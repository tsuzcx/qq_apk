package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class FullScreenKeyBoardLayout
  extends RelativeLayout
{
  private int mHeight = 0;
  private Rect mRect = new Rect();
  private int mWidth = 0;
  
  public FullScreenKeyBoardLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenKeyBoardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FullScreenKeyBoardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(this.mRect);
    if ((this.mWidth == 0) && (this.mHeight == 0))
    {
      this.mWidth = getRootView().getWidth();
      this.mHeight = getRootView().getHeight();
    }
    int i = this.mRect.bottom - this.mRect.top;
    if (this.mHeight - i > this.mHeight / 4)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenKeyBoardLayout
 * JD-Core Version:    0.7.0.1
 */