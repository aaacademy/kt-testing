package dev.asrul.kubus

class BalokModel {
    private var panjang: Double = 0.0
    private var lebar: Double = 0.0
    private var tinggi: Double = 0.0

    fun simpan(panjang: Double, lebar: Double, tinggi: Double) {
        this.panjang = panjang
        this.lebar = lebar
        this.tinggi = tinggi
    }

    fun getVolume(): Double = panjang * lebar * tinggi

    fun getKeliling(): Double = 4 * (panjang + lebar + tinggi)

    fun getLuas(): Double {
        val pl = panjang * lebar
        val lt = lebar * tinggi
        val pt = panjang * tinggi
        return 2 * (pl + lt + pt)
    }

}