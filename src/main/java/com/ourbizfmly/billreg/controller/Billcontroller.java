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
public class Billcontroller extends BaseController {
    @Autowired
    private Billdao billdao;

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

    @RequestMapping("/billsave")
    public String save() {
        try {
            BillModel bill;

            billdao.UpdateInfo(bill);
            return "index";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
  
    @RequestMapping("/getbill")
    public String get() {
        try {
            return "underConstruction";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }
}