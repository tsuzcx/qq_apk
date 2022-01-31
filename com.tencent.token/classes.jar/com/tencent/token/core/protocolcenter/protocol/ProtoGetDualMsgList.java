package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dm;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetDualMsgList
  extends e
{
  private long d;
  private byte e;
  private final String f = "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2";
  private int g;
  
  public static void a(ev paramev, long paramLong, byte paramByte)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.msg.source", Byte.valueOf(paramByte));
  }
  
  protected String a()
  {
    if (cv.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    do localdo = do.a();
    int i;
    Object localObject1;
    if (this.d > 0L)
    {
      i = 0;
      for (;;)
      {
        if (i < localdo.d())
        {
          localObject1 = localdo.a(i);
          h.c("getdualmsglist: hash=" + this.d + ", uin=" + ((QQUser)localObject1).mUin + ", real=" + ((QQUser)localObject1).mRealUin + ", bind=" + ((QQUser)localObject1).mIsBinded);
          if ((!((QQUser)localObject1).mIsBinded) || (((QQUser)localObject1).mUin != this.d)) {}
        }
        else
        {
          if (i != localdo.d()) {
            break;
          }
          this.a.b(110);
          return null;
        }
        if ((!((QQUser)localObject1).mIsBinded) && (w.f(((QQUser)localObject1).mRealUin) == this.d))
        {
          this.a.b(10029);
          return null;
        }
        i += 1;
      }
    }
    long l = localdo.f();
    if ((localdo.e() == null) || (l == 0L))
    {
      this.a.b(110);
      return null;
    }
    if (localdo.e().mIsBinded) {
      l = localdo.e().mUin;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = cw.a + 1;
      cw.a = i;
      this.g = i;
      ((JSONObject)localObject1).put("seq_id", this.g);
      ((JSONObject)localObject1).put("op_time", cx.c().s() / 1000L);
      ((JSONObject)localObject1).put("tkn_seq", cx.c().j().replaceAll("-", ""));
      ((JSONObject)localObject1).put("source", this.e);
      localObject1 = ((JSONObject)localObject1).toString();
      h.a("plain:" + (String)localObject1);
      localObject1 = w.b(((String)localObject1).getBytes());
      localObject1 = "?aq_base_sid=" + localdo.g() + "&data=" + (String)localObject1;
      return c.e() + "/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2" + (String)localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((Byte)paramev.c.get("param.msg.source")).byteValue();
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
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("msgs");
      if (!dm.a().a(paramJSONObject, this.d))
      {
        this.a.a(10000, "update conf list failed:" + paramJSONObject.toString());
        return;
      }
      do.a().m();
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDualMsgList
 * JD-Core Version:    0.7.0.1
 */