package io.github.wonmoyang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.github.wonmoyang.security.filter.AuthTokenFilter;
import io.github.wonmoyang.security.filter.CorsFilter;
import io.github.wonmoyang.security.result.Http401AuthEntryPoint;

/**
 * 인증 환경 설정 (spring security)
 *
 * @author Yang
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfigration extends WebSecurityConfigurerAdapter{
	
    private final CorsFilter corsFilter;
    
    public SecurityConfigration(CorsFilter corsFilter) {
    	this.corsFilter = corsFilter;
	}

	// 인증 서비스 생성
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
	// web resource 환경 정의
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	// http security 환경 정의
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling().authenticationEntryPoint(http401AuthEntryPoint())
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
			.permitAll()
		.and()
			.headers()
			.frameOptions()
			.disable()
		.and()
			.authorizeRequests()
	    	.antMatchers("/").permitAll()
	    	.antMatchers("/api/login*").permitAll()
	    	.antMatchers("/api/users/**").permitAll();
	}
	
    @Bean
    public Http401AuthEntryPoint http401AuthEntryPoint() {
        return new Http401AuthEntryPoint();
    }
	
    @Bean
    public AuthTokenFilter authTokenFilter() throws Exception {
        return new AuthTokenFilter();
    }

}
