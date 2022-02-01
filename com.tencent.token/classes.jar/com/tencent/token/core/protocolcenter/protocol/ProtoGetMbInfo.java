package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dj;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetMbInfo
  extends d
{
  MbInfoResult d;
  private long e;
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.c = i;
    String str2 = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_mbinfo_encrypt" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
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
      if (this.c != i)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.c);
        return;
      }
      this.d = new MbInfoResult(paramJSONObject.getJSONArray("mb_list"));
      dj.a().a(this.d);
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMbInfo
 * JD-Core Version:    0.7.0.1
 */