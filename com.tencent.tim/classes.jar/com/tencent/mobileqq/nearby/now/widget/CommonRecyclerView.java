package com.tencent.mobileqq.nearby.now.widget;

import akbg;
import akbh;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonRecyclerView
  extends RecyclerView
{
  private List<View> DJ = new ArrayList();
  private List<View> DK = new ArrayList();
  private int mScrollState = -1;
  
  public CommonRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @Nullable
  public akbh a()
  {
    if (getAdapter() == null) {
      return null;
    }
    if ((((akbg)getAdapter()).getAdapter() instanceof akbh)) {
      return (akbh)((akbg)getAdapter()).getAdapter();
    }
    return null;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
    throws IllegalArgumentException
  {
    if (paramAdapter == null) {
      super.setAdapter(null);
    }
    for (;;)
    {
      return;
      if ((a() == null) || (paramAdapter != a()))
      {
        if (!(paramAdapter instanceof akbh)) {
          throw new IllegalArgumentException("adapter must extends CommonAdapter");
        }
        super.setAdapter(new akbg(paramAdapter));
        View localView;
        if (this.DJ.size() > 0)
        {
          paramAdapter = this.DJ.iterator();
          while (paramAdapter.hasNext())
          {
            localView = (View)paramAdapter.next();
            ((akbg)getAdapter()).addHeaderView(localView);
          }
        }
        if (this.DK.size() <= 0) {
          break;
        }
        paramAdapter = this.DK.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((akbg)getAdapter()).addFooterView(localView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView
 * JD-Core Version:    0.7.0.1
 */