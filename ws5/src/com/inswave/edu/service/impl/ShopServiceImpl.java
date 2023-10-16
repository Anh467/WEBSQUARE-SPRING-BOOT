package com.inswave.edu.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.inswave.edu.dao.ShopDao;
//import com.inswave.edu.dao.EduDao;
import com.inswave.edu.service.ShopeService;
//import com.inswave.edu.util.EduUtils;
@Service("shopService")
public class ShopServiceImpl implements ShopeService{
	@Resource(name="shopDao")
	private ShopDao shopDao;
	
	public int insertShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.insertShop(param); 
	}

	public int updateShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.updateShop(param);
	}

	public int deleteShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.deleteShop(param);
	}

	public JSONObject selectShopDetail() throws Exception {
		// TODO Auto-generated method stub
		JSONObject resObj = new JSONObject();
		 resObj.put("shop", shopDao.selectShopDetail());
		 return resObj;
	}

	public int saveShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.insertShopList(param); 
	}

	public int updateShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.updateShopList(param);
	}

	public int deleteShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.deleteShopList(param);
	}

	public int saveShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public JSONObject selectShopList() throws Exception {
		// TODO Auto-generated method stub
		JSONObject resObj = new JSONObject();
		 resObj.put("shop", shopDao.selectShopList());
		 return resObj;
	}

	public JSONObject selectShopDetailSize() throws Exception {
		// TODO Auto-generated method stub
		JSONObject resObj = new JSONObject();
		 resObj.put("shop", shopDao.selectShopDetailSize());
		 return resObj;
	}

	public JSONObject selectShop(String id) throws Exception {
		// TODO Auto-generated method stub
		JSONObject resObj = new JSONObject();
		 resObj.put("shop", shopDao.selectShop(id));
		return resObj;
	}

}
