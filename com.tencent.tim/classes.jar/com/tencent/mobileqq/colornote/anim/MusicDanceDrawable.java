package com.tencent.mobileqq.colornote.anim;

import aebi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import wja;

public class MusicDanceDrawable
  extends Drawable
  implements aebi, Runnable
{
  private static List<Double>[] d;
  private boolean SD;
  private int axg;
  private int cLV;
  private int cLW;
  private int cLX;
  private int height;
  private Paint mPaint;
  private int width;
  private List<a> yB;
  
  public void O(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.yB.add(new a(paramInt1, paramInt2, paramInt3, paramInt4, null));
  }
  
  public void b(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.yB = new ArrayList();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(paramInt3);
    this.cLW = paramInt2;
    this.cLX = wja.dp2px(2.0F, paramContext.getResources());
    if (this.cLX < 0) {}
    paramInt3 = (paramInt1 - this.cLX * 2) / 3;
    paramInt1 = 0;
    while ((this.yB.size() < 3) && (paramInt1 < 3))
    {
      O(0, paramInt2, paramInt3, -1);
      paramInt1 += 1;
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.cLV = 0;
    int i = 0;
    while (i < this.yB.size())
    {
      a locala = (a)this.yB.get(i);
      paramCanvas.drawRect(this.cLV, this.cLW - a.a(locala), this.cLV + a.b(locala), this.cLW, this.mPaint);
      this.cLV += a.b(locala) + this.cLX;
      i += 1;
    }
  }
  
  public void f(Context paramContext, int paramInt1, int paramInt2)
  {
    b(paramContext, paramInt1, paramInt2, -16777216);
  }
  
  public int getIntrinsicHeight()
  {
    return this.height;
  }
  
  public int getIntrinsicWidth()
  {
    return this.width;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void run()
  {
    if (this.SD)
    {
      int i = 0;
      while (i < this.yB.size())
      {
        double d1 = ((Double)d[i].get(this.axg)).doubleValue();
        a locala = (a)this.yB.get(i);
        locala.setHeight((int)(d1 * a.c(locala)));
        i += 1;
      }
      scheduleSelf(this, 50L);
      invalidateSelf();
      this.axg += 1;
      if (this.axg >= d[0].size()) {
        this.axg = 0;
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public void start(int paramInt)
  {
    if (d == null)
    {
      d = new ArrayList[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        d[paramInt] = new ArrayList();
        paramInt += 1;
      }
      for (double d1 = 0.0D; d1 < 3.141592653589793D; d1 += 0.05D)
      {
        d[0].add(Double.valueOf(Math.abs(Math.sin(d1 + 0.0D))));
        d[1].add(Double.valueOf(Math.abs(Math.sin(1.0D + d1))));
        d[2].add(Double.valueOf(Math.abs(Math.sin(2.0D + d1))));
      }
    }
    if (!this.SD)
    {
      scheduleSelf(this, 0L);
      invalidateSelf();
      this.SD = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicDanceView", 2, "start music animation");
    }
  }
  
  public void stop()
  {
    this.SD = false;
  }
  
  class a
  {
    private int mHeight;
    private int mMaxHeight;
    private int mMinHeight;
    private int mWidth;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mMinHeight = paramInt1;
      this.mMaxHeight = paramInt2;
      this.mWidth = paramInt3;
    }
    
    public void setHeight(int paramInt)
    {
      this.mHeight = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.MusicDanceDrawable
 * JD-Core Version:    0.7.0.1
 */