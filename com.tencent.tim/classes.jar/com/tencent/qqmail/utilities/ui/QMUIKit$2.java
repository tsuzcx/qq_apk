package com.tencent.qqmail.utilities.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

final class QMUIKit$2
  implements Runnable
{
  QMUIKit$2(View paramView1, View paramView2) {}
  
  public void run()
  {
    if ((this.val$targetView != null) && (this.val$parentView != null))
    {
      Rect localRect = new Rect();
      this.val$targetView.getHitRect(localRect);
      View localView1 = (View)this.val$targetView.getParent();
      View localView2 = localView1.getRootView();
      while ((localView1 != null) && (localView1 != this.val$parentView) && (localView1.getParent() != localView2))
      {
        localRect.offset(localView1.getLeft(), localView1.getTop());
        localView1 = (View)localView1.getParent();
      }
      int i = Math.min(localRect.width() / 2, localRect.height() / 2);
      localRect.left -= i;
      localRect.top -= i;
      localRect.right += i;
      localRect.bottom = (i + localRect.bottom);
      this.val$parentView.setTouchDelegate(new TouchDelegate(localRect, this.val$targetView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIKit.2
 * JD-Core Version:    0.7.0.1
 */