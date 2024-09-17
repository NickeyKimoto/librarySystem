package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Book;
import com.example.demo.Model.Rental;
import com.example.demo.Model.User;
import com.example.demo.Service.BookService;
import com.example.demo.Service.RentalService;
import com.example.demo.Service.UserService;

/*
*クラス名：LibraryController
*概要：リクエストを受け取り、適切な処理を実行してレスポンスを返す
*作成者：N.Kimoto
*作成日：2024/09/
*/
@Controller
public class LibraryController {
	
	// 書籍情報サービスのインスタンスを生成
	private final BookService bookService;
	// 貸出記録サービスのインスタンスを生成
	private final RentalService rentalService;
	// ユーザーサービスのインスタンスを生成
	private final UserService userService;
	
	/*
	*コンストラクタ名：LibraryController
	*概要：図書館システムコントローラーのコンストラクタ
	*引数：bookService BookService 書籍情報サービスのクラスインスタンス
	*      rentalService RentalService 貸出記録サービスのクラスインスタンス
	*      userService UserService ユーザーサービスのクラスインスタンス
	*戻り値：なし
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@Autowired
	public LibraryController(BookService bookService, RentalService rentalService, UserService userService) {
		
		// 書籍情報サービスのインスタンスを引数で初期化
		this.bookService = bookService;
		// 貸出記録サービスのインスタンスを引数で初期化
		this.rentalService = rentalService;
		// ユーザーサービスのインスタンスを引数で初期化
		this.userService = userService;
		
	}
	
	/*
	*関数名：homePage
	*概要：ホーム画面を表示する
	*引数：なし
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/")
	public String homePage() {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "index";
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：bookPage
	*概要：書誌貸出画面を表示する
	*引数：bookModel Model ビューへ受け渡す書籍情報
	*      rentalModel Model ビューへ受け渡す貸出記録
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/bookPage")
	public String bookPage(Model bookModel, Model rentalModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "bookPage";
		
		// 書籍情報サービスから全ての書籍情報を取得
		List<Book> listBooks = bookService.getAllBooks();
		// 貸出記録サービスから全ての貸出記録を取得
		List<Rental> listRental = rentalService.getAllRental();
		
		// 取得した書籍情報をビューに渡す
		bookModel.addAttribute("listBooks", listBooks);
		// 取得した貸出記録をビューに渡す
		rentalModel.addAttribute("listRental", listRental);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：searchBookPage
	*概要：書籍情報の検索結果を表示する
	*引数：searchWord String 検索ワード
	*      bookModel Model ビューへ受け渡す書籍情報
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/searchBookPage")
	public String searchBookPage(@RequestParam("searchWord") String searchWord, Model bookModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "bookPage";
		
		// 書籍情報サービスから検索した書籍情報を取得
		List<Book> listBooks = bookService.searchBooks(searchWord);
		
		// 取得した書籍情報をビューに渡す
		bookModel.addAttribute("listBooks", listBooks);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：searchRentalPage
	*概要：貸出記録の検索結果を表示する
	*引数：searchWord String 検索ワード
	*      rentalModel Model ビューへ受け渡す貸出記録
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/searchRentalPage")
	public String searchRentalPage(@RequestParam("searchWord") String searchWord, Model rentalModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "bookPage";
		
		// 貸出記録サービスから検索した貸出記録を取得
		List<Rental> listRental = rentalService.searchRental(searchWord);
		
		// 取得した貸出記録をビューに渡す
		rentalModel.addAttribute("listRental", listRental);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：addRental
	*概要：貸出記録を追加する
	*引数：newData Rental 追加する貸出記録
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@PostMapping("/addRental")
	public String addRental(@ModelAttribute("Rental") Rental newData) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "bookPage";
		
		// 貸出記録を追加
		rentalService.saveRental(newData);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：editRentalPage
	*概要：貸出記録編集画面を表示する
	*引数：rentalId int 編集する貸出記録の貸出ID
	*      rentalModel Model 取得した貸出記録
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/editRentalPage/{rentalId}")
	public String editRentalPage(@PathVariable(value = "rentalId") int rentalId, Model rentalModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "edit";
		
		// 更新する貸出記録を取得
		Rental editRental = rentalService.getRentalById(rentalId).orElse(null);
		
		// 取得した貸出記録をビューに渡す
		rentalModel.addAttribute("editRental", editRental);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：userPage
	*概要：ユーザー画面を表示する
	*引数：userModel Model ビューへ受け渡すユーザー
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/userPage")
	public String userPage(Model userModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "userPage";
		
		// 書籍情報サービスから全てのユーザーを取得
		List<User> listUser = userService.getAllUser();
		
		// 取得したユーザーをビューに渡す
		userModel.addAttribute("listUser", listUser);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：searchUserPage
	*概要：ユーザーの検索結果を表示する
	*引数：searchWord String 検索ワード
	*      userModel Model ビューへ受け渡すユーザー
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/searchUserPage")
	public String searchUserPage(@RequestParam("searchWord") String searchWord, Model userModel) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "userPage";
		
		// ユーザーサービスから検索したユーザーを取得
		List<User> listUser = userService.searchUser(searchWord);
		
		// 取得したユーザーをビューに渡す
		userModel.addAttribute("listUser", listUser);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：addUser
	*概要：ユーザーを追加する
	*引数：newData User 追加するユーザー
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("User") User newData) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "userPage";
		
		// ユーザーを追加
		userService.saveUser(newData);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}
	
	/*
	*関数名：deleteUser
	*概要：ユーザーを削除する
	*引数：userId String 削除するユーザーのユーザーID
	*戻り値：displayScreen String 画面のHTMLファイル名
	*作成者：N.Kimoto
	*作成日：2024/09/
	*/
	@GetMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable(value = "userId") String userId) {
		
		// 表示する画面のHTMLファイル名を宣言
		String displayScreen = "userPage";
		
		// 指定されたユーザーを削除する
		this.userService.deleteUser(userId);
		
		// 表示する画面のHTMLファイル名を返却
		return displayScreen;
		
	}

}
