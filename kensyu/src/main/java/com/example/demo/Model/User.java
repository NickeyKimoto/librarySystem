package com.example.demo.Model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
*クラス名：User
*概要：ユーザーのエンティティクラス
*作成者：N.Kimoto
*作成日：2024/09/15
*/

@Entity
@Table(name = "usr")
@Data
public class User {
	
	// 利用者コード
	@Id
	@NotBlank
	@Length(max = 7, message = "7文字以内で入力してください。")
	private String userId = null;
	
	// 利用者苗字
	@NotBlank
	@Length(max = 20, message = "20文字以内で入力してください。")
	private String lastName = null;
	
	// 利用者名前
	@NotBlank
	@Length(max = 20, message = "20文字以内で入力してください。")
	private String firstName = null;
	
	// 住所の都道府県
	@NotBlank
	@Length(max = 15, message = "15文字以内で入力してください。")
	private String prefectureAddress = null;
	
	// 住所の市町村
	@NotBlank
	@Length(max = 20, message = "20文字以内で入力してください。")
	private String cityAddress = null;
	
	// その他の住所
	@NotBlank
	@Length(max = 100, message = "100文字以内で入力してください。")
	private String otherAddress = null;

}