package com.tencent.qqmini.sdk.core.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectFix
  extends JSONObject
{
  public JSONObjectFix() {}
  
  public JSONObjectFix(String paramString)
    throws JSONException
  {
    super(paramString);
  }
  
  public String optString(String paramString1, String paramString2)
  {
    if (isNull(paramString1)) {
      return paramString2;
    }
    return super.optString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.JSONObjectFix
 * JD-Core Version:    0.7.0.1
 */