package com.example.demo.Model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
*クラス名：Book
*概要：書籍情報のエンティティクラス
*作成者：N.Kimoto
*作成日：2024/09/15
*/

@Entity
@Table(name = "books")
@Data
public class Book {
	
	// ISBNコード
	@Id
	private String isbnId = null;
	
	// 本のタイトル
	@NotBlank(message = "入力必須です。")
	@Length(max = 255, message = "255文字以内で入力してください。")
	private String bookTitle = null;
	
	// 出版社名
	private String publisherName = null;
	
	// 分類ID
	private String categoryId = null;

}
