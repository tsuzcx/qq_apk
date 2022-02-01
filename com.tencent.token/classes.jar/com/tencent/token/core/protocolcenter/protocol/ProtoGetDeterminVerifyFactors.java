package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.token.by;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetDeterminVerifyFactors
  extends d
{
  public byte[] d;
  public long e;
  public DeterminVerifyFactorsResult f;
  private int g;
  private int h;
  private int i;
  
  public static void a(dn paramdn, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramdn.c.put("param.realuin", Long.valueOf(paramLong));
    paramdn.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramdn.c.put("param.common.seq", Integer.valueOf(paramInt1));
    paramdn.c.put("param.wtlogin.type", Integer.valueOf(paramInt2));
    paramdn.c.put("param.scene_id", Integer.valueOf(paramInt3));
  }
  
  protected String a()
  {
    g.c("upgrade url: ");
    String str3 = bz.a().b();
    if (str3 == null)
    {
      this.a.b(104);
      g.c("upgrade url: ");
      return null;
    }
    g.c("upgrade url: ");
    String str2 = cb.c().j().replaceAll("-", "");
    String str1 = "";
    DisplayMetrics localDisplayMetrics = RqdApplication.l().getResources().getDisplayMetrics();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", this.e);
      localJSONObject.put("seq_id", this.g);
      localJSONObject.put("op_time", (int)(cb.c().s() / 1000L));
      localJSONObject.put("scene", this.i);
      localJSONObject.put("tkn_seq", str2);
      localJSONObject.put("wtlogin_sig", l.a(this.d));
      localJSONObject.put("wtlogin_type", Integer.toString(this.h));
      localJSONObject.put("guid", l.a(by.a(RqdApplication.l()).b()));
      localJSONObject.put("android_id", l.a(RqdApplication.l()));
      localJSONObject.put("mac", l.c(RqdApplication.l()));
      localJSONObject.put("device_id", l.b(RqdApplication.l()));
      localJSONObject.put("device_name", URLEncoder.encode(Build.MODEL));
      localJSONObject.put("imei", l.b(RqdApplication.l()));
      localJSONObject.put("dev_model", URLEncoder.encode(Build.BRAND));
      localJSONObject.put("sys_ver", URLEncoder.encode(Build.VERSION.RELEASE));
      localJSONObject.put("mobile_model", URLEncoder.encode(Build.MODEL));
      localJSONObject.put("screen_witdh", localDisplayMetrics.widthPixels);
      localJSONObject.put("screen_height", localDisplayMetrics.heightPixels);
      localJSONObject.put("screen_dpi", localDisplayMetrics.densityDpi);
      localJSONObject.put("cpu_count", m.y());
      localJSONObject.put("cpu_freq", m.z());
      g.a("mbtoken3_determine_verify_factors plaindata=" + localJSONObject);
      str2 = l.b(localJSONObject.toString().getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.c(localException.getMessage());
        localException.printStackTrace();
      }
      this.a.b(10000);
      g.c("upgradeDetermin url data is null ");
    }
    str2 = "?aq_base_sid=" + str3;
    if (!TextUtils.isEmpty(str1))
    {
      str1 = str2 + "&data=" + str1;
      str1 = c.e() + "/cn/mbtoken3/mbtoken3_determine_verify_factors" + str1;
      g.c("upgrade url: " + str1);
      return str1;
    }
    return null;
  }
  
  protected void a(dn paramdn)
  {
    this.e = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.d = ((byte[])paramdn.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramdn.c.get("param.common.seq")).intValue();
    this.h = ((Integer)paramdn.c.get("param.wtlogin.type")).intValue();
    this.i = ((Integer)paramdn.c.get("param.scene_id")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      g.a("error" + paramJSONObject + ",error code =" + j);
      this.a.a(j, "server errcode=" + j + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.c("mbtoken3_determine_verify_factors=" + paramJSONObject);
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + paramJSONObject.getInt("seq_id") + ",right = " + this.g);
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (this.e != l)
      {
        this.a.a(10000, "uin not match " + this.e + ":" + l);
        return;
      }
      this.f = new DeterminVerifyFactorsResult(paramJSONObject);
      try
      {
        l = paramJSONObject.getLong("server_time");
        cb.c().b(l);
        this.a.c();
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDeterminVerifyFactors
 * JD-Core Version:    0.7.0.1
 */