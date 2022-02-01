package com.tencent.biz;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import jnd;

public class PoiMapActivity$4$1
  implements Runnable
{
  public PoiMapActivity$4$1(jnd paramjnd) {}
  
  public void run()
  {
    this.a.this$0.aaC = false;
    this.a.this$0.mRootView.startAnimation(this.a.c);
    this.a.b.hideSoftInputFromWindow(this.a.this$0.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.4.1
 * JD-Core Version:    0.7.0.1
 */