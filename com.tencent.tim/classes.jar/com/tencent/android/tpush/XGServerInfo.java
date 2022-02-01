package com.tencent.android.tpush;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XGServerInfo
{
  public static final String TAG_IP = "ip";
  public static final String TAG_PORT = "port";
  public static final String TAG_PROXY_IP = "p_ip";
  public static final String TAG_PROXY_PORT = "p_port";
  private JSONArray a = new JSONArray();
  
  public XGServerInfo() {}
  
  public XGServerInfo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.a = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramInt1 > 0)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ip", paramString1);
      localJSONObject.put("port", paramInt1);
      if (!TextUtils.isEmpty(paramString2))
      {
        localJSONObject.put("p_ip", paramInt2);
        localJSONObject.put("p_port", paramInt2);
      }
      this.a.put(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public XGServerInfo addServerIp(String paramString, int paramInt)
  {
    a(paramString, paramInt, null, 0);
    return this;
  }
  
  public XGServerInfo addServerIp(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramString1, paramInt1, paramString2, paramInt2);
    return this;
  }
  
  public JSONArray getIpArray()
  {
    return this.a;
  }
  
  public boolean isEmpty()
  {
    return (this.a != null) && (this.a.length() > 0);
  }
  
  public void reset()
  {
    this.a = new JSONArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGServerInfo
 * JD-Core Version:    0.7.0.1
 */