package com.parikshaportal;

/*import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.parikshaportal.model.Role;
import com.parikshaportal.model.User;
import com.parikshaportal.model.UserRole;
import com.parikshaportal.service.UserService;
*/
@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan({"controller", "services", "configure"})
public class ParikshaportalApplication implements CommandLineRunner{
	/*
	 * @Autowired private UserService userService;
	 * 
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	public static void main(String[] args) {
		SpringApplication.run(ParikshaportalApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		 
		/*
		 * User user=new User(); user.setUsername("archana290296");
		 * user.setPassword(this.bCryptPasswordEncoder.encode( "290296"));
		 * user.setFirstName("Archana"); user.setLastName("Khandekar");
		 * user.setEmailId("archana290296@gmail.com"); user.setPhone("9657165376");
		 * user.setProfile("default.png");
		 * 
		 * Role role1=new Role(); role1.setRoleid(1L); role1.setRoleName("ADMIN");
		 * 
		 * Set<UserRole> userRoleSet=new HashSet<>(); UserRole userRoles=new UserRole();
		 * 
		 * userRoles.setRole(role1); userRoles.setUser(user);
		 * 
		 * userRoleSet.add(userRoles);
		 * 
		 * User user1=this.userService.createUser(user, userRoleSet);
		 * System.out.println(user1.getUsername());
		 */
	}

}
