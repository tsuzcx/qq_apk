package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.net.HttpUtil;
import com.tencent.mapsdk.net.NetResponse;
import java.io.IOException;
import org.json.JSONException;

abstract class c<T, V>
{
  protected T a;
  protected String b = null;
  protected String c = "";
  
  public c(T paramT)
  {
    this.a = paramT;
  }
  
  protected abstract V a(byte[] paramArrayOfByte)
    throws IOException, JSONException;
  
  protected abstract String a();
  
  public final V b()
  {
    if (this.a == null) {
      return null;
    }
    this.c = a();
    try
    {
      NetResponse localNetResponse = HttpUtil.sendSyncGetRequest(this.c, "Android_SDK");
      if ((localNetResponse == null) || (localNetResponse.data == null)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    this.b = localException.charset;
    try
    {
      Object localObject = a(localException.data);
      return localObject;
    }
    catch (IOException localIOException)
    {
      return null;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.c
 * JD-Core Version:    0.7.0.1
 */