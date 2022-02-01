package com.tencent.qbardemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.token.aad;
import com.tencent.token.ui.IndexActivity;

public class RectView
  extends View
{
  private static final long ANIMATION_DELAY = 20L;
  private static final int K_ROUND_TIME = 5;
  private int CORNER_HEIGHT = 12;
  private int CORNER_WIDTH = 32;
  private int bottom;
  private int height;
  private int left;
  private final int mCornerColor;
  private boolean mIsDrawLineImg = true;
  private long mLastTime = 0L;
  private final int mMaskColor;
  private Bitmap mScanLine = null;
  private Paint pen;
  private int right;
  private int top;
  private int width;
  
  public RectView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    double d = paramInt1;
    Double.isNaN(d);
    this.width = ((int)(d * 0.6D));
    d = this.width;
    Double.isNaN(d);
    this.height = ((int)(d * 1.0D));
    this.top = ((paramInt2 - this.height - IndexActivity.S_STATUS_HEIGHT - IndexActivity.S_TITLE_HEIGHT) / 2);
    this.bottom = ((paramInt2 + this.height - IndexActivity.S_STATUS_HEIGHT - IndexActivity.S_TITLE_HEIGHT) / 2);
    paramInt2 = this.width;
    this.left = ((paramInt1 - paramInt2) / 2);
    this.right = ((paramInt1 + paramInt2) / 2);
    this.pen = new Paint();
    paramContext = getResources();
    this.mMaskColor = paramContext.getColor(2130968810);
    this.mCornerColor = paramContext.getColor(2130968626);
  }
  
  public Paint getPen()
  {
    return this.pen;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    this.pen.setColor(this.mMaskColor);
    float f1 = IndexActivity.S_DENSITY;
    float f2 = i;
    paramCanvas.drawRect(0.0F, f1 * 50.0F, f2, this.top, this.pen);
    paramCanvas.drawRect(0.0F, this.top, this.left, this.bottom + 1, this.pen);
    paramCanvas.drawRect(this.right + 1, this.top, f2, this.bottom + 1, this.pen);
    paramCanvas.drawRect(0.0F, this.bottom + 1, f2, j, this.pen);
    if (this.mScanLine == null) {
      this.mScanLine = aad.a(getResources(), 2131100097, this.width);
    }
    Object localObject = getResources().getString(2131493002);
    this.pen.setColor(getResources().getColor(2130968665));
    this.pen.setTextSize(getResources().getDimension(2131034250));
    paramCanvas.drawText((String)localObject, (f2 - this.pen.measureText((String)localObject)) / 2.0F, this.bottom + IndexActivity.S_DENSITY * 30.0F, this.pen);
    j = this.CORNER_HEIGHT / 2;
    this.pen.setColor(this.mCornerColor);
    int k = this.left;
    f1 = k - j;
    int m = this.top;
    paramCanvas.drawRect(f1, m - j, k + this.CORNER_WIDTH - j, m + this.CORNER_HEIGHT - j, this.pen);
    k = this.left;
    f1 = k - j;
    m = this.top;
    paramCanvas.drawRect(f1, m - j, k + this.CORNER_HEIGHT - j, m + this.CORNER_WIDTH - j, this.pen);
    k = this.left;
    f1 = k - j;
    m = this.bottom;
    paramCanvas.drawRect(f1, m - this.CORNER_HEIGHT + j, k + this.CORNER_WIDTH - j, m + 1 + j, this.pen);
    k = this.left;
    f1 = k - j;
    m = this.bottom;
    paramCanvas.drawRect(f1, m - this.CORNER_WIDTH + j, k + this.CORNER_HEIGHT - j, m + 1 + j, this.pen);
    k = this.right;
    f1 = k - this.CORNER_HEIGHT + j;
    m = this.top;
    paramCanvas.drawRect(f1, m - j, k + 1 + j, m + this.CORNER_WIDTH - j, this.pen);
    k = this.right;
    f1 = k - this.CORNER_WIDTH + j;
    m = this.top;
    paramCanvas.drawRect(f1, m - j, k + 1 + j, m + this.CORNER_HEIGHT - j, this.pen);
    k = this.right;
    f1 = k - this.CORNER_HEIGHT + j;
    m = this.bottom;
    paramCanvas.drawRect(f1, m - this.CORNER_WIDTH + j, k + 1 + j, m + 1 + j, this.pen);
    k = this.right;
    f1 = k - this.CORNER_WIDTH + j;
    m = this.bottom;
    paramCanvas.drawRect(f1, m - this.CORNER_HEIGHT + j, k + 1 + j, m + 1 + j, this.pen);
    if ((this.mScanLine != null) && (this.mIsDrawLineImg))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mLastTime;
      if (l2 == 0L)
      {
        this.mLastTime = l1;
      }
      else
      {
        l1 -= l2;
        j = ((int)(l1 / 1000L) % 5 * 1000 + (int)(l1 % 1000L)) * this.height / 5000;
        localObject = this.mScanLine;
        paramCanvas.drawBitmap((Bitmap)localObject, (i - this.width) / 2, this.top + j - ((Bitmap)localObject).getHeight(), this.pen);
      }
      postInvalidateDelayed(20L, this.left, this.top, this.right, this.bottom);
    }
  }
  
  public void setDrawLineImage(boolean paramBoolean)
  {
    this.mIsDrawLineImg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.RectView
 * JD-Core Version:    0.7.0.1
 */