package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQueryRealName
  extends d
{
  RealNameQueryResult d;
  private long e;
  private int f;
  
  public static void a(do paramdo, long paramLong, int paramInt)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.j = paramInt;
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = RqdApplication.l().getResources().getDisplayMetrics();
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L), "mobile_model", URLEncoder.encode(Build.MODEL), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(m.y()), "cpu_freq", Integer.valueOf(m.z()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    str = c.e() + "/cn/mbtoken3/mbtoken3_realname_qry" + str;
    g.c("ProtoQueryRealName url: " + str);
    return str;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.f = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    g.c("ProtoQueryRealName parseJSON errCode: " + i);
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
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.f);
        return;
      }
      this.d = new RealNameQueryResult(paramJSONObject);
      g.c("result rebind_type: " + this.d.b());
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQueryRealName
 * JD-Core Version:    0.7.0.1
 */