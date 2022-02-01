import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emoticon.EmojiManager.4;
import com.tencent.mobileqq.emoticon.EmojiManager.5;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afke
  implements Manager
{
  public static long Xv;
  public static afkd b;
  private static String bDJ = "json_";
  public static boolean bYs;
  public static boolean bYt;
  private static int cRq;
  private static int cRr = 1;
  public static int cRs;
  public static int cRt = 60000;
  public static int cRu = 1;
  public static int cRv = cRu + 1;
  public String TAG = afke.class.getSimpleName();
  aixk a;
  public JobQueue a;
  public boolean bYu;
  public boolean bYv;
  public boolean bYw;
  public int cKT = 3000000;
  int cRw = 0;
  public ConcurrentHashMap<String, aflh> fi = new ConcurrentHashMap();
  public HashMap<String, String> gO = new HashMap();
  Map<String, String> ki = new HashMap();
  QQAppInterface mApp = null;
  LRULinkedHashMap<String, ArrayList<String>> p = new LRULinkedHashMap(20);
  public aquy q = new afkf(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  aquy r = new afkg(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public aquy s = new afkh(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  
  public afke(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aixk = null;
    this.jdField_a_of_type_ComTencentImageJobQueue = new JobQueue(3);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aixk = ((aixk)this.mApp.getManager(83));
    b = afkd.a();
  }
  
  private void N(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoResID", paramString2);
    localHashMap.put("emoPackageID", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = anpc.a(BaseApplication.getContext());
    paramString2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.collectPerformance(paramString2, "NewAudioEmoticonVoiceDownload", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public static aflh a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (afke)paramAppRuntime.getManager(43);
      if (paramAppRuntime != null) {
        return (aflh)paramAppRuntime.fi.get(paramString);
      }
    }
    return null;
  }
  
  private Bundle a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, EmoticonPackage paramEmoticonPackage)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramInt2 == -1)
    {
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      switch (paramInt1)
      {
      default: 
        k = paramInt6;
        j = paramInt4;
        i = paramInt2;
      case 2: 
        paramInt1 = i;
        m = j;
        n = k;
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + i + " status=" + j + " progress=" + k);
          paramInt4 = k;
          paramInt2 = j;
          paramInt1 = i;
        }
        break;
      }
    }
    for (;;)
    {
      paramInt6 = paramInt2;
      paramInt2 = paramInt1;
      if (paramInt1 == -1)
      {
        paramInt2 = 0;
        paramInt6 = 0;
        paramInt4 = 0;
      }
      paramEmoticonPackage = new Bundle();
      paramEmoticonPackage.putString("id", paramString);
      paramEmoticonPackage.putInt("result", paramInt2);
      paramEmoticonPackage.putInt("status", paramInt6);
      paramEmoticonPackage.putInt("pluginStatus", paramInt5);
      paramEmoticonPackage.putLong("pluginSize", paramLong);
      paramEmoticonPackage.putInt("progress", paramInt4);
      paramEmoticonPackage.putInt("dEmojiId", paramInt7);
      paramEmoticonPackage.putInt("flag", paramInt3);
      paramEmoticonPackage.putStringArrayList("srcList", paramArrayList1);
      paramEmoticonPackage.putStringArrayList("urlParamsList", paramArrayList2);
      return paramEmoticonPackage;
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (lV(paramString)) {
        if (afnu.jx(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (lW(paramString)) {
        if (afnu.jx(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (a(paramString, Boolean.valueOf(true)))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (d(paramString, true, true))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      paramInt1 = paramInt2;
      m = paramInt4;
      n = paramInt6;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "getPackageStatus| query result in running... result=" + paramInt2 + " status=" + paramInt4 + " progress=" + paramInt6);
        n = paramInt6;
        m = paramInt4;
        paramInt1 = paramInt2;
      }
      paramInt4 = n;
      paramInt2 = m;
    }
  }
  
  /* Error */
  private Emoticon a(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 315	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: bipush 14
    //   11: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14: checkcast 317	ajdg
    //   17: astore 4
    //   19: aload 4
    //   21: aload_3
    //   22: invokevirtual 320	ajdg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   25: astore 5
    //   27: aload 4
    //   29: aload_3
    //   30: aload_1
    //   31: getfield 323	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   34: invokevirtual 326	ajdg:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   37: astore_2
    //   38: aload 5
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: ifnonnull +125 -> 169
    //   47: new 4	java/lang/Object
    //   50: dup
    //   51: invokespecial 71	java/lang/Object:<init>	()V
    //   54: astore_2
    //   55: new 328	afkj
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: aload_2
    //   62: invokespecial 331	afkj:<init>	(Lafke;Ljava/lang/String;Ljava/lang/Object;)V
    //   65: astore 5
    //   67: invokestatic 146	afkd:a	()Lafkd;
    //   70: aload 5
    //   72: invokevirtual 334	afkd:a	(Lafko;)V
    //   75: aload_0
    //   76: aload_3
    //   77: getstatic 60	afke:cRu	I
    //   80: invokevirtual 337	afke:ex	(Ljava/lang/String;I)V
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_2
    //   86: ldc2_w 338
    //   89: invokevirtual 343	java/lang/Object:wait	(J)V
    //   92: aload_2
    //   93: monitorexit
    //   94: invokestatic 146	afkd:a	()Lafkd;
    //   97: aload 5
    //   99: invokevirtual 345	afkd:b	(Lafko;)V
    //   102: aload 4
    //   104: aload_3
    //   105: invokevirtual 320	ajdg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   108: astore 5
    //   110: aload 4
    //   112: aload_3
    //   113: aload_1
    //   114: getfield 323	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   117: invokevirtual 326	ajdg:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   120: astore_2
    //   121: aload 5
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: astore_1
    //   128: aload_2
    //   129: ifnonnull +42 -> 171
    //   132: aload_0
    //   133: getfield 81	afke:TAG	Ljava/lang/String;
    //   136: iconst_1
    //   137: new 162	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 347
    //   147: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: areturn
    //   164: astore_1
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_2
    //   170: astore_1
    //   171: aload_1
    //   172: getfield 353	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   175: ifeq +21 -> 196
    //   178: aload_1
    //   179: getfield 353	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   182: iconst_2
    //   183: if_icmpeq +13 -> 196
    //   186: aload_1
    //   187: astore_2
    //   188: aload_1
    //   189: getfield 353	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   192: iconst_4
    //   193: if_icmpne -31 -> 162
    //   196: aload_1
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 356	com/tencent/mobileqq/data/Emoticon:hasEncryptKey	()Z
    //   202: ifne -40 -> 162
    //   205: new 358	java/util/ArrayList
    //   208: dup
    //   209: iconst_1
    //   210: invokespecial 359	java/util/ArrayList:<init>	(I)V
    //   213: astore_2
    //   214: aload_2
    //   215: aload_1
    //   216: invokevirtual 363	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   219: pop
    //   220: new 365	afkz
    //   223: dup
    //   224: invokespecial 366	afkz:<init>	()V
    //   227: astore 4
    //   229: aload_0
    //   230: aload_3
    //   231: aload_2
    //   232: aload 4
    //   234: invokevirtual 369	afke:a	(Ljava/lang/String;Ljava/util/ArrayList;Lafkz;)V
    //   237: aload_1
    //   238: astore_2
    //   239: aload 4
    //   241: getfield 372	afkz:bYL	Z
    //   244: ifne -82 -> 162
    //   247: aload_0
    //   248: getfield 81	afke:TAG	Ljava/lang/String;
    //   251: iconst_1
    //   252: new 162	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 374
    //   262: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 376
    //   272: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: getfield 323	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   279: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aconst_null
    //   289: areturn
    //   290: astore 6
    //   292: goto -200 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	afke
    //   0	295	1	paramEmoticon	Emoticon
    //   37	202	2	localObject1	Object
    //   4	262	3	str	String
    //   17	223	4	localObject2	Object
    //   25	97	5	localObject3	Object
    //   290	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   85	92	164	finally
    //   92	94	164	finally
    //   165	167	164	finally
    //   85	92	290	java/lang/InterruptedException
  }
  
  private void a(EmoticonPackage arg1, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, Emoticon paramEmoticon, String[] paramArrayOfString)
  {
    boolean bool;
    if (???.rscType == 1)
    {
      if (!aixo.nd(afnu.bEC.replace("[epId]", paramEmoticon.epId))) {
        break label154;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool)
      {
        paramList.add(paramArrayOfString[0]);
        paramMap.put(paramArrayOfString[0], new File(paramArrayOfString[1]));
        if (???.rscType != 1) {
          break label101;
        }
        paramBundle.putInt(paramArrayOfString[0], 16);
      }
      label101:
      while (???.jobType == 1)
      {
        return;
        bool = aqhq.fileExists(paramArrayOfString[1]);
        break;
      }
      paramBundle.putInt(paramArrayOfString[0], 7);
      synchronized (this.ki)
      {
        this.ki.put(paramArrayOfString[0], paramEmoticon.encryptKey);
        return;
      }
      label154:
      bool = false;
    }
  }
  
  private void a(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = b(paramEmoticon);
      if (!aqhq.fileExists(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramList = arrayOfString[0];
        if (paramEmoticon.jobType != 1) {
          break label148;
        }
      }
    }
    label148:
    for (paramInt = 15;; paramInt = 8)
    {
      paramBundle.putInt(paramList, paramInt);
      return;
    }
  }
  
  private boolean a(Emoticon paramEmoticon)
  {
    if (aqft.cC())
    {
      if (aqft.hE() < 1048576L)
      {
        QLog.d(this.TAG, 1, "sdcard check, sdcard full .return.");
        aqrm.b("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return true;
      }
    }
    else
    {
      QLog.d(this.TAG, 1, "sdcard check, has sdcard FALSE .return.");
      aqrm.b("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramFile = aqhq.readFileContent(paramFile);
    int j;
    int i;
    if (paramFile != null)
    {
      paramFile = paramFile.split("&");
      j = paramFile.length;
      i = 0;
      if (i < j)
      {
        String str = paramFile[i];
        if (new File(paramString3 + paramString2 + File.separator + str).exists()) {}
      }
    }
    label234:
    do
    {
      do
      {
        return false;
        i += 1;
        break;
        paramString2 = new File(paramString3 + "audio" + File.separator + "audio.ini");
      } while (!paramString2.exists());
      paramString2 = aqhq.readFileContent(paramString2);
      if (paramString2 != null)
      {
        paramString2 = paramString2.split("&");
        j = paramString2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label234;
          }
          paramFile = paramString2[i];
          if (!new File(paramString3 + "audio" + File.separator + paramFile).exists()) {
            break;
          }
          i += 1;
        }
      }
    } while (!Y(paramString1, cRr));
    return lZ(paramString1);
  }
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = afnu.bEg.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = afnu.bEs.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    for (paramString2 = str;; paramString2 = str)
    {
      return new String[] { paramString2, paramString1 };
      str = afnu.bEj.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = afnu.bEs.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
  }
  
  private boolean aT(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 == 1)) {}
    while (((paramInt1 == 3) && (paramInt2 == 3)) || ((paramInt1 == 4) && (paramInt2 == 5)) || ((paramInt1 == 5) && (paramInt2 == 4)) || ((paramInt1 == 1) && (paramInt2 == 0))) {
      return true;
    }
    return false;
  }
  
  private void b(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = a(paramEmoticon);
      if (!aqhq.fileExists(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramBundle.putInt(arrayOfString[0], 9);
        if (paramEmoticon.isNewSoundEmoticon()) {
          paramBundle.putString(arrayOfString[0] + "emoticonId", paramEmoticon.eId);
        }
      }
    }
  }
  
  private boolean b(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
      }
      Object localObject = c(paramEmoticon);
      bool1 = bool2;
      if (!aqhq.fileExists(localObject[1]))
      {
        localObject = new aquz(localObject[0], new File(localObject[1]));
        ((aquz)localObject).cWw = true;
        ((aquz)localObject).akN = cRt;
        paramInt = aqva.a((aquz)localObject, this.mApp);
        if (paramInt == 0) {
          break label291;
        }
        QLog.e(this.TAG, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
        aqrm.b("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(this.mApp.getApplication()) + "", paramInt + "", "", "", "");
        bool1 = true;
      }
    }
    label291:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "ret:" + paramInt);
    return false;
  }
  
  private boolean c(Emoticon paramEmoticon, int paramInt)
  {
    File localFile = null;
    boolean bool2 = false;
    boolean bool1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt & 0x4) != 4)
    {
      bool1 = bool2;
      if ((paramInt & 0x20) != 32) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      if (paramEmoticon.jobType == 1) {
        break label1062;
      }
      if ((paramInt & 0x20) != 32) {
        break label1057;
      }
      paramInt = 2;
      localObject1 = a(paramEmoticon, paramInt);
      localObject2 = new afkz();
      if ((paramEmoticon.jobType == 3) || (!TextUtils.isEmpty(paramEmoticon.encryptKey))) {
        break label277;
      }
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(paramEmoticon);
      a(paramEmoticon.epId, (ArrayList)localObject3, (afkz)localObject2);
      if (!TextUtils.isEmpty(paramEmoticon.encryptKey)) {
        break label277;
      }
      QLog.i(this.TAG, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
      aqrm.b("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      bool1 = true;
    }
    return bool1;
    for (;;)
    {
      label277:
      if (localObject1 == null) {
        return true;
      }
      boolean bool3 = aqhq.fileExists(localObject1[1]);
      if (!bool3)
      {
        localFile = new File(localObject1[1]);
        localObject1 = new aquz(localObject1[0], localFile);
        ((aquz)localObject1).cWw = true;
        ((aquz)localObject1).akN = cRt;
        paramInt = aqva.a((aquz)localObject1, this.mApp);
        if (paramInt != 0)
        {
          QLog.e(this.TAG, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + paramInt);
          aqrm.b("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(this.mApp.getApplication()) + "", paramInt + "", "", "", "");
          return true;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
        bool1 = bool2;
        if (paramEmoticon.jobType == 1) {
          break;
        }
        for (;;)
        {
          try
          {
            localObject2 = aqhq.fileToBytes(localFile);
            localObject3 = localFile.getAbsolutePath();
            localFile.delete();
            if (localObject2 == null)
            {
              QLog.e(this.TAG, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
              aqrm.b("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return true;
            }
            if (paramEmoticon.jobType != 3)
            {
              paramInt = afgc.a((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject3);
              if (paramInt != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.TAG, 2, "onProgress download encrypt exception, url=" + ((aquz)localObject1).currUrl);
                }
                if ((aqft.cC()) && (aqft.hE() > 1048576L)) {
                  aqhq.a(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localFile.getName()), (byte[])localObject2, false);
                }
                QLog.e(this.TAG, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + paramInt);
                aqrm.b("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", paramInt + "", "", "", "");
                return true;
              }
            }
            else
            {
              if (paramEmoticon.jobType != 3) {
                break label1046;
              }
              paramInt = afgc.a((byte[])localObject2, (String)localObject3);
              continue;
            }
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "onProgress| Emotiocon encode resource done.result=" + paramInt + " time:" + System.currentTimeMillis() + " url=" + ((aquz)localObject1).currUrl);
            return false;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((aquz)localObject1).currUrl);
            }
            aqrm.b("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return true;
          }
          label1046:
          paramInt = 0;
        }
        localObject1 = null;
      }
      label1057:
      paramInt = 0;
      break;
      label1062:
      localObject1 = null;
    }
  }
  
  private boolean d(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      Object localObject = b(paramEmoticon);
      bool1 = bool2;
      if (!aqhq.fileExists(localObject[1]))
      {
        localObject = new aquz(localObject[0], new File(localObject[1]));
        ((aquz)localObject).cWw = true;
        ((aquz)localObject).akN = cRt;
        paramInt = aqva.a((aquz)localObject, this.mApp);
        bool1 = bool2;
        if (paramInt != 0)
        {
          QLog.e(this.TAG, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          aqrm.b("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(this.mApp.getApplication()) + "", paramInt + "", "", "", "");
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean e(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramEmoticon.isSound)
    {
      bool1 = bool2;
      if ((paramInt & 0x8) == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        Object localObject = a(paramEmoticon);
        bool1 = bool2;
        if (!aqhq.fileExists(localObject[1]))
        {
          localObject = new aquz(localObject[0], new File(localObject[1]));
          ((aquz)localObject).cWw = true;
          ((aquz)localObject).akN = cRt;
          paramInt = aqva.a((aquz)localObject, this.mApp);
          if (paramInt == 0) {
            break label324;
          }
          QLog.e(this.TAG, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          aqrm.b("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, aqiw.getNetworkType(this.mApp.getApplication()) + "", paramInt + "", "", "", "");
          if (paramEmoticon.isNewSoundEmoticon()) {
            N(paramEmoticon.epId, paramEmoticon.eId, ((aquz)localObject).errCode);
          }
          bool1 = false;
        }
      }
    }
    label324:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!paramEmoticon.isNewSoundEmoticon());
    N(paramEmoticon.epId, paramEmoticon.eId, 0);
    return true;
  }
  
  public static boolean jj(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  private boolean lU(String paramString)
  {
    ??? = null;
    try
    {
      synchronized (this.p)
      {
        if (this.p.containsKey(paramString)) {
          ??? = (ArrayList)this.p.get(paramString);
        }
        ??? = ???;
        if (??? != null) {
          break label223;
        }
        ??? = new File(afnu.bEA.replace("[epId]", paramString));
        boolean bool = ((File)???).exists();
        if (!bool) {
          return false;
        }
      }
      ??? = new JSONObject(aqhq.readFileToString((File)???));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
      }
      return false;
    }
    ??? = new ArrayList();
    ??? = ((JSONObject)???).getJSONArray("fileList");
    int j = ((JSONArray)???).length();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = ((JSONArray)???).getString(i);
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)???).add(str);
        }
      }
      else
      {
        synchronized (this.p)
        {
          this.p.put(paramString, ???);
          label223:
          if (??? != null)
          {
            paramString = ((ArrayList)???).iterator();
            while (paramString.hasNext())
            {
              ??? = new File((String)paramString.next());
              if ((??? != null) && (!((File)???).exists()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.TAG, 2, "checkH5MagicFacePackageIntact, file miss: " + ???);
                }
                return false;
              }
            }
          }
        }
        return true;
      }
      i += 1;
    }
  }
  
  boolean A(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (ArrayList)a().az(paramString);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (Emoticon)((Iterator)localObject).next();
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)localObject).jobType == 4) && ((((Emoticon)localObject).encryptKey == null) || (((Emoticon)localObject).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
          if (!new File(afnu.bEs.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    Object localObject = new File(afnu.bEy.replace("[epId]", paramString));
    if ((localObject != null) && (!((File)localObject).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkH5MagicFacePackageIntact, no root path: " + localObject);
      }
      return false;
    }
    return lU(paramString);
  }
  
  public void HX(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (aflh)this.fi.get(paramString);
    } while (paramString == null);
    paramString.cN(this.mApp);
  }
  
  public boolean Y(String paramString, int paramInt)
  {
    String str3 = afnu.bEq.replace("[epId]", paramString);
    String str1;
    int i;
    if (paramInt == cRr)
    {
      String str2 = aiyf.getVideoPath();
      str1 = str3 + str2 + File.separator + "video.ini";
      File localFile = new File(str1);
      paramString = localFile;
      if (!localFile.exists())
      {
        str2 = "big";
        str1 = str3 + "big" + File.separator + "video.ini";
        localFile = new File(str1);
        paramString = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "videoConfigPath ==" + str1);
      }
      paramString = aqhq.readFileContent(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + str2 + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == cRq)
    {
      paramString = new File(str3 + "audio" + File.separator + "audio.ini");
      if (!paramString.exists()) {
        return false;
      }
      paramString = aqhq.readFileContent(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public int a(Emoticon paramEmoticon)
  {
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(this.TAG, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return MarketFaceItemBuilder.a(null, this.mApp, paramEmoticon, null);
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(i);
      Object localObject;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        if (!aqhq.fileExists(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label388;
          }
        }
      }
      label388:
      for (int j = 15;; j = 6)
      {
        paramBundle.putInt((String)localObject, j);
        if (((paramInt & 0x4) != 4) && ((paramInt & 0x20) != 32)) {
          break label413;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = null;
        if (paramEmoticonPackage.jobType != 1)
        {
          if (!localEmoticon.hasEncryptKey()) {
            break;
          }
          j = paramEmoticonPackage.rscType;
          if ((paramInt & 0x20) == 32) {
            j = 2;
          }
          localObject = a(localEmoticon, j);
        }
        if (localObject != null) {
          break label399;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
      }
      return 11009;
      label399:
      a(paramEmoticonPackage, paramList, paramMap, paramBundle, localEmoticon, (String[])localObject);
      label413:
      a(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      b(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      i += 1;
    }
    return 0;
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        String[] arrayOfString = c((Emoticon)localObject);
        if ((!aqhq.fileExists(arrayOfString[1])) || (paramBoolean))
        {
          paramList.add(arrayOfString[0]);
          paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
          paramBundle.putInt(arrayOfString[0], 6);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = a((Emoticon)localObject, paramEmoticonPackage.rscType);
        if ((!aqhq.fileExists(localObject[1])) || (paramBoolean)) {
          paramList.add(localObject[0]);
        }
        paramMap.put(localObject[0], new File(localObject[1]));
        paramBundle.putInt(localObject[0], 7);
      }
      i += 1;
    }
    return 0;
  }
  
  int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    afkz localafkz = new afkz();
    byte[] arrayOfByte = null;
    if (paramFile != null) {}
    label522:
    for (;;)
    {
      try
      {
        if (paramFile.exists())
        {
          arrayOfByte = aqhq.fileToBytes(paramFile);
          if (paramEmoticonPackage.jobType == 4)
          {
            paramFile = afkp.a(this.mApp, paramEmoticonPackage, cRu, arrayOfByte, localArrayList);
            if (paramEmoticonPackage.isAPNG != 2) {
              break label522;
            }
            paramInt |= 0x20;
            if (paramFile == null) {
              continue;
            }
            QLog.e(this.TAG, 1, "addEmotionsTask| parse json error");
            aqrm.b("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
            return 11008;
          }
        }
        else
        {
          arrayOfByte = null;
          continue;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        QLog.e(this.TAG, 1, "OutOfMemoryError e = " + paramFile.getMessage());
        arrayOfByte = null;
        continue;
        paramFile = afkp.a(this.mApp, paramEmoticonPackage, cRu, arrayOfByte, localArrayList, localafkz);
        continue;
        if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!aqqi.bV(paramEmoticonPackage.minQQVersion, "3.4.4")))
        {
          QLog.e(this.TAG, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
          return 11011;
        }
        paramBundle.putBoolean("isUpdate", paramBoolean);
        paramBundle.putSerializable("emoticonList", localArrayList);
        if ((!localafkz.bYL) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localafkz.bDO = null;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          a(paramEmoticonPackage.epId, localArrayList, localafkz);
          int j = i + 1;
          if (!localafkz.bYL)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localafkz.bYL);
          }
          if (!localafkz.bYL)
          {
            QLog.e(this.TAG, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localafkz.bDO + " encryptKeysResultCode" + localafkz.cRP);
            return 11009;
          }
        }
        if (paramEmoticonPackage.jobType == 4) {
          return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt, paramBoolean);
        }
        return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt);
      }
    }
  }
  
  public ajdg a()
  {
    return (ajdg)this.mApp.getManager(14);
  }
  
  Bundle a(String paramString, int paramInt1, int paramInt2)
  {
    int m = -1;
    int i = 0;
    int n = 0;
    int i1 = 0;
    EmoticonPackage localEmoticonPackage = a().c(paramString, paramInt2);
    paramInt2 = i;
    if (localEmoticonPackage != null) {
      if (!localEmoticonPackage.valid) {
        break label133;
      }
    }
    label133:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 == 2) {
        paramInt2 = 1;
      }
      aflh localaflh = (aflh)this.fi.get(paramString);
      int k = m;
      int j = n;
      i = i1;
      if (localaflh != null)
      {
        k = m;
        j = n;
        i = i1;
        if (!localaflh.isCancel())
        {
          k = 0;
          i = (int)localaflh.ba();
          j = 2;
        }
      }
      return a(paramString, paramInt1, k, paramInt2, j, 0, 0L, i, -1, null, null, localEmoticonPackage);
    }
  }
  
  public aqvc a()
  {
    return ((aqva)this.mApp.getManager(47)).a(1);
  }
  
  public void a(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    boolean bool1 = paramBundle.getBoolean("newPkgAdd", false);
    boolean bool2 = paramBundle.getBoolean("isUpdate", false);
    boolean bool3 = paramBundle.getBoolean("wifiAutoDownload", true);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    int i;
    if ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      i = 1;
      label69:
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramObject + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (!paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          paramInt2 = afgc.hg(paramInt1);
          QLog.e(this.TAG, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramInt1);
          b.a(localEmoticonPackage, paramInt2, this.mApp);
          aqrm.b("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramInt1 + "", "", "", "");
          a(localEmoticonPackage, paramInt2, 0L, paramString);
          if (!bool1) {
            break;
          }
          if (localEmoticonPackage.type != 1) {
            break label319;
          }
          paramInt1 = 5;
          ajdg.ew(String.valueOf(paramInt2), paramInt1);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e(this.TAG, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
          return;
        }
        i = 0;
        break label69;
        label319:
        paramInt1 = 4;
      }
    }
    if ((bool2) && (i == 0))
    {
      paramBundle = (ArrayList)paramBundle.getSerializable("emoticonList");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        a().N(localEmoticonPackage.epId, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + paramBundle.size());
        }
      }
    }
    for (;;)
    {
      localEmoticonPackage.updateFlag &= 0xFFFFFFFE;
      localEmoticonPackage.status = 2;
      localEmoticonPackage.valid = true;
      paramBundle = a();
      paramBundle.m(localEmoticonPackage);
      if (localEmoticonPackage.jobType != 5) {
        break label602;
      }
      paramObject = this.mApp.a().createEntityManager();
      Object localObject = paramObject.query(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        d(((EmoticonPackage)((Iterator)localObject).next()).epId, true, true);
      }
      if (localEmoticonPackage.latestVersion > localEmoticonPackage.localVersion) {
        localEmoticonPackage.localVersion = localEmoticonPackage.latestVersion;
      }
      localEmoticonPackage.hasReadUpdatePage = false;
    }
    paramObject.close();
    label602:
    if (bool1) {}
    try
    {
      paramBundle.fh(localEmoticonPackage.epId, paramInt2);
      b.a(localEmoticonPackage, this.mApp);
      if (!bool3) {
        localEmoticonPackage.extraFlags |= 0x2;
      }
      b.h(localEmoticonPackage);
      a(localEmoticonPackage, 0, paramLong, paramString);
      return;
    }
    finally {}
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i = 0;
    if (paramInt != 0) {
      i = 1;
    }
    paramInt = aqiw.getSystemNetwork(this.mApp.getApp().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      anot.a(this.mApp, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i, paramEmoticonPackage.epId + "", paramInt + "", paramString, String.valueOf(paramLong));
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, aquy paramaquy, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.mApp == null))
    {
      QLog.e(this.TAG, 1, "ep or mApp = null");
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e(this.TAG, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
      b.a(paramEmoticonPackage, 11003, this.mApp);
      aqrm.b("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putInt("businessType", paramInt);
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    Object localObject1;
    label248:
    Object localObject2;
    label267:
    label370:
    File localFile;
    if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading))
    {
      localObject1 = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
      if (paramEmoticonPackage.jobType == 3)
      {
        e(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        localObject2 = new aquz(localArrayList, localHashMap, (String)localObject1);
        if (!((String)localObject1).contains("auto")) {
          this.fi.put(paramEmoticonPackage.epId, new aflh(paramEmoticonPackage.epId, (aquz)localObject2));
        }
        ((aquz)localObject2).cWw = true;
        if (localArrayList.size() != 0) {
          break label986;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handleEmotionPackage| urlList is empty");
        }
        ((aquz)localObject2).dy(localBundle);
        ((aquz)localObject2).setStatus(3);
        paramaquy.onDone((aquz)localObject2);
        if (paramEmoticonPackage.jobType != 5) {
          break label1018;
        }
        b(paramEmoticonPackage, paramBoolean1);
      }
    }
    else
    {
      if (paramEmoticonPackage.jobType == 5)
      {
        ((aqrc)this.mApp.getManager(235)).a.a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
        return;
      }
      localObject2 = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      localObject1 = afgc.kw(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.jobType == 4) {
        localObject1 = afnu.bEf.replace("[epId]", paramEmoticonPackage.epId);
      }
      localFile = new File(afnu.bEu.replace("[epId]", paramEmoticonPackage.epId));
      localObject1 = new aquz((String)localObject1, localFile);
      aflh localaflh = new aflh(paramEmoticonPackage.epId, (aquz)localObject1);
      this.fi.put(bDJ + paramEmoticonPackage.epId, localaflh);
      ((aquz)localObject1).cWp = bYt;
      ((aquz)localObject1).cWs = true;
      ((aquz)localObject1).cWw = true;
      paramInt = aqva.a((aquz)localObject1, this.mApp);
      this.fi.remove(bDJ + paramEmoticonPackage.epId);
      b.b(paramEmoticonPackage, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.TAG, 1, "json download faile : resultCode = " + paramInt);
        paramInt = afgc.hg(paramInt);
        b.a(paramEmoticonPackage, paramInt, this.mApp);
        aqrm.b("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", aqiw.getNetworkType(this.mApp.getApplication()) + "", paramInt + "", "", "", "");
        return;
      }
      paramBoolean2 = afnu.a(paramEmoticonPackage);
      if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
        a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      }
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramInt = 42;
        label815:
        if (paramEmoticonPackage.jobType != 5) {
          break label947;
        }
        paramInt = 6;
      }
    }
    label1027:
    for (;;)
    {
      paramInt = a(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, localBundle, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.TAG, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + paramInt);
        b.a(paramEmoticonPackage, paramInt, this.mApp);
        aqrm.b("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", paramInt + "", "", "", "");
        return;
        paramInt = 14;
        break label815;
        label947:
        if (paramEmoticonPackage.jobType != 3) {
          break label1027;
        }
        paramInt |= 0x1;
        continue;
        if (paramEmoticonPackage.jobType != 5) {
          break label267;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break label267;
        label986:
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handleEmotionPackage| startDownload");
        }
        a().a((aquz)localObject2, paramaquy, localBundle);
        break label370;
        label1018:
        break;
      }
      localObject1 = localObject2;
      break label248;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    a(paramEmoticonPackage, paramBoolean, true, 0);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    a(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (this.mApp == null)) {}
    Object localObject;
    label137:
    do
    {
      return;
      if (paramInt == 0) {
        paramEmoticonPackage.aio = true;
      }
      aflh localaflh;
      for (;;)
      {
        localObject = (aflh)this.fi.get(paramEmoticonPackage.epId);
        localaflh = (aflh)this.fi.get(bDJ + paramEmoticonPackage.epId);
        if (localObject == null) {
          break label137;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(this.TAG, 2, "pullEmoticonPackage task exist epId = " + paramEmoticonPackage.epId);
        return;
        if (paramInt == 1) {
          paramEmoticonPackage.kandian = true;
        }
      }
      if (localaflh == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.TAG, 2, "pullEmoticonPackage jsonTask exist epId = " + paramEmoticonPackage.epId);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!afgc.lO(paramEmoticonPackage.epId))
    {
      QLog.e(this.TAG, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      aqrm.b("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!afnu.jx(paramEmoticonPackage.updateFlag))) {
        break label415;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().m(paramEmoticonPackage);
      localObject = new File(acbn.bmM);
      if (!((File)localObject).exists())
      {
        boolean bool = ((File)localObject).mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.excute(new EmojiManager.5(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 128, null, true);
      return;
      label415:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    a(paramString, paramInt, paramBundle, paramBoolean, 0);
  }
  
  public void a(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageJobQueue.execute(new EmojiManager.4(this, paramBoolean, paramString, paramInt2, paramInt1, paramBundle), 128, true);
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList, afkz paramafkz)
  {
    int i = afgc.cL(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramafkz == null) || (i == -1)) {
      return;
    }
    paramString = new Object();
    acdz localacdz = (acdz)this.mApp.getBusinessHandler(12);
    localacdz.a(new afki(this, localacdz, paramafkz, paramString));
    int j = this.cRw;
    this.cRw = (j + 1);
    String str = Integer.toString(j);
    paramafkz.bDO = str;
    paramafkz.cRP = 11022;
    localacdz.a(i, paramArrayList, str);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void a(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int j;
    int i;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      j = 13;
      i = 14;
    }
    for (;;)
    {
      String str2 = afgc.A(j, str1);
      String str3 = afgc.z(3, paramEmoticonPackage.epId);
      if (!aqhq.fileExists(str3))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        paramBundle.putInt(str2, 3);
      }
      str1 = afgc.A(i, str1);
      paramEmoticonPackage = afgc.z(4, paramEmoticonPackage.epId);
      if (!aqhq.fileExists(paramEmoticonPackage))
      {
        paramList.add(str1);
        paramMap.put(str1, new File(paramEmoticonPackage));
        paramBundle.putInt(str1, 4);
      }
      return;
      if (paramEmoticonPackage.jobType == 4)
      {
        str1 = paramEmoticonPackage.epId;
        j = 17;
        i = 18;
      }
      else
      {
        j = 3;
        i = 4;
      }
    }
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
      }
    } while ((a(paramEmoticon)) || (b(paramEmoticon, paramInt)) || (c(paramEmoticon, paramInt)) || (d(paramEmoticon, paramInt)));
    return e(paramEmoticon, paramInt);
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    cd(paramString, bool);
    return bool;
  }
  
  String[] a(Emoticon paramEmoticon)
  {
    return new String[] { afnu.bEh.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), afnu.bEr.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3)
    {
      str1 = afnu.bEd.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt != 2) {}
    }
    boolean bool;
    for (String str1 = afnu.bEe.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = afnu.bEi.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = afnu.bEv.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str2 = afnu.bEw.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      paramEmoticon = str2;
      if (1 == paramInt)
      {
        paramEmoticon = str2;
        if (!TextUtils.isEmpty(str2)) {
          paramEmoticon = str2 + ".zip";
        }
      }
      return new String[] { str1, paramEmoticon };
      bool = d(paramEmoticon);
      if (1 != paramInt) {
        break;
      }
    }
    if (paramInt == 2)
    {
      str2 = afnu.bEl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        str1 = String.valueOf(paramEmoticon.extensionWidth);
        label265:
        str2 = str2.replace("[width]", str1);
        if (!bool) {
          break label313;
        }
      }
      label313:
      for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
      {
        str1 = str2.replace("[height]", str1);
        break;
        str1 = "200";
        break label265;
      }
    }
    String str2 = afnu.bEk.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    if (bool)
    {
      str1 = String.valueOf(paramEmoticon.extensionWidth);
      label364:
      str2 = str2.replace("[width]", str1);
      if (!bool) {
        break label412;
      }
    }
    label412:
    for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
    {
      str1 = str2.replace("[height]", str1);
      break;
      str1 = "200";
      break label364;
    }
  }
  
  public boolean ajr()
  {
    boolean bool2 = false;
    boolean bool3 = this.mApp.getApplication().getSharedPreferences("h5magic_sp_name", 4).getBoolean("h5magic_sp_isplay_key", false);
    boolean bool4 = ajs();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean ajs()
  {
    return DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.h5magic_support.name());
  }
  
  public boolean ajt()
  {
    if (cRs == 4) {
      if (System.currentTimeMillis() - Xv > 15000L)
      {
        cRs = 0;
        bYs = false;
      }
    }
    do
    {
      return true;
      return false;
      cRs += 1;
    } while ((cRs != 4) || (bYs));
    bYs = true;
    Xv = System.currentTimeMillis();
    return true;
  }
  
  public void am(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, null, false, paramInt2);
  }
  
  void b(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramEmoticonPackage.childEpId)) || ("0".equals(paramEmoticonPackage.childEpId)) || (this.mApp == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (acdz)this.mApp.getBusinessHandler(12);
      if (localObject != null) {
        ((acdz)localObject).dt(paramEmoticonPackage.childEpId, 0);
      }
    }
    EmoticonPackage localEmoticonPackage = a().c(paramEmoticonPackage.childEpId, 0);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleEmotionPackage| auto download childEp = " + localObject);
    }
    a((EmoticonPackage)localObject, paramBoolean);
  }
  
  void b(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 4) {}
    for (int i = 19;; i = 2)
    {
      if (paramEmoticonPackage.jobType == 2) {}
      for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
      {
        str = afgc.A(i, str);
        paramEmoticonPackage = afgc.z(2, paramEmoticonPackage.epId);
        if (!aqhq.fileExists(paramEmoticonPackage))
        {
          paramList.add(str);
          paramMap.put(str, new File(paramEmoticonPackage));
          paramBundle.putInt(str, 2);
        }
        return;
      }
    }
  }
  
  public boolean b(Emoticon paramEmoticon)
  {
    afpu localafpu = new afpu(this.mApp.getCurrentAccountUin());
    localafpu.type = 6;
    localafpu.isAPNG = paramEmoticon.isAPNG;
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(this.TAG, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localafpu.e = paramEmoticon;
    MarketFaceItemBuilder.b = localafpu;
    return true;
  }
  
  boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().az(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(afnu.bEs.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str2 = aiyf.getVideoPath();
    String str3 = afnu.bEq.replace("[epId]", paramString);
    String str1 = str3 + str2 + File.separator + "video.ini";
    File localFile = new File(str1);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str2 = "big";
      str1 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str1);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "videoConfigPath ==" + str1);
    }
    return a(paramString, str2, str3, paramBoolean);
  }
  
  String[] b(Emoticon paramEmoticon)
  {
    Object localObject = null;
    String str;
    if (paramEmoticon.jobType != 1)
    {
      boolean bool = d(paramEmoticon);
      str = afnu.bEm.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        localObject = String.valueOf(paramEmoticon.extensionWidth);
        str = str.replace("[width]", (CharSequence)localObject);
        if (!bool) {
          break label135;
        }
        localObject = String.valueOf(paramEmoticon.extensionHeight);
        label81:
        localObject = str.replace("[height]", (CharSequence)localObject);
        paramEmoticon = afnu.bEt.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramEmoticon };
      localObject = "200";
      break;
      label135:
      localObject = "200";
      break label81;
      str = null;
      paramEmoticon = (Emoticon)localObject;
      localObject = str;
    }
  }
  
  void c(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!Y(paramEmoticonPackage.epId, cRr))
    {
      String str = afgc.ai(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = afnu.bEB.replace("[epId]", paramEmoticonPackage.epId);
      if (!aqhq.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  /* Error */
  public boolean c(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: sipush 149
    //   7: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 1444	afhu
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 1448	afhu:ez	()Ljava/util/List;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: bipush 14
    //   28: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   31: checkcast 317	ajdg
    //   34: aload_1
    //   35: getfield 315	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   38: invokevirtual 320	ajdg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   41: ifnonnull +14 -> 55
    //   44: aload_0
    //   45: aload_1
    //   46: getfield 315	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   49: getstatic 60	afke:cRu	I
    //   52: invokevirtual 337	afke:ex	(Ljava/lang/String;I)V
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 1450	afke:bYu	Z
    //   62: ifne +121 -> 183
    //   65: aload 4
    //   67: ifnull +16 -> 83
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 1452 1 0
    //   80: ifeq +103 -> 183
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 1450	afke:bYu	Z
    //   88: invokestatic 1453	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   91: invokestatic 1064	aqiw:isNetSupport	(Landroid/content/Context;)Z
    //   94: ifne +5 -> 99
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: bipush 103
    //   105: invokevirtual 139	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   108: checkcast 1455	afhv
    //   111: astore 6
    //   113: aload 4
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 1458	afhv:ajh	()Z
    //   121: ifeq +62 -> 183
    //   124: new 4	java/lang/Object
    //   127: dup
    //   128: invokespecial 71	java/lang/Object:<init>	()V
    //   131: astore_3
    //   132: new 1460	afkk
    //   135: dup
    //   136: aload_0
    //   137: aload_3
    //   138: invokespecial 1463	afkk:<init>	(Lafke;Ljava/lang/Object;)V
    //   141: astore 4
    //   143: aload_0
    //   144: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   147: aload 4
    //   149: invokevirtual 1467	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lacci;)V
    //   152: aload 6
    //   154: invokevirtual 1470	afhv:cZq	()V
    //   157: aload_3
    //   158: monitorenter
    //   159: aload_3
    //   160: ldc2_w 338
    //   163: invokevirtual 343	java/lang/Object:wait	(J)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aload_0
    //   169: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: aload 4
    //   174: invokevirtual 1473	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   177: aload 5
    //   179: invokevirtual 1448	afhu:ez	()Ljava/util/List;
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull -87 -> 97
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: aload_3
    //   191: invokeinterface 1004 1 0
    //   196: if_icmpge -99 -> 97
    //   199: aload_3
    //   200: iload_2
    //   201: invokeinterface 1474 2 0
    //   206: checkcast 1476	com/tencent/mobileqq/data/CustomEmotionData
    //   209: astore 4
    //   211: aload 4
    //   213: getfield 1479	com/tencent/mobileqq/data/CustomEmotionData:isMarkFace	Z
    //   216: ifeq +54 -> 270
    //   219: aload 4
    //   221: getfield 1482	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   224: aload_1
    //   225: getfield 315	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   228: invokevirtual 1379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +39 -> 270
    //   234: aload 4
    //   236: getfield 1483	com/tencent/mobileqq/data/CustomEmotionData:eId	Ljava/lang/String;
    //   239: aload_1
    //   240: getfield 323	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   243: invokevirtual 1379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +24 -> 270
    //   249: ldc_w 1485
    //   252: aload 4
    //   254: getfield 1488	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   257: invokevirtual 1379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifne -163 -> 97
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_1
    //   266: aload_3
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: iload_2
    //   271: iconst_1
    //   272: iadd
    //   273: istore_2
    //   274: goto -85 -> 189
    //   277: astore 6
    //   279: goto -113 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	afke
    //   0	282	1	paramEmoticon	Emoticon
    //   188	86	2	i	int
    //   57	210	3	localObject1	Object
    //   20	233	4	localObject2	Object
    //   13	165	5	localafhu	afhu
    //   111	42	6	localafhv	afhv
    //   277	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   159	166	265	finally
    //   166	168	265	finally
    //   266	268	265	finally
    //   159	166	277	java/lang/InterruptedException
  }
  
  public boolean c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().b(paramString) != null) {}
    for (int i = 1;; i = 0) {
      return (i != 0) && (d(paramString, paramBoolean1, paramBoolean2));
    }
  }
  
  String[] c(Emoticon paramEmoticon)
  {
    String str1 = paramEmoticon.epId;
    String str2 = paramEmoticon.eId;
    if (paramEmoticon.jobType == 3) {}
    for (boolean bool = true;; bool = false) {
      return a(str1, str2, bool);
    }
  }
  
  void cd(String paramString, boolean paramBoolean)
  {
    paramString = a().b(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label39;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().m(paramString);
      }
    }
    label39:
    while (paramString.status == 0) {
      return;
    }
    paramString.status = 0;
    a().m(paramString);
  }
  
  public Bundle d(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (aflh)this.fi.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramString.a(this.mApp);
      paramString.cN(this.mApp);
      if (localBundle != null)
      {
        paramString = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        if (paramString != null) {
          b.a(paramString, 11007, this.mApp);
        }
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    paramString.putInt("sceneType", paramInt);
    return paramString;
  }
  
  void d(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!Y(paramEmoticonPackage.epId, cRq))
    {
      String str = afgc.ai(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = afnu.bEB.replace("[epId]", paramEmoticonPackage.epId);
      if (!aqhq.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean d(Emoticon paramEmoticon)
  {
    return (paramEmoticon != null) && (paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0);
  }
  
  public boolean d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = A(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().b(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = A(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        cd(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label220:
          cd(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label220;
      paramBoolean1 = true;
      break;
      paramBoolean1 = bool2;
    }
  }
  
  public float e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1.0F;
    }
    paramString = (aflh)this.fi.get(paramString);
    if (paramString != null) {
      return paramString.ba();
    }
    return -1.0F;
  }
  
  public Bundle e(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().af(paramInt);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1, paramInt));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3, paramInt));
        } else if (localEmoticonPackage.jobType == 5) {
          localArrayList.add(a(localEmoticonPackage.epId, 4, paramInt));
        } else if (localEmoticonPackage.jobType == 4) {
          localArrayList.add(a(localEmoticonPackage.epId, 5, paramInt));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  void e(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  public void ex(String paramString, int paramInt)
  {
    a(paramString, paramInt, null, false, 0);
  }
  
  /* Error */
  void f(aquz paramaquz)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 1540	aquz:getParams	()Landroid/os/Bundle;
    //   9: ldc_w 928
    //   12: invokevirtual 932	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   15: checkcast 273	com/tencent/mobileqq/data/EmoticonPackage
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 1543	aquz:ov	Ljava/util/Map;
    //   24: aload_1
    //   25: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   28: invokeinterface 1544 2 0
    //   33: checkcast 404	java/io/File
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 86	afke:ki	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   46: invokeinterface 1545 2 0
    //   51: ifeq +584 -> 635
    //   54: aload_0
    //   55: getfield 86	afke:ki	Ljava/util/Map;
    //   58: astore 4
    //   60: aload 4
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 86	afke:ki	Ljava/util/Map;
    //   67: aload_1
    //   68: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   71: invokeinterface 1544 2 0
    //   76: checkcast 390	java/lang/String
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 86	afke:ki	Ljava/util/Map;
    //   84: aload_1
    //   85: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   88: invokeinterface 1546 2 0
    //   93: pop
    //   94: aload 4
    //   96: monitorexit
    //   97: aload 7
    //   99: ifnull +527 -> 626
    //   102: aload 7
    //   104: invokestatic 604	aqhq:fileToBytes	(Ljava/io/File;)[B
    //   107: astore 5
    //   109: aload 7
    //   111: invokevirtual 607	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 610	java/io/File:delete	()Z
    //   121: pop
    //   122: goto +518 -> 640
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 1549	aquz:cWk	Z
    //   130: aload_0
    //   131: getfield 81	afke:TAG	Ljava/lang/String;
    //   134: iconst_1
    //   135: ldc_w 1551
    //   138: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: getstatic 148	afke:b	Lafkd;
    //   144: aload 6
    //   146: sipush 11013
    //   149: aload_0
    //   150: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 957	afkd:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   156: ldc_w 447
    //   159: ldc_w 840
    //   162: ldc_w 614
    //   165: aload 6
    //   167: getfield 841	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   170: ldc 169
    //   172: ldc 169
    //   174: ldc 169
    //   176: ldc 169
    //   178: ldc 169
    //   180: ldc 169
    //   182: invokestatic 456	aqrm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   185: return
    //   186: astore_3
    //   187: aload_3
    //   188: invokevirtual 664	java/lang/Throwable:printStackTrace	()V
    //   191: aload_0
    //   192: getfield 81	afke:TAG	Ljava/lang/String;
    //   195: iconst_2
    //   196: new 162	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1553
    //   206: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 667	java/lang/Throwable:toString	()Ljava/lang/String;
    //   213: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 525
    //   219: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   225: invokevirtual 533	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 661
    //   231: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   238: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: iconst_1
    //   249: putfield 1549	aquz:cWk	Z
    //   252: getstatic 148	afke:b	Lafkd;
    //   255: aload 6
    //   257: sipush 11020
    //   260: aload_0
    //   261: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   264: invokevirtual 957	afkd:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   267: ldc_w 447
    //   270: ldc_w 840
    //   273: ldc_w 677
    //   276: aload 6
    //   278: getfield 841	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   281: ldc 169
    //   283: ldc 169
    //   285: ldc 169
    //   287: ldc 169
    //   289: ldc 169
    //   291: ldc 169
    //   293: invokestatic 456	aqrm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: astore_3
    //   298: aload 4
    //   300: monitorexit
    //   301: aload_3
    //   302: athrow
    //   303: aload 6
    //   305: getfield 416	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   308: iconst_4
    //   309: if_icmpeq +68 -> 377
    //   312: aload_3
    //   313: ifnonnull +64 -> 377
    //   316: aload_1
    //   317: iconst_1
    //   318: putfield 1549	aquz:cWk	Z
    //   321: aload_0
    //   322: getfield 81	afke:TAG	Ljava/lang/String;
    //   325: iconst_1
    //   326: ldc_w 1555
    //   329: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: getstatic 148	afke:b	Lafkd;
    //   335: aload 6
    //   337: sipush 11009
    //   340: aload_0
    //   341: getfield 73	afke:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   344: invokevirtual 957	afkd:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   347: ldc_w 447
    //   350: ldc_w 840
    //   353: ldc_w 654
    //   356: aload 6
    //   358: getfield 841	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   361: ldc 169
    //   363: ldc 169
    //   365: ldc 169
    //   367: ldc 169
    //   369: ldc 169
    //   371: ldc 169
    //   373: invokestatic 456	aqrm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   376: return
    //   377: aload 6
    //   379: getfield 416	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   382: iconst_4
    //   383: if_icmpne +231 -> 614
    //   386: aload 5
    //   388: aload 4
    //   390: invokestatic 657	afgc:a	([BLjava/lang/String;)I
    //   393: istore_2
    //   394: iload_2
    //   395: ifeq +159 -> 554
    //   398: aload_0
    //   399: getfield 81	afke:TAG	Ljava/lang/String;
    //   402: iconst_2
    //   403: new 162	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 1557
    //   413: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_1
    //   417: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   420: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: ldc_w 447
    //   432: ldc_w 840
    //   435: ldc_w 669
    //   438: aload 6
    //   440: getfield 841	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   443: ldc 169
    //   445: ldc 169
    //   447: new 162	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   454: iload_2
    //   455: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc 169
    //   460: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: ldc 169
    //   468: ldc 169
    //   470: ldc 169
    //   472: invokestatic 456	aqrm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   475: invokestatic 437	aqft:cC	()Z
    //   478: ifeq +76 -> 554
    //   481: invokestatic 441	aqft:hE	()J
    //   484: ldc2_w 442
    //   487: lcmp
    //   488: ifle +66 -> 554
    //   491: new 162	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   498: getstatic 629	acbn:SDCARD_PATH	Ljava/lang/String;
    //   501: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc_w 631
    //   507: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: getstatic 474	java/io/File:separator	Ljava/lang/String;
    //   513: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 6
    //   518: getfield 841	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   521: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 636
    //   530: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 7
    //   535: invokevirtual 639	java/io/File:getName	()Ljava/lang/String;
    //   538: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 645	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   547: aload 5
    //   549: iconst_0
    //   550: invokestatic 648	aqhq:a	(Ljava/lang/String;[BZ)Z
    //   553: pop
    //   554: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -553 -> 4
    //   560: aload_0
    //   561: getfield 81	afke:TAG	Ljava/lang/String;
    //   564: iconst_2
    //   565: new 162	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 1559
    //   575: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload_2
    //   579: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 525
    //   585: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   591: invokevirtual 533	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: ldc_w 661
    //   597: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_1
    //   601: getfield 624	aquz:currUrl	Ljava/lang/String;
    //   604: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: return
    //   614: aload 5
    //   616: aload_3
    //   617: aload 4
    //   619: invokestatic 619	afgc:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   622: istore_2
    //   623: goto -229 -> 394
    //   626: aconst_null
    //   627: astore 4
    //   629: aconst_null
    //   630: astore 5
    //   632: goto +8 -> 640
    //   635: aconst_null
    //   636: astore_3
    //   637: goto -540 -> 97
    //   640: aload 5
    //   642: ifnull -517 -> 125
    //   645: aload 4
    //   647: ifnonnull -344 -> 303
    //   650: goto -525 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	afke
    //   0	653	1	paramaquz	aquz
    //   393	230	2	i	int
    //   79	1	3	str1	String
    //   186	24	3	localThrowable	Throwable
    //   297	320	3	str2	String
    //   636	1	3	localObject1	Object
    //   107	534	5	arrayOfByte	byte[]
    //   18	499	6	localEmoticonPackage	EmoticonPackage
    //   36	498	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	63	186	java/lang/Throwable
    //   102	122	186	java/lang/Throwable
    //   125	185	186	java/lang/Throwable
    //   301	303	186	java/lang/Throwable
    //   303	312	186	java/lang/Throwable
    //   316	376	186	java/lang/Throwable
    //   377	394	186	java/lang/Throwable
    //   398	554	186	java/lang/Throwable
    //   554	613	186	java/lang/Throwable
    //   614	623	186	java/lang/Throwable
    //   63	97	297	finally
    //   298	301	297	finally
  }
  
  void f(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!d(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = afgc.kx(paramEmoticonPackage.epId);
      paramEmoticonPackage = afgc.ky(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  public boolean f(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = true;
      return bool1;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt & 0x1) == 1)
    {
      if (paramEmoticon.jobType != 1) {
        localObject1 = afnu.bEt.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = ahbj.isFileExists((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = afnu.bEv.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (boolean bool2 = ahbj.isFileExists((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = ahbj.isFileExists(afnu.bEs.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramEmoticon.isSound)
          {
            bool2 = bool1;
            if ((paramInt & 0x8) == 8) {
              bool2 = ahbj.isFileExists(afnu.bEr.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
            }
          }
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if ((paramInt & 0x20) != 32) {
          break;
        }
        return ahbj.isFileExists(afnu.bEw.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
      bool1 = true;
      localObject1 = localObject2;
    }
  }
  
  public void fx(String paramString1, String arg2)
  {
    Object localObject = aqhq.ag(???);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      synchronized (this.p)
      {
        this.p.put(paramString1, localObject);
        ??? = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            ???.put(str);
          }
        }
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        String str;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("fileList", ???);
        aqhq.writeFile(afnu.bEA.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(this.TAG, 1, "", paramString1);
        return;
      }
    }
    QLog.e(this.TAG, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
  }
  
  void g(aquz paramaquz)
  {
    if (paramaquz == null) {
      return;
    }
    Object localObject = paramaquz.getParams();
    int i = ((Bundle)localObject).getInt(paramaquz.currUrl);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    localObject = (File)paramaquz.ov.get(paramaquz.currUrl);
    switch (i)
    {
    default: 
      return;
    case 2: 
      b.a(localEmoticonPackage, 2, 0, 0);
      return;
    case 21: 
      try
      {
        aqhq.W(((File)localObject).getAbsolutePath(), afnu.bEq.replace("[epId]", localEmoticonPackage.epId), false);
        ((File)localObject).delete();
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          paramaquz.cWk = true;
          localIOException1.printStackTrace();
        }
      }
    }
    try
    {
      aqhq.W(((File)localObject).getAbsolutePath(), afnu.bEC.replace("[epId]", localIOException1.epId), false);
      this.jdField_a_of_type_Aixk.b(localIOException1.epId);
      ((File)localObject).delete();
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        paramaquz.cWk = true;
        localIOException2.printStackTrace();
      }
    }
  }
  
  public void i(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new aquz(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.atX = this.cKT;
    paramEmoticonPackage.cWw = true;
    a().a(paramEmoticonPackage, this.r, localBundle);
  }
  
  public Bundle j(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int i = paramBundle.getInt("businessType");
    int j = paramBundle.getInt("sceneType");
    if (a(this.mApp, str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
    }
    paramBundle = a().c(str, -1);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.mApp != null)) {
          anot.a(this.mApp, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", i);
        localBundle.putString("messge", "");
        localBundle.putInt("sceneType", j);
        return localBundle;
        a(paramBundle, true, j);
        i = 0;
        continue;
        i = 4;
      }
    }
    Object localObject = a().a(str, -1);
    paramBundle = (Bundle)localObject;
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!aT(i, ((EmoticonPackage)localObject).jobType))
      {
        a().d((EmoticonPackage)localObject);
        paramBundle = null;
      }
    }
    localObject = paramBundle;
    if (paramBundle == null)
    {
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = str;
      ((EmoticonPackage)localObject).wordingId = -1L;
      if (i != 2) {
        break label409;
      }
      ((EmoticonPackage)localObject).jobType = 1;
    }
    for (;;)
    {
      ((EmoticonPackage)localObject).isMagicFaceDownloading = false;
      if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      }
      a((EmoticonPackage)localObject, true, j);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
      label409:
      if (i == 3) {
        ((EmoticonPackage)localObject).jobType = 3;
      } else if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      } else if (i == 5) {
        ((EmoticonPackage)localObject).jobType = 4;
      } else {
        ((EmoticonPackage)localObject).jobType = 0;
      }
    }
  }
  
  public Bundle k(Bundle paramBundle)
  {
    int i = 1;
    int j;
    int k;
    if (paramBundle == null)
    {
      j = -1;
      paramBundle = "";
      i = 0;
      k = 0;
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      if (i == 0) {
        break;
      }
      paramBundle = a(paramBundle, j, k);
      ((Bundle)localObject).putInt("result", paramBundle.getInt("result"));
      ((Bundle)localObject).putString("messge", "");
      ((Bundle)localObject).putInt("id", -1);
      ((Bundle)localObject).putInt("status", paramBundle.getInt("status"));
      ((Bundle)localObject).putInt("pluginStatus", paramBundle.getInt("pluginStatus"));
      ((Bundle)localObject).putLong("pluginSize", paramBundle.getLong("pluginSize"));
      ((Bundle)localObject).putInt("progress", paramBundle.getInt("progress"));
      ((Bundle)localObject).putInt("dynamicEmojiId", paramBundle.getInt("dEmojiId"));
      ((Bundle)localObject).putStringArrayList("dynamicEmojiList", paramBundle.getStringArrayList("srcList"));
      ((Bundle)localObject).putStringArrayList("urlParamsList", paramBundle.getStringArrayList("urlParamsList"));
      return localObject;
      localObject = paramBundle.getString("id");
      int m = paramBundle.getInt("businessType");
      int n = paramBundle.getInt("sceneType");
      if (((String)localObject).length() == 0)
      {
        i = 0;
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
      }
      else
      {
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
        if (afgc.cL((String)localObject) == -1)
        {
          i = 0;
          k = n;
          j = m;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    ((Bundle)localObject).putInt("result", 0);
    ((Bundle)localObject).putString("messge", "");
    ((Bundle)localObject).putInt("id", -1);
    ((Bundle)localObject).putInt("status", 0);
    ((Bundle)localObject).putInt("pluginStatus", 0);
    ((Bundle)localObject).putLong("pluginSize", 0L);
    ((Bundle)localObject).putInt("progress", 0);
    ((Bundle)localObject).putInt("dynamicEmojiId", -1);
    ((Bundle)localObject).putStringArrayList("dynamicEmojiList", null);
    ((Bundle)localObject).putStringArrayList("urlParamsList", null);
    return localObject;
  }
  
  public boolean lV(String paramString)
  {
    boolean bool = lY(paramString);
    cd(paramString, bool);
    return bool;
  }
  
  public boolean lW(String paramString)
  {
    boolean bool = lX(paramString);
    cd(paramString, bool);
    return bool;
  }
  
  public boolean lX(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = afgc.z(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = afgc.z(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = afgc.z(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = (ArrayList)a().az(paramString);
    if (localObject != null)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if (localEmoticon == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(afnu.bEs.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        localObject = a().a(paramString, -1);
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {}
        for (localObject = afnu.bEw.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId); !new File((String)localObject).exists(); localObject = afnu.bEv.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  public boolean lY(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          localObject = afgc.z(2, paramString);
          if (new File((String)localObject).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.TAG, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
        return false;
        localObject = afgc.z(3, paramString);
        if (new File((String)localObject).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "cover_pkg_color isn't exist." + (String)localObject);
      return false;
      localObject = afgc.z(4, paramString);
      if (new File((String)localObject).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "cover_pkg_gray isn't exist." + (String)localObject);
    return false;
    Object localObject = (ArrayList)a().e(paramString, true);
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localEmoticonPackage = a().a(paramString, -1);
      if (localEmoticonPackage == null) {
        break label623;
      }
    }
    label585:
    label623:
    for (int i = localEmoticonPackage.rscType;; i = 0)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (localEmoticon == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (!new File(afnu.bEs.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (1 == i) {
            return aixo.nd(afnu.bEC.replace("[epId]", paramString));
          }
          if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {}
          for (localObject = afnu.bEw.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId);; localObject = afnu.bEv.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
          {
            if (new File((String)localObject).exists()) {
              break label585;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "emoticons do not be exist.epId=" + paramString);
          }
        }
      }
      return true;
    }
  }
  
  protected boolean lZ(String paramString)
  {
    Object localObject = a().b(paramString);
    if (localObject != null) {}
    for (int i = ((EmoticonPackage)localObject).rscType;; i = 0)
    {
      if (1 == i) {
        return aixo.nd(afnu.bEC.replace("[epId]", paramString));
      }
      localObject = (ArrayList)a().az(paramString);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!new File(afnu.bEv.replace("[epId]", paramString).replace("[eId]", ((Emoticon)((ArrayList)localObject).get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)((ArrayList)localObject).get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  public boolean ma(String paramString)
  {
    return new File(afnu.bEq.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "clear History. uin:" + this.mApp.getAccount() + " app=" + String.valueOf(this.mApp));
    }
    b.onDestory();
    if (a() != null) {
      a().clearCache();
    }
    synchronized (this.ki)
    {
      this.ki.clear();
      return;
    }
  }
  
  public void u(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    int i = afgc.cL(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i == -1)) {
      return;
    }
    int j = this.cRw;
    this.cRw = (j + 1);
    paramString = Integer.toString(j);
    ((acdz)this.mApp.getBusinessHandler(12)).a(i, paramArrayList, paramString);
  }
  
  public class a
  {
    WeakReference<acdz> gJ;
    
    public a(acdz paramacdz)
    {
      this.gJ = new WeakReference(paramacdz);
    }
    
    public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afke
 * JD-Core Version:    0.7.0.1
 */