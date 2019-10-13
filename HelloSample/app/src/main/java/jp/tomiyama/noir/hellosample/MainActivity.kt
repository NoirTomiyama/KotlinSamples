package jp.tomiyama.noir.hellosample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // 表示ボタンであるButtonオブジェクトを取得
    val btClick = findViewById<Button>(R.id.btClick)
    // リスナクラスのインスタンス生成
    val listener = HelloListener()
    // 表示ボタンにリスナを設定
    btClick.setOnClickListener(listener)

    // クリアボタンであるButtonオブジェクトを取得
    val btClear = findViewById<Button>(R.id.btClear)
    // クリアボタンにリスナを設定
    btClear.setOnClickListener(listener)
  }

  // ボタンをクリックしたときのリスナクラス
  private inner class HelloListener : View.OnClickListener {
    override fun onClick(view: View) {
      // 名前入力欄であるEditTextオブジェクトの取得
      val input = findViewById<EditText>(R.id.etName)
      // メッセージを表示するTextViewオブジェクトの取得
      val output = findViewById<TextView>(R.id.tvOutput)

      // idのR値に応じて処理を分岐
      when (view.id) {
        // 表示ボタンの場合
        R.id.btClick -> {
          // 入力された名前文字列を取得
          val inputStr = input.text.toString()
          // メッセージの表示
          output.text = inputStr + "さん、こんにちは！"
        }
        // クリアボタンの場合
        R.id.btClear -> {
          // 名前入力欄を空文字に設定
          input.setText("")
          output.text = ""
        }
      }


    }
  }

}
