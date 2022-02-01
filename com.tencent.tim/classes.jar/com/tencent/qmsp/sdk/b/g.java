package com.tencent.qmsp.sdk.b;

import android.text.TextUtils;
import com.tencent.qmsp.sdk.f.k;
import org.json.JSONObject;

public class g
{
  private static g c;
  private String a = "Qp.netImp";
  private f b = null;
  
  private JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    if ((!(paramJSONObject instanceof JSONObject)) || (paramJSONObject == null)) {
      return null;
    }
    if (paramInt == 8)
    {
      try
      {
        paramJSONObject = paramJSONObject.toString();
        paramJSONObject = com.tencent.qmsp.sdk.c.f.a(paramInt, 0, 0, 0, paramJSONObject, "");
        if ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject))) {
          break label125;
        }
        localJSONObject = new JSONObject();
        localJSONObject.put(com.tencent.qmsp.sdk.a.e.a(17), paramJSONObject);
        return localJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    else
    {
      while (paramInt != 9)
      {
        JSONObject localJSONObject;
        return null;
      }
      paramJSONObject = a(paramJSONObject);
      paramJSONObject = com.tencent.qmsp.sdk.c.f.a(paramInt, 0, 0, 0, paramJSONObject, "");
      if ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject))) {
        break label127;
      }
      paramJSONObject = new JSONObject(paramJSONObject);
      return paramJSONObject;
    }
    label125:
    return null;
    label127:
    return null;
  }
  
  public static g b()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new g();
      }
      return c;
    }
    finally {}
  }
  
  private JSONObject b(int paramInt, JSONObject paramJSONObject)
  {
    if ((!(paramJSONObject instanceof JSONObject)) || (paramJSONObject == null)) {
      return null;
    }
    return a(paramInt, paramJSONObject);
  }
  
  public String a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString(com.tencent.qmsp.sdk.a.e.a(17));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    this.b = new g.a(this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject, e parame)
  {
    f localf;
    if (((paramJSONObject instanceof JSONObject)) && (paramJSONObject != null) && (parame != null))
    {
      localf = this.b;
      if (localf != null) {}
    }
    else
    {
      com.tencent.qmsp.sdk.f.g.d(this.a, 0, k.a(k.a));
      return;
    }
    localf.a(paramInt1, paramString, paramInt2, paramJSONObject, parame);
  }
  
  public void a(f paramf)
  {
    if ((paramf == null) || (!(paramf instanceof f)))
    {
      com.tencent.qmsp.sdk.f.g.d(this.a, 0, k.a(k.a));
      return;
    }
    this.b = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.g
 * JD-Core Version:    0.7.0.1
 */