package com.tencent.qmsp.sdk.a;

import android.os.Build.VERSION;
import com.tencent.qmsp.sdk.app.QmspSDK;
import org.json.JSONObject;

public class d
{
  public static JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(e.a(0), paramInt);
      localJSONObject.put(e.a(1), QmspSDK.getAppID());
      localJSONObject.put(e.a(2), QmspSDK.getDevId());
      localJSONObject.put(e.a(3), QmspSDK.getUid());
      localJSONObject.put(e.a(4), QmspSDK.getQImeiVer());
      localJSONObject.put(e.a(5), Build.VERSION.SDK_INT);
      localJSONObject.put(e.a(6), c.c());
      localJSONObject.put(e.a(7), c.e());
      localJSONObject.put(e.a(8), System.currentTimeMillis());
      localJSONObject.put(e.a(9), 1);
      String str2 = e.a(10);
      boolean bool = c.h();
      if (bool) {}
      for (String str1 = "1";; str1 = "0")
      {
        localJSONObject.put(str2, str1);
        str1 = e.a(11);
        localJSONObject.put(str1, "");
        return localJSONObject;
      }
      return null;
    }
    finally
    {
      localObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */