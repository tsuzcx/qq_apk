package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import auvj;
import auvj.a;
import com.tencent.qphone.base.util.QLog;
import wja;

public class TroopLabelTextView
  extends TextView
  implements auvj.a
{
  public auvj a;
  protected int dXB;
  private int dlV;
  int dp2;
  private int dp5;
  private PorterDuffXfermode f;
  private Bitmap gu;
  private Canvas mCanvas;
  private Context mContext;
  private Paint paint;
  private Bitmap result;
  
  public TroopLabelTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.dXB = paramInt1;
    setTextColor(paramInt2);
    setMaxLines(1);
    setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, wja.dp2px(16.0F, getResources()));
    localLayoutParams.rightMargin = 4;
    paramInt2 = wja.dp2px(4.0F, getResources());
    int i = wja.dp2px(4.0F, getResources());
    int j = wja.dp2px(0.0F, getResources());
    int k = wja.dp2px(0.0F, getResources());
    setTextSize(1, 10.0F);
    if (paramInt3 == 2) {
      paramInt1 = wja.dp2px(10.0F, getResources());
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      setPadding(paramInt1, j, i, k);
      this.mContext = paramContext;
      this.dlV = paramInt3;
      this.dp2 = wja.dp2px(2.0F, this.mContext.getResources());
      this.dp5 = wja.dp2px(5.0F, this.mContext.getResources());
      aiL();
      return;
      paramInt1 = paramInt2;
      if (paramInt3 == 1)
      {
        setIncludeFontPadding(false);
        localLayoutParams.height = wja.dp2px(14.0F, getResources());
        paramInt1 = paramInt2;
      }
    }
  }
  
  private void aiL()
  {
    this.a = new auvj();
    this.a.setSupportMaskView(true);
    this.a.setMaskShape(auvj.euM);
  }
  
  public void L(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.a(paramCanvas, this);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.dlV == 2) && (this.gu != null))
    {
      this.paint.setXfermode(this.f);
      this.mCanvas.drawColor(this.dXB);
      this.mCanvas.drawBitmap(this.gu, 0.0F, 0.0F, this.paint);
      this.paint.setXfermode(null);
      paramCanvas.drawBitmap(this.result, 0.0F, 0.0F, this.paint);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3 + (getPaddingLeft() + getPaddingRight()), paramInt4);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (this.dlV == 1)
    {
      localGradientDrawable.setColor(this.dXB);
      localGradientDrawable.setCornerRadius(this.dp2);
      setBackgroundDrawable(localGradientDrawable);
    }
    do
    {
      return;
      if (this.dlV == 0)
      {
        localGradientDrawable.setStroke(2, this.dXB);
        localGradientDrawable.setCornerRadius(getHeight() / 2);
        setBackgroundDrawable(localGradientDrawable);
        return;
      }
    } while (this.dlV != 2);
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.dXB = paramInt1;
    setTextColor(paramInt2);
  }
  
  public void setMaskImage(int paramInt)
  {
    try
    {
      this.gu = BitmapFactory.decodeResource(getResources(), paramInt);
      this.result = Bitmap.createBitmap(this.gu.getWidth(), this.gu.getHeight(), Bitmap.Config.ARGB_8888);
      this.mCanvas = new Canvas(this.result);
      this.paint = new Paint(1);
      this.f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopLabelTextView", 2, "TroopLabelTextView setMaskImage OOM");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelTextView
 * JD-Core Version:    0.7.0.1
 */