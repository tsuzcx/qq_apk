package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.ScanDataResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ec
  extends bm
{
  ScanDataResult c;
  private long d;
  private long e;
  
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
      if (this.d != 0L) {
        ((JSONObject)localObject2).put("real_uin", this.d);
      }
      ((JSONObject)localObject2).put("seq_id", this.e);
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
    return b.c() + "/cn/mbtoken3/mbtoken3_detector_info" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramfs.c.get("param.common.seq")).intValue();
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
      this.c = new ScanDataResult(new JSONObject(new String(paramJSONObject)));
      this.a.a = 0;
      return;
    }
    a(10022, RqdApplication.i().getString(2131361799));
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
 * Qualified Name:     com.tencent.token.ec
 * JD-Core Version:    0.7.0.1
 */