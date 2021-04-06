package aitsi.store.service;

import aitsi.store.entity.User;

public interface UserService {
    User findByEmail(String email);

    User saveUser(User user);
}
