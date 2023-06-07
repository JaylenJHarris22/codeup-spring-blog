package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Friend findFriendByName(String name);
}
