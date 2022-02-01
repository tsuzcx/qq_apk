package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import aqho;
import com.tencent.qphone.base.util.QLog;

public class QimMusicSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int bsC = ei.length;
  protected static int bsD;
  protected static int bsE;
  protected static int eIG;
  protected static final int[] ei = { 18, 14, 9, 12, 14, 18 };
  protected static int[] ej = new int[bsC];
  protected int JO;
  protected a a;
  protected boolean aIx;
  protected Rect aK;
  protected int aVd;
  protected Paint bf;
  protected int bsF;
  protected int bsG;
  protected int bsH;
  protected int bsI;
  protected int bsJ;
  protected int bsK;
  protected int bsL;
  protected Paint cI;
  protected Paint df;
  protected int eIH;
  protected int eII;
  protected Paint mBluePaint;
  protected int mScrollX;
  protected int mVideoDuration;
  protected int mViewHeight;
  protected Paint mWhitePaint;
  float nK = 0.0F;
  
  public QimMusicSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bsK = ((int)aqho.convertDpToPixel(paramContext, 8.0F));
    this.eIH = ((int)aqho.convertDpToPixel(paramContext, 2.0F));
    this.eII = ((int)aqho.convertDpToPixel(paramContext, 2.0F));
    this.aVd = ((int)aqho.convertDpToPixel(paramContext, 3.0F));
    bsD = (int)aqho.convertDpToPixel(paramContext, 4.0F);
    eIG = (int)aqho.convertDpToPixel(paramContext, 50.0F);
    bsE = (int)aqho.convertDpToPixel(paramContext, 36.0F);
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
    this.mBluePaint.setColor(paramContext.getColor(2131166534));
    this.bf = new Paint();
    this.bf.setAntiAlias(true);
    this.bf.setColor(paramContext.getColor(2131167664));
    this.bf.setStrokeWidth(1.0F);
    this.bf.setStyle(Paint.Style.FILL);
    this.df = new Paint();
    this.df.setAntiAlias(true);
    this.df.setColor(paramContext.getColor(2131165587));
    this.df.setStyle(Paint.Style.FILL);
    this.cI = new Paint();
    this.cI.setAntiAlias(true);
    this.cI.setColor(0);
    this.cI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    super.setOnTouchListener(this);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Paint paramPaint)
  {
    RectF localRectF = new RectF();
    localRectF.left = paramInt1;
    localRectF.top = paramInt2;
    localRectF.bottom = paramInt4;
    localRectF.right = paramInt3;
    paramCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    Rect localRect = new Rect();
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.bottom = paramInt4;
    localRect.right = paramInt3;
    paramCanvas.drawRect(localRect, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mWhitePaint.setStrokeWidth(this.bsL);
    this.mWhitePaint.setStyle(Paint.Style.FILL);
    this.mBluePaint.setStrokeWidth(this.bsL);
    this.mBluePaint.setStyle(Paint.Style.FILL);
    int i = 0;
    int j;
    label108:
    int k;
    label297:
    int m;
    int n;
    if (i < this.bsF)
    {
      j = this.bsJ - this.mScrollX + (i + 1) * bsD + this.eIH * i;
      if ((j <= this.bsJ + this.bsG) || (this.mScrollX != this.bsH - this.bsG)) {}
    }
    else
    {
      this.mWhitePaint.setStrokeWidth(1.0F);
      this.mWhitePaint.setStyle(Paint.Style.FILL);
      a(paramCanvas, this.aK.left - this.bsK, this.aK.top, this.aK.right + this.bsK, this.aK.bottom, 10.0F, this.mWhitePaint);
      this.df.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      a(paramCanvas, this.aK.left, this.aK.top + this.eII, this.aK.right, this.aK.bottom - this.eII, this.df);
      this.df.setXfermode(null);
      this.mWhitePaint.setStrokeWidth(this.bsL);
      this.mWhitePaint.setStyle(Paint.Style.FILL);
      this.mBluePaint.setStrokeWidth(this.bsL);
      this.mBluePaint.setStyle(Paint.Style.FILL);
      j = 0;
      i = -1;
      if (j < this.bsF)
      {
        k = this.bsJ;
        m = this.mScrollX;
        n = bsD;
        n = this.eIH * j + (k - m + (j + 1) * n);
        if ((n <= this.bsJ + this.bsG) || (this.mScrollX != this.bsH - this.bsG)) {
          break label481;
        }
      }
    }
    Paint localPaint;
    label481:
    do
    {
      return;
      if (j < 0) {}
      for (;;)
      {
        i += 1;
        break;
        if (j > this.JO) {
          break label108;
        }
        localPaint = this.bf;
        if ((this.aIx) || (j <= this.aK.left - this.eIH) || (j >= this.aK.right))
        {
          k = ej[(i % bsC)];
          m = (this.mViewHeight - k) / 2;
          a(paramCanvas, j, m, j + this.eIH, m + k, 5.0F, localPaint);
        }
      }
      if (n < 0)
      {
        j += 1;
        break label297;
      }
    } while (n > this.JO);
    if ((!this.aIx) && (n > this.aK.left - this.eIH) && (n < this.aK.right))
    {
      k = this.eIH;
      if ((n >= this.aK.left) || (this.eIH + n <= this.aK.left)) {
        break label826;
      }
      m = this.aK.left;
      k = this.eIH + n;
    }
    for (;;)
    {
      if ((n < this.aK.right) && (this.eIH + n > this.aK.right)) {
        k = this.aK.right;
      }
      for (;;)
      {
        if (i == -1) {
          i = j;
        }
        for (;;)
        {
          if ((j >= i) && (j < this.bsI + i)) {}
          for (localPaint = this.mBluePaint;; localPaint = this.mWhitePaint)
          {
            m = ej[(j % bsC)];
            int i1 = (this.mViewHeight - m) / 2;
            a(paramCanvas, n, i1, k, i1 + m, 5.0F, localPaint);
            break;
          }
          if ((this.aIx) && (n > this.aK.left - this.eIH) && (n < this.aK.right))
          {
            if (i == -1) {
              i = j;
            }
            for (;;)
            {
              localPaint = this.mWhitePaint;
              k = ej[(j % bsC)];
              m = (this.mViewHeight - k) / 2;
              a(paramCanvas, n, m, n + this.eIH, m + k, 5.0F, localPaint);
              break;
            }
          }
          break;
        }
        n = m;
      }
      label826:
      k += n;
      m = n;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.JO = super.getMeasuredWidth();
    this.mViewHeight = (eIG + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.JO, this.mViewHeight);
    this.bsJ = ((this.JO - this.bsG) / 2);
    paramInt1 = (this.mViewHeight - eIG) / 2;
    this.aK = new Rect(this.bsJ, paramInt1, this.bsJ + this.bsG, eIG + paramInt1);
    if (this.a != null) {
      this.a.en(this.bsJ, this.bsG);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onMeasure() mViewWidth: " + this.JO + ", mViewHeight = " + this.mViewHeight + ", mVideoViewOffsetX = " + this.bsJ + ", mMusicMaxWidth = " + this.bsH);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      label35:
      float f1;
      do
      {
        return bool1;
        this.aIx = false;
        this.nK = paramMotionEvent.getX();
        if (this.a == null) {
          break;
        }
        this.a.ae(this.bsH, this.bsG, this.mScrollX);
        break;
        this.aIx = true;
        f1 = paramMotionEvent.getX();
        bool1 = bool2;
      } while (Math.abs(f1 - this.nK) < 3.0F);
      float f2 = (this.nK - f1) / (bsD + this.eIH);
      int i = Math.round(Math.abs(f2));
      if ((f2 > 0.0F) && (i >= 1)) {}
      for (this.mScrollX += (bsD + this.eIH) * i;; this.mScrollX -= (bsD + this.eIH) * i) {
        do
        {
          bool1 = bool2;
          if (i == 0) {
            break label35;
          }
          if (this.mScrollX <= 0) {
            this.mScrollX = 0;
          }
          if (this.mScrollX >= this.bsH - this.bsG) {
            this.mScrollX = (this.bsH - this.bsG);
          }
          super.invalidate();
          if (this.a != null) {
            this.a.af(this.bsH, this.bsG, this.mScrollX);
          }
          this.nK = f1;
          break;
        } while ((f2 >= 0.0F) || (i < 1));
      }
      this.aIx = false;
      super.invalidate();
      if (this.a != null) {
        this.a.ag(this.bsH, this.bsG, this.mScrollX);
      }
    }
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.mVideoDuration = ((int)(paramInt1 * 2.5F));
    this.bsF = ((int)(paramInt2 * 2.5F));
    this.bsG = (bsD * this.mVideoDuration + (this.mVideoDuration - 1) * this.eIH);
    this.bsH = (bsD * this.bsF + (this.bsF - 1) * this.eIH);
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
    this.mScrollX = ((int)(paramInt / 1000 * (bsD + this.eIH) * 2.5F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QimMusicSeekView
 * JD-Core Version:    0.7.0.1
 */