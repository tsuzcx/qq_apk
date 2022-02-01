package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.ct;
import com.tencent.token.cv;
import com.tencent.token.dk;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetMessage
  extends d
{
  ct d = ct.a();
  cv e = cv.a();
  private long f;
  private int g;
  private int h;
  private int i;
  private int j;
  private Object k;
  private String l;
  private int m;
  private int n;
  private String o;
  private String p;
  private int q;
  
  public static void a(do paramdo, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.msg.source", Integer.valueOf(paramInt1));
    paramdo.c.put("param.msg.type", Integer.valueOf(paramInt2));
    paramdo.c.put("param.msg.num", Integer.valueOf(paramInt4));
    paramdo.c.put("param.msg.filter", Integer.valueOf(paramInt3));
  }
  
  public static void a(do paramdo, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, int paramInt6, String paramString2, String paramString3)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.msg.source", Integer.valueOf(paramInt1));
    paramdo.c.put("param.msg.type", Integer.valueOf(paramInt2));
    paramdo.c.put("param.msg.num", Integer.valueOf(paramInt4));
    paramdo.c.put("param.msg.filter", Integer.valueOf(paramInt3));
    paramdo.c.put("param.device.lock.guid", paramString1);
    paramdo.c.put("param.device.lock.appid", Integer.valueOf(paramInt5));
    paramdo.c.put("param.device.lock.subappid", Integer.valueOf(paramInt6));
    paramdo.c.put("param.device.lock.appname", paramString2);
    paramdo.c.put("param.skey", paramString3);
  }
  
  protected String a()
  {
    long l1 = cc.c().s();
    long l2 = System.currentTimeMillis();
    if (l1 <= l2) {
      l1 = l2;
    }
    l2 = l1 / 1000L + 300L;
    String str = ca.a().b();
    Object localObject1 = null;
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    l1 = 0L;
    if (this.j != 1) {
      l1 = m.a(this.i, this.f);
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.f);
      int i1 = cb.a + 1;
      cb.a = i1;
      this.q = i1;
      ((JSONObject)localObject2).put("seq_id", this.q);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
      ((JSONObject)localObject2).put("msg_type", this.i);
      ((JSONObject)localObject2).put("req_msg_num", this.h);
      ((JSONObject)localObject2).put("start_time", l1);
      ((JSONObject)localObject2).put("end_time", l2);
      ((JSONObject)localObject2).put("source", l2);
      ((JSONObject)localObject2).put("end_time", l2);
      ((JSONObject)localObject2).put("source", this.g);
      ((JSONObject)localObject2).put("filter_type", this.j);
      ((JSONObject)localObject2).put("filter_type", this.j);
      if ((this.j == 0) && (this.i == 1))
      {
        ((JSONObject)localObject2).put("guid", this.l);
        ((JSONObject)localObject2).put("appid", this.m);
        ((JSONObject)localObject2).put("subappid", this.n);
        ((JSONObject)localObject2).put("appname", this.o);
        ((JSONObject)localObject2).put("A2", this.p);
      }
      localObject2 = ((JSONObject)localObject2).toString();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("plain:");
      localStringBuilder2.append((String)localObject2);
      com.tencent.token.global.g.a(localStringBuilder2.toString());
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("JSONException:");
      localStringBuilder2.append(localJSONException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("?aq_base_sid=");
    localStringBuilder1.append(str);
    localStringBuilder1.append("&data=");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.e());
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_get_message_v2");
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
  
  protected void a(do paramdo)
  {
    this.f = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramdo.c.get("param.msg.source")).intValue();
    this.h = ((Integer)paramdo.c.get("param.msg.num")).intValue();
    this.i = ((Integer)paramdo.c.get("param.msg.type")).intValue();
    this.j = ((Integer)paramdo.c.get("param.msg.filter")).intValue();
    if ((this.j == 0) && (this.i == 1))
    {
      this.l = ((String)paramdo.c.get("param.device.lock.guid"));
      this.m = ((Integer)paramdo.c.get("param.device.lock.appid")).intValue();
      this.n = ((Integer)paramdo.c.get("param.device.lock.subappid")).intValue();
      this.o = ((String)paramdo.c.get("param.device.lock.appname"));
      this.p = ((String)paramdo.c.get("param.skey"));
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i1 = paramJSONObject.getInt("seq_id");
      if (i1 != this.q)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i1);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.q);
        com.tencent.token.global.g.c(paramJSONObject.toString());
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      long l2 = this.f;
      if (l1 != l2)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin not match=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.f);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString());
        return;
      }
      if (this.i == 1)
      {
        this.d.a(l2);
        if (this.j == 1)
        {
          this.k = new AbnormalLoginMsgResult(paramJSONObject);
          this.a.c();
          return;
        }
        this.d.b = null;
        localObject = new ArrayList();
        if (paramJSONObject.has("devs"))
        {
          OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
          if (localOnlineDeviceResult.mDevicesList != null) {
            ((ArrayList)localObject).addAll(localOnlineDeviceResult.mDevicesList);
          }
          this.d.b = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
        }
        com.tencent.service.g.a().a(this.f, (List)localObject);
        this.a = this.d.f.a(paramJSONObject, l1, this.i);
        return;
      }
      this.e.a(l2);
      this.a = this.e.f.a(paramJSONObject, l1, this.i);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.k;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMessage
 * JD-Core Version:    0.7.0.1
 */