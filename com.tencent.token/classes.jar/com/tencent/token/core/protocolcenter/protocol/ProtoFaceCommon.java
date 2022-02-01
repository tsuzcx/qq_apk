package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
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
  
  public static void a(dn paramdn, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4, int paramInt5)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdn.j = paramInt1;
    g.c("reqdata.seq=" + paramInt1);
    paramdn.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdn.c.put("param.optype", Integer.valueOf(paramInt2));
    paramdn.c.put("param.facedata", paramArrayOfByte);
    paramdn.c.put("param.lockstatus", Integer.valueOf(paramInt3));
    paramdn.c.put("param.scene.id", Integer.valueOf(paramInt4));
    paramdn.c.put("param.light.mode", Integer.valueOf(paramInt5));
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
    if (bz.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    return com.tencent.token.global.c.e() + "/cn/mbtoken3/mbtoken3_face_reg_v2";
  }
  
  protected void a(dn paramdn)
  {
    this.p = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.q = paramdn.j;
    g.c("reqdata.seq=" + this.q);
    this.s = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.t = ((Integer)paramdn.c.get("param.optype")).intValue();
    this.u = ((byte[])paramdn.c.get("param.facedata"));
    this.v = ((Integer)paramdn.c.get("param.lockstatus")).intValue();
    this.w = ((Integer)paramdn.c.get("param.scene.id")).intValue();
    this.x = ((Integer)paramdn.c.get("param.light.mode")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i1 = paramJSONObject.getInt("seq_id");
      g.c("reqdata.seq=" + i1 + ", json=" + paramJSONObject);
      if (i1 != this.q)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.q);
        return;
      }
      i1 = paramJSONObject.getInt("err");
      if (i1 != 0)
      {
        String str = paramJSONObject.getString("info");
        this.r = paramJSONObject.getInt("op_type");
        com.tencent.token.core.bean.c localc = new com.tencent.token.core.bean.c();
        localc.a(this.r);
        localc.b(paramJSONObject.optInt("is_realname_qualified"));
        this.a.d = localc;
        a(i1, str);
        return;
      }
      this.r = paramJSONObject.getInt("op_type");
      this.y = paramJSONObject.getJSONArray("no_face_uin_list");
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  public dn b(dn paramdn)
  {
    int i2 = 1;
    int i3 = paramdn.j;
    paramdn.m = 1;
    paramdn.n = new ContentValues(3);
    paramdn.n.put("aq_base_sid", bz.a().b());
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.t != 2)
        {
          localJSONObject.put("uin", this.s);
          localJSONObject.put("op_type", this.t);
          long l1 = System.currentTimeMillis();
          String str;
          if (this.t != 3)
          {
            g.c("doFaceRecognition src data=" + this.u.length);
            str = b.a(this.u);
            localJSONObject.put("img_data", str);
            g.c("doFaceRecognition img_data=" + str.length());
            localJSONObject.put("resolution", d);
            localJSONObject.put("so_code_time", e);
            localJSONObject.put("face_detect_time", f);
            localJSONObject.put("face_detect_frame", h);
            if (FaceDetector.IsSupportNeon())
            {
              i1 = 1;
              localJSONObject.put("is_neon", i1);
              localJSONObject.put("face_model_init_time", g);
              localJSONObject.put("vivo_model_init_time", i);
              localJSONObject.put("vivo_reg_action1_time", j);
              localJSONObject.put("vivo_reg_action2_time", k);
              localJSONObject.put("vivo_reg_action1_frame", l);
              localJSONObject.put("vivo_reg_action2_frame", m);
              localJSONObject.put("vivo_ver_action_time", n);
              localJSONObject.put("vivo_ver_action_frame", o);
              localJSONObject.put("vivo_reg_action1_type", ProtoLiveFaceDetect.d);
              localJSONObject.put("vivo_reg_action2_type", ProtoLiveFaceDetect.e);
              localJSONObject.put("vivo_ver_action_type", ProtoLiveFaceDetect.f);
              localJSONObject.put("mobile_os", "android:" + URLEncoder.encode(Build.VERSION.RELEASE));
              localJSONObject.put("algorithm", m.i());
            }
          }
          else
          {
            localJSONObject.put("op_time", (int)(cb.c().s() / 1000L));
            localJSONObject.put("seq_id", i3);
            localJSONObject.put("highlighted", this.x);
            if (this.w != 10) {
              break label771;
            }
            i1 = i2;
            localJSONObject.put("scene", i1);
            i1 = (int)(System.currentTimeMillis() - l1);
            g.c("encodeTime=" + i1);
            localJSONObject.put("encode_time", i1);
            if (this.t == 5) {
              localJSONObject.put("token_seq", cb.c().k());
            }
            str = b.a(l.c(localJSONObject.toString().getBytes())).replace('+', '-').replace('=', '_');
            paramdn.n.put("data", str);
            g.a("resolution=" + d + ",so_code_time=" + e + ",scan_time=" + f + ",frame_cnt=" + h + ",encode_time=" + i1 + ",seq=" + i3);
            g.a("doFaceRecognition data=" + localJSONObject.toString());
            g.a("doFaceRecognition base64 data=" + str.length());
            return paramdn;
          }
        }
        else
        {
          localJSONObject.put("uin", this.s);
          if (this.v <= 0) {
            continue;
          }
          localJSONObject.put("lock_status", this.v);
          continue;
        }
        i1 = 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramdn;
      }
      continue;
      label771:
      int i1 = this.w;
    }
  }
  
  protected void b()
  {
    if (!this.b.e)
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