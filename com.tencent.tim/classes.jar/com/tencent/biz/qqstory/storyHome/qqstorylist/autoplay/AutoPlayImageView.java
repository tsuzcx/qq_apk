package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import ram;

public class AutoPlayImageView
  extends ImageView
{
  private int Dk;
  public boolean aFU = true;
  private Paint aT;
  private int mCoverHeight;
  private String mCoverUrl;
  private int mCoverWidth;
  private Path mPath;
  private int mState;
  
  public AutoPlayImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mState = 0;
    this.mPath = new Path();
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    for (;;)
    {
      this.aT = new Paint();
      this.aT.setColor(-2302756);
      this.aT.setStyle(Paint.Style.STROKE);
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        super.setLayerType(1, null);
      }
    }
  }
  
  public boolean KF()
  {
    if (this.mState != 3) {
      return false;
    }
    return this.aFU;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2) {}
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.Dk > 0) {
      i = this.Dk;
    }
    for (;;)
    {
      this.mPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      this.mPath.reset();
      this.mPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      if (QQStoryContext.isNightMode()) {
        this.aT.setColor(getContext().getResources().getColor(2131166764));
      }
      paramCanvas.drawPath(this.mPath, this.aT);
      return;
      i /= 30;
    }
  }
  
  public String getCoverUrl()
  {
    return this.mCoverUrl;
  }
  
  public boolean isPause()
  {
    return false;
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void pausePlay()
  {
    ram.d("AutoPlayImageView", "pausePlay last mState=" + this.mState);
    if (this.mState == 3) {
      return;
    }
    this.mState = 2;
  }
  
  public void release() {}
  
  public void resumePlay() {}
  
  public int sR()
  {
    return this.mState;
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.aT.setColor(paramInt);
    invalidate();
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.Dk = paramInt;
  }
  
  public void setCoverDrawable(Drawable paramDrawable) {}
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    this.mCoverUrl = paramString;
    this.mCoverWidth = paramInt1;
    this.mCoverHeight = paramInt2;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView
 * JD-Core Version:    0.7.0.1
 */