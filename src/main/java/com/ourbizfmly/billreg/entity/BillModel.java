com.ourbizfmly.billreg.billregistration.controller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_bill_registeration", uniqueConstraints = {@UniqueConstraint(columnNames = {"billregisteration_id"}),@UniqueConstraint(columnNames = {"billing_id"})})
public class BillModel implements Serializable {
    private static final long serialVersionUID = -5794059306446703568L;

    @Id
    @Column(name = "billregisteration_id", length = 50, nullable = false)
    private String billregisteration_id;
    @Column(name = "billing_id", length = 20, nullable = false) //شناسه قبض
    private String billing_id;

    @Column(name = "body_num", length = 20, nullable = false) // شماره بدنه کنتور
    private String body_num;

    @Column(name = "file_num", length = 20, nullable = false) //شماره پرونده
    private String file_num;

    @Column(name = "computer_num", length = 20, nullable = false) //شماره رایانه
    private String computer_num;

    @Column(name = "consume_type", length = 20, nullable = false) //نوع مصرف
    private String consume_type;

    @Column(name = "install_date")
    private Date install_date;

    @Column(name = "change_date")
    private Date change_date;
    
    @Column(name = "belong_to", length = 20, nullable = false) //کلید خارجی به جدول اشخاص
    private String belong_to;
    @Column(name = "bill_name‌‌", length = 20, nullable = false) //نام مشترک روی قبض
    private String bill_name‌‌;
    @Column(name = "user_name‌‌", length = 20, nullable = false) //نام سیستم
    private String user_name‌‌;
    @Column(name = "Description", length = 20, nullable = false) //شرح
    private String Description;

}