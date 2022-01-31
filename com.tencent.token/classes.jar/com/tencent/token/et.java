package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class et
  extends bm
{
  private long c;
  private String d;
  private int e = -1;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?uin=" + this.c + "&aq_base_sid=" + str + "&data=" + this.d;
    e.c("params: " + str);
    return b.c() + "/cn/mbtoken3/mbtoken3_report_location" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((String)paramfs.c.get("param.loginmsg.reportlocation"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    try
    {
      this.e = paramJSONObject.getInt("is_priv_ip_user");
      this.a.a = 0;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.e = -1;
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.et
 * JD-Core Version:    0.7.0.1
 */