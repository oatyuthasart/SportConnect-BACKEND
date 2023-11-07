//package com.example.demo.tokens;
//
//import com.example.demo.exceptions.type.ApiNotFoundException;
//import com.example.demo.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepository jwtUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        System.out.println("Email: " + email);
//        if(jwtUserRepository.existsByUsername(email)){
//            com.example.demo.entities.User jwtUser = jwtUserRepository.findByUsername(email);
//            return new User(jwtUser.getUsername(), "test", getAuthority(jwtUser));
//        } else {
//            throw new ApiNotFoundException("Email does not exist");
//        }
//
//
////        if (jwtUser == null) {
////            throw new UsernameNotFoundException("email Not found" + email);
////        }
//
//    }
//
//    private Set<SimpleGrantedAuthority> getAuthority(com.example.demo.entities.User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        //authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//        authorities.add(new SimpleGrantedAuthority("ROLE_member"));
//        return authorities;
//    }
//
//}
