package com.example.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.dao.UserAdminDao;
import com.example.domain.Role;
import com.example.domain.UserAdmin;

@Service("userDetailsService")
public class UserAdminService implements UserDetailsService {
	
	@Autowired
	private UserAdminDao userAdminDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserAdmin userAdmin = userAdminDao.findByUsername(username);
		
		if(userAdmin == null) {
			throw new UsernameNotFoundException(username);
		}
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Role role : userAdmin.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new User(userAdmin.getUsername(), userAdmin.getPassword(), roles);
		
	}

}
