package jp.te4a.spring.boot.myapp13.mybootapp13.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp13.mybootapp13.bean.UserBean;
import jp.te4a.spring.boot.myapp13.mybootapp13.repository.UserRepository;
import jp.te4a.spring.boot.myapp13.mybootapp13.security.LoginUserDetails;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBean> opt = userRepository.findById(username);
        UserBean userBean = opt.orElseThrow(() -> new UsernameNotFoundException("The requested user is not found."));
        return (UserDetails) new LoginUserDetails(userBean, true, true, true, getAuthorities(userBean));
    }
    private Collection<GrantedAuthority> getAuthorities(UserBean userBean) {
        List<GrantedAuthority> authList = null;
        if(userBean.getUsername() == "admin") {
            authList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER","ROLE_OTHER");
        } else if(userBean.getUsername() == "") {
            authList = AuthorityUtils.createAuthorityList("ROLE_OTHER");
        } else {
            authList = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_OTHER");
        }
        return authList;
    }
}

    