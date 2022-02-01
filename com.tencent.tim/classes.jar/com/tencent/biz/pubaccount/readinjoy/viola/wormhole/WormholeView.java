package com.tencent.biz.pubaccount.readinjoy.viola.wormhole;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class WormholeView
  extends FrameLayout
{
  private a a;
  private ViewGroup container;
  private boolean hasAttach;
  private View nh;
  private TextView tQ;
  
  public WormholeView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public WormholeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WormholeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bcn()
  {
    if (!this.hasAttach)
    {
      this.hasAttach = true;
      if (this.a != null) {
        this.a.a(this);
      }
    }
  }
  
  private void bco()
  {
    if (this.hasAttach)
    {
      this.hasAttach = false;
      if (this.a != null) {
        this.a.b(this);
      }
    }
  }
  
  public ViewGroup getContainer()
  {
    return this.container;
  }
  
  public void hideLoading()
  {
    if (this.nh != null) {
      this.nh.setVisibility(8);
    }
  }
  
  public void initView()
  {
    this.container = ((ViewGroup)findViewById(2131382320));
    this.nh = findViewById(2131382322);
    this.tQ = ((TextView)findViewById(2131382321));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    bcn();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    bco();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    bcn();
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    bco();
  }
  
  public void setLifeListener(a parama)
  {
    this.a = parama;
  }
  
  public void setOnErrorViewClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener == null) || (this.tQ == null)) {
      return;
    }
    this.tQ.setOnClickListener(paramOnClickListener);
  }
  
  public void showError()
  {
    if ((this.tQ != null) && (this.nh != null))
    {
      this.nh.setVisibility(0);
      this.tQ.setVisibility(0);
    }
  }
  
  public void showLoading()
  {
    if (this.nh != null) {
      this.nh.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(WormholeView paramWormholeView);
    
    public abstract void b(WormholeView paramWormholeView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView
 * JD-Core Version:    0.7.0.1
 */