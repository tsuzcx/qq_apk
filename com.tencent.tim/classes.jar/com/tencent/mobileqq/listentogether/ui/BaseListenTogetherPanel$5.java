package com.tencent.mobileqq.listentogether.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public final class BaseListenTogetherPanel$5
  implements Runnable
{
  public BaseListenTogetherPanel$5(View paramView) {}
  
  public void run()
  {
    Object localObject = new Rect();
    ((Rect)localObject).setEmpty();
    localObject = new TouchDelegate((Rect)localObject, this.val$view);
    if (View.class.isInstance(this.val$view.getParent())) {
      ((View)this.val$view.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.5
 * JD-Core Version:    0.7.0.1
 */