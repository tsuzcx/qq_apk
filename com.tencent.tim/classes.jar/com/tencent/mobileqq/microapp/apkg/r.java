package com.tencent.mobileqq.microapp.apkg;

import org.json.JSONObject;

public final class r
{
  public static r a(JSONObject paramJSONObject)
  {
    r localr = new r();
    if (paramJSONObject == null)
    {
      if (paramJSONObject != null) {
        break label38;
      }
      label16:
      if (paramJSONObject != null) {
        break label50;
      }
    }
    for (;;)
    {
      if (paramJSONObject != null) {
        break label62;
      }
      return localr;
      paramJSONObject.optInt("request", 60000);
      break;
      label38:
      paramJSONObject.optInt("connectSocket", 60000);
      break label16;
      label50:
      paramJSONObject.optInt("uploadFile", 60000);
    }
    label62:
    paramJSONObject.optInt("downloadFile", 60000);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.r
 * JD-Core Version:    0.7.0.1
 */