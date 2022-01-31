package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import exm;
import exn;
import exo;

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
  
  private final void a(View paramView, Object paramObject, int paramInt, exo paramexo)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new exm(this, paramView, localObject, paramObject, paramInt, paramexo);
    exo.a(paramexo, true);
    exo.a(paramexo, paramView);
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
      paramViewGroup = new exo(this, null);
      exo.a(paramViewGroup, new exn(this, (View)localObject, str, paramInt, paramViewGroup));
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof exo)))
      {
        localObject = (exo)localObject;
        if ((exo.a((exo)localObject) == true) && (exo.a((exo)localObject) != null))
        {
          if (exo.b((exo)localObject)) {
            break label258;
          }
          b(exo.a((exo)localObject));
        }
      }
    }
    for (;;)
    {
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof exo)))
      {
        paramViewGroup = (exo)paramViewGroup;
        if ((!this.jdField_a_of_type_Boolean) && (!exo.a(paramViewGroup)))
        {
          a(exo.a(paramViewGroup));
          exo.b(paramViewGroup, true);
        }
      }
      return paramView;
      label258:
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(exo.a((exo)localObject));
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
        if ((localObject != null) && ((localObject instanceof exo)))
        {
          localObject = (exo)localObject;
          if (!exo.a((exo)localObject))
          {
            a(exo.a((exo)localObject));
            exo.b((exo)localObject, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter
 * JD-Core Version:    0.7.0.1
 */