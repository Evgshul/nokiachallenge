package lv.inteview.nokiachallenge.acounts.repository;

import lv.inteview.nokiachallenge.acounts.model.UserAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountsRepository extends JpaRepository<UserAccounts, Long> {

//    @Query("SELECT u from UserAccounts u where u.email = ?1")
//    Optional<UserAccounts> findUserAccountsByEmail(String email);

}
