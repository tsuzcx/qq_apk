package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetEvalAccountResult
  extends d
{
  EvalAccountResult d;
  private long e;
  private int f;
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    g.c("account page ProtoGetEvalAccountResult packet params: user =" + paramLong);
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = ca.a().b();
    g.c("account page generateUrl sessId =" + str);
    if (str == null)
    {
      this.a.b(104);
      g.c("account page generateUrl sessId =" + str);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.e);
      int i = cb.a + 1;
      cb.a = i;
      this.f = i;
      ((JSONObject)localObject2).put("seq_id", this.f);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      g.a("plain:" + (String)localObject2);
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_eval_account_v3" + (String)localObject1;
    g.c("account page generateUrl url =" + (String)localObject1);
    return localObject1;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
    g.c("account page ProtoGetEvalAccountResult unpacketParams: user =" + this.e);
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
      if (i != this.f)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + cb.a().b());
        return;
      }
      this.d = new EvalAccountResult(paramJSONObject.getJSONObject("result"), paramJSONObject);
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetEvalAccountResult
 * JD-Core Version:    0.7.0.1
 */