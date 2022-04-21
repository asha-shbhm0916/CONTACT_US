package com.Contact_us.CONTACT_US.Controller;




import com.Contact_us.CONTACT_US.Model.EmailRequest;
import com.Contact_us.CONTACT_US.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private EmailService emailService;
    @GetMapping("/home")
    public String welcome()
    {
        return "home";
    }

    @PostMapping("/home/save")
    public String save(@RequestParam("Name") String name,
                       @RequestParam("Email") String email,
                       @RequestParam("Contact") Integer number,
                       @RequestParam("message") String message){

     String content = "Email "+email+" \t"+
                       "number "+number+"\t"+
                       message;
     emailService.sendmail("shubhamdubey130012@gmail.com",name,content);
     return "redirect:/home";
    }

}
