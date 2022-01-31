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
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.ct;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class er
  extends bm
{
  public static String h;
  public static String i;
  public long c;
  public long d;
  public int e;
  public String f;
  public String g;
  private int j;
  private byte[] k;
  private byte[] l;
  private byte[] m;
  private byte[] n;
  private byte[] o;
  private RealNameRegResult p;
  
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
    return com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_realname_reg";
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((String)paramfs.c.get("param.realname"));
    this.g = ((String)paramfs.c.get("param.idnumber"));
    this.j = ((Integer)paramfs.c.get("param.optype")).intValue();
    this.k = ((byte[])paramfs.c.get("param.facedata"));
    this.l = ((byte[])paramfs.c.get("param.frontdata"));
    this.m = ((byte[])paramfs.c.get("param.backdata"));
    this.n = ((byte[])paramfs.c.get("param.prontphotoinfo"));
    this.o = ((byte[])paramfs.c.get("param.backphotoinfo"));
    this.e = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    String str;
    if (i1 != 0)
    {
      str = paramJSONObject.getString("info");
      paramJSONObject = s.d(paramJSONObject.getString("data"));
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h = paramJSONObject.getString("hint_title");
      i = paramJSONObject.getString("hint_content");
      label66:
      a(i1, str);
      return;
      paramJSONObject = s.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        e.a("ProtoRealNameReg json=" + paramJSONObject);
        i1 = paramJSONObject.getInt("seq_id");
        if (i1 != this.e)
        {
          this.a.a(10030, null, null);
          e.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.e);
          return;
        }
        this.p = new RealNameRegResult(paramJSONObject);
        this.a.a = 0;
        return;
      }
      e.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.i().getString(2131361799));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label66;
    }
  }
  
  public final fs b(fs paramfs)
  {
    int i1 = paramfs.j;
    paramfs.m = 1;
    paramfs.n = new ContentValues(3);
    Object localObject2 = paramfs.n;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (Object localObject1 = ax.c;; localObject1 = null)
    {
      ((ContentValues)localObject2).put("aq_base_sid", (String)localObject1);
      paramfs.n.put("uin", Long.valueOf(this.c));
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("real_uin", this.d);
        ((JSONObject)localObject1).put("realname", this.f);
        ((JSONObject)localObject1).put("id_number", this.g);
        ((JSONObject)localObject1).put("op_type", this.j);
        e.a("doRealNameReg common_data=" + ((JSONObject)localObject1).toString());
        if (this.k != null)
        {
          localObject2 = com.tencent.token.utils.b.a(this.k);
          ((JSONObject)localObject1).put("face_data", localObject2);
          e.a("doRealNameReg face_data=" + ((String)localObject2).length());
        }
        if (this.l != null)
        {
          localObject2 = com.tencent.token.utils.b.a(this.l);
          ((JSONObject)localObject1).put("id_photo_front", localObject2);
          e.a("doRealNameReg front_data=" + ((String)localObject2).length());
        }
        if (this.m != null)
        {
          localObject2 = com.tencent.token.utils.b.a(this.m);
          ((JSONObject)localObject1).put("id_photo_back", localObject2);
          e.a("doRealNameReg back_data=" + ((String)localObject2).length());
        }
        if (this.n != null) {
          ((JSONObject)localObject1).put("id_photo_info_front", com.tencent.token.utils.b.a(this.n));
        }
        if (this.o != null) {
          ((JSONObject)localObject1).put("id_photo_info_back", com.tencent.token.utils.b.a(this.o));
        }
        ((JSONObject)localObject1).put("token_seq", ag.c().k());
        ((JSONObject)localObject1).put("guid", s.a(x.a(RqdApplication.i()).c()));
        ((JSONObject)localObject1).put("seq_id", i1);
        ((JSONObject)localObject1).put("op_time", (int)(ag.c().r() / 1000L));
        ((JSONObject)localObject1).put("vendor_id", Build.MANUFACTURER);
        ((JSONObject)localObject1).put("android_id", s.a(RqdApplication.i()));
        ((JSONObject)localObject1).put("imei", s.b(RqdApplication.i()));
        ((JSONObject)localObject1).put("mac", s.c(RqdApplication.i()));
        ((JSONObject)localObject1).put("device_model", Build.MODEL);
        ((JSONObject)localObject1).put("sys_ver", Build.VERSION.RELEASE);
        ((JSONObject)localObject1).put("face_detect_time", cv.e);
        ((JSONObject)localObject1).put("face_detect_frame", cv.g);
        ((JSONObject)localObject1).put("face_model_init_time", cv.f);
        ((JSONObject)localObject1).put("vivo_model_init_time", cv.h);
        ((JSONObject)localObject1).put("vivo_reg_action1_time", cv.i);
        ((JSONObject)localObject1).put("vivo_reg_action2_time", cv.j);
        ((JSONObject)localObject1).put("vivo_reg_action1_frame", cv.k);
        ((JSONObject)localObject1).put("vivo_reg_action2_frame", cv.l);
        ((JSONObject)localObject1).put("vivo_ver_action_time", cv.m);
        ((JSONObject)localObject1).put("vivo_ver_action_frame", cv.n);
        ((JSONObject)localObject1).put("vivo_reg_action1_type", ei.c);
        ((JSONObject)localObject1).put("vivo_reg_action2_type", ei.d);
        ((JSONObject)localObject1).put("vivo_ver_action_type", ei.e);
        ((JSONObject)localObject1).put("id_photo_front_time", ct.b);
        ((JSONObject)localObject1).put("id_photo_front_frame", ct.a);
        ((JSONObject)localObject1).put("id_photo_back_time", ct.d);
        ((JSONObject)localObject1).put("id_photo_back_frame", ct.c);
        localObject2 = s.e(RqdApplication.i());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("route_name", localObject2);
        }
        localObject2 = s.d(RqdApplication.i());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("route_mac", localObject2);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localObject1 = com.tencent.token.utils.b.a(s.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
      e.a("doRealNameReg data = " + ((String)localObject1).length());
      paramfs.n.put("data", (String)localObject1);
      return paramfs;
    }
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.p;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.er
 * JD-Core Version:    0.7.0.1
 */