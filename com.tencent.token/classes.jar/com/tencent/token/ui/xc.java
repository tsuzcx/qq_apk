package com.tencent.token.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

class xc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  xc(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, ScrollView paramScrollView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.getRootView().getHeight() - this.a.getHeight() < this.a.getMeasuredHeight() / 3) && (!RealNameStep1InputNameIdActivity.access$500(this.b))) {
      RealNameStep1InputNameIdActivity.access$3200(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xc
 * JD-Core Version:    0.7.0.1
 */