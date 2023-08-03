package com.ourbizfmly.billreg.dao;

import com.ourbizfmly.billreg.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Billrep  extends JpaRepository<Bill, String> {
}
