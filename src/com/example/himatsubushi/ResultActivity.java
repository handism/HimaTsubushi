package com.example.himatsubushi;

import android.app.Activity;
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

public class ResultActivity extends Activity implements OnClickListener {

	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	private final int rand = 218; // 結果文章の数

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		makeView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void makeView(){

		// rand分乱数作成
		int random=(int)(Math.random()*rand);

		// リニアレイアウト定義
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setGravity(Gravity.CENTER);

		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WC, WC);
	    layoutParams.setMargins((int)DPtoPX(0), (int)DPtoPX(0), (int)DPtoPX(0), (int)DPtoPX(100));


	    // テキスト表示
		TextView title = new TextView(this);
		title.setLayoutParams(layoutParams);

		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
		// ディスプレイのインスタンス生成
		Display disp = wm.getDefaultDisplay();
		Point size = new Point();
		disp.getSize(size);


		title = SetMaxTextSize.setMaxTextSize(getString(R.string.H00001 + random), title, getBaseContext().getResources().getDisplayMetrics().density, size.x);

		layout.addView(title);

		//リニアで入れ子にする
		LinearLayout layout2 = new LinearLayout(this);
		layout2.setOrientation(LinearLayout.HORIZONTAL);
		layout2.setGravity(Gravity.CENTER);

		// もう一回ボタン
		Button b1 = makeButton("もう一回","0");
		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(WC, WC);
		layoutParams2.setMargins((int)DPtoPX(0), (int)DPtoPX(0), (int)DPtoPX(50), (int)DPtoPX(0));
		b1.setLayoutParams(layoutParams2);
		layout2.addView(b1);

		// 戻るボタン
		Button b2 = makeButton("　戻る　","1");
		layout2.addView(b2);

		layout.addView(layout2);
	}


	// 変換関数メソッド
	float DPtoPX(float dp){
		float d = getBaseContext().getResources().getDisplayMetrics().density;
		return dp * d;
	}

	private Button makeButton(String text, String tag){
		Button btn = new Button(this);
		btn.setText(text);
		btn.setTag(tag);
		btn.setOnClickListener(this);

		btn.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		return btn;
	}


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		int tag = Integer.parseInt((String)v.getTag());
		if(tag == 0){
			makeView();

		}else if (tag == 1){
			finish();
		}

	}

}
