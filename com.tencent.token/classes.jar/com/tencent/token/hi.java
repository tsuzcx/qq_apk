package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class hi
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
  private static final Object c = new Object();
  
  public static ColorStateList a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    Object localObject1 = d(paramContext, paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    ColorStateList localColorStateList = c(paramContext, paramInt);
    if (localColorStateList != null) {
      synchronized (c)
      {
        SparseArray localSparseArray = (SparseArray)b.get(paramContext);
        localObject1 = localSparseArray;
        if (localSparseArray == null)
        {
          localObject1 = new SparseArray();
          b.put(paramContext, localObject1);
        }
        ((SparseArray)localObject1).append(paramInt, new a(localColorStateList, paramContext.getResources().getConfiguration()));
        return localColorStateList;
      }
    }
    return dj.b(paramContext, paramInt);
  }
  
  public static Drawable b(Context paramContext, int paramInt)
  {
    return iy.a().a(paramContext, paramInt, false);
  }
  
  private static ColorStateList c(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)a.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      a.set(localObject1);
    }
    int i = 1;
    localResources.getValue(paramInt, (TypedValue)localObject1, true);
    if ((((TypedValue)localObject1).type < 28) || (((TypedValue)localObject1).type > 31)) {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    localObject1 = paramContext.getResources();
    localObject2 = ((Resources)localObject1).getXml(paramInt);
    try
    {
      paramContext = hh.a((Resources)localObject1, (XmlPullParser)localObject2, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static ColorStateList d(Context paramContext, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.b.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.a;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  static final class a
  {
    final ColorStateList a;
    final Configuration b;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.a = paramColorStateList;
      this.b = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hi
 * JD-Core Version:    0.7.0.1
 */