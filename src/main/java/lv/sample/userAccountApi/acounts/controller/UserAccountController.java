package lv.sample.userAccountApi.acounts.controller;

import lv.sample.userAccountApi.acounts.model.UserAccounts;
import lv.sample.userAccountApi.acounts.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintDeclarationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/userAccounts")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public List<UserAccounts> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createNewUserAccount(@Valid @RequestBody UserAccounts userAccounts) throws ConstraintDeclarationException {
        userAccountService.addNewUserAccount(userAccounts);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("message", "User Account create success!!!");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserAccounts>> getUserAccountById(@PathVariable(value = "id") Long id) {
        Optional<UserAccounts> userAccounts = userAccountService.getUserAccountById(id);
        return ResponseEntity.ok(userAccounts);
    }

    @DeleteMapping("/userAccount/{id}")
    public Map<String, Boolean> deleteUserAccount(@PathVariable(value = "id") Long id) {
        userAccountService.deleteUserAccount(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("user Account " + id + " deleted ", Boolean.TRUE);
        return response;
    }

    @PutMapping("/updateUserAccount/{id}")
    public ResponseEntity<Object> updateUserAccount(@PathVariable(value = "id") Long id,
                                                    @Valid @RequestBody UserAccounts userAccount) {
        userAccountService.updateUserAccount(id, userAccount);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("message", "User Account with id " + id + " updated successful !!!");
        return ResponseEntity.ok(response);
    }
}
