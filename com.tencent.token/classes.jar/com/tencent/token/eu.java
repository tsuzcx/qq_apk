package com.tencent.token;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class eu
  extends bm
{
  int c;
  int d;
  private long e;
  private long f;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      if (this.e != 0L) {
        ((JSONObject)localObject2).put("real_uin", this.e);
      }
      ((JSONObject)localObject2).put("seq_id", this.f);
      ((JSONObject)localObject2).put("op_time", (int)(ag.c().r() / 1000L));
      String str2 = s.c(RqdApplication.i());
      if (!TextUtils.isEmpty(str2)) {
        ((JSONObject)localObject2).put("mac", str2);
      }
      str2 = s.b(RqdApplication.i());
      if (!TextUtils.isEmpty(str2)) {
        ((JSONObject)localObject2).put("imei", str2);
      }
      ((JSONObject)localObject2).put("sys_ver", URLEncoder.encode(Build.VERSION.RELEASE));
      ((JSONObject)localObject2).put("model", URLEncoder.encode(Build.MODEL));
      ((JSONObject)localObject2).put("worm_type", this.c);
      ((JSONObject)localObject2).put("infected_cnt", this.d);
      localObject2 = s.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_detector_report" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramfs.c.get("param.common.seq")).intValue();
    this.c = ((Integer)paramfs.c.get("param.worm_type")).intValue();
    this.d = ((Integer)paramfs.c.get("infected_cnt")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    this.b.e = true;
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eu
 * JD-Core Version:    0.7.0.1
 */