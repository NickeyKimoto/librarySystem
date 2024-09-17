package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Rental;
import com.example.demo.Repository.RentalRepository;

import jakarta.transaction.Transactional;

/*
*クラス名：RentalService
*概要：リポジトリの機能を実際に使用するクラス
*作成者：N.Kimoto
*作成日：2024/09/
*/
@Service
public class RentalService {
	
	// リポジトリの機能を実際に使用するインスタンス
	private RentalRepository rentalRepository = null;
	
	/*
	*コンストラクタ名：RentalService
	*概要：貸出記録サービスのコンストラクタ
	*引数：rentalRepository RentalRepository 貸出記録リポジトリのクラスインスタンス
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Autowired
	public RentalService(RentalRepository rentalRepository) {
		
		// フィールドを引数で初期化
		this.rentalRepository = rentalRepository;
		
	}
	
	/*
	*関数名：getAllRental
	*概要：貸出記録を全件検索する
	*引数：なし
	*戻り値：allRental List<Rental> 全ての貸出記録
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<Rental> getAllRental() {
		
		// 貸出記録を全件検索する
		List<Rental> allRental = rentalRepository.findAll();
		
		// 全ての貸出記録を返却
		return allRental;
		
	}
	
	/*
	*関数名：searchRental
	*概要：貸出記録を検索ワードで検索する
	*引数：searchWord String 検索ワード
	*戻り値：searchResult List<Rental> 検索結果
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<Rental> searchRental(String searchWord) {
		
		// 貸出記録を検索ワードで検索する
		List<Rental> searchResult = rentalRepository.findByNameContaining(searchWord);
		
		// 検索結果を返却
		return searchResult;
		
	}
	
	/*
	*関数名：saveRental
	*概要：貸出記録を保存する
	*引数：newData Rental 保存する貸出記録
	*戻り値：addedRental Rental 保存した貸出記録
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public Rental saveRental(Rental newData) {
		
		// 貸出記録を保存する
		Rental addedRental = rentalRepository.saveAndFlush(newData);
		
		// 保存した貸出記録を返却
		return addedRental;
		
	}
	
	/*
	*関数名：getRentalById
	*概要：貸出IDのデータを取得する
	*引数：searchId int 取得するデータの貸出ID
	*戻り値：selectedData Optional<Rental> 取得したデータ
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public Optional<Rental> getRentalById(int searchId) {
		
		// 貸出IDのデータを取得する
		Optional<Rental> selectedData = rentalRepository.findById(searchId);
		
		// 取得したデータを返却
		return selectedData;
		
	}

}
