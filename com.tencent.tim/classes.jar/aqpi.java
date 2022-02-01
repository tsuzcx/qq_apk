import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class aqpi
{
  public static aqpi.a a;
  public static aqpi.c a;
  public static aqpi.c[] a;
  public static aqpi.c b;
  public static aqpi.c c;
  public static String cuH = "https://i.gtimg.cn/xydata";
  public static aqpi.c d;
  public static aqpi.c e;
  public static aqpi.c f;
  public static aqpi.c g;
  public static aqpi.c h;
  public static aqpi.c i;
  public static HashMap<String, Boolean> pa = new HashMap();
  static aquy q = new aqpj();
  
  static
  {
    jdField_a_of_type_Aqpi$c = new aqpi.c("recommendEmotion.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    b = new aqpi.c("IndividuationUrls.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    c = new aqpi.c("Individuation.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    d = new aqpi.c("EmoticonWording.json", "", "https://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    e = new aqpi.c("WebviewCrashReport.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    f = new aqpi.c("Qutu_xydata.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    g = new aqpi.c("iRedPacket_v2.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    h = new aqpi.c("UrlIntercept.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    i = new aqpi.c("font_info.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    jdField_a_of_type_ArrayOfAqpi$c = new aqpi.c[] { jdField_a_of_type_Aqpi$c, c, d };
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, aqpi.c paramc, boolean paramBoolean)
  {
    Object localObject = paramQQAppInterface.getApplication().getApplicationContext();
    String str = paramc.cuN;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    if (((File)localObject).exists()) {
      try
      {
        paramQQAppInterface = aqhq.b((File)localObject, -1);
        if (paramQQAppInterface == null) {}
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface);
            return paramQQAppInterface;
          }
          catch (Throwable paramQQAppInterface)
          {
            QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile new Json err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
            ((File)localObject).delete();
          }
          paramQQAppInterface = paramQQAppInterface;
          QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
          paramQQAppInterface = null;
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.w("ClubContentJsonTask", 2, "getJsonFromLocalFile not exist,json_name:" + str + " _ " + paramBoolean);
      }
      if (paramBoolean) {
        a(paramQQAppInterface, paramc);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, aqpi.c paramc, String paramString, File paramFile, Bundle paramBundle)
  {
    if (paramFile == null) {}
    String str1;
    do
    {
      return;
      str1 = paramString;
    } while ((paramString == null) && (paramc == null));
    label424:
    label432:
    label438:
    label441:
    for (;;)
    {
      try
      {
        for (;;)
        {
          str1 = paramc.cuO;
          if (paramc == null) {
            break label424;
          }
          paramc = paramc.cuN;
          paramString = paramBundle.getString("method");
          if (paramString != null) {
            break label441;
          }
          paramString = "other";
          String str2 = paramBundle.getString("ifromet");
          if (str2 != null) {
            break label438;
          }
          str2 = "false";
          if (!paramBundle.containsKey("forceUpdate")) {
            break label432;
          }
          bool = paramBundle.getBoolean("forceUpdate");
          int j = paramBundle.getInt("version", 0);
          String str3 = paramc + "_" + j;
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "club_downloadFile,method:" + paramString + ",key:" + paramc + ", server version:" + j + ",ifromet:" + str2);
          }
          if ((!bool) && (pa.containsKey(str3)) && (((Boolean)pa.get(str3)).booleanValue())) {
            break;
          }
          pa.put(str3, Boolean.valueOf(true));
          paramFile = new aquz(str1, paramFile);
          paramFile.cWw = true;
          paramFile.key = paramc;
          ((aqva)paramAppInterface.getManager(47)).a(1).a(paramFile, q, paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramString + ",cdownloadFile url=" + str1);
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_key", paramc);
            paramString.put("param_ifromet", str2);
            anpc.a(paramAppInterface.getApplication().getApplicationContext()).collectPerformance(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramAppInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ClubContentJsonTask", 2, "downloadFile, downloadFile error=" + paramAppInterface.toString());
        break;
      }
      finally {}
      paramc = paramFile.getName();
      continue;
      boolean bool = false;
      continue;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aqpi.c paramc)
  {
    int j = 10;
    int k = 0;
    if ((paramQQAppInterface == null) || (paramc == null)) {}
    do
    {
      return;
      File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramc.cuN);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + paramc.cuN);
        }
        for (;;)
        {
          try
          {
            localObject = String.valueOf(NetConnInfoCenter.getServerTime());
            if (((String)localObject).length() <= 10) {
              continue;
            }
            localObject = ((String)localObject).substring(0, j);
            j = k;
            if (Long.parseLong((String)localObject) < 2147483647L) {
              j = Integer.parseInt((String)localObject);
            }
          }
          catch (Exception localException)
          {
            Object localObject;
            QLog.e("ClubContentJsonTask", 1, "downloadIfNotExist, Integer.parseInt Err:" + localException.getMessage());
            j = k;
            continue;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("version", j);
          ((Bundle)localObject).putString("version_key", paramc.cuQ);
          ((Bundle)localObject).putString("method", "downloadIfNotExist");
          ((Bundle)localObject).putString("ifromet", "null1");
          a(paramQQAppInterface, paramc, afgc.insertMtype("VIP_emosm", paramc.cuO), localFile, (Bundle)localObject);
          return;
          j = ((String)localObject).length();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aqpi.c paramc, int paramInt, boolean paramBoolean)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramc.cuN);
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", paramc.cuQ);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramQQAppInterface, paramc, null, localFile, localBundle);
  }
  
  public static void aP(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "setJsonVersion ,key=" + paramString + ",version:" + paramInt);
    }
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static int bI(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("clubContentVersion", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "--getJsonVersion ,key=" + paramString + ",version:" + paramContext.getInt(paramString, 0));
    }
    return paramContext.getInt(paramString, 0);
  }
  
  public static void eD(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getApplicationContext();
    int j = 0;
    while (j < jdField_a_of_type_ArrayOfAqpi$c.length)
    {
      a(paramQQAppInterface, jdField_a_of_type_ArrayOfAqpi$c[j]);
      j += 1;
    }
  }
  
  /* Error */
  public static void eE(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 473
    //   4: iconst_0
    //   5: aconst_null
    //   6: invokestatic 479	com/tencent/mobileqq/vas/VasQuickUpdateManager:getJSONFromLocal	(Lmqq/app/AppRuntime;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)Lorg/json/JSONObject;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: getstatic 485	ku:jdField_E_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: invokevirtual 491	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   24: new 6	aqpi$a
    //   27: dup
    //   28: invokespecial 492	aqpi$a:<init>	()V
    //   31: putstatic 494	aqpi:jdField_a_of_type_Aqpi$a	Laqpi$a;
    //   34: aload 6
    //   36: ldc_w 496
    //   39: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: ldc_w 501
    //   51: iload_1
    //   52: invokestatic 504	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: invokestatic 509	aqrs:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Z
    //   58: pop
    //   59: aload 6
    //   61: ldc_w 511
    //   64: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +689 -> 756
    //   70: aload 6
    //   72: ldc_w 511
    //   75: invokevirtual 518	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +168 -> 250
    //   85: aload 4
    //   87: invokevirtual 521	org/json/JSONArray:length	()I
    //   90: ifle +160 -> 250
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload 4
    //   98: invokevirtual 521	org/json/JSONArray:length	()I
    //   101: if_icmpge +149 -> 250
    //   104: aload 4
    //   106: iload_1
    //   107: invokevirtual 524	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   110: checkcast 187	org/json/JSONObject
    //   113: astore 5
    //   115: aload 5
    //   117: ldc_w 526
    //   120: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +639 -> 762
    //   126: aload 5
    //   128: ldc_w 526
    //   131: invokevirtual 528	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   134: istore_2
    //   135: goto +686 -> 821
    //   138: aload 5
    //   140: ldc_w 530
    //   143: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +621 -> 767
    //   149: aload 5
    //   151: ldc_w 530
    //   154: invokevirtual 531	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 4
    //   159: aload 5
    //   161: ldc_w 533
    //   164: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +666 -> 833
    //   170: aload 5
    //   172: ldc_w 533
    //   175: invokevirtual 531	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 5
    //   180: getstatic 494	aqpi:jdField_a_of_type_Aqpi$a	Laqpi$a;
    //   183: aload 4
    //   185: putfield 536	aqpi$a:cuI	Ljava/lang/String;
    //   188: getstatic 494	aqpi:jdField_a_of_type_Aqpi$a	Laqpi$a;
    //   191: aload 5
    //   193: putfield 539	aqpi$a:cuJ	Ljava/lang/String;
    //   196: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +51 -> 250
    //   202: ldc 192
    //   204: iconst_2
    //   205: new 194	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 541
    //   215: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_2
    //   219: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 543
    //   225: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 545
    //   236: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 6
    //   252: ldc_w 547
    //   255: invokevirtual 551	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +274 -> 536
    //   265: aload 4
    //   267: ldc_w 553
    //   270: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   273: iconst_1
    //   274: if_icmpne +573 -> 847
    //   277: iconst_1
    //   278: istore_3
    //   279: iload_3
    //   280: putstatic 556	ku:cC	Z
    //   283: getstatic 556	ku:cC	Z
    //   286: ifeq +488 -> 774
    //   289: aload 4
    //   291: ldc_w 558
    //   294: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   297: iconst_1
    //   298: if_icmpne +554 -> 852
    //   301: iconst_1
    //   302: istore_3
    //   303: iload_3
    //   304: putstatic 561	ku:cD	Z
    //   307: aload 4
    //   309: ldc_w 563
    //   312: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   315: d2f
    //   316: putstatic 570	ku:jdField_E_of_type_Float	F
    //   319: aload 4
    //   321: ldc_w 572
    //   324: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   327: d2f
    //   328: putstatic 575	ku:W	F
    //   331: aload 4
    //   333: ldc_w 577
    //   336: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   339: d2f
    //   340: putstatic 580	ku:X	F
    //   343: aload 4
    //   345: ldc_w 582
    //   348: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   351: d2f
    //   352: putstatic 585	ku:Y	F
    //   355: aload 4
    //   357: ldc_w 587
    //   360: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   363: d2f
    //   364: putstatic 589	ku:Z	F
    //   367: aload 4
    //   369: ldc_w 591
    //   372: invokevirtual 567	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   375: d2f
    //   376: putstatic 594	ku:aa	F
    //   379: aload 4
    //   381: ldc_w 596
    //   384: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   387: putstatic 600	ku:iD	I
    //   390: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +115 -> 508
    //   396: ldc 192
    //   398: iconst_2
    //   399: new 194	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 602
    //   409: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: getstatic 561	ku:cD	Z
    //   415: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: ldc_w 604
    //   421: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: getstatic 570	ku:jdField_E_of_type_Float	F
    //   427: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   430: ldc_w 609
    //   433: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 575	ku:W	F
    //   439: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   442: ldc_w 611
    //   445: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: getstatic 580	ku:X	F
    //   451: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   454: ldc_w 613
    //   457: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: getstatic 585	ku:Y	F
    //   463: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   466: ldc_w 615
    //   469: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: getstatic 589	ku:Z	F
    //   475: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   478: ldc_w 617
    //   481: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: getstatic 594	ku:aa	F
    //   487: invokevirtual 607	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   490: ldc_w 619
    //   493: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: getstatic 600	ku:iD	I
    //   499: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: getstatic 485	ku:jdField_E_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   511: iconst_1
    //   512: invokevirtual 491	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   515: getstatic 624	xov:f	Lcom/tencent/util/LRULinkedHashMap;
    //   518: astore 4
    //   520: aload 4
    //   522: monitorenter
    //   523: getstatic 624	xov:f	Lcom/tencent/util/LRULinkedHashMap;
    //   526: invokevirtual 629	com/tencent/util/LRULinkedHashMap:clear	()V
    //   529: aload 4
    //   531: monitorexit
    //   532: aload_0
    //   533: invokestatic 635	aqnl:H	(Lcom/tencent/common/app/AppInterface;)V
    //   536: aload 6
    //   538: ldc_w 637
    //   541: invokevirtual 551	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   544: astore_0
    //   545: aload_0
    //   546: ifnull +252 -> 798
    //   549: aload_0
    //   550: ldc_w 639
    //   553: iconst_0
    //   554: invokevirtual 641	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: iconst_1
    //   558: if_icmpne +299 -> 857
    //   561: iconst_1
    //   562: istore_3
    //   563: iload_3
    //   564: putstatic 646	com/tencent/mobileqq/app/SignatureManager:bJq	Z
    //   567: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +32 -> 602
    //   573: ldc_w 648
    //   576: iconst_2
    //   577: new 194	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 650
    //   587: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 646	com/tencent/mobileqq/app/SignatureManager:bJq	Z
    //   593: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 6
    //   604: ldc_w 652
    //   607: invokevirtual 551	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   610: astore_0
    //   611: aload_0
    //   612: ifnull +16 -> 628
    //   615: aload_0
    //   616: ldc_w 654
    //   619: sipush 300
    //   622: invokevirtual 641	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   625: putstatic 659	ahxs:dbR	I
    //   628: aload 6
    //   630: ldc_w 661
    //   633: invokevirtual 551	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   636: astore_0
    //   637: aload_0
    //   638: ifnull +68 -> 706
    //   641: aload_0
    //   642: ldc_w 663
    //   645: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   648: istore_1
    //   649: iload_1
    //   650: ifle +19 -> 669
    //   653: new 665	java/util/Random
    //   656: dup
    //   657: invokespecial 666	java/util/Random:<init>	()V
    //   660: iload_1
    //   661: invokevirtual 670	java/util/Random:nextInt	(I)I
    //   664: iconst_1
    //   665: iadd
    //   666: putstatic 675	la:iM	I
    //   669: getstatic 679	la:j	Ljava/util/concurrent/atomic/AtomicInteger;
    //   672: aload_0
    //   673: ldc_w 681
    //   676: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: invokevirtual 686	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   682: getstatic 689	la:L	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   685: astore 4
    //   687: aload_0
    //   688: ldc_w 691
    //   691: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   694: iconst_1
    //   695: if_icmpne +116 -> 811
    //   698: iconst_1
    //   699: istore_3
    //   700: aload 4
    //   702: iload_3
    //   703: invokevirtual 491	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   706: aload 6
    //   708: ldc_w 693
    //   711: invokevirtual 551	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   714: astore_0
    //   715: aload_0
    //   716: ifnull -700 -> 16
    //   719: getstatic 698	aqpm:en	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   722: astore 4
    //   724: aload_0
    //   725: ldc_w 553
    //   728: invokevirtual 499	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: iconst_1
    //   732: if_icmpne +84 -> 816
    //   735: iconst_1
    //   736: istore_3
    //   737: aload 4
    //   739: iload_3
    //   740: invokevirtual 491	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   743: return
    //   744: astore_0
    //   745: ldc 192
    //   747: iconst_1
    //   748: ldc_w 700
    //   751: aload_0
    //   752: invokestatic 703	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   755: return
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -679 -> 80
    //   762: iconst_m1
    //   763: istore_2
    //   764: goto +57 -> 821
    //   767: ldc 51
    //   769: astore 4
    //   771: goto -612 -> 159
    //   774: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq -269 -> 508
    //   780: ldc 192
    //   782: iconst_2
    //   783: ldc_w 705
    //   786: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -281 -> 508
    //   792: astore_0
    //   793: aload 4
    //   795: monitorexit
    //   796: aload_0
    //   797: athrow
    //   798: ldc_w 707
    //   801: iconst_1
    //   802: ldc_w 709
    //   805: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -206 -> 602
    //   811: iconst_0
    //   812: istore_3
    //   813: goto -113 -> 700
    //   816: iconst_0
    //   817: istore_3
    //   818: goto -81 -> 737
    //   821: iload_2
    //   822: ifeq -684 -> 138
    //   825: iload_2
    //   826: iconst_2
    //   827: if_icmpne +13 -> 840
    //   830: goto -692 -> 138
    //   833: ldc 51
    //   835: astore 5
    //   837: goto -657 -> 180
    //   840: iload_1
    //   841: iconst_1
    //   842: iadd
    //   843: istore_1
    //   844: goto -749 -> 95
    //   847: iconst_0
    //   848: istore_3
    //   849: goto -570 -> 279
    //   852: iconst_0
    //   853: istore_3
    //   854: goto -551 -> 303
    //   857: iconst_0
    //   858: istore_3
    //   859: goto -296 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	paramQQAppInterface	QQAppInterface
    //   42	802	1	j	int
    //   134	694	2	k	int
    //   278	581	3	bool	boolean
    //   113	723	5	localObject2	Object
    //   9	698	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	43	744	java/lang/Exception
    //   47	59	744	java/lang/Exception
    //   59	80	744	java/lang/Exception
    //   85	93	744	java/lang/Exception
    //   95	135	744	java/lang/Exception
    //   138	159	744	java/lang/Exception
    //   159	180	744	java/lang/Exception
    //   180	250	744	java/lang/Exception
    //   250	260	744	java/lang/Exception
    //   265	277	744	java/lang/Exception
    //   279	301	744	java/lang/Exception
    //   303	508	744	java/lang/Exception
    //   508	523	744	java/lang/Exception
    //   532	536	744	java/lang/Exception
    //   536	545	744	java/lang/Exception
    //   549	561	744	java/lang/Exception
    //   563	602	744	java/lang/Exception
    //   602	611	744	java/lang/Exception
    //   615	628	744	java/lang/Exception
    //   628	637	744	java/lang/Exception
    //   641	649	744	java/lang/Exception
    //   653	669	744	java/lang/Exception
    //   669	698	744	java/lang/Exception
    //   700	706	744	java/lang/Exception
    //   706	715	744	java/lang/Exception
    //   719	735	744	java/lang/Exception
    //   737	743	744	java/lang/Exception
    //   774	789	744	java/lang/Exception
    //   796	798	744	java/lang/Exception
    //   798	808	744	java/lang/Exception
    //   523	532	792	finally
    //   793	796	792	finally
  }
  
  public static class a
  {
    public String cuI;
    public String cuJ;
  }
  
  public static class b
    extends afom
  {
    public static int GIF;
    public static int MAGIC = 1;
    public static int SMALL = 5;
    public static int ebi = 2;
    public static int ebj;
    public static int ebk = 6;
    public static int ebl = 7;
    public static int ebm = 8;
    public static int ebn;
    public static int ebo = 1;
    public static int ebp = 6;
    public static int ebq = 1;
    public static int ebr = 2;
    public String bgColor;
    public boolean cVz;
    public String cuK;
    public String cuL;
    public String cuM;
    public String detailUrl;
    public int ebs;
    public int ebt;
    public int feeType;
    public String id;
    public String imgUrl;
    public int price;
    public int recommendType;
    public int type;
    
    static
    {
      GIF = 3;
      ebj = 4;
    }
  }
  
  public static class c
  {
    public String businessName;
    public JSONObject cb;
    public String cuN;
    public String cuO;
    public String cuP;
    public String cuQ;
    
    public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.cuN = paramString1;
      this.cuP = paramString2;
      this.cuO = paramString3;
      this.cuQ = paramString4;
      this.businessName = paramString5;
    }
    
    public JSONObject e(Context paramContext)
    {
      Object localObject = null;
      for (;;)
      {
        try
        {
          if (this.cb != null)
          {
            paramContext = this.cb;
            return paramContext;
          }
          if ((paramContext == null) || (TextUtils.isEmpty(this.cuN)))
          {
            QLog.e("TaskInfo", 1, "readLocalJsonFile, context or json_name null, context=" + paramContext + ", json_name=" + this.cuN);
            paramContext = localObject;
            continue;
          }
          paramContext = new File(paramContext.getFilesDir(), this.cuN);
        }
        finally {}
        if (paramContext.exists()) {
          paramContext = aqhq.readFileContent(paramContext);
        }
        try
        {
          this.cb = new JSONObject(paramContext);
          paramContext = this.cb;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            this.cb = null;
            QLog.e("TaskInfo", 1, "readLocalJsonFile, exception=" + MsfSdkUtils.getStackTraceString(paramContext));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpi
 * JD-Core Version:    0.7.0.1
 */