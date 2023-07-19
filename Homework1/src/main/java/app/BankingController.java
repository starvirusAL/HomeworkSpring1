package app;

import app.custom.FormatedPersonal;
import app.custom.TableHeader;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class BankingController {

    CustomerController cc = new CustomerController();
    AccountController ac = new AccountController();

    @GetMapping("customCreate")
    public String customCreate() {
        return "customCreate";
    }

    @PostMapping("customCreate")

    public String customCreate(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        cc.createNewCustomer(form.getName(), form.getEmail(), form.getAge());
        return "redirect:navigation";
    }
    @GetMapping("listCreate")
    @ResponseBody
    public String listShow() {
        return cc.getAllCustomer().toString();
    }

    @GetMapping("putMoney")
    public String moneyPut() {
        return "putMoney";
    }

    @PostMapping("putMoney")
    public String moneyPut(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        ac.replenishTheBalance(cc.daoListC.getOne(form.getIdCustomer()).getAccountList(form.getIdAccount()), form.getValueM());
        return "redirect:navigation";
    }
    @GetMapping("transferMoney")
    public String transferMoney() {
        return "transferMoney";
    }

    @PostMapping("transferMoney")
    public String transferMoney(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        ac.transferMoney(cc.daoListC.getOne(form.getIdCustomer()).getAccountList(form.getIdAccount()),cc.daoListC.getOne(form.getIdCustomer2()).getAccountList(form.getIdAccount2()), form.getValueM());
        return "redirect:navigation";
    }
    @GetMapping("createNewAccount")
    public String createNewAccount() {
        return "createNewAccount";
    }

    @PostMapping("createNewAccount")
    public String createNewAccount(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        cc.daoListC.getOne(form.getIdCustomer()).addAccounts(new Account(form.getInputCurrency()));
        return "redirect:navigation";
    }
    @GetMapping("personalInformation")
    public String personal1() {
        return "personalInformation";
    }

    @PostMapping("personalInformation")
    @ResponseBody
    public String personal1(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
      Customer customer =  cc.daoListC.getOne(form.getIdCustomer());
        return FormatedPersonal.formated(customer.getId(), customer.getName(),customer.getEmail(),customer.getAge(),customer.getAccounts());
    }
    @GetMapping("withdrawMoney")
    public String withdrawMoney() {
        return "withdrawMoney";
    }

    @PostMapping("withdrawMoney")
    public String withdrawMoney(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        ac.withdrawBalance(cc.daoListC.getOne(form.getIdCustomer()).getAccountList(form.getIdAccount()), form.getValueM());
        return "redirect:navigation";
    }

    private Map<String, Object> data() {
        TableHeader th = new TableHeader("Id", "Name", "E-mail", "Account");
        List<Customer> tb = cc.daoListC.findAll();
        return Map.of(
                "thead", th,
                "tbody", tb
        );
    }
    @GetMapping("list")
    public String javaBooks1(Model model) {
        data().forEach((k, v) -> model.addAttribute(k, v));
        return "listCustomer";
    }
    @GetMapping("balance")
    public String balance() {
        return "balance";
    }

    @PostMapping("balance")
    @ResponseBody
    public String balance(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();

        return "Money on your balance:" + cc.daoListC.getOne(form.idCustomer).getAccountList(form.idAccount).getBalance().toString();
    }
    @GetMapping("removeCustomer")
    public String removeCustomer() {
        return "removeCustomer";
    }

    @PostMapping("removeCustomer")

    public String removeCustomer(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
      cc.deleteCustomer(form.getIdCustomer())  ;
         return "redirect:navigation";
    }
    @GetMapping("removeAccount")
    public String removeAccount() {
        return "removeAccount";
    }

    @PostMapping("removeAccount")

    public String removeAccount(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        Customer customer = cc.daoListC.getOne(form.getIdCustomer());
        cc.deleteAccount(customer, form.getIdAccount());
        return "redirect:navigation";
    }
}
