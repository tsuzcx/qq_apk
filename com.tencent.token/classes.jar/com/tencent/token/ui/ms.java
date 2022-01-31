package com.tencent.token.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.token.af;
import com.tencent.token.utils.t;

final class ms
  implements Runnable
{
  ms(IndexActivity paramIndexActivity) {}
  
  public final void run()
  {
    int i = this.a.getWindowManager().getDefaultDisplay().getWidth();
    int j = this.a.getWindowManager().getDefaultDisplay().getHeight();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    t.b(this.a.mLocalConfig);
    af.a().a(i, j, localDisplayMetrics.densityDpi, IndexActivity.access$300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ms
 * JD-Core Version:    0.7.0.1
 */