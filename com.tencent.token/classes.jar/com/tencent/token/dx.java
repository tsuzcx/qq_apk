package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class dx
  extends bm
{
  RealNameStatusResult c;
  private long d;
  private long e;
  private int f;
  
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
    Object localObject = ag.c();
    ((ag)localObject).m();
    localObject = ((ag)localObject).j().replaceAll("-", "");
    if ((this.e == 0L) && (ax.a().e() != null)) {
      this.e = ax.a().e().mRealUin;
    }
    localObject = s.a(new Object[] { "real_uin", Long.valueOf(this.e), "token_seq", localObject, "guid", s.a(x.a(RqdApplication.i()).c()), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str = "?uin=" + this.d + "&aq_base_sid=" + str + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_realname_status_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
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
      if (i != this.f)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.f);
        return;
      }
      this.c = new RealNameStatusResult(paramJSONObject);
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
 * Qualified Name:     com.tencent.token.dx
 * JD-Core Version:    0.7.0.1
 */