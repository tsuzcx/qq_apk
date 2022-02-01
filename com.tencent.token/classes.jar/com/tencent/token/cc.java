package com.tencent.token;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
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
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryFreezeStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryMaliciousURL;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryRealName;
import com.tencent.token.core.protocolcenter.protocol.ProtoQuerySpecialVerify;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameCardCheck;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportDnsInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportLocation;
import com.tencent.token.core.protocolcenter.protocol.ProtoSetMbMobile;
import com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryCaptcha;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryMbMobileCode;
import com.tencent.token.utils.l;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cc
  implements a
{
  public static int a = new Random().nextInt() >>> 1;
  private static cc b;
  private com.tencent.token.core.protocolcenter.e c = new com.tencent.token.core.protocolcenter.e();
  
  public static cc a()
  {
    if (b == null) {
      b = new cc();
    }
    return b;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_get_config_v2", 2, paramHandler, 3041);
    ProtoGetConfig.a(paramHandler, paramInt1, paramInt2, paramInt3);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte paramByte, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_get_dual_msg_list_v2", 2, paramHandler, 3069);
    ProtoGetDualMsgList.a(paramHandler, paramLong, paramByte);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem, Handler paramHandler)
  {
    QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_report_location", 3, paramHandler, 3032);
    if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
    }
    ProtoReportLocation.a(paramHandler, paramLong, paramInt1, paramInt2, paramInt3, paramSafeMsgItem);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Handler paramHandler)
  {
    Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_message_v2", 3, paramHandler, 3005);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoGetMessage.a(paramHandler, paramLong, paramInt1, 1, paramInt2, 40);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3, Handler paramHandler)
  {
    QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_message_v2", 3, paramHandler, 3005);
    if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
    }
    ProtoGetMessage.a(paramHandler, paramLong, paramInt1, 1, paramInt2, 40, paramString1, paramInt3, paramInt4, paramString2, paramString3);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt, Handler paramHandler)
  {
    Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_message_v2", 3, paramHandler, 3006);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoGetMessage.a(paramHandler, paramLong, paramInt, 2, 0, 40);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    a += 1;
    int i = a;
    paramHandler = new dp("mbtoken3_get_device_lock_status_v2", 3, paramHandler, 3054);
    ProtoGetDeviceLock.a(paramHandler, paramLong, paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3, i);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_mbop_get_mobile_code", 3, paramHandler, 3013);
    ProtoGetMbMobileCode.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_set_mod_mobile", 3, paramHandler, 3012);
    ProtoSetMbMobile.a(paramHandler, paramLong, paramInt, paramString1, paramString2, paramString3);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int paramInt, boolean paramBoolean, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_face_verify_on_off", 3, paramHandler, 4002);
    int i = a + 1;
    a = i;
    ProtoFaceVryOnOff.a(paramHandler, paramLong, paramInt, i, paramBoolean, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Handler paramHandler)
  {
    if (paramLong2 == 0L)
    {
      Object localObject = null;
      if (paramLong1 == 0L)
      {
        localObject = cs.a().e();
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
      paramHandler = new dp("mbtoken3_check_up_sms", 2, paramHandler, 3068);
      a += 1;
      ProtoCheckUpSMS.a(paramHandler, paramLong1, ((QQUser)localObject).mRealUin, paramInt1, a, paramInt2);
      this.c.a(paramHandler);
      return 0;
    }
    paramHandler = new dp("mbtoken3_check_up_sms", 2, paramHandler, 3068);
    a += 1;
    ProtoCheckUpSMS.a(paramHandler, l.f(paramLong2), paramLong2, paramInt1, a, paramInt2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dp("mbtoken3_unbind_token", 3, paramHandler, 4001);
    ProtoDoUnbindToken.a(paramHandler, paramLong1, paramLong2, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, Handler paramHandler)
  {
    if (paramLong2 == 0L)
    {
      QQUser localQQUser = null;
      if (paramLong1 == 0L)
      {
        localQQUser = cs.a().e();
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
      paramHandler = new dp("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
      a += 1;
      ProtoGeneralVryMobileCode.a(paramHandler, paramLong1, localQQUser.mRealUin, paramInt1, a, paramString, paramInt2);
      this.c.a(paramHandler);
      return 0;
    }
    paramHandler = new dp("mbtoken3_general_verify_mobile_code", 2, paramHandler, 3066);
    a += 1;
    ProtoGeneralVryMobileCode.a(paramHandler, l.f(paramLong2), paramLong2, paramInt1, a, paramString, paramInt2);
    this.c.a(paramHandler);
    return 0;
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, Handler paramHandler)
  {
    // Byte code:
    //   0: iload 5
    //   2: iconst_1
    //   3: if_icmpeq +20 -> 23
    //   6: iload 5
    //   8: iconst_3
    //   9: if_icmpne +6 -> 15
    //   12: goto +11 -> 23
    //   15: lload_3
    //   16: invokestatic 191	com/tencent/token/utils/l:f	(J)J
    //   19: lstore_1
    //   20: goto +105 -> 125
    //   23: invokestatic 66	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   26: invokevirtual 70	com/tencent/token/cs:e	()Lcom/tencent/token/core/bean/QQUser;
    //   29: astore 15
    //   31: lload_1
    //   32: lconst_0
    //   33: lcmp
    //   34: ifne +91 -> 125
    //   37: aload 15
    //   39: ifnonnull +53 -> 92
    //   42: aload 13
    //   44: sipush 3067
    //   47: invokevirtual 76	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   50: astore 6
    //   52: new 78	com/tencent/token/global/e
    //   55: dup
    //   56: invokespecial 79	com/tencent/token/global/e:<init>	()V
    //   59: astore 7
    //   61: aload 7
    //   63: bipush 110
    //   65: invokevirtual 82	com/tencent/token/global/e:b	(I)V
    //   68: aload 6
    //   70: aload 7
    //   72: getfield 83	com/tencent/token/global/e:a	I
    //   75: putfield 88	android/os/Message:arg1	I
    //   78: aload 6
    //   80: aload 7
    //   82: putfield 92	android/os/Message:obj	Ljava/lang/Object;
    //   85: aload 6
    //   87: invokevirtual 95	android/os/Message:sendToTarget	()V
    //   90: iconst_m1
    //   91: ireturn
    //   92: lload_3
    //   93: aload 15
    //   95: getfield 115	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   98: lcmp
    //   99: ifeq +11 -> 110
    //   102: lload_3
    //   103: invokestatic 191	com/tencent/token/utils/l:f	(J)J
    //   106: lstore_1
    //   107: goto +18 -> 125
    //   110: aload 15
    //   112: getfield 101	com/tencent/token/core/bean/QQUser:mUin	J
    //   115: lstore_1
    //   116: aload 15
    //   118: getfield 115	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   121: lstore_3
    //   122: goto +3 -> 125
    //   125: getstatic 25	com/tencent/token/cc:a	I
    //   128: iconst_1
    //   129: iadd
    //   130: putstatic 25	com/tencent/token/cc:a	I
    //   133: getstatic 25	com/tencent/token/cc:a	I
    //   136: istore 14
    //   138: iload 5
    //   140: iconst_1
    //   141: if_icmpne +23 -> 164
    //   144: new 39	com/tencent/token/dp
    //   147: dup
    //   148: ldc 212
    //   150: iconst_3
    //   151: aload 13
    //   153: sipush 3067
    //   156: invokespecial 44	com/tencent/token/dp:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   159: astore 13
    //   161: goto +46 -> 207
    //   164: iload 5
    //   166: iconst_3
    //   167: if_icmpne +23 -> 190
    //   170: new 39	com/tencent/token/dp
    //   173: dup
    //   174: ldc 212
    //   176: iconst_3
    //   177: aload 13
    //   179: sipush 3078
    //   182: invokespecial 44	com/tencent/token/dp:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   185: astore 13
    //   187: goto +20 -> 207
    //   190: new 39	com/tencent/token/dp
    //   193: dup
    //   194: ldc 212
    //   196: iconst_2
    //   197: aload 13
    //   199: sipush 3067
    //   202: invokespecial 44	com/tencent/token/dp:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   205: astore 13
    //   207: aload 13
    //   209: iconst_1
    //   210: putfield 215	com/tencent/token/dp:m	I
    //   213: aload 13
    //   215: new 217	android/content/ContentValues
    //   218: dup
    //   219: iconst_3
    //   220: invokespecial 219	android/content/ContentValues:<init>	(I)V
    //   223: putfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   226: aload 13
    //   228: getfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   231: ldc 225
    //   233: invokestatic 230	com/tencent/token/cb:a	()Lcom/tencent/token/cb;
    //   236: invokevirtual 233	com/tencent/token/cb:b	()Ljava/lang/String;
    //   239: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: new 238	org/json/JSONObject
    //   245: dup
    //   246: invokespecial 239	org/json/JSONObject:<init>	()V
    //   249: astore 16
    //   251: aload 16
    //   253: ldc 241
    //   255: lload_3
    //   256: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload 16
    //   262: ldc 246
    //   264: lload_1
    //   265: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 16
    //   271: ldc 248
    //   273: aload 6
    //   275: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 16
    //   281: ldc 253
    //   283: aload 7
    //   285: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload 16
    //   291: ldc 255
    //   293: iload 5
    //   295: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   298: pop
    //   299: new 260	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   306: astore 15
    //   308: aload 15
    //   310: ldc_w 263
    //   313: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 15
    //   319: aload 16
    //   321: invokevirtual 270	org/json/JSONObject:toString	()Ljava/lang/String;
    //   324: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 15
    //   330: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   336: aload 8
    //   338: ifnull +58 -> 396
    //   341: aload 8
    //   343: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   346: astore 15
    //   348: aload 16
    //   350: ldc_w 283
    //   353: aload 15
    //   355: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   358: pop
    //   359: new 260	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   366: astore 17
    //   368: aload 17
    //   370: ldc_w 285
    //   373: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 17
    //   379: aload 15
    //   381: invokevirtual 290	java/lang/String:length	()I
    //   384: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 17
    //   390: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   396: aload 9
    //   398: ifnull +58 -> 456
    //   401: aload 9
    //   403: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   406: astore 15
    //   408: aload 16
    //   410: ldc_w 295
    //   413: aload 15
    //   415: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   418: pop
    //   419: new 260	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   426: astore 17
    //   428: aload 17
    //   430: ldc_w 297
    //   433: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 17
    //   439: aload 15
    //   441: invokevirtual 290	java/lang/String:length	()I
    //   444: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 17
    //   450: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   456: aload 10
    //   458: ifnull +58 -> 516
    //   461: aload 10
    //   463: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   466: astore 15
    //   468: aload 16
    //   470: ldc_w 299
    //   473: aload 15
    //   475: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: new 260	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   486: astore 17
    //   488: aload 17
    //   490: ldc_w 301
    //   493: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 17
    //   499: aload 15
    //   501: invokevirtual 290	java/lang/String:length	()I
    //   504: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 17
    //   510: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   516: aload 11
    //   518: ifnull +17 -> 535
    //   521: aload 16
    //   523: ldc_w 303
    //   526: aload 11
    //   528: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   531: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload 12
    //   537: ifnull +17 -> 554
    //   540: aload 16
    //   542: ldc_w 305
    //   545: aload 12
    //   547: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   550: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   553: pop
    //   554: aload 16
    //   556: ldc_w 307
    //   559: invokestatic 312	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   562: invokevirtual 316	com/tencent/token/cd:k	()J
    //   565: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   568: pop
    //   569: aload 16
    //   571: ldc_w 318
    //   574: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   577: invokestatic 328	com/tencent/token/ca:a	(Landroid/content/Context;)Lcom/tencent/token/ca;
    //   580: invokevirtual 331	com/tencent/token/ca:b	()[B
    //   583: invokestatic 332	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
    //   586: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   589: pop
    //   590: aload 16
    //   592: ldc_w 334
    //   595: iload 14
    //   597: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   600: pop
    //   601: aload 16
    //   603: ldc_w 336
    //   606: invokestatic 312	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   609: invokevirtual 339	com/tencent/token/cd:s	()J
    //   612: ldc2_w 340
    //   615: ldiv
    //   616: l2i
    //   617: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   620: pop
    //   621: aload 16
    //   623: ldc_w 343
    //   626: getstatic 349	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   629: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload 16
    //   635: ldc_w 351
    //   638: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   641: invokestatic 354	com/tencent/token/utils/l:a	(Landroid/content/Context;)Ljava/lang/String;
    //   644: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload 16
    //   650: ldc_w 356
    //   653: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   656: invokestatic 358	com/tencent/token/utils/l:b	(Landroid/content/Context;)Ljava/lang/String;
    //   659: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   662: pop
    //   663: aload 16
    //   665: ldc_w 360
    //   668: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   671: invokestatic 362	com/tencent/token/utils/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   674: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   677: pop
    //   678: aload 16
    //   680: ldc_w 364
    //   683: getstatic 367	android/os/Build:MODEL	Ljava/lang/String;
    //   686: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   689: pop
    //   690: aload 16
    //   692: ldc_w 369
    //   695: getstatic 374	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   698: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload 16
    //   704: ldc_w 376
    //   707: getstatic 380	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:f	I
    //   710: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 16
    //   716: ldc_w 382
    //   719: getstatic 385	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:h	I
    //   722: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   725: pop
    //   726: aload 16
    //   728: ldc_w 387
    //   731: getstatic 390	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:g	I
    //   734: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   737: pop
    //   738: aload 16
    //   740: ldc_w 392
    //   743: getstatic 395	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:i	I
    //   746: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 16
    //   752: ldc_w 397
    //   755: getstatic 400	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:j	I
    //   758: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   761: pop
    //   762: aload 16
    //   764: ldc_w 402
    //   767: getstatic 404	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:k	I
    //   770: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   773: pop
    //   774: aload 16
    //   776: ldc_w 406
    //   779: getstatic 409	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:l	I
    //   782: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   785: pop
    //   786: aload 16
    //   788: ldc_w 411
    //   791: getstatic 412	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:m	I
    //   794: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   797: pop
    //   798: aload 16
    //   800: ldc_w 414
    //   803: getstatic 416	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:n	I
    //   806: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   809: pop
    //   810: aload 16
    //   812: ldc_w 418
    //   815: getstatic 421	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:o	I
    //   818: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   821: pop
    //   822: aload 16
    //   824: ldc_w 423
    //   827: getstatic 428	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:d	I
    //   830: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   833: pop
    //   834: aload 16
    //   836: ldc_w 430
    //   839: getstatic 432	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:e	I
    //   842: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   845: pop
    //   846: aload 16
    //   848: ldc_w 434
    //   851: getstatic 435	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:f	I
    //   854: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   857: pop
    //   858: aload 16
    //   860: ldc_w 437
    //   863: getstatic 441	com/tencent/token/ui/e:b	I
    //   866: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   869: pop
    //   870: aload 16
    //   872: ldc_w 443
    //   875: getstatic 444	com/tencent/token/ui/e:a	I
    //   878: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   881: pop
    //   882: aload 16
    //   884: ldc_w 446
    //   887: getstatic 447	com/tencent/token/ui/e:d	I
    //   890: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   893: pop
    //   894: aload 16
    //   896: ldc_w 449
    //   899: getstatic 451	com/tencent/token/ui/e:c	I
    //   902: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   905: pop
    //   906: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   909: invokestatic 453	com/tencent/token/utils/l:e	(Landroid/content/Context;)Ljava/lang/String;
    //   912: astore 15
    //   914: aload 15
    //   916: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   919: ifne +14 -> 933
    //   922: aload 16
    //   924: ldc_w 461
    //   927: aload 15
    //   929: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   932: pop
    //   933: invokestatic 323	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   936: invokestatic 463	com/tencent/token/utils/l:d	(Landroid/content/Context;)Ljava/lang/String;
    //   939: astore 15
    //   941: aload 15
    //   943: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   946: ifne +34 -> 980
    //   949: aload 16
    //   951: ldc_w 465
    //   954: aload 15
    //   956: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   959: pop
    //   960: goto +20 -> 980
    //   963: astore 15
    //   965: goto +10 -> 975
    //   968: astore 15
    //   970: goto +5 -> 975
    //   973: astore 15
    //   975: aload 15
    //   977: invokevirtual 468	java/lang/Exception:printStackTrace	()V
    //   980: aload 16
    //   982: invokevirtual 270	org/json/JSONObject:toString	()Ljava/lang/String;
    //   985: invokevirtual 471	java/lang/String:getBytes	()[B
    //   988: invokestatic 474	com/tencent/token/utils/l:c	([B)[B
    //   991: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   994: bipush 43
    //   996: bipush 45
    //   998: invokevirtual 478	java/lang/String:replace	(CC)Ljava/lang/String;
    //   1001: bipush 61
    //   1003: bipush 95
    //   1005: invokevirtual 478	java/lang/String:replace	(CC)Ljava/lang/String;
    //   1008: astore 15
    //   1010: new 260	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1017: astore 16
    //   1019: aload 16
    //   1021: ldc_w 480
    //   1024: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload 16
    //   1030: aload 15
    //   1032: invokevirtual 290	java/lang/String:length	()I
    //   1035: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 16
    //   1041: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1047: aload 13
    //   1049: getfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   1052: ldc_w 482
    //   1055: aload 15
    //   1057: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1060: aload 13
    //   1062: lload_1
    //   1063: iload 14
    //   1065: lload_3
    //   1066: aload 6
    //   1068: aload 7
    //   1070: iload 5
    //   1072: aload 8
    //   1074: aload 9
    //   1076: aload 10
    //   1078: aload 11
    //   1080: aload 12
    //   1082: invokestatic 487	com/tencent/token/core/protocolcenter/protocol/ProtoRealNameReg:a	(Lcom/tencent/token/dp;JIJLjava/lang/String;Ljava/lang/String;I[B[B[B[B[B)V
    //   1085: aload_0
    //   1086: getfield 32	com/tencent/token/cc:c	Lcom/tencent/token/core/protocolcenter/e;
    //   1089: aload 13
    //   1091: invokevirtual 52	com/tencent/token/core/protocolcenter/e:a	(Lcom/tencent/token/dp;)I
    //   1094: pop
    //   1095: iconst_0
    //   1096: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1097	0	this	cc
    //   0	1097	1	paramLong1	long
    //   0	1097	3	paramLong2	long
    //   0	1097	5	paramInt	int
    //   0	1097	6	paramString1	String
    //   0	1097	7	paramString2	String
    //   0	1097	8	paramArrayOfByte1	byte[]
    //   0	1097	9	paramArrayOfByte2	byte[]
    //   0	1097	10	paramArrayOfByte3	byte[]
    //   0	1097	11	paramArrayOfByte4	byte[]
    //   0	1097	12	paramArrayOfByte5	byte[]
    //   0	1097	13	paramHandler	Handler
    //   136	928	14	i	int
    //   29	926	15	localObject1	Object
    //   963	1	15	localException1	java.lang.Exception
    //   968	1	15	localException2	java.lang.Exception
    //   973	3	15	localException3	java.lang.Exception
    //   1008	48	15	str	String
    //   249	791	16	localObject2	Object
    //   366	143	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   279	336	963	java/lang/Exception
    //   341	396	963	java/lang/Exception
    //   401	456	963	java/lang/Exception
    //   461	516	963	java/lang/Exception
    //   521	535	963	java/lang/Exception
    //   540	554	963	java/lang/Exception
    //   554	933	963	java/lang/Exception
    //   933	960	963	java/lang/Exception
    //   269	279	968	java/lang/Exception
    //   251	269	973	java/lang/Exception
  }
  
  /* Error */
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, Handler paramHandler)
  {
    // Byte code:
    //   0: lload_3
    //   1: lconst_0
    //   2: lcmp
    //   3: ifeq +15 -> 18
    //   6: invokestatic 66	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   9: lload_3
    //   10: invokevirtual 491	com/tencent/token/cs:d	(J)Lcom/tencent/token/core/bean/QQUser;
    //   13: astore 15
    //   15: goto +6 -> 21
    //   18: aconst_null
    //   19: astore 15
    //   21: aload 15
    //   23: astore 16
    //   25: aload 15
    //   27: ifnonnull +11 -> 38
    //   30: invokestatic 66	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   33: invokevirtual 70	com/tencent/token/cs:e	()Lcom/tencent/token/core/bean/QQUser;
    //   36: astore 16
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +67 -> 108
    //   44: aload 16
    //   46: ifnonnull +53 -> 99
    //   49: aload 10
    //   51: sipush 3058
    //   54: invokevirtual 76	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   57: astore 6
    //   59: new 78	com/tencent/token/global/e
    //   62: dup
    //   63: invokespecial 79	com/tencent/token/global/e:<init>	()V
    //   66: astore 10
    //   68: aload 10
    //   70: bipush 110
    //   72: invokevirtual 82	com/tencent/token/global/e:b	(I)V
    //   75: aload 6
    //   77: aload 10
    //   79: getfield 83	com/tencent/token/global/e:a	I
    //   82: putfield 88	android/os/Message:arg1	I
    //   85: aload 6
    //   87: aload 10
    //   89: putfield 92	android/os/Message:obj	Ljava/lang/Object;
    //   92: aload 6
    //   94: invokevirtual 95	android/os/Message:sendToTarget	()V
    //   97: iconst_m1
    //   98: ireturn
    //   99: aload 16
    //   101: getfield 101	com/tencent/token/core/bean/QQUser:mUin	J
    //   104: lstore_1
    //   105: goto +3 -> 108
    //   108: lload_3
    //   109: lconst_0
    //   110: lcmp
    //   111: ifeq +11 -> 122
    //   114: lload_3
    //   115: invokestatic 191	com/tencent/token/utils/l:f	(J)J
    //   118: lstore_1
    //   119: goto +17 -> 136
    //   122: aload 16
    //   124: ifnull +12 -> 136
    //   127: aload 16
    //   129: getfield 115	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   132: lstore_3
    //   133: goto +3 -> 136
    //   136: getstatic 25	com/tencent/token/cc:a	I
    //   139: iconst_1
    //   140: iadd
    //   141: putstatic 25	com/tencent/token/cc:a	I
    //   144: getstatic 25	com/tencent/token/cc:a	I
    //   147: istore 12
    //   149: iload 8
    //   151: iconst_2
    //   152: if_icmpeq +40 -> 192
    //   155: iload 8
    //   157: bipush 10
    //   159: if_icmpeq +33 -> 192
    //   162: iload 8
    //   164: iconst_1
    //   165: if_icmpne +6 -> 171
    //   168: goto +24 -> 192
    //   171: new 39	com/tencent/token/dp
    //   174: dup
    //   175: ldc_w 493
    //   178: iconst_3
    //   179: aload 10
    //   181: sipush 3058
    //   184: invokespecial 44	com/tencent/token/dp:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   187: astore 15
    //   189: goto +21 -> 210
    //   192: new 39	com/tencent/token/dp
    //   195: dup
    //   196: ldc_w 493
    //   199: iconst_2
    //   200: aload 10
    //   202: sipush 3058
    //   205: invokespecial 44	com/tencent/token/dp:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   208: astore 15
    //   210: aload 15
    //   212: iconst_1
    //   213: putfield 215	com/tencent/token/dp:m	I
    //   216: aload 15
    //   218: new 217	android/content/ContentValues
    //   221: dup
    //   222: iconst_3
    //   223: invokespecial 219	android/content/ContentValues:<init>	(I)V
    //   226: putfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   229: aload 15
    //   231: getfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   234: ldc 225
    //   236: invokestatic 230	com/tencent/token/cb:a	()Lcom/tencent/token/cb;
    //   239: invokevirtual 233	com/tencent/token/cb:b	()Ljava/lang/String;
    //   242: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: new 238	org/json/JSONObject
    //   248: dup
    //   249: invokespecial 239	org/json/JSONObject:<init>	()V
    //   252: astore 10
    //   254: iload 5
    //   256: iconst_2
    //   257: if_icmpeq +19 -> 276
    //   260: aload 10
    //   262: ldc 246
    //   264: aload 16
    //   266: getfield 115	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   269: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   272: pop
    //   273: goto +28 -> 301
    //   276: aload 10
    //   278: ldc 246
    //   280: lload_3
    //   281: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   284: pop
    //   285: iload 7
    //   287: ifle +14 -> 301
    //   290: aload 10
    //   292: ldc_w 495
    //   295: iload 7
    //   297: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 10
    //   303: ldc 255
    //   305: iload 5
    //   307: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   310: pop
    //   311: new 260	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   318: astore 17
    //   320: aload 17
    //   322: ldc_w 497
    //   325: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 17
    //   331: iload 5
    //   333: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 17
    //   339: ldc_w 499
    //   342: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 17
    //   348: aload 16
    //   350: getfield 115	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   353: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 17
    //   359: ldc_w 504
    //   362: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 17
    //   368: lload_3
    //   369: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 17
    //   375: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   381: invokestatic 509	java/lang/System:currentTimeMillis	()J
    //   384: lstore 13
    //   386: iload 5
    //   388: iconst_3
    //   389: if_icmpeq +840 -> 1229
    //   392: new 260	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   399: astore 16
    //   401: aload 16
    //   403: ldc_w 511
    //   406: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 16
    //   412: aload 6
    //   414: arraylength
    //   415: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 16
    //   421: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 513	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   427: aload 6
    //   429: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   432: astore 16
    //   434: aload 10
    //   436: ldc_w 515
    //   439: aload 16
    //   441: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: new 260	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   452: astore 17
    //   454: aload 17
    //   456: ldc_w 517
    //   459: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 17
    //   465: aload 16
    //   467: invokevirtual 290	java/lang/String:length	()I
    //   470: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 17
    //   476: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 513	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   482: aload 10
    //   484: ldc_w 519
    //   487: getstatic 521	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:d	Ljava/lang/String;
    //   490: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   493: pop
    //   494: aload 10
    //   496: ldc_w 523
    //   499: getstatic 524	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:e	I
    //   502: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   505: pop
    //   506: aload 10
    //   508: ldc_w 376
    //   511: getstatic 380	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:f	I
    //   514: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   517: pop
    //   518: aload 10
    //   520: ldc_w 382
    //   523: getstatic 385	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:h	I
    //   526: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   529: pop
    //   530: invokestatic 530	com/tencent/jni/FaceDetector:IsSupportNeon	()Z
    //   533: ifeq +685 -> 1218
    //   536: iconst_1
    //   537: istore 11
    //   539: goto +3 -> 542
    //   542: aload 10
    //   544: ldc_w 532
    //   547: iload 11
    //   549: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   552: pop
    //   553: aload 10
    //   555: ldc_w 387
    //   558: getstatic 390	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:g	I
    //   561: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   564: pop
    //   565: aload 10
    //   567: ldc_w 392
    //   570: getstatic 395	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:i	I
    //   573: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload 10
    //   579: ldc_w 397
    //   582: getstatic 400	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:j	I
    //   585: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: aload 10
    //   591: ldc_w 402
    //   594: getstatic 404	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:k	I
    //   597: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   600: pop
    //   601: aload 10
    //   603: ldc_w 406
    //   606: getstatic 409	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:l	I
    //   609: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   612: pop
    //   613: aload 10
    //   615: ldc_w 411
    //   618: getstatic 412	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:m	I
    //   621: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   624: pop
    //   625: aload 10
    //   627: ldc_w 414
    //   630: getstatic 416	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:n	I
    //   633: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   636: pop
    //   637: aload 10
    //   639: ldc_w 418
    //   642: getstatic 421	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:o	I
    //   645: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   648: pop
    //   649: aload 10
    //   651: ldc_w 423
    //   654: getstatic 428	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:d	I
    //   657: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   660: pop
    //   661: aload 10
    //   663: ldc_w 430
    //   666: getstatic 432	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:e	I
    //   669: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   672: pop
    //   673: aload 10
    //   675: ldc_w 434
    //   678: getstatic 435	com/tencent/token/core/protocolcenter/protocol/ProtoLiveFaceDetect:f	I
    //   681: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   684: pop
    //   685: new 260	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   692: astore 16
    //   694: aload 16
    //   696: ldc_w 534
    //   699: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload 16
    //   705: getstatic 374	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   708: invokestatic 540	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   711: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 10
    //   717: ldc_w 542
    //   720: aload 16
    //   722: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   728: pop
    //   729: aload 10
    //   731: ldc_w 544
    //   734: invokestatic 548	com/tencent/token/utils/m:i	()I
    //   737: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   740: pop
    //   741: goto +3 -> 744
    //   744: aload 10
    //   746: ldc_w 336
    //   749: invokestatic 312	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   752: invokevirtual 339	com/tencent/token/cd:s	()J
    //   755: ldc2_w 340
    //   758: ldiv
    //   759: l2i
    //   760: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   763: pop
    //   764: aload 10
    //   766: ldc_w 334
    //   769: iload 12
    //   771: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   774: pop
    //   775: aload 10
    //   777: ldc_w 550
    //   780: iload 9
    //   782: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   785: pop
    //   786: iload 8
    //   788: bipush 10
    //   790: if_icmpne +442 -> 1232
    //   793: iconst_1
    //   794: istore 11
    //   796: goto +3 -> 799
    //   799: aload 10
    //   801: ldc_w 552
    //   804: iload 11
    //   806: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   809: pop
    //   810: new 260	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   817: astore 16
    //   819: aload 16
    //   821: ldc_w 554
    //   824: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload 16
    //   830: iload 8
    //   832: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 16
    //   838: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   844: invokestatic 509	java/lang/System:currentTimeMillis	()J
    //   847: lload 13
    //   849: lsub
    //   850: l2i
    //   851: istore 11
    //   853: new 260	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   860: astore 16
    //   862: aload 16
    //   864: ldc_w 556
    //   867: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 16
    //   873: iload 11
    //   875: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 16
    //   881: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 513	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   887: aload 10
    //   889: ldc_w 558
    //   892: iload 11
    //   894: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   897: pop
    //   898: iload 5
    //   900: iconst_5
    //   901: if_icmpne +18 -> 919
    //   904: aload 10
    //   906: ldc_w 307
    //   909: invokestatic 312	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   912: invokevirtual 316	com/tencent/token/cd:k	()J
    //   915: invokevirtual 244	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   918: pop
    //   919: aload 10
    //   921: invokevirtual 270	org/json/JSONObject:toString	()Ljava/lang/String;
    //   924: invokevirtual 471	java/lang/String:getBytes	()[B
    //   927: invokestatic 474	com/tencent/token/utils/l:c	([B)[B
    //   930: astore 16
    //   932: aload 16
    //   934: invokestatic 281	com/tencent/token/utils/b:a	([B)Ljava/lang/String;
    //   937: bipush 43
    //   939: bipush 45
    //   941: invokevirtual 478	java/lang/String:replace	(CC)Ljava/lang/String;
    //   944: bipush 61
    //   946: bipush 95
    //   948: invokevirtual 478	java/lang/String:replace	(CC)Ljava/lang/String;
    //   951: astore 10
    //   953: aload 15
    //   955: getfield 223	com/tencent/token/dp:n	Landroid/content/ContentValues;
    //   958: ldc_w 482
    //   961: aload 10
    //   963: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   966: new 260	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   973: astore 17
    //   975: aload 17
    //   977: ldc_w 560
    //   980: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload 17
    //   986: getstatic 521	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:d	Ljava/lang/String;
    //   989: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload 17
    //   995: ldc_w 562
    //   998: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload 17
    //   1004: getstatic 524	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:e	I
    //   1007: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload 17
    //   1013: ldc_w 564
    //   1016: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 17
    //   1022: getstatic 380	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:f	I
    //   1025: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload 17
    //   1031: ldc_w 566
    //   1034: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 17
    //   1040: getstatic 385	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:h	I
    //   1043: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 17
    //   1049: ldc_w 568
    //   1052: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 17
    //   1058: iload 11
    //   1060: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 17
    //   1066: ldc_w 570
    //   1069: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload 17
    //   1075: iload 12
    //   1077: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload 17
    //   1083: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1089: new 260	java/lang/StringBuilder
    //   1092: dup
    //   1093: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1096: astore 17
    //   1098: aload 17
    //   1100: ldc_w 572
    //   1103: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 17
    //   1109: aload 16
    //   1111: arraylength
    //   1112: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: aload 17
    //   1118: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1124: new 260	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1131: astore 16
    //   1133: aload 16
    //   1135: ldc_w 574
    //   1138: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: aload 16
    //   1144: aload 10
    //   1146: invokevirtual 290	java/lang/String:length	()I
    //   1149: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 16
    //   1155: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokestatic 276	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1161: goto +26 -> 1187
    //   1164: astore 10
    //   1166: goto +5 -> 1171
    //   1169: astore 10
    //   1171: goto +5 -> 1176
    //   1174: astore 10
    //   1176: aload 15
    //   1178: iconst_1
    //   1179: putfield 576	com/tencent/token/dp:k	Z
    //   1182: aload 10
    //   1184: invokevirtual 468	java/lang/Exception:printStackTrace	()V
    //   1187: aload 15
    //   1189: lload_1
    //   1190: iload 12
    //   1192: lload_3
    //   1193: iload 5
    //   1195: aload 6
    //   1197: iload 7
    //   1199: iload 8
    //   1201: iload 9
    //   1203: invokestatic 579	com/tencent/token/core/protocolcenter/protocol/ProtoFaceCommon:a	(Lcom/tencent/token/dp;JIJI[BIII)V
    //   1206: aload_0
    //   1207: getfield 32	com/tencent/token/cc:c	Lcom/tencent/token/core/protocolcenter/e;
    //   1210: aload 15
    //   1212: invokevirtual 52	com/tencent/token/core/protocolcenter/e:a	(Lcom/tencent/token/dp;)I
    //   1215: pop
    //   1216: iconst_0
    //   1217: ireturn
    //   1218: iconst_0
    //   1219: istore 11
    //   1221: goto -679 -> 542
    //   1224: astore 10
    //   1226: goto -50 -> 1176
    //   1229: goto -485 -> 744
    //   1232: iload 8
    //   1234: istore 11
    //   1236: goto -437 -> 799
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1239	0	this	cc
    //   0	1239	1	paramLong1	long
    //   0	1239	3	paramLong2	long
    //   0	1239	5	paramInt1	int
    //   0	1239	6	paramArrayOfByte	byte[]
    //   0	1239	7	paramInt2	int
    //   0	1239	8	paramInt3	int
    //   0	1239	9	paramInt4	int
    //   0	1239	10	paramHandler	Handler
    //   537	698	11	i	int
    //   147	1044	12	j	int
    //   384	464	13	l	long
    //   13	1198	15	localObject1	Object
    //   23	1131	16	localObject2	Object
    //   318	799	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   775	786	1164	java/lang/Exception
    //   799	898	1164	java/lang/Exception
    //   904	919	1164	java/lang/Exception
    //   919	1161	1164	java/lang/Exception
    //   454	536	1169	java/lang/Exception
    //   542	741	1169	java/lang/Exception
    //   744	775	1169	java/lang/Exception
    //   260	273	1174	java/lang/Exception
    //   276	285	1174	java/lang/Exception
    //   290	301	1174	java/lang/Exception
    //   301	386	1174	java/lang/Exception
    //   410	454	1174	java/lang/Exception
    //   392	410	1224	java/lang/Exception
  }
  
  public int a(long paramLong1, long paramLong2, Handler paramHandler)
  {
    long l = paramLong1;
    if (paramLong1 == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_feedback_abnormal_login", 3, paramHandler, 3038);
    ProtoFeedbackAbnormalLogin.a(paramHandler, l, paramLong2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong1, long paramLong2, String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (0L == paramLong2)
    {
      QQUser localQQUser = cs.a().e();
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
        break label98;
      }
    }
    long l = paramLong2;
    paramLong2 = paramLong1;
    label98:
    a += 1;
    if (paramBoolean) {
      paramHandler = new dp("mbtoken3_card_check", 3, paramHandler, 3080);
    } else {
      paramHandler = new dp("mbtoken3_card_check", 2, paramHandler, 3080);
    }
    ProtoRealNameCardCheck.a(paramHandler, paramLong2, l, a, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_ac_lock_status_v2", 3, paramHandler, 3000);
    ProtoGetAccountLockStatus.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, Long paramLong1, int paramInt, Handler paramHandler)
  {
    if (paramLong1.longValue() == 0L)
    {
      paramLong1 = null;
      if (paramLong == 0L)
      {
        paramLong1 = cs.a().e();
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
      paramHandler = new dp("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
      a += 1;
      ProtoGeneralGetMobileCode.a(paramHandler, paramLong, paramLong1.mRealUin, paramInt, a);
      this.c.a(paramHandler);
      return 0;
    }
    paramHandler = new dp("mbtoken3_general_get_mobile_code", 2, paramHandler, 3065);
    a += 1;
    ProtoGeneralGetMobileCode.a(paramHandler, l.f(paramLong1.longValue()), paramLong1.longValue(), paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_verify_qqtoken_v2", 2, paramHandler, 3027);
    ProtoDoVerifyQQToken.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_mbop_verify_mobile_code", 3, paramHandler, 3014);
    ProtoVryMbMobileCode.a(paramHandler, l, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    a += 1;
    int i = a;
    paramHandler = new dp("mbtoken3_device_lock_del_device_v2", 3, paramHandler, 3055);
    ProtoDelDevice.a(paramHandler, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, paramInt4, paramInt5, paramString5, paramString6, i);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_kickoff_v2", 3, paramHandler, 3056);
    ProtoKickOff.a(paramHandler, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramString5, paramString6);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_vry_ques_v2", 2, paramHandler, 3028);
    ProtoDoVerifyQuestion.a(paramHandler, paramLong, paramList, paramArrayOfString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, int paramInt)
  {
    paramHandler = new dp("mbtoken3_vfy_wtlogin", 2, paramHandler, 3024);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ProtoDoWtLogin.a(paramHandler, localStringBuilder.toString(), paramArrayOfByte, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, Handler paramHandler, int paramInt1, int paramInt2)
  {
    a += 1;
    int i = a;
    if (1 == paramInt2)
    {
      paramHandler = new dp("mbtoken3_determine_verify_factors", 3, paramHandler, 4003);
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(paramLong));
      paramHandler.c.put("param.uinhash", Long.valueOf(paramLong));
    }
    else
    {
      paramHandler = new dp("mbtoken3_determine_verify_factors", 2, paramHandler, 4003);
    }
    ProtoGetDeterminVerifyFactors.a(paramHandler, paramLong, paramArrayOfByte, i, paramInt1, paramInt2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Handler paramHandler)
  {
    if (paramLong == 0L)
    {
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_set_service_status_v2", 3, paramHandler, 3061);
    a += 1;
    ProtoSetServiceStatusV2.a(paramHandler, paramLong, paramArrayOfInt1, paramArrayOfInt2, paramString, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(Handler paramHandler)
  {
    dp localdp = new dp("mbtoken3_get_key_value_conf", 2, paramHandler, 3023);
    Object localObject2 = this.c.b(localdp);
    if ((localObject2 != null) && (((dq)localObject2).a != null)) {
      try
      {
        Object localObject1 = ct.a().h.a("key_value");
        localObject2 = new JSONObject((String)((dq)localObject2).a);
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
    ProtoGetStrConfig.e(localdp);
    this.c.a(localdp);
    return 0;
  }
  
  public int a(Handler paramHandler, File paramFile, String paramString)
  {
    QQUser localQQUser = cs.a().e();
    paramHandler = new dp("mbtoken3_log_upload", 2, paramHandler, 3063);
    paramHandler.m = 2;
    paramHandler.o = paramFile;
    StringBuilder localStringBuilder;
    if (localQQUser == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0_");
      localStringBuilder.append(paramString);
      paramHandler.p = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localQQUser.mUin);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramHandler.p = localStringBuilder.toString();
    }
    paramHandler.n = new ContentValues(2);
    if (localQQUser == null) {
      paramHandler.n.put("uin", l.b(String.valueOf(0).getBytes()));
    } else {
      paramHandler.n.put("uin", l.b(String.valueOf(localQQUser.b()).getBytes()));
    }
    paramHandler.n.put("aq_base_sid", cb.a().b());
    paramHandler.n.put("log_date", Integer.valueOf(dz.a().j()));
    ProtoUploadLogFile.a(paramHandler, paramFile.getAbsolutePath());
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(ConfigResult paramConfigResult, Handler paramHandler)
  {
    paramHandler = new dp("token.getstartupimg", 1, paramHandler, 3042);
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
      QQUser localQQUser = cs.a().e();
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
    a += 1;
    int i = a;
    paramHandler = new dp("mbtoken3_get_sms_port_v2", 2, paramHandler, 3019);
    ProtoGetSMSChannel.a(paramHandler, paramLong, paramString1, paramInt1, paramInt2, paramString2, i);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(String paramString, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_query_malicious_url", 2, paramHandler, 3053);
    ProtoQueryMaliciousURL.a(paramHandler, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_report_dns_v2", 2, paramHandler, 4013);
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
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_del_mbitem", 3, paramHandler, 3011);
    ProtoDelMbInfo.a(paramHandler, l, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    paramHandler = new dp("mbtoken3_general_bind", 2, paramHandler, 4004);
    ProtoDoGeneralBindToken.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong1, long paramLong2, int paramInt, Handler paramHandler)
  {
    if ((0L == paramLong2) && (paramLong1 == 0L))
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_qry_spec_verify", 3, paramHandler, 3075);
    a += 1;
    ProtoQuerySpecialVerify.a(paramHandler, paramLong1, paramLong2, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_game_lock_status_v2", 3, paramHandler, 3002);
    ProtoGetGameLockStatus.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_verify_original_mobile", 2, paramHandler, 3085);
    ProtoDoVerifyOriginalMobile.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(long paramLong, String paramString, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_feedback_v2", 2, paramHandler, 3022);
    ProtoDoSendFeedback.a(paramHandler, paramLong, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int b(Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_qry_bind_notify_msg", 2, paramHandler, 3043);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dp("mbtoken3_login_v2", 2, paramHandler, 10002);
    ProtoDoLoginV2.a(paramHandler, paramLong, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    paramHandler = new dp("mbtoken3_bind_token_by_app_v3", 2, paramHandler, 3026);
    ProtoDoBindToken.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_safe_protection_v2", 3, paramHandler, 3001);
    ProtoGetSafeProtection.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_verify_mobile_code_v2", 2, paramHandler, 3029);
    ProtoDoVerifySmscode.a(paramHandler, paramLong, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(long paramLong, String paramString, Handler paramHandler)
  {
    QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_login_prot", 3, paramHandler, 3060);
    ProtoGetLoginProtect.a(paramHandler, l, paramString, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int c(Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_get_domain", 2, paramHandler, 3062);
    QQUser localQQUser = cs.a().e();
    long l;
    if (localQQUser != null) {
      l = localQQUser.mRealUin;
    } else {
      l = 0L;
    }
    ProtoGetDomain.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, int paramInt, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dp("mbtoken3_bind_token_by_realname", 2, paramHandler, 3074);
    ProtoDoBindTokenByRealName.a(paramHandler, paramLong, paramInt, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, int paramInt, String paramString1, String paramString2, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_verify_captcha_v3", 2, paramHandler, 3072);
    ProtoVryCaptcha.a(paramHandler, paramLong, paramInt, paramString1, paramString2);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, Handler paramHandler)
  {
    Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_eval_account_v3", 3, paramHandler, 3004);
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
      QQUser localQQUser = cs.a().e();
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
    paramHandler = new dp("mbtoken3_modify_pwd", 3, paramHandler, 3052);
    ProtoModifyQQPwd.a(paramHandler, l, paramString, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int d(long paramLong, String paramString, Handler paramHandler)
  {
    a += 1;
    paramHandler = new dp("mbtoken3_bind_token_by_univerify", 2, paramHandler, 4015);
    ProtoDoBindTokenByUniverify.a(paramHandler, paramLong, paramString, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, int paramInt, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == -1L)
    {
      QQUser localQQUser = cs.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new dp("mbtoken3_live_video_detect", 2, paramHandler, 3082);
    ProtoLiveFaceDetect.a(paramHandler, l, paramInt);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, Handler paramHandler)
  {
    Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_get_mbinfo", 3, paramHandler, 3010);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoGetMbInfo.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int e(long paramLong, String paramString, int paramInt, Handler paramHandler)
  {
    QQUser localQQUser;
    if (paramLong == 0L)
    {
      localQQUser = cs.a().e();
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
      paramLong = localQQUser.mUin;
    }
    else
    {
      localQQUser = null;
    }
    paramHandler = new dp("mbtoken3_freeze_action", 3, paramHandler, 4008);
    if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(localQQUser.mRealUin));
    }
    ProtoFreezeUin.a(paramHandler, paramLong, paramInt, paramString);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int f(long paramLong, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_get_mobile_code_v2", 2, paramHandler, 3031);
    ProtoDoSendSmscode.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int g(long paramLong, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_query_real_uin_v2", 2, paramHandler, 1006);
    ProtoGetRealUin.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int h(long paramLong, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_del_unvfy_uin", 2, paramHandler, 3036);
    ProtoDelUnverifyUin.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int i(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_feedback_mobile_using", 2, paramHandler, 3037);
    ProtoFeedbackMobileUsing.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int j(long paramLong, Handler paramHandler)
  {
    Object localObject;
    if (paramLong == 0L)
    {
      localObject = cs.a().e();
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
    else
    {
      localObject = null;
    }
    paramHandler = new dp("mbtoken3_realname_status_v2", 3, paramHandler, 3064);
    a += 1;
    ProtoGetRealNameStatus.a(paramHandler, paramLong, ((QQUser)localObject).mRealUin, a);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int k(long paramLong, Handler paramHandler)
  {
    paramHandler = new dp("mbtoken3_realname_qry", 2, paramHandler, 3073);
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
      QQUser localQQUser = cs.a().e();
      l = paramLong;
      if (localQQUser != null) {
        l = localQQUser.mRealUin;
      }
    }
    paramHandler = new dp("mbtoken3_auto_idcard_detect", 2, paramHandler, 3083);
    ProtoAutoIDCardDetect.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int m(long paramLong, Handler paramHandler)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      Object localObject = cs.a().e();
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
    paramHandler = new dp("mbtoken3_copy_face", 3, paramHandler, 3084);
    ProtoCopyFace.a(paramHandler, l);
    this.c.a(paramHandler);
    return 0;
  }
  
  public int n(long paramLong, Handler paramHandler)
  {
    Object localObject;
    if (paramLong == 0L)
    {
      localObject = cs.a().e();
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
      paramLong = ((QQUser)localObject).mUin;
    }
    else
    {
      localObject = null;
    }
    paramHandler = new dp("mbtoken3_query_freeze_status", 3, paramHandler, 4007);
    if ((localObject != null) && (!((QQUser)localObject).mIsBinded)) {
      paramHandler.c.put("param.uin.wtlogin", Long.valueOf(((QQUser)localObject).mRealUin));
    }
    ProtoQueryFreezeStatus.a(paramHandler, paramLong);
    this.c.a(paramHandler);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cc
 * JD-Core Version:    0.7.0.1
 */