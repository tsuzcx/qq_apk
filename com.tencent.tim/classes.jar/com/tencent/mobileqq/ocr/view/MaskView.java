package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import wja;

public class MaskView
  extends View
{
  private RectF aG;
  private Rect cg;
  private Rect ch;
  private boolean ctn;
  private boolean cto;
  private int doc;
  private Drawable fd;
  private Drawable fe;
  private Paint mPaint = new Paint();
  
  public MaskView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.fd = getResources().getDrawable(2130846533);
    this.doc = wja.dp2px(3.0F, getResources());
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int j;
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = localDisplayMetrics.widthPixels;
      i = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      int k = j - wja.dp2px(18.0F, getResources());
      int m = k * 424 / 680;
      int n = (j - k) / 2 + 0;
      int i1 = (i - m) / 2 + 0;
      this.cg = new Rect(n, i1, n + k, i1 + m);
      this.ch = new Rect(this.doc + n, this.doc + i1, k + n - this.doc, m + i1 - this.doc);
      this.aG = new RectF(this.ch.left * 1.0F / j, this.ch.top * 1.0F / i, this.ch.right * 1.0F / j, this.ch.bottom * 1.0F / i);
      if (QLog.isColorLevel()) {
        QLog.d("MaskView", 2, new Object[] { "MaskView init mBoxRect:", this.cg, " screenHeight: ", Integer.valueOf(i), " screenWidth: ", Integer.valueOf(j), "mPreviewRect:", this.ch, "mPreviewRectF:", this.aG });
      }
      return;
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
  }
  
  public Rect getPreviewRect()
  {
    return this.ch;
  }
  
  public RectF i()
  {
    return this.aG;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.ctn) {
      return;
    }
    if (this.cto) {
      this.mPaint.setColor(-16777216);
    }
    for (;;)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(new Rect(0, 0, getWidth(), this.ch.top), this.mPaint);
      paramCanvas.drawRect(new Rect(0, this.ch.bottom, getWidth(), getHeight()), this.mPaint);
      paramCanvas.drawRect(new Rect(0, this.ch.top, this.ch.left, this.ch.bottom), this.mPaint);
      paramCanvas.drawRect(new Rect(this.ch.right, this.ch.top, getHeight(), this.ch.bottom), this.mPaint);
      if ((this.fe == null) || (!this.cto)) {
        break;
      }
      this.fe.setBounds(this.ch);
      this.fe.draw(paramCanvas);
      return;
      this.mPaint.setColor(-2147483648);
    }
    this.fd.setBounds(this.cg);
    this.fd.draw(paramCanvas);
  }
  
  public void setIsDisplayRect(boolean paramBoolean)
  {
    this.ctn = paramBoolean;
  }
  
  public void setModel(boolean paramBoolean)
  {
    this.cto = paramBoolean;
    if (!this.cto) {
      this.fe = null;
    }
    invalidate();
  }
  
  public void setPreviewDrawable(Drawable paramDrawable)
  {
    this.fe = paramDrawable;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.MaskView
 * JD-Core Version:    0.7.0.1
 */