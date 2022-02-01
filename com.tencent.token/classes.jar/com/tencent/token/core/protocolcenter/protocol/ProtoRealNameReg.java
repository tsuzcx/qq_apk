package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.g;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoRealNameReg
  extends d
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
  
  public static void a(do paramdo, long paramLong1, int paramInt1, long paramLong2, String paramString1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.c.put("param.realname", paramString1);
    paramdo.c.put("param.idnumber", paramString2);
    paramdo.c.put("param.optype", Integer.valueOf(paramInt2));
    paramdo.c.put("param.facedata", paramArrayOfByte1);
    paramdo.c.put("param.frontdata", paramArrayOfByte2);
    paramdo.c.put("param.backdata", paramArrayOfByte3);
    paramdo.c.put("param.prontphotoinfo", paramArrayOfByte4);
    paramdo.c.put("param.backphotoinfo", paramArrayOfByte5);
    paramdo.j = paramInt1;
  }
  
  protected String a()
  {
    if (ca.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_realname_reg_v2");
    return localStringBuilder.toString();
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.g = ((String)paramdo.c.get("param.realname"));
    this.h = ((String)paramdo.c.get("param.idnumber"));
    this.k = ((Integer)paramdo.c.get("param.optype")).intValue();
    this.l = ((byte[])paramdo.c.get("param.facedata"));
    this.m = ((byte[])paramdo.c.get("param.frontdata"));
    this.n = ((byte[])paramdo.c.get("param.backdata"));
    this.o = ((byte[])paramdo.c.get("param.prontphotoinfo"));
    this.p = ((byte[])paramdo.c.get("param.backphotoinfo"));
    this.f = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    Object localObject;
    if (i1 != 0)
    {
      localObject = paramJSONObject.getString("info");
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getString("hint_title");
      j = paramJSONObject.getString("hint_content");
      label66:
      a(i1, (String)localObject);
      return;
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ProtoRealNameReg json=");
        ((StringBuilder)localObject).append(paramJSONObject);
        g.a(((StringBuilder)localObject).toString());
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.f)
        {
          this.a.b(10030);
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("parseJSON error seq is wrong seq=");
          paramJSONObject.append(i1);
          paramJSONObject.append(",right = ");
          paramJSONObject.append(this.f);
          g.c(paramJSONObject.toString());
          return;
        }
        this.q = new RealNameRegResult(paramJSONObject);
        this.a.c();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseJSON error decodeData=");
      ((StringBuilder)localObject).append(paramJSONObject);
      g.c(((StringBuilder)localObject).toString());
      a(10022, RqdApplication.l().getString(2131493067));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public do b(do paramdo)
  {
    int i1 = paramdo.j;
    paramdo.m = 1;
    paramdo.n = new ContentValues(3);
    paramdo.n.put("aq_base_sid", ca.a().b());
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("uin", this.d);
      ((JSONObject)localObject1).put("real_uin", this.e);
      ((JSONObject)localObject1).put("realname", this.g);
      ((JSONObject)localObject1).put("id_number", this.h);
      ((JSONObject)localObject1).put("op_type", this.k);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doRealNameReg common_data=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      g.a(((StringBuilder)localObject2).toString());
      StringBuilder localStringBuilder2;
      if (this.l != null)
      {
        localObject2 = b.a(this.l);
        ((JSONObject)localObject1).put("face_data", localObject2);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("doRealNameReg face_data=");
        localStringBuilder2.append(((String)localObject2).length());
        g.a(localStringBuilder2.toString());
      }
      if (this.m != null)
      {
        localObject2 = b.a(this.m);
        ((JSONObject)localObject1).put("id_photo_front", localObject2);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("doRealNameReg front_data=");
        localStringBuilder2.append(((String)localObject2).length());
        g.a(localStringBuilder2.toString());
      }
      if (this.n != null)
      {
        localObject2 = b.a(this.n);
        ((JSONObject)localObject1).put("id_photo_back", localObject2);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("doRealNameReg back_data=");
        localStringBuilder2.append(((String)localObject2).length());
        g.a(localStringBuilder2.toString());
      }
      if (this.o != null) {
        ((JSONObject)localObject1).put("id_photo_info_front", b.a(this.o));
      }
      if (this.p != null) {
        ((JSONObject)localObject1).put("id_photo_info_back", b.a(this.p));
      }
      ((JSONObject)localObject1).put("token_seq", cc.c().k());
      ((JSONObject)localObject1).put("guid", l.a(bz.a(RqdApplication.l()).b()));
      ((JSONObject)localObject1).put("seq_id", i1);
      ((JSONObject)localObject1).put("op_time", (int)(cc.c().s() / 1000L));
      ((JSONObject)localObject1).put("vendor_id", Build.MANUFACTURER);
      ((JSONObject)localObject1).put("android_id", l.a(RqdApplication.l()));
      ((JSONObject)localObject1).put("imei", l.b(RqdApplication.l()));
      ((JSONObject)localObject1).put("mac", l.c(RqdApplication.l()));
      ((JSONObject)localObject1).put("device_model", Build.MODEL);
      ((JSONObject)localObject1).put("sys_ver", Build.VERSION.RELEASE);
      ((JSONObject)localObject1).put("face_detect_time", ProtoFaceCommon.f);
      ((JSONObject)localObject1).put("face_detect_frame", ProtoFaceCommon.h);
      ((JSONObject)localObject1).put("face_model_init_time", ProtoFaceCommon.g);
      ((JSONObject)localObject1).put("vivo_model_init_time", ProtoFaceCommon.i);
      ((JSONObject)localObject1).put("vivo_reg_action1_time", ProtoFaceCommon.j);
      ((JSONObject)localObject1).put("vivo_reg_action2_time", ProtoFaceCommon.k);
      ((JSONObject)localObject1).put("vivo_reg_action1_frame", ProtoFaceCommon.l);
      ((JSONObject)localObject1).put("vivo_reg_action2_frame", ProtoFaceCommon.m);
      ((JSONObject)localObject1).put("vivo_ver_action_time", ProtoFaceCommon.n);
      ((JSONObject)localObject1).put("vivo_ver_action_frame", ProtoFaceCommon.o);
      ((JSONObject)localObject1).put("vivo_reg_action1_type", ProtoLiveFaceDetect.d);
      ((JSONObject)localObject1).put("vivo_reg_action2_type", ProtoLiveFaceDetect.e);
      ((JSONObject)localObject1).put("vivo_ver_action_type", ProtoLiveFaceDetect.f);
      ((JSONObject)localObject1).put("id_photo_front_time", com.tencent.token.ui.e.b);
      ((JSONObject)localObject1).put("id_photo_front_frame", com.tencent.token.ui.e.a);
      ((JSONObject)localObject1).put("id_photo_back_time", com.tencent.token.ui.e.d);
      ((JSONObject)localObject1).put("id_photo_back_frame", com.tencent.token.ui.e.c);
      localObject2 = l.e(RqdApplication.l());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_name", localObject2);
      }
      localObject2 = l.d(RqdApplication.l());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((JSONObject)localObject1).put("route_mac", localObject2);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localObject1 = b.a(l.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("doRealNameReg data = ");
    localStringBuilder1.append(((String)localObject1).length());
    g.a(localStringBuilder1.toString());
    paramdo.n.put("data", (String)localObject1);
    return paramdo;
  }
  
  protected void b()
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoRealNameReg
 * JD-Core Version:    0.7.0.1
 */