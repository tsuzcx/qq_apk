package com.tencent.biz.common.offline;

import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineExpire
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OfflineExpire";
    jdField_a_of_type_Int = 3;
  }
  
  protected static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        int j = paramString.length();
        if (i >= j) {
          break;
        }
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          break label121;
        }
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      label121:
      int k = ((JSONObject)localObject).optInt("bid");
      if (k > 0)
      {
        localObject = HtmlOffline.a(k + "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (String)localObject + k;
          if (new File((String)localObject).exists()) {
            Util.a((String)localObject);
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc 110
    //   12: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: new 112	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody
    //   23: dup
    //   24: invokespecial 113	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: aload_0
    //   30: invokevirtual 117	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 121	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   38: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   41: iconst_1
    //   42: if_icmpne -23 -> 19
    //   45: aload_1
    //   46: getfield 130	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:rpt_msg_expired_pkg	Ltencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg;
    //   49: invokevirtual 135	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   52: checkcast 132	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull -38 -> 19
    //   60: aload_0
    //   61: getfield 138	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:uint32_platform	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   67: getstatic 15	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_Int	I
    //   70: if_icmpne -51 -> 19
    //   73: new 140	java/lang/String
    //   76: dup
    //   77: aload_0
    //   78: getfield 144	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:str_expire_pkg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   81: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   84: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   87: ldc 157
    //   89: invokespecial 160	java/lang/String:<init>	([BLjava/lang/String;)V
    //   92: invokestatic 162	com/tencent/biz/common/offline/OfflineExpire:a	(Ljava/lang/String;)V
    //   95: return
    //   96: astore_0
    //   97: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -81 -> 19
    //   103: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: iconst_2
    //   107: new 36	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   114: ldc 164
    //   116: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokestatic 72	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   123: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: return
    //   133: astore_0
    //   134: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -118 -> 19
    //   140: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_2
    //   144: new 36	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   151: ldc 166
    //   153: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: invokevirtual 169	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   160: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: return
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   175: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -159 -> 19
    //   181: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: iconst_2
    //   185: new 36	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   192: ldc 164
    //   194: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: invokestatic 72	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   201: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramArrayOfByte	byte[]
    //   27	19	1	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0x65.SubMsgType0x65.MsgBody
    // Exception table:
    //   from	to	target	type
    //   73	95	96	java/io/UnsupportedEncodingException
    //   28	34	133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   73	95	170	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire
 * JD-Core Version:    0.7.0.1
 */