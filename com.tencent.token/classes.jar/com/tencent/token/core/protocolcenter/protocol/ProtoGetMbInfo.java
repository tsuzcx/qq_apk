package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.eq;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetMbInfo
  extends e
{
  MbInfoResult d;
  private long e;
  
  public static void a(ev paramev, long paramLong)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.c = i;
    String str2 = w.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_mbinfo_encrypt" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.uinhash")).longValue();
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
      if (this.c != i)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.c);
        return;
      }
      this.d = new MbInfoResult(paramJSONObject.getJSONArray("mb_list"));
      eq.a().a(this.d);
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMbInfo
 * JD-Core Version:    0.7.0.1
 */