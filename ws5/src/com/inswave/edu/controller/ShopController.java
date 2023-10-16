package com.inswave.edu.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inswave.edu.service.ShopeService;
//import com.inswave.edu.util.EduUtils;
//import com.inswave.edu.util.FileHandler;
import com.inswave.edu.util.EduUtils;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@Resource(name = "shopService")
	private ShopeService shopService;
	private final String ROW_INSERT= "insert";
	private final String ROW_DELETE= "delete";
	private final String ROW_UPDATE= "update";
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public Map selectListShopList(@RequestBody (required = false )Map param) throws Exception {
		Map resObj = new HashMap();
		try {
			resObj.put("dl_Shop_List", shopService.selectShopList().get("shop"));
		} catch (Exception ex) {
			ex.printStackTrace();
			resObj = EduUtils.setErrorMessage(resObj);
		}
		return resObj;
	}
	@RequestMapping(value = "/list/{id}.do", method = RequestMethod.GET)
	public Map selectShop(@PathVariable String id) throws Exception {
	    Map resObj = new HashMap();
	    try {
	        // Xử lý dữ liệu ở đây dựa trên tham số 'id' từ URL.
	    	resObj.put("dl_Shop_List", shopService.selectShop(id).get("shop"));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        resObj = EduUtils.setErrorMessage(resObj);
	    }
	    return resObj;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	public Map saveShopList(@RequestBody Map param) throws Exception {
		Map resObj = new HashMap();
		Map result = new HashMap();
		Map modParam = new HashMap<String, List>();
		List insert = new ArrayList<Map>();
		List update = new ArrayList<Map>();
		List delete = new ArrayList<Map>();
		List saveList = null;
		System.out.print(param);
		try {
			saveList= (List) param.get("dl_Shop_List");
			for (int i = 0; i < saveList.size(); i++) {
				
				Map rowData = (Map) saveList.get(i);
				String rowStatus = (String) rowData.get("rowStatus");
				
				if( rowStatus.equalsIgnoreCase("C")) {
					insert.add(rowData);
				} else if( rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					delete.add(rowData);
				} else if ( rowStatus.equalsIgnoreCase("U") ) {
					update.add(rowData);
				}
			}

			
			modParam.put(ROW_INSERT, insert);
			modParam.put(ROW_UPDATE, update);
			modParam.put(ROW_DELETE, delete);
			
			resObj.put("update", update);
			int updateCount = 0;
			for(int j =0; j < update.size() ; j ++) {
				Map mapUpdate = (Map) update.get(j);
				System.out.println("##########"+ mapUpdate);
				updateCount += shopService.updateShopList(mapUpdate);
				//System.out.println()
			}
			
			
			if( delete.size() > 0)
				resObj.put("deleteShopList", shopService.deleteShopList(modParam));
			
			if( update.size() > 0)
				resObj.put("updateShopList", updateCount);
			
		
			if( insert.size() > 0)
				resObj.put("insertShopList", shopService.insertShopList(modParam));
		
			
		} catch (Exception e) {
			e.printStackTrace();
			resObj.put("msg", e.getMessage());
		}
		return resObj;
	}


// shop detail
	//get all
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public Map selectShopDetail(@RequestBody (required = false )Map param) throws Exception {
		Map resObj = new HashMap();
		Map resData1 = null;
		try {
			resObj.put("dl_Shoe_Shop", shopService.selectShopDetail().get("shop"));
		} catch (Exception ex) {
			ex.printStackTrace();
			resObj = EduUtils.setErrorMessage(resObj);
		}
		return resObj;
	}
	//get size
	@RequestMapping(value = "/detail/size.do", method = RequestMethod.GET)
	public Map selectShopDetailSize(@RequestBody (required = false )Map param) throws Exception {
		Map resObj = new HashMap();
		Map resData1 = null;
		try {
			resObj.put("dl_CBX_Size", shopService.selectShopDetailSize().get("shop"));
		} catch (Exception ex) {
			ex.printStackTrace();
			resObj = EduUtils.setErrorMessage(resObj);
		}
		return resObj;
	}
	//post detail
	@RequestMapping(value = "/detail.do", method = RequestMethod.POST)
	public Map saveShopDetail(@RequestBody Map param) throws Exception {
		Map resObj = new HashMap();
		Map result = new HashMap();
		Map modParam = new HashMap<String, List>();
		List insert = new ArrayList<Map>();
		List update = new ArrayList<Map>();
		List delete = new ArrayList<Map>();
		List saveList = null;
		System.out.print(param);
		try {
			saveList= (List) param.get("dl_Shoe_Shop");
			
			for (int i = 0; i < saveList.size(); i++) {
				
				Map rowData = (Map) saveList.get(i);
				String rowStatus = (String) rowData.get("rowStatus");
				
				if( rowStatus.equalsIgnoreCase("C")) {
					insert.add(rowData);
				} else if( rowStatus.equalsIgnoreCase("D") || rowStatus.equalsIgnoreCase("E")) {
					delete.add(rowData);
				} else if ( rowStatus.equalsIgnoreCase("U") ) {
					update.add(rowData);
				}
			}

			
			modParam.put(ROW_INSERT, insert);
			modParam.put(ROW_UPDATE, update);
			modParam.put(ROW_DELETE, delete);
			
			
			// delete
			if( delete.size() > 0)
				resObj.put("deleteShop", shopService.deleteShop(modParam));
			
			//update
			int updateCount = 0;
			for(int j =0; j < update.size() ; j ++) {
				Map mapUpdate = (Map) update.get(j);
				System.out.println("##########"+ mapUpdate);
				updateCount += shopService.updateShop(mapUpdate);
				//System.out.println()
			}
			
			if( update.size() > 0)
				resObj.put("updateShop", updateCount);
			//insert
			int insertCount = 0;
			for(int j =0; j < insert.size() ; j ++) {
				Map mapInsert = (Map) insert.get(j);
				System.out.println("##########"+ mapInsert);
				updateCount += shopService.insertShop(mapInsert);
				//System.out.println()
			}
			if( insert.size() > 0)
				resObj.put("insertShop", shopService.insertShop(modParam));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resObj.put("msg", e.getMessage());
		}
		return resObj;
	}
}
