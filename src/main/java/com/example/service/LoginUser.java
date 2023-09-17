package com.example.service;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
import com.example.entity.User;


public class LoginUser implements UserDetails {
	//Userオブジェクト
	private final User user;
	
	//コンストラクタ
	public LoginUser(User user) {
		this.user = user;
	}
	
	//EntityクラスのUseオブジェクトのゲッター
	public User getUser() {
		return this.user;
	}
	
	//ユーザー認証に使用されるパスワードを返却
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	//ユーザー認証に使用されるユーザー名を返却する
	@Override
	public String getUsername() {
		return this.user.getEmail();
	}
	
	
}
