package com.inswave.edu.service;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
public interface ShopeService{
	//shop detail
	public int insertShop(Map param) throws Exception;
	public int updateShop(Map param) throws Exception;
	public int deleteShop(Map param) throws Exception;
	public int saveShop(Map param) throws Exception;
	public JSONObject selectShopDetail() throws Exception;
		// size
		public JSONObject selectShopDetailSize() throws Exception;
	//shop list
	public int insertShopList(Map param) throws Exception;
	public int updateShopList(Map param) throws Exception;
	public int deleteShopList(Map param) throws Exception;
	public int saveShopList(Map param) throws Exception;
	public JSONObject selectShopList() throws Exception;
	public JSONObject selectShop(String id) throws Exception;
}
