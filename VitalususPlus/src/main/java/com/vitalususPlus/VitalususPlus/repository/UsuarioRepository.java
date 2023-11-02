package com.vitalususPlus.VitalususPlus.repository;

import com.vitalususPlus.VitalususPlus.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,String> {
    @Query(value="SELECT * FROM usuario c WHERE c.email=? AND c.senha=?", nativeQuery = true)
    Usuario findByLogin(String email, String senha);
}
