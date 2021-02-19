package br.com.zup.controle_vacina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.controle_vacina.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}
