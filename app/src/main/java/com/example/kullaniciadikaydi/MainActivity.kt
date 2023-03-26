package com.example.kullaniciadikaydi

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     lateinit var sharedPreferences : SharedPreferences
     var alinanKullaniciAdi :String ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         sharedPreferences = this.getSharedPreferences(" com.example.kullaniciadikaydi",
            Context.MODE_PRIVATE)
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
    }
    fun Kaydet(view: View)
    {
    val kullaniciAdi = editText.text.toString()
    if(kullaniciAdi == "")
    {
        Toast.makeText( this, "Lütfen Bir Değer Giriniz", Toast.LENGTH_SHORT).show()
    }
        else
    {
        sharedPreferences.edit().putString("kullanici",kullaniciAdi).apply()
        textView.text ="Kaydedilen Kullanıcı Adı: ${kullaniciAdi}"
    }
    }
    fun Sil(view: View)
    {
    alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if(alinanKullaniciAdi != null)
        {
            textView.text = "kaydeddilen Kullanici Adı:"
            sharedPreferences.edit().remove("kullanici").apply()
        }
    }
}