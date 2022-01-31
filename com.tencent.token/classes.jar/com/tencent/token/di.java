package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class di
  extends bm
{
  private long c;
  private byte d;
  private final String e = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int f;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (Object localObject1 = ax.c; localObject1 == null; localObject1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    localObject1 = ax.a();
    int i;
    if (this.c > 0L)
    {
      i = 0;
      while (i < ((ax)localObject1).d())
      {
        QQUser localQQUser = ((ax)localObject1).a(i);
        e.c("getdualmsglist: hash=" + this.c + ", uin=" + localQQUser.mUin + ", real=" + localQQUser.mRealUin + ", bind=" + localQQUser.mIsBinded);
        if ((localQQUser.mIsBinded) && (localQQUser.mUin == this.c)) {
          break;
        }
        if ((!localQQUser.mIsBinded) && (s.f(localQQUser.mRealUin) == this.c))
        {
          this.a.a(10029, null, null);
          return null;
        }
        i += 1;
      }
      if (i == ((ax)localObject1).d())
      {
        this.a.a(110, null, null);
        return null;
      }
    }
    long l = ((ax)localObject1).f();
    if ((((ax)localObject1).e() == null) || (l == 0L))
    {
      this.a.a(110, null, null);
      return null;
    }
    if (((ax)localObject1).e().mIsBinded) {
      l = ((ax)localObject1).e().mUin;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = af.a + 1;
      af.a = i;
      this.f = i;
      ((JSONObject)localObject1).put("seq_id", this.f);
      ((JSONObject)localObject1).put("op_time", ag.c().r() / 1000L);
      ((JSONObject)localObject1).put("tkn_seq", ag.c().j().replaceAll("-", ""));
      ((JSONObject)localObject1).put("source", this.d);
      localObject1 = ((JSONObject)localObject1).toString();
      e.a("plain:" + (String)localObject1);
      localObject1 = s.b(((String)localObject1).getBytes());
      localObject1 = "?aq_base_sid=" + ax.g() + "&data=" + (String)localObject1;
      return b.c() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((Byte)paramfs.c.get("param.msg.source")).byteValue();
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
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("msgs");
      if (!av.a().a(paramJSONObject, this.c))
      {
        this.a.a(10000, "update conf list failed:" + paramJSONObject.toString(), null);
        return;
      }
      ax.a().m();
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.di
 * JD-Core Version:    0.7.0.1
 */