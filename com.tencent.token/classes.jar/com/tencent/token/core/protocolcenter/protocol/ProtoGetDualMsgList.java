package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cp;
import com.tencent.token.cr;
import com.tencent.token.do;
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
  
  public static void a(do paramdo, long paramLong, byte paramByte)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.msg.source", Byte.valueOf(paramByte));
  }
  
  protected String a()
  {
    Object localObject2 = ca.a().b();
    Object localObject1 = null;
    if (localObject2 == null)
    {
      this.a.b(104);
      return null;
    }
    cr localcr = cr.a();
    int i;
    StringBuilder localStringBuilder2;
    if (this.d > 0L)
    {
      i = 0;
      while (i < localcr.d())
      {
        localObject2 = localcr.a(i);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getdualmsglist: hash=");
        localStringBuilder2.append(this.d);
        localStringBuilder2.append(", uin=");
        localStringBuilder2.append(((QQUser)localObject2).mUin);
        localStringBuilder2.append(", real=");
        localStringBuilder2.append(((QQUser)localObject2).mRealUin);
        localStringBuilder2.append(", bind=");
        localStringBuilder2.append(((QQUser)localObject2).mIsBinded);
        g.c(localStringBuilder2.toString());
        if ((((QQUser)localObject2).mIsBinded) && (((QQUser)localObject2).mUin == this.d)) {
          break;
        }
        if ((!((QQUser)localObject2).mIsBinded) && (l.f(((QQUser)localObject2).mRealUin) == this.d))
        {
          this.a.b(10029);
          return null;
        }
        i += 1;
      }
      if (i == localcr.d())
      {
        this.a.b(110);
        return null;
      }
    }
    long l = localcr.f();
    if ((localcr.e() != null) && (l != 0L))
    {
      if (localcr.e().mIsBinded) {
        l = localcr.e().mUin;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", l);
        i = cb.a + 1;
        cb.a = i;
        this.g = i;
        ((JSONObject)localObject2).put("seq_id", this.g);
        ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
        ((JSONObject)localObject2).put("tkn_seq", cc.c().j().replaceAll("-", ""));
        ((JSONObject)localObject2).put("source", this.e);
        localObject2 = ((JSONObject)localObject2).toString();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("plain:");
        localStringBuilder2.append((String)localObject2);
        g.a(localStringBuilder2.toString());
        localObject2 = l.b(((String)localObject2).getBytes());
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("JSONException:");
        localStringBuilder2.append(localJSONException.getMessage());
        g.c(localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("?aq_base_sid=");
      localStringBuilder1.append(localcr.g());
      localStringBuilder1.append("&data=");
      localStringBuilder1.append((String)localObject1);
      localObject1 = localStringBuilder1.toString();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(c.e());
      localStringBuilder1.append("/cn/mbtoken3/mbtoken3_get_dual_msg_list_v2");
      localStringBuilder1.append((String)localObject1);
      return localStringBuilder1.toString();
    }
    this.a.b(110);
    return null;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((Byte)paramdo.c.get("param.msg.source")).byteValue();
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
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cb.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("msgs");
      if (!cp.a().a(paramJSONObject, this.d))
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update conf list failed:");
        localStringBuilder.append(paramJSONObject.toString());
        ((e)localObject).a(10000, localStringBuilder.toString());
        return;
      }
      cr.a().m();
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDualMsgList
 * JD-Core Version:    0.7.0.1
 */