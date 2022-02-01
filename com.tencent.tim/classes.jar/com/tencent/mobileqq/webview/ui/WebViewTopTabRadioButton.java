package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RadioButton;
import aqcx;

public class WebViewTopTabRadioButton
  extends RadioButton
{
  public volatile boolean cYV;
  Bitmap fe;
  Bitmap gD;
  int mLeft = 0;
  int mTop = aqcx.dip2px(super.getContext(), 2.0F);
  
  public WebViewTopTabRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  Bitmap e(Context paramContext)
  {
    if ((this.gD == null) || (this.gD.isRecycled())) {}
    try
    {
      this.gD = BitmapFactory.decodeResource(paramContext.getResources(), 2130851400);
      return this.gD;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.cYV)
    {
      this.fe = e(super.getContext());
      if ((this.fe != null) && (!this.fe.isRecycled())) {
        paramCanvas.drawBitmap(this.fe, this.mLeft, this.mTop, null);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.fe = e(super.getContext());
    if ((this.fe == null) || (this.fe.isRecycled())) {}
    for (paramInt2 = aqcx.dip2px(super.getContext(), 9.0F);; paramInt2 = this.fe.getWidth())
    {
      this.mLeft = (paramInt1 - paramInt2 - aqcx.dip2px(super.getContext(), 3.0F));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabRadioButton
 * JD-Core Version:    0.7.0.1
 */