package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetEvalAccountResult
  extends e
{
  EvalAccountResult d;
  private long e;
  private int f;
  
  public static void a(ev paramev, long paramLong)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    h.c("account page ProtoGetEvalAccountResult packet params: user =" + paramLong);
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    h.c("account page generateUrl sessId =" + str);
    if (str == null)
    {
      this.a.b(104);
      h.c("account page generateUrl sessId =" + str);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.e);
      int i = cw.a + 1;
      cw.a = i;
      this.f = i;
      ((JSONObject)localObject2).put("seq_id", this.f);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_eval_account_v3" + (String)localObject1;
    h.c("account page generateUrl url =" + (String)localObject1);
    return localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.uinhash")).longValue();
    h.c("account page ProtoGetEvalAccountResult unpacketParams: user =" + this.e);
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
      if (i != this.f)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
        return;
      }
      this.d = new EvalAccountResult(paramJSONObject.getJSONObject("result"), paramJSONObject);
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetEvalAccountResult
 * JD-Core Version:    0.7.0.1
 */