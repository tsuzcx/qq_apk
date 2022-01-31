package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dh
  extends bm
{
  private long c;
  private String d;
  
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
    str = "?uin=" + this.c + "&aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_domain" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.realuin")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("domain name:" + paramJSONObject);
      int i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        a(i, paramJSONObject.getString("info"));
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("domain_list");
      if (paramJSONObject.length() > 0) {
        this.d = paramJSONObject.getString(0);
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dh
 * JD-Core Version:    0.7.0.1
 */