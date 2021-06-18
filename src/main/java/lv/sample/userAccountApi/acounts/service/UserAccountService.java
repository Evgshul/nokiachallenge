package lv.sample.userAccountApi.acounts.service;

import lv.sample.userAccountApi.acounts.model.UserAccounts;
import lv.sample.userAccountApi.acounts.repository.UserAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountsRepository userAccountsRepository;

    @Autowired
    public UserAccountService(UserAccountsRepository userAccountsRepository) {
        this.userAccountsRepository = userAccountsRepository;
    }

    public void addNewUserAccount(UserAccounts userAccounts) {
        userAccountsRepository.saveAndFlush(userAccounts);
    }

    public List<UserAccounts> getAllUserAccounts() {

        return userAccountsRepository.findAll();
    }

    public Optional<UserAccounts> getUserAccountById(Long userAccountId) {
        boolean exist = userAccountsRepository.existsById(userAccountId);
        if (!exist) {
            throw new IllegalStateException(
                    "user account with this ID " + userAccountId + " does not exist"
            );
        }
        return userAccountsRepository.findById(userAccountId);
    }

    public void deleteUserAccount(Long id) {
        if (!userAccountsRepository.existsById(id)) {
            throw new IllegalStateException(
                    "ID " + id + " does not exist"
            );
        }
        userAccountsRepository.deleteById(id);
    }

    @Transactional
    public void updateUserAccount(Long id,
                                  UserAccounts userAccount) {

        UserAccounts existAccount = userAccountsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "User Account " + id + "does not exist"
                ));
        existAccount.setId(id);
        if (userAccount.getName() != null && userAccount.getName().length() > 0 &&
                !Objects.equals(existAccount.getName(), userAccount.getName())) {
            existAccount.setName(userAccount.getName());
        }
        if (userAccount.getPhone() != null && userAccount.getPhone().length() > 0 &&
                !Objects.equals(existAccount.getPhone(), userAccount.getPhone())) {
            existAccount.setName(userAccount.getPhone());
        }
        if (userAccount.getEmail() != null && userAccount.getEmail().length() > 0 &&
                !Objects.equals(existAccount.getEmail(), userAccount.getEmail())) {
            existAccount.setName(userAccount.getEmail());
        }
        if (userAccount.getAddress() != null && userAccount.getAddress().length() > 0 &&
                !Objects.equals(existAccount.getEmail(), userAccount.getAddress())) {
            existAccount.setName(userAccount.getAddress());
        }
        if (userAccount.getDepartment() != null && userAccount.getDepartment().length() > 0 &&
                !Objects.equals(existAccount.getDepartment(), userAccount.getDepartment())) {
            existAccount.setName(userAccount.getDepartment());
        }
    }
}
