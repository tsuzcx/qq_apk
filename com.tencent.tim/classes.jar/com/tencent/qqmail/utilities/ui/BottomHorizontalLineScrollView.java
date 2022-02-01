package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class BottomHorizontalLineScrollView
  extends HorizontalScrollView
{
  private Context mContext;
  private int mItemMiniWidth;
  private LinearLayout mLayout;
  private List<View> mViews = new ArrayList();
  
  public BottomHorizontalLineScrollView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public BottomHorizontalLineScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public BottomHorizontalLineScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayout = new LinearLayout(this.mContext);
    this.mLayout.setOrientation(0);
    this.mLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    addView(this.mLayout);
    this.mItemMiniWidth = this.mContext.getResources().getDimensionPixelSize(2131296709);
  }
  
  public void addItem(View paramView)
  {
    this.mViews.add(paramView);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(this.mItemMiniWidth, -1));
    this.mLayout.addView(paramView);
  }
  
  public int getViewCount()
  {
    return this.mViews.size();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (this.mViews.size() > 0)
    {
      j = View.MeasureSpec.getSize(paramInt1) - getPaddingRight() - getPaddingLeft();
      int k = this.mItemMiniWidth;
      int m = this.mViews.size();
      i = this.mItemMiniWidth;
      if (m * k >= j) {
        break label153;
      }
      i = j / this.mViews.size();
    }
    label153:
    for (;;)
    {
      j = 0;
      while (j < this.mViews.size())
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)this.mViews.get(j)).getLayoutParams();
        localLayoutParams.width = i;
        ((View)this.mViews.get(j)).setLayoutParams(localLayoutParams);
        j += 1;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.BottomHorizontalLineScrollView
 * JD-Core Version:    0.7.0.1
 */