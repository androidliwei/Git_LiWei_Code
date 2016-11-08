package com.wang.cn.base;

import com.example.every_text.view.LoadingPager;
import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.R;
import com.wang.cn.utils.UIUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author wang
 * @version 创建时间：2015年7月8日 上午11:31:11 类说明
 */
public abstract class BaseActivity extends Activity {
	public LoadingPager loadingPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		loadingPage = new LoadingPager(UIUtils.getContext(),
				R.layout.loadpage_loading, R.layout.loadpage_error,
				R.layout.loadpage_empty) {
			@Override
			protected LoadResult load() {
				return BaseActivity.this.load();
			}
			@Override
			protected View createSuccessView() {
				return BaseActivity.this.createSuccessView();
			}
		};
//		可以点击
		loadingPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				loadingPage.show();
			}
		});
//		显示 loading的页面
		loadingPage.show();
		setContentView(loadingPage);
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
