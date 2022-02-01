package com.tencent.qmsp.sdk.a;

import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.app.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static String a = "Qp.RPT";
  
  public static void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (!(paramString instanceof String))) {}
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    JSONObject localJSONObject2;
    Object localObject;
    do
    {
      return;
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      localJSONObject2 = new JSONObject();
      localObject = d.a(3);
    } while (!a((JSONObject)localObject));
    try
    {
      localJSONObject2.put(e.a(15), localObject);
      localObject = e.a(16);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject2.put((String)localObject, localJSONObject3.put("log", paramString));
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("arr", localJSONArray);
      com.tencent.qmsp.sdk.f.g.a(a, 1, localJSONObject2.toString());
      b.e().a(new f.a(paramInt, localJSONObject1));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected static boolean a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put(e.a(12), c.b());
      paramJSONObject.put(e.a(13), c.f());
      paramJSONObject.put(e.a(14), c.a());
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
  
  private static void b(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    com.tencent.qmsp.sdk.f.g.a(a, 0, "Rpt: " + paramJSONObject);
    com.tencent.qmsp.sdk.b.g.b().a(3, QmspSDK.getAppID(), paramInt, paramJSONObject, new f.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */