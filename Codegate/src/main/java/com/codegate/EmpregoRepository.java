package com.codegate;

import org.springframework.data.repository.CrudRepository;

public interface EmpregoRepository extends CrudRepository<Emprego, Long>{
	//Comunicador direto com o banco de dados
}
