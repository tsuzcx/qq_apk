package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g
{
  private static g a;
  private static f b;
  
  public static g a()
  {
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      return localg;
    }
    finally {}
  }
  
  public static String a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (paramArrayOfString.length > 1)
      {
        int i = 0;
        while (i < paramArrayOfString.length - 1)
        {
          localStringBuilder.append(paramArrayOfString[i]).append(",");
          i += 1;
        }
      }
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    return localStringBuilder.toString();
  }
  
  public static String[] a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split(",");
    }
    return null;
  }
  
  private SharedPreferences b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("tbs_emergence", 4);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public List<String> a(Context paramContext, String paramString)
  {
    paramString = b(paramContext).getString(paramString, "");
    paramContext = new ArrayList();
    paramString = paramString.split(";");
    if (paramString.length > 0) {
      paramContext.addAll(Arrays.asList(paramString));
    }
    return paramContext;
  }
  
  public void a(Context paramContext)
  {
    b = f.a(new File(paramContext.getFilesDir(), "prefs.lock"));
  }
  
  public void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = b(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
    paramContext.commit();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    List localList = a(paramContext, paramString1);
    localList.add(paramString2);
    a(paramContext, paramString1, localList);
  }
  
  public void a(Context paramContext, String paramString, List<String> paramList)
  {
    paramContext = b(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() > 1)
      {
        int i = 0;
        while (i < paramList.size() - 1)
        {
          localStringBuilder.append((String)paramList.get(i));
          localStringBuilder.append(";");
          i += 1;
        }
      }
      localStringBuilder.append((String)paramList.get(paramList.size() - 1));
    }
    paramContext.putString(paramString, localStringBuilder.toString());
    paramContext.apply();
    paramContext.commit();
  }
  
  public long b(Context paramContext, String paramString)
  {
    return b(paramContext).getLong(paramString, -1L);
  }
  
  public boolean b()
  {
    return b != null;
  }
  
  public void c()
  {
    if (b != null)
    {
      b.b();
      b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.g
 * JD-Core Version:    0.7.0.1
 */