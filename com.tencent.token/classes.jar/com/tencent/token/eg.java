package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class eg
  extends bm
{
  public byte[] c;
  public long d;
  public UpgradeDeterminResult e;
  private int f;
  
  protected final String a()
  {
    e.c("upgrade url: ");
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      e.c("upgrade url: ");
      return null;
    }
    e.c("upgrade url: ");
    String str3 = ag.c().j().replaceAll("-", "");
    String str2 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("seq_id", this.f);
      localJSONObject.put("op_time", (int)(ag.c().r() / 1000L));
      localJSONObject.put("tkn_seq", str3);
      localJSONObject.put("wtlogin_sig", s.a(this.c));
      localJSONObject.put("wtlogin_type", Integer.toString(2));
      localJSONObject.put("guid", s.a(x.a(RqdApplication.i()).c()));
      localJSONObject.put("android_id", s.a(RqdApplication.i()));
      localJSONObject.put("mac", s.c(RqdApplication.i()));
      localJSONObject.put("device_id", s.b(RqdApplication.i()));
      localJSONObject.put("device_name", URLEncoder.encode(Build.MODEL));
      localJSONObject.put("imei", s.b(RqdApplication.i()));
      localJSONObject.put("dev_model", URLEncoder.encode(Build.BRAND));
      localJSONObject.put("sys_ver", URLEncoder.encode(Build.VERSION.RELEASE));
      str3 = s.b(localJSONObject.toString().getBytes());
      str2 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c(localException.getMessage());
        localException.printStackTrace();
      }
      this.a.a(10000, null, null);
      e.c("upgradeDetermin url data is null ");
    }
    str1 = "?uin=" + this.d + "&aq_base_sid=" + str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str1 + "&data=" + str2;
      str1 = b.c() + "/cn/mbtoken3/mbtoken3_upgrade_determin_v3" + str1;
      e.c("upgrade url: " + str1);
      return str1;
    }
    return null;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.c = ((byte[])paramfs.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramfs.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        paramJSONObject = paramJSONObject.getString("info");
        e.a("error" + paramJSONObject + ",error code =" + i);
        this.a.a(i, paramJSONObject, paramJSONObject);
        return;
      }
      if (paramJSONObject.getInt("seq_id") != this.f)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + paramJSONObject.getInt("seq_id") + ",right = " + this.f);
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (this.d != l)
      {
        this.a.a(10000, "uin not match " + this.d + ":" + l, null);
        return;
      }
      this.e = new UpgradeDeterminResult(paramJSONObject);
      l = paramJSONObject.getLong("server_time");
      ag.c();
      ag.b(l);
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eg
 * JD-Core Version:    0.7.0.1
 */