package com.wang.cn.fragmetn;

import android.view.View;

import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.R;
import com.wang.cn.base.BaseFragment;
import com.wang.cn.utils.UIUtils;

public class GameFragment extends BaseFragment {
	


	@Override
	public View createSuccessView() {

		return UIUtils.inflate(R.layout.activity_main);
	}

	@Override
	public LoadResult load() {
		return LoadResult.EMPTY;
	}
}
