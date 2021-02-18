package com.app5kmezmur;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelpMe extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_me);
		getActionBar().setHomeButtonEnabled(true);

		TextView text = new TextView(this);
		text.setText("እርዳታ");
		text.setTextSize(16);
		text.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/gfzemenu.ttf"));
		text.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getActionBar().setCustomView(text);
		ColorDrawable col = new ColorDrawable(Color.parseColor("#365674"));
		getActionBar().setBackgroundDrawable(col);
		getActionBar().setIcon(R.drawable.ic_arrow_back_white2);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		final WebView wv = (WebView) findViewById(R.id.webView1);
		WebSettings settings = wv.getSettings();
		settings.setJavaScriptEnabled(true);

		settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(true);
		settings.setAllowUniversalAccessFromFileURLs(true);
		wv.loadUrl("file:///android_asset/help.html");

	}

	public boolean onOptionsItemSelected(final MenuItem item) {
		final WebView wv = (WebView) findViewById(R.id.webView1);
		WebSettings settings = wv.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(true);
		switch (item.getItemId()) {
		case android.R.id.home:
			// API 5+ solution
			onBackPressed();
			return true;
		case R.id.help:
			wv.loadUrl("file:///android_asset/help2.html");
			item.setIcon(android.R.drawable.radiobutton_on_background);

			item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

				@Override
				public boolean onMenuItemClick(MenuItem arg0) {
					// TODO Auto-generated method stub

					wv.loadUrl("file:///android_asset/help.html");
					item.setIcon(android.R.drawable.radiobutton_off_background);
					item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

						@Override
						public boolean onMenuItemClick(MenuItem arg0) {
							// TODO Auto-generated method stub

							wv.loadUrl("file:///android_asset/help2.html");
							item.setIcon(android.R.drawable.radiobutton_on_background);
							item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

								@Override
								public boolean onMenuItemClick(MenuItem arg0) {

									wv.loadUrl("file:///android_asset/help.html");
									item.setIcon(android.R.drawable.radiobutton_off_background);
									item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

										@Override
										public boolean onMenuItemClick(
												MenuItem arg0) {

											wv.loadUrl("file:///android_asset/help2.html");
											item.setIcon(android.R.drawable.radiobutton_on_background);
											item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

												@Override
												public boolean onMenuItemClick(
														MenuItem arg0) {

													wv.loadUrl("file:///android_asset/help.html");
													item.setIcon(android.R.drawable.radiobutton_off_background);
													item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

														@Override
														public boolean onMenuItemClick(
																MenuItem arg0) {

															wv.loadUrl("file:///android_asset/help2.html");
															item.setIcon(android.R.drawable.radiobutton_on_background);
															item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

																@Override
																public boolean onMenuItemClick(
																		MenuItem arg0) {

																	wv.loadUrl("file:///android_asset/help.html");
																	item.setIcon(android.R.drawable.radiobutton_off_background);
																	return true;
																}
															});
															return true;
														}
													});
													return true;
												}
											});
											return true;
										}
									});
									return true;
								}
							});
							return true;
						}
					});
					return true;
				}
			});

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help_me, menu);
		return true;
	}

}
