package com.fuka.coroutineusecasesonandroid.usecases.flow.usecase3

import android.os.Bundle
import androidx.activity.viewModels
import com.fuka.coroutineusecasesonandroid.base.BaseActivity
import com.fuka.coroutineusecasesonandroid.base.flowUseCase3Description
import com.fuka.coroutineusecasesonandroid.databinding.ActivityFlowUsecase1Binding
import com.fuka.coroutineusecasesonandroid.utils.setGone
import com.fuka.coroutineusecasesonandroid.utils.setVisible
import com.fuka.coroutineusecasesonandroid.utils.toast
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

class FlowUseCase3Activity : BaseActivity() {

    private val binding by lazy { ActivityFlowUsecase1Binding.inflate(layoutInflater) }
    private val adapter = StockAdapter()

    private val viewModel: FlowUseCase3ViewModel by viewModels {
        ViewModelFactory(NetworkStockPriceDataSource(mockApi(applicationContext)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.currentStockPriceAsLiveData.observe(this) { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                binding.progressBar.setVisible()
                binding.recyclerView.setGone()
            }
            is UiState.Success -> {
                binding.recyclerView.setVisible()
                binding.lastUpdateTime.text =
                    "lastUpdateTime: ${LocalDateTime.now().toString(DateTimeFormat.fullTime())}"
                adapter.stockList = uiState.stockList
                binding.progressBar.setGone()
            }
            is UiState.Error -> {
                toast(uiState.message)
                binding.progressBar.setGone()
            }
        }
    }

    override fun getToolbarTitle() = flowUseCase3Description
}