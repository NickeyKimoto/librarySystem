package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

/*
*インターフェース名：UserRepository
*概要：DBを操作できるようにするインターフェース
*作成者：N.Kimoto
*作成日：2024/09/15
*/
public interface UserRepository extends JpaRepository<User, String> {
	
	/*
	*関数名：findByNameContaining
	*概要：ユーザーを曖昧検索する
	*引数：searchWord String 検索ワード
	*作成者：N.Kimoto
	*作成日：2024/09/15
	*/
	List<User> findByNameContaining(String searchWord);

}