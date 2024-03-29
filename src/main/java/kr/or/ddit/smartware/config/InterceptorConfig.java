package kr.or.ddit.smartware.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import kr.or.ddit.smartware.interceptor.PerformanceCheckInterceptor;

@Configuration
@EnableWebMvc
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		PerformanceCheckInterceptor performanceCheckInterceptor = new PerformanceCheckInterceptor();
		registry.addInterceptor(performanceCheckInterceptor).addPathPatterns("/**");
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/bootstrap/**")
				.excludePathPatterns("/error/**");
	}
}
