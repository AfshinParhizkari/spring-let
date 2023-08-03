package com.ourbizfmly.billreg.controller;

import com.ourbizfmly.billreg.dao.Billrep;
import com.ourbizfmly.billreg.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
public class Billcontroller  {

    @Autowired private Billrep dao;

    @PostMapping("/billsave")
    public String UpdateInfo(Bill bill) {
        try {
            bill=dao.save(bill);
            return bill.getBillregisteration_id();
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
  
    @GetMapping("/getbill")
    public String get(String billregisteration_id) {
        try {
            return dao.findById(billregisteration_id).stream().findFirst().orElse(null).toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}