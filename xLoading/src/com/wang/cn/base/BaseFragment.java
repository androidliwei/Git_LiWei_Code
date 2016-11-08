package com.wang.cn.base;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.example.every_text.view.LoadingPager;
import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.R;
import com.wang.cn.utils.UIUtils;
import com.wang.cn.utils.ViewUtils;

public abstract class BaseFragment extends Fragment {

	private LoadingPager loadingPage;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (loadingPage == null) { // 之前的frameLayout 已经记录了一个爹了 爹是之前的ViewPager
			loadingPage = new LoadingPager(UIUtils.getContext(),
					R.layout.loadpage_loading, R.layout.loadpage_error,
					R.layout.loadpage_empty) {
				@Override
				protected LoadResult load() {
					return BaseFragment.this.load();
				}

				@Override
				protected View createSuccessView() {
					return BaseFragment.this.createSuccessView();
				}
			};
			loadingPage.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					loadingPage.show();
				}
			});
		} else {
			ViewUtils.removeSelfFromParent(loadingPage);// 移除frameLayout之前的爹
		}
		return loadingPage;
	}

	public void show() {
		if (loadingPage != null) {
			loadingPage.show();
		}
	}

	/**
	 * 刷新页面工程
	 * 
	 * @return
	 */
	protected abstract View createSuccessView();

	/**
	 * 请求服务器 获取当前状态
	 * 
	 */
	protected abstract LoadResult load();

}
