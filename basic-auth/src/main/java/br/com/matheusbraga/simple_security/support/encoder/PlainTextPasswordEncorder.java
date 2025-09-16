package br.com.matheusbraga.simple_security.support.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncorder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

}
