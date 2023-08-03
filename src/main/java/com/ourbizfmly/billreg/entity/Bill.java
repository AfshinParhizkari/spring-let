package com.ourbizfmly.billreg.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_bill_registration", uniqueConstraints = {@UniqueConstraint(columnNames = {"billregisteration_id"}),@UniqueConstraint(columnNames = {"billregisteration_id"})})
public class Bill implements Serializable {
    private static final long serialVersionUID = -5794059306446703568L;

    @Id
	@Column(name = "billregisteration_id")
    private String billregisteration_id;
	public String getBillregisteration_id() {
		return this.billregisteration_id;
	}
	public void setBillregisteration_id(String billregisteration_id) {
		this.billregisteration_id = billregisteration_id;
	}

    @Column(name = "billing_id", length = 20, nullable = false) //شناسه قبض
    private String billing_id;
	public String getBilling_id() {
		return this.billing_id;
	}
	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}

    @Column(name = "body_num", length = 20, nullable = false) // شماره بدنه کنتور
    private String body_num;
	public String getBody_num() {
		return this.body_num;
	}
	public void setBody_num(String body_num) {
		this.body_num = body_num;
	}

    @Column(name = "file_num", length = 20, nullable = false) //شماره پرونده
    private String file_num;
	public String getFile_num() {
		return this.file_num;
	}
	public void setFile_num(String file_num) {
		this.file_num = file_num;
	}

    @Column(name = "computer_num", length = 20, nullable = false) //شماره رایانه
    private String computer_num;
	public String getComputer_num() {
		return this.computer_num;
	}
	public void setComputer_num(String computer_num) {
		this.computer_num = computer_num;
	}

    @Column(name = "consume_type", length = 20, nullable = false) //نوع مصرف
    private String consume_type;
	public String getConsume_type() {
		return this.consume_type;
	}
	public void setConsume_type(String consume_type) {
		this.consume_type = consume_type;
	}

    @Column(name = "install_date")
    private Date install_date;
	public Date getInstall_date() {
		return this.install_date;
	}
	public void setInstall_date(Date install_date) {
		this.install_date = install_date;
	}

    @Column(name = "change_date")
    private Date change_date;
	public Date getChange_date() {
		return this.change_date;
	}
	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}
    
    @Column(name = "belong_to", length = 20, nullable = false) //کلید خارجی به جدول اشخاص
    private String belong_to;
	public String getBelong_to() {
		return this.belong_to;
	}

	public void setBelong_to(String belong_to) {
		this.belong_to = belong_to;
	}
    @Column(name = "bill_name", length = 20, nullable = false) //نام مشترک روی قبض
    private String bill_name;
	public String getBill_name() {
		return this.bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}
    
    @Column(name = "user_name", length = 20, nullable = false) //نام سیستم
    private String user_name;
	public String getUser_name‌‌() {
		return this.user_name;
	}
	public void setUser_name‌‌(String user_name) {
		this.user_name = user_name;
	}
    
    @Column(name = "description", length = 20, nullable = false) //شرح
    private String Description;
	public String getDescription() {
		return this.Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}


	@Override
	public String toString() {
		return "Bill{" +
				"billregisteration_id='" + billregisteration_id + '\'' +
				", billing_id='" + billing_id + '\'' +
				", body_num='" + body_num + '\'' +
				", file_num='" + file_num + '\'' +
				", computer_num='" + computer_num + '\'' +
				", consume_type='" + consume_type + '\'' +
				", install_date=" + install_date +
				", change_date=" + change_date +
				", belong_to='" + belong_to + '\'' +
				", bill_name='" + bill_name + '\'' +
				", user_name='" + user_name + '\'' +
				", Description='" + Description + '\'' +
				'}';
	}
}