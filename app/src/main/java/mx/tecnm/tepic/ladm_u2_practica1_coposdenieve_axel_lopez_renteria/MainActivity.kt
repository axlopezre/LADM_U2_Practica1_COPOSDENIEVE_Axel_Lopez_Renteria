package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_axel_lopez_renteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_axel_lopez_renteria.databinding.ActivityMainBinding
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Lienzo(this))
    }

}