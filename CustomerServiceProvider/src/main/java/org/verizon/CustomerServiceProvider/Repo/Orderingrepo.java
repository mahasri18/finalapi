package org.verizon.CustomerServiceProvider.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verizon.CustomerServiceProvider.Model.Orderingmodel;

@Repository
public interface Orderingrepo extends JpaRepository<Orderingmodel,Integer>{

}
