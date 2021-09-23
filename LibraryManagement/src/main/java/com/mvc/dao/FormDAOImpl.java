package com.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.entity.User;

@Transactional
@Repository
public class FormDAOImpl implements FormDAO{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean isUserExist(User user) {
		String query="select count(*) from Form f where f.username=:myUsername and f.password=:myPassword";
		String[] paramName=new String[] {"myUsername", "myPassword"};
		String[] value=new String[] {user.getUsername(), user.getPassword()};
		List<?> result = hibernateTemplate.findByNamedParam(query, paramName, value);
		Long count=(Long) result.get(0);
		if(count==0)
		{
			return false;
		}
		return true;
	}

}
