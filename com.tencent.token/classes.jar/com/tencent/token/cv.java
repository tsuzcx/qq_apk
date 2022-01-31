package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class cv
  extends bm
{
  public static String c;
  public static int d;
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
  public static boolean o;
  public long p;
  public int q;
  private int r;
  private long s;
  private int t;
  private byte[] u;
  private int v;
  private int w;
  
  public static void e()
  {
    c = "";
    d = 0;
    e = 0;
    g = 0;
    f = 0;
    h = 0;
    i = 0;
    j = 0;
    k = 0;
    l = 0;
    m = 0;
    n = 0;
    ei.c = 0;
    ei.d = 0;
    ei.e = 0;
  }
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    return com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_face_reg";
  }
  
  protected final void a(fs paramfs)
  {
    this.p = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.q = paramfs.j;
    e.c("reqdata.seq=" + this.q);
    this.s = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.t = ((Integer)paramfs.c.get("param.optype")).intValue();
    this.u = ((byte[])paramfs.c.get("param.facedata"));
    this.v = ((Integer)paramfs.c.get("param.lockstatus")).intValue();
    this.w = ((Integer)paramfs.c.get("param.scene.id")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i1 = paramJSONObject.getInt("seq_id");
      e.c("reqdata.seq=" + i1 + ", json=" + paramJSONObject);
      if (i1 != this.q)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.q);
        return;
      }
      i1 = paramJSONObject.getInt("err");
      if (i1 != 0)
      {
        String str = paramJSONObject.getString("info");
        this.r = paramJSONObject.getInt("op_type");
        this.a.d = Integer.valueOf(this.r);
        a(i1, str);
        return;
      }
      this.r = paramJSONObject.getInt("op_type");
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  public final fs b(fs paramfs)
  {
    int i2 = paramfs.j;
    paramfs.m = 1;
    paramfs.n = new ContentValues(3);
    Object localObject3 = paramfs.n;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    label795:
    Object localObject2;
    for (Object localObject1 = ax.c;; localObject2 = null)
    {
      ((ContentValues)localObject3).put("aq_base_sid", (String)localObject1);
      paramfs.n.put("uin", Long.valueOf(this.p));
      localObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          if (this.t != 2)
          {
            ((JSONObject)localObject1).put("uin", this.s);
            ((JSONObject)localObject1).put("op_type", this.t);
            long l1 = System.currentTimeMillis();
            if (this.t != 3)
            {
              e.c("doFaceRecognition src data=" + this.u.length);
              localObject3 = com.tencent.token.utils.b.a(this.u);
              ((JSONObject)localObject1).put("img_data", localObject3);
              e.c("doFaceRecognition img_data=" + ((String)localObject3).length());
              ((JSONObject)localObject1).put("resolution", c);
              ((JSONObject)localObject1).put("so_code_time", d);
              ((JSONObject)localObject1).put("face_detect_time", e);
              ((JSONObject)localObject1).put("face_detect_frame", g);
              if (FaceDetector.IsSupportNeon())
              {
                i1 = 1;
                ((JSONObject)localObject1).put("is_neon", i1);
                ((JSONObject)localObject1).put("face_model_init_time", f);
                ((JSONObject)localObject1).put("vivo_model_init_time", h);
                ((JSONObject)localObject1).put("vivo_reg_action1_time", i);
                ((JSONObject)localObject1).put("vivo_reg_action2_time", j);
                ((JSONObject)localObject1).put("vivo_reg_action1_frame", k);
                ((JSONObject)localObject1).put("vivo_reg_action2_frame", l);
                ((JSONObject)localObject1).put("vivo_ver_action_time", m);
                ((JSONObject)localObject1).put("vivo_ver_action_frame", n);
                ((JSONObject)localObject1).put("vivo_reg_action1_type", ei.c);
                ((JSONObject)localObject1).put("vivo_reg_action2_type", ei.d);
                ((JSONObject)localObject1).put("vivo_ver_action_type", ei.e);
                ((JSONObject)localObject1).put("mobile_os", "android:" + URLEncoder.encode(Build.VERSION.RELEASE));
                ((JSONObject)localObject1).put("algorithm", t.l());
              }
            }
            else
            {
              ((JSONObject)localObject1).put("op_time", (int)(ag.c().r() / 1000L));
              ((JSONObject)localObject1).put("seq_id", i2);
              if (this.w != 6) {
                break label795;
              }
              i1 = 1;
              ((JSONObject)localObject1).put("scene", i1);
              if (this.t == 5) {
                ((JSONObject)localObject1).put("token_seq", ag.c().k());
              }
              localObject3 = com.tencent.token.utils.b.a(s.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
              i1 = (int)(System.currentTimeMillis() - l1);
              e.c("encodeTime=" + i1);
              paramfs.n.put("data", (String)localObject3);
              paramfs.n.put("encode_time", Integer.valueOf(i1));
              e.a("resolution=" + c + ",so_code_time=" + d + ",scan_time=" + e + ",frame_cnt=" + g + ",encode_time=" + i1 + ",seq=" + i2);
              e.a("doFaceRecognition data=" + ((JSONObject)localObject1).toString());
              e.a("doFaceRecognition base64 data=" + ((String)localObject3).length());
              return paramfs;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("uin", this.s);
            if (this.v <= 0) {
              continue;
            }
            ((JSONObject)localObject1).put("lock_status", this.v);
            continue;
          }
          i1 = 0;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return paramfs;
        }
        continue;
        int i1 = this.w;
      }
    }
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.r;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cv
 * JD-Core Version:    0.7.0.1
 */