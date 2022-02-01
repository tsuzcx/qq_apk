package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

public class XGPushRegisterResult
  implements XGIResult
{
  long a = 0L;
  String b = "";
  String c = "";
  String d = "";
  short e = 0;
  String f = "";
  String g = "";
  int h = 100;
  
  public long getAccessId()
  {
    return this.a;
  }
  
  public String getAccount()
  {
    return this.c;
  }
  
  public String getFacilityIdentity()
  {
    return this.b;
  }
  
  public String getOtherPushToken()
  {
    return this.g;
  }
  
  public int getPushChannel()
  {
    return this.h;
  }
  
  public String getTicket()
  {
    return this.d;
  }
  
  public short getTicketType()
  {
    return this.e;
  }
  
  public String getToken()
  {
    return this.f;
  }
  
  public void parseIntent(Intent paramIntent)
  {
    try
    {
      this.a = paramIntent.getLongExtra("accId", -1L);
      this.b = paramIntent.getStringExtra("deviceId");
      this.c = paramIntent.getStringExtra("account");
      this.d = paramIntent.getStringExtra("ticket");
      this.e = paramIntent.getShortExtra("ticketType", (short)0);
      this.f = paramIntent.getStringExtra("token");
      return;
    }
    catch (Throwable paramIntent)
    {
      TLogger.w("XGPushRegisterResult", "unexpected for parseIntent");
    }
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("account", this.c);
      localJSONObject.put("ticket", this.d);
      localJSONObject.put("deviceId", this.b);
      localJSONObject.put("ticketType", this.e);
      localJSONObject.put("token", this.f);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("XGPushRegisterResult", "unexpected for toJson");
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPushRegisterMessage [accessId=").append(this.a).append(", deviceId=").append(this.b).append(", account=").append(this.c).append(", ticket=").append(this.d).append(", ticketType=").append(this.e).append(", token=").append(this.f).append(", pushChannel=").append(this.h).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushRegisterResult
 * JD-Core Version:    0.7.0.1
 */