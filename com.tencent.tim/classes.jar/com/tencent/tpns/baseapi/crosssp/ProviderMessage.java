package com.tencent.tpns.baseapi.crosssp;

import alld;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ProviderMessage
{
  private static ConcurrentHashMap<String, List<Long>> a = new ConcurrentHashMap();
  
  public static int delete(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = a.a(paramContext, paramUri, paramString, paramArrayOfString);
      return i;
    }
    catch (Throwable paramContext)
    {
      Logger.e("ProviderMessage", "delete", paramContext);
    }
    return 0;
  }
  
  public static int delete(Context paramContext, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    return delete(paramContext, Uri.parse("content://" + paramString1 + "/" + paramString2), paramString3, paramArrayOfString);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    try
    {
      paramContext = a.a(paramContext, paramUri);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("ProviderMessage", "getType", paramContext);
    }
    return null;
  }
  
  public static String getType(Context paramContext, String paramString1, String paramString2)
  {
    return getType(paramContext, Uri.parse("content://" + paramString1 + "/" + paramString2));
  }
  
  public static Uri insert(Context paramContext, Uri paramUri, ContentValues paramContentValues)
  {
    try
    {
      paramContext = a.a(paramContext, paramUri, paramContentValues);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("ProviderMessage", "insert", paramContext);
    }
    return null;
  }
  
  public static Uri insert(Context paramContext, String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insert(paramContext, Uri.parse("content://" + paramString1 + "/" + paramString2), paramContentValues);
  }
  
  public static void log(String paramString)
  {
    Logger.d("ProviderMessage", "" + paramString);
  }
  
  public static Cursor query(Context paramContext, Uri paramUri, String[] paramArrayOfString, String paramString)
  {
    return query(paramContext, paramUri, paramArrayOfString, paramString, null, null);
  }
  
  public static Cursor query(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      paramContext = a.a(paramContext, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("ProviderMessage", "query", paramContext);
    }
    return null;
  }
  
  public static Cursor query(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString1, String paramString3, String[] paramArrayOfString2, String paramString4)
  {
    return query(paramContext, Uri.parse("content://" + paramString1 + "/" + paramString2), paramArrayOfString1, paramString3, paramArrayOfString2, paramString4);
  }
  
  public static int update(Context paramContext, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = a.a(paramContext, paramUri, paramContentValues, paramString, paramArrayOfString);
      return i;
    }
    catch (Throwable paramContext)
    {
      Logger.e("ProviderMessage", "update", paramContext);
    }
    return 0;
  }
  
  public static int update(Context paramContext, String paramString1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString)
  {
    return update(paramContext, Uri.parse("content://" + paramString1 + "/" + paramString2), paramContentValues, paramString3, paramArrayOfString);
  }
  
  static class a<T>
    implements Runnable
  {
    private Context a;
    private Uri b;
    private String[] c;
    private String d;
    private String[] e;
    private String f;
    private ContentValues g;
    private String h;
    private int i;
    private T j;
    
    a(Context paramContext, Uri paramUri)
    {
      this.a = paramContext;
      this.b = paramUri;
      this.i = 3;
    }
    
    a(Context paramContext, Uri paramUri, ContentValues paramContentValues)
    {
      this.a = paramContext;
      this.b = paramUri;
      this.g = paramContentValues;
      this.i = 2;
    }
    
    a(Context paramContext, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      this.a = paramContext;
      this.b = paramUri;
      this.g = paramContentValues;
      this.h = paramString;
      this.e = paramArrayOfString;
      this.i = 4;
    }
    
    a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      this.a = paramContext;
      this.b = paramUri;
      this.h = paramString;
      this.e = paramArrayOfString;
      this.i = 5;
    }
    
    a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      this.a = paramContext;
      this.b = paramUri;
      this.c = paramArrayOfString1;
      this.d = paramString1;
      this.e = paramArrayOfString2;
      this.f = paramString2;
      this.i = 1;
    }
    
    static int a(Context paramContext, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      paramContext = new a(paramContext, paramUri, paramContentValues, paramString, paramArrayOfString);
      paramUri = new Thread(paramContext);
      paramUri.start();
      try
      {
        paramUri.join(1000L);
        return ((Integer)paramContext.a()).intValue();
      }
      catch (Throwable paramUri)
      {
        for (;;)
        {
          Logger.e("ProviderMessage", "myUpdate", paramUri);
        }
      }
    }
    
    static int a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      paramContext = new a(paramContext, paramUri, paramString, paramArrayOfString);
      paramUri = new Thread(paramContext);
      paramUri.start();
      try
      {
        paramUri.join(1000L);
        return ((Integer)paramContext.a()).intValue();
      }
      catch (Throwable paramUri)
      {
        for (;;)
        {
          Logger.e("ProviderMessage", "myDelete", paramUri);
        }
      }
    }
    
    static Cursor a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      paramContext = new a(paramContext, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      paramUri = new Thread(paramContext);
      paramUri.start();
      try
      {
        paramUri.join(1000L);
        return (Cursor)paramContext.a();
      }
      catch (Throwable paramUri)
      {
        for (;;)
        {
          Logger.e("ProviderMessage", "myQuery", paramUri);
        }
      }
    }
    
    static Uri a(Context paramContext, Uri paramUri, ContentValues paramContentValues)
    {
      paramContext = new a(paramContext, paramUri, paramContentValues);
      paramUri = new Thread(paramContext);
      paramUri.start();
      try
      {
        paramUri.join(1000L);
        return (Uri)paramContext.a();
      }
      catch (Throwable paramUri)
      {
        for (;;)
        {
          Logger.e("ProviderMessage", "myInsert", paramUri);
        }
      }
    }
    
    static String a(Context paramContext, Uri paramUri)
    {
      paramContext = new a(paramContext, paramUri);
      paramUri = new Thread(paramContext);
      paramUri.start();
      try
      {
        paramUri.join(1000L);
        return (String)paramContext.a();
      }
      catch (Throwable paramUri)
      {
        for (;;)
        {
          Logger.e("ProviderMessage", "myGetType", paramUri);
        }
      }
    }
    
    public T a()
    {
      return this.j;
    }
    
    public void a(T paramT)
    {
      this.j = paramT;
    }
    
    public void run()
    {
      Object localObject = null;
      for (;;)
      {
        try
        {
          switch (this.i)
          {
          case 1: 
            a(localObject);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          int k;
          Logger.e("ProviderMessage", "call", localThrowable);
          return;
        }
        localObject = alld.query(this.a.getContentResolver(), this.b, this.c, this.d, this.e, this.f);
        continue;
        localObject = this.a.getContentResolver().insert(this.b, this.g);
        continue;
        localObject = this.a.getContentResolver().getType(this.b);
        continue;
        localObject = Integer.valueOf(this.a.getContentResolver().update(this.b, this.g, this.h, this.e));
        continue;
        k = this.a.getContentResolver().delete(this.b, this.h, this.e);
        localObject = Integer.valueOf(k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.crosssp.ProviderMessage
 * JD-Core Version:    0.7.0.1
 */