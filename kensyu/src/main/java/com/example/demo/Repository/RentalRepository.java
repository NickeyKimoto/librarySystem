package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Rental;

/*
*インターフェース名：RentalRepository
*概要：DBを操作できるようにするインターフェース
*作成者：N.Kimoto
*作成日：2024/09/15
*/
public interface RentalRepository extends JpaRepository<Rental, Integer> {
	
	/*
	*関数名：findByNameContaining
	*概要：貸出記録を曖昧検索する
	*引数：searchWord String 検索ワード
	*作成者：N.Kimoto
	*作成日：2024/09/15
	*/
	List<Rental> findByNameContaining(String searchWord);

}