package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import auwm;
import auwt;
import auwz;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import oer;
import oeu;
import oex;
import omi;

public abstract class WSBaseHomeFragment<V extends oer, P extends oeu<V>, M>
  extends WSBaseFragment<V, P>
  implements omi<M>
{
  public XRecyclerView b;
  protected boolean isVisible;
  public Context mContext;
  private View mLoadingView;
  protected View mView;
  
  private int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label39;
      }
      i = k;
    }
    label39:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void u(View paramView)
  {
    this.mLoadingView = paramView.findViewById(2131368571);
    this.b = ((XRecyclerView)paramView.findViewById(2131382357));
    if (this.b != null)
    {
      paramView = this.b.a();
      if (paramView != null) {
        paramView.abv(12);
      }
      this.b.setRefreshCallback(new oex(this));
      paramView = this.b.a();
      if (a() != null) {
        paramView.setAdapter(a());
      }
      if (a() != null) {
        paramView.setLayoutManager(a());
      }
    }
  }
  
  protected abstract RecyclerView.LayoutManager a();
  
  protected abstract auwm a();
  
  public abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  public abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
  public abstract void aCB();
  
  protected abstract void aS(Bundle paramBundle);
  
  protected abstract void dr(View paramView);
  
  protected int getLastVisiblePosition()
  {
    int j = -1;
    int i = j;
    RecyclerView.LayoutManager localLayoutManager;
    if (this.b != null)
    {
      i = j;
      if (this.b.a() != null)
      {
        localLayoutManager = this.b.a().getLayoutManager();
        if (!(localLayoutManager instanceof StaggeredGridLayoutManager)) {
          break label71;
        }
        int[] arrayOfInt = new int[((StaggeredGridLayoutManager)localLayoutManager).getSpanCount()];
        ((StaggeredGridLayoutManager)localLayoutManager).findLastVisibleItemPositions(arrayOfInt);
        i = a(arrayOfInt);
      }
    }
    label71:
    do
    {
      return i;
      i = j;
    } while (!(localLayoutManager instanceof LinearLayoutManager));
    return ((LinearLayoutManager)localLayoutManager).findLastVisibleItemPosition();
  }
  
  protected int getLayoutResId()
  {
    return -1;
  }
  
  public void hideLoading()
  {
    if ((this.mLoadingView != null) && (this.mLoadingView.isShown())) {
      this.mLoadingView.setVisibility(8);
    }
  }
  
  public abstract void ie();
  
  public void of(int paramInt) {}
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.mContext = getActivity();
    if (getArguments() != null) {
      aS(getArguments());
    }
    if (getLayoutResId() != -1) {}
    for (this.mView = paramLayoutInflater.inflate(getLayoutResId(), paramViewGroup, false);; this.mView = paramLayoutInflater.inflate(2131560200, paramViewGroup, false))
    {
      paramLayoutInflater = this.mView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    u(this.mView);
    dr(this.mView);
    ie();
  }
  
  protected int rl()
  {
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter;
    if (this.b != null)
    {
      localRecyclerViewWithHeaderFooter = this.b.a();
      if ((localRecyclerViewWithHeaderFooter != null) && (localRecyclerViewWithHeaderFooter.getAdapter() != null) && (a() != null)) {}
    }
    else
    {
      return 0;
    }
    return ((auwz)localRecyclerViewWithHeaderFooter.getAdapter()).rl();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.isVisible = getUserVisibleHint();
  }
  
  public void showLoading(boolean paramBoolean)
  {
    if ((this.mLoadingView != null) && (!this.mLoadingView.isShown())) {
      this.mLoadingView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */