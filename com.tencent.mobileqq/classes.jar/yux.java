import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class yux
{
  public static int a(String paramString)
  {
    return a(paramString).getInt("configVersion", 0);
  }
  
  protected static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("troop_gift_config_" + paramString, 0);
  }
  
  public static yuy a(JSONObject paramJSONObject)
  {
    int i = 0;
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject;
      try
      {
        localArrayList = new ArrayList();
        localObject = paramJSONObject.getString("title");
        paramJSONObject = paramJSONObject.getJSONArray("actionList");
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          yuz localyuz = new yuz();
          localyuz.jdField_a_of_type_JavaLangString = localJSONObject.optString("img");
          localyuz.jdField_b_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
          if ((TextUtils.isEmpty(localyuz.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localyuz.jdField_b_of_type_JavaLangString))) {
            break label215;
          }
          localArrayList.add(localyuz);
        }
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GiftConfigManager", 2, "parseActivityTabInfo exp:" + paramJSONObject.toString());
        }
      }
      for (;;)
      {
        return null;
        paramJSONObject = (JSONObject)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject = alud.a(2131705657);
        }
        if (paramJSONObject.length() > 4) {
          paramJSONObject = paramJSONObject.substring(0, 4);
        }
        while ((!TextUtils.isEmpty(paramJSONObject)) && (localArrayList.size() > 0))
        {
          localObject = new yuy();
          ((yuy)localObject).jdField_a_of_type_JavaLangString = paramJSONObject;
          ((yuy)localObject).jdField_a_of_type_JavaUtilList = localArrayList;
          return localObject;
        }
      }
      label215:
      i += 1;
    }
  }
  
  public static yuz a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.getString("icon");
      String str2 = paramJSONObject.getString("jumpUrl");
      int i = paramJSONObject.getInt("width");
      int j = paramJSONObject.getInt("height");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (i > 0) && (j > 0))
      {
        paramJSONObject = new yuz();
        paramJSONObject.jdField_a_of_type_JavaLangString = str1;
        paramJSONObject.jdField_b_of_type_JavaLangString = str2;
        paramJSONObject.jdField_a_of_type_Int = i;
        paramJSONObject.jdField_b_of_type_Int = j;
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GiftConfigManager", 2, "parsePanelEntryItem exp:" + paramJSONObject.toString());
      }
    }
    return null;
  }
  
  public static yva a(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getString("jumpUrl");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        yva localyva = new yva();
        localyva.jdField_a_of_type_JavaLangString = str;
        localyva.jdField_b_of_type_JavaLangString = paramJSONObject;
        return localyva;
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GiftConfigManager", 2, "parseProfileCardGiftItem exp:" + paramJSONObject.toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4: astore 5
    //   6: aload 5
    //   8: invokestatic 172	yux:a	(Ljava/lang/String;)I
    //   11: istore 4
    //   13: aload_1
    //   14: getfield 178	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   17: invokevirtual 183	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   20: istore_3
    //   21: new 26	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   28: ldc 185
    //   30: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload 4
    //   35: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 190
    //   40: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 192
    //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore_0
    //   53: aload_1
    //   54: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   57: ifnonnull +112 -> 169
    //   60: iconst_0
    //   61: istore_2
    //   62: ldc 110
    //   64: iconst_1
    //   65: aload_0
    //   66: iload_2
    //   67: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: iload 4
    //   78: iload_3
    //   79: if_icmpeq +293 -> 372
    //   82: aload_1
    //   83: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   86: ifnull +286 -> 372
    //   89: aload_1
    //   90: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   93: invokevirtual 202	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   96: ifle +276 -> 372
    //   99: iconst_0
    //   100: istore_2
    //   101: iload_2
    //   102: aload_1
    //   103: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 202	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: if_icmpge +71 -> 180
    //   112: ldc 110
    //   114: iconst_1
    //   115: new 26	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   122: ldc 204
    //   124: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc 206
    //   133: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   140: iload_2
    //   141: invokevirtual 209	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   144: checkcast 211	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   147: getfield 215	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -65 -> 101
    //   169: aload_1
    //   170: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   173: invokevirtual 202	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   176: istore_2
    //   177: goto -115 -> 62
    //   180: aload_1
    //   181: getfield 196	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   184: iconst_0
    //   185: invokevirtual 209	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   188: checkcast 211	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   191: astore_0
    //   192: aload_0
    //   193: ifnull +179 -> 372
    //   196: aload_0
    //   197: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   200: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   203: iconst_1
    //   204: if_icmpne +201 -> 405
    //   207: aload_0
    //   208: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 230	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   214: invokevirtual 236	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   217: invokestatic 241	awci:a	([B)[B
    //   220: astore_0
    //   221: aload_0
    //   222: ifnull +291 -> 513
    //   225: new 125	java/lang/String
    //   228: dup
    //   229: aload_0
    //   230: ldc 243
    //   232: invokespecial 246	java/lang/String:<init>	([BLjava/lang/String;)V
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +266 -> 503
    //   240: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +28 -> 271
    //   246: ldc 110
    //   248: iconst_2
    //   249: new 26	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   256: ldc 248
    //   258: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: new 54	org/json/JSONObject
    //   274: dup
    //   275: aload_0
    //   276: invokespecial 254	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   279: astore_1
    //   280: aload_1
    //   281: ldc_w 256
    //   284: invokevirtual 260	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   287: astore_0
    //   288: aload_0
    //   289: ifnonnull +130 -> 419
    //   292: ldc_w 262
    //   295: astore_0
    //   296: aload 5
    //   298: ldc_w 264
    //   301: aload_0
    //   302: invokestatic 267	yux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ldc_w 269
    //   309: invokevirtual 260	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +121 -> 435
    //   317: aload_0
    //   318: ldc_w 271
    //   321: invokevirtual 260	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   324: astore_0
    //   325: aload_0
    //   326: ifnonnull +101 -> 427
    //   329: ldc_w 262
    //   332: astore_0
    //   333: aload 5
    //   335: ldc_w 273
    //   338: aload_0
    //   339: invokestatic 267	yux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_1
    //   343: ldc_w 275
    //   346: invokevirtual 260	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   349: astore_0
    //   350: aload_0
    //   351: ifnull +138 -> 489
    //   354: aload 5
    //   356: ldc_w 275
    //   359: aload_0
    //   360: invokevirtual 276	org/json/JSONObject:toString	()Ljava/lang/String;
    //   363: invokestatic 267	yux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 5
    //   368: iload_3
    //   369: invokestatic 279	yux:a	(Ljava/lang/String;I)V
    //   372: return
    //   373: astore_0
    //   374: ldc 110
    //   376: iconst_1
    //   377: new 26	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 281
    //   387: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: aconst_null
    //   401: astore_0
    //   402: goto -166 -> 236
    //   405: aload_0
    //   406: getfield 225	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   409: invokevirtual 230	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   412: invokevirtual 287	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   415: astore_0
    //   416: goto -180 -> 236
    //   419: aload_0
    //   420: invokevirtual 276	org/json/JSONObject:toString	()Ljava/lang/String;
    //   423: astore_0
    //   424: goto -128 -> 296
    //   427: aload_0
    //   428: invokevirtual 276	org/json/JSONObject:toString	()Ljava/lang/String;
    //   431: astore_0
    //   432: goto -99 -> 333
    //   435: aload 5
    //   437: ldc_w 273
    //   440: ldc_w 262
    //   443: invokestatic 267	yux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   446: goto -104 -> 342
    //   449: astore_0
    //   450: ldc 110
    //   452: iconst_1
    //   453: new 26	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 289
    //   463: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    //   477: astore_0
    //   478: ldc 110
    //   480: iconst_1
    //   481: ldc_w 291
    //   484: aload_0
    //   485: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   488: return
    //   489: aload 5
    //   491: ldc_w 275
    //   494: ldc_w 262
    //   497: invokestatic 267	yux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -134 -> 366
    //   503: ldc 110
    //   505: iconst_1
    //   506: ldc_w 296
    //   509: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: return
    //   513: aconst_null
    //   514: astore_0
    //   515: goto -279 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	518	1	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   61	116	2	i	int
    //   20	349	3	j	int
    //   11	69	4	k	int
    //   4	486	5	str	String
    // Exception table:
    //   from	to	target	type
    //   225	236	373	java/lang/Exception
    //   271	288	449	java/lang/Exception
    //   296	313	449	java/lang/Exception
    //   317	325	449	java/lang/Exception
    //   333	342	449	java/lang/Exception
    //   342	350	449	java/lang/Exception
    //   354	366	449	java/lang/Exception
    //   366	372	449	java/lang/Exception
    //   419	424	449	java/lang/Exception
    //   427	432	449	java/lang/Exception
    //   435	446	449	java/lang/Exception
    //   489	500	449	java/lang/Exception
    //   0	60	477	java/lang/Exception
    //   62	76	477	java/lang/Exception
    //   82	99	477	java/lang/Exception
    //   101	162	477	java/lang/Exception
    //   169	177	477	java/lang/Exception
    //   180	192	477	java/lang/Exception
    //   196	221	477	java/lang/Exception
    //   240	271	477	java/lang/Exception
    //   374	400	477	java/lang/Exception
    //   405	416	477	java/lang/Exception
    //   450	476	477	java/lang/Exception
    //   503	512	477	java/lang/Exception
  }
  
  protected static void a(String paramString, int paramInt)
  {
    a(paramString).edit().putInt("configVersion", paramInt).commit();
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1).edit().putString(paramString2, paramString3).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yux
 * JD-Core Version:    0.7.0.1
 */