package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.ImageCache;
import com.tencent.token.utils.UserTask;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class aau
  extends BitmapDrawable
{
  public static Bitmap a;
  public static Bitmap b;
  public static ImageCache c;
  public static Map<String, aau> d;
  public static Map<String, String> e;
  public static boolean f = false;
  private static boolean h;
  private BitmapDrawable g;
  
  private aau(final String paramString1, final String paramString2)
  {
    this.g = new BitmapDrawable(a);
    new UserTask() {}.a(new String[] { "" });
  }
  
  private aau(final String paramString1, final String paramString2, final String paramString3, Bitmap paramBitmap)
  {
    this.g = new BitmapDrawable(paramBitmap);
    new UserTask() {}.a(new String[] { "" });
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
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 4)) {
        break label258;
      }
      localObject = ImageCache.d(paramString1);
    }
    paramString2 = c.a(localObject);
    if (paramString2 != null)
    {
      xv.a("face:from cache");
      localObject = a(paramString1, (String)localObject, paramString2);
      if (localObject != null) {
        return localObject;
      }
      xv.b("from memcache".concat(String.valueOf(paramString1)));
      return new BitmapDrawable(paramString2);
    }
    paramString2 = c;
    paramString2 = paramString2.b(paramString2.c((String)localObject));
    if (paramString2 != null)
    {
      c.b((String)localObject, paramString2);
      localObject = a(paramString1, (String)localObject, paramString2);
      if (localObject != null) {
        return localObject;
      }
      xv.b("from cache,don't update".concat(String.valueOf(paramString1)));
      return new BitmapDrawable(paramString2);
    }
    if ((paramString1 != null) && (paramString1.length() > 4))
    {
      paramString2 = (aau)d.get(paramString1);
      if (paramString2 != null)
      {
        xv.b("from loading task".concat(String.valueOf(paramString1)));
        return paramString2;
      }
      xv.b("from new task".concat(String.valueOf(paramString1)));
      paramString2 = new aau(paramString1, (String)localObject);
      d.put(paramString1, paramString2);
      return paramString2;
    }
    return new BitmapDrawable(a);
    label258:
    return new BitmapDrawable(a);
  }
  
  private static BitmapDrawable a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    String str = (String)e.get(paramString2);
    if ((paramString1 != null) && (paramString1.length() > 4) && (str != null))
    {
      aau localaau = (aau)d.get(paramString1);
      if (localaau != null) {
        return localaau;
      }
      paramString2 = new aau(paramString1, paramString2, str, paramBitmap);
      d.put(paramString1, paramString2);
      return paramString2;
    }
    return null;
  }
  
  private static void a()
  {
    if (!h)
    {
      Resources localResources = RqdApplication.n().getResources();
      a = aaz.a(localResources, 2131099813);
      b = aaz.a(localResources, 2131099767);
      c = new ImageCache(30, RqdApplication.n());
      e = Collections.synchronizedMap(new HashMap());
      d = Collections.synchronizedMap(new HashMap());
      h = true;
    }
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    Object localObject = new ajq();
    try
    {
      localObject = ajs.a((aju)localObject, "qqface", new String[] { "uinhash", "filename" }, null, null, null, null).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajq localajq = (ajq)((Iterator)localObject).next();
        if (localajq == null) {
          break;
        }
        paramMap.put(localajq.a, localajq.b);
      }
      return true;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      xv.c(paramMap.toString());
    }
    return false;
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
        break label120;
      }
      str = ImageCache.d(paramString1);
    }
    paramString2 = (aau)d.get(paramString1);
    if (paramString2 != null)
    {
      xv.b("from loading task".concat(String.valueOf(paramString1)));
      return paramString2;
    }
    xv.b("from new task".concat(String.valueOf(paramString1)));
    paramString2 = new aau(paramString1, str);
    d.put(paramString1, paramString2);
    return paramString2;
    label120:
    return new BitmapDrawable(a);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    BitmapDrawable localBitmapDrawable = this.g;
    if (localBitmapDrawable != null) {
      localBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public final int getOpacity()
  {
    BitmapDrawable localBitmapDrawable = this.g;
    if (localBitmapDrawable != null) {
      return localBitmapDrawable.getOpacity();
    }
    return -2;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    BitmapDrawable localBitmapDrawable = this.g;
    if (localBitmapDrawable != null) {
      localBitmapDrawable.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public final void setAlpha(int paramInt)
  {
    BitmapDrawable localBitmapDrawable = this.g;
    if (localBitmapDrawable != null) {
      localBitmapDrawable.setAlpha(paramInt);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    BitmapDrawable localBitmapDrawable = this.g;
    if (localBitmapDrawable != null) {
      localBitmapDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aau
 * JD-Core Version:    0.7.0.1
 */