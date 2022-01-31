package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class dj
  extends bm
{
  EvalAccountResult c;
  private long d;
  private int e;
  
  protected final String a()
  {
    Object localObject1 = null;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c;; str = null)
    {
      e.c("account page generateUrl sessId =" + str);
      if (str != null) {
        break;
      }
      this.a.a(104, null, null);
      e.c("account page generateUrl sessId =" + str);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int i = af.a + 1;
      af.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", ag.c().r() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      e.a("plain:" + (String)localObject2);
      localObject2 = s.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
      }
    }
    str = "?aq_base_sid=" + str + "&data=" + localObject1;
    str = b.c() + "/cn/mbtoken3/mbtoken3_eval_account_v3" + str;
    e.c("account page generateUrl url =" + str);
    return str;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.uinhash")).longValue();
    e.c("account page ProtoGetEvalAccountResult unpacketParams: user =" + this.d);
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
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      this.c = new EvalAccountResult(paramJSONObject.getJSONObject("result"), paramJSONObject);
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
 * Qualified Name:     com.tencent.token.dj
 * JD-Core Version:    0.7.0.1
 */