package com.example.service;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.authority.AuthorityUtils;

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
	
	public Cllection<? extends GrantedAuthority> getAuthorities(){
		//ロールカラムを見て、認証ユーザのロールを設定
		if(this.user.getRole().equals("管理者"))｛
				return AuthorityUtils.createAuthorityList("ADMIN","GENERAL");
	}
	
	return AuthorityUtils.createAthorityList("GENERAL");
	
	
}
