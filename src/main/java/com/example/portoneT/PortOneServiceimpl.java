package com.example.portoneT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortOneServiceimpl implements PortOneService{

	@Autowired
	PortOneDao dao;
	
	@Override
	public String insert(PortOneVO vo) {
		
	try {
		dao.insert(vo);
		System.out.println("insert(PortOneVO vo):" + vo.getMpaynum());
		return "/PortOneT/result?mpaynum="+vo.getMpaynum();	
	}catch(Exception e) {
		return "/PortOneT/failure";
	}
  }

	@Override
	public 	PortOneVO edit(PortOneVO vo){
		return dao.edit(vo);
	}
}