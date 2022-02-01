package com.tencent.mobileqq.listentogether.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public final class BaseListenTogetherPanel$4
  implements Runnable
{
  public BaseListenTogetherPanel$4(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.val$view.setEnabled(true);
    this.val$view.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.dS;
    ((Rect)localObject).bottom += this.aME;
    ((Rect)localObject).left -= this.mQ;
    ((Rect)localObject).right += this.aMD;
    localObject = new TouchDelegate((Rect)localObject, this.val$view);
    if (View.class.isInstance(this.val$view.getParent())) {
      ((View)this.val$view.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4
 * JD-Core Version:    0.7.0.1
 */