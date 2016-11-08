package com.wang.cn.fragmetn;

import java.util.List;

import android.view.View;

import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.R;
import com.wang.cn.base.BaseFragment;
import com.wang.cn.utils.UIUtils;

public class AppFragment extends BaseFragment {

	@Override
	public View createSuccessView() {
		return UIUtils.inflate(R.layout.activity_main);
	}
	/**
	 * 请求服务器获取数据
	 */
	@Override
	public LoadResult load() {

		return LoadResult.SUCCESS;
	}

}
