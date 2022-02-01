package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

public class q
{
  int a = 0;
  String b = null;
  
  public JSONObject a()
  {
    if (this.b == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("accountType", this.a);
    localJSONObject.put("account", this.b);
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.q
 * JD-Core Version:    0.7.0.1
 */