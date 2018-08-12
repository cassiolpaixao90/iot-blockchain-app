package br.com.cassiopaixao.blockchain.iot.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cassiopaixao.blockchain.iot.dtos.UserDTO;
import br.com.cassiopaixao.blockchain.iot.models.Users;
import br.com.cassiopaixao.blockchain.iot.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Users> userOptional = userRepository.findByEmail(email);
		Users user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User and/or inválid password!"));
		return new UserDTO(user, getPermissoes(user));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Users users) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		users.getPermissions()
				.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}