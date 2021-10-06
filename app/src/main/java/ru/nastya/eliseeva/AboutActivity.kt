package ru.nastya.eliseeva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.nastya.eliseeva.databinding.ActivityAboutBinding


class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    companion object {
        private const val EXTRA_URL = "EXTRA_URL"

        fun newInstance(context: Context, url: String) = Intent(context, AboutActivity::class.java).apply {
            putExtra(EXTRA_URL, url)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra(EXTRA_URL) ?: ""


        binding.aboutWebView.apply {
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    }
}