package com.ourbizfmly.billreg.dao;

import com.ourbizfmly.billreg.entity.BillModel;
import com.ourbizfmly.billreg.controller.Billcontroller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name = "tb_bill_registeration", uniqueConstraints = {@UniqueConstraint(columnNames = {"billregisteration_id"}),@UniqueConstraint(columnNames = {"billing_id"})})
public class Billdao implements Serializable {
   private static final long serialVersionUID = -5794059306446703568L;
    
   @Autowired
    private SessionFactory sessionFactory;

//@Override
public void UpdateInfo(BillModel billmodel) {
    try {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BillModel.class);
      
        this.sessionFactory.getCurrentSession().merge(billmodel);
    }
    catch (Exception e) {
        System.out.println("Exception: " + e.getMessage() + " happened!");
        e.printStackTrace();
    }
}


//@Override
public BillModel findById(String billregisteration_id) {
    try {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BillModel.class);
        criteria.add(Restrictions.eq("billregisteration_id", billregisteration_id));
        return (BillModel) criteria.uniqueResult();
    }
    catch (Exception e) {
        System.out.println("Exception: " + e.getMessage() + " happened!");
        e.printStackTrace();
    }
    return null;
}
}