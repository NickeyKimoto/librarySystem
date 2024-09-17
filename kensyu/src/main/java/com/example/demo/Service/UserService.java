package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import jakarta.transaction.Transactional;

/*
*クラス名：UserService
*概要：リポジトリの機能を実際に使用するクラス
*作成者：N.Kimoto
*作成日：2024/09/
*/
@Service
public class UserService {
	
	// リポジトリの機能を実際に使用するインスタンス
	private UserRepository userRepository = null;
	
	/*
	*コンストラクタ名：UserService
	*概要：ユーザーサービスのコンストラクタ
	*引数：userRepository UserRepository ユーザーリポジトリのクラスインスタンス
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Autowired
	public UserService(UserRepository userRepository) {
		
		// フィールドを引数で初期化
		this.userRepository = userRepository;
		
	}
	
	/*
	*関数名：getAllUser
	*概要：ユーザーを全件検索する
	*引数：なし
	*戻り値：allUser List<User> 全てのユーザー
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<User> getAllUser() {
		
		// ユーザーを全件検索する
		List<User> allUser = userRepository.findAll();
		
		// 全ての貸出記録を返却
		return allUser;
		
	}
	
	/*
	*関数名：searchUser
	*概要：ユーザーを検索ワードで検索する
	*引数：searchWord String 検索ワード
	*戻り値：searchResult List<User> 検索結果
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<User> searchUser(String searchWord) {
		
		// 貸出記録を検索ワードで検索する
		List<User> searchResult = userRepository.findByNameContaining(searchWord);
		
		// 検索結果を返却
		return searchResult;
		
	}
	
	/*
	*関数名：saveUser
	*概要：ユーザーを保存する
	*引数：newData User 保存するユーザー
	*戻り値：addedUser User 保存したユーザー
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public User saveUser(User newData) {
		
		// ユーザーを保存する
		User addedUser = userRepository.saveAndFlush(newData);
		
		// 保存したユーザーを返却
		return addedUser;
		
	}
	
	/*
	*関数名：getUserById
	*概要：利用者コードのデータを取得する
	*引数：searchId String 取得するデータの利用者コード
	*戻り値：selectedData Optional<User> 取得したデータ
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public Optional<User> getUserById(String searchId) {
		
		// 利用者コードのデータを取得する
		Optional<User> selectedData = userRepository.findById(searchId);
		
		// 取得したデータを返却
		return selectedData;
		
	}
	
	/*
	*関数名：deleteUser
	*概要：ユーザーを削除する
	*引数：deleteUserId String 削除するユーザーの利用者コード
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public void deleteUser(String deleteUserId) {
		
		// 利用者コードのユーザーを削除する
		userRepository.deleteById(deleteUserId);
		
	}

}
