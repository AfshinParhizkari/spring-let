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

import com.afshin.repository.BillDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//Application Layer
@RequestMapping("/")
public class BillRst {
    @Autowired private BillDao dao;

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String findAll() throws Exception {
        return dao.findAll().toString();
    }
  
    @GetMapping(value = "/find/{billregisteration_id}")
    @ResponseStatus(HttpStatus.OK)
    public String find(@PathVariable String billregisteration_id) throws Exception {
        return dao.findById(billregisteration_id).toString();
    }

	@GetMapping(value = "/get")
	@ResponseStatus(HttpStatus.OK)
	public String get(@RequestParam(defaultValue = "1") String billregisteration_id) throws Exception {
		return dao.findById(billregisteration_id).toString();
	}
}