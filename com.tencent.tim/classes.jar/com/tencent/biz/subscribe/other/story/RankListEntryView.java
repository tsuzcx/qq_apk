package com.tencent.biz.subscribe.other.story;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import rpq;
import sfg;

public class RankListEntryView
  extends View
{
  private RectF Z;
  private int ZY;
  private sfg a;
  private Rect aM;
  private int bwA = 87;
  private int bwB;
  private int bwC;
  private int bwD;
  private int bwE;
  private int bwz = 228;
  private Bitmap cW;
  private Bitmap cX;
  private Bitmap cY;
  private Bitmap cZ;
  private Bitmap da;
  private Bitmap db;
  private Paint mPaint;
  private Rect mSrcRect;
  private ArrayList<Bitmap> nW = new ArrayList();
  private float of;
  private float og;
  private RectF v;
  
  public RankListEntryView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RankListEntryView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RankListEntryView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.of = rpq.getScreenWidth(paramContext);
    if (this.of <= 0.0F) {}
    for (this.og = 1.0F;; this.og = (this.of / 720.0F))
    {
      this.mPaint = new Paint();
      this.bwC = 1;
      this.bwD = 43;
      this.ZY = 32;
      this.mSrcRect = new Rect();
      this.v = new RectF();
      this.bwE = 0;
      return;
    }
  }
  
  int ep(int paramInt)
  {
    return (int)(paramInt * this.og);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawBitmap(this.cW, this.aM, this.Z, this.mPaint);
    int i = 0;
    int j;
    if (i < this.nW.size())
    {
      j = (25 - this.bwC) * i + 22;
      int k = (this.bwA - this.bwD - this.bwC * 2 - 6) / 2;
      Bitmap localBitmap1;
      switch (i)
      {
      default: 
        localBitmap1 = this.cZ;
      }
      for (;;)
      {
        Bitmap localBitmap2 = (Bitmap)this.nW.get(i);
        this.mSrcRect.left = 0;
        this.mSrcRect.top = 0;
        this.mSrcRect.right = localBitmap2.getWidth();
        this.mSrcRect.bottom = localBitmap2.getHeight();
        this.v.left = ep(j);
        this.v.top = ep(k);
        this.v.right = ep(this.bwD + j);
        this.v.bottom = ep(this.bwD + k);
        paramCanvas.drawBitmap((Bitmap)this.nW.get(i), this.mSrcRect, this.v, this.mPaint);
        this.mSrcRect.left = 0;
        this.mSrcRect.top = 0;
        this.mSrcRect.right = localBitmap1.getWidth();
        this.mSrcRect.bottom = localBitmap1.getHeight();
        this.v.left = ep(j - this.bwC);
        this.v.top = ep(k - this.bwC);
        this.v.right = ep(j + this.bwC + this.bwD);
        this.v.bottom = ep(this.bwC + k + this.bwD);
        paramCanvas.drawBitmap(localBitmap1, this.mSrcRect, this.v, this.mPaint);
        i += 1;
        break;
        localBitmap1 = this.cY;
        continue;
        localBitmap1 = this.da;
      }
    }
    if (this.bwE == 0)
    {
      i = (this.bwA - this.bwD - this.bwC * 2 - 6) / 2;
      this.mSrcRect.left = 0;
      this.mSrcRect.top = 0;
      this.mSrcRect.right = 51;
      this.mSrcRect.bottom = 56;
      this.v.left = ep(20);
      this.v.top = ep(i);
      this.v.right = ep(20 + this.mSrcRect.right);
      this.v.bottom = ep(i + this.mSrcRect.bottom);
      paramCanvas.drawBitmap(this.cX, this.mSrcRect, this.v, this.mPaint);
    }
    if (this.db != null)
    {
      this.mPaint.setTextSize(28.0F * this.of / 720.0F);
      i = this.bwB - 84 - 20;
      j = this.bwA / 2 - 13 - 4;
      this.mSrcRect.left = 0;
      this.mSrcRect.top = 0;
      this.mSrcRect.right = 84;
      this.mSrcRect.bottom = 26;
      this.v.left = ep(i);
      this.v.top = ep(j);
      this.v.right = ep(this.mSrcRect.right + i);
      this.v.bottom = ep(this.mSrcRect.bottom + j);
      paramCanvas.drawBitmap(this.db, this.mSrcRect, this.v, this.mPaint);
    }
  }
  
  public void setGameInfo(sfg paramsfg)
  {
    this.a = paramsfg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.RankListEntryView
 * JD-Core Version:    0.7.0.1
 */