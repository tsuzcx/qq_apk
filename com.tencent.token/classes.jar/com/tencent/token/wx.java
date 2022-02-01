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

public final class wx
  extends ud
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
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.g = ((String)paramabm.c.get("param.realname"));
    this.h = ((String)paramabm.c.get("param.idnumber"));
    this.k = ((Integer)paramabm.c.get("param.optype")).intValue();
    this.l = ((byte[])paramabm.c.get("param.facedata"));
    this.m = ((byte[])paramabm.c.get("param.frontdata"));
    this.n = ((byte[])paramabm.c.get("param.backdata"));
    this.o = ((byte[])paramabm.c.get("param.prontphotoinfo"));
    this.p = ((byte[])paramabm.c.get("param.backphotoinfo"));
    this.f = paramabm.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    String str;
    if (i1 != 0)
    {
      str = paramJSONObject.getString("info");
      paramJSONObject = aay.d(paramJSONObject.getString("data"));
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
      paramJSONObject = aay.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        xv.a("ProtoRealNameReg json=".concat(String.valueOf(paramJSONObject)));
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.f)
        {
          this.a.a(10030, null, null);
          paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
          paramJSONObject.append(i1);
          paramJSONObject.append(",right = ");
          paramJSONObject.append(this.f);
          xv.c(paramJSONObject.toString());
          return;
        }
        this.q = new RealNameRegResult(paramJSONObject);
        this.a.a = 0;
        return;
      }
      xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493069));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public final abm b(abm paramabm)
  {
    int i1 = paramabm.j;
    paramabm.m = 1;
    paramabm.n = new ContentValues(3);
    Object localObject1 = paramabm.n;
    st.a();
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
      xv.a(((StringBuilder)localObject2).toString());
      StringBuilder localStringBuilder2;
      if (this.l != null)
      {
        localObject2 = aap.a(this.l);
        ((JSONObject)localObject1).put("face_data", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg face_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xv.a(localStringBuilder2.toString());
      }
      if (this.m != null)
      {
        localObject2 = aap.a(this.m);
        ((JSONObject)localObject1).put("id_photo_front", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg front_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xv.a(localStringBuilder2.toString());
      }
      if (this.n != null)
      {
        localObject2 = aap.a(this.n);
        ((JSONObject)localObject1).put("id_photo_back", localObject2);
        localStringBuilder2 = new StringBuilder("doRealNameReg back_data=");
        localStringBuilder2.append(((String)localObject2).length());
        xv.a(localStringBuilder2.toString());
      }
      if (this.o != null) {
        ((JSONObject)localObject1).put("id_photo_info_front", aap.a(this.o));
      }
      if (this.p != null) {
        ((JSONObject)localObject1).put("id_photo_info_back", aap.a(this.p));
      }
      sv.b();
      ((JSONObject)localObject1).put("token_seq", 0L);
      ((JSONObject)localObject1).put("guid", aay.a(ss.a(RqdApplication.n()).a.GetGuid()));
      ((JSONObject)localObject1).put("seq_id", i1);
      sv.b();
      ((JSONObject)localObject1).put("op_time", (int)((System.currentTimeMillis() + 0L) / 1000L));
      ((JSONObject)localObject1).put("vendor_id", Build.MANUFACTURER);
      ((JSONObject)localObject1).put("android_id", aay.b(RqdApplication.n()));
      RqdApplication.n();
      ((JSONObject)localObject1).put("imei", aay.l());
      ((JSONObject)localObject1).put("mac", aay.c(RqdApplication.n()));
      ((JSONObject)localObject1).put("device_model", yd.a);
      ((JSONObject)localObject1).put("sys_ver", Build.VERSION.RELEASE);
      ((JSONObject)localObject1).put("face_detect_time", vg.f);
      ((JSONObject)localObject1).put("face_detect_frame", vg.h);
      ((JSONObject)localObject1).put("face_model_init_time", vg.g);
      ((JSONObject)localObject1).put("vivo_model_init_time", vg.i);
      ((JSONObject)localObject1).put("vivo_reg_action1_time", vg.j);
      ((JSONObject)localObject1).put("vivo_reg_action2_time", vg.k);
      ((JSONObject)localObject1).put("vivo_reg_action1_frame", vg.l);
      ((JSONObject)localObject1).put("vivo_reg_action2_frame", vg.m);
      ((JSONObject)localObject1).put("vivo_ver_action_time", vg.n);
      ((JSONObject)localObject1).put("vivo_ver_action_frame", vg.o);
      ((JSONObject)localObject1).put("vivo_reg_action1_type", wm.d);
      ((JSONObject)localObject1).put("vivo_reg_action2_type", wm.e);
      ((JSONObject)localObject1).put("vivo_ver_action_type", wm.f);
      ((JSONObject)localObject1).put("id_photo_front_time", ys.f);
      ((JSONObject)localObject1).put("id_photo_front_frame", ys.e);
      ((JSONObject)localObject1).put("id_photo_back_time", ys.h);
      ((JSONObject)localObject1).put("id_photo_back_frame", ys.g);
      localObject2 = aay.e(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_name", localObject2);
      }
      localObject2 = aay.d(RqdApplication.n());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_mac", localObject2);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localObject1 = aap.a(aay.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
    StringBuilder localStringBuilder1 = new StringBuilder("doRealNameReg data = ");
    localStringBuilder1.append(((String)localObject1).length());
    xv.a(localStringBuilder1.toString());
    paramabm.n.put("data", (String)localObject1);
    return paramabm;
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
 * Qualified Name:     com.tencent.token.wx
 * JD-Core Version:    0.7.0.1
 */