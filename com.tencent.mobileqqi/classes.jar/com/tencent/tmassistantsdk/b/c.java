package com.tencent.tmassistantsdk.b;

import com.tencent.tmassistantsdk.f.d;
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
  
  public c(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3)
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
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    paramArrayOfByte = new d().a(paramArrayOfByte, "&-*)Wb5_U,[^!9'+".getBytes());
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      paramArrayOfByte = new c(paramArrayOfByte.getString("mHostPackageName"), paramArrayOfByte.getInt("mHostVersion"), paramArrayOfByte.getString("mHostUserIdentity"), paramArrayOfByte.getInt("mDataItemType"), paramArrayOfByte.getString("mDataItemAction"), paramArrayOfByte.getLong("mDataItemStartTime"), paramArrayOfByte.getLong("mDataItemEndTime"), paramArrayOfByte.getInt("mDataItemVersion"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
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
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null)
      {
        localObject = ((String)localObject).getBytes("UTF-8");
        if (localObject != null)
        {
          localObject = new d().b((byte[])localObject, "&-*)Wb5_U,[^!9'+".getBytes());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.b.c
 * JD-Core Version:    0.7.0.1
 */