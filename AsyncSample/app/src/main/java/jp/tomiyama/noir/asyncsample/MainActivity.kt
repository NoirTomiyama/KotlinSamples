package jp.tomiyama.noir.asyncsample

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // 画面部品ListViewを取得
    val lvCityList = findViewById<ListView>(R.id.lvCityList)
    // SimpleAdapterで使用するMutableListオブジェクトを用意
    val cityList: MutableList<MutableMap<String, String>> = mutableListOf()
    //都市データを格納するMutableMapオブジェクトの用意とcityListへのデータ登録。
    var city = mutableMapOf("name" to "大阪", "id" to "270000")
    cityList.add(city)
    city = mutableMapOf("name" to "神戸", "id" to "280010")
    cityList.add(city)
    city = mutableMapOf("name" to "豊岡", "id" to "280020")
    cityList.add(city)
    city = mutableMapOf("name" to "京都", "id" to "260010")
    cityList.add(city)
    city = mutableMapOf("name" to "舞鶴", "id" to "260020")
    cityList.add(city)
    city = mutableMapOf("name" to "奈良", "id" to "290010")
    cityList.add(city)
    city = mutableMapOf("name" to "風屋", "id" to "290020")
    cityList.add(city)
    city = mutableMapOf("name" to "和歌山", "id" to "300010")
    cityList.add(city)
    city = mutableMapOf("name" to "潮岬", "id" to "300020")
    cityList.add(city)
    // SimpleAdapterで使用するform-to用変数の用意
    val from = arrayOf("name")
    val to = intArrayOf(android.R.id.text1)
    // SimpleAdapterを生成
    val adapter = SimpleAdapter(applicationContext, cityList, android.R.layout.simple_expandable_list_item_1, from, to)
    // ListViewにSimpleAdapterを設定
    lvCityList.adapter = adapter
    // リストタップのリスナクラスの登録
    lvCityList.onItemClickListener = ListItemClickListener()
  }

  // リストがタップされたときの処理が記述されたメンバクラス
  private inner class ListItemClickListener : AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
      // ListViewでタップされた行の都市名と都市IDを取得
      val item = parent.getItemAtPosition(position) as Map<String, String>
      val cityName = item["name"]
      val cityId = item["id"]
      // 取得した都市名をtvCityNameに設定
      val tvCityName = findViewById<TextView>(R.id.tvCityName)
      tvCityName.setText(cityName + "の天気：")
      // WeatherInfoReceiverインスタンス生成
      val receiver = WeatherInfoReceiver()
      // WeatherInfoReceiverを実行
      receiver.execute(cityId)
    }
  }

  private inner class WeatherInfoReceiver() : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String): String {
      // 可変長引数の1個目(インデックス0)を取得．これが都市ID
      val id = params[0]
      val urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=${id}"

      // ここに上記URLに接続してJSON文字列を取得する処理を記述
      // JSON文字列を返す
      return result
    }

    override fun onPostExecute(result: String) {
      // ここに天気情報JSON文字列を解析する処理を記述

      // 天気情報用文字列をTextViewにセット
      val tvWeatherTelop = findViewById<TextView>(R.id.tvWeatherTelop)
      val tvWeatherDesc = findViewById<TextView>(R.id.tvWeatherDesc)
      tvWeatherTelop.text = telop
      tvWeatherDesc.text = desc
    }
  }
}
