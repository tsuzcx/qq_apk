package com.tencent.token;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.JLProtectionInfo;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class do
  extends bm
{
  JLProtectionInfo c;
  private long d;
  private int e;
  private int f;
  private int g;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?uin=" + this.d + "&aq_base_sid=" + str + "&mobile_brand=" + URLEncoder.encode(Build.BRAND) + "&mobile_model=" + URLEncoder.encode(Build.MODEL) + "&mobile_sys_version=" + URLEncoder.encode(Build.VERSION.RELEASE) + "&screen_width=" + this.e + "&screen_height=" + this.f + "&screen_dpi=" + this.g;
    return b.c() + "/cn/mbtoken3/mbtoken3_query_jl_protection_info" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramfs.c.get("param.config.width")).intValue();
    this.f = ((Integer)paramfs.c.get("param.config.height")).intValue();
    this.g = ((Integer)paramfs.c.get("param.config.dpi")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.c = new JLProtectionInfo(paramJSONObject);
    this.a.a = 0;
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
 * Qualified Name:     com.tencent.token.do
 * JD-Core Version:    0.7.0.1
 */