package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
{
  public SharedPreferences a = null;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public Context e = null;
  public String f = "";
  
  public ae(Context paramContext, String paramString)
  {
    try
    {
      this.e = paramContext;
      this.f = paramString;
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool1 = al.a(paramArrayOfByte);
      boolean bool2 = paramString.equalsIgnoreCase(ag.b(paramArrayOfByte));
      if ((bool1) && (bool2)) {
        return true;
      }
    }
    return false;
  }
  
  private byte[] b()
  {
    if (TextUtils.isEmpty(this.d)) {
      return null;
    }
    Object localObject;
    try
    {
      localObject = new File(this.d);
      if (((File)localObject).exists())
      {
        byte[] arrayOfByte = new byte[(int)((File)localObject).length()];
        localObject = new FileInputStream((File)localObject);
        try
        {
          ((FileInputStream)localObject).read(arrayOfByte);
          ((FileInputStream)localObject).close();
          return arrayOfByte;
        }
        catch (Exception localException1) {}
      }
      else
      {
        localObject = null;
      }
    }
    catch (Exception localException2)
    {
      localObject = null;
      localException2.printStackTrace();
    }
    if (localObject != null) {
      try
      {
        ((FileInputStream)localObject).close();
        return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return null;
  }
  
  private void c()
  {
    try
    {
      Object localObject = b();
      Context localContext = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localContext.getFilesDir().toString());
      localStringBuilder.append(aa.a(ak.a[3]));
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      this.d = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(aa.a(ak.a[0]));
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      this.a = localContext.getSharedPreferences(localStringBuilder.toString(), 0);
      this.b = this.a.getLong(aa.a(ak.a[1]), 0L);
      this.c = this.a.getString(aa.a(ak.a[2]), "");
      if (!a((byte[])localObject, this.c))
      {
        localObject = this.a.edit();
        ((SharedPreferences.Editor)localObject).clear();
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new File(this.d);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        this.c = "";
        this.b = 0L;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      c();
      localJSONObject.put(ak.a(24), 1);
      localJSONObject.put(ak.a(27), this.b);
      localJSONObject.put(ak.a(28), this.c);
      localJSONObject.put(ak.a(26), "");
      localJSONObject.put(ak.a(25), "");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final void a(long paramLong, String paramString)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        SharedPreferences.Editor localEditor = this.a.edit();
        localEditor.putLong(aa.a(ak.a[1]), paramLong);
        localEditor.putString(aa.a(ak.a[2]), paramString);
        localEditor.commit();
        this.b = paramLong;
        this.c = paramString;
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ae
 * JD-Core Version:    0.7.0.1
 */