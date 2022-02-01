import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class sna
{
  protected static void T(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1).edit().putString(paramString2, paramString3).commit();
  }
  
  public static sna.a a(JSONObject paramJSONObject)
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
          sna.b localb = new sna.b();
          localb.imgUrl = localJSONObject.optString("img");
          localb.jumpUrl = localJSONObject.optString("jumpUrl");
          if ((TextUtils.isEmpty(localb.imgUrl)) || (TextUtils.isEmpty(localb.jumpUrl))) {
            break label215;
          }
          localArrayList.add(localb);
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
          paramJSONObject = acfp.m(2131706959);
        }
        if (paramJSONObject.length() > 4) {
          paramJSONObject = paramJSONObject.substring(0, 4);
        }
        while ((!TextUtils.isEmpty(paramJSONObject)) && (localArrayList.size() > 0))
        {
          localObject = new sna.a();
          ((sna.a)localObject).title = paramJSONObject;
          ((sna.a)localObject).dQ = localArrayList;
          return localObject;
        }
      }
      label215:
      i += 1;
    }
  }
  
  public static sna.b a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.getString("icon");
      String str2 = paramJSONObject.getString("jumpUrl");
      int i = paramJSONObject.getInt("width");
      int j = paramJSONObject.getInt("height");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (i > 0) && (j > 0))
      {
        paramJSONObject = new sna.b();
        paramJSONObject.imgUrl = str1;
        paramJSONObject.jumpUrl = str2;
        paramJSONObject.width = i;
        paramJSONObject.height = j;
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
  
  public static sna.c a(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getString("jumpUrl");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        sna.c localc = new sna.c();
        localc.title = str;
        localc.jumpUrl = paramJSONObject;
        return localc;
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
  
  protected static SharedPreferences b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("troop_gift_config_" + paramString, 0);
  }
  
  /* Error */
  public static void b(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4: astore 5
    //   6: aload 5
    //   8: invokestatic 188	sna:bo	(Ljava/lang/String;)I
    //   11: istore 4
    //   13: aload_1
    //   14: getfield 194	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   17: invokevirtual 199	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   20: istore_3
    //   21: new 103	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   28: ldc 201
    //   30: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload 4
    //   35: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 206
    //   40: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 208
    //   49: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore_0
    //   53: aload_1
    //   54: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   57: ifnonnull +112 -> 169
    //   60: iconst_0
    //   61: istore_2
    //   62: ldc 101
    //   64: iconst_1
    //   65: aload_0
    //   66: iload_2
    //   67: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: iload 4
    //   78: iload_3
    //   79: if_icmpeq +295 -> 374
    //   82: aload_1
    //   83: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   86: ifnull +288 -> 374
    //   89: aload_1
    //   90: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   93: invokevirtual 218	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   96: ifle +278 -> 374
    //   99: iconst_0
    //   100: istore_2
    //   101: iload_2
    //   102: aload_1
    //   103: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 218	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: if_icmpge +71 -> 180
    //   112: ldc 101
    //   114: iconst_1
    //   115: new 103	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   122: ldc 220
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc 222
    //   133: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   140: iload_2
    //   141: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   144: checkcast 227	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   147: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload_2
    //   163: iconst_1
    //   164: iadd
    //   165: istore_2
    //   166: goto -65 -> 101
    //   169: aload_1
    //   170: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   173: invokevirtual 218	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   176: istore_2
    //   177: goto -115 -> 62
    //   180: aload_1
    //   181: getfield 212	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   184: iconst_0
    //   185: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   188: checkcast 227	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   191: astore_0
    //   192: aload_0
    //   193: ifnull +181 -> 374
    //   196: aload_0
    //   197: getfield 237	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   200: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   203: iconst_1
    //   204: if_icmpne +203 -> 407
    //   207: aload_0
    //   208: getfield 241	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 246	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   214: invokevirtual 252	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   217: invokestatic 258	akrf:inflateConfigString	([B)[B
    //   220: astore_0
    //   221: aload_0
    //   222: ifnull +293 -> 515
    //   225: new 128	java/lang/String
    //   228: dup
    //   229: aload_0
    //   230: ldc_w 260
    //   233: invokespecial 263	java/lang/String:<init>	([BLjava/lang/String;)V
    //   236: astore_0
    //   237: aload_0
    //   238: ifnull +267 -> 505
    //   241: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +29 -> 273
    //   247: ldc 101
    //   249: iconst_2
    //   250: new 103	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 265
    //   260: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 268	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: new 48	org/json/JSONObject
    //   276: dup
    //   277: aload_0
    //   278: invokespecial 271	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc_w 273
    //   286: invokevirtual 277	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   289: astore_0
    //   290: aload_0
    //   291: ifnonnull +130 -> 421
    //   294: ldc_w 279
    //   297: astore_0
    //   298: aload 5
    //   300: ldc_w 281
    //   303: aload_0
    //   304: invokestatic 283	sna:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_1
    //   308: ldc_w 285
    //   311: invokevirtual 277	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   314: astore_0
    //   315: aload_0
    //   316: ifnull +121 -> 437
    //   319: aload_0
    //   320: ldc_w 287
    //   323: invokevirtual 277	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   326: astore_0
    //   327: aload_0
    //   328: ifnonnull +101 -> 429
    //   331: ldc_w 279
    //   334: astore_0
    //   335: aload 5
    //   337: ldc_w 289
    //   340: aload_0
    //   341: invokestatic 283	sna:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_1
    //   345: ldc_w 291
    //   348: invokevirtual 277	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   351: astore_0
    //   352: aload_0
    //   353: ifnull +138 -> 491
    //   356: aload 5
    //   358: ldc_w 291
    //   361: aload_0
    //   362: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   365: invokestatic 283	sna:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 5
    //   370: iload_3
    //   371: invokestatic 296	sna:bD	(Ljava/lang/String;I)V
    //   374: return
    //   375: astore_0
    //   376: ldc 101
    //   378: iconst_1
    //   379: new 103	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 298
    //   389: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_0
    //   393: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aconst_null
    //   403: astore_0
    //   404: goto -167 -> 237
    //   407: aload_0
    //   408: getfield 241	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   411: invokevirtual 246	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   414: invokevirtual 304	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   417: astore_0
    //   418: goto -181 -> 237
    //   421: aload_0
    //   422: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   425: astore_0
    //   426: goto -128 -> 298
    //   429: aload_0
    //   430: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   433: astore_0
    //   434: goto -99 -> 335
    //   437: aload 5
    //   439: ldc_w 289
    //   442: ldc_w 279
    //   445: invokestatic 283	sna:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   448: goto -104 -> 344
    //   451: astore_0
    //   452: ldc 101
    //   454: iconst_1
    //   455: new 103	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 306
    //   465: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_0
    //   469: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: return
    //   479: astore_0
    //   480: ldc 101
    //   482: iconst_1
    //   483: ldc_w 308
    //   486: aload_0
    //   487: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: return
    //   491: aload 5
    //   493: ldc_w 291
    //   496: ldc_w 279
    //   499: invokestatic 283	sna:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -134 -> 368
    //   505: ldc 101
    //   507: iconst_1
    //   508: ldc_w 313
    //   511: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: return
    //   515: aconst_null
    //   516: astore_0
    //   517: goto -280 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	520	1	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   61	116	2	i	int
    //   20	351	3	j	int
    //   11	69	4	k	int
    //   4	488	5	str	String
    // Exception table:
    //   from	to	target	type
    //   225	237	375	java/lang/Exception
    //   273	290	451	java/lang/Exception
    //   298	315	451	java/lang/Exception
    //   319	327	451	java/lang/Exception
    //   335	344	451	java/lang/Exception
    //   344	352	451	java/lang/Exception
    //   356	368	451	java/lang/Exception
    //   368	374	451	java/lang/Exception
    //   421	426	451	java/lang/Exception
    //   429	434	451	java/lang/Exception
    //   437	448	451	java/lang/Exception
    //   491	502	451	java/lang/Exception
    //   0	60	479	java/lang/Exception
    //   62	76	479	java/lang/Exception
    //   82	99	479	java/lang/Exception
    //   101	162	479	java/lang/Exception
    //   169	177	479	java/lang/Exception
    //   180	192	479	java/lang/Exception
    //   196	221	479	java/lang/Exception
    //   241	273	479	java/lang/Exception
    //   376	402	479	java/lang/Exception
    //   407	418	479	java/lang/Exception
    //   452	478	479	java/lang/Exception
    //   505	514	479	java/lang/Exception
  }
  
  protected static void bD(String paramString, int paramInt)
  {
    b(paramString).edit().putInt("configVersion", paramInt).commit();
  }
  
  public static int bo(String paramString)
  {
    return b(paramString).getInt("configVersion", 0);
  }
  
  public static class a
  {
    public List<sna.b> dQ;
    public String title;
  }
  
  public static class b
  {
    public int height;
    public String imgUrl;
    public String jumpUrl;
    public int width;
  }
  
  public static class c
  {
    public String jumpUrl;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sna
 * JD-Core Version:    0.7.0.1
 */