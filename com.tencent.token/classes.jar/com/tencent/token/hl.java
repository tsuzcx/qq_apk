package com.tencent.token;

import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class hl
  extends BaseAdapter
{
  static final int a = gp.g.abc_popup_menu_item_layout;
  public hm b;
  boolean c;
  private int d = -1;
  private final boolean e;
  private final LayoutInflater f;
  
  public hl(hm paramhm, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = paramLayoutInflater;
    this.b = paramhm;
    a();
  }
  
  private void a()
  {
    ho localho = this.b.j;
    if (localho != null)
    {
      ArrayList localArrayList = this.b.j();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((ho)localArrayList.get(i) == localho)
        {
          this.d = i;
          return;
        }
        i += 1;
      }
    }
    this.d = -1;
  }
  
  public final ho a(int paramInt)
  {
    ArrayList localArrayList;
    if (this.e) {
      localArrayList = this.b.j();
    } else {
      localArrayList = this.b.h();
    }
    int j = this.d;
    int i = paramInt;
    if (j >= 0)
    {
      i = paramInt;
      if (paramInt >= j) {
        i = paramInt + 1;
      }
    }
    return (ho)localArrayList.get(i);
  }
  
  public final int getCount()
  {
    ArrayList localArrayList;
    if (this.e) {
      localArrayList = this.b.j();
    } else {
      localArrayList = this.b.h();
    }
    if (this.d < 0) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.f.inflate(a, paramViewGroup, false);
    }
    paramView = (hu.a)localView;
    if (this.c) {
      ((ListMenuItemView)localView).setForceShowIcon(true);
    }
    paramView.a(a(paramInt));
    return localView;
  }
  
  public final void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hl
 * JD-Core Version:    0.7.0.1
 */