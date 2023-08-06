package com.afshin.service;

import com.afshin.logger.MyLogger;
import com.afshin.repository.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillSrv {
    @Autowired private BillDao dao;
    @Autowired private MyLogger logger;

    public String findAll() throws Exception {
        try {
            logger.eventLogger.info("start fetch all bills");
            return dao.findAll().toString();
        }catch (Exception ex){
            logger.eventLogger.error("error"+ ex.getMessage());
            logger.logStackTrace(ex);
            return ex.getMessage();
        }
    }

    public String find(String billregisteration_id) {
        try {
            logger.eventLogger.info("start fetch a bill");
            return dao.findById(billregisteration_id).toString();
        }catch (Exception ex){
            logger.eventLogger.error("error"+ ex.getMessage());
            logger.logStackTrace(ex);
            return ex.getMessage();
        }
    }
}