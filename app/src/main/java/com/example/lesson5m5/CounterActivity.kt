package com.example.lesson5m5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.lesson5m5.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCounterBinding.inflate(layoutInflater)
    }
    private val viewModel: CountViewModel by lazy {
        ViewModelProvider(this)[CountViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
        }


        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
        }

        viewModel.counterData.observe(this) { counter ->
            binding.tvResult.text = counter.toString()
        }

        viewModel.message.observe(this) { messageToast ->
            Toast.makeText(this, messageToast.toString(), Toast.LENGTH_LONG).show()
        }

        viewModel.textColor.observe(this) { color ->
            binding.tvResult.setTextColor(getColor(color))
        }
    }
}