package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vm
  extends ud
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
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.g = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.h = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.j = ((Integer)paramabm.c.get("param.general.mobilecode.sceneid")).intValue();
    this.i = paramabm.j;
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
        paramJSONObject = aay.d(paramJSONObject.getString("data"));
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
          xv.b(paramJSONObject.toString());
        }
      }
      a(k, (String)localObject);
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject = new StringBuilder("json");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      xv.a(((StringBuilder)localObject).toString());
      k = paramJSONObject.getInt("seq_id");
      if (k != this.i)
      {
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.i);
        xv.c(paramJSONObject.toString());
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
      xv.b(paramJSONObject.toString());
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vm
 * JD-Core Version:    0.7.0.1
 */