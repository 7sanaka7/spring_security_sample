package com.example.Config;

import org.springframework.context.annotation.Bean;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;

// Spring Securityの設定を有効にします
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//認可に関する設定
		http.authorizeRequests()
		.antMatchers("/loginForm").permitAll()  // /loginFormは全ユーザからのアクセスを許可
        .anyRequest().authenticated();   // 許可した項目以外は認証を求める
		
		 //ログイン処理
	    http.formLogin()
	        .loginProcessingUrl("/login") // ログイン処理のパス
	        .loginPage("/loginForm") // ログインページの指定
	        .usernameParameter("email") // ログインページのメールアドレス
	        .passwordParameter("password") // ログインページのパスワード
	        .defaultSuccessUrl("/home", true) // ログイン成功後のパス
	        .failureUrl("/loginForm?error"); // ログイン失敗時のパス
	    
	    //ログアウト処理
	    http.logout()
	    .logoutUrl("/logout") //ログアウト処理のパス
	    .logoutSuccessUrl("/loginForm") ;//ログアウト成功後のパス
	    
	    //認可の設定
	    http.authorizeRequests()
	    	.antMatchers("/loginForm").permitALL()
	    	.antMatchers("/admin").hasAuthority("ADMIN") //管理者のみadminにアクセス可能
	    	.antRequest().authoriticated();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override  // WebSecurity型の引数を持ったconfigure()を追加します
    public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}
}
