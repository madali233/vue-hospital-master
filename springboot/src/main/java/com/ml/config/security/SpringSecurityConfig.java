package com.ml.config.security;

import com.ml.config.security.filter.CheckTokenFilter;
import com.ml.config.security.handler.AnonymousAuthenticationHandler;
import com.ml.config.security.handler.CustomerAccessDeniedHandler;
import com.ml.config.security.handler.LoginFailureHandler;
import com.ml.config.security.handler.LoginSuccessHandler;
import com.ml.config.security.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
//开启权限注解控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private CustomerUserDetailsService customerUserDetailsService;
    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private LoginFailureHandler loginFailureHandler;
    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;
    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;
        /**
        * 注入加密处理类
        *
        * @return
        */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Resource
    private CheckTokenFilter checkTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//登录前进行过滤
        http.addFilterBefore(checkTokenFilter,
                UsernamePasswordAuthenticationFilter.class);
        http.formLogin()
                .loginProcessingUrl("/api/user/login")
// 设置登录验证成功或失败后的的跳转地址
                .successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
// 禁用csrf防御机制
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationHandler)
                .accessDeniedHandler(customerAccessDeniedHandler)
                .and().cors();//开启跨域配置
    }
    /**
     * 配置认证处理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
