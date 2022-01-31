package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cp;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetRealNameStatus
  extends e
{
  RealNameStatusResult d;
  private long e;
  private long f;
  private int g;
  
  public static void a(ev paramev, long paramLong1, long paramLong2, int paramInt)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramev.c.put("param.realuin", Long.valueOf(paramLong2));
    paramev.j = paramInt;
  }
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = cx.c();
    ((cx)localObject).m();
    localObject = ((cx)localObject).j().replaceAll("-", "");
    if ((this.f == 0L) && (do.a().e() != null)) {
      this.f = do.a().e().mRealUin;
    }
    localObject = w.a(new Object[] { "uin", Long.valueOf(this.e), "token_seq", localObject, "guid", w.a(cp.a(RqdApplication.l()).b()), "seq_id", Integer.valueOf(this.g), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_status_encrypt" + str;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.f = ((Long)paramev.c.get("param.realuin")).longValue();
    this.g = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.g)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.g);
        return;
      }
      this.d = new RealNameStatusResult(paramJSONObject);
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameStatus
 * JD-Core Version:    0.7.0.1
 */