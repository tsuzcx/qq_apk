package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public abstract class LazyFragment
  extends ReportV4Fragment
{
  private Bundle E;
  protected ViewGroup mContainer;
  protected View mContentView;
  private boolean mIsInit;
  private boolean mIsStart;
  private FrameLayout mLayout;
  protected LayoutInflater mLayoutInflater;
  
  protected void aI(Bundle paramBundle)
  {
    if ((getUserVisibleHint()) && (!this.mIsInit))
    {
      this.mIsInit = true;
      this.E = paramBundle;
      aJ(this.E);
      return;
    }
    this.E = paramBundle;
    aVa();
  }
  
  protected void aJ(Bundle paramBundle)
  {
    setContentView(pw());
    init(paramBundle);
  }
  
  protected void aUV() {}
  
  protected void aUW() {}
  
  protected void aUX() {}
  
  protected void aUY() {}
  
  protected void aUZ() {}
  
  protected void aVa()
  {
    this.mLayout = new FrameLayout(this.mContainer.getContext());
    this.mLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mContentView = this.mLayout;
  }
  
  public void aVb()
  {
    if ((!this.mIsInit) && (getContentView() != null))
    {
      this.mIsInit = true;
      aJ(this.E);
    }
  }
  
  public View getContentView()
  {
    return this.mContentView;
  }
  
  public abstract void init(Bundle paramBundle);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.mLayoutInflater = paramLayoutInflater;
    this.mContainer = paramViewGroup;
    aI(paramBundle);
    if (this.mContentView == null) {}
    for (paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);; paramLayoutInflater = this.mContentView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mContentView = null;
    this.mContainer = null;
    this.mLayoutInflater = null;
    if (this.mIsInit) {
      aUZ();
    }
    this.mIsInit = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsInit) {
      aUX();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mIsInit) {
      aUW();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.mIsInit) && (!this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = true;
      aUV();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.mIsInit) && (this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = false;
      aUY();
    }
  }
  
  public abstract int pw();
  
  public void setContentView(int paramInt)
  {
    if ((getContentView() != null) && (getContentView().getParent() != null) && (this.mLayout != null))
    {
      View localView = this.mLayoutInflater.inflate(paramInt, this.mLayout, false);
      this.mLayout.addView(localView);
      return;
    }
    this.mContentView = this.mLayoutInflater.inflate(paramInt, this.mContainer, false);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.mIsInit)) {
      aVb();
    }
    if ((this.mIsInit) && (getContentView() != null))
    {
      if (paramBoolean)
      {
        this.mIsStart = true;
        aUV();
        aUW();
      }
    }
    else {
      return;
    }
    this.mIsStart = false;
    aUX();
    aUY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.LazyFragment
 * JD-Core Version:    0.7.0.1
 */