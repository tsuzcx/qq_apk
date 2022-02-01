package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, long paramLong, int paramInt)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.j = paramInt;
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cd.c().s() / 1000L), "mobile_model", URLEncoder.encode(Build.MODEL), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(m.y()), "cpu_freq", Integer.valueOf(m.z()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_realname_qry");
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ProtoQueryRealName url: ");
    ((StringBuilder)localObject).append(str);
    g.c(((StringBuilder)localObject).toString());
    return str;
  }
  
  protected void a(dp paramdp)
  {
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.f = paramdp.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProtoQueryRealName parseJSON errCode: ");
    localStringBuilder.append(i);
    g.c(localStringBuilder.toString());
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
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        g.c(paramJSONObject.toString());
        return;
      }
      this.d = new RealNameQueryResult(paramJSONObject);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("result rebind_type: ");
      paramJSONObject.append(this.d.b());
      g.c(paramJSONObject.toString());
      this.a.c();
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
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