package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.co;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetDualMsgList
  extends d
{
  private long d;
  private byte e;
  private final String f = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int g;
  
  public static void a(dn paramdn, long paramLong, byte paramByte)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.msg.source", Byte.valueOf(paramByte));
  }
  
  protected String a()
  {
    if (bz.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    cq localcq = cq.a();
    int i;
    Object localObject1;
    if (this.d > 0L)
    {
      i = 0;
      for (;;)
      {
        if (i < localcq.d())
        {
          localObject1 = localcq.a(i);
          g.c("getdualmsglist: hash=" + this.d + ", uin=" + ((QQUser)localObject1).mUin + ", real=" + ((QQUser)localObject1).mRealUin + ", bind=" + ((QQUser)localObject1).mIsBinded);
          if ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin != this.d)) {}
        }
        else
        {
          if (i != localcq.d()) {
            break;
          }
          this.a.b(110);
          return null;
        }
        if ((!((QQUser)localObject1).mIsBinded) && (l.f(((QQUser)localObject1).mRealUin) == this.d))
        {
          this.a.b(10029);
          return null;
        }
        i += 1;
      }
    }
    long l = localcq.f();
    if ((localcq.e() == null) || (l == 0L))
    {
      this.a.b(110);
      return null;
    }
    if (localcq.e().mIsBinded) {
      l = localcq.e().mUin;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = ca.a + 1;
      ca.a = i;
      this.g = i;
      ((JSONObject)localObject1).put("seq_id", this.g);
      ((JSONObject)localObject1).put("op_time", cb.c().s() / 1000L);
      ((JSONObject)localObject1).put("tkn_seq", cb.c().j().replaceAll("-", ""));
      ((JSONObject)localObject1).put("source", this.e);
      localObject1 = ((JSONObject)localObject1).toString();
      g.a("plain:" + (String)localObject1);
      localObject1 = l.b(((String)localObject1).getBytes());
      localObject1 = "?aq_base_sid=" + localcq.g() + "&data=" + (String)localObject1;
      return c.e() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.c("JSONException:" + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.e = ((Byte)paramdn.c.get("param.msg.source")).byteValue();
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
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + ca.a().b());
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("msgs");
      if (!co.a().a(paramJSONObject, this.d))
      {
        this.a.a(10000, "update conf list failed:" + paramJSONObject.toString());
        return;
      }
      cq.a().m();
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDualMsgList
 * JD-Core Version:    0.7.0.1
 */