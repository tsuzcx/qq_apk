package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import aqmr;
import com.tencent.mobileqq.microapp.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public boolean a;
  public String b;
  public s c;
  public t d;
  public List e = new LinkedList();
  private Map f;
  private Map g = new HashMap();
  
  public static p a(String paramString)
  {
    p localp = new p();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.optString(str1);
        localp.g.put(str1, str2);
      }
      localp.a = paramString.optBoolean("debug");
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return localp;
    }
    localp.b = paramString.optString("entryPagePath");
    localp.c = s.a();
    localp.c.a(paramString.optJSONObject("global"));
    localp.f = a(paramString.optJSONObject("page"), localp.c);
    a(paramString.optJSONArray("pages"));
    r.a(paramString.optJSONObject("networkTimeout"));
    localp.d = t.a(paramString.optJSONObject("tabBar"));
    localp.e = b(paramString.optJSONArray("subPackages"));
    return localp;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        String str = paramJSONArray.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localLinkedList.add(str);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static Map a(JSONObject paramJSONObject, s params)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        s locals = params.b();
        locals.a(paramJSONObject.optJSONObject(str));
        localHashMap.put(str, locals);
      }
    }
    return localHashMap;
  }
  
  private static List b(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("root");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localLinkedList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public String b(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return "";
    }
    String str2 = c.d(paramString);
    Iterator localIterator = this.e.iterator();
    label120:
    label123:
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str1;
      if (str3.startsWith("/"))
      {
        paramString = str3.substring(1);
        str1 = paramString;
        if (paramString.endsWith("/")) {
          str1 = paramString.substring(0, paramString.length() - 1);
        }
        if (!str2.startsWith("/")) {
          break label120;
        }
      }
      for (paramString = str2.substring(1);; paramString = str2)
      {
        if (!paramString.startsWith(str1)) {
          break label123;
        }
        return str3;
        paramString = str3;
        break;
      }
    }
    return "";
  }
  
  public s c(String paramString)
  {
    paramString = c.d(paramString);
    s locals = (s)this.f.get(paramString);
    paramString = locals;
    if (locals == null) {
      paramString = this.c;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.p
 * JD-Core Version:    0.7.0.1
 */