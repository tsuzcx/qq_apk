package com.tencent.android.tpush.service.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public class g
{
  public long a = -1L;
  public String b = "";
  public String c = "";
  
  public boolean a()
  {
    return (this.a > 0L) && (!TextUtils.isEmpty(this.b)) && (!this.b.equals("0")) && (!TextUtils.isEmpty(this.c));
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("accessid", this.a);
    localJSONObject.put("token", this.b);
    localJSONObject.put("channel", this.c);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.g
 * JD-Core Version:    0.7.0.1
 */