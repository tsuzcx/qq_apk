package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import wja;

public class MoveDistIndicateView
  extends ImageView
{
  public int bQm;
  public int bQn;
  private int bQo;
  private Rect be = new Rect();
  private Bitmap dT;
  private Bitmap dU;
  private Paint mPaint;
  private int mRadius;
  private Matrix matrix = new Matrix();
  private int type;
  
  public MoveDistIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    paramContext = getResources();
    this.bQm = wja.dp2px(29.0F, paramContext);
    this.bQn = wja.dp2px(42.0F, paramContext);
    this.bQo = wja.dp2px(10.0F, paramContext);
    this.mRadius = this.bQm;
    if (QLog.isDevelopLevel()) {
      QLog.d("MoveDistIndicateView", 4, "init(), mRaidusMin:" + this.bQm + ",mRaidusMax:" + this.bQn);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    int m = i / 2;
    int n = j / 2;
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    float f1;
    if (this.mRadius > this.bQm + this.bQo) {
      if (this.dU != null)
      {
        f1 = this.bQn / this.bQm;
        this.matrix.reset();
        m = this.dU.getWidth();
        n = this.dU.getHeight();
        this.matrix.setScale(f1, f1);
        this.matrix.postTranslate((i - m * f1) / 2.0F, (j - f1 * n) / 2.0F);
        this.be.set(0, 0, m, n);
        paramCanvas.concat(this.matrix);
        paramCanvas.drawBitmap(this.dU, null, this.be, null);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      super.onDraw(paramCanvas);
      return;
      if (this.type == 1) {
        this.mPaint.setColor(getResources().getColor(2131167413));
      }
      for (;;)
      {
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.mRadius, this.mPaint);
        break;
        this.mPaint.setColor(getResources().getColor(2131167414));
      }
      if (this.mRadius > this.bQm)
      {
        this.mPaint.setColor(getResources().getColor(2131167303));
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.bQm, this.mPaint);
      }
      else
      {
        if (this.dT == null) {
          break;
        }
        f1 = this.mRadius / this.bQm;
        this.matrix.reset();
        m = this.dT.getWidth();
        n = this.dT.getHeight();
        float f2 = (i - m * f1) * 0.5F + 0.5F;
        float f3 = (j - n * f1) * 0.5F + 0.5F;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "dx is:" + f2 + ",dy is:" + f3);
        }
        this.matrix.setScale(f1, f1);
        this.matrix.postTranslate(f2, f3);
        this.be.set(0, 0, m, n);
        paramCanvas.concat(this.matrix);
        paramCanvas.drawBitmap(this.dT, null, this.be, null);
      }
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.mPaint.setColor(-16711423);
    }
    for (;;)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(m, n, this.mRadius, this.mPaint);
      break;
      this.mPaint.setColor(-1);
    }
  }
  
  public void setAfterBitmap(Bitmap paramBitmap)
  {
    this.dU = paramBitmap;
  }
  
  public void setLevel(int paramInt)
  {
    this.mRadius = (this.bQm + (this.bQn - this.bQm) * paramInt / 100);
    if (QLog.isDevelopLevel()) {
      QLog.d("MoveDistIndicateView", 4, "setLevel(), max=" + this.bQn + " min=" + this.bQm + " mRadius=" + this.mRadius + " type =" + this.type + " level=" + paramInt);
    }
    if (this.mRadius > this.bQm + this.bQo) {
      setPressed(true);
    }
    for (;;)
    {
      invalidate();
      return;
      setPressed(false);
    }
  }
  
  public void setScaleBitmap(Bitmap paramBitmap)
  {
    this.dT = paramBitmap;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView
 * JD-Core Version:    0.7.0.1
 */