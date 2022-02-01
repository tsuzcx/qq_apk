package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class BubbleViewLayout
  extends RelativeLayout
{
  float[] aC;
  private boolean cZA = true;
  private boolean cZv = true;
  public boolean mIsSend = true;
  Path mPath;
  private float mRadius = 30.0F;
  RectF mRect;
  private Resources mRes;
  private Paint x;
  private Paint y;
  
  public BubbleViewLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BubbleViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    this.x = new Paint();
    this.x.setColor(-1);
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.y = new Paint();
    this.y.setXfermode(null);
    this.mPath = new Path();
    this.mRect = new RectF();
    this.aC = new float[8];
    this.mRes = getResources();
    setRadius(15.0F);
    setWillNotDraw(false);
  }
  
  public void TE(boolean paramBoolean)
  {
    this.cZv = paramBoolean;
  }
  
  public void TF(boolean paramBoolean)
  {
    this.cZA = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((Build.VERSION.SDK_INT == 28) || (Build.VERSION.SDK_INT == 29))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.mPath);
      super.dispatchDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.y, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawPath(this.mPath, this.x);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      onResize(getWidth(), getHeight());
    }
  }
  
  public void onResize(float paramFloat1, float paramFloat2)
  {
    if (!this.cZv)
    {
      this.mRect.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      if (this.cZA)
      {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      }
      return;
    }
    Resources localResources = this.mRes;
    float f1 = dp2px(10.0F, localResources);
    float f2;
    if (this.mIsSend)
    {
      this.mRect.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.mPath.reset();
      paramFloat2 = dp2px(5.0F, localResources);
      if (!this.mIsSend) {
        break label267;
      }
      this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      f1 = dp2px(14.0F, localResources);
      f2 = dp2px(8.0F, localResources);
      this.mPath.moveTo(paramFloat1 - f1, f2);
      f1 = dp2px(4.0F, localResources);
      f2 = dp2px(10.0F, localResources);
      this.mPath.quadTo(paramFloat1 - f1, f2, paramFloat1, paramFloat2);
      paramFloat2 = dp2px(10.0F, localResources);
      f1 = dp2px(16.0F, localResources);
      f2 = dp2px(1.0F, localResources);
      float f3 = dp2px(14.0F, localResources);
      this.mPath.quadTo(paramFloat1 - f2, f3, paramFloat1 - paramFloat2, f1);
    }
    for (;;)
    {
      this.mPath.close();
      return;
      this.mRect.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label267:
      this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CCW);
      paramFloat1 = dp2px(14.0F, localResources);
      f1 = dp2px(8.0F, localResources);
      this.mPath.moveTo(paramFloat1, f1);
      paramFloat1 = dp2px(4.0F, localResources);
      f1 = dp2px(10.0F, localResources);
      this.mPath.quadTo(paramFloat1, f1, 0.0F, paramFloat2);
      paramFloat1 = dp2px(10.0F, localResources);
      paramFloat2 = dp2px(16.0F, localResources);
      f1 = dp2px(1.0F, localResources);
      f2 = dp2px(14.0F, localResources);
      this.mPath.quadTo(f1, f2, paramFloat1, paramFloat2);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null) {
      Arrays.fill(this.aC, this.mRadius);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null)
    {
      Arrays.fill(this.aC, 0, 4, this.mRadius);
      Arrays.fill(this.aC, 4, 8, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleViewLayout
 * JD-Core Version:    0.7.0.1
 */