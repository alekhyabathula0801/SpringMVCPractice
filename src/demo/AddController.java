package demo;

import demo.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

    AddService addService;

    public AddService getAddService() {
        return addService;
    }

    @Autowired
    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    @RequestMapping()
    public String indexPage() {
        return "index.jsp";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("number1") int number1, @RequestParam("number2") int number2) {
        int result = addService.add(number1,number2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display.jsp");
        modelAndView.addObject("result",result);
        return modelAndView;
    }

}
