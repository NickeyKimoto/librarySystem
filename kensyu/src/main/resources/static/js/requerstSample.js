/* 
 * このフロントエンドプログラムをSpringBootで使う時の事前準備
 
 1. scr/main/resources/static/js/[このjsファイル] となるようにファイルを配置する
 2. jsフォルダの中に、このjsファイルと「jquery.min.js」「jquery-ui.min.js」の各ファイルを置く。
 3. index.htmlのbodyタグ配下先頭に以下を追記する。(index.htmlはscr/main/resources/templates内に配置されている認識です。)
 
<!-- JavaScriptを読み込む。 -->
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/requerstSample.js"></script>

 */


/* 
 * 関数名:requestGetHtm
 * 概要  :サーバ側の指定されたパスに対してAjaxでリクエストを要求し、HTMLで結果を得る
 * 第1引数：urlPath リクエストを送るURL（Javaサーブレットを置いたURLを指定する）
 * MOD 2024/08/09 S.Saito サーバに送る情報を文字列ではなく文字列の配列に変更
 * 第2引数：paramList サーバ側に送る文字列情報の配列
 * 第3引数：appendDomSelector サーバから帰ってきたHTMLを差し込むタグのセレクタ(画面上の差し込み先の情報)
 * 返却値  :html サーバから帰ってきたHTML文字列
 * 作成者:S.Takemoto
 * 作成日:2023.07.31
 */
this.requestGetHtml = function(urlPath, paramList, appendDomSelector){
	//Ajax通信でHTMLを取得する。
	$.ajax({
		//URLを指定する。
		url: urlPath,
		//取得するファイルの形式をHTMLに指定する。
		dataType: 'HTML',
		//POSTメソッドでデータを送信する
		type:'POST', 
		//同期通信を行う。
		async: false,
		//サーバへ引数となる文字列を送信する。
		data: {param:paramList}, 
		//キャッシュを無効にする。
		cache:false,
		//通信完了時の処理を記述する。
		success: function(html){
			//指定されたセレクタを空にする
			$(appendDomSelector).empty();
			//指定されたセレクタにDOMを追加する。
			$(appendDomSelector).append($(html));
		},
		//通信失敗時の処理。
		error:function(){
			//エラーのダイアログを出す。
			alert('通信に失敗しました。');
		}
	});
	
	return html;
};