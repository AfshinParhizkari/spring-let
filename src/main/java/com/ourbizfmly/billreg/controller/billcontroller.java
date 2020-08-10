package com.ourbizfmly.billreg.billregistration.controller;

import com.ourFamilyBusiness.bill.dao.UserAdminDAO;
import com.ourFamilyBusiness.bill.utils.UserRole;
import com.ourFamilyBusiness.bill.dao.impl.UserRoleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@Transactional
@EnableWebMvc
public class AppController extends BaseController {
    @Autowired
    private UserRoleDAOImpl userRoleDAOImpl;

    @Autowired
    private UserAdminDAO userAdminDAO;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
    }

    @RequestMapping("/403")
    public String accessDenied() {
        try {
            return "/403";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/")
    public String home() {
        try {
            userRoleDAOImpl.save();
            userAdminDAO.saveUser("5900004120", "09191942264", "10001", "123456789", UserRole.ADMIN.text());
            userAdminDAO.saveUser("0010498842", "09127034625", "10002", "123456789", UserRole.COMMON.text());
            return "index";
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/login")
    public String login() {
        try {
            return "login";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/underConstruction")
    public String underConstruction() {
        try {
            return "underConstruction";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }
}
