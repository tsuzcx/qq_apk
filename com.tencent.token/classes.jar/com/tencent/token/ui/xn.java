package com.tencent.token.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

final class xn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  xn(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, ScrollView paramScrollView) {}
  
  public final void onGlobalLayout()
  {
    if ((this.a.getRootView().getHeight() - this.a.getHeight() < this.a.getMeasuredHeight() / 3) && (!RealNameStep1InputNameIdActivity.access$500(this.b))) {
      RealNameStep1InputNameIdActivity.access$2900(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xn
 * JD-Core Version:    0.7.0.1
 */