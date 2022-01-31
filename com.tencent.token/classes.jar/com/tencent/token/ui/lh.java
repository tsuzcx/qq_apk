package com.tencent.token.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.token.cw;

class lh
  implements Runnable
{
  lh(IndexActivity paramIndexActivity) {}
  
  public void run()
  {
    int i = this.a.getWindowManager().getDefaultDisplay().getWidth();
    int j = this.a.getWindowManager().getDefaultDisplay().getHeight();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    cw.a().a(i, j, localDisplayMetrics.densityDpi, IndexActivity.access$100(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lh
 * JD-Core Version:    0.7.0.1
 */