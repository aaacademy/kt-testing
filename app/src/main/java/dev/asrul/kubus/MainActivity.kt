package dev.asrul.kubus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText

    private lateinit var tvHasil: TextView

    private lateinit var btnSave: Button
    private lateinit var btnLuas: Button
    private lateinit var btnKeliling: Button
    private lateinit var btnVolume: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(BalokModel())

        edtPanjang = findViewById(R.id.edt_panjang)
        edtLebar = findViewById(R.id.edt_lebar)
        edtTinggi = findViewById(R.id.edt_tinggi)
        tvHasil = findViewById(R.id.tv_hasil)
        btnSave = findViewById(R.id.btn_save)
        btnKeliling = findViewById(R.id.btn_keliling)
        btnLuas = findViewById(R.id.btn_luas)
        btnVolume = findViewById(R.id.btn_volume)

        btnSave.setOnClickListener(this)
        btnKeliling.setOnClickListener(this)
        btnLuas.setOnClickListener(this)
        btnVolume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val inputPanjang = edtPanjang.text.toString().trim()
        val inputLebar = edtLebar.text.toString().trim()
        val inputTinggi = edtTinggi.text.toString().trim()

        when{
            inputPanjang.isEmpty() -> edtPanjang.error = "Kolom panjang harus diisi"
            inputLebar.isEmpty() -> edtLebar.error = "Kolom lebar harus diisi"
            inputTinggi.isEmpty() -> edtTinggi.error = "Kolom tinggi harus diisi"
            else -> {
                val p = inputPanjang.toDouble()
                val l = inputLebar.toDouble()
                val t = inputTinggi.toDouble()
                when{
                    v.id == R.id.btn_save -> {
                        mainViewModel.simpan(p, l, t)
                        visible()
                    }
                    v.id == R.id.btn_volume -> {
                        tvHasil.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    v.id == R.id.btn_keliling -> {
                        tvHasil.text = mainViewModel.getKeliling().toString()
                        gone()
                    }
                    v.id == R.id.btn_luas -> {
                        tvHasil.text = mainViewModel.getLuas().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnSave.visibility = View.GONE
        btnVolume.visibility = View.VISIBLE
        btnKeliling.visibility = View.VISIBLE
        btnLuas.visibility = View.VISIBLE
    }

    private fun gone() {
        btnSave.visibility = View.VISIBLE
        btnVolume.visibility = View.GONE
        btnKeliling.visibility = View.GONE
        btnLuas.visibility = View.GONE
    }
}