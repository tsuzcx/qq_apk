package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ui
  extends ud
{
  public static int d = -1;
  public static int e = -1;
  private long f;
  private int g;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.f = ((Long)paramabm.c.get("param.realuin")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.g = paramJSONObject.getInt("need_idcard_detect");
      if (this.g == 1) {
        try
        {
          d = paramJSONObject.getInt("displayangle");
          e = paramJSONObject.getInt("imageangle");
          paramJSONObject = new StringBuilder("plain angle=");
          paramJSONObject.append(d);
          paramJSONObject.append(",angel2=");
          paramJSONObject.append(e);
          xv.a(paramJSONObject.toString());
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui
 * JD-Core Version:    0.7.0.1
 */