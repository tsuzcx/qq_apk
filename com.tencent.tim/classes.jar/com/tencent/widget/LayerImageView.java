package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class LayerImageView
  extends ImageView
{
  private a[] a;
  private boolean dkF;
  private boolean dkG;
  private int dsm;
  private Bitmap mBitmap;
  private Bitmap.Config mConfig;
  private Paint mPaint;
  
  public LayerImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void exf()
  {
    this.dkF = true;
  }
  
  private void init()
  {
    this.dkF = false;
    this.mPaint = new Paint();
    this.dsm = getResources().getDisplayMetrics().densityDpi;
    this.dkG = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBitmaps(Bitmap[] paramArrayOfBitmap, boolean paramBoolean)
  {
    int j = 0;
    if ((paramBoolean) && (this.a != null))
    {
      a[] arrayOfa = this.a;
      int k = arrayOfa.length;
      i = 0;
      while (i < k)
      {
        a locala = arrayOfa[i];
        if (a.a(locala) != null) {
          a.a(locala).recycle();
        }
        i += 1;
      }
    }
    this.a = new a[paramArrayOfBitmap.length];
    int i = j;
    while (i < paramArrayOfBitmap.length)
    {
      this.a[i] = new a(paramArrayOfBitmap[i], this.dsm, null);
      if ((this.mConfig == null) || ((a.a(this.a[i]) != null) && (a.a(this.a[i]).ordinal() > this.mConfig.ordinal()))) {
        this.mConfig = a.a(this.a[i]);
      }
      i += 1;
    }
    exf();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.dkF = false;
    this.mBitmap = paramBitmap;
  }
  
  public void setLayerBitmap(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    a locala = this.a[paramInt];
    this.a[paramInt] = new a(paramBitmap, this.dsm, null);
    if ((paramBoolean) && (a.a(locala) != null)) {
      a.a(locala).recycle();
    }
  }
  
  public void setLayerPadding(int paramInt, Rect paramRect)
  {
    a.a(this.a[paramInt], paramRect);
    exf();
  }
  
  public void setLayerPadding(Rect[] paramArrayOfRect)
  {
    if (paramArrayOfRect.length != this.a.length) {
      throw new IllegalArgumentException("padding must have the same size as input bitmaps");
    }
    int i = 0;
    while (i < this.a.length)
    {
      a.a(this.a[i], paramArrayOfRect[i]);
      i += 1;
    }
    exf();
  }
  
  public void setLayerVisibility(int paramInt1, int paramInt2)
  {
    a.a(this.a[paramInt1], paramInt2);
    exf();
  }
  
  public void setNeedTransparent(boolean paramBoolean)
  {
    this.dkG = paramBoolean;
  }
  
  static class a
  {
    private Rect dd;
    private Bitmap mBitmap;
    private Bitmap.Config mConfig;
    private int mHeight;
    private int mVisibility;
    private int mWidth;
    
    private a(Bitmap paramBitmap, int paramInt)
    {
      this.mBitmap = paramBitmap;
      this.dd = new Rect(0, 0, 0, 0);
      if (paramBitmap != null)
      {
        this.mWidth = paramBitmap.getScaledWidth(paramInt);
        this.mHeight = paramBitmap.getScaledHeight(paramInt);
        this.mVisibility = 0;
        this.mConfig = paramBitmap.getConfig();
        return;
      }
      this.mVisibility = 4;
    }
    
    private void setPadding(Rect paramRect)
    {
      this.dd.set(paramRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.LayerImageView
 * JD-Core Version:    0.7.0.1
 */