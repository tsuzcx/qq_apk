package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
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

public class ProtoGetDeterminVerifyFactors
  extends d
{
  public byte[] d;
  public long e;
  public DeterminVerifyFactorsResult f;
  private int g;
  private int h;
  private int i;
  
  public static void a(dp paramdp, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramdp.c.put("param.common.seq", Integer.valueOf(paramInt1));
    paramdp.c.put("param.wtlogin.type", Integer.valueOf(paramInt2));
    paramdp.c.put("param.scene_id", Integer.valueOf(paramInt3));
  }
  
  protected String a()
  {
    g.c("upgrade url: ");
    Object localObject4 = cb.a().b();
    if (localObject4 == null)
    {
      this.a.b(104);
      g.c("upgrade url: ");
      return null;
    }
    g.c("upgrade url: ");
    Object localObject5 = cd.c().j().replaceAll("-", "");
    Object localObject1 = "";
    DisplayMetrics localDisplayMetrics = RqdApplication.n().getResources().getDisplayMetrics();
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.e);
      ((JSONObject)localObject2).put("seq_id", this.g);
      ((JSONObject)localObject2).put("op_time", (int)(cd.c().s() / 1000L));
      ((JSONObject)localObject2).put("scene", this.i);
      ((JSONObject)localObject2).put("tkn_seq", localObject5);
      ((JSONObject)localObject2).put("wtlogin_sig", l.a(this.d));
      ((JSONObject)localObject2).put("wtlogin_type", Integer.toString(this.h));
      ((JSONObject)localObject2).put("guid", l.a(ca.a(RqdApplication.n()).b()));
      ((JSONObject)localObject2).put("android_id", l.a(RqdApplication.n()));
      ((JSONObject)localObject2).put("mac", l.c(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_id", l.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("device_name", URLEncoder.encode(Build.MODEL));
      ((JSONObject)localObject2).put("imei", l.b(RqdApplication.n()));
      ((JSONObject)localObject2).put("dev_model", URLEncoder.encode(Build.BRAND));
      ((JSONObject)localObject2).put("sys_ver", URLEncoder.encode(Build.VERSION.RELEASE));
      ((JSONObject)localObject2).put("mobile_model", URLEncoder.encode(Build.MODEL));
      ((JSONObject)localObject2).put("screen_witdh", localDisplayMetrics.widthPixels);
      ((JSONObject)localObject2).put("screen_height", localDisplayMetrics.heightPixels);
      ((JSONObject)localObject2).put("screen_dpi", localDisplayMetrics.densityDpi);
      ((JSONObject)localObject2).put("cpu_count", m.y());
      ((JSONObject)localObject2).put("cpu_freq", m.z());
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("mbtoken3_determine_verify_factors plaindata=");
      ((StringBuilder)localObject5).append(localObject2);
      g.a(((StringBuilder)localObject5).toString());
      localObject2 = l.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      g.c(localException.getMessage());
      localException.printStackTrace();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("?aq_base_sid=");
    ((StringBuilder)localObject3).append((String)localObject4);
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("&data=");
      ((StringBuilder)localObject4).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject4).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(c.e());
      ((StringBuilder)localObject3).append("/cn/mbtoken3/mbtoken3_determine_verify_factors");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("upgrade url: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      g.c(((StringBuilder)localObject3).toString());
      return localObject1;
    }
    this.a.b(10000);
    g.c("upgradeDetermin url data is null ");
    return null;
  }
  
  protected void a(dp paramdp)
  {
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.d = ((byte[])paramdp.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramdp.c.get("param.common.seq")).intValue();
    this.h = ((Integer)paramdp.c.get("param.wtlogin.type")).intValue();
    this.i = ((Integer)paramdp.c.get("param.scene_id")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(",error code =");
      ((StringBuilder)localObject).append(j);
      g.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(j);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(j, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mbtoken3_determine_verify_factors=");
      ((StringBuilder)localObject).append(paramJSONObject);
      g.c(((StringBuilder)localObject).toString());
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.b(10030);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseJSON error seq is wrong seq=");
        ((StringBuilder)localObject).append(paramJSONObject.getInt("seq_id"));
        ((StringBuilder)localObject).append(",right = ");
        ((StringBuilder)localObject).append(this.g);
        g.c(((StringBuilder)localObject).toString());
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (this.e != l)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin not match ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(l);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString());
        return;
      }
      this.f = new DeterminVerifyFactorsResult(paramJSONObject);
      try
      {
        l = paramJSONObject.getLong("server_time");
        cd.c().b(l);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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