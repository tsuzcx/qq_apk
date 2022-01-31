package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class dv
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
    str = "?aq_base_sid=" + str + "&uin=" + this.c;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_ads_info" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    this.d = paramJSONObject.getString("ads_info");
    this.a.a = 0;
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
 * Qualified Name:     com.tencent.token.dv
 * JD-Core Version:    0.7.0.1
 */