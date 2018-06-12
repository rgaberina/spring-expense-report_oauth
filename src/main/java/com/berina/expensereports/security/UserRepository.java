/**
 * 
 */
package com.berina.expensereports.security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berina
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
