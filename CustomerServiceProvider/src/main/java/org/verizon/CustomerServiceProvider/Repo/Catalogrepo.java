package org.verizon.CustomerServiceProvider.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verizon.CustomerServiceProvider.Model.Catalogmodel;

@Repository
public interface Catalogrepo extends  JpaRepository<Catalogmodel,Integer> {


}
