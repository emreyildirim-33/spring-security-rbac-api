package com.workintech.s19d2.service;

import com.workintech.s19d2.dao.MemberRepository;
import com.workintech.s19d2.dao.RoleRepository;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public Member register(String email, String password) {

        Optional<Member> foundMember = memberRepository.findByEmail(email);
        if (foundMember.isPresent()) {
            throw new RuntimeException("User with given email already exist");
        }


        Role role = roleRepository.findByAuthority("ADMIN").orElse(null);

        if (role == null) {
            role = roleRepository.findByAuthority("USER")
                    .orElseThrow(() -> new RuntimeException("USER rolü bulunamadı!"));
        }

        List<Role> roles = new ArrayList<>();
        roles.add(role);


        Member member = new Member();
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        member.setRoles(roles);

        return memberRepository.save(member);
    }
}