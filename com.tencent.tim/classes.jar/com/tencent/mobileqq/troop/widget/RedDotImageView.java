package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class RedDotImageView
  extends ImageView
{
  private boolean MX;
  private Drawable bL;
  private boolean cSF;
  protected Paint cr;
  private int dXe = 0;
  private int dXf = 13;
  private int dXg = 13;
  protected int dXh;
  protected int dXi;
  private int dXj;
  protected Drawable fJ;
  protected float mCharHeight;
  private float mDensity = getResources().getDisplayMetrics().density;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((QLog.isColorLevel()) && (toString().contains("qq_aio_panel_image"))) {
      QLog.d("Q.recent", 2, " onDraw() : " + this.dXi + ",isShownBorder" + this.cSF + "，this = " + this);
    }
    int j;
    int i;
    if ((this.MX) && (this.bL != null))
    {
      this.bL.setState(getDrawableState());
      if (this.dXe != 0) {
        break label385;
      }
      j = (int)Math.ceil(getWidth() * 0.5D + this.mDensity * this.dXf - this.bL.getIntrinsicWidth() * 0.5D);
      i = (int)Math.ceil(getHeight() * 0.5D - this.mDensity * this.dXg - this.bL.getIntrinsicHeight() * 0.5D);
    }
    for (;;)
    {
      this.bL.setBounds(j, i, this.bL.getIntrinsicWidth() + j, this.bL.getIntrinsicHeight() + i);
      this.bL.draw(paramCanvas);
      if ((this.dXi > 0) && (this.fJ != null))
      {
        this.fJ.setState(getDrawableState());
        i = getWidth();
        if (i <= this.dXh * 2) {
          break label463;
        }
      }
      label385:
      label463:
      for (i = (int)Math.ceil(i / 2);; i = (int)Math.ceil(i - this.dXh - this.dXj))
      {
        this.fJ.setBounds(i, 0, this.dXh + i, this.dXh);
        this.fJ.draw(paramCanvas);
        j = (int)Math.ceil(this.cr.measureText(String.valueOf(this.dXi)));
        int k = this.dXi;
        double d = i;
        paramCanvas.drawText(String.valueOf(k), (int)((this.dXh - j) * 0.5D + d), (int)(this.dXh - this.mCharHeight * 0.5D), this.cr);
        return;
        if (this.dXe != 1) {
          break label485;
        }
        j = (int)Math.ceil(getWidth() + this.mDensity * this.dXf - this.bL.getIntrinsicWidth() * 0.5D);
        i = (int)Math.ceil(-this.mDensity * this.dXg - this.bL.getIntrinsicHeight() * 0.5D);
        break;
      }
      label485:
      i = 0;
      j = 0;
    }
  }
  
  public boolean rL()
  {
    return this.MX;
  }
  
  public void setRedDotBase(int paramInt)
  {
    if (this.dXe != paramInt)
    {
      this.dXe = paramInt;
      postInvalidate();
    }
  }
  
  public void setRedDotDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.bL = paramDrawable;
    }
  }
  
  public void setReddotXOffsetDp(int paramInt)
  {
    if (paramInt != this.dXf)
    {
      this.dXf = paramInt;
      postInvalidate();
    }
  }
  
  public void setReddotYOffsetDp(int paramInt)
  {
    if (paramInt != this.dXg)
    {
      this.dXg = paramInt;
      postInvalidate();
    }
  }
  
  public void setShowBorder(boolean paramBoolean)
  {
    this.cSF = paramBoolean;
  }
  
  public void setUnreadNumber(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " setUnreadNumber() : " + paramInt + ",isShownBorder" + this.cSF + "，this = " + this);
    }
    if ((paramInt > 0) && (this.fJ == null))
    {
      this.dXh = ((int)(this.mDensity * 20.0F));
      this.dXj = ((int)(this.mDensity * 6.0F));
      this.cr = new Paint();
      this.cr.setAntiAlias(true);
      this.cr.setColor(-1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.cr.setColor(-1509949441);
      }
      this.cr.setStyle(Paint.Style.FILL);
      this.cr.setTextSize(this.mDensity * 12.0F);
      Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
      this.cr.getFontMetrics(localFontMetrics);
      this.mCharHeight = Math.abs(localFontMetrics.ascent);
      if (!this.cSF) {
        break label219;
      }
    }
    label219:
    for (this.fJ = getResources().getDrawable(2130846609);; this.fJ = getResources().getDrawable(2130850804))
    {
      this.dXi = paramInt;
      postInvalidate();
      return;
    }
  }
  
  public void showRedDot(boolean paramBoolean)
  {
    if (this.MX != paramBoolean)
    {
      this.MX = paramBoolean;
      if ((this.MX) && (this.bL == null)) {
        this.bL = getResources().getDrawable(2130851400);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, " showRedDot() : " + this.dXi + ",isShownBorder" + this.cSF + "，this = " + this);
      }
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView
 * JD-Core Version:    0.7.0.1
 */