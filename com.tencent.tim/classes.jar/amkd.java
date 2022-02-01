import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amkd
{
  public static boolean cDa;
  public static String caC = "";
  
  public static int C(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("search_net_config_version_code" + paramString + AppSetting.getVersion(), -1);
      paramString = "";
    }
  }
  
  public static String C(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("net_search_cell_summary" + paramString, "");
      paramString = "";
    }
  }
  
  public static int IP()
  {
    return 1;
  }
  
  /* Error */
  public static void a(Context paramContext, com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config paramConfig, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: invokeinterface 74 1 0
    //   9: astore 9
    //   11: aload_2
    //   12: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +650 -> 665
    //   18: aload_2
    //   19: astore 8
    //   21: aload_1
    //   22: getfield 80	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   25: ifnull +633 -> 658
    //   28: aload_1
    //   29: getfield 80	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   32: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   35: ifle +623 -> 658
    //   38: aload_1
    //   39: getfield 80	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   42: iconst_0
    //   43: invokevirtual 89	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   46: checkcast 91	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +607 -> 658
    //   54: aload_1
    //   55: getfield 95	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 99	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   61: iconst_1
    //   62: if_icmpne +553 -> 615
    //   65: aload_1
    //   66: getfield 103	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   69: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   72: invokevirtual 114	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   75: invokestatic 120	akrf:inflateConfigString	([B)[B
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +516 -> 596
    //   83: new 122	java/lang/String
    //   86: dup
    //   87: aload_1
    //   88: ldc 124
    //   90: invokespecial 127	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_1
    //   94: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +28 -> 125
    //   100: ldc 135
    //   102: iconst_2
    //   103: new 31	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   110: ldc 137
    //   112: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: ifnull +532 -> 658
    //   129: new 143	org/json/JSONObject
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload_1
    //   139: ldc 148
    //   141: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 10
    //   146: aload_1
    //   147: ldc 154
    //   149: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   152: istore_3
    //   153: aload_1
    //   154: ldc 160
    //   156: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   159: istore 4
    //   161: aload_1
    //   162: ldc 162
    //   164: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   167: istore 5
    //   169: aload_1
    //   170: ldc 164
    //   172: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   175: istore 6
    //   177: aload_1
    //   178: ldc 166
    //   180: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   183: istore 7
    //   185: aload_1
    //   186: ldc 168
    //   188: ldc 169
    //   190: invokestatic 175	acfp:m	(I)Ljava/lang/String;
    //   193: invokevirtual 177	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 11
    //   198: aload 9
    //   200: new 31	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   207: ldc 58
    //   209: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 8
    //   214: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload 10
    //   222: invokeinterface 183 3 0
    //   227: pop
    //   228: aload 9
    //   230: new 31	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   237: ldc 185
    //   239: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload_1
    //   251: ldc 187
    //   253: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokeinterface 183 3 0
    //   261: pop
    //   262: aload 9
    //   264: new 31	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   271: ldc 189
    //   273: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 8
    //   278: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: iload_3
    //   285: invokeinterface 193 3 0
    //   290: pop
    //   291: aload 9
    //   293: new 31	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   300: ldc 195
    //   302: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 8
    //   307: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: iload 4
    //   315: invokeinterface 193 3 0
    //   320: pop
    //   321: aload 9
    //   323: new 31	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   330: ldc 197
    //   332: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: iload 5
    //   345: invokeinterface 193 3 0
    //   350: pop
    //   351: aload 9
    //   353: new 31	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   360: ldc 199
    //   362: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 8
    //   367: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: aload_1
    //   374: ldc 201
    //   376: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   379: invokeinterface 193 3 0
    //   384: pop
    //   385: aload 9
    //   387: new 31	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   394: ldc 203
    //   396: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 8
    //   401: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: aload_1
    //   408: ldc 205
    //   410: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   413: invokeinterface 193 3 0
    //   418: pop
    //   419: aload 9
    //   421: new 31	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   428: ldc 207
    //   430: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 8
    //   435: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: aload_1
    //   442: ldc 209
    //   444: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   447: invokeinterface 193 3 0
    //   452: pop
    //   453: aload 9
    //   455: new 31	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   462: ldc 211
    //   464: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 8
    //   469: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: iload 6
    //   477: invokeinterface 193 3 0
    //   482: pop
    //   483: aload 9
    //   485: new 31	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   492: ldc 213
    //   494: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 8
    //   499: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: iload 7
    //   507: invokeinterface 193 3 0
    //   512: pop
    //   513: aload 9
    //   515: new 31	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   522: ldc 215
    //   524: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 8
    //   529: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: aload 11
    //   537: invokeinterface 183 3 0
    //   542: pop
    //   543: aload 9
    //   545: invokeinterface 218 1 0
    //   550: pop
    //   551: aconst_null
    //   552: putstatic 223	amxh:ccp	Ljava/lang/String;
    //   555: return
    //   556: astore_1
    //   557: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +31 -> 591
    //   563: ldc 135
    //   565: iconst_2
    //   566: new 31	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   573: ldc 225
    //   575: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: invokevirtual 228	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   582: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aconst_null
    //   592: astore_1
    //   593: goto -499 -> 94
    //   596: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq +11 -> 610
    //   602: ldc 135
    //   604: iconst_2
    //   605: ldc 230
    //   607: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aconst_null
    //   611: astore_1
    //   612: goto -518 -> 94
    //   615: aload_1
    //   616: getfield 103	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   619: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   622: invokevirtual 233	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   625: astore_1
    //   626: goto -532 -> 94
    //   629: astore_1
    //   630: ldc 135
    //   632: iconst_2
    //   633: new 31	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   640: ldc 235
    //   642: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_1
    //   646: invokevirtual 236	java/lang/Exception:toString	()Ljava/lang/String;
    //   649: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload_0
    //   659: iconst_m1
    //   660: aload_2
    //   661: invokestatic 240	amkd:k	(Landroid/content/Context;ILjava/lang/String;)V
    //   664: return
    //   665: ldc 12
    //   667: astore 8
    //   669: goto -648 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	paramContext	Context
    //   0	672	1	paramConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   0	672	2	paramString	String
    //   152	133	3	i	int
    //   159	155	4	j	int
    //   167	177	5	k	int
    //   175	301	6	m	int
    //   183	323	7	n	int
    //   19	649	8	str1	String
    //   9	535	9	localEditor	SharedPreferences.Editor
    //   144	77	10	str2	String
    //   196	340	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   83	94	556	java/lang/Throwable
    //   129	555	629	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean2)
    {
      localSharedPreferences.edit().putBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, paramBoolean1).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateNeedRefreshModelList");
      return;
    }
    localSharedPreferences.edit().putBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, paramBoolean1).commit();
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateNeedRefreshModelList");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length - 1)
      {
        localStringBuilder.append(paramArrayOfInt[i]).append("_");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfInt[(paramArrayOfInt.length - 1)]);
    }
    paramArrayOfInt = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean)
    {
      paramArrayOfInt.edit().putString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, localStringBuilder.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateModelListByTab");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "setEntryListByTab, result = " + localStringBuilder.toString() + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
      }
      return;
      paramArrayOfInt.edit().putString("search_discovery_sp_prefix_unifypref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, localStringBuilder.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateModelListByTab");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (!paramBoolean)
    {
      paramBoolean = localSharedPreferences.getBoolean("search_discovery_sp_prefixrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, true);
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getNeedRefreshModelList");
      return paramBoolean;
    }
    paramBoolean = localSharedPreferences.getBoolean("search_discovery_sp_prefix_unifyrefresh_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, true);
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getNeedRefreshModelList");
    return paramBoolean;
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    String[] arrayOfString;
    if (!paramBoolean)
    {
      arrayOfString = ((SharedPreferences)localObject1).getString("search_discovery_sp_prefixpref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, "").split("_");
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getModelListByTab");
    }
    Object localObject2;
    for (;;)
    {
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        try
        {
          int[] arrayOfInt = new int[arrayOfString.length];
          int i = 0;
          for (;;)
          {
            localObject1 = arrayOfInt;
            if (i >= arrayOfString.length) {
              break;
            }
            arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
            i += 1;
          }
          arrayOfString = ((SharedPreferences)localObject1).getString("search_discovery_sp_prefix_unifypref_search_model_list" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramInt, "").split("_");
          QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getModelListByTab");
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, NumberFormatException, e = " + localNumberFormatException + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
          }
          localObject2 = null;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, "getEntryListByTab, result = " + localObject2 + ", uin = " + paramQQAppInterface.getCurrentAccountUin() + ", tabType = " + paramInt);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  public static int aj(String paramString, int paramInt)
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    int i = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString + str, paramInt);
    if (i == 0) {
      return paramInt;
    }
    return i;
  }
  
  public static void k(Context paramContext, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putInt("search_net_config_version_code" + paramString + AppSetting.getVersion(), paramInt);
      paramContext.commit();
      return;
      paramString = "";
    }
  }
  
  public static String yY()
  {
    String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_net_search_function_title" + str, acfp.m(2131714108));
  }
  
  public static String yZ()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str2 = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str1 = acfp.m(2131721084);
    if (TextUtils.isEmpty(amxh.ccp))
    {
      if (!amxh.oK(((QQAppInterface)localObject).getCurrentAccountUin())) {
        break label184;
      }
      localObject = BaseApplicationImpl.getContext();
      str1 = "";
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2;
      }
      str1 = PreferenceManager.getDefaultSharedPreferences((Context)localObject).getString("fts_search_bar_summary" + str1, "");
      if (!TextUtils.isEmpty(str1)) {
        amxh.ccp = str1;
      }
    }
    label184:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() searchBarWording=" + str1);
      }
      return str1;
      str1 = acfp.m(2131721084);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, "getFtsSearchBarWording() cache wording is not null. " + amxh.ccp);
      }
      str1 = amxh.ccp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkd
 * JD-Core Version:    0.7.0.1
 */