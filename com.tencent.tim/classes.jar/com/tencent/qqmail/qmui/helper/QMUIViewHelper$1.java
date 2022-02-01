package com.tencent.qqmail.qmui.helper;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

final class QMUIViewHelper$1
  implements Runnable
{
  QMUIViewHelper$1(View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.left -= this.val$expendSize;
    localRect.top -= this.val$expendSize;
    localRect.right += this.val$expendSize;
    localRect.bottom += this.val$expendSize;
    this.val$parentView.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.helper.QMUIViewHelper.1
 * JD-Core Version:    0.7.0.1
 */