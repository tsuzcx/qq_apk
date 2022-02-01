package com.tencent.biz.qqstory.album.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class RoundCornerLayout
  extends RelativeLayout
{
  public static final float[] DEFAULT_EDGE_CORDS = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  private static boolean aAv;
  RectF T;
  RectF U;
  public boolean aAu;
  float[] aC;
  private Paint aQ;
  Paint mPaint;
  Path mPath;
  private float mRadius;
  private Resources mRes;
  private Path u;
  
  static
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("BV0720")) || (str.contains("M821")) || ((Build.VERSION.SDK_INT == 21) && ((str.contains("NX511J")) || (str.contains("MI 5")) || (str.contains("GT-I9508")) || (str.contains("X9077")) || (str.contains("COOLPAD 8675-A"))))) {}
    for (boolean bool = true;; bool = false)
    {
      aAv = bool;
      return;
    }
  }
  
  public RoundCornerLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    this.aAu = aAv;
    this.mRes = getResources();
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setColor(-1);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.mPath = new Path();
    this.T = new RectF();
    this.U = new RectF();
    this.aC = new float[8];
    this.aQ = new Paint();
    this.aQ.setColor(-1);
    this.aQ.setAntiAlias(true);
    this.aQ.setStrokeWidth(4.0F);
    this.aQ.setStyle(Paint.Style.STROKE);
    this.u = new Path();
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    paramCanvas.drawPath(this.u, this.aQ);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.aAu)
    {
      setLayerType(1, null);
      return;
    }
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setLayerType(0, null);
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
    this.T.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.mPath.reset();
    this.mPath.addRoundRect(this.T, this.aC, Path.Direction.CW);
    this.U.set(2.0F, 2.0F, paramFloat1 - 2.0F, paramFloat2 - 2.0F);
    this.u.reset();
    this.u.addRoundRect(this.U, this.aC, Path.Direction.CW);
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null) {
      Arrays.fill(this.aC, this.mRadius);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.RoundCornerLayout
 * JD-Core Version:    0.7.0.1
 */