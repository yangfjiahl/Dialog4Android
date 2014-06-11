/**
* @Title: AlertDialog.java
* @Description: TODO
* @author: Calvinyang
* @date: Jun 4, 2014 11:26:47 AM
* Copyright: Copyright (c) 2013
* @version: 1.0
*/
package cn.edu.fudan.calvin;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

/**
 * @author: Calvinyang
 * @Description: 提醒框
 * @date: Jun 4, 2014 11:26:47 AM
 */
public class AlertDialog extends Dialog {
	private Context context;
	private String hint;
	
	/**
	 * @param context
	 */
	private AlertDialog(Context context) {
		super(context, R.style.dialog_style);
		this.context = context;
	}

	/**
	 * @param context
	 * @param hint
	 */
	public AlertDialog(Context context, String hint) {
		this(context);
		this.hint = hint;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_alert);
		Window window = getWindow();
		LayoutParams params = window.getAttributes();
		params.gravity = Gravity.CENTER;
		params.width = (int) (CommonUtils.getWidth(context) - 100 * CommonUtils.getDensity(context));
		params.height = (int) (CommonUtils.getDensity(context) * (hint.length() / 12 * 30 + 120));
		window.setAttributes(params);
		TextView tv = (TextView) findViewById(R.id.alert_content);
		tv.setText(hint);
		setCancelable(false);
		findViewById(R.id.alert_ok).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				dismiss();
			}
		});
	}
}
