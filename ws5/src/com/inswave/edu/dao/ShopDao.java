package com.inswave.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("shopDao")
public class ShopDao {
	@Autowired
	private SqlSession sqlSession;

	private static final String NS = "com.inswave.edu.dao.ShopDao.";
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
// shop detail
	public int insertShop(Map param) throws Exception {
		return sqlSession.insert(NS + "insertShop", param);
	}

	public int updateShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NS + "updateShop", param);
	}

	public int deleteShop(Map param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NS + "deleteShop", param);
	}

	public List selectShopDetail() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + "selectShopDetail");
	}
// shop list
	public int insertShopList(Map param) throws Exception {
		return sqlSession.insert(NS + "insertShopList", param);
	}

	public int updateShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NS + "updateShopList", param);
	}

	public int deleteShopList(Map param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NS + "deleteShopList", param);
	}

	public List selectShopList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + "selectShopList");
	}
	public List selectShopDetailSize() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + "selectShopDetailSize");
	}
	public List selectShop(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + "selectShop", id);
	}
}
