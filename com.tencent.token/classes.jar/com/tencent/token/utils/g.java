package com.tencent.token.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.cr;
import com.tencent.token.ep;
import com.tencent.token.er;
import com.tencent.token.et;
import com.tencent.token.global.RqdApplication;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class g
  extends BitmapDrawable
{
  public static Bitmap a;
  public static Bitmap b;
  public static ImageCache c;
  public static Map<String, g> d;
  public static Map<String, String> e;
  public static boolean f = false;
  private static boolean h;
  private BitmapDrawable g;
  
  private g(final String paramString1, final String paramString2)
  {
    this.g = new BitmapDrawable(a);
    new UserTask()
    {
      public Bitmap a(String... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = cr.a().a(paramString1, null);
        Bitmap localBitmap = cr.a().a(paramAnonymousVarArgs);
        if (localBitmap != null)
        {
          g.c.b(paramString2, localBitmap);
          String str = g.c.c(paramString2);
          if (g.c.a(str, localBitmap)) {
            g.c(paramString2, paramAnonymousVarArgs);
          }
        }
        return localBitmap;
      }
      
      public void a(Bitmap paramAnonymousBitmap)
      {
        g localg = (g)g.d.remove(paramString1);
        if ((paramAnonymousBitmap == null) || (localg == null)) {
          return;
        }
        paramAnonymousBitmap = new BitmapDrawable(paramAnonymousBitmap);
        paramAnonymousBitmap.setBounds(g.a(localg).getBounds());
        g.a(localg, paramAnonymousBitmap);
        localg.invalidateSelf();
      }
    }.c(new String[] { "" });
  }
  
  private g(final String paramString1, final String paramString2, final String paramString3, Bitmap paramBitmap)
  {
    this.g = new BitmapDrawable(paramBitmap);
    new UserTask()
    {
      public Bitmap a(String... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = null;
        String str1 = cr.a().a(paramString1, null);
        if ((str1 != null) && (str1.equals(paramString3))) {}
        Bitmap localBitmap;
        String str2;
        do
        {
          do
          {
            return paramAnonymousVarArgs;
            localBitmap = cr.a().a(str1);
            paramAnonymousVarArgs = localBitmap;
          } while (localBitmap == null);
          g.c.b(paramString2, localBitmap);
          str2 = g.c.c(paramString2);
          paramAnonymousVarArgs = localBitmap;
        } while (!g.c.a(str2, localBitmap));
        g.c(paramString2, str1);
        return localBitmap;
      }
      
      public void a(Bitmap paramAnonymousBitmap)
      {
        g.e.remove(paramString2);
        g localg = (g)g.d.remove(paramString1);
        if (localg == null) {}
        while (paramAnonymousBitmap == null) {
          return;
        }
        paramAnonymousBitmap = new BitmapDrawable(paramAnonymousBitmap);
        paramAnonymousBitmap.setBounds(g.a(localg).getBounds());
        g.a(localg, paramAnonymousBitmap);
        localg.invalidateSelf();
      }
    }.c(new String[] { "" });
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
        com.tencent.token.global.g.a("face:from cache");
        localObject = a(paramString1, (String)localObject, localBitmap);
        paramString2 = (String)localObject;
      } while (localObject != null);
      com.tencent.token.global.g.b("from memcache" + paramString1);
      return new BitmapDrawable(localBitmap);
      localBitmap = c.b(c.c((String)localObject));
      if (localBitmap == null) {
        break;
      }
      c.b((String)localObject, localBitmap);
      localObject = a(paramString1, (String)localObject, localBitmap);
      paramString2 = (String)localObject;
    } while (localObject != null);
    com.tencent.token.global.g.b("from cache,don't update" + paramString1);
    return new BitmapDrawable(localBitmap);
    if ((paramString1 == null) || (paramString1.length() <= 4)) {
      return new BitmapDrawable(a);
    }
    paramString2 = (g)d.get(paramString1);
    if (paramString2 != null)
    {
      com.tencent.token.global.g.b("from loading task" + paramString1);
      return paramString2;
    }
    com.tencent.token.global.g.b("from new task" + paramString1);
    paramString2 = new g(paramString1, (String)localObject);
    d.put(paramString1, paramString2);
    return paramString2;
  }
  
  private static BitmapDrawable a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    String str = (String)e.get(paramString2);
    if ((paramString1 != null) && (paramString1.length() > 4) && (str != null))
    {
      g localg = (g)d.get(paramString1);
      if (localg != null) {
        return localg;
      }
      paramString2 = new g(paramString1, paramString2, str, paramBitmap);
      d.put(paramString1, paramString2);
      return paramString2;
    }
    return null;
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    Object localObject = new ep();
    try
    {
      localObject = er.a((et)localObject, "qqface", new String[] { "uinhash", "filename" }, null, null, null, null, null, null);
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ep localep = (ep)((Iterator)localObject).next();
        if (localep == null) {
          break;
        }
        paramMap.put(localep.a, localep.b);
      }
      return true;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      com.tencent.token.global.g.c(paramMap.toString());
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
    paramString2 = (g)d.get(paramString1);
    if (paramString2 != null)
    {
      com.tencent.token.global.g.b("from loading task" + paramString1);
      return paramString2;
    }
    com.tencent.token.global.g.b("from new task" + paramString1);
    paramString2 = new g(paramString1, str);
    d.put(paramString1, paramString2);
    return paramString2;
  }
  
  private static void b()
  {
    if (!h)
    {
      Resources localResources = RqdApplication.l().getResources();
      a = m.a(localResources, 2130837666);
      b = m.a(localResources, 2130837622);
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
      ep localep = new ep();
      localep.a = paramString1;
      localep.b = paramString2;
      er.c(localep);
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
 * Qualified Name:     com.tencent.token.utils.g
 * JD-Core Version:    0.7.0.1
 */