package lv.sample.userAccountApi.acounts.repository;

import lv.sample.userAccountApi.acounts.model.UserAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountsRepository extends JpaRepository<UserAccounts, Long> {

}
