package com.tencent.token.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.fx;
import com.tencent.token.ga;
import com.tencent.token.gd;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class k
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
    new l(this, paramString1, paramString2).c(new String[] { "" });
  }
  
  private k(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    this.g = new BitmapDrawable(paramBitmap);
    new m(this, paramString1, paramString3, paramString2).c(new String[] { "" });
  }
  
  public static BitmapDrawable a(String paramString1, String paramString2)
  {
    
    if (!f)
    {
      f = true;
      a(e);
    }
    Object localObject;
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
        localObject = c.d(paramString1);
        localBitmap = c.a(localObject);
        if (localBitmap == null) {
          break;
        }
        h.a("face:from cache");
        localObject = a(paramString1, (String)localObject, localBitmap);
        paramString2 = (String)localObject;
      } while (localObject != null);
      h.b("from memcache" + paramString1);
      return new BitmapDrawable(localBitmap);
      localBitmap = c.b(c.c((String)localObject));
      if (localBitmap == null) {
        break;
      }
      c.b((String)localObject, localBitmap);
      localObject = a(paramString1, (String)localObject, localBitmap);
      paramString2 = (String)localObject;
    } while (localObject != null);
    h.b("from cache,don't update" + paramString1);
    return new BitmapDrawable(localBitmap);
    if ((paramString1 == null) || (paramString1.length() <= 4)) {
      return new BitmapDrawable(a);
    }
    paramString2 = (k)d.get(paramString1);
    if (paramString2 != null)
    {
      h.b("from loading task" + paramString1);
      return paramString2;
    }
    h.b("from new task" + paramString1);
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
    Object localObject = new fx();
    try
    {
      localObject = ga.a((gd)localObject, "qqface", new String[] { "uinhash", "filename" }, null, null, null, null, null, null);
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        fx localfx = (fx)((Iterator)localObject).next();
        if (localfx == null) {
          break;
        }
        paramMap.put(localfx.a, localfx.b);
      }
      return true;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      h.c(paramMap.toString());
      return false;
    }
  }
  
  public static BitmapDrawable b(String paramString1, String paramString2)
  {
    
    if (!f)
    {
      f = true;
      a(e);
    }
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() > 4) {}
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 4)) {
        return new BitmapDrawable(a);
      }
      str = c.d(paramString1);
    }
    paramString2 = (k)d.get(paramString1);
    if (paramString2 != null)
    {
      h.b("from loading task" + paramString1);
      return paramString2;
    }
    h.b("from new task" + paramString1);
    paramString2 = new k(paramString1, str);
    d.put(paramString1, paramString2);
    return paramString2;
  }
  
  private static void b()
  {
    if (!h)
    {
      Resources localResources = RqdApplication.l().getResources();
      a = x.a(localResources, 2130837666);
      b = x.a(localResources, 2130837622);
      c = new ImageCache("", 30, RqdApplication.l());
      e = Collections.synchronizedMap(new HashMap());
      d = Collections.synchronizedMap(new HashMap());
      h = true;
    }
  }
  
  private static void d(String paramString1, String paramString2)
  {
    try
    {
      fx localfx = new fx();
      localfx.a = paramString1;
      localfx.b = paramString2;
      ga.c(localfx);
      return;
    }
    finally {}
  }
  
  public BitmapDrawable a()
  {
    return this.g;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.g != null) {
      this.g.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    if (this.g != null) {
      return this.g.getOpacity();
    }
    return -2;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    if (this.g != null) {
      this.g.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.g != null) {
      this.g.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
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