package com.tencent.mobileqq.activity.recent.cur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import wja;

public class RecentMayKnowRelativeLayout
  extends RelativeLayout
{
  boolean aIP;
  Drawable ek;
  SoftReference<Bitmap> m;
  int mDividerHeight;
  Rect mDstRect;
  Rect mSrcRect;
  SoftReference<Canvas> n;
  
  public RecentMayKnowRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public RecentMayKnowRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RecentMayKnowRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.aIP = false;
    try
    {
      this.ek = getResources().getDrawable(2130851241);
      this.mDividerHeight = wja.dp2px(0.5F, getResources());
      return;
    }
    catch (Throwable paramContext)
    {
      this.aIP = true;
      QLog.i("RecentMayKnowRelativeLayout", 1, "init error:" + paramContext.getMessage());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.aIP) {
      return;
    }
    for (;;)
    {
      Canvas localCanvas;
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.m == null) || (this.m.get() == null) || (((Bitmap)this.m.get()).getWidth() != i) || (((Bitmap)this.m.get()).getHeight() != j))
        {
          this.ek.setBounds(0, 0, i, j);
          localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          this.m = new SoftReference(localBitmap);
          localCanvas = new Canvas(localBitmap);
          this.n = new SoftReference(localCanvas);
          this.mSrcRect = new Rect(0, j - this.mDividerHeight, i, j);
          this.mDstRect = new Rect(getLeft(), getBottom() - this.mDividerHeight, getRight(), getBottom());
          if ((localBitmap == null) || (localCanvas == null)) {
            break;
          }
          this.ek.draw(localCanvas);
          paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.mDstRect, null);
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        QLog.i("RecentMayKnowRelativeLayout", 1, "dispatchDraw error:" + paramCanvas.getMessage());
        return;
      }
      Bitmap localBitmap = (Bitmap)this.m.get();
      if ((this.n == null) || (this.n.get() == null))
      {
        localCanvas = new Canvas(localBitmap);
        this.n = new SoftReference(localCanvas);
      }
      else
      {
        localCanvas = (Canvas)this.n.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.RecentMayKnowRelativeLayout
 * JD-Core Version:    0.7.0.1
 */