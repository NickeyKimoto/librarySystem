package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Book;

/*
*インターフェース名：BookRepository
*概要：DBを操作できるようにするインターフェース
*作成者：N.Kimoto
*作成日：2024/09/15
*/
public interface BookRepository extends JpaRepository<Book, String> {

	/*
	*関数名：findByNameContaining
	*概要：書籍情報を曖昧検索する
	*引数：searchWord String 検索ワード
	*作成者：N.Kimoto
	*作成日：2024/09/15
	*/
	List<Book> findByNameContaining(String searchWord);
	
}
