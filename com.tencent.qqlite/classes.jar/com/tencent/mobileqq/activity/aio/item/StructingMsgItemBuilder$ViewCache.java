package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import byb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class StructingMsgItemBuilder$ViewCache
{
  private StructingMsgItemBuilder.CacheMap a = new StructingMsgItemBuilder.CacheMap(null);
  private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
  
  private int a(HashMap paramHashMap)
  {
    paramHashMap = paramHashMap.keySet().iterator();
    String str;
    for (int i = 0; paramHashMap.hasNext(); i = this.a.get(str).size() + i) {
      str = (String)paramHashMap.next();
    }
    return i;
  }
  
  private byb a(String paramString, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.b.get(paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (byb)localIterator.next();
      if (paramString != null) {
        paramString.a(paramViewGroup);
      }
    }
    for (;;)
    {
      this.b.remove(paramString);
      this.a.add(paramString);
      return paramString;
      paramString = null;
    }
  }
  
  private String a(HashMap paramHashMap, String paramString)
  {
    paramHashMap = (ArrayList)paramHashMap.get(paramString);
    if (paramHashMap == null) {
      return "key 0";
    }
    return "key " + paramHashMap.size();
  }
  
  public View a(String paramString, ViewGroup paramViewGroup)
  {
    a(paramString, paramViewGroup);
    paramString = a(paramString, paramViewGroup);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public void a(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.a.add(new byb(paramString, paramView, paramViewGroup));
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    byb localbyb;
    do
    {
      return;
      while (!paramString.hasNext()) {
        paramString = this.a.get(paramString).iterator();
      }
      localbyb = (byb)paramString.next();
    } while ((localbyb == null) || ((localbyb.a() != paramViewGroup) && (localbyb.a() != null)));
    localbyb.a().removeAllViews();
    this.a.remove(localbyb);
    this.b.add(localbyb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache
 * JD-Core Version:    0.7.0.1
 */