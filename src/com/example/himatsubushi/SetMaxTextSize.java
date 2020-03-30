package com.example.himatsubushi;

import android.graphics.Paint;
import android.util.TypedValue;
import android.widget.TextView;

public class SetMaxTextSize {

	protected static final int MAX_FONT_SIZE = 39;

	/** 最小フォントサイズ **/

	protected static final int MIN_FONT_SIZE = 9;

	static TextView setMaxTextSize(String str, TextView tv, float density, float width) {

		Paint p = new Paint();

		for (int i = MAX_FONT_SIZE  ; i > MIN_FONT_SIZE  ; i = i-2) {

			p.setTextSize(i); //ここでPaintにテキストサイズを指定する

			width = width/density; //Dip単位に変換します

			if ((width >= p.measureText( str ))) { //Textviewの幅が

				tv.setText( str );

				int size = (int) ( i - (3*density));

				tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,size);

				break;

			}

		}

		return tv;

	}


}