package com.tencent.tmassistantsdk.b;

import com.tencent.tmassistantsdk.f.a;
import com.tencent.tmassistantsdk.f.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public int a = -1;
  public long b = 0L;
  public long c = 0L;
  private String d = "";
  private int e = 0;
  private String f = "";
  private int g = 0;
  private String h = "";
  private int i = 0;
  private byte[] j = null;
  
  public c(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.d = paramString1;
    if (this.d == null) {
      this.d = "";
    }
    this.e = paramInt1;
    this.f = paramString2;
    if (this.f == null) {
      this.f = "";
    }
    this.g = paramInt2;
    this.h = paramString3;
    if (this.h == null) {
      this.h = "";
    }
    this.b = paramLong1;
    this.c = paramLong2;
    this.i = paramInt3;
    this.j = paramArrayOfByte;
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    paramArrayOfByte = new e().a(paramArrayOfByte, "&-*)Wb5_U,[^!9'+".getBytes());
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str1 = paramArrayOfByte.getString("mHostPackageName");
      k = paramArrayOfByte.getInt("mHostVersion");
      str2 = paramArrayOfByte.getString("mHostUserIdentity");
      m = paramArrayOfByte.getInt("mDataItemType");
      str3 = paramArrayOfByte.getString("mDataItemAction");
      l1 = paramArrayOfByte.getLong("mDataItemStartTime");
      l2 = paramArrayOfByte.getLong("mDataItemEndTime");
      n = paramArrayOfByte.getInt("mDataItemVersion");
      if (n <= 0) {
        break label171;
      }
      paramArrayOfByte = paramArrayOfByte.getString("mIPCData");
      if (paramArrayOfByte == null) {
        break label171;
      }
      paramArrayOfByte = a.a(paramArrayOfByte, 0);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      String str1;
      int k;
      String str2;
      int m;
      String str3;
      long l1;
      long l2;
      int n;
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        paramArrayOfByte = null;
      }
    }
    paramArrayOfByte = new c(str1, k, str2, m, str3, l1, l2, n, paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public final byte[] a()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("mHostPackageName", this.d);
      ((JSONObject)localObject).put("mHostVersion", this.e);
      ((JSONObject)localObject).put("mHostUserIdentity", this.f);
      ((JSONObject)localObject).put("mDataItemType", this.g);
      ((JSONObject)localObject).put("mDataItemAction", this.h);
      ((JSONObject)localObject).put("mDataItemStartTime", this.b);
      ((JSONObject)localObject).put("mDataItemEndTime", this.c);
      ((JSONObject)localObject).put("mDataItemVersion", this.i);
      if ((this.i > 0) && (this.j != null))
      {
        String str = a.a(this.j, 0);
        if (str != null) {
          ((JSONObject)localObject).put("mIPCData", str);
        }
      }
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null)
      {
        localObject = ((String)localObject).getBytes("UTF-8");
        if (localObject != null)
        {
          localObject = new e().b((byte[])localObject, "&-*)Wb5_U,[^!9'+".getBytes());
          return localObject;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.b.c
 * JD-Core Version:    0.7.0.1
 */