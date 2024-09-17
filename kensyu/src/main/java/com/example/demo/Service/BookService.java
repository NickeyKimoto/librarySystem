package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;

import jakarta.transaction.Transactional;

/*
*クラス名：BookService
*概要：リポジトリの機能を実際に使用するクラス
*作成者：N.Kimoto
*作成日：2024/09/
*/
@Service
public class BookService {

	// リポジトリの機能を実際に使用するインスタンス
	private BookRepository bookRepository = null;
	
	/*
	*コンストラクタ名：BookService
	*概要：書籍情報サービスのコンストラクタ
	*引数：bookRepository BookRepository 書籍情報リポジトリのクラスインスタンス
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Autowired
	public BookService(BookRepository bookRepository) {
		
		// フィールドを引数で初期化
		this.bookRepository = bookRepository;
		
	}
	
	/*
	*関数名：getAllBooks
	*概要：書籍情報を全件検索する
	*引数：なし
	*戻り値：allBooks List<Book> 全ての書籍情報
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<Book> getAllBooks() {
		
		// 書籍情報を全件検索する
		List<Book> allBooks = bookRepository.findAll();
		
		// 全ての書籍情報を返却
		return allBooks;
		
	}
	
	/*
	*関数名：searchBooks
	*概要：書籍情報を検索ワードで検索する
	*引数：searchWord String 検索ワード
	*戻り値：searchResult List<Book> 検索結果
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Transactional
	public List<Book> searchBooks(String searchWord) {
		
		// 書籍情報を検索ワードで検索する
		List<Book> searchResult = bookRepository.findByNameContaining(searchWord);
		
		// 検索結果を返却
		return searchResult;
		
	}
	
}