package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import aqho;
import com.tencent.qphone.base.util.QLog;

public class MusicHorizontalSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int bsC = ei.length;
  protected static int bsD;
  protected static int bsE;
  protected static final int[] ei = { 6, 8, 10, 12, 12, 10, 8, 6 };
  protected static int[] ej = new int[bsC];
  protected int JO;
  protected a a;
  protected boolean aIx;
  protected Rect aK;
  protected Paint bf;
  protected int bsF;
  protected int bsG;
  protected int bsH;
  protected int bsI;
  protected int bsJ;
  protected int bsK;
  protected int bsL;
  protected Paint mBluePaint;
  protected int mScrollX;
  protected int mVideoDuration;
  protected int mViewHeight;
  protected Paint mWhitePaint;
  float nK = 0.0F;
  
  public MusicHorizontalSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bsK = ((int)aqho.convertDpToPixel(paramContext, 2.0F));
    this.bsL = ((int)aqho.convertDpToPixel(paramContext, 1.0F));
    bsD = (int)aqho.convertDpToPixel(paramContext, 10.0F);
    bsE = (int)aqho.convertDpToPixel(paramContext, 21.0F);
    int i = 0;
    while (i < bsC)
    {
      ej[i] = ((int)aqho.convertDpToPixel(paramContext, ei[i]));
      i += 1;
    }
    paramContext = paramContext.getResources();
    this.mWhitePaint = new Paint();
    this.mWhitePaint.setAntiAlias(true);
    this.mWhitePaint.setColor(paramContext.getColor(2131165685));
    this.mBluePaint = new Paint();
    this.mBluePaint.setAntiAlias(true);
    this.mBluePaint.setColor(paramContext.getColor(2131166755));
    this.bf = new Paint();
    this.bf.setAntiAlias(true);
    this.bf.setColor(paramContext.getColor(2131166757));
    this.bf.setStrokeWidth(this.bsL);
    super.setOnTouchListener(this);
  }
  
  public static void ep(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 30) {
      bsD = paramInt2 / (paramInt1 + 16);
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt1, paramInt3, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.mWhitePaint.setStrokeWidth(this.bsL);
    this.mBluePaint.setStrokeWidth(this.bsL);
    int j = 0;
    int i = -1;
    int k;
    int m;
    if (j < this.bsF)
    {
      k = this.bsJ;
      m = this.mScrollX;
      k = (j + 1) * bsD + (k - m);
      if ((k <= this.bsJ + this.bsG) || (this.mScrollX != this.bsH)) {
        break label189;
      }
    }
    label189:
    label194:
    Paint localPaint;
    for (;;)
    {
      if ((this.aIx) || (this.bsI >= this.mVideoDuration))
      {
        this.mBluePaint.setStrokeWidth(this.bsK);
        a(paramCanvas, this.aK.left, this.aK.top, this.aK.bottom, this.mBluePaint);
        a(paramCanvas, this.aK.right, this.aK.top, this.aK.bottom, this.mBluePaint);
        if (QLog.isColorLevel()) {}
        return;
        if (k < 0)
        {
          j += 1;
          break;
        }
        if (k <= this.JO)
        {
          localPaint = this.bf;
          if ((this.aIx) || (k <= this.aK.left) || (k >= this.aK.right)) {
            break label498;
          }
          if (i != -1) {
            break label495;
          }
          i = j;
          label254:
          if ((j >= i) && (j < this.bsI + i)) {
            localPaint = this.mBluePaint;
          }
        }
      }
    }
    label495:
    label498:
    for (;;)
    {
      m = ej[(j % bsC)];
      int n = (this.mViewHeight - m) / 2;
      a(paramCanvas, k, n, n + m, localPaint);
      break label194;
      localPaint = this.mWhitePaint;
      continue;
      if (this.bsI == -1)
      {
        this.mWhitePaint.setStrokeWidth(this.bsK);
        a(paramCanvas, this.aK.left, this.aK.top, this.aK.bottom, this.mWhitePaint);
        a(paramCanvas, this.aK.right, this.aK.top, this.aK.bottom, this.mWhitePaint);
        break;
      }
      this.mBluePaint.setStrokeWidth(this.bsK);
      a(paramCanvas, this.aK.left, this.aK.top, this.aK.bottom, this.mBluePaint);
      this.mWhitePaint.setStrokeWidth(this.bsK);
      a(paramCanvas, this.aK.right, this.aK.top, this.aK.bottom, this.mWhitePaint);
      break;
      break label254;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.JO = super.getMeasuredWidth();
    this.mViewHeight = (bsE + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.JO, this.mViewHeight);
    this.bsJ = ((this.JO - this.bsG) / 2);
    paramInt1 = (this.mViewHeight - bsE) / 2;
    this.aK = new Rect(this.bsJ, paramInt1, this.bsJ + this.mVideoDuration * bsD, bsE + paramInt1);
    if (this.a != null) {
      this.a.en(this.bsJ, this.bsG);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = false;
      float f;
      do
      {
        return bool;
        this.aIx = false;
        this.nK = paramMotionEvent.getX();
        if (this.a == null) {
          break;
        }
        this.a.ae(this.bsH, this.bsG, this.mScrollX);
        break;
        f = paramMotionEvent.getX();
      } while (Math.abs(f - this.nK) < 2.0F);
      this.aIx = true;
      this.mScrollX = ((int)(this.mScrollX + (this.nK - f) / 2.0F));
      if (f > this.nK)
      {
        if (this.mScrollX <= bsD)
        {
          this.mScrollX = 0;
          super.invalidate();
          if (this.a != null) {
            this.a.af(this.bsH, this.bsG, this.mScrollX);
          }
          this.nK = f;
          return false;
        }
      }
      else if (this.mScrollX >= this.bsH - this.bsG)
      {
        this.mScrollX = (this.bsH - this.bsG);
        super.invalidate();
        if (this.a != null) {
          this.a.af(this.bsH, this.bsG, this.mScrollX);
        }
        this.nK = f;
        return false;
      }
      super.invalidate();
      if (this.a != null) {
        this.a.af(this.bsH, this.bsG, this.mScrollX);
      }
      this.nK = f;
      continue;
      this.aIx = false;
      super.invalidate();
      if (this.a != null) {
        this.a.ag(this.bsH, this.bsG, this.mScrollX);
      }
    }
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.mVideoDuration = paramInt1;
    this.bsF = paramInt2;
    this.bsG = (bsD * this.mVideoDuration);
    this.bsH = (bsD * this.bsF);
  }
  
  public void setOnSeekListener(a parama)
  {
    this.a = parama;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.bsI = paramInt;
    super.invalidate();
  }
  
  public void xF(int paramInt)
  {
    this.mScrollX = (bsD * paramInt / 1000);
    setPlayedPosition(-1);
  }
  
  public static abstract interface a
  {
    public abstract void ae(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void af(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void ag(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void en(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView
 * JD-Core Version:    0.7.0.1
 */