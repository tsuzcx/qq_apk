package com.tencent.qbardemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.x;

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
    this.width = ((int)(paramInt1 * 0.6D));
    this.height = ((int)(this.width * 1.0D));
    this.top = ((paramInt2 - this.height - IndexActivity.S_STATUS_HEIGHT - IndexActivity.S_TITLE_HEIGHT) / 2);
    this.bottom = ((this.height + paramInt2 - IndexActivity.S_STATUS_HEIGHT - IndexActivity.S_TITLE_HEIGHT) / 2);
    this.left = ((paramInt1 - this.width) / 2);
    this.right = ((this.width + paramInt1) / 2);
    this.pen = new Paint();
    paramContext = getResources();
    this.mMaskColor = paramContext.getColor(2131493074);
    this.mCornerColor = paramContext.getColor(2131492895);
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
    paramCanvas.drawRect(0.0F, 50.0F * IndexActivity.S_DENSITY, i, this.top, this.pen);
    paramCanvas.drawRect(0.0F, this.top, this.left, this.bottom + 1, this.pen);
    paramCanvas.drawRect(this.right + 1, this.top, i, this.bottom + 1, this.pen);
    paramCanvas.drawRect(0.0F, this.bottom + 1, i, j, this.pen);
    if (this.mScanLine == null) {
      this.mScanLine = x.a(getResources(), 2130837945, this.width);
    }
    String str = getResources().getString(2131230859);
    this.pen.setColor(getResources().getColor(2131492933));
    this.pen.setTextSize(getResources().getDimension(2131296400));
    float f = this.pen.measureText(str);
    paramCanvas.drawText(str, (i - f) / 2.0F, this.bottom + 30.0F * IndexActivity.S_DENSITY, this.pen);
    j = this.CORNER_HEIGHT / 2;
    this.pen.setColor(this.mCornerColor);
    paramCanvas.drawRect(this.left - j, this.top - j, this.left + this.CORNER_WIDTH - j, this.top + this.CORNER_HEIGHT - j, this.pen);
    paramCanvas.drawRect(this.left - j, this.top - j, this.left + this.CORNER_HEIGHT - j, this.top + this.CORNER_WIDTH - j, this.pen);
    paramCanvas.drawRect(this.left - j, this.bottom - this.CORNER_HEIGHT + j, this.left + this.CORNER_WIDTH - j, this.bottom + 1 + j, this.pen);
    paramCanvas.drawRect(this.left - j, this.bottom - this.CORNER_WIDTH + j, this.left + this.CORNER_HEIGHT - j, this.bottom + 1 + j, this.pen);
    paramCanvas.drawRect(this.right - this.CORNER_HEIGHT + j, this.top - j, this.right + 1 + j, this.top + this.CORNER_WIDTH - j, this.pen);
    paramCanvas.drawRect(this.right - this.CORNER_WIDTH + j, this.top - j, this.right + 1 + j, this.top + this.CORNER_HEIGHT - j, this.pen);
    paramCanvas.drawRect(this.right - this.CORNER_HEIGHT + j, this.bottom - this.CORNER_WIDTH + j, this.right + 1 + j, this.bottom + 1 + j, this.pen);
    paramCanvas.drawRect(this.right - this.CORNER_WIDTH + j, this.bottom - this.CORNER_HEIGHT + j, this.right + 1 + j, this.bottom + 1 + j, this.pen);
    long l;
    if ((this.mScanLine != null) && (this.mIsDrawLineImg))
    {
      l = System.currentTimeMillis();
      if (this.mLastTime != 0L) {
        break label723;
      }
      this.mLastTime = l;
    }
    for (;;)
    {
      postInvalidateDelayed(20L, this.left, this.top, this.right, this.bottom);
      return;
      label723:
      l -= this.mLastTime;
      j = (int)(l / 1000L);
      j = ((int)(l % 1000L) + j % 5 * 1000) * this.height / 5000;
      paramCanvas.drawBitmap(this.mScanLine, (i - this.width) / 2, j + this.top - this.mScanLine.getHeight(), this.pen);
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