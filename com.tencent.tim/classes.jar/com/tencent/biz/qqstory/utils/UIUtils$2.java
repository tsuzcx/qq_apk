package com.tencent.biz.qqstory.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public final class UIUtils$2
  implements Runnable
{
  public UIUtils$2(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.2
 * JD-Core Version:    0.7.0.1
 */