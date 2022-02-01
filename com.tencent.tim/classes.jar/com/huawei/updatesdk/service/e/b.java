package com.huawei.updatesdk.service.e;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static final Map<Integer, String> a = new HashMap();
  private static b b = new b();
  private int c = 0;
  
  static
  {
    a.put(Integer.valueOf(1), "1.0");
    a.put(Integer.valueOf(2), "1.5");
    a.put(Integer.valueOf(3), "1.6");
    a.put(Integer.valueOf(4), "2.0");
    a.put(Integer.valueOf(5), "2.0");
    a.put(Integer.valueOf(6), "2.3");
    a.put(Integer.valueOf(7), "3.0");
    a.put(Integer.valueOf(8), "3.0.5");
    a.put(Integer.valueOf(8), "3.1");
    a.put(Integer.valueOf(9), "4.0");
    a.put(Integer.valueOf(10), "4.1");
    a.put(Integer.valueOf(11), "5.0");
    a.put(Integer.valueOf(12), "5.1");
  }
  
  private b()
  {
    if (this.c == 0) {
      this.c = d();
    }
    a.a("EMUISupportUtil", "emuiVersion:" + this.c);
  }
  
  public static b a()
  {
    return b;
  }
  
  private String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      str1 = str2;
      if (paramString.length == 2) {
        str1 = paramString[1];
      }
    }
    return str1;
  }
  
  private int c()
  {
    return com.huawei.updatesdk.a.a.c.a.b.a("ro.build.hw_emui_api_level", 0);
  }
  
  private int d()
  {
    String str = a(com.huawei.updatesdk.a.a.c.a.b.a("ro.build.version.emui", ""));
    if (!TextUtils.isEmpty(str))
    {
      Iterator localIterator = a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (str.equals(localEntry.getValue())) {
          return ((Integer)localEntry.getKey()).intValue();
        }
      }
    }
    return 0;
  }
  
  public int b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.e.b
 * JD-Core Version:    0.7.0.1
 */