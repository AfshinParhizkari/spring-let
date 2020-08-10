package com.ourbizfmly.billreg.billregistration.controller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_bill_registeration", uniqueConstraints = {@UniqueConstraint(columnNames = {"billregisteration_id"}),@UniqueConstraint(columnNames = {"billing_id"})})
public class Billdao implements Serializable {
    private static final long serialVersionUID = -5794059306446703568L;
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

@Override
public void UpdateInfo(BillModel billmodel) {
    try {
        this.sessionFactory.getCurrentSession().merge(billmodel);
    }
    catch (Exception e) {
        System.out.println("Exception: " + e.getMessage() + " happened!");
        e.printStackTrace();
    }
}


@Override
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