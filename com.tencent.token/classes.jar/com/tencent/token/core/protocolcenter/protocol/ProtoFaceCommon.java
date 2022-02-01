package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProtoFaceCommon
  extends d
{
  public static String d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public long p;
  public int q;
  private int r;
  private long s;
  private int t;
  private byte[] u;
  private int v;
  private int w;
  private int x;
  private JSONArray y;
  
  public static void a(dp paramdp, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4, int paramInt5)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdp.j = paramInt1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqdata.seq=");
    localStringBuilder.append(paramInt1);
    g.c(localStringBuilder.toString());
    paramdp.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdp.c.put("param.optype", Integer.valueOf(paramInt2));
    paramdp.c.put("param.facedata", paramArrayOfByte);
    paramdp.c.put("param.lockstatus", Integer.valueOf(paramInt3));
    paramdp.c.put("param.scene.id", Integer.valueOf(paramInt4));
    paramdp.c.put("param.light.mode", Integer.valueOf(paramInt5));
  }
  
  public static void e()
  {
    d = "";
    e = 0;
    f = 0;
    h = 0;
    g = 0;
    i = 0;
    j = 0;
    k = 0;
    l = 0;
    m = 0;
    n = 0;
    o = 0;
    ProtoLiveFaceDetect.d = 0;
    ProtoLiveFaceDetect.e = 0;
    ProtoLiveFaceDetect.f = 0;
  }
  
  protected String a()
  {
    if (cb.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.token.global.c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_face_reg_v2");
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp)
  {
    this.p = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.q = paramdp.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqdata.seq=");
    localStringBuilder.append(this.q);
    g.c(localStringBuilder.toString());
    this.s = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.t = ((Integer)paramdp.c.get("param.optype")).intValue();
    this.u = ((byte[])paramdp.c.get("param.facedata"));
    this.v = ((Integer)paramdp.c.get("param.lockstatus")).intValue();
    this.w = ((Integer)paramdp.c.get("param.scene.id")).intValue();
    this.x = ((Integer)paramdp.c.get("param.light.mode")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i1 = paramJSONObject.getInt("seq_id");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqdata.seq=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", json=");
      ((StringBuilder)localObject).append(paramJSONObject);
      g.c(((StringBuilder)localObject).toString());
      if (i1 != this.q)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i1);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.q);
        g.c(paramJSONObject.toString());
        return;
      }
      i1 = paramJSONObject.getInt("err");
      if (i1 != 0)
      {
        localObject = paramJSONObject.getString("info");
        this.r = paramJSONObject.getInt("op_type");
        com.tencent.token.core.bean.c localc = new com.tencent.token.core.bean.c();
        localc.a(this.r);
        localc.b(paramJSONObject.optInt("is_realname_qualified"));
        this.a.d = localc;
        a(i1, (String)localObject);
        return;
      }
      this.r = paramJSONObject.getInt("op_type");
      this.y = paramJSONObject.getJSONArray("no_face_uin_list");
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public dp b(dp paramdp)
  {
    int i3 = paramdp.j;
    int i2 = 1;
    paramdp.m = 1;
    paramdp.n = new ContentValues(3);
    paramdp.n.put("aq_base_sid", cb.a().b());
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.t != 2)
        {
          ((JSONObject)localObject1).put("uin", this.s);
        }
        else
        {
          ((JSONObject)localObject1).put("uin", this.s);
          if (this.v > 0) {
            ((JSONObject)localObject1).put("lock_status", this.v);
          }
        }
        ((JSONObject)localObject1).put("op_type", this.t);
        long l1 = System.currentTimeMillis();
        Object localObject2;
        StringBuilder localStringBuilder;
        if (this.t != 3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doFaceRecognition src data=");
          ((StringBuilder)localObject2).append(this.u.length);
          g.c(((StringBuilder)localObject2).toString());
          localObject2 = b.a(this.u);
          ((JSONObject)localObject1).put("img_data", localObject2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doFaceRecognition img_data=");
          localStringBuilder.append(((String)localObject2).length());
          g.c(localStringBuilder.toString());
          ((JSONObject)localObject1).put("resolution", d);
          ((JSONObject)localObject1).put("so_code_time", e);
          ((JSONObject)localObject1).put("face_detect_time", f);
          ((JSONObject)localObject1).put("face_detect_frame", h);
          if (FaceDetector.IsSupportNeon())
          {
            i1 = 1;
            ((JSONObject)localObject1).put("is_neon", i1);
            ((JSONObject)localObject1).put("face_model_init_time", g);
            ((JSONObject)localObject1).put("vivo_model_init_time", i);
            ((JSONObject)localObject1).put("vivo_reg_action1_time", j);
            ((JSONObject)localObject1).put("vivo_reg_action2_time", k);
            ((JSONObject)localObject1).put("vivo_reg_action1_frame", l);
            ((JSONObject)localObject1).put("vivo_reg_action2_frame", m);
            ((JSONObject)localObject1).put("vivo_ver_action_time", n);
            ((JSONObject)localObject1).put("vivo_ver_action_frame", o);
            ((JSONObject)localObject1).put("vivo_reg_action1_type", ProtoLiveFaceDetect.d);
            ((JSONObject)localObject1).put("vivo_reg_action2_type", ProtoLiveFaceDetect.e);
            ((JSONObject)localObject1).put("vivo_ver_action_type", ProtoLiveFaceDetect.f);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("android:");
            ((StringBuilder)localObject2).append(URLEncoder.encode(Build.VERSION.RELEASE));
            ((JSONObject)localObject1).put("mobile_os", ((StringBuilder)localObject2).toString());
            ((JSONObject)localObject1).put("algorithm", m.i());
          }
        }
        else
        {
          ((JSONObject)localObject1).put("op_time", (int)(cd.c().s() / 1000L));
          ((JSONObject)localObject1).put("seq_id", i3);
          ((JSONObject)localObject1).put("highlighted", this.x);
          if (this.w == 10) {
            i1 = i2;
          } else {
            i1 = this.w;
          }
          ((JSONObject)localObject1).put("scene", i1);
          i1 = (int)(System.currentTimeMillis() - l1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("encodeTime=");
          ((StringBuilder)localObject2).append(i1);
          g.c(((StringBuilder)localObject2).toString());
          ((JSONObject)localObject1).put("encode_time", i1);
          if (this.t == 5) {
            ((JSONObject)localObject1).put("token_seq", cd.c().k());
          }
          localObject2 = b.a(l.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
          paramdp.n.put("data", (String)localObject2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("resolution=");
          localStringBuilder.append(d);
          localStringBuilder.append(",so_code_time=");
          localStringBuilder.append(e);
          localStringBuilder.append(",scan_time=");
          localStringBuilder.append(f);
          localStringBuilder.append(",frame_cnt=");
          localStringBuilder.append(h);
          localStringBuilder.append(",encode_time=");
          localStringBuilder.append(i1);
          localStringBuilder.append(",seq=");
          localStringBuilder.append(i3);
          g.a(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doFaceRecognition data=");
          localStringBuilder.append(((JSONObject)localObject1).toString());
          g.a(localStringBuilder.toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doFaceRecognition base64 data=");
          ((StringBuilder)localObject1).append(((String)localObject2).length());
          g.a(((StringBuilder)localObject1).toString());
          return paramdp;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramdp;
      }
      int i1 = 0;
    }
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.r;
      localMessage.obj = this.y;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon
 * JD-Core Version:    0.7.0.1
 */