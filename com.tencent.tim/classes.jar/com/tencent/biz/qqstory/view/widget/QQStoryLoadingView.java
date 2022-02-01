package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import ram;
import rsq;

public class QQStoryLoadingView
  extends TextView
{
  protected AnimationDrawable l;
  protected Handler mHandler = new rsq(this, Looper.getMainLooper());
  
  public QQStoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setGravity(17);
    if ((a(this) == 0) && (!post(new QQStoryLoadingView.2(this)))) {
      setVisibility(0);
    }
  }
  
  public static void cI(Context paramContext)
  {
    int i = 0;
    while (i < 29)
    {
      paramContext.getResources().getDrawable(2130847441 + i);
      i += 1;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.mHandler.hasMessages(0)) {
      ram.d("QQStoryLoadingView", "ignore VISIBLE");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    String str2;
    String str1;
    if (super.getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      str2 = "QQStoryLoadingView" + System.identityHashCode(this);
      if (paramInt != 8) {
        break label87;
      }
      str1 = "GONE";
    }
    for (;;)
    {
      ram.b(str2, "setVisibility => %s", str1);
      if (paramInt != 0) {
        break;
      }
      startAnimation();
      return;
      label87:
      if (paramInt == 0) {
        str1 = "VISIBLE";
      } else {
        str1 = "INVISIBLE";
      }
    }
    stopAnimation();
  }
  
  public void setVisibilityDelay(int paramInt, long paramLong, String paramString)
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, paramInt, paramString), paramLong);
  }
  
  public void startAnimation()
  {
    int i = 0;
    try
    {
      if ((this.l == null) || (this.l.getNumberOfFrames() != 29))
      {
        this.l = new AnimationDrawable();
        while (i < 29)
        {
          this.l.addFrame(super.getResources().getDrawable(2130847441 + i), 50);
          i += 1;
        }
        this.l.setOneShot(false);
        super.setCompoundDrawablesWithIntrinsicBounds(null, this.l, null, null);
      }
      this.l.start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.l = null;
      ram.e("Q.qqstory.QQStoryLoadingView", "start animation error:" + localOutOfMemoryError);
    }
  }
  
  public void stopAnimation()
  {
    super.setCompoundDrawablesWithIntrinsicBounds(null, super.getResources().getDrawable(2130847441), null, null);
    if (this.l != null)
    {
      this.l.stop();
      int i = 0;
      while (i < this.l.getNumberOfFrames())
      {
        Drawable localDrawable = this.l.getFrame(i);
        if ((!(localDrawable instanceof BitmapDrawable)) || (localDrawable != null)) {
          localDrawable.setCallback(null);
        }
        i += 1;
      }
      this.l.setCallback(null);
      this.l = null;
    }
  }
  
  public int tW()
  {
    if (this.mHandler.hasMessages(0)) {
      return 0;
    }
    if (this.mHandler.hasMessages(4)) {
      return 4;
    }
    if (this.mHandler.hasMessages(8)) {
      return 8;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingView
 * JD-Core Version:    0.7.0.1
 */