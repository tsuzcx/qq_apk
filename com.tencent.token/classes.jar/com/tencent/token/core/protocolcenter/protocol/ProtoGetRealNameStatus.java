package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetRealNameStatus
  extends d
{
  RealNameStatusResult d;
  private long e;
  private long f;
  private int g;
  
  public static void a(do paramdo, long paramLong1, long paramLong2, int paramInt)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.j = paramInt;
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = cc.c();
    ((cc)localObject).m();
    localObject = ((cc)localObject).j().replaceAll("-", "");
    if ((this.f == 0L) && (cr.a().e() != null)) {
      this.f = cr.a().e().mRealUin;
    }
    localObject = l.a(new Object[] { "uin", Long.valueOf(this.e), "token_seq", localObject, "guid", l.a(bz.a(RqdApplication.l()).b()), "seq_id", Integer.valueOf(this.g), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_status_encrypt" + str;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.f = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.g = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.g)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.g);
        return;
      }
      this.d = new RealNameStatusResult(paramJSONObject);
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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