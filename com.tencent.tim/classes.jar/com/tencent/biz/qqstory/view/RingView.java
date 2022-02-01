package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RingView
  extends View
{
  protected RectF P = new RectF();
  protected List<a> pi = new ArrayList();
  
  public RingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected static void checkMainThread()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("not main thread !");
    }
  }
  
  public void a(a parama)
  {
    
    if (parama == null) {
      throw new NullPointerException("drawInfo should not be NULL");
    }
    if (!this.P.isEmpty()) {
      parama.k((int)this.P.centerX(), (int)this.P.centerY(), (int)this.P.height() / 2);
    }
    this.pi.add(parama);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    Iterator localIterator = this.pi.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.k((int)this.P.centerX(), (int)this.P.centerY(), (int)this.P.height() / 2);
      locala.draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = super.getWidth();
    paramInt2 = super.getHeight();
    int j = super.getPaddingLeft();
    int k = super.getPaddingRight();
    paramInt3 = super.getPaddingTop();
    paramInt4 = super.getPaddingBottom();
    paramInt1 = Math.min(i - j - k, paramInt2 - paramInt3 - paramInt4);
    i = (i - j - k - paramInt1) / 2 + j;
    paramInt2 = (paramInt2 - paramInt3 - paramInt4 - paramInt1) / 2 + paramInt3;
    this.P.left = i;
    this.P.right = (i + paramInt1);
    this.P.top = paramInt2;
    this.P.bottom = (paramInt2 + paramInt1);
    Iterator localIterator = this.pi.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).k((int)this.P.centerX(), (int)this.P.centerY(), (int)this.P.height() / 2);
    }
  }
  
  public static class a
  {
    public boolean aJu = true;
    public boolean aJv;
    public int buu;
    public int buv;
    public int buw;
    public int bux;
    public int buy;
    public int buz;
    public int mCenterX;
    public int mCenterY;
    public final Paint mPaint = new Paint();
    public int mRadius;
    public final RectF mRect = new RectF();
    public float nT;
    public float nU;
    
    public a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, float paramFloat2, int paramInt5, int paramInt6, Paint.Style paramStyle)
    {
      this.buv = paramInt1;
      this.buw = paramInt2;
      this.mRadius = paramInt3;
      this.nT = paramFloat1;
      this.buu = paramInt4;
      this.nU = paramFloat2;
      this.bux = paramInt5;
      this.buy = paramInt6;
      bvZ();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(paramStyle);
    }
    
    private void bvZ()
    {
      if ((this.mRadius <= 0) && ((this.nT <= 0.0F) || (this.nT > 1.0F))) {
        throw new IllegalArgumentException("radius/radiusRatio = " + this.mRadius + "/" + this.nT + " is invalid !");
      }
      if ((this.buu <= 0) && ((this.nU <= 0.0F) || (this.nU > 1.0F))) {
        throw new IllegalArgumentException("mThickness/mThicknessRatio = " + this.buu + "/" + this.nU + " is invalid !");
      }
    }
    
    public void bvY()
    {
      this.aJv = true;
    }
    
    protected void draw(Canvas paramCanvas)
    {
      if (!this.aJv) {
        if (this.mPaint.getStyle() == Paint.Style.STROKE) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        this.mPaint.setColor(this.buy);
        paramCanvas.drawArc(this.mRect, 0.0F, 360.0F, bool, this.mPaint);
        this.mPaint.setColor(this.bux);
        paramCanvas.drawArc(this.mRect, this.buv, this.buw - this.buv, bool, this.mPaint);
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return this == paramObject;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public void k(int paramInt, float paramFloat)
    {
      this.mRadius = paramInt;
      this.nT = paramFloat;
      if ((this.mRadius <= 0) && ((this.nT <= 0.0F) || (this.nT > 1.0F))) {
        throw new IllegalArgumentException("radius/radiusRatio = " + this.mRadius + "/" + this.nT + " is invalid !");
      }
      this.aJu = true;
    }
    
    protected boolean k(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!this.aJu) && (this.mCenterX == paramInt1) && (this.mCenterY == paramInt2) && (this.buz == paramInt3)) {
        return false;
      }
      this.mCenterX = paramInt1;
      this.mCenterY = paramInt2;
      this.buz = paramInt3;
      int i;
      if (this.mRadius > 0)
      {
        i = this.mRadius;
        if (this.buu <= 0) {
          break label153;
        }
      }
      label153:
      for (paramInt3 = this.buu;; paramInt3 = (int)(this.nU * paramInt3))
      {
        this.mPaint.setStrokeWidth(paramInt3);
        paramInt3 = i - paramInt3 / 2;
        this.mRect.left = (paramInt1 - paramInt3);
        this.mRect.right = (paramInt1 + paramInt3);
        this.mRect.top = (paramInt2 - paramInt3);
        this.mRect.bottom = (paramInt3 + paramInt2);
        this.aJu = false;
        return true;
        i = (int)(this.nT * paramInt3);
        break;
      }
    }
    
    public void l(int paramInt, float paramFloat)
    {
      this.buu = paramInt;
      this.nU = paramFloat;
      if ((this.buu <= 0) && ((this.nU <= 0.0F) || (this.nU > 1.0F))) {
        throw new IllegalArgumentException("mThickness/mThicknessRatio = " + this.buu + "/" + this.nU + " is invalid !");
      }
      this.aJu = true;
    }
    
    public String toString()
    {
      return "DrawInfo{mAngleStart=" + this.buv + ", mAngleEnd=" + this.buw + ", mRadius=" + this.mRadius + ", mRadiusRatio=" + this.nT + ", mThickness=" + this.buu + ", mThicknessRatio=" + this.nU + ", mForeground=" + this.bux + ", mBackground=" + this.buy + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.RingView
 * JD-Core Version:    0.7.0.1
 */