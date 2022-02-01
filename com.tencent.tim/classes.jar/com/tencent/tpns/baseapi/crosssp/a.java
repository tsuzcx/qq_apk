package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.tencent.tpns.baseapi.base.SettingsContentProvider;
import com.tencent.tpns.baseapi.base.util.Logger;

public class a
{
  public static volatile a a = null;
  private Context b;
  
  private a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public float a(String paramString, float paramFloat)
  {
    try
    {
      paramString = SettingsContentProvider.getContentUri(this.b, paramString, "float");
      paramFloat = SettingsContentProvider.getFloatValue(ProviderMessage.query(this.b, paramString, null, null, null, null), paramFloat);
      return paramFloat;
    }
    catch (Throwable paramString)
    {
      Logger.e("SettingsPreferences", "error = ", paramString);
    }
    return 0.0F;
  }
  
  public int a(String paramString, int paramInt)
  {
    try
    {
      paramString = SettingsContentProvider.getContentUri(this.b, paramString, "integer");
      paramInt = SettingsContentProvider.getIntValue(ProviderMessage.query(this.b, paramString, null, null, null, null), paramInt);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      Logger.e("SettingsPreferences", "error = ", paramString);
    }
    return 0;
  }
  
  public long a(String paramString, long paramLong)
  {
    try
    {
      paramString = SettingsContentProvider.getContentUri(this.b, paramString, "long");
      paramLong = SettingsContentProvider.getLongValue(ProviderMessage.query(this.b, paramString, null, null, null, null), paramLong);
      return paramLong;
    }
    catch (Throwable paramString)
    {
      Logger.e("SettingsPreferences", "error = ", paramString);
    }
    return 0L;
  }
  
  public a a()
  {
    return new a(this.b, null);
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SettingsContentProvider.getContentUri(this.b, paramString1, "string");
      paramString1 = SettingsContentProvider.getStringValue(ProviderMessage.query(this.b, paramString1, null, null, null, null), paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Logger.e("SettingsPreferences", "error = ", paramString1);
    }
    return "";
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = SettingsContentProvider.getContentUri(this.b, paramString, "boolean");
      paramBoolean = SettingsContentProvider.getBooleanValue(ProviderMessage.query(this.b, paramString, null, null), paramBoolean);
      return paramBoolean;
    }
    catch (Throwable paramString)
    {
      Logger.e("SettingsPreferences", "error = ", paramString);
    }
    return false;
  }
  
  public Object b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SettingsContentProvider.getContentUri(this.b, paramString1, "memory");
      paramString1 = SettingsContentProvider.getObjectValue(ProviderMessage.query(this.b, paramString1, null, null), paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Logger.e("SettingsPreferences", "error = ", paramString1);
    }
    return Boolean.valueOf(false);
  }
  
  public static class a
  {
    Context a;
    private ContentValues b = new ContentValues();
    
    private a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public a a(String paramString, float paramFloat)
    {
      this.b.put(paramString, Float.valueOf(paramFloat));
      return this;
    }
    
    public a a(String paramString, int paramInt)
    {
      this.b.put(paramString, Integer.valueOf(paramInt));
      return this;
    }
    
    public a a(String paramString, long paramLong)
    {
      this.b.put(paramString, Long.valueOf(paramLong));
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.b.put(paramString1, paramString2);
      return this;
    }
    
    public a a(String paramString, boolean paramBoolean)
    {
      this.b.put(paramString, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public void a()
    {
      try
      {
        Uri localUri = SettingsContentProvider.getContentUri(this.a, "key", "type");
        ProviderMessage.insert(this.a, localUri, this.b);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("SettingsPreferences", "apply", localThrowable);
      }
    }
    
    public void a(String paramString)
    {
      this.b.putNull(paramString);
    }
    
    public void b()
    {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.crosssp.a
 * JD-Core Version:    0.7.0.1
 */