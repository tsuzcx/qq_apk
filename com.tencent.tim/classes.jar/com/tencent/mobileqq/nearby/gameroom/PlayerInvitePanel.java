package com.tencent.mobileqq.nearby.gameroom;

import ajts;
import ajtt;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.LinkedList;
import java.util.List;

public class PlayerInvitePanel
  extends AdapterView<BaseAdapter>
{
  private List<View> DC = new LinkedList();
  private BaseAdapter mAdapter;
  private int mColumnCount = 5;
  private DataSetObserver mDataSetObserver = new ajtt(this);
  private AdapterView.OnItemClickListener mOnItemClickListener;
  
  public PlayerInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dzk()
  {
    this.DC.clear();
    int i = 0;
    while (i < getChildCount())
    {
      this.DC.add(getChildAt(i));
      i += 1;
    }
  }
  
  public BaseAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  public void layoutChildren()
  {
    dzk();
    detachAllViewsFromParent();
    int i = 0;
    while (i < this.mAdapter.getCount())
    {
      View localView = this.mAdapter.getView(i, obtainView(), this);
      localView.setOnClickListener(new ajts(this, i));
      addViewInLayout(localView, i, new ViewGroup.LayoutParams(-2, -2));
      i += 1;
    }
    requestLayout();
  }
  
  protected View obtainView()
  {
    if (!this.DC.isEmpty()) {
      return (View)this.DC.remove(0);
    }
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = super.getChildCount();
    if (k > this.mColumnCount) {}
    for (int i = this.mColumnCount;; i = k)
    {
      int m = paramInt3 - paramInt1;
      int j = 0;
      while (j < k)
      {
        View localView = super.getChildAt(j);
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        int i3 = (m - this.mColumnCount * n) / (this.mColumnCount + 1);
        int i2 = (m - i * n - (i - 1) * i3) / 2 + (n + i3) * (j % this.mColumnCount);
        i3 = (i3 + i1) * (j / this.mColumnCount);
        localView.layout(i2, i3, n + i2, i1 + i3);
        j += 1;
      }
    }
    invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      measureChild(getChildAt(i), paramInt1, paramInt2);
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.mAdapter = paramBaseAdapter;
    if (this.mAdapter != null) {
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
    }
    layoutChildren();
  }
  
  public void setColumnCount(int paramInt)
  {
    this.mColumnCount = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel
 * JD-Core Version:    0.7.0.1
 */