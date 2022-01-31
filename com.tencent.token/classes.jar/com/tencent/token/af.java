package com.tencent.token;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.jni.FaceDetector;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.ct;
import com.tencent.token.utils.b;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
  implements bh
{
  public static int a = new Random().nextInt() >>> 1;
  private static af b;
  private bn c = new bn();
  
  public static af a()
  {
    if (b == null) {
      b = new af();
    }
    return b;
  }
  
  public static int b()
  {
    return a;
  }
  
  public final int a(byte paramByte, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_get_dual_msg_list_v2", 2, paramHandler, 3069);
    paramHandler.c.put("param.uinhash", Long.valueOf(0L));
    paramHandler.c.put("param.msg.source", Byte.valueOf(paramByte));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_get_config_v2", 2, paramHandler, 3041);
    paramHandler.c.put("param.config.width", Integer.valueOf(paramInt1));
    paramHandler.c.put("param.config.height", Integer.valueOf(paramInt2));
    paramHandler.c.put("param.config.dpi", Integer.valueOf(paramInt3));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    if (0L == 0L)
    {
      if (localObject == null)
      {
        paramSafeMsgItem = paramHandler.obtainMessage(3032);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramSafeMsgItem.arg1 = paramHandler.a;
        paramSafeMsgItem.obj = paramHandler;
        paramSafeMsgItem.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_report_location", 3, paramHandler, 3032);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    localObject = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject1.put("type_a", paramSafeMsgItem.mTypea);
      localJSONObject1.put("type_b", paramSafeMsgItem.mTypeb);
      localJSONObject1.put("type_c", paramSafeMsgItem.mTypec);
      int i = paramSafeMsgItem.a();
      localJSONObject2.put("ip", i);
      localJSONObject2.put("country_id", paramSafeMsgItem.mLoc_country_id);
      localJSONObject2.put("prov_id", paramSafeMsgItem.mLoc_prov_id);
      localJSONObject2.put("city_id", paramSafeMsgItem.mLoc_city_id);
      localJSONObject3.put("ip", i);
      localJSONObject3.put("country_id", 1);
      localJSONObject3.put("prov_id", paramInt1);
      localJSONObject3.put("city_id", paramInt2);
      ((JSONObject)localObject).put("msg_time", paramSafeMsgItem.mTime);
      ((JSONObject)localObject).put("msg_type", localJSONObject1);
      ((JSONObject)localObject).put("old_loc", localJSONObject2);
      ((JSONObject)localObject).put("new_loc", localJSONObject3);
      if ((paramInt3 == 1) || (paramInt3 == 2)) {
        ((JSONObject)localObject).put("feed_priv_ip_type", paramInt3);
      }
      paramHandler.c.put("param.loginmsg.reportlocation", URLEncoder.encode(((JSONObject)localObject).toString()));
    }
    catch (Exception paramSafeMsgItem)
    {
      for (;;)
      {
        paramSafeMsgItem.printStackTrace();
        paramHandler.c.put("param.loginmsg.reportlocation", "");
      }
    }
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    if (0L == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3005);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_get_message_v2", 3, paramHandler, 3005);
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
      du.a(paramHandler, paramLong, paramInt, 1, 1);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public final int a(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2, long paramLong3, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3045);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong1 = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_jl_appeal", 3, paramHandler, 3045);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramHandler.c.put("param.jl_roleid", Integer.valueOf(paramInt1));
    paramHandler.c.put("param.jl_rolename", paramString1);
    paramHandler.c.put("param.jl_zoneid", Integer.valueOf(paramInt2));
    paramHandler.c.put("param.jl_serverid", Integer.valueOf(paramInt3));
    paramHandler.c.put("param.jl_servername", paramString2);
    paramHandler.c.put("param.jl_lastlogintime", Long.valueOf(paramLong2));
    paramHandler.c.put("param.jl_stealtime", Long.valueOf(paramLong3));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_verify_captcha_v2", 2, paramHandler, 3072);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.scene.id", Integer.valueOf(paramInt));
    paramHandler.c.put("param.captcha", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3012);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_set_mod_mobile", 3, paramHandler, 3012);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbmobile.set", Integer.valueOf(paramInt));
    paramHandler.c.put("param.mbmobile.mobile", paramString1);
    paramHandler.c.put("param.mbmoible.areacode", paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, Handler paramHandler)
  {
    QQUser localQQUser = ax.a().e();
    if (0L == 0L)
    {
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3005);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_get_message_v2", 3, paramHandler, 3005);
    paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.msg.source", Integer.valueOf(paramInt));
    paramHandler.c.put("param.msg.type", Integer.valueOf(1));
    paramHandler.c.put("param.msg.num", Integer.valueOf(40));
    paramHandler.c.put("param.msg.filter", Integer.valueOf(0));
    paramHandler.c.put("param.device.lock.guid", paramString1);
    paramHandler.c.put("param.device.lock.appid", Integer.valueOf(523005425));
    paramHandler.c.put("param.device.lock.subappid", Integer.valueOf(1));
    paramHandler.c.put("param.device.lock.appname", paramString2);
    paramHandler.c.put("param.skey", paramString3);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = ax.a().e();
    if (0L == 0L)
    {
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3004);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_face_verify_on_off", 3, paramHandler, 4002);
    int i = a + 1;
    a = i;
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.scene_id", Integer.valueOf(paramInt));
    paramHandler.c.put("param.verifyonoff", Boolean.valueOf(paramBoolean));
    paramHandler.c.put("param.wtlogin.a2", paramString);
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, Handler paramHandler)
  {
    Object localObject;
    if (paramLong2 == 0L)
    {
      if (paramLong1 != 0L) {
        break label191;
      }
      localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong1 = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_check_up_sms", 2, paramHandler, 3068);
      a += 1;
      cc.a(paramHandler, paramLong1, ((QQUser)localObject).mRealUin, paramInt, a);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new fs("mbtoken3_check_up_sms", 2, paramHandler, 3068);
      a += 1;
      cc.a(paramHandler, s.f(paramLong2), paramLong2, paramInt, a);
      this.c.a(paramHandler);
      return 0;
      label191:
      localObject = null;
    }
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString, Handler paramHandler)
  {
    QQUser localQQUser;
    if (paramLong2 == 0L)
    {
      if (paramLong1 != 0L) {
        break label195;
      }
      localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong1 = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
      a += 1;
      dc.a(paramHandler, paramLong1, localQQUser.mRealUin, paramInt, a, paramString);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new fs("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
      a += 1;
      dc.a(paramHandler, s.f(paramLong2), paramLong2, paramInt, a, paramString);
      this.c.a(paramHandler);
      return 0;
      label195:
      localQQUser = null;
    }
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, Handler paramHandler)
  {
    long l;
    int i;
    label146:
    Object localObject2;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject1 = ax.a().e();
      l = paramLong2;
      if (0L == 0L)
      {
        if (localObject1 == null)
        {
          paramString1 = paramHandler.obtainMessage(3067);
          paramString2 = new d((byte)0);
          paramString2.a(110, null, null);
          paramString1.arg1 = paramString2.a;
          paramString1.obj = paramString2;
          paramString1.sendToTarget();
          return -1;
        }
        if (paramLong2 == ((QQUser)localObject1).mRealUin)
        {
          paramLong1 = ((QQUser)localObject1).mUin;
          l = ((QQUser)localObject1).mRealUin;
        }
      }
      else
      {
        i = a + 1;
        a = i;
        if (paramInt != 1) {
          break label1139;
        }
        paramHandler = new fs("mbtoken3_realname_reg", 3, paramHandler, 3067);
        paramHandler.m = 1;
        paramHandler.n = new ContentValues(3);
        localObject2 = paramHandler.n;
        ae.a();
        if (!ax.a().p()) {
          break label1187;
        }
        ax.a();
      }
    }
    label1187:
    for (Object localObject1 = ax.c;; localObject1 = null)
    {
      ((ContentValues)localObject2).put("aq_base_sid", (String)localObject1);
      paramHandler.n.put("uin", Long.valueOf(paramLong1));
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("real_uin", l);
        ((JSONObject)localObject1).put("realname", paramString1);
        ((JSONObject)localObject1).put("id_number", paramString2);
        ((JSONObject)localObject1).put("op_type", paramInt);
        e.a("doRealNameReg common_data=" + ((JSONObject)localObject1).toString());
        if (paramArrayOfByte1 != null)
        {
          localObject2 = b.a(paramArrayOfByte1);
          ((JSONObject)localObject1).put("face_data", localObject2);
          e.a("doRealNameReg face_data=" + ((String)localObject2).length());
        }
        if (paramArrayOfByte2 != null)
        {
          localObject2 = b.a(paramArrayOfByte2);
          ((JSONObject)localObject1).put("id_photo_front", localObject2);
          e.a("doRealNameReg front_data=" + ((String)localObject2).length());
        }
        if (paramArrayOfByte3 != null)
        {
          localObject2 = b.a(paramArrayOfByte3);
          ((JSONObject)localObject1).put("id_photo_back", localObject2);
          e.a("doRealNameReg back_data=" + ((String)localObject2).length());
        }
        if (paramArrayOfByte4 != null) {
          ((JSONObject)localObject1).put("id_photo_info_front", b.a(paramArrayOfByte4));
        }
        if (paramArrayOfByte5 != null) {
          ((JSONObject)localObject1).put("id_photo_info_back", b.a(paramArrayOfByte5));
        }
        ((JSONObject)localObject1).put("token_seq", ag.c().k());
        ((JSONObject)localObject1).put("guid", s.a(x.a(RqdApplication.i()).c()));
        ((JSONObject)localObject1).put("seq_id", i);
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
      localObject1 = b.a(s.c(((JSONObject)localObject1).toString().getBytes())).replace('+', '-').replace('=', '_');
      e.a("doRealNameReg data = " + ((String)localObject1).length());
      paramHandler.n.put("data", (String)localObject1);
      paramHandler.c.put("param.uinhash", Long.valueOf(paramLong1));
      paramHandler.c.put("param.realuin", Long.valueOf(l));
      paramHandler.c.put("param.realname", paramString1);
      paramHandler.c.put("param.idnumber", paramString2);
      paramHandler.c.put("param.optype", Integer.valueOf(paramInt));
      paramHandler.c.put("param.facedata", paramArrayOfByte1);
      paramHandler.c.put("param.frontdata", paramArrayOfByte2);
      paramHandler.c.put("param.backdata", paramArrayOfByte3);
      paramHandler.c.put("param.prontphotoinfo", paramArrayOfByte4);
      paramHandler.c.put("param.backphotoinfo", paramArrayOfByte5);
      paramHandler.j = i;
      this.c.a(paramHandler);
      return 0;
      paramLong1 = s.f(paramLong2);
      l = paramLong2;
      break;
      label1139:
      if (paramInt == 3)
      {
        paramHandler = new fs("mbtoken3_realname_reg", 3, paramHandler, 3078);
        break label146;
      }
      paramHandler = new fs("mbtoken3_realname_reg", 2, paramHandler, 3067);
      break label146;
    }
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Handler paramHandler)
  {
    Object localObject1 = null;
    if (paramLong2 != 0L) {
      localObject1 = ax.a().d(paramLong2);
    }
    if (localObject1 == null) {
      localObject1 = ax.a().e();
    }
    for (;;)
    {
      if (0L == 0L)
      {
        if (localObject1 == null)
        {
          paramArrayOfByte = paramHandler.obtainMessage(3058);
          paramHandler = new d((byte)0);
          paramHandler.a(110, null, null);
          paramArrayOfByte.arg1 = paramHandler.a;
          paramArrayOfByte.obj = paramHandler;
          paramArrayOfByte.sendToTarget();
          return -1;
        }
        paramLong1 = ((QQUser)localObject1).mUin;
      }
      for (;;)
      {
        long l;
        int j;
        label156:
        Object localObject2;
        if (paramLong2 != 0L)
        {
          l = s.f(paramLong2);
          j = a + 1;
          a = j;
          if ((paramInt3 != 2) && (paramInt3 != 6)) {
            break label1135;
          }
          paramHandler = new fs("mbtoken3_face_reg", 2, paramHandler, 3058);
          paramHandler.m = 1;
          paramHandler.n = new ContentValues(3);
          ContentValues localContentValues = paramHandler.n;
          ae.a();
          if (!ax.a().p()) {
            break label1156;
          }
          ax.a();
          localObject2 = ax.c;
          label204:
          localContentValues.put("aq_base_sid", (String)localObject2);
          paramHandler.n.put("uin", Long.valueOf(l));
          localObject2 = new JSONObject();
          if (paramInt1 == 2) {
            break label1162;
          }
        }
        for (;;)
        {
          try
          {
            ((JSONObject)localObject2).put("uin", ((QQUser)localObject1).mRealUin);
            ((JSONObject)localObject2).put("op_type", paramInt1);
            e.a("doFaceRecognition opType=" + paramInt1 + ",mRealUin=" + ((QQUser)localObject1).mRealUin + "," + "uin=" + paramLong2);
            paramLong1 = System.currentTimeMillis();
            if (paramInt1 == 3) {
              continue;
            }
            e.c("doFaceRecognition src data=" + paramArrayOfByte.length);
            localObject1 = b.a(paramArrayOfByte);
            ((JSONObject)localObject2).put("img_data", localObject1);
            e.c("doFaceRecognition img_data=" + ((String)localObject1).length());
            ((JSONObject)localObject2).put("resolution", cv.c);
            ((JSONObject)localObject2).put("so_code_time", cv.d);
            ((JSONObject)localObject2).put("face_detect_time", cv.e);
            ((JSONObject)localObject2).put("face_detect_frame", cv.g);
            if (!FaceDetector.IsSupportNeon()) {
              continue;
            }
            i = 1;
          }
          catch (Exception localException)
          {
            label1135:
            paramHandler.k = true;
            label1156:
            label1162:
            localException.printStackTrace();
            continue;
            int i = 0;
            continue;
            i = paramInt3;
            continue;
          }
          ((JSONObject)localObject2).put("is_neon", i);
          ((JSONObject)localObject2).put("face_model_init_time", cv.f);
          ((JSONObject)localObject2).put("vivo_model_init_time", cv.h);
          ((JSONObject)localObject2).put("vivo_reg_action1_time", cv.i);
          ((JSONObject)localObject2).put("vivo_reg_action2_time", cv.j);
          ((JSONObject)localObject2).put("vivo_reg_action1_frame", cv.k);
          ((JSONObject)localObject2).put("vivo_reg_action2_frame", cv.l);
          ((JSONObject)localObject2).put("vivo_ver_action_time", cv.m);
          ((JSONObject)localObject2).put("vivo_ver_action_frame", cv.n);
          ((JSONObject)localObject2).put("vivo_reg_action1_type", ei.c);
          ((JSONObject)localObject2).put("vivo_reg_action2_type", ei.d);
          ((JSONObject)localObject2).put("vivo_ver_action_type", ei.e);
          ((JSONObject)localObject2).put("mobile_os", "android:" + URLEncoder.encode(Build.VERSION.RELEASE));
          ((JSONObject)localObject2).put("algorithm", t.l());
          ((JSONObject)localObject2).put("op_time", (int)(ag.c().r() / 1000L));
          ((JSONObject)localObject2).put("seq_id", j);
          if (paramInt3 != 6) {
            continue;
          }
          i = 1;
          ((JSONObject)localObject2).put("scene", i);
          e.a("doFaceRecognition scene=" + paramInt3);
          if (paramInt1 == 5) {
            ((JSONObject)localObject2).put("token_seq", ag.c().k());
          }
          localObject1 = s.c(((JSONObject)localObject2).toString().getBytes());
          localObject2 = b.a((byte[])localObject1).replace('+', '-').replace('=', '_');
          i = (int)(System.currentTimeMillis() - paramLong1);
          e.c("encodeTime=" + i);
          paramHandler.n.put("data", (String)localObject2);
          paramHandler.n.put("encode_time", Integer.valueOf(i));
          e.a("resolution=" + cv.c + ",so_code_time=" + cv.d + ",scan_time=" + cv.e + ",frame_cnt=" + cv.g + ",encode_time=" + i + ",seq=" + j);
          e.a("doFaceRecognition data=" + localObject1.length);
          e.a("doFaceRecognition base64 data=" + ((String)localObject2).length());
          paramHandler.c.put("param.uinhash", Long.valueOf(l));
          paramHandler.j = j;
          e.c("reqdata.seq=" + j);
          paramHandler.c.put("param.realuin", Long.valueOf(paramLong2));
          paramHandler.c.put("param.optype", Integer.valueOf(paramInt1));
          paramHandler.c.put("param.facedata", paramArrayOfByte);
          paramHandler.c.put("param.lockstatus", Integer.valueOf(paramInt2));
          paramHandler.c.put("param.scene.id", Integer.valueOf(paramInt3));
          this.c.a(paramHandler);
          return 0;
          l = paramLong1;
          if (localObject1 == null) {
            break;
          }
          paramLong2 = ((QQUser)localObject1).mRealUin;
          l = paramLong1;
          break;
          paramHandler = new fs("mbtoken3_face_reg", 3, paramHandler, 3058);
          break label156;
          localObject2 = null;
          break label204;
          ((JSONObject)localObject2).put("uin", paramLong2);
          if (paramInt2 > 0) {
            ((JSONObject)localObject2).put("lock_status", paramInt2);
          }
        }
      }
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Handler paramHandler)
  {
    a += 1;
    paramHandler = new fs("mbtoken3_unbind_token", 3, paramHandler, 4001);
    int i = a;
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong2));
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramHandler.c.put("param.unbind.type", Integer.valueOf(1));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong1, long paramLong2, String paramString, Handler paramHandler)
  {
    long l2 = paramLong1;
    long l1 = paramLong2;
    if (0L == paramLong2)
    {
      QQUser localQQUser = ax.a().e();
      l2 = paramLong1;
      l1 = paramLong2;
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new d((byte)0);
          paramHandler.a(110, null, null);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        l1 = localQQUser.mRealUin;
        l2 = localQQUser.mUin;
      }
    }
    a += 1;
    paramHandler = new fs("mbtoken3_card_check", 3, paramHandler, 3080);
    int i = a;
    paramHandler.c.put("param.uinhash", Long.valueOf(l2));
    paramHandler.c.put("param.realuin", Long.valueOf(l1));
    paramHandler.c.put("param.idnumber", paramString);
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3000);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_get_ac_lock_status_v2", 3, paramHandler, 3000);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, Handler paramHandler, Activity paramActivity)
  {
    if (0L == 0L)
    {
      localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3048);
        paramActivity = new d((byte)0);
        paramActivity.a(110, null, null);
        paramHandler.arg1 = paramActivity.a;
        paramHandler.obj = paramActivity;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_query_jl_protection_info", 3, paramHandler, 3048);
    int i = paramActivity.getWindowManager().getDefaultDisplay().getWidth();
    int j = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    Object localObject = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int k = ((DisplayMetrics)localObject).densityDpi;
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.config.width", Integer.valueOf(i));
    paramHandler.c.put("param.config.height", Integer.valueOf(j));
    paramHandler.c.put("param.config.dpi", Integer.valueOf(k));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, Long paramLong1, int paramInt, Handler paramHandler)
  {
    if (paramLong1.longValue() == 0L)
    {
      if (0L != 0L) {
        break label192;
      }
      paramLong1 = ax.a().e();
      if (paramLong1 == null)
      {
        paramLong1 = paramHandler.obtainMessage(3065);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramLong1.arg1 = paramHandler.a;
        paramLong1.obj = paramHandler;
        paramLong1.sendToTarget();
        return -1;
      }
      paramLong = paramLong1.mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
      a += 1;
      db.a(paramHandler, paramLong, paramLong1.mRealUin, paramInt, a);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new fs("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
      a += 1;
      db.a(paramHandler, s.f(paramLong1.longValue()), paramLong1.longValue(), paramInt, a);
      this.c.a(paramHandler);
      return 0;
      label192:
      paramLong1 = null;
    }
  }
  
  public final int a(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3052);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_modify_pwd", 3, paramHandler, 3052);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.qqpwd", paramString);
    paramHandler.c.put("param.scene.id", Integer.valueOf(paramInt));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, String paramString, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3014);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_mbop_verify_mobile_code", 3, paramHandler, 3014);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbmobile.vrycode", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3055);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    int i = a + 1;
    a = i;
    paramHandler = new fs("mbtoken3_device_lock_del_device_v2", 3, paramHandler, 3055);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.device.lock.dguid", paramString1);
    paramHandler.c.put("param.device.lock.ddes", paramString2);
    paramHandler.c.put("param.device.lock.dappid", Integer.valueOf(paramInt1));
    paramHandler.c.put("param.device.lock.dsubappid", Integer.valueOf(paramInt2));
    paramHandler.c.put("param.device.lock.dappname", paramString3);
    paramHandler.c.put("param.device.lock.id", Integer.valueOf(paramInt3));
    paramHandler.c.put("param.device.lock.guid", paramString4);
    paramHandler.c.put("param.device.lock.appid", Integer.valueOf(523005419));
    paramHandler.c.put("param.device.lock.subappid", Integer.valueOf(1));
    paramHandler.c.put("param.device.lock.appname", paramString5);
    paramHandler.c.put("param.wtlogin.a2", paramString6);
    paramHandler.c.put("param.common.seq", Integer.valueOf(i));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3056);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_kickoff", 3, paramHandler, 3056);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.device.lock.dguid", paramString1);
    paramHandler.c.put("param.device.lock.ddes", paramString2);
    paramHandler.c.put("param.device.lock.dappid", Integer.valueOf(paramInt1));
    paramHandler.c.put("param.device.lock.dsubappid", Integer.valueOf(paramInt2));
    paramHandler.c.put("param.device.lock.dappname", paramString3);
    paramHandler.c.put("param.device.lock.guid", paramString4);
    paramHandler.c.put("param.device.lock.appid", Integer.valueOf(523005425));
    paramHandler.c.put("param.device.lock.subappid", Integer.valueOf(1));
    paramHandler.c.put("param.device.lock.appname", paramString5);
    paramHandler.c.put("param.skey", paramString6);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, List paramList, String[] paramArrayOfString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_vry_ques", 2, paramHandler, 3028);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.qqquestion", paramList);
    paramHandler.c.put("param.qqquestionanswer", paramArrayOfString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler)
  {
    int i = a + 1;
    a = i;
    paramHandler = new fs("mbtoken3_upgrade_determin_v3", 3, paramHandler, 3030);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramHandler.c.put("param.common.seq", Integer.valueOf(i));
    paramHandler.c.put("param.uin.wtlogin", Long.valueOf(paramLong));
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, int paramInt)
  {
    paramHandler = new fs("mbtoken3_vfy_wtlogin", 2, paramHandler, 3024);
    cu.a(paramHandler, paramLong + "", paramArrayOfByte, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = ax.a().e();
    if (0L == 0L)
    {
      if (localObject2 == null)
      {
        paramArrayOfByte = paramHandler.obtainMessage(3059);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramArrayOfByte.arg1 = paramHandler.a;
        paramArrayOfByte.obj = paramHandler;
        paramArrayOfByte.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject2).mUin;
    }
    int i = a + 1;
    a = i;
    localObject2 = new fs("mbtoken3_face_pk", 3, paramHandler, 3059);
    ((fs)localObject2).m = 1;
    ((fs)localObject2).n = new ContentValues(3);
    ContentValues localContentValues = ((fs)localObject2).n;
    ae.a();
    paramHandler = localObject1;
    if (ax.a().p())
    {
      ax.a();
      paramHandler = ax.c;
    }
    localContentValues.put("aq_base_sid", paramHandler);
    ((fs)localObject2).n.put("uin", Long.valueOf(paramLong));
    ((fs)localObject2).k = true;
    e.c("path:" + paramString);
    ((fs)localObject2).c.put("param.uinhash", Long.valueOf(paramLong));
    ((fs)localObject2).j = i;
    ((fs)localObject2).c.put("param.facedata", paramArrayOfByte);
    if (paramString != null) {
      ((fs)localObject2).c.put("param.videopath", paramString);
    }
    this.c.a((fs)localObject2);
    return 0;
  }
  
  public final int a(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramArrayOfInt1 = paramHandler.obtainMessage(3018);
        paramArrayOfInt2 = new d((byte)0);
        paramArrayOfInt2.a(110, null, null);
        paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
        paramArrayOfInt1.obj = paramArrayOfInt2;
        paramArrayOfInt1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_set_service_status", 3, paramHandler, 3018);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbinfo.id", paramArrayOfInt1);
    paramHandler.c.put("param.mbinfo.val", paramArrayOfInt2);
    paramHandler.c.put("param.skey", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_exchange_key_v3", 1, paramHandler, 4000);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(Handler paramHandler, int paramInt1, int paramInt2)
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {}
    for (long l = 0L;; l = localQQUser.mRealUin)
    {
      a += 1;
      paramHandler = new fs("mbtoken3_detector_report", 2, paramHandler, 0);
      int i = a;
      paramHandler.c.put("param.common.seq", Integer.valueOf(i));
      paramHandler.c.put("param.realuin", Long.valueOf(l));
      paramHandler.c.put("param.worm_type", Integer.valueOf(paramInt1));
      paramHandler.c.put("infected_cnt", Integer.valueOf(paramInt2));
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public final int a(Handler paramHandler, File paramFile, String paramString)
  {
    QQUser localQQUser = ax.a().e();
    fs localfs = new fs("mbtoken3_log_upload", 2, paramHandler, 3063);
    localfs.m = 2;
    localfs.o = paramFile;
    if (localQQUser == null)
    {
      localfs.p = ("0_" + paramString);
      localfs.n = new ContentValues(2);
      if (localQQUser != null) {
        break label224;
      }
      localfs.n.put("uin", s.b(String.valueOf(0).getBytes()));
      label106:
      paramString = localfs.n;
      ae.a();
      if (!ax.a().p()) {
        break label252;
      }
      ax.a();
    }
    label224:
    label252:
    for (paramHandler = ax.c;; paramHandler = null)
    {
      paramString.put("aq_base_sid", paramHandler);
      paramHandler = localfs.n;
      gb.a();
      paramHandler.put("log_date", Integer.valueOf(gb.g()));
      ey.a(paramFile.getAbsolutePath());
      this.c.a(localfs);
      return 0;
      localfs.p = ("" + localQQUser.mUin + "_" + paramString);
      break;
      localfs.n.put("uin", s.b(String.valueOf(localQQUser.mRealUin).getBytes()));
      break label106;
    }
  }
  
  public final int a(ConfigResult paramConfigResult, Handler paramHandler)
  {
    paramHandler = new fs("token.getstartupimg", 1, paramHandler, 3042);
    paramHandler.c.put("param.startup.img.result", paramConfigResult);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public final int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      l = localQQUser.mRealUin;
    }
    int i = a + 1;
    a = i;
    paramHandler = new fs("mbtoken3_get_sms_port_v2", 2, paramHandler, 3019);
    paramHandler.c.put("param.realuin", Long.valueOf(l));
    paramHandler.c.put("param.mbmobile.mobile", paramString1);
    paramHandler.c.put("param.mbmoible.ismobile", Integer.valueOf(paramInt1));
    paramHandler.c.put("param.scene.id", Integer.valueOf(paramInt2));
    paramHandler.c.put("param.mbmoible.areacode", paramString2);
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int a(String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_feedback_v2", 2, paramHandler, 3022);
    paramHandler.c.put("param.uinhash", Long.valueOf(0L));
    paramHandler.c.put("param.feedback.comment", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong, int paramInt, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    if (0L == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3006);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_get_message_v2", 3, paramHandler, 3006);
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
      du.a(paramHandler, paramLong, paramInt, 2, 0);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public final int b(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3013);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_mbop_get_mobile_code", 3, paramHandler, 3013);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbmobile.getcode", Integer.valueOf(paramInt));
    paramHandler.c.put("param.mbmobile.mobile", paramString1);
    paramHandler.c.put("param.mbmoible.areacode", paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3054);
        paramString2 = new d((byte)0);
        paramString2.a(110, null, null);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    int i = a + 1;
    a = i;
    paramHandler = new fs("mbtoken3_get_device_lock_status_v2", 3, paramHandler, 3054);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.device.lock.id", Integer.valueOf(paramInt));
    paramHandler.c.put("param.device.lock.guid", paramString1);
    paramHandler.c.put("param.device.lock.appid", Integer.valueOf(523005419));
    paramHandler.c.put("param.device.lock.subappid", Integer.valueOf(1));
    paramHandler.c.put("param.device.lock.appname", paramString2);
    paramHandler.c.put("param.wtlogin.a2", paramString3);
    paramHandler.c.put("param.common.seq", Integer.valueOf(i));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong1, long paramLong2, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3038);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong1 = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_feedback_abnormal_login", 3, paramHandler, 3038);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramHandler.c.put("param.feedback.msgid", Long.valueOf(paramLong2));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3002);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_get_game_lock_status_v2", 3, paramHandler, 3002);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong, String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_verify_qqtoken", 2, paramHandler, 3027);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.qqtoken", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Handler paramHandler)
  {
    if (0L == 0L)
    {
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        paramArrayOfInt1 = paramHandler.obtainMessage(3061);
        paramArrayOfInt2 = new d((byte)0);
        paramArrayOfInt2.a(110, null, null);
        paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
        paramArrayOfInt1.obj = paramArrayOfInt2;
        paramArrayOfInt1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    paramHandler = new fs("mbtoken3_set_service_status_v2", 3, paramHandler, 3061);
    a += 1;
    int i = a;
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbinfo.id", paramArrayOfInt1);
    paramHandler.c.put("param.mbinfo.val", paramArrayOfInt2);
    paramHandler.c.put("param.wtlogin.a2", paramString);
    paramHandler.c.put("param.common.seq", Integer.valueOf(i));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_get_uin_list_v2", 2, paramHandler, 3003);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int b(String paramString, Handler paramHandler)
  {
    paramHandler = new fs("token.getcommonimg", 1, paramHandler, 3050);
    paramHandler.c.put("param.common.img.url", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int c(long paramLong, int paramInt, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3011);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_del_mbitem", 3, paramHandler, 3011);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.mbinfo.id", Integer.valueOf(paramInt));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int c(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = new fs("mbtoken3_bind_token_by_app_v3", 2, paramHandler, 3026);
    paramString1.c.put("param.realuin", Long.valueOf(paramLong));
    paramString1.c.put("param.bind.type", Integer.valueOf(paramInt));
    paramString1.c.put("param.bind.mobile", str);
    paramString1.c.put("param.bind.areacode", paramString2);
    this.c.a(paramString1);
    return 0;
  }
  
  public final int c(long paramLong1, long paramLong2, Handler paramHandler)
  {
    long l = paramLong1;
    if (0L == paramLong2)
    {
      l = paramLong1;
      if (paramLong1 == 0L)
      {
        Object localObject = ax.a().e();
        if (localObject == null)
        {
          paramHandler = paramHandler.obtainMessage(3075);
          localObject = new d((byte)0);
          ((d)localObject).a(110, null, null);
          paramHandler.arg1 = ((d)localObject).a;
          paramHandler.obj = localObject;
          paramHandler.sendToTarget();
          return -1;
        }
        l = ((QQUser)localObject).mUin;
      }
    }
    paramHandler = new fs("mbtoken3_qry_spec_verify", 3, paramHandler, 3075);
    a += 1;
    int i = a;
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong2));
    paramHandler.c.put("param.scene_id", Integer.valueOf(1));
    paramHandler.c.put("param.op_time", Long.valueOf(ag.c().r() / 1000L));
    paramHandler.c.put("param.uinhash", Long.valueOf(l));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int c(long paramLong, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3001);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_get_safe_protection_v2", 3, paramHandler, 3001);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int c(long paramLong, String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_verify_mobile_code", 2, paramHandler, 3029);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.smscode", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int c(Handler paramHandler)
  {
    fs localfs = new fs("mbtoken3_get_key_value_conf", 2, paramHandler, 3023);
    Object localObject = bi.a(localfs.a);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bm)localObject).c())
    {
      if ((localObject == null) || (((ft)localObject).a == null)) {
        break label133;
      }
      try
      {
        NewConfigureCacheItem localNewConfigureCacheItem = ba.a().h.a("key_value");
        localObject = new JSONObject((String)((ft)localObject).a);
        if (((JSONObject)localObject).getInt("key_value_version") < localNewConfigureCacheItem.mClientVersion) {
          break label133;
        }
        localObject = ((JSONObject)localObject).getJSONObject("data");
        paramHandler = paramHandler.obtainMessage(3023);
        paramHandler.arg1 = 0;
        paramHandler.obj = ((JSONObject)localObject).toString();
        paramHandler.sendToTarget();
        return 0;
      }
      catch (JSONException paramHandler)
      {
        paramHandler.printStackTrace();
      }
    }
    label133:
    this.c.a(localfs);
    return 0;
  }
  
  public final int c(String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_query_malicious_url", 2, paramHandler, 3053);
    paramHandler.c.put("param.barcode.url", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int d(long paramLong, int paramInt, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3044);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_query_jl_role_list", 3, paramHandler, 3044);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.jl_worldid", Integer.valueOf(paramInt));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int d(long paramLong, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    if (0L == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3004);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_eval_account_v3", 3, paramHandler, 3004);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    e.c("account page ProtoGetEvalAccountResult packet params: user =" + paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int d(long paramLong, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = ax.a().e();
    if (0L == 0L)
    {
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3060);
        paramHandler = new d((byte)0);
        paramHandler.a(110, null, null);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    a += 1;
    paramHandler = new fs("mbtoken3_get_login_prot", 3, paramHandler, 3060);
    int i = a;
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.wtlogin.a2", paramString);
    paramHandler.c.put("param.common.seq", Integer.valueOf(i));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int d(Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_activate_token", 2, paramHandler, 3025);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int d(String paramString, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_report_dns", 2, paramHandler, 3041);
    paramHandler.c.put("param.reportdns.domain", paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int e(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new fs("mbtoken3_login_v2", 2, paramHandler, 10002);
    int i = a;
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.loginv2.clearkick", Integer.valueOf(paramInt));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int e(long paramLong, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_get_mbinfo", 3, paramHandler, 3010);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    paramHandler.c.put("param.uinhash", Long.valueOf(l));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int e(Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_qry_bind_notify_msg", 2, paramHandler, 3043);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int f(long paramLong, int paramInt, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_query_captcha", 2, paramHandler, 3071);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.scene.id", Integer.valueOf(paramInt));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int f(long paramLong, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_get_mobile_code_v2", 2, paramHandler, 3031);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int f(Handler paramHandler)
  {
    if ((0L == 0L) && (ax.a().e() == null))
    {
      paramHandler = paramHandler.obtainMessage(3049);
      d locald = new d((byte)0);
      locald.a(110, null, null);
      paramHandler.arg1 = locald.a;
      paramHandler.obj = locald;
      paramHandler.sendToTarget();
      return -1;
    }
    paramHandler = new fs("mbtoken3_query_jl_zone_list", 2, paramHandler, 3049);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int g(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new fs("mbtoken3_bind_token_by_realname", 2, paramHandler, 3074);
    int i = a;
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.c.put("param.type", Integer.valueOf(paramInt));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int g(long paramLong, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_query_real_uin_v2", 2, paramHandler, 1006);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int g(Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_get_domain", 2, paramHandler, 3062);
    long l = 0L;
    QQUser localQQUser = ax.a().e();
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    }
    paramHandler.c.put("param.realuin", Long.valueOf(l));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int h(long paramLong, int paramInt, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == -1L)
    {
      QQUser localQQUser = ax.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new fs("mbtoken3_live_video_detect", 2, paramHandler, 3082);
    ei.a(paramHandler, l, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int h(long paramLong, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_del_unvfy_uin", 2, paramHandler, 3036);
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int h(Handler paramHandler)
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {}
    for (long l = 0L;; l = localQQUser.mRealUin)
    {
      a += 1;
      paramHandler = new fs("mbtoken3_detector_info", 2, paramHandler, 3079);
      int i = a;
      paramHandler.c.put("param.common.seq", Integer.valueOf(i));
      paramHandler.c.put("param.realuin", Long.valueOf(l));
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public final int i(long paramLong, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3037);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_feedback_mobile_using", 2, paramHandler, 3037);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int j(long paramLong, Handler paramHandler)
  {
    if (0L == 0L)
    {
      Object localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3046);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    paramHandler = new fs("mbtoken3_query_jl_appeal_list", 3, paramHandler, 3046);
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int k(long paramLong, Handler paramHandler)
  {
    Object localObject = ax.a().e();
    if (0L == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3057);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    int i = a + 1;
    a = i;
    paramHandler = new fs("mbtoken3_security_reporter_v2", 3, paramHandler, 3057);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    paramHandler.c.put("param.type", Integer.valueOf(1));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int l(long paramLong, Handler paramHandler)
  {
    Object localObject;
    if (0L == 0L)
    {
      localObject = ax.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3064);
        localObject = new d((byte)0);
        ((d)localObject).a(110, null, null);
        paramHandler.arg1 = ((d)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new fs("mbtoken3_realname_status_v2", 3, paramHandler, 3064);
      a += 1;
      long l = ((QQUser)localObject).mRealUin;
      int i = a;
      paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
      paramHandler.c.put("param.realuin", Long.valueOf(l));
      paramHandler.j = i;
      this.c.a(paramHandler);
      return 0;
      localObject = null;
    }
  }
  
  public final int m(long paramLong, Handler paramHandler)
  {
    paramHandler = new fs("mbtoken3_realname_qry", 2, paramHandler, 3073);
    a += 1;
    int i = a;
    paramHandler.c.put("param.realuin", Long.valueOf(paramLong));
    paramHandler.j = i;
    this.c.a(paramHandler);
    return 0;
  }
  
  public final int n(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (-1L == -1L)
    {
      QQUser localQQUser = ax.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new fs("mbtoken3_auto_idcard_detect", 2, paramHandler, 3083);
    ca.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.af
 * JD-Core Version:    0.7.0.1
 */