package dev.asrul.kubus

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {
//    skenario test
    private lateinit var mainViewModel: MainViewModel
    private lateinit var balokModel: BalokModel
    private val dummyPanjang = 1.5
    private val dummyLebar = 2.0
    private val dummyTinggi = 2.5

    private val dummyVolume = 7.5
    private val dummyKeliling = 24.0
    private val dummyLuas = 23.5

    @Before
    fun persiapan() {
        balokModel = mock(BalokModel::class.java)
        mainViewModel = MainViewModel(balokModel)
    }

    @Test
    fun testVolume() {
        balokModel = BalokModel()
        mainViewModel = MainViewModel(balokModel)
        mainViewModel.simpan(dummyPanjang, dummyLebar, dummyTinggi)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0)
    }

    @Test
    fun testKeliling() {
        balokModel = BalokModel()
        mainViewModel = MainViewModel(balokModel)
        mainViewModel.simpan(dummyPanjang, dummyLebar, dummyTinggi)
        val keliling = mainViewModel.getKeliling()
        assertEquals(dummyKeliling, keliling, 0.0)
    }

    @Test
    fun testLuas() {
        balokModel = BalokModel()
        mainViewModel = MainViewModel(balokModel)
        mainViewModel.simpan(dummyPanjang, dummyLebar, dummyTinggi)
        val luas = mainViewModel.getLuas()
        assertEquals(dummyLuas, luas, 0.0)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(balokModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0)
    }

    @Test
    fun testMockKeliling() {
        `when`(mainViewModel.getKeliling()).thenReturn(dummyKeliling)
        val keliling = mainViewModel.getKeliling()
        verify(balokModel).getKeliling()
        assertEquals(dummyKeliling, keliling, 0.0)
    }

    @Test
    fun testMockLuas() {
        `when`(mainViewModel.getLuas()).thenReturn(dummyLuas)
        val luas = mainViewModel.getLuas()
        verify(balokModel).getLuas()
        assertEquals(dummyLuas, luas, 0.0)
    }

}