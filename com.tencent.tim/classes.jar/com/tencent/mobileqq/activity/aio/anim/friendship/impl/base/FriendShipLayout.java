package com.tencent.mobileqq.activity.aio.anim.friendship.impl.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class FriendShipLayout
  extends FrameLayout
{
  a b;
  
  public FriendShipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendShipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      this.b.bZT();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void setBackListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bZT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout
 * JD-Core Version:    0.7.0.1
 */