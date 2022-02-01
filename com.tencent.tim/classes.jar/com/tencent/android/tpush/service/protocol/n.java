package com.tencent.android.tpush.service.protocol;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class n
  extends e
{
  public long a = 0L;
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public String e = "";
  public long f = 0L;
  public long g = 0L;
  public String h = "";
  public String i = "";
  public int j = -1;
  public ArrayList<String> k = null;
  
  public MessageType a()
  {
    return MessageType.REGISTER;
  }
  
  public void a(String paramString)
  {
    paramString = new JSONObject(paramString);
    this.a = paramString.optLong("confVersion", this.a);
    this.b = paramString.optString("token", this.b);
    this.c = paramString.optLong("guid", this.c);
    this.d = paramString.optLong("otherPushTokenType", this.d);
    this.e = paramString.optString("otherPushToken", this.e);
    this.f = paramString.optLong("otherPushTokenCrc32", this.f);
    this.g = paramString.optLong("tokenCrc32", this.g);
    this.h = paramString.optString("reserved", this.h);
    this.i = paramString.optString("ticket", this.i);
    this.j = paramString.optInt("ticketType", this.j);
    paramString = paramString.optJSONArray("groupKeys");
    if (paramString != null)
    {
      this.k = new ArrayList();
      int m = 0;
      while (m < paramString.length())
      {
        this.k.add(paramString.getString(m));
        m += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.n
 * JD-Core Version:    0.7.0.1
 */