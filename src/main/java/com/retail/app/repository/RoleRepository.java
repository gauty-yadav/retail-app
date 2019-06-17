package com.retail.app.repository;

import com.retail.app.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(value = "SELECT * FROM Roles where name IN (:roles)", nativeQuery = true)
    Set<Role> find(@Param("roles") List<String> roles);
}