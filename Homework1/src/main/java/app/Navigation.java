package app;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Log4j2
public class Navigation {
    @GetMapping("navigation")
    public String moneyPut() {
        return "navigation";
    }

    @PostMapping("navigation")

    public String navigation(InputForm form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        if(form.getCheckPage() == 0) return "redirect:personalInformation";
        if(form.getCheckPage() == 1) return "redirect:customCreate";
        if(form.getCheckPage() == 2) return "redirect:createNewAccount";
        if(form.getCheckPage() == 3) return "redirect:list";
        if(form.getCheckPage() == 4) return "redirect:putMoney";
        if(form.getCheckPage() == 5) return "redirect:withdrawMoney";
        if(form.getCheckPage() == 6) return "redirect:transferMoney";
        if(form.getCheckPage() == 7) return "redirect:balance";
        return "redirect:navigation";
    }
}
