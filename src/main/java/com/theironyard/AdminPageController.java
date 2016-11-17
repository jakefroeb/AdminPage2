package com.theironyard;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jakefroeb on 11/11/16.
 */
@Controller
public class AdminPageController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String get(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        User[] users = (User[]) session.getAttribute("users");
        Review[] reviews = (Review[]) session.getAttribute("reviews");
        if(user==null){
            return "home";
        }
        model.addAttribute("reviews",reviews);
        model.addAttribute("users",users);
        model.addAttribute("user",user);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String email,String password){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/adminLogin?email="+email+"&password="+password,User.class);
        if(user==null){
            return"redirect:/";
        }else{
            session.setAttribute("user", user);
        }
        return"redirect:/";
    }
    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String getUsers(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject("http://localhost:8080/users",User[].class);
        if(users == null){
            return "redirect:/";
        }else{
            session.setAttribute("users", users);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-user", method = RequestMethod.POST)
    public String deleteUser(int id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/delete-user?id="+id);
        return "redirect:/";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public String getReviews(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        Review[] reviews = restTemplate.getForObject("http://localhost:8080/reviews",Review[].class);
        if(reviews == null){
            return "redirect:/";
        }else{
            session.setAttribute("reviews", reviews);
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/approve-review", method = RequestMethod.POST)
    public String approveReview(int id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Review> entity = restTemplate.postForEntity("http://localhost:8080/approve-review?id="+id,null,Review.class);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-review", method = RequestMethod.POST)
    public String deleteReview(int id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/delete-review?id="+id);
        return "redirect:/";
    }


}
