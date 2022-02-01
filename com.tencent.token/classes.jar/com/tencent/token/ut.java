package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ut
  extends tk
{
  public static String d;
  public static String e;
  public static String f;
  private long g;
  private long h;
  private int i;
  private int j;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.g = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.h = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.j = ((Integer)paramaar.c.get("param.general.mobilecode.sceneid")).intValue();
    this.i = paramaar.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    Object localObject;
    if (k != 0)
    {
      localObject = paramJSONObject.getString("info");
      if (k == 124)
      {
        paramJSONObject = aad.d(paramJSONObject.getString("data"));
        if (paramJSONObject != null)
        {
          paramJSONObject = new JSONObject(new String(paramJSONObject));
          d = paramJSONObject.getString("sms_port");
          e = paramJSONObject.getString("sms_up_code");
          try
          {
            f = paramJSONObject.getString("mobile_sms_prefix");
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
          }
          paramJSONObject = new StringBuilder("realname port=");
          paramJSONObject.append(d);
          paramJSONObject.append(", content=");
          paramJSONObject.append(e);
          xb.b(paramJSONObject.toString());
        }
      }
      a(k, (String)localObject);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject = new StringBuilder("json");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      xb.a(((StringBuilder)localObject).toString());
      k = paramJSONObject.getInt("seq_id");
      if (k != this.i)
      {
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.i);
        xb.c(paramJSONObject.toString());
        this.a.a(10030, null, null);
        return;
      }
      d = paramJSONObject.getString("sms_port");
      e = paramJSONObject.getString("sms_up_code");
      try
      {
        f = paramJSONObject.getString("mobile_sms_prefix");
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = new StringBuilder("realname port=");
      paramJSONObject.append(d);
      paramJSONObject.append(", content=");
      paramJSONObject.append(e);
      xb.b(paramJSONObject.toString());
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ut
 * JD-Core Version:    0.7.0.1
 */