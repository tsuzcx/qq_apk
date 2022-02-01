package com.tencent.biz.pubaccount.readinjoy.common;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public final class ReadInJoyUtils$19
  implements Runnable
{
  public ReadInJoyUtils$19(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.val$view.setEnabled(true);
    this.val$view.getHitRect((Rect)localObject);
    ((Rect)localObject).left -= this.mQ;
    ((Rect)localObject).top -= this.dS;
    ((Rect)localObject).right += this.aMD;
    ((Rect)localObject).bottom += this.aME;
    localObject = new TouchDelegate((Rect)localObject, this.val$view);
    this.ke.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.19
 * JD-Core Version:    0.7.0.1
 */