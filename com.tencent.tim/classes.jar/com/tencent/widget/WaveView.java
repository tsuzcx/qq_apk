package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import auvo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class WaveView
  extends ImageView
{
  public static int dEg;
  public static int dEh;
  private Path O;
  private Path P;
  private Paint cn;
  private Paint co;
  private int dEi = -1249807;
  private int dEj = -1249807;
  public int dEk;
  public int dEl;
  private int dEm;
  private int dEn;
  private int dEo;
  private int dEp;
  private int dEq;
  private int dEr;
  private int dEs;
  private int dEt;
  private int dEu;
  private int dEv;
  public int euW;
  private int height;
  private float mDensity;
  private Handler mHandler = new Handler(new auvo(this));
  private int width;
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void dOH()
  {
    this.O.reset();
    this.O.moveTo(this.dEm, this.dEl);
    this.O.quadTo(this.dEm + this.dEo, this.dEl - this.dEk * 2, this.dEm + this.dEp, this.dEl);
    this.O.quadTo(this.dEm + this.dEq, this.dEl + this.dEk * 2, this.dEm + this.width, this.dEl);
    this.O.quadTo(this.dEm + this.dEr, this.dEl - this.dEk * 2, this.dEm + this.dEs, this.dEl);
    this.O.quadTo(this.dEm + this.dEt, this.dEl + this.dEk * 2, this.dEm + this.dEu, this.dEl);
    this.O.lineTo(this.dEm + this.dEu, this.height);
    this.O.lineTo(this.dEm, this.height);
    this.O.close();
  }
  
  private void dOI()
  {
    this.P.reset();
    this.P.moveTo(this.dEn, this.euW);
    this.P.quadTo(this.dEn + this.dEo, this.euW - this.dEk * 2, this.dEn + this.dEp, this.euW);
    this.P.quadTo(this.dEn + this.dEq, this.euW + this.dEk * 2, this.dEn + this.width, this.euW);
    this.P.quadTo(this.dEn + this.dEr, this.euW - this.dEk * 2, this.dEn + this.dEs, this.euW);
    this.P.quadTo(this.dEn + this.dEt, this.euW + this.dEk * 2, this.dEn + this.dEu, this.euW);
    this.P.lineTo(this.dEn + this.dEu, this.height);
    this.P.lineTo(this.dEn, this.height);
    this.P.close();
  }
  
  private void exN()
  {
    if (!VersionUtils.isHoneycomb()) {
      return;
    }
    this.mHandler.sendEmptyMessage(1001);
  }
  
  private void exO()
  {
    if (!VersionUtils.isHoneycomb()) {
      return;
    }
    this.mHandler.sendEmptyMessage(1003);
  }
  
  private void init()
  {
    this.P = new Path();
    this.O = new Path();
    this.cn = new Paint();
    this.cn.setAntiAlias(true);
    this.cn.setColor(this.dEi);
    this.cn.setAlpha(102);
    this.co = new Paint();
    this.co.setAntiAlias(true);
    this.co.setColor(this.dEj);
    this.co.setAlpha(38);
    this.width = getResources().getDisplayMetrics().widthPixels;
    this.height = getResources().getDimensionPixelSize(2131298712);
    this.mDensity = getResources().getDisplayMetrics().density;
    dEg = (int)(this.mDensity * 4.0F + 0.5D);
    this.dEk = dEg;
    this.dEl = (dEg * 3);
    this.euW = (this.dEl - this.dEk);
    int i = this.width / 125;
    dEh = i;
    this.dEv = i;
    this.dEn = 0;
    this.dEm = (-this.width);
    this.dEo = (this.width / 4);
    this.dEp = (this.width / 2);
    this.dEq = (this.width * 3 / 4);
    this.dEr = (this.width * 5 / 4);
    this.dEs = (this.width * 3 / 2);
    this.dEt = (this.width * 7 / 4);
    this.dEu = (this.width * 2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    exN();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveVie onAttachedToWindow.");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    exO();
    if (QLog.isColorLevel()) {
      QLog.i("WaveView", 2, "WaveView onDetachedFromWindow.");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    dOH();
    dOI();
    paramCanvas.drawPath(this.P, this.co);
    paramCanvas.drawPath(this.O, this.cn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.WaveView
 * JD-Core Version:    0.7.0.1
 */