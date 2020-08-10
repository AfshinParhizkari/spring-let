package com.ourbizfmly.billreg.billregistration.controller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_bill_registeration", uniqueConstraints = {@UniqueConstraint(columnNames = {"billregisteration_id"}),@UniqueConstraint(columnNames = {"billing_id"})})
public class Billdao implements Serializable {
    private static final long serialVersionUID = -5794059306446703568L;

}