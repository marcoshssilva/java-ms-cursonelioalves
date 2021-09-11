package br.com.marcoshssilva.hr.api.gateway.zuul.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };
	
	private static final String[] OPERATOR = {"/hr-worker/**"};
	
	private static final String[] ADMIN = {"/hr-payroll/**", "/hr-user/**" };
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(corsConfigurationSource());
		http.authorizeRequests()
			.antMatchers(PUBLIC).permitAll()
			.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
			.antMatchers(ADMIN).hasRole("ADMIN")
			.anyRequest().authenticated();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		
		corConfiguration.setAllowedOrigins(Arrays.asList("*"));
		corConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS"));
		corConfiguration.setAllowCredentials(true);
		corConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource basedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		basedCorsConfigurationSource.registerCorsConfiguration("/**", corConfiguration);
		
		return basedCorsConfigurationSource;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> filterRegistrationBean(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
}
