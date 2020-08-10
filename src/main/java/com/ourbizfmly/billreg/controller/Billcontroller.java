package com.ourbizfmly.billreg.controller;

import com.ourbizfmly.billreg.dao.Billdao;
import com.ourbizfmly.billreg.entity.BillModel;


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
public class Billcontroller  {
    @Autowired
    private Billdao billdao;

    @Autowired
    private BillModel billmodel;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
    }

    @RequestMapping("/billsave")
    public String UpdateInfo() {
        try {
            //BillModel bill;

            billdao.UpdateInfo(billmodel);
            return "index";
        }

        catch (Exception e){
            e.printStackTrace();
            return "erro";
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