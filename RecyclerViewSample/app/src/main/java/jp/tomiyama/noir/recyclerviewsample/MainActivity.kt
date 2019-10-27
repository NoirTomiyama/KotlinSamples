package jp.tomiyama.noir.recyclerviewsample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    toolbar.setLogo(R.mipmap.ic_launcher)
    setSupportActionBar(toolbar)
    val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbarLayout)
    toolbarLayout.title = getString(R.string.toolbar_title)
    toolbarLayout.setExpandedTitleColor(Color.WHITE)
    toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY)

    // RecyclerViewを取得
    val lvMenu = findViewById<RecyclerView>(R.id.lvMenu)
    // LinearLayoutManagerオブジェクトを生成
    val layout = LinearLayoutManager(applicationContext)
    // RecyclerViewにレイアウトマネージャーとしてLinearLayoutManagerを設定
    lvMenu.layoutManager = layout
    // 定食メニューリストデータを生成
    val menuList = createTeishokuList()
    // アダプタオブジェクトを生成
    val adapter = RecyclerListAdapter(menuList)
    // RecyclerViewにアダプタオブジェクトを設定
    lvMenu.adapter = adapter
  }

  private inner class RecyclerListAdapter(private val _listData: MutableList<MutableMap<String, Any>>) : RecyclerView.Adapter<RecyclerListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerListViewHolder {
      // レイアウトインフレータを取得
      val inflater = LayoutInflater.from(applicationContext)
      // row.xmlをインフレートし，1行分の画面部品とする
      val view = inflater.inflate(R.layout.row, parent, false)
      // ビューホルダーオブジェクトを生成
      val holder = RecyclerListViewHolder(view)
      // 生成したビューホルダーをリターン
      return holder
    }

    override fun onBindViewHolder(holder: RecyclerListViewHolder, position: Int) {
      // リストデータから該当1行分のデータを取得
      val item = _listData[position]
      // メニュー名文字列を取得
      val menuName = item["name"] as String
      // メニュー金額を取得
      val menuPrice = item["price"] as Int
      // 表示用に金額を文字列に変換
      val menuPriceStr = menuPrice.toString()
      // メニュー名と金額をビューホルダー中のTextViewに設定
      holder.tvMenuName.text = menuName
      holder.tvMenuPrice.text = menuPriceStr
    }

    override fun getItemCount(): Int {
      // リストデータ中の件数をリターン
      return _listData.size
    }
  }

  private inner class RecyclerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // リスト1行分中でメニュー名を表示する画面部品
    var tvMenuName: TextView
    // リスト1行分中でメニュー金額を表示する画面部品
    var tvMenuPrice: TextView

    init {
      // 引数で渡されたリスト1行分の画面部品中から表示に使われるTextViewを取得
      tvMenuName = itemView.findViewById(R.id.tvMenuName)
      tvMenuPrice = itemView.findViewById(R.id.tvMenuPrice)
    }
  }

  private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
    //定食メニューリスト用のListオブジェクトを用意。
    val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
    //「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
    var menu = mutableMapOf("name" to "から揚げ定食", "price" to 800, "desc" to "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    //「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
    menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    //以下データ登録の繰り返し。
    menu = mutableMapOf("name" to "生姜焼き定食", "price" to 850, "desc" to "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "ミンチかつ定食", "price" to 850, "desc" to "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "チキンカツ定食", "price" to 900, "desc" to "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "焼き魚定食", "price" to 850, "desc" to "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    menu = mutableMapOf("name" to "焼肉定食", "price" to 950, "desc" to "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。")
    menuList.add(menu)
    return menuList
  }
}
