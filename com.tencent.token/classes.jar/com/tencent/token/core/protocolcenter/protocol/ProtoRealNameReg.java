package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cp;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.di;
import com.tencent.token.utils.b;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoRealNameReg
  extends e
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
  
  public static void a(ev paramev, long paramLong1, int paramInt1, long paramLong2, String paramString1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramev.c.put("param.realuin", Long.valueOf(paramLong2));
    paramev.c.put("param.realname", paramString1);
    paramev.c.put("param.idnumber", paramString2);
    paramev.c.put("param.optype", Integer.valueOf(paramInt2));
    paramev.c.put("param.facedata", paramArrayOfByte1);
    paramev.c.put("param.frontdata", paramArrayOfByte2);
    paramev.c.put("param.backdata", paramArrayOfByte3);
    paramev.c.put("param.prontphotoinfo", paramArrayOfByte4);
    paramev.c.put("param.backphotoinfo", paramArrayOfByte5);
    paramev.j = paramInt1;
  }
  
  protected String a()
  {
    if (cv.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_reg_v2";
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramev.c.get("param.realuin")).longValue();
    this.g = ((String)paramev.c.get("param.realname"));
    this.h = ((String)paramev.c.get("param.idnumber"));
    this.k = ((Integer)paramev.c.get("param.optype")).intValue();
    this.l = ((byte[])paramev.c.get("param.facedata"));
    this.m = ((byte[])paramev.c.get("param.frontdata"));
    this.n = ((byte[])paramev.c.get("param.backdata"));
    this.o = ((byte[])paramev.c.get("param.prontphotoinfo"));
    this.p = ((byte[])paramev.c.get("param.backphotoinfo"));
    this.f = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    String str;
    if (i1 != 0)
    {
      str = paramJSONObject.getString("info");
      paramJSONObject = w.c(paramJSONObject.getString("data"));
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
      paramJSONObject = w.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        h.a("ProtoRealNameReg json=" + paramJSONObject);
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.f)
        {
          this.a.b(10030);
          h.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.f);
          return;
        }
        this.q = new RealNameRegResult(paramJSONObject);
        this.a.c();
        return;
      }
      h.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.l().getString(2131230925));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public ev b(ev paramev)
  {
    int i1 = paramev.j;
    paramev.m = 1;
    paramev.n = new ContentValues(3);
    paramev.n.put("aq_base_sid", cv.a().b());
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", this.d);
      ((JSONObject)localObject).put("real_uin", this.e);
      ((JSONObject)localObject).put("realname", this.g);
      ((JSONObject)localObject).put("id_number", this.h);
      ((JSONObject)localObject).put("op_type", this.k);
      h.a("doRealNameReg common_data=" + ((JSONObject)localObject).toString());
      if (this.l != null)
      {
        str = b.a(this.l);
        ((JSONObject)localObject).put("face_data", str);
        h.a("doRealNameReg face_data=" + str.length());
      }
      if (this.m != null)
      {
        str = b.a(this.m);
        ((JSONObject)localObject).put("id_photo_front", str);
        h.a("doRealNameReg front_data=" + str.length());
      }
      if (this.n != null)
      {
        str = b.a(this.n);
        ((JSONObject)localObject).put("id_photo_back", str);
        h.a("doRealNameReg back_data=" + str.length());
      }
      if (this.o != null) {
        ((JSONObject)localObject).put("id_photo_info_front", b.a(this.o));
      }
      if (this.p != null) {
        ((JSONObject)localObject).put("id_photo_info_back", b.a(this.p));
      }
      ((JSONObject)localObject).put("token_seq", cx.c().k());
      ((JSONObject)localObject).put("guid", w.a(cp.a(RqdApplication.l()).b()));
      ((JSONObject)localObject).put("seq_id", i1);
      ((JSONObject)localObject).put("op_time", (int)(cx.c().s() / 1000L));
      ((JSONObject)localObject).put("vendor_id", Build.MANUFACTURER);
      ((JSONObject)localObject).put("android_id", w.a(RqdApplication.l()));
      ((JSONObject)localObject).put("imei", w.b(RqdApplication.l()));
      ((JSONObject)localObject).put("mac", w.c(RqdApplication.l()));
      ((JSONObject)localObject).put("device_model", Build.MODEL);
      ((JSONObject)localObject).put("sys_ver", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("face_detect_time", ProtoFaceCommon.f);
      ((JSONObject)localObject).put("face_detect_frame", ProtoFaceCommon.h);
      ((JSONObject)localObject).put("face_model_init_time", ProtoFaceCommon.g);
      ((JSONObject)localObject).put("vivo_model_init_time", ProtoFaceCommon.i);
      ((JSONObject)localObject).put("vivo_reg_action1_time", ProtoFaceCommon.j);
      ((JSONObject)localObject).put("vivo_reg_action2_time", ProtoFaceCommon.k);
      ((JSONObject)localObject).put("vivo_reg_action1_frame", ProtoFaceCommon.l);
      ((JSONObject)localObject).put("vivo_reg_action2_frame", ProtoFaceCommon.m);
      ((JSONObject)localObject).put("vivo_ver_action_time", ProtoFaceCommon.n);
      ((JSONObject)localObject).put("vivo_ver_action_frame", ProtoFaceCommon.o);
      ((JSONObject)localObject).put("vivo_reg_action1_type", ProtoLiveFaceDetect.d);
      ((JSONObject)localObject).put("vivo_reg_action2_type", ProtoLiveFaceDetect.e);
      ((JSONObject)localObject).put("vivo_ver_action_type", ProtoLiveFaceDetect.f);
      ((JSONObject)localObject).put("id_photo_front_time", di.b);
      ((JSONObject)localObject).put("id_photo_front_frame", di.a);
      ((JSONObject)localObject).put("id_photo_back_time", di.d);
      ((JSONObject)localObject).put("id_photo_back_frame", di.c);
      String str = w.e(RqdApplication.l());
      if (!TextUtils.isEmpty(str)) {
        ((JSONObject)localObject).put("route_name", str);
      }
      str = w.d(RqdApplication.l());
      if (!TextUtils.isEmpty(str)) {
        ((JSONObject)localObject).put("route_mac", str);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject = b.a(w.c(((JSONObject)localObject).toString().getBytes())).replace('+', '-').replace('=', '_');
    h.a("doRealNameReg data = " + ((String)localObject).length());
    paramev.n.put("data", (String)localObject);
    return paramev;
  }
  
  protected void b()
  {
    if (!this.b.e)
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoRealNameReg
 * JD-Core Version:    0.7.0.1
 */