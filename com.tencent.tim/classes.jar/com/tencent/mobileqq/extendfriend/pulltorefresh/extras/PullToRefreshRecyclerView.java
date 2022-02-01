package com.tencent.mobileqq.extendfriend.pulltorefresh.extras;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.AnimationStyle;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

public class PullToRefreshRecyclerView
  extends PullToRefreshBase<RecyclerView>
{
  public PullToRefreshRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  private boolean akB()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)bX()).getAdapter();
    if ((localAdapter == null) || (localAdapter.getItemCount() == 0)) {
      return true;
    }
    if (getFirstVisiblePosition() == 0) {
      return ((RecyclerView)this.Cn).getChildAt(0).getTop() >= ((RecyclerView)this.Cn).getTop();
    }
    return false;
  }
  
  private boolean akC()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)bX()).getAdapter();
    if ((localAdapter == null) || (localAdapter.getItemCount() == 0)) {
      return true;
    }
    if (getLastVisiblePosition() >= ((RecyclerView)this.Cn).getAdapter().getItemCount() - 1) {
      return ((RecyclerView)this.Cn).getChildAt(((RecyclerView)this.Cn).getChildCount() - 1).getBottom() <= ((RecyclerView)this.Cn).getBottom();
    }
    return false;
  }
  
  private int getFirstVisiblePosition()
  {
    View localView = ((RecyclerView)this.Cn).getChildAt(0);
    if (localView != null) {
      return ((RecyclerView)this.Cn).getChildPosition(localView);
    }
    return -1;
  }
  
  private int getLastVisiblePosition()
  {
    View localView = ((RecyclerView)this.Cn).getChildAt(((RecyclerView)this.Cn).getChildCount() - 1);
    if (localView != null) {
      return ((RecyclerView)this.Cn).getChildPosition(localView);
    }
    return -1;
  }
  
  protected RecyclerView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView(paramContext, paramAttributeSet);
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  public boolean fj()
  {
    return akB();
  }
  
  public boolean fl()
  {
    return akC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView
 * JD-Core Version:    0.7.0.1
 */