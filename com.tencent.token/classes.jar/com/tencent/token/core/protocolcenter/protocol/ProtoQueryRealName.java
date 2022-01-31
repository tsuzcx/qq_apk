package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQueryRealName
  extends e
{
  RealNameQueryResult d;
  private long e;
  private int f;
  
  public static void a(ev paramev, long paramLong, int paramInt)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.j = paramInt;
  }
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = RqdApplication.l().getResources().getDisplayMetrics();
    localObject = w.a(new Object[] { "real_uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cx.c().s() / 1000L), "mobile_model", URLEncoder.encode(Build.MODEL), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(x.y()), "cpu_freq", Integer.valueOf(x.z()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    str = c.e() + "/cn/mbtoken3/mbtoken3_realname_qry" + str;
    h.c("ProtoQueryRealName url: " + str);
    return str;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.realuin")).longValue();
    this.f = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    h.c("ProtoQueryRealName parseJSON errCode: " + i);
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
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.f);
        return;
      }
      this.d = new RealNameQueryResult(paramJSONObject);
      h.c("result rebind_type: " + this.d.b());
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQueryRealName
 * JD-Core Version:    0.7.0.1
 */