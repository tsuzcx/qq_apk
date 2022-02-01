package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.androidqqmail.R.styleable;

public class WrapContentListView
  extends ListView
{
  private int mMaxHeight = 536870911;
  
  public WrapContentListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WrapContentListView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mMaxHeight = paramInt;
  }
  
  public WrapContentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WrapContentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WrapContentListView, paramInt, 0);
    this.mMaxHeight = paramContext.getDimensionPixelSize(R.styleable.WrapContentListView_maxHeight, this.mMaxHeight);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.WrapContentListView
 * JD-Core Version:    0.7.0.1
 */