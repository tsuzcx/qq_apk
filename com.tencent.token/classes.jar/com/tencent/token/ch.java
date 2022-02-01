package com.tencent.token;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ch
{
  static ArrayList<String> a(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(ex.h(localView));
      ex.a(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  protected static void a(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  protected static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  static boolean a(List<View> paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  final void a(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int k = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = ex.h((View)localObject);
      localArrayList.add(str);
      if (str != null)
      {
        ex.a((View)localObject, null);
        localObject = (String)paramMap.get(str);
        int j = 0;
        while (j < k)
        {
          if (((String)localObject).equals(paramArrayList.get(j)))
          {
            ex.a((View)paramArrayList2.get(j), str);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    cn.a(paramView, new Runnable()
    {
      public final void run()
      {
        int i = 0;
        while (i < k)
        {
          ex.a((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
          ex.a((View)paramArrayList1.get(i), (String)localArrayList.get(i));
          i += 1;
        }
      }
    });
  }
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract void a(Object paramObject, Rect paramRect);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  final void a(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (ey.a(paramView))
        {
          paramArrayList.add(paramView);
          return;
        }
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramArrayList, paramView.getChildAt(i));
          i += 1;
        }
        return;
      }
      paramArrayList.add(paramView);
    }
  }
  
  final void a(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ex.h(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public abstract boolean a(Object paramObject);
  
  public abstract Object b(Object paramObject);
  
  public abstract Object b(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object c(Object paramObject);
  
  public abstract void c(Object paramObject, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ch
 * JD-Core Version:    0.7.0.1
 */