package com.example.get_date_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView // TextViewクラス使用
import android.view.View // Viewクラス使用
import android.widget.Toast
import com.example.get_date_app.databinding.ActivityMainBinding
import java.util.Date // Dateクラス使用


class MainActivity : AppCompatActivity() {

    // Bindingクラスを入れる変数
    // Widgetの操作を簡単にできる
    // レイアウトファイル一つにつき一個設定できる
    // build.gradle(Moduleの方)で有効化させてから使う
    private lateinit var binding: ActivityMainBinding // activity_main.xmlが設定される

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // バインディングを設定（ほぼ定型分なので丸暗記）
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Buttonを長押しした時のハンドラー
        // 自前でイベントハンドラーを作る場合はView.setOn~Listenerを定義し、
        // WidgetのsetOn~Listenerにセットする
        // 下のコードはクロージャで簡単に記述してるので原始的なコードは本書P94を確認
        binding.btnCurrent.setOnLongClickListener {
            var date = Date().toString()
            // トースト表示
            // 第一引数にcontext
            // 第二引数に値
            // 第三引数に表示する長さ
            val toast = Toast.makeText(this, date, Toast.LENGTH_LONG)
            toast.show() // 表示

            Log.d("CurrentTime", date)

            true
        }
    }

    // Buttonのイベントハンドラー
    // ボタンはクリックは当たり前に使うのでAttributeにある
    fun btnCurrentClick(v: View) {

        // ResIdからViewを特定(Bundleで指定しない場合の方法)
        val textResult = findViewById<TextView>(R.id.textResult)

        //　現在日時に値を更新
        textResult.text = Date().toString()
    }

}