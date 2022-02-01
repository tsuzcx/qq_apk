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

public final class we
  extends tk
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
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.g = ((String)paramaar.c.get("param.realname"));
    this.h = ((String)paramaar.c.get("param.idnumber"));
    this.k = ((Integer)paramaar.c.get("param.optype")).intValue();
    this.l = ((byte[])paramaar.c.get("param.facedata"));
    this.m = ((byte[])paramaar.c.get("param.frontdata"));
    this.n = ((byte[])paramaar.c.get("param.backdata"));
    this.o = ((byte[])paramaar.c.get("param.prontphotoinfo"));
    this.p = ((byte[])paramaar.c.get("param.backphotoinfo"));
    this.f = paramaar.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    String str;
    if (i1 != 0)
    {
      str = paramJSONObject.getString("info");
      paramJSONObject = aad.d(paramJSONObject.getString("data"));
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
      paramJSONObject = aad.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        xb.a("ProtoRealNameReg json=".concat(String.valueOf(paramJSONObject)));
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.f)
        {
          this.a.a(10030, null, null);
          paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
          paramJSONObject.append(i1);
          paramJSONObject.append(",right = ");
          paramJSONObject.append(this.f);
          xb.c(paramJSONObject.toString());
          return;
        }
        this.q = new RealNameRegResult(paramJSONObject);
        this.a.a = 0;
        return;
      }
      xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493068));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public final aar b(aar paramaar)
  {
    int i1 = paramaar.j;
    paramaar.m = 1;
    paramaar.n = new ContentValues(3);
    Object localObject1 = paramaar.n;
    sa.a();
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
      xb.a(((StringBuilder)localObject2).toString());
      StringBuilder localStringBuilder2;
      if (this.l != null)
      {
        localObject2 = zu.a(this.l);
        ((JSONObject)localObject1).put("face_data", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg face_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xb.a(localStringBuilder2.toString());
      }
      if (this.m != null)
      {
        localObject2 = zu.a(this.m);
        ((JSONObject)localObject1).put("id_photo_front", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg front_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xb.a(localStringBuilder2.toString());
      }
      if (this.n != null)
      {
        localObject2 = zu.a(this.n);
        ((JSONObject)localObject1).put("id_photo_back", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg back_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xb.a(localStringBuilder2.toString());
      }
      if (this.o != null) {
        ((JSONObject)localObject1).put("id_photo_info_front", zu.a(this.o));
      }
      if (this.p != null) {
        ((JSONObject)localObject1).put("id_photo_info_back", zu.a(this.p));
      }
      ((JSONObject)localObject1).put("token_seq", sc.b().a.d());
      ((JSONObject)localObject1).put("guid", aad.a(rz.a(RqdApplication.n()).a.GetGuid()));
      ((JSONObject)localObject1).put("seq_id", i1);
      ((JSONObject)localObject1).put("op_time", (int)(sc.b().i() / 1000L));
      ((JSONObject)localObject1).put("vendor_id", Build.MANUFACTURER);
      ((JSONObject)localObject1).put("android_id", aad.a(RqdApplication.n()));
      ((JSONObject)localObject1).put("imei", aad.b(RqdApplication.n()));
      ((JSONObject)localObject1).put("mac", aad.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_model", Build.MODEL);
      ((JSONObject)localObject1).put("sys_ver", Build.VERSION.RELEASE);
      ((JSONObject)localObject1).put("face_detect_time", un.f);
      ((JSONObject)localObject1).put("face_detect_frame", un.h);
      ((JSONObject)localObject1).put("face_model_init_time", un.g);
      ((JSONObject)localObject1).put("vivo_model_init_time", un.i);
      ((JSONObject)localObject1).put("vivo_reg_action1_time", un.j);
      ((JSONObject)localObject1).put("vivo_reg_action2_time", un.k);
      ((JSONObject)localObject1).put("vivo_reg_action1_frame", un.l);
      ((JSONObject)localObject1).put("vivo_reg_action2_frame", un.m);
      ((JSONObject)localObject1).put("vivo_ver_action_time", un.n);
      ((JSONObject)localObject1).put("vivo_ver_action_frame", un.o);
      ((JSONObject)localObject1).put("vivo_reg_action1_type", vt.d);
      ((JSONObject)localObject1).put("vivo_reg_action2_type", vt.e);
      ((JSONObject)localObject1).put("vivo_ver_action_type", vt.f);
      ((JSONObject)localObject1).put("id_photo_front_time", xu.f);
      ((JSONObject)localObject1).put("id_photo_front_frame", xu.e);
      ((JSONObject)localObject1).put("id_photo_back_time", xu.h);
      ((JSONObject)localObject1).put("id_photo_back_frame", xu.g);
      localObject2 = aad.e(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_name", localObject2);
      }
      localObject2 = aad.d(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_mac", localObject2);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localObject1 = zu.a(aad.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
    StringBuilder localStringBuilder1 = new StringBuilder("doRealNameReg data = ");
    localStringBuilder1.append(((String)localObject1).length());
    xb.a(localStringBuilder1.toString());
    paramaar.n.put("data", (String)localObject1);
    return paramaar;
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
 * Qualified Name:     com.tencent.token.we
 * JD-Core Version:    0.7.0.1
 */