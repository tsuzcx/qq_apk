package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class eo
  extends bm
{
  RealNameQueryResult c;
  private long d;
  private int e;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    str1 = b.c() + "/cn/mbtoken3/mbtoken3_realname_qry" + str1;
    e.c("ProtoQueryRealName url: " + str1);
    return str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.e = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    e.c("ProtoQueryRealName parseJSON errCode: " + i);
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
        return;
      }
      this.c = new RealNameQueryResult(paramJSONObject);
      e.c("result rebind_type: " + this.c.b());
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
      localMessage.obj = this.c;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eo
 * JD-Core Version:    0.7.0.1
 */