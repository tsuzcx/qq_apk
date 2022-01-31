package com.tencent.token.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.gi;
import com.tencent.token.gl;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.go;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  extends BitmapDrawable
{
  public static Bitmap a;
  public static Bitmap b;
  public static ImageCache c;
  public static Map d;
  public static Map e;
  public static boolean f = false;
  private static boolean h;
  private BitmapDrawable g;
  
  private k(String paramString1, String paramString2)
  {
    this.g = new BitmapDrawable(a);
    new l(this, paramString1, paramString2).a(new String[] { "" });
  }
  
  private k(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    this.g = new BitmapDrawable(paramBitmap);
    new m(this, paramString1, paramString3, paramString2).a(new String[] { "" });
  }
  
  public static BitmapDrawable a(String paramString1, String paramString2)
  {
    Object localObject;
    if (!h)
    {
      localObject = RqdApplication.i().getResources();
      a = t.a((Resources)localObject, 2130837585);
      b = t.a((Resources)localObject, 2130837544);
      c = new ImageCache(30, RqdApplication.i());
      e = Collections.synchronizedMap(new HashMap());
      d = Collections.synchronizedMap(new HashMap());
      h = true;
    }
    if (!f)
    {
      f = true;
      a(e);
    }
    if (paramString2 != null)
    {
      localObject = paramString2;
      if (paramString2.length() > 4) {}
    }
    else if ((paramString1 == null) || (paramString1.length() <= 4))
    {
      paramString2 = new BitmapDrawable(a);
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        return paramString2;
        localObject = ImageCache.d(paramString1);
        localBitmap = c.a(localObject);
        if (localBitmap == null) {
          break;
        }
        localObject = a(paramString1, (String)localObject, localBitmap);
        paramString2 = (String)localObject;
      } while (localObject != null);
      e.b("from memcache" + paramString1);
      return new BitmapDrawable(localBitmap);
      localBitmap = c.b(c.c((String)localObject));
      if (localBitmap == null) {
        break;
      }
      c.b((String)localObject, localBitmap);
      localObject = a(paramString1, (String)localObject, localBitmap);
      paramString2 = (String)localObject;
    } while (localObject != null);
    e.b("from cache,don't update" + paramString1);
    return new BitmapDrawable(localBitmap);
    if ((paramString1 == null) || (paramString1.length() <= 4)) {
      return new BitmapDrawable(a);
    }
    paramString2 = (k)d.get(paramString1);
    if (paramString2 != null)
    {
      e.b("from loading task" + paramString1);
      return paramString2;
    }
    e.b("from new task" + paramString1);
    paramString2 = new k(paramString1, (String)localObject);
    d.put(paramString1, paramString2);
    return paramString2;
  }
  
  private static BitmapDrawable a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    String str = (String)e.get(paramString2);
    if ((paramString1 != null) && (paramString1.length() > 4) && (str != null))
    {
      k localk = (k)d.get(paramString1);
      if (localk != null) {
        return localk;
      }
      paramString2 = new k(paramString1, paramString2, str, paramBitmap);
      d.put(paramString1, paramString2);
      return paramString2;
    }
    return null;
  }
  
  private static boolean a(Map paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    Object localObject = new gi();
    try
    {
      localObject = gl.a((go)localObject, "qqface", new String[] { "uinhash", "filename" }, null, null, null, null);
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        gi localgi = (gi)((Iterator)localObject).next();
        if (localgi == null) {
          break;
        }
        paramMap.put(localgi.a, localgi.b);
      }
      return true;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      e.c(paramMap.toString());
      return false;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.g != null) {
      this.g.draw(paramCanvas);
    }
  }
  
  public final int getOpacity()
  {
    if (this.g != null) {
      return this.g.getOpacity();
    }
    return -2;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    if (this.g != null) {
      this.g.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.g != null) {
      this.g.setAlpha(paramInt);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.g != null) {
      this.g.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.k
 * JD-Core Version:    0.7.0.1
 */