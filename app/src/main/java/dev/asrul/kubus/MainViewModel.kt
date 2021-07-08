package dev.asrul.kubus

class MainViewModel(private val balokModel: BalokModel) {
    fun simpan(p: Double, l: Double, t: Double) {
        balokModel.simpan(p, l, t)
    }

    fun getVolume(): Double = balokModel.getVolume()

    fun getKeliling(): Double = balokModel.getKeliling()

    fun getLuas(): Double = balokModel.getLuas()
}