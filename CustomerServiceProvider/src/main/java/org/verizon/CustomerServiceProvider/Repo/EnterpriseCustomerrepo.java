package org.verizon.CustomerServiceProvider.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verizon.CustomerServiceProvider.Model.EnterpriseCustmodel;

@Repository
public interface EnterpriseCustomerrepo extends JpaRepository<EnterpriseCustmodel,Integer> {

}
