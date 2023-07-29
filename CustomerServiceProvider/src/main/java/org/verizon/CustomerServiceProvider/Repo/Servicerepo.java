package org.verizon.CustomerServiceProvider.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verizon.CustomerServiceProvider.Model.Servicemodel;

@Repository
public interface Servicerepo extends JpaRepository<Servicemodel,Integer>{

}
