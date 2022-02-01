package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class a
{
  private static final b a = new c(null);
  private static final b b = new a(null);
  
  @Nullable
  public static b a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return b(paramObject).a(paramObject);
  }
  
  static void a(@Nullable Object paramObject, @Nullable b paramb)
  {
    if (paramObject == null) {
      return;
    }
    b(paramObject).a(paramObject, paramb);
  }
  
  @NonNull
  private static b b(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return a;
    }
    return b;
  }
  
  static class a
    implements a.b
  {
    @Nullable
    public b a(Object paramObject)
    {
      return f.a(paramObject);
    }
    
    public void a(Object paramObject, b paramb)
    {
      f.a(paramObject, paramb);
    }
  }
  
  static abstract interface b
  {
    @Nullable
    public abstract b a(Object paramObject);
    
    public abstract void a(Object paramObject, b paramb);
  }
  
  static class c
    implements a.b
  {
    @Nullable
    public b a(Object paramObject)
    {
      return (b)((View)paramObject).getTag(2131165332);
    }
    
    public void a(Object paramObject, b paramb)
    {
      ((View)paramObject).setTag(2131165332, paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a.a
 * JD-Core Version:    0.7.0.1
 */