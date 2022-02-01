package com.tencent.qqmail.view.keeppressed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

public class KeepPressedRelativeLayout
  extends RelativeLayout
{
  private final Runnable mCheckForChecked = new KeepPressedRelativeLayout.1(this);
  private int mDividerInsetLeftBottom = 0;
  private int mDividerInsetLeftTop = 0;
  private boolean mNeedDrawBottomDivider = true;
  private boolean mNeedDrawTopDivider = false;
  private boolean mNeedPostPress = true;
  private Paint mPaint;
  
  public KeepPressedRelativeLayout(Context paramContext)
  {
    super(paramContext);
    initPaint();
  }
  
  public KeepPressedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaint();
  }
  
  public KeepPressedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initPaint();
  }
  
  private void initPaint()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(getContext().getResources().getColor(2131166583));
    this.mPaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(2131297594));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    QMUIHelper.drawDivider(this.mNeedDrawTopDivider, this.mNeedDrawBottomDivider, paramCanvas, this.mPaint, this.mDividerInsetLeftTop, this.mDividerInsetLeftBottom);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    super.setPressed(false);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.setPressed(false);
    }
  }
  
  public void setDrawDivider(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mNeedDrawTopDivider = paramBoolean1;
    this.mNeedDrawBottomDivider = paramBoolean2;
  }
  
  public void setNeedPostPress(boolean paramBoolean)
  {
    this.mNeedPostPress = paramBoolean;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setPressed(paramBoolean);
      return;
    }
    Runnable localRunnable = this.mCheckForChecked;
    if (this.mNeedPostPress) {}
    for (long l = ViewConfiguration.getLongPressTimeout();; l = 0L)
    {
      postDelayed(localRunnable, l);
      return;
    }
  }
  
  public void updateDividerInsetLeft(int paramInt1, int paramInt2)
  {
    this.mDividerInsetLeftTop = paramInt1;
    this.mDividerInsetLeftBottom = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout
 * JD-Core Version:    0.7.0.1
 */