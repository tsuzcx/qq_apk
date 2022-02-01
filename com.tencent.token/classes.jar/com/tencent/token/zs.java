package com.tencent.token;

import org.json.JSONException;
import org.json.JSONObject;

public final class zs
{
  String a;
  String b;
  String c;
  String d;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("id", this.d);
      localJSONObject.put("version", this.b);
      localJSONObject.put("publickey", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zs
 * JD-Core Version:    0.7.0.1
 */