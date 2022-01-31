package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import cpt;
import cpu;
import cpv;

public abstract class BaseWhatASmoothAdapter
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  public static final String a = "WhatASmoothAdapter";
  protected Context a;
  protected Handler a;
  protected LayoutInflater a;
  private boolean a;
  public String b = new Object().toString();
  private String c = new Object().toString();
  
  public BaseWhatASmoothAdapter(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getMainLooper());
  }
  
  private final void a(View paramView, Object paramObject, int paramInt, cpv paramcpv)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new cpt(this, paramView, localObject, paramObject, paramInt, paramcpv);
    cpv.a(paramcpv, true);
    cpv.a(paramcpv, paramView);
    this.jdField_a_of_type_AndroidOsHandler.post(paramView);
  }
  
  protected abstract int a();
  
  protected abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  protected abstract Object a(int paramInt);
  
  protected void a()
  {
    this.c = new Object().toString();
    this.b = new Object().toString();
  }
  
  protected abstract void a(View paramView, int paramInt);
  
  public abstract void a(View paramView, Object paramObject);
  
  protected abstract void a(Runnable paramRunnable);
  
  protected abstract void b(Runnable paramRunnable);
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = a(paramInt, paramView, paramViewGroup);
    Object localObject = paramView.findViewById(a());
    if (localObject == null) {
      return paramView;
    }
    String str = this.c + getItem(paramInt);
    paramViewGroup = this.b + getItem(paramInt);
    if (!paramViewGroup.equals(((View)localObject).getTag()))
    {
      if (!paramViewGroup.equals(str))
      {
        ((View)localObject).setTag(str);
        a((View)localObject, paramInt);
      }
      paramViewGroup = new cpv(this, null);
      cpv.a(paramViewGroup, new cpu(this, (View)localObject, str, paramInt, paramViewGroup));
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof cpv)))
      {
        localObject = (cpv)localObject;
        if ((cpv.a((cpv)localObject) == true) && (cpv.a((cpv)localObject) != null))
        {
          if (cpv.b((cpv)localObject)) {
            break label258;
          }
          b(cpv.a((cpv)localObject));
        }
      }
    }
    for (;;)
    {
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof cpv)))
      {
        paramViewGroup = (cpv)paramViewGroup;
        if ((!this.jdField_a_of_type_Boolean) && (!cpv.a(paramViewGroup)))
        {
          a(cpv.a(paramViewGroup));
          cpv.b(paramViewGroup, true);
        }
      }
      return paramView;
      label258:
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(cpv.a((cpv)localObject));
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Boolean = false;
      int i = paramAbsListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = paramAbsListView.getChildAt(paramInt).getTag();
        if ((localObject != null) && ((localObject instanceof cpv)))
        {
          localObject = (cpv)localObject;
          if (!cpv.a((cpv)localObject))
          {
            a(cpv.a((cpv)localObject));
            cpv.b((cpv)localObject, true);
          }
        }
        paramInt += 1;
      }
    case 1: 
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter
 * JD-Core Version:    0.7.0.1
 */