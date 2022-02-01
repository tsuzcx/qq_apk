package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;

public class ArkAppLoadLayout
  extends RelativeLayout
{
  public static int bSA = -2565408;
  public static int bSB = -2565408;
  public static Paint sPaint = new Paint(1);
  private RectF ag = new RectF();
  int bSC = -2565408;
  public boolean bgD;
  private Path mPath = new Path();
  private ArkViewImplement mViewImpl;
  
  public ArkAppLoadLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint;
    if (!this.bgD)
    {
      localPaint = sPaint;
      if (!isPressed()) {
        break label44;
      }
    }
    label44:
    for (int i = bSA;; i = this.bSC)
    {
      localPaint.setColor(i);
      paramCanvas.drawPath(this.mPath, sPaint);
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.bgD)
    {
      this.ag.set(0.0F, 0.0F, View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      this.mPath.reset();
      this.mViewImpl.makePath(this.ag, this.mPath);
    }
  }
  
  public void setArkView(ArkViewImplement paramArkViewImplement)
  {
    this.mViewImpl = paramArkViewImplement;
    setWillNotDraw(false);
  }
  
  public void setBkgColorNormal(int paramInt)
  {
    this.bSC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout
 * JD-Core Version:    0.7.0.1
 */