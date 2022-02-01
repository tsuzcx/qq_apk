package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

public final class wd
  extends tj
{
  public static String i;
  public static String j;
  public long d;
  public long e;
  public int f;
  public String g;
  public String h;
  private int k;
  private byte[] l;
  private byte[] m;
  private byte[] n;
  private byte[] o;
  private byte[] p;
  private RealNameRegResult q;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramaaq.c.get("param.realuin")).longValue();
    this.g = ((String)paramaaq.c.get("param.realname"));
    this.h = ((String)paramaaq.c.get("param.idnumber"));
    this.k = ((Integer)paramaaq.c.get("param.optype")).intValue();
    this.l = ((byte[])paramaaq.c.get("param.facedata"));
    this.m = ((byte[])paramaaq.c.get("param.frontdata"));
    this.n = ((byte[])paramaaq.c.get("param.backdata"));
    this.o = ((byte[])paramaaq.c.get("param.prontphotoinfo"));
    this.p = ((byte[])paramaaq.c.get("param.backphotoinfo"));
    this.f = paramaaq.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    String str;
    if (i1 != 0)
    {
      str = paramJSONObject.getString("info");
      paramJSONObject = aac.d(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getString("hint_title");
      j = paramJSONObject.getString("hint_content");
      label66:
      a(i1, str);
      return;
      paramJSONObject = aac.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        xa.a("ProtoRealNameReg json=".concat(String.valueOf(paramJSONObject)));
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.f)
        {
          this.a.a(10030, null, null);
          paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
          paramJSONObject.append(i1);
          paramJSONObject.append(",right = ");
          paramJSONObject.append(this.f);
          xa.c(paramJSONObject.toString());
          return;
        }
        this.q = new RealNameRegResult(paramJSONObject);
        this.a.a = 0;
        return;
      }
      xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493068));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public final aaq b(aaq paramaaq)
  {
    int i1 = paramaaq.j;
    paramaaq.m = 1;
    paramaaq.n = new ContentValues(3);
    Object localObject1 = paramaaq.n;
    rz.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.d);
      ((JSONObject)localObject1).put("real_uin", this.e);
      ((JSONObject)localObject1).put("realname", this.g);
      ((JSONObject)localObject1).put("id_number", this.h);
      ((JSONObject)localObject1).put("op_type", this.k);
      Object localObject2 = new StringBuilder("doRealNameReg common_data=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      xa.a(((StringBuilder)localObject2).toString());
      StringBuilder localStringBuilder2;
      if (this.l != null)
      {
        localObject2 = zt.a(this.l);
        ((JSONObject)localObject1).put("face_data", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg face_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xa.a(localStringBuilder2.toString());
      }
      if (this.m != null)
      {
        localObject2 = zt.a(this.m);
        ((JSONObject)localObject1).put("id_photo_front", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg front_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xa.a(localStringBuilder2.toString());
      }
      if (this.n != null)
      {
        localObject2 = zt.a(this.n);
        ((JSONObject)localObject1).put("id_photo_back", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg back_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xa.a(localStringBuilder2.toString());
      }
      if (this.o != null) {
        ((JSONObject)localObject1).put("id_photo_info_front", zt.a(this.o));
      }
      if (this.p != null) {
        ((JSONObject)localObject1).put("id_photo_info_back", zt.a(this.p));
      }
      ((JSONObject)localObject1).put("token_seq", sb.b().a.d());
      ((JSONObject)localObject1).put("guid", aac.a(ry.a(RqdApplication.n()).a.GetGuid()));
      ((JSONObject)localObject1).put("seq_id", i1);
      ((JSONObject)localObject1).put("op_time", (int)(sb.b().i() / 1000L));
      ((JSONObject)localObject1).put("vendor_id", Build.MANUFACTURER);
      ((JSONObject)localObject1).put("android_id", aac.a(RqdApplication.n()));
      ((JSONObject)localObject1).put("imei", aac.b(RqdApplication.n()));
      ((JSONObject)localObject1).put("mac", aac.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_model", Build.MODEL);
      ((JSONObject)localObject1).put("sys_ver", Build.VERSION.RELEASE);
      ((JSONObject)localObject1).put("face_detect_time", um.f);
      ((JSONObject)localObject1).put("face_detect_frame", um.h);
      ((JSONObject)localObject1).put("face_model_init_time", um.g);
      ((JSONObject)localObject1).put("vivo_model_init_time", um.i);
      ((JSONObject)localObject1).put("vivo_reg_action1_time", um.j);
      ((JSONObject)localObject1).put("vivo_reg_action2_time", um.k);
      ((JSONObject)localObject1).put("vivo_reg_action1_frame", um.l);
      ((JSONObject)localObject1).put("vivo_reg_action2_frame", um.m);
      ((JSONObject)localObject1).put("vivo_ver_action_time", um.n);
      ((JSONObject)localObject1).put("vivo_ver_action_frame", um.o);
      ((JSONObject)localObject1).put("vivo_reg_action1_type", vs.d);
      ((JSONObject)localObject1).put("vivo_reg_action2_type", vs.e);
      ((JSONObject)localObject1).put("vivo_ver_action_type", vs.f);
      ((JSONObject)localObject1).put("id_photo_front_time", xt.f);
      ((JSONObject)localObject1).put("id_photo_front_frame", xt.e);
      ((JSONObject)localObject1).put("id_photo_back_time", xt.h);
      ((JSONObject)localObject1).put("id_photo_back_frame", xt.g);
      localObject2 = aac.e(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_name", localObject2);
      }
      localObject2 = aac.d(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_mac", localObject2);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localObject1 = zt.a(aac.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
    StringBuilder localStringBuilder1 = new StringBuilder("doRealNameReg data = ");
    localStringBuilder1.append(((String)localObject1).length());
    xa.a(localStringBuilder1.toString());
    paramaaq.n.put("data", (String)localObject1);
    return paramaaq;
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.q;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wd
 * JD-Core Version:    0.7.0.1
 */