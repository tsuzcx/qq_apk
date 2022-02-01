package com.tencent.mobileqq.microapp.out.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.microapp.app.a;
import com.tencent.mobileqq.microapp.app.a.a;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class g
  extends BaseAdapter
{
  Context a;
  List b;
  CompoundButton.OnCheckedChangeListener c;
  
  public g(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a = paramContext;
    this.c = paramOnCheckedChangeListener;
    LayoutInflater.from(paramContext);
    this.b = new ArrayList();
  }
  
  public a.a a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.b.size())) {
      return (a.a)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (paramString.equals(locala.a))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          locala.b = i;
          break;
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormSwitchItem localFormSwitchItem;
    a.a locala;
    boolean bool;
    label34:
    String str;
    if (paramView != null)
    {
      localFormSwitchItem = (FormSwitchItem)paramView;
      locala = a(paramInt);
      if (locala != null)
      {
        if (locala.b != 2) {
          break label124;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem.a().setTag(locala.a);
        str = (String)a.b.get(locala.a);
        if (str == null) {
          break label130;
        }
      }
    }
    for (;;)
    {
      localFormSwitchItem.setText(str);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localFormSwitchItem;
      localFormSwitchItem = new FormSwitchItem(this.a);
      localFormSwitchItem.setOnCheckedChangeListener(this.c);
      break;
      label124:
      bool = false;
      break label34;
      label130:
      str = locala.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.g
 * JD-Core Version:    0.7.0.1
 */