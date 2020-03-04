package com.tharsikan.oauthoauth.conf;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
        import org.springframework.security.crypto.factory.PasswordEncoderFactories;
        import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfigurations extends GlobalAuthenticationConfigurerAdapter {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        super.init(auth);
        auth.inMemoryAuthentication().withUser("krish").password(passwordEncoder.encode("krishpass")).roles("ADMIN","USER","MANAGER").authorities("CAN_READ","CAN_EDIT","CAN_DELETE").and().
                withUser("tharsikan").password(passwordEncoder.encode("tharsikanpass")).roles("ADMIN").authorities("CAN_READ","CAN_EDIT");
    }
}
