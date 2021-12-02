package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.ChampTier.Tier1Adapter
import com.example.firstapp.databinding.FragmentTierTopBinding
import com.example.firstapp.model.ApiResponse
import timber.log.Timber

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class TierTopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTierTopBinding>(
            inflater,
            R.layout.fragment_tier_top,
            container,
            false
        )

        // RecyclerView 초기화
        binding.tier1Recycler.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        val adapter = Tier1Adapter(requireContext())
        binding.tier1Recycler.adapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("jsoup","bundle: $savedInstanceState")

        // 상위 fragment에서 데이터 가져오기
        setFragmentResultListener("tierDataKey") { requestKey, bundle ->
            val result = bundle.getParcelable<BaseParcelable>("topTierKey")?.value
            Log.d("jsoup","result: $result")
        }
    }
}