package com.example.himatsubushi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// リニアレイアウト定義
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setGravity(Gravity.CENTER);


		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WC, WC);


		// テキスト表示
		TextView title = new TextView(this);
		layoutParams.setMargins((int)DPtoPX(0), (int)DPtoPX(0), (int)DPtoPX(0), (int)DPtoPX(100));
		title.setLayoutParams(layoutParams);

		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
		// ディスプレイのインスタンス生成
		Display disp = wm.getDefaultDisplay();
		Point size = new Point();
		disp.getSize(size);

		title = SetMaxTextSize.setMaxTextSize(getString(R.string.app_name), title, getBaseContext().getResources().getDisplayMetrics().density, size.x);

		layout.addView(title);

		// 結果呼び出しボタン
		Button btn = new Button(this);
		btn.setText(R.string.what);
		btn.setOnClickListener(this);
		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(WC, WC);
		btn.setLayoutParams(layoutParams2);
		layout.addView(btn);

	}


	// 変換関数メソッド
	float DPtoPX(float dp){
		float d = getBaseContext().getResources().getDisplayMetrics().density;
		return dp * d;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view){

		Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
	}

}
