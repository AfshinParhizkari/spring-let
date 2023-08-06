package com.afshin.controller;
/**
 * @Project DDD
 * @Author Afshin Parhizkari
 * @Date 2021 - 09 - 25
 * @Time 11:43 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Application Layer
 */

import com.afshin.logger.MyLogger;
import com.afshin.service.BillSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController//Application Layer
@RequestMapping("/")
public class BillRst {
    @Autowired private BillSrv srv;
    @Autowired private MyLogger logger;

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String findAll() throws Exception {
            return srv.findAll().toString();
    }
  
    @GetMapping(value = "/find/{billregisteration_id}")
    @ResponseStatus(HttpStatus.OK)
    public String find(@PathVariable String billregisteration_id) throws Exception{
            return srv.find(billregisteration_id);
    }

	@GetMapping(value = "/get")
	@ResponseStatus(HttpStatus.OK)
	public String get(@RequestParam(defaultValue = "1") String billregisteration_id) throws Exception{
            return srv.find(billregisteration_id);
    }
}