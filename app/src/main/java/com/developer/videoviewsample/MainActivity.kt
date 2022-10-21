package com.developer.videoviewsample

import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.developer.videoviewsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.video.setOnPreparedListener(OnPreparedListener { mp ->
            mp.setOnVideoSizeChangedListener { _, _, _ ->
                val mc = MediaController(this@MainActivity)
                binding.video.setMediaController(mc)
                mc.setAnchorView(binding.video)
            }
        })
        binding.video.setVideoPath("https://edisciplinas.usp.br/pluginfile.php/5196097/mod_resource/content/1/Teste.mp4");
        binding.video.start();

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}