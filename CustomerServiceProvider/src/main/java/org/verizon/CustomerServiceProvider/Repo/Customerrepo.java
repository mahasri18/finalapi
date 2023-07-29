package org.verizon.CustomerServiceProvider.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verizon.CustomerServiceProvider.Model.Customermodel;

@Repository
public interface Customerrepo extends JpaRepository<Customermodel,Integer> {

}
