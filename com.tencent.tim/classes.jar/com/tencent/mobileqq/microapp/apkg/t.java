package com.tencent.mobileqq.microapp.apkg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public List f;
  
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static t a(JSONObject paramJSONObject)
  {
    t localt = null;
    if (paramJSONObject != null)
    {
      localt = new t();
      localt.a = DisplayUtil.parseColor(paramJSONObject.optString("color"));
      localt.b = DisplayUtil.parseColor(paramJSONObject.optString("selectedColor"));
      localt.c = DisplayUtil.parseColor(paramJSONObject.optString("backgroundColor"));
      localt.d = paramJSONObject.optString("borderStyle", "black");
      localt.f = a(paramJSONObject.optJSONArray("list"));
      localt.e = paramJSONObject.optString("position", "bottom");
    }
    return localt;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(a.a(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public t a()
  {
    try
    {
      localt1 = (t)super.clone();
      try
      {
        localt1.f = new LinkedList();
        Iterator localIterator = this.f.iterator();
        for (;;)
        {
          Object localObject = localt1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (a)localIterator.next();
          localt1.f.add(((a)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        t localt2;
        t localt1 = null;
      }
    }
    localt2 = localt1;
    return localt2;
  }
  
  public static final class a
    implements Cloneable
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public Bitmap e;
    public Bitmap f;
    
    public static a a(JSONObject paramJSONObject)
    {
      a locala = new a();
      if (paramJSONObject != null)
      {
        locala.a = paramJSONObject.optString("pagePath");
        locala.b = paramJSONObject.optString("text");
        locala.c = paramJSONObject.optString("iconData");
        locala.d = paramJSONObject.optString("selectedIconData");
        locala.e = t.a(locala.c);
        locala.f = t.a(locala.d);
      }
      return locala;
    }
    
    public a a()
    {
      try
      {
        a locala = (a)super.clone();
        return locala;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.t
 * JD-Core Version:    0.7.0.1
 */