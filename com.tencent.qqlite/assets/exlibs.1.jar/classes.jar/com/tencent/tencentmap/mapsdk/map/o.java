package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class o
  extends View
{
  private n a = null;
  
  public o(Context paramContext)
  {
    super(paramContext);
    paramContext = null;
    try
    {
      Method localMethod = getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class });
      paramContext = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label39;
    }
    catch (SecurityException localSecurityException)
    {
      label39:
      break label39;
    }
    if (paramContext != null) {}
    try
    {
      paramContext.invoke(this, new Object[] { Integer.valueOf(1), null });
      return;
    }
    catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
  }
  
  public final void a(n paramn)
  {
    this.a = paramn;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    this.a.b.a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.o
 * JD-Core Version:    0.7.0.1
 */