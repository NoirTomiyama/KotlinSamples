package com.noir.lifecyclesample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i("LifeCycleSample", "Sub onCreate() called.")
    setContentView(R.layout.activity_sub)
  }

  override fun onStart() {
    Log.i("LifeCycleSample", "Sub onStart() called.")
    super.onStart()
  }

  override fun onRestart() {
    Log.i("LifeCycleSample", "Sub onRestart() called.")
    super.onRestart()
  }

  override fun onResume() {
    Log.i("LifeCycleSample", "Sub onResume() called.")
    super.onResume()
  }

  override fun onPause() {
    Log.i("LifeCycleSample", "Sub onPause() called.")
    super.onPause()
  }

  override fun onStop() {
    Log.i("LifeCycleSample", "Sub onStop() called.")
    super.onStop()
  }

  override fun onDestroy() {
    Log.i("LifeCycleSample", "Sub onDestroy() called.")
    super.onDestroy()
  }

  // 「前の画面を表示」ボタンがタップされた時の処理
  fun onButtonClick(view: View) {
    // このアクティビティの終了
    finish()
  }
}
