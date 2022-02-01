package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import asch;

public class KeyboardDetectorRelativeLayout
  extends RelativeLayout
{
  protected asch a;
  protected Rect rect;
  
  public KeyboardDetectorRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.rect == null) {
      this.rect = new Rect();
    }
  }
  
  public void a(asch paramasch)
  {
    this.a = paramasch;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Activity localActivity = (Activity)super.getContext();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.rect);
    int j = this.rect.top;
    int k = localActivity.getWindowManager().getDefaultDisplay().getHeight();
    if ((this.a != null) && (i != 0))
    {
      if (k - j - i <= 100) {
        break label112;
      }
      this.a.Zk(Math.abs(this.rect.height()) - getPaddingBottom() - getPaddingTop());
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label112:
      this.a.elc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.widget.KeyboardDetectorRelativeLayout
 * JD-Core Version:    0.7.0.1
 */