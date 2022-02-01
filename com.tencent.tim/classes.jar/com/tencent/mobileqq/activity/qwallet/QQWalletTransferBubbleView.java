package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class QQWalletTransferBubbleView
  extends RelativeLayout
{
  LightingColorFilter a;
  boolean bux;
  int cfx;
  int mAlpha = 255;
  
  public QQWalletTransferBubbleView(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public QQWalletTransferBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {
      return;
    }
    Drawable localDrawable = getResources().getDrawable(this.cfx);
    localDrawable.setBounds(0, 0, getWidth(), getHeight());
    localDrawable.setColorFilter(this.a);
    localDrawable.setAlpha(this.mAlpha);
    if (this.bux)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getWidth() / 2, getHeight() / 2);
    localDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBubbleBackground(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.cfx = paramInt1;
    this.bux = paramBoolean;
    this.a = new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt2);
    this.mAlpha = 255;
  }
  
  public void setBubbleNightBackground(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.cfx = paramInt1;
    this.bux = paramBoolean;
    this.a = new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt2);
    this.mAlpha = 178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView
 * JD-Core Version:    0.7.0.1
 */