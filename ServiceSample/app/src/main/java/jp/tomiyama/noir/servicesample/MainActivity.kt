package jp.tomiyama.noir.servicesample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  var mService: SoundManageService? = null
  private var bound: Boolean = false

  // コネクション作成
  private val connection = object : ServiceConnection {
    override fun onServiceConnected(className: ComponentName, service: IBinder) {
      // サービス接続時に呼ばれる
      Log.i("ServiceConnection", "onServiceConnected")
      // BinderからServiceのインスタンスを取得
      mService = (service as SoundManageService.BindServiceBinder).getService()
      mService?.let {
        if (mService!!.isPlay) {
          // 再生ボタンをタップ不可に，停止ボタンをタップ可に変更
          val btPlay = findViewById<Button>(R.id.btPlay)
          val btStop = findViewById<Button>(R.id.btStop)
          btPlay.isEnabled = false
          btStop.isEnabled = true
        }
      }
      bound = true
    }

    override fun onServiceDisconnected(arg0: ComponentName) {
      // サービス切断時に呼ばれる
      Log.i("ServiceConnection", "onServiceDisconnected")
      mService = null
      bound = false
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // バインド開始
    bindService(Intent(this, SoundManageService::class.java), connection, Context.BIND_AUTO_CREATE)
    mService?.let {
      if (!mService!!.isPlay) {
        // 再生ボタンをタップ可に，停止ボタンをタップ可に変更
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = true
        btStop.isEnabled = false
      }
    }
  }

  fun onPlayButtonClick(view: View) {
    // バインド開始
    bindService(Intent(this, SoundManageService::class.java), connection, Context.BIND_AUTO_CREATE)
    // インテントオブジェクトを生成
    val intent = Intent(applicationContext, SoundManageService::class.java)
    // サービスを起動
    startService(intent)
    // 再生ボタンをタップ不可に，停止ボタンをタップ可に変更
    val btPlay = findViewById<Button>(R.id.btPlay)
    val btStop = findViewById<Button>(R.id.btStop)
    btPlay.isEnabled = false
    btStop.isEnabled = true
  }

  fun onStopButtonClick(view: View) {
    // インテントオブジェクトを生成
    val intent = Intent(applicationContext, SoundManageService::class.java)
    // サービスを停止
    stopService(intent)
    // 再生ボタンをタップ可に，停止ボタンをタップ可に変更
    val btPlay = findViewById<Button>(R.id.btPlay)
    val btStop = findViewById<Button>(R.id.btStop)
    btPlay.isEnabled = true
    btStop.isEnabled = false
    unbindService(connection)
  }

  override fun onDestroy() {
    super.onDestroy()
    if (bound) {
      unbindService(connection)
      bound = false
    }
  }
}
