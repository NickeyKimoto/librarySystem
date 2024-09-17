package com.example.demo.Controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
*クラス名：GlobalControllAdvice
*概要：アプリケーション全体で発生した例外処理を実装したクラス
*作成者：N.Kimoto
*作成日：2024/09/
*/
@ControllerAdvice
@Component
public class GlobalControllAdvice {
	
	/*
	*関数名：dataAccessExceptionHandler
	*概要：エラー画面を表示する
	*引数：occurredException DataAccessException 発生した例外
	*      errorModel Model ビューへ受け渡す例外情報
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException occurredException, Model errorModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "error";
		
		// 例外クラスのメッセージをModelに登録
		errorModel.addAttribute("error", "内部サーバーエラー（DB）：GlobalControllAdvice");
		
		// 例外クラスのメッセージをModelに登録
		errorModel.addAttribute("message", "DataAccessExceptionが発生しました");
		
		// HTTPのエラーコード（500）をModelに登録
		errorModel.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}

	/*
	*関数名：dataAccessExceptionHandler
	*概要：エラー画面を表示する
	*引数：occurredException Exception 発生した例外
	*      errorModel Model ビューへ受け渡す例外情報
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception occurredException, Model errorModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "error";
		
		// 例外クラスのメッセージをModelに登録
		errorModel.addAttribute("error", "内部サーバーエラー：GlobalControllAdvice");
		
		// 例外クラスのメッセージをModelに登録
		errorModel.addAttribute("message", "Exceptionが発生しました");
		
		// HTTPのエラーコード（500）をModelに登録
		errorModel.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}

}
