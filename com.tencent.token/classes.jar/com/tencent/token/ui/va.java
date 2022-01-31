package com.tencent.token.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

class va
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  va(RealNameFindActivity paramRealNameFindActivity, ScrollView paramScrollView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.getRootView().getHeight() - this.a.getHeight() < this.a.getMeasuredHeight() / 3) && (!RealNameFindActivity.access$300(this.b))) {
      RealNameFindActivity.access$3100(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.va
 * JD-Core Version:    0.7.0.1
 */