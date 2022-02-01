package com.tencent.token;

import android.content.ContentValues;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.jni.FaceDetector;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.protocolcenter.ProtoSetServiceStatusV2;
import com.tencent.token.core.protocolcenter.a;
import com.tencent.token.core.protocolcenter.protocol.ProtoAutoIDCardDetect;
import com.tencent.token.core.protocolcenter.protocol.ProtoCheckUpSMS;
import com.tencent.token.core.protocolcenter.protocol.ProtoCopyFace;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelDevice;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelMbInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelUnverifyUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByRealName;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByUniverify;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoGeneralBindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoLoginV2;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoSendFeedback;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoSendSmscode;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoUnbindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyOriginalMobile;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyQQToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyQuestion;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifySmscode;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceVryOnOff;
import com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackAbnormalLogin;
import com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackMobileUsing;
import com.tencent.token.core.protocolcenter.protocol.ProtoFreezeUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralVryMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetAccountLockStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetConfig;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDeterminVerifyFactors;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDeviceLock;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDomain;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDualMsgList;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetEvalAccountResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetGameLockStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetLoginProtect;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMbInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMbMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMessage;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetRealUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSafeProtection;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetStartUpImg;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetStrConfig;
import com.tencent.token.core.protocolcenter.protocol.ProtoKickOff;
import com.tencent.token.core.protocolcenter.protocol.ProtoLiveFaceDetect;
import com.tencent.token.core.protocolcenter.protocol.ProtoModifyQQPwd;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryCaptcha;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryFreezeStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryMaliciousURL;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryRealName;
import com.tencent.token.core.protocolcenter.protocol.ProtoQuerySpecialVerify;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameCardCheck;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameReg;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportDnsInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportLocation;
import com.tencent.token.core.protocolcenter.protocol.ProtoSetMbMobile;
import com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryCaptcha;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryMbMobileCode;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import com.tmsdk.common.util.TmsLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ca
  implements a
{
  public static int a = new Random().nextInt() >>> 1;
  private static ca b;
  private com.tencent.token.core.protocolcenter.e c = new com.tencent.token.core.protocolcenter.e();
  
  public static ca a()
  {
    if (b == null) {
      b = new ca();
    }
    return b;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_get_config_v2", 2, paramHandler, 3041);
    ProtoGetConfig.a(paramHandler, paramInt1, paramInt2, paramInt3);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte paramByte, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_get_dual_msg_list_v2", 2, paramHandler, 3069);
    ProtoGetDualMsgList.a(paramHandler, paramLong, paramByte);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem, Handler paramHandler)
  {
    QQUser localQQUser = cq.a().e();
    if (paramLong == 0L)
    {
      if (localQQUser == null)
      {
        paramSafeMsgItem = paramHandler.obtainMessage(3032);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramSafeMsgItem.arg1 = paramHandler.a;
        paramSafeMsgItem.obj = paramHandler;
        paramSafeMsgItem.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_report_location", 3, paramHandler, 3032);
      if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
        paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
      }
      ProtoReportLocation.a(paramHandler, paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Handler paramHandler)
  {
    Object localObject = cq.a().e();
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3005);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_get_message_v2", 3, paramHandler, 3005);
      if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
        paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
      }
      ProtoGetMessage.a(paramHandler, paramLong, paramInt1, 1, paramInt2, 40);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3, Handler paramHandler)
  {
    QQUser localQQUser = cq.a().e();
    if (paramLong == 0L)
    {
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3005);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_get_message_v2", 3, paramHandler, 3005);
      if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
        paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
      }
      ProtoGetMessage.a(paramHandler, paramLong, paramInt1, 1, paramInt2, 40, paramString1, paramInt3, paramInt4, paramString2, paramString3);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt, Handler paramHandler)
  {
    Object localObject = cq.a().e();
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3006);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_get_message_v2", 3, paramHandler, 3006);
      if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
        paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
      }
      ProtoGetMessage.a(paramHandler, paramLong, paramInt, 2, 0, 40);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3054);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      a += 1;
      int i = a;
      paramHandler = new dn("mbtoken3_get_device_lock_status_v2", 3, paramHandler, 3054);
      ProtoGetDeviceLock.a(paramHandler, paramLong, paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3, i);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3013);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_mbop_get_mobile_code", 3, paramHandler, 3013);
      ProtoGetMbMobileCode.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3012);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_set_mod_mobile", 3, paramHandler, 3012);
      ProtoSetMbMobile.a(paramHandler, paramLong, paramInt, paramString1, paramString2, paramString3);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = cq.a().e();
    if (paramLong == 0L)
    {
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3004);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_face_verify_on_off", 3, paramHandler, 4002);
      int i = a + 1;
      a = i;
      ProtoFaceVryOnOff.a(paramHandler, paramLong, paramInt, i, paramBoolean, paramString);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Handler paramHandler)
  {
    Object localObject;
    if (paramLong2 == 0L)
    {
      localObject = null;
      if (paramLong1 != 0L) {
        break label193;
      }
      localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3068);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong1 = ((QQUser)localObject).mUin;
    }
    label193:
    for (;;)
    {
      paramHandler = new dn("mbtoken3_check_up_sms", 2, paramHandler, 3068);
      a += 1;
      ProtoCheckUpSMS.a(paramHandler, paramLong1, ((QQUser)localObject).mRealUin, paramInt1, a, paramInt2);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new dn("mbtoken3_check_up_sms", 2, paramHandler, 3068);
      a += 1;
      ProtoCheckUpSMS.a(paramHandler, l.f(paramLong2), paramLong2, paramInt1, a, paramInt2);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dn("mbtoken3_unbind_token", 3, paramHandler, 4001);
    ProtoDoUnbindToken.a(paramHandler, paramLong1, paramLong2, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, Handler paramHandler)
  {
    QQUser localQQUser;
    if (paramLong2 == 0L)
    {
      localQQUser = null;
      if (paramLong1 != 0L) {
        break label197;
      }
      localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3066);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      paramLong1 = localQQUser.mUin;
    }
    label197:
    for (;;)
    {
      paramHandler = new dn("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
      a += 1;
      ProtoGeneralVryMobileCode.a(paramHandler, paramLong1, localQQUser.mRealUin, paramInt1, a, paramString, paramInt2);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new dn("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
      a += 1;
      ProtoGeneralVryMobileCode.a(paramHandler, l.f(paramLong2), paramLong2, paramInt1, a, paramString, paramInt2);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, Handler paramHandler)
  {
    Object localObject;
    long l1;
    long l2;
    int i;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = cq.a().e();
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 == 0L)
      {
        if (localObject == null)
        {
          paramString1 = paramHandler.obtainMessage(3067);
          paramString2 = new com.tencent.token.global.e();
          paramString2.b(110);
          paramString1.arg1 = paramString2.a;
          paramString1.obj = paramString2;
          paramString1.sendToTarget();
          return -1;
        }
        if (paramLong2 != ((QQUser)localObject).mRealUin)
        {
          l1 = l.f(paramLong2);
          l2 = paramLong2;
        }
      }
      else
      {
        a += 1;
        i = a;
        if (paramInt != 1) {
          break label995;
        }
        paramHandler = new dn("mbtoken3_realname_reg_v2", 3, paramHandler, 3067);
      }
    }
    for (;;)
    {
      paramHandler.m = 1;
      paramHandler.n = new ContentValues(3);
      paramHandler.n.put("aq_base_sid", bz.a().b());
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("real_uin", l2);
        ((JSONObject)localObject).put("uin", l1);
        ((JSONObject)localObject).put("realname", paramString1);
        ((JSONObject)localObject).put("id_number", paramString2);
        ((JSONObject)localObject).put("op_type", paramInt);
        g.a("doRealNameReg common_data=" + ((JSONObject)localObject).toString());
        if (paramArrayOfByte1 != null)
        {
          str = b.a(paramArrayOfByte1);
          ((JSONObject)localObject).put("face_data", str);
          g.a("doRealNameReg face_data=" + str.length());
        }
        if (paramArrayOfByte2 != null)
        {
          str = b.a(paramArrayOfByte2);
          ((JSONObject)localObject).put("id_photo_front", str);
          g.a("doRealNameReg front_data=" + str.length());
        }
        if (paramArrayOfByte3 != null)
        {
          str = b.a(paramArrayOfByte3);
          ((JSONObject)localObject).put("id_photo_back", str);
          g.a("doRealNameReg back_data=" + str.length());
        }
        if (paramArrayOfByte4 != null) {
          ((JSONObject)localObject).put("id_photo_info_front", b.a(paramArrayOfByte4));
        }
        if (paramArrayOfByte5 != null) {
          ((JSONObject)localObject).put("id_photo_info_back", b.a(paramArrayOfByte5));
        }
        ((JSONObject)localObject).put("token_seq", cb.c().k());
        ((JSONObject)localObject).put("guid", l.a(by.a(RqdApplication.l()).b()));
        ((JSONObject)localObject).put("seq_id", i);
        ((JSONObject)localObject).put("op_time", (int)(cb.c().s() / 1000L));
        ((JSONObject)localObject).put("vendor_id", Build.MANUFACTURER);
        ((JSONObject)localObject).put("android_id", l.a(RqdApplication.l()));
        ((JSONObject)localObject).put("imei", l.b(RqdApplication.l()));
        ((JSONObject)localObject).put("mac", l.c(RqdApplication.l()));
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
        ((JSONObject)localObject).put("id_photo_front_time", com.tencent.token.ui.e.b);
        ((JSONObject)localObject).put("id_photo_front_frame", com.tencent.token.ui.e.a);
        ((JSONObject)localObject).put("id_photo_back_time", com.tencent.token.ui.e.d);
        ((JSONObject)localObject).put("id_photo_back_frame", com.tencent.token.ui.e.c);
        String str = l.e(RqdApplication.l());
        if (!TextUtils.isEmpty(str)) {
          ((JSONObject)localObject).put("route_name", str);
        }
        str = l.d(RqdApplication.l());
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
      localObject = b.a(l.c(((JSONObject)localObject).toString().getBytes())).replace('+', '-').replace('=', '_');
      g.a("doRealNameReg data = " + ((String)localObject).length());
      paramHandler.n.put("data", (String)localObject);
      ProtoRealNameReg.a(paramHandler, l1, i, l2, paramString1, paramString2, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5);
      this.c.a(paramHandler);
      return 0;
      l1 = ((QQUser)localObject).mUin;
      l2 = ((QQUser)localObject).mRealUin;
      break;
      l1 = l.f(paramLong2);
      l2 = paramLong2;
      break;
      label995:
      if (paramInt == 3) {
        paramHandler = new dn("mbtoken3_realname_reg_v2", 3, paramHandler, 3078);
      } else {
        paramHandler = new dn("mbtoken3_realname_reg_v2", 2, paramHandler, 3067);
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, Handler paramHandler)
  {
    Object localObject1 = null;
    if (paramLong2 != 0L) {
      localObject1 = cq.a().d(paramLong2);
    }
    if (localObject1 == null) {
      localObject1 = cq.a().e();
    }
    for (;;)
    {
      if (paramLong1 == 0L)
      {
        if (localObject1 == null)
        {
          paramArrayOfByte = paramHandler.obtainMessage(3058);
          paramHandler = new com.tencent.token.global.e();
          paramHandler.b(110);
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
        if (paramLong2 != 0L)
        {
          l = l.f(paramLong2);
          paramLong1 = paramLong2;
          paramLong2 = l;
        }
        for (;;)
        {
          a += 1;
          int j = a;
          label165:
          Object localObject2;
          if ((paramInt3 == 2) || (paramInt3 == 10) || (paramInt3 == 1))
          {
            paramHandler = new dn("mbtoken3_face_reg_v2", 2, paramHandler, 3058);
            paramHandler.m = 1;
            paramHandler.n = new ContentValues(3);
            paramHandler.n.put("aq_base_sid", bz.a().b());
            localObject2 = new JSONObject();
            if (paramInt1 == 2) {
              break label1019;
            }
          }
          for (;;)
          {
            try
            {
              ((JSONObject)localObject2).put("uin", ((QQUser)localObject1).mRealUin);
              ((JSONObject)localObject2).put("op_type", paramInt1);
              g.a("doFaceRecognition opType=" + paramInt1 + ",mRealUin=" + ((QQUser)localObject1).mRealUin + ",uin=" + paramLong1);
              l = System.currentTimeMillis();
              if (paramInt1 == 3) {
                continue;
              }
              g.c("doFaceRecognition src data=" + paramArrayOfByte.length);
              localObject1 = b.a(paramArrayOfByte);
              ((JSONObject)localObject2).put("img_data", localObject1);
              g.c("doFaceRecognition img_data=" + ((String)localObject1).length());
              ((JSONObject)localObject2).put("resolution", ProtoFaceCommon.d);
              ((JSONObject)localObject2).put("so_code_time", ProtoFaceCommon.e);
              ((JSONObject)localObject2).put("face_detect_time", ProtoFaceCommon.f);
              ((JSONObject)localObject2).put("face_detect_frame", ProtoFaceCommon.h);
              if (!FaceDetector.IsSupportNeon()) {
                continue;
              }
              i = 1;
            }
            catch (Exception localException)
            {
              label1019:
              paramHandler.k = true;
              localException.printStackTrace();
              continue;
              int i = 0;
              continue;
              i = paramInt3;
              continue;
              l = paramLong2;
              paramLong2 = paramLong1;
              paramLong1 = l;
            }
            ((JSONObject)localObject2).put("is_neon", i);
            ((JSONObject)localObject2).put("face_model_init_time", ProtoFaceCommon.g);
            ((JSONObject)localObject2).put("vivo_model_init_time", ProtoFaceCommon.i);
            ((JSONObject)localObject2).put("vivo_reg_action1_time", ProtoFaceCommon.j);
            ((JSONObject)localObject2).put("vivo_reg_action2_time", ProtoFaceCommon.k);
            ((JSONObject)localObject2).put("vivo_reg_action1_frame", ProtoFaceCommon.l);
            ((JSONObject)localObject2).put("vivo_reg_action2_frame", ProtoFaceCommon.m);
            ((JSONObject)localObject2).put("vivo_ver_action_time", ProtoFaceCommon.n);
            ((JSONObject)localObject2).put("vivo_ver_action_frame", ProtoFaceCommon.o);
            ((JSONObject)localObject2).put("vivo_reg_action1_type", ProtoLiveFaceDetect.d);
            ((JSONObject)localObject2).put("vivo_reg_action2_type", ProtoLiveFaceDetect.e);
            ((JSONObject)localObject2).put("vivo_ver_action_type", ProtoLiveFaceDetect.f);
            ((JSONObject)localObject2).put("mobile_os", "android:" + URLEncoder.encode(Build.VERSION.RELEASE));
            ((JSONObject)localObject2).put("algorithm", m.i());
            ((JSONObject)localObject2).put("op_time", (int)(cb.c().s() / 1000L));
            ((JSONObject)localObject2).put("seq_id", j);
            ((JSONObject)localObject2).put("highlighted", paramInt4);
            if (paramInt3 != 10) {
              continue;
            }
            i = 1;
            ((JSONObject)localObject2).put("scene", i);
            g.a("doFaceRecognition scene=" + paramInt3);
            i = (int)(System.currentTimeMillis() - l);
            g.c("encodeTime=" + i);
            ((JSONObject)localObject2).put("encode_time", i);
            if (paramInt1 == 5) {
              ((JSONObject)localObject2).put("token_seq", cb.c().k());
            }
            localObject1 = l.c(((JSONObject)localObject2).toString().getBytes());
            localObject2 = b.a((byte[])localObject1).replace('+', '-').replace('=', '_');
            paramHandler.n.put("data", (String)localObject2);
            g.a("resolution=" + ProtoFaceCommon.d + ",so_code_time=" + ProtoFaceCommon.e + ",scan_time=" + ProtoFaceCommon.f + ",frame_cnt=" + ProtoFaceCommon.h + ",encode_time=" + i + ",seq=" + j);
            g.a("doFaceRecognition data=" + localObject1.length);
            g.a("doFaceRecognition base64 data=" + ((String)localObject2).length());
            ProtoFaceCommon.a(paramHandler, paramLong2, j, paramLong1, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
            this.c.a(paramHandler);
            return 0;
            if (localObject1 == null) {
              continue;
            }
            l = ((QQUser)localObject1).mRealUin;
            paramLong2 = paramLong1;
            paramLong1 = l;
            break;
            paramHandler = new dn("mbtoken3_face_reg_v2", 3, paramHandler, 3058);
            break label165;
            ((JSONObject)localObject2).put("uin", paramLong1);
            if (paramInt2 > 0) {
              ((JSONObject)localObject2).put("lock_status", paramInt2);
            }
          }
        }
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, Handler paramHandler)
  {
    long l = paramLong1;
    if (paramLong1 == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3038);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_feedback_abnormal_login", 3, paramHandler, 3038);
    ProtoFeedbackAbnormalLogin.a(paramHandler, l, paramLong2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, String paramString, Handler paramHandler, boolean paramBoolean)
  {
    long l;
    if (0L == paramLong2)
    {
      QQUser localQQUser = cq.a().e();
      if (paramLong1 == 0L)
      {
        if (localQQUser == null)
        {
          paramString = paramHandler.obtainMessage(3080);
          paramHandler = new com.tencent.token.global.e();
          paramHandler.b(110);
          paramString.arg1 = paramHandler.a;
          paramString.obj = paramHandler;
          paramString.sendToTarget();
          return -1;
        }
        paramLong1 = localQQUser.mRealUin;
        paramLong2 = localQQUser.mUin;
        l = paramLong1;
        paramLong1 = paramLong2;
      }
    }
    for (;;)
    {
      a += 1;
      if (paramBoolean) {}
      for (paramHandler = new dn("mbtoken3_card_check", 3, paramHandler, 3080);; paramHandler = new dn("mbtoken3_card_check", 2, paramHandler, 3080))
      {
        ProtoRealNameCardCheck.a(paramHandler, paramLong1, l, a, paramString);
        this.c.a(paramHandler);
        return 0;
      }
      l = paramLong2;
    }
  }
  
  public int a(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3000);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_get_ac_lock_status_v2", 3, paramHandler, 3000);
    ProtoGetAccountLockStatus.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, Long paramLong1, int paramInt, Handler paramHandler)
  {
    if (paramLong1.longValue() == 0L)
    {
      paramLong1 = null;
      if (paramLong != 0L) {
        break label191;
      }
      paramLong1 = cq.a().e();
      if (paramLong1 == null)
      {
        paramLong1 = paramHandler.obtainMessage(3065);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramLong1.arg1 = paramHandler.a;
        paramLong1.obj = paramHandler;
        paramLong1.sendToTarget();
        return -1;
      }
      paramLong = paramLong1.mUin;
    }
    label191:
    for (;;)
    {
      paramHandler = new dn("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
      a += 1;
      ProtoGeneralGetMobileCode.a(paramHandler, paramLong, paramLong1.mRealUin, paramInt, a);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new dn("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
      a += 1;
      ProtoGeneralGetMobileCode.a(paramHandler, l.f(paramLong1.longValue()), paramLong1.longValue(), paramInt, a);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_verify_qqtoken_v2", 2, paramHandler, 3027);
    ProtoDoVerifyQQToken.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3014);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      l = localQQUser.mUin;
    }
    paramHandler = new dn("mbtoken3_mbop_verify_mobile_code", 3, paramHandler, 3014);
    ProtoVryMbMobileCode.a(paramHandler, l, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3055);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      a += 1;
      int i = a;
      paramHandler = new dn("mbtoken3_device_lock_del_device_v2", 3, paramHandler, 3055);
      ProtoDelDevice.a(paramHandler, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, paramInt4, paramInt5, paramString5, paramString6, i);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3056);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_kickoff_v2", 3, paramHandler, 3056);
      ProtoKickOff.a(paramHandler, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramString5, paramString6);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_vry_ques_v2", 2, paramHandler, 3028);
    ProtoDoVerifyQuestion.a(paramHandler, paramLong, paramList, paramArrayOfString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, int paramInt)
  {
    paramHandler = new dn("mbtoken3_vfy_wtlogin", 2, paramHandler, 3024);
    ProtoDoWtLogin.a(paramHandler, paramLong + "", paramArrayOfByte, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, int paramInt1, int paramInt2)
  {
    a += 1;
    int i = a;
    if (1 == paramInt2)
    {
      paramHandler = new dn("mbtoken3_determine_verify_factors", 3, paramHandler, 4003);
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(paramLong));
      paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    }
    for (;;)
    {
      ProtoGetDeterminVerifyFactors.a(paramHandler, paramLong, paramArrayOfByte, i, paramInt1, paramInt2);
      this.c.a(paramHandler);
      return 0;
      paramHandler = new dn("mbtoken3_determine_verify_factors", 2, paramHandler, 4003);
    }
  }
  
  public int a(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramArrayOfInt1 = paramHandler.obtainMessage(3061);
        paramArrayOfInt2 = new com.tencent.token.global.e();
        paramArrayOfInt2.b(110);
        paramArrayOfInt1.arg1 = paramArrayOfInt2.a;
        paramArrayOfInt1.obj = paramArrayOfInt2;
        paramArrayOfInt1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_set_service_status_v2", 3, paramHandler, 3061);
      a += 1;
      ProtoSetServiceStatusV2.a(paramHandler, paramLong, paramArrayOfInt1, paramArrayOfInt2, paramString, a);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_exchange_key_v3", 1, paramHandler, 4000);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(Handler paramHandler, File paramFile, String paramString)
  {
    QQUser localQQUser = cq.a().e();
    paramHandler = new dn("mbtoken3_log_upload", 2, paramHandler, 3063);
    paramHandler.m = 2;
    paramHandler.o = paramFile;
    if (localQQUser == null)
    {
      paramHandler.p = ("0_" + paramString);
      paramHandler.n = new ContentValues(2);
      if (localQQUser != null) {
        break label193;
      }
      paramHandler.n.put("uin", l.b(String.valueOf(0).getBytes()));
    }
    for (;;)
    {
      paramHandler.n.put("aq_base_sid", bz.a().b());
      paramHandler.n.put("log_date", Integer.valueOf(dw.a().j()));
      ProtoUploadLogFile.a(paramHandler, paramFile.getAbsolutePath());
      this.c.a(paramHandler);
      return 0;
      paramHandler.p = ("" + localQQUser.mUin + "_" + paramString);
      break;
      label193:
      paramHandler.n.put("uin", l.b(String.valueOf(localQQUser.b()).getBytes()));
    }
  }
  
  public int a(ConfigResult paramConfigResult, Handler paramHandler)
  {
    paramHandler = new dn("token.getstartupimg", 1, paramHandler, 3042);
    ProtoGetStartUpImg.a(paramHandler, paramConfigResult);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public int a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString1 = paramHandler.obtainMessage(3019);
        paramString2 = new com.tencent.token.global.e();
        paramString2.b(110);
        paramString1.arg1 = paramString2.a;
        paramString1.obj = paramString2;
        paramString1.sendToTarget();
        return -1;
      }
      paramLong = localQQUser.mRealUin;
    }
    for (;;)
    {
      a += 1;
      int i = a;
      paramHandler = new dn("mbtoken3_get_sms_port_v2", 2, paramHandler, 3019);
      ProtoGetSMSChannel.a(paramHandler, paramLong, paramString1, paramInt1, paramInt2, paramString2, i);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int a(String paramString, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_query_malicious_url", 2, paramHandler, 3053);
    ProtoQueryMaliciousURL.a(paramHandler, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_report_dns_v2", 2, paramHandler, 4013);
    ProtoReportDnsInfo.a(paramHandler, paramJSONArray);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b()
  {
    return a;
  }
  
  public int b(long paramLong, int paramInt, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3011);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_del_mbitem", 3, paramHandler, 3011);
    ProtoDelMbInfo.a(paramHandler, l, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_general_bind", 2, paramHandler, 4004);
      ProtoDoGeneralBindToken.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int b(long paramLong1, long paramLong2, int paramInt, Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong1 = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_qry_spec_verify", 3, paramHandler, 3075);
      a += 1;
      ProtoQuerySpecialVerify.a(paramHandler, paramLong1, paramLong2, paramInt, a);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int b(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3002);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_get_game_lock_status_v2", 3, paramHandler, 3002);
    ProtoGetGameLockStatus.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_verify_original_mobile", 2, paramHandler, 3085);
    ProtoDoVerifyOriginalMobile.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, String paramString, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_feedback_v2", 2, paramHandler, 3022);
    ProtoDoSendFeedback.a(paramHandler, paramLong, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_get_uin_list_v2", 2, paramHandler, 3003);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dn("mbtoken3_login_v2", 2, paramHandler, 10002);
    ProtoDoLoginV2.a(paramHandler, paramLong, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_bind_token_by_app_v3", 2, paramHandler, 3026);
      ProtoDoBindToken.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int c(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3001);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_get_safe_protection_v2", 3, paramHandler, 3001);
    ProtoGetSafeProtection.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_verify_mobile_code_v2", 2, paramHandler, 3029);
    ProtoDoVerifySmscode.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = cq.a().e();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3060);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      l = localQQUser.mUin;
    }
    a += 1;
    paramHandler = new dn("mbtoken3_get_login_prot", 3, paramHandler, 3060);
    ProtoGetLoginProtect.a(paramHandler, l, paramString, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(Handler paramHandler)
  {
    dn localdn = new dn("mbtoken3_get_key_value_conf", 2, paramHandler, 3023);
    Object localObject2 = this.c.b(localdn);
    if ((localObject2 != null) && (((do)localObject2).a != null)) {
      try
      {
        Object localObject1 = cr.a().h.a("key_value");
        localObject2 = new JSONObject((String)((do)localObject2).a);
        if (((JSONObject)localObject2).getInt("key_value_version") >= ((NewConfigureCacheItem)localObject1).mClientVersion)
        {
          localObject1 = ((JSONObject)localObject2).getJSONObject("data");
          paramHandler = paramHandler.obtainMessage(3023);
          paramHandler.arg1 = 0;
          paramHandler.obj = ((JSONObject)localObject1).toString();
          paramHandler.sendToTarget();
          return 0;
        }
      }
      catch (JSONException paramHandler)
      {
        paramHandler.printStackTrace();
      }
    }
    ProtoGetStrConfig.e(localdn);
    this.c.a(localdn);
    return 0;
  }
  
  public int d(long paramLong, int paramInt, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_query_captcha", 2, paramHandler, 3071);
    ProtoQueryCaptcha.a(paramHandler, paramLong, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_verify_captcha_v3", 2, paramHandler, 3072);
    ProtoVryCaptcha.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, Handler paramHandler)
  {
    Object localObject = cq.a().e();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3004);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_eval_account_v3", 3, paramHandler, 3004);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoGetEvalAccountResult.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      QQUser localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(3052);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      l = localQQUser.mUin;
    }
    paramHandler = new dn("mbtoken3_modify_pwd", 3, paramHandler, 3052);
    ProtoModifyQQPwd.a(paramHandler, l, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, String paramString, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dn("mbtoken3_bind_token_by_univerify", 2, paramHandler, 4015);
    ProtoDoBindTokenByUniverify.a(paramHandler, paramLong, paramString, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_activate_token", 2, paramHandler, 3025);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dn("mbtoken3_bind_token_by_realname", 2, paramHandler, 3074);
    ProtoDoBindTokenByRealName.a(paramHandler, paramLong, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, Handler paramHandler)
  {
    Object localObject = cq.a().e();
    long l = paramLong;
    if (paramLong == 0L)
    {
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3010);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_get_mbinfo", 3, paramHandler, 3010);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoGetMbInfo.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser = null;
    long l = paramLong;
    if (paramLong == 0L)
    {
      localQQUser = cq.a().e();
      if (localQQUser == null)
      {
        paramString = paramHandler.obtainMessage(4008);
        paramHandler = new com.tencent.token.global.e();
        paramHandler.b(110);
        paramString.arg1 = paramHandler.a;
        paramString.obj = paramHandler;
        paramString.sendToTarget();
        return -1;
      }
      l = localQQUser.mUin;
    }
    paramHandler = new dn("mbtoken3_freeze_action", 3, paramHandler, 4008);
    if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
    }
    ProtoFreezeUin.a(paramHandler, l, paramInt, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(Handler paramHandler)
  {
    if (cb.c().g())
    {
      TmsLog.i("mod_seed", "auto mod failed, no initcode.");
      return -1;
    }
    paramHandler = new dn("mbtoken3_mod_seed", 2, paramHandler, 4016);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int f(long paramLong, int paramInt, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == -1L)
    {
      QQUser localQQUser = cq.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new dn("mbtoken3_live_video_detect", 2, paramHandler, 3082);
    ProtoLiveFaceDetect.a(paramHandler, l, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int f(long paramLong, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_get_mobile_code_v2", 2, paramHandler, 3031);
    ProtoDoSendSmscode.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int f(Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_qry_bind_notify_msg", 2, paramHandler, 3043);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int g(long paramLong, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_query_real_uin_v2", 2, paramHandler, 1006);
    ProtoGetRealUin.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int g(Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_get_domain", 2, paramHandler, 3062);
    long l = 0L;
    QQUser localQQUser = cq.a().e();
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    }
    ProtoGetDomain.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int h(long paramLong, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_del_unvfy_uin", 2, paramHandler, 3036);
    ProtoDelUnverifyUin.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int i(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3037);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_feedback_mobile_using", 2, paramHandler, 3037);
    ProtoFeedbackMobileUsing.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int j(long paramLong, Handler paramHandler)
  {
    Object localObject = null;
    if (paramLong == 0L)
    {
      localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3064);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      paramLong = ((QQUser)localObject).mUin;
    }
    for (;;)
    {
      paramHandler = new dn("mbtoken3_realname_status_v2", 3, paramHandler, 3064);
      a += 1;
      ProtoGetRealNameStatus.a(paramHandler, paramLong, ((QQUser)localObject).mRealUin, a);
      this.c.a(paramHandler);
      return 0;
    }
  }
  
  public int k(long paramLong, Handler paramHandler)
  {
    paramHandler = new dn("mbtoken3_realname_qry", 2, paramHandler, 3073);
    a += 1;
    ProtoQueryRealName.a(paramHandler, paramLong, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int l(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == -1L)
    {
      QQUser localQQUser = cq.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new dn("mbtoken3_auto_idcard_detect", 2, paramHandler, 3083);
    ProtoAutoIDCardDetect.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int m(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(3075);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_copy_face", 3, paramHandler, 3084);
    ProtoCopyFace.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int n(long paramLong, Handler paramHandler)
  {
    Object localObject = null;
    long l = paramLong;
    if (paramLong == 0L)
    {
      localObject = cq.a().e();
      if (localObject == null)
      {
        paramHandler = paramHandler.obtainMessage(4007);
        localObject = new com.tencent.token.global.e();
        ((com.tencent.token.global.e)localObject).b(110);
        paramHandler.arg1 = ((com.tencent.token.global.e)localObject).a;
        paramHandler.obj = localObject;
        paramHandler.sendToTarget();
        return -1;
      }
      l = ((QQUser)localObject).mUin;
    }
    paramHandler = new dn("mbtoken3_query_freeze_status", 3, paramHandler, 4007);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoQueryFreezeStatus.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ca
 * JD-Core Version:    0.7.0.1
 */