package jp.tomiyama.noir.listviewsample2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // ListViewオブジェクトを取得
    val lvMenu = findViewById<ListView>(R.id.lvMenu)
    // リストビューに表示するリストデータを作成
    var menuList = mutableListOf(
      "から揚げ定食", "ハンバーグ定食", "生姜焼き定食",
      "ステーキ定食", "野菜炒め定食", "とんかつ定食",
      "ミンチかつ定食", "チキンカツ定食", "コロッケ定食",
      "焼き魚定食", "焼肉定食"
    )
    // アダプタオブジェクトを生成
    val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, menuList)
    // リストビューにアダプタオブジェクトを設定
    lvMenu.adapter = adapter
  }
}
