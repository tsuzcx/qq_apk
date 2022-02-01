package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.token.global.RqdApplication;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class uu
  extends tr
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
  
  public static void d()
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
    wa.d = 0;
    wa.e = 0;
    wa.f = 0;
  }
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.p = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.q = paramabc.j;
    StringBuilder localStringBuilder = new StringBuilder("reqdata.seq=");
    localStringBuilder.append(this.q);
    xj.c(localStringBuilder.toString());
    this.s = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.t = ((Integer)paramabc.c.get("param.optype")).intValue();
    this.u = ((byte[])paramabc.c.get("param.facedata"));
    this.v = ((Integer)paramabc.c.get("param.lockstatus")).intValue();
    this.w = ((Integer)paramabc.c.get("param.scene.id")).intValue();
    this.x = ((Integer)paramabc.c.get("param.light.mode")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i1 = paramJSONObject.getInt("seq_id");
      Object localObject = new StringBuilder("reqdata.seq=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", json=");
      ((StringBuilder)localObject).append(paramJSONObject);
      xj.c(((StringBuilder)localObject).toString());
      if (i1 != this.q)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i1);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.q);
        xj.c(paramJSONObject.toString());
        return;
      }
      i1 = paramJSONObject.getInt("err");
      if (i1 != 0)
      {
        localObject = paramJSONObject.getString("info");
        this.r = paramJSONObject.getInt("op_type");
        so localso = new so();
        localso.a = this.r;
        localso.b = paramJSONObject.optInt("is_realname_qualified");
        this.a.d = localso;
        a(i1, (String)localObject);
        return;
      }
      this.r = paramJSONObject.getInt("op_type");
      this.y = paramJSONObject.getJSONArray("no_face_uin_list");
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final abc b(abc paramabc)
  {
    int i3 = paramabc.j;
    int i2 = 1;
    paramabc.m = 1;
    paramabc.n = new ContentValues(3);
    Object localObject1 = paramabc.n;
    sh.a();
    ((ContentValues)localObject1).put("aq_base_sid", null);
    localObject1 = new JSONObject();
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
          localObject2 = new StringBuilder("doFaceRecognition src data=");
          ((StringBuilder)localObject2).append(this.u.length);
          xj.c(((StringBuilder)localObject2).toString());
          localObject2 = aaf.a(this.u);
          ((JSONObject)localObject1).put("img_data", localObject2);
          localStringBuilder = new StringBuilder("doFaceRecognition img_data=");
          localStringBuilder.append(((String)localObject2).length());
          xj.c(localStringBuilder.toString());
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
            ((JSONObject)localObject1).put("vivo_reg_action1_type", wa.d);
            ((JSONObject)localObject1).put("vivo_reg_action2_type", wa.e);
            ((JSONObject)localObject1).put("vivo_ver_action_type", wa.f);
            localObject2 = new StringBuilder("android:");
            ((StringBuilder)localObject2).append(URLEncoder.encode(Build.VERSION.RELEASE));
            ((JSONObject)localObject1).put("mobile_os", ((StringBuilder)localObject2).toString());
            ((JSONObject)localObject1).put("algorithm", aap.i());
          }
        }
        else
        {
          ((JSONObject)localObject1).put("op_time", (int)(sj.b().i() / 1000L));
          ((JSONObject)localObject1).put("seq_id", i3);
          ((JSONObject)localObject1).put("highlighted", this.x);
          if (this.w == 10) {
            i1 = i2;
          } else {
            i1 = this.w;
          }
          ((JSONObject)localObject1).put("scene", i1);
          i1 = (int)(System.currentTimeMillis() - l1);
          xj.c("encodeTime=".concat(String.valueOf(i1)));
          ((JSONObject)localObject1).put("encode_time", i1);
          if (this.t == 5) {
            ((JSONObject)localObject1).put("token_seq", sj.b().a.d());
          }
          localObject2 = aaf.a(aao.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
          paramabc.n.put("data", (String)localObject2);
          localStringBuilder = new StringBuilder("resolution=");
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
          xj.a(localStringBuilder.toString());
          localStringBuilder = new StringBuilder("doFaceRecognition data=");
          localStringBuilder.append(((JSONObject)localObject1).toString());
          xj.a(localStringBuilder.toString());
          localObject1 = new StringBuilder("doFaceRecognition base64 data=");
          ((StringBuilder)localObject1).append(((String)localObject2).length());
          xj.a(((StringBuilder)localObject1).toString());
          return paramabc;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramabc;
      }
      int i1 = 0;
    }
  }
  
  public final void b()
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
 * Qualified Name:     com.tencent.token.uu
 * JD-Core Version:    0.7.0.1
 */