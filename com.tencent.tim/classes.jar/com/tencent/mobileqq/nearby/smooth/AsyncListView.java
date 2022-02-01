package com.tencent.mobileqq.nearby.smooth;

import akkc;
import akkd;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView.e;

public class AsyncListView
  extends FPSXListView
{
  final akkc a = new akkc(this);
  
  public AsyncListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.dtE();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(this.a.a(paramListAdapter));
    this.a.dBB();
  }
  
  public void setItemManager(akkd paramakkd)
  {
    this.a.setItemManager(paramakkd);
  }
  
  public void setOnItemSelectedListener(AdapterView.e parame)
  {
    this.a.setOnItemSelectedListener(parame);
    if (!this.a.arR()) {
      super.setOnItemSelectedListener(parame);
    }
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.a.setOnScrollListener(parame);
    if (!this.a.arR()) {
      super.setOnScrollListener(parame);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
    if (!this.a.arR()) {
      super.setOnTouchListener(paramOnTouchListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncListView
 * JD-Core Version:    0.7.0.1
 */