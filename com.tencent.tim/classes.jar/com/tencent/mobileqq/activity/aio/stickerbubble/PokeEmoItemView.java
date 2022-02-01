package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import wja;

public class PokeEmoItemView
  extends View
  implements Runnable
{
  private long JR;
  public int bYL;
  public int bYM;
  private int bYN = 200;
  private boolean bmp;
  public Paint bp;
  private Drawable dX;
  public int mImgWidth;
  private boolean mIsSend;
  public Paint mStrokePaint;
  public String mText;
  public int mTextWidth;
  
  public PokeEmoItemView(Context paramContext)
  {
    super(paramContext);
    this.bYM = wja.dp2px(16.0F, paramContext.getResources());
    this.mImgWidth = wja.dp2px(80.0F, paramContext.getResources());
    this.bYL = wja.dp2px(2.0F, paramContext.getResources());
    this.bp = new Paint();
    this.bp.setAntiAlias(true);
    this.bp.setColor(Color.parseColor("#FFDC4F"));
    this.bp.setTextSize(wja.dp2px(24.0F, paramContext.getResources()));
    this.mStrokePaint = new Paint(this.bp);
    this.mStrokePaint.setStyle(Paint.Style.STROKE);
    this.mStrokePaint.setColor(Color.parseColor("#418DFF"));
    this.mStrokePaint.setStrokeWidth(wja.dp2px(4.0F, paramContext.getResources()));
  }
  
  private float f(long paramLong)
  {
    if (this.JR == 0L) {
      return 0.0F;
    }
    double d = (paramLong - this.JR) % 400L / 400.0D * 20.0D;
    if (d < 10.0D) {}
    for (d -= 5.0D;; d = 10.0D - (d - 10.0D) - 5.0D) {
      return (float)d;
    }
  }
  
  public boolean Tx()
  {
    return this.bmp;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = this.mText;
    int i = getMeasuredWidth();
    int j = this.mTextWidth;
    int m = this.mImgWidth;
    int n = this.mTextWidth;
    int i1 = this.bYM;
    int i2 = this.bYL;
    int k = paramCanvas.save();
    if (this.mIsSend) {
      paramCanvas.translate(i - m - (n - i1) - i2, 0.0F);
    }
    if (this.dX != null) {
      this.dX.draw(paramCanvas);
    }
    long l = SystemClock.uptimeMillis();
    m = this.mImgWidth - this.bYM;
    Paint.FontMetricsInt localFontMetricsInt = this.bp.getFontMetricsInt();
    n = getMeasuredHeight() - localFontMetricsInt.descent - 4;
    paramCanvas.rotate(f(l), j / 2 + m, localFontMetricsInt.ascent / 2 + n);
    paramCanvas.drawText(str, m, n, this.mStrokePaint);
    paramCanvas.drawText(str, m, n, this.bp);
    if (QLog.isDevelopLevel()) {
      QLog.d("PokeEmoItemView", 4, String.format("mImgWidth:%d,measureW:%d,mTextWidth:%d,mTextOffset:%d,left:%d,mText:%s", new Object[] { Integer.valueOf(this.mImgWidth), Integer.valueOf(i), Integer.valueOf(this.mTextWidth), Integer.valueOf(this.bYM), Integer.valueOf(m), this.mText }));
    }
    paramCanvas.restoreToCount(k);
    if (this.JR == 0L) {
      this.JR = l;
    }
    postDelayed(this, this.bYN);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void run()
  {
    if (getVisibility() == 0) {
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, this.mImgWidth, this.mImgWidth);
    }
    this.dX = paramDrawable;
    invalidate(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mTextWidth = ((int)this.bp.measureText(paramString));
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
    for (;;)
    {
      this.mText = paramString;
      return;
      this.mTextWidth = 0;
    }
  }
  
  public void setTypeFace(Typeface paramTypeface)
  {
    if (this.bmp) {}
    while (paramTypeface == null) {
      return;
    }
    this.bmp = true;
    this.bp.setTypeface(paramTypeface);
    this.mStrokePaint.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView
 * JD-Core Version:    0.7.0.1
 */