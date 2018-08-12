package br.com.cassiopaixao.blockchain.iot.dtos;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.cassiopaixao.blockchain.iot.models.Users;

public class UserDTO extends User {

	private static final long serialVersionUID = 1L;
	private Users users;

	public UserDTO(Users users, Collection<? extends GrantedAuthority> authorities) {
		super(users.getEmail(), users.getPassword(), authorities);
		this.users = users;
	}

	public Users getUsuario() {
		return users;
	}

}
