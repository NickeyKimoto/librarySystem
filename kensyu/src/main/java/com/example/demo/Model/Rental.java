package com.example.demo.Model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
*クラス名：Rental
*概要：貸出記録のエンティティクラス
*作成者：N.Kimoto
*作成日：2024/09/15
*/

@Entity
@Table(name = "rental")
@Data
public class Rental {
	
	// 貸出ID
	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rentalId = 0;
	
	// 利用者コード
	@NotBlank
	@Length(max = 7, message = "7文字以内で入力してください。")
	private String userId = null;
	
	// ISBNコード
	@NotBlank
	@Length(max = 17, message = "17文字以内で入力してください。")
	private String isbnId = null;
	
	// 貸出日
	@NotBlank
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate rentalDate = null;
	
	// 返却状況
	@NotBlank
	@Length(max = 1, message = "0か1を入力してください。")
	private int isReturned = 0;

}
