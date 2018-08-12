package br.com.cassiopaixao.blockchain.iot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cassiopaixao.blockchain.iot.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	public Optional<Users> findByEmail(String email);
	
}
