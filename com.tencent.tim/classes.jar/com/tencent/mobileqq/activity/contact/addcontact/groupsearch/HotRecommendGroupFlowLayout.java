package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.troop.widget.FlowLayout;

public class HotRecommendGroupFlowLayout
  extends FlowLayout
{
  public HotRecommendGroupFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HotRecommendGroupFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HotRecommendGroupFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aGs()
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.mAdapter.getCount()) && (i < j))
    {
      View localView = getChildAt(i);
      this.mAdapter.getView(i, localView, this);
      i += 1;
    }
    if (j > this.mAdapter.getCount()) {
      removeViews(i, j - this.mAdapter.getCount());
    }
    if (j < this.mAdapter.getCount()) {
      while (i < this.mAdapter.getCount())
      {
        addView(this.mAdapter.getView(i, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.HotRecommendGroupFlowLayout
 * JD-Core Version:    0.7.0.1
 */