/**
 * @Title: MainACtivity.java
 * @Description: TODO
 * @author: Calvinyang
 * @date: Jun 11, 2014 2:04:54 PM
 * Copyright: Copyright (c) 2013
 * @version: 1.0
 */
package cn.edu.fudan.calvin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author: Calvinyang
 * @Description: TODO
 * @date: Jun 11, 2014 2:04:54 PM
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.alert).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new AlertDialog(MainActivity.this, "xxxx").show();
			}
		});
		findViewById(R.id.confirm).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final ConfirmDialog dlg = new ConfirmDialog(MainActivity.this, "xxxx ?");
				dlg.show();
				dlg.setButton("yes", "no !");
				dlg.setListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dlg.dismiss();
						Log.e("xxx", "yes");
					}
				}, new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dlg.dismiss();
						Log.e("xxx", "no");
					}
				});
			}
		});
	}
}
