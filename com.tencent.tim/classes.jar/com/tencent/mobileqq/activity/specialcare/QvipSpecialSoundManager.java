package com.tencent.mobileqq.activity.specialcare;

import abbg;
import abbg.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aqhq;
import aqiw;
import aquz;
import aqva;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundManager
{
  public static HashMap<String, List<abbg.a>> ib = new HashMap();
  public static HashMap<String, abbg.a> ic = new HashMap();
  private ByteArrayPool a = new ByteArrayPool(4096);
  private AppInterface app;
  private Context context;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  
  public QvipSpecialSoundManager(Context paramContext, AppInterface paramAppInterface)
  {
    this.context = paramAppInterface.getApp();
    this.app = paramAppInterface;
    try
    {
      paramContext = paramContext.getFilesDir().getCanonicalPath() + "/";
      ThreadManager.getFileThreadHandler().post(new MoveConfig(paramContext, null));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(int paramInt, File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      QLog.e("QvipSpecialSoundManager", 1, "onSpecialSoundConfigDownloaded specialSoundPath == null");
      return;
    }
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QvipSpecialSoundManager", 2, "download SpecialSound Success");
      }
    }
    for (;;)
    {
      try
      {
        String str = l(paramFile);
        if (!paramFile.exists()) {
          continue;
        }
        l = paramFile.length();
        gK(l);
        paramFile = str;
      }
      catch (Exception paramFile)
      {
        long l;
        cK("decodeTextFile is exception.");
        paramFile.printStackTrace();
        paramFile = null;
        continue;
      }
      catch (OutOfMemoryError paramFile)
      {
        cK("decodeTextFile is OutOfMemoryError.");
        paramFile.printStackTrace();
      }
      if (!TextUtils.isEmpty(paramFile)) {
        break;
      }
      cK("new Config is Empty");
      return;
      l = 0L;
      continue;
      paramFile = null;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramFile)))
    {
      cK("Config is Same");
      return;
    }
    eg(paramString, paramFile);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    this.mainHandler.post(new QvipSpecialSoundManager.3(this, parama, paramBoolean));
  }
  
  private void cAP()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230771);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void eg(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = abbg.a(new JSONObject(paramString2));
        localObject = abbg.a(new JSONObject(paramString1));
        paramString1 = paramString2.vK;
        paramString2 = ((abbg)localObject).vK;
        if ((paramString1 == null) || (paramString2 == null) || (paramString1.isEmpty()) || (paramString2.isEmpty()) || (paramString1.size() < paramString2.size()))
        {
          cK("updateSpecialSound return.");
          return;
        }
      }
      catch (Exception paramString1)
      {
        cK("updateSpecialSound exception");
        paramString1.printStackTrace();
        return;
      }
      int j = paramString2.size();
      int i = 0;
      while (i < j)
      {
        localObject = (abbg.a)paramString1.get(i);
        abbg.a locala = (abbg.a)paramString2.get(i);
        if ((((abbg.a)localObject).id == locala.id) && (!((abbg.a)localObject).bfc.equals(locala.bfc))) {
          ThreadManager.post(new QvipSpecialSoundManager.1(this, (abbg.a)localObject), 5, null, true);
        }
        i += 1;
      }
    }
  }
  
  private void hM(List<abbg.a> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      cK("SpecialSoundList is empty, donot need sort.");
    }
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      if (i < j)
      {
        abbg.a locala = (abbg.a)paramList.get(i);
        if (!ic.containsKey(String.valueOf(locala.id))) {
          ic.put(String.valueOf(locala.id), locala);
        }
        localEditor.putString("special_sound_url" + locala.id, locala.ace);
        if (!isWhiteList(locala.bfd)) {
          cK("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (locala.isShow == 1) {
            if (locala.type == 1) {
              localArrayList1.add(locala);
            } else if (locala.type == 2) {
              localArrayList2.add(locala);
            } else {
              localArrayList3.add(locala);
            }
          }
        }
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
      paramList.addAll(localArrayList3);
    } while (ib.containsKey("key_special_sound_list" + this.app.getCurrentAccountUin()));
    ib.put("key_special_sound_list" + this.app.getCurrentAccountUin(), paramList);
  }
  
  private boolean isWhiteList(String paramString)
  {
    str = this.app.getCurrentAccountUin();
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return true;
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label85;
            }
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              break;
            }
            i += 1;
          }
          return paramString.equals(str);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  private String l(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 355	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 358	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 360	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 361	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 48	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 365	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 371	java/io/InputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +59 -> 101
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 375	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 379	java/io/InputStream:close	()V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: getfield 48	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   83: aload 4
    //   85: invokevirtual 384	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   88: ldc_w 386
    //   91: areturn
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 387	java/io/FileNotFoundException:printStackTrace	()V
    //   97: ldc_w 386
    //   100: areturn
    //   101: new 175	java/lang/String
    //   104: dup
    //   105: aload_3
    //   106: invokevirtual 391	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   109: ldc_w 393
    //   112: invokespecial 396	java/lang/String:<init>	([BLjava/lang/String;)V
    //   115: astore 5
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 379	java/io/InputStream:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: getfield 48	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   137: aload 4
    //   139: invokevirtual 384	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   142: aload 5
    //   144: areturn
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 379	java/io/InputStream:close	()V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   168: aload_0
    //   169: getfield 48	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   172: aload 4
    //   174: invokevirtual 384	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   177: goto -89 -> 88
    //   180: astore 5
    //   182: aload_1
    //   183: ifnull +7 -> 190
    //   186: aload_1
    //   187: invokevirtual 379	java/io/InputStream:close	()V
    //   190: aload_3
    //   191: ifnull +7 -> 198
    //   194: aload_3
    //   195: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_0
    //   199: getfield 48	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   202: aload 4
    //   204: invokevirtual 384	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   207: aload 5
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	QvipSpecialSoundManager
    //   0	210	1	paramFile	File
    //   39	11	2	i	int
    //   16	179	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	176	4	arrayOfByte	byte[]
    //   56	3	5	localIOException	IOException
    //   115	28	5	str	String
    //   145	3	5	localException	Exception
    //   180	28	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	40	56	java/io/IOException
    //   45	53	56	java/io/IOException
    //   101	117	56	java/io/IOException
    //   0	9	92	java/io/FileNotFoundException
    //   29	40	145	java/lang/Exception
    //   45	53	145	java/lang/Exception
    //   101	117	145	java/lang/Exception
    //   29	40	180	finally
    //   45	53	180	finally
    //   58	63	180	finally
    //   101	117	180	finally
    //   147	152	180	finally
  }
  
  private String qO()
  {
    Object localObject = new File(this.context.getFilesDir(), "pddata/vas/special_remind/new_config.json");
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        aquz localaquz = new aquz(this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localaquz.bC = 1;
        localaquz.cWw = true;
        i = aqva.a(localaquz, this.app);
        if (i != 0) {
          break label204;
        }
        if (localObject != null)
        {
          l = ((File)localObject).length();
          gK(l);
          i = 1;
          if (i != 0) {
            break label143;
          }
          cK("downLoad Special Sound Config failed.");
          return "";
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        i = -1;
        continue;
        long l = 0L;
        continue;
      }
      int i = 1;
      continue;
      try
      {
        label143:
        localObject = l((File)localObject);
        return localObject;
      }
      catch (IOException localIOException)
      {
        cK("decodeTextFile is IOException.");
        localIOException.printStackTrace();
        return "";
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          cK("decodeTextFile is OutOfMemoryError.");
          localOutOfMemoryError.printStackTrace();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          cK("decodeTextFile is exception.");
          localException1.printStackTrace();
        }
      }
      label204:
      i = 0;
    }
  }
  
  public void Bj(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = abbg.a(new JSONObject(paramString));
        if (paramString != null)
        {
          hM(paramString.vK);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean XO()
  {
    String str = "key_special_sound_list" + this.app.getCurrentAccountUin();
    return ib.containsKey(str);
  }
  
  public void a(a parama)
  {
    ThreadManager.post(new QvipSpecialSoundManager.2(this, parama), 5, null, true);
  }
  
  /* Error */
  public void cAN()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:app	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 67	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 200
    //   9: iconst_4
    //   10: invokevirtual 206	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_1
    //   16: new 82	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 69	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:context	Landroid/content/Context;
    //   24: invokevirtual 80	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: ldc_w 399
    //   30: invokespecial 402	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 145	java/io/File:exists	()Z
    //   38: ifeq +9 -> 47
    //   41: aload_0
    //   42: aload_2
    //   43: invokespecial 142	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:l	(Ljava/io/File;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_3
    //   48: ldc_w 406
    //   51: ldc_w 386
    //   54: invokeinterface 410 3 0
    //   59: astore_3
    //   60: new 404	aquz
    //   63: dup
    //   64: aload_3
    //   65: aload_2
    //   66: invokespecial 413	aquz:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   69: astore 5
    //   71: aload 5
    //   73: iconst_1
    //   74: putfield 417	aquz:bC	B
    //   77: aload 5
    //   79: iconst_1
    //   80: putfield 421	aquz:cWw	Z
    //   83: aload 5
    //   85: sipush 20000
    //   88: putfield 447	aquz:akN	I
    //   91: aload_0
    //   92: getfield 71	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:app	Lcom/tencent/common/app/AppInterface;
    //   95: sipush 193
    //   98: invokevirtual 451	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   101: checkcast 453	aopo
    //   104: astore 4
    //   106: aload 4
    //   108: invokevirtual 456	aopo:isEnable	()Z
    //   111: ifeq +150 -> 261
    //   114: new 9	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable
    //   117: dup
    //   118: aload_0
    //   119: aload 5
    //   121: aload_0
    //   122: getfield 71	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:app	Lcom/tencent/common/app/AppInterface;
    //   125: aload_2
    //   126: aload_1
    //   127: invokespecial 459	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable:<init>	(Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager;Laquz;Lcom/tencent/common/app/AppInterface;Ljava/io/File;Ljava/lang/String;)V
    //   130: astore_1
    //   131: new 461	aopp
    //   134: dup
    //   135: aload_0
    //   136: getfield 71	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:app	Lcom/tencent/common/app/AppInterface;
    //   139: checkcast 463	com/tencent/mobileqq/app/QQAppInterface
    //   142: ldc_w 465
    //   145: aload_1
    //   146: ldc2_w 466
    //   149: invokespecial 470	aopp:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Runnable;J)V
    //   152: astore_1
    //   153: aload 4
    //   155: sipush 10021
    //   158: ldc_w 472
    //   161: ldc_w 465
    //   164: iconst_0
    //   165: aload_3
    //   166: aload_2
    //   167: invokevirtual 86	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   170: iconst_2
    //   171: iconst_0
    //   172: iconst_0
    //   173: aload_1
    //   174: invokevirtual 475	aopo:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLaopm;)Z
    //   177: pop
    //   178: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +42 -> 223
    //   184: ldc 121
    //   186: iconst_2
    //   187: new 73	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 477
    //   197: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_2
    //   201: invokevirtual 86	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   204: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 479
    //   210: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: return
    //   224: astore_1
    //   225: aload_0
    //   226: new 73	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 481
    //   236: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_1
    //   240: invokevirtual 482	java/lang/Exception:toString	()Ljava/lang/String;
    //   243: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 165	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:cK	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -211 -> 47
    //   261: aload_0
    //   262: aload 5
    //   264: aload_0
    //   265: getfield 71	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:app	Lcom/tencent/common/app/AppInterface;
    //   268: invokestatic 426	aqva:a	(Laquz;Lmqq/app/AppRuntime;)I
    //   271: aload_2
    //   272: aload_1
    //   273: invokespecial 195	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(ILjava/io/File;Ljava/lang/String;)V
    //   276: return
    //   277: astore_1
    //   278: aload_0
    //   279: new 73	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 481
    //   289: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_1
    //   293: invokevirtual 482	java/lang/Exception:toString	()Ljava/lang/String;
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 165	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:cK	(Ljava/lang/String;)V
    //   305: aload_1
    //   306: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	QvipSpecialSoundManager
    //   15	159	1	localObject1	Object
    //   224	29	1	localException1	Exception
    //   257	16	1	str	String
    //   277	29	1	localException2	Exception
    //   33	239	2	localFile	File
    //   13	201	3	localObject2	Object
    //   104	50	4	localaopo	aopo
    //   69	194	5	localaquz	aquz
    // Exception table:
    //   from	to	target	type
    //   34	47	224	java/lang/Exception
    //   47	223	277	java/lang/Exception
    //   261	276	277	java/lang/Exception
  }
  
  public void cAO()
  {
    cAP();
    Bj(qO());
  }
  
  public void cK(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
  
  public String da(int paramInt)
  {
    if ((ic != null) && (!ic.isEmpty()))
    {
      abbg.a locala = (abbg.a)ic.get(String.valueOf(paramInt));
      if (locala != null) {
        return locala.bfb;
      }
    }
    return "";
  }
  
  public void gK(long paramLong)
  {
    if (paramLong <= 0L)
    {
      cK("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      cK("reportFlowData int wifi state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFISpecialCareDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      cK("sendAppDataIncerment flowSize = " + paramLong);
      this.app.sendAppDataIncerment(this.app.getAccount(), arrayOfString, paramLong);
      return;
      cK("reportFlowData int 2G/3G state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGSpecialCareDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public boolean jc(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      File localFile = new File(this.context.getFilesDir(), paramString);
      try
      {
        paramString = new aquz(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.bC = 1;
        i = aqva.a(paramString, this.app);
        if (i == 0) {
          continue;
        }
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = -1;
        }
      }
    }
  }
  
  static class MoveConfig
    implements Runnable
  {
    private String bfh;
    
    private MoveConfig(String paramString)
    {
      this.bfh = paramString;
    }
    
    public void run()
    {
      aqhq.moveFile(this.bfh + "https://i.gtimg.cn/club/moblie/special_sound/new_config.json", this.bfh + "pddata/vas/special_remind/new_config.json");
    }
  }
  
  public class SyncDownloadRunnable
    implements Runnable
  {
    private File ab;
    private AppInterface app;
    private aquz b;
    private String bfi;
    public int resultCode;
    
    public SyncDownloadRunnable(aquz paramaquz, AppInterface paramAppInterface, File paramFile, String paramString)
    {
      this.app = paramAppInterface;
      this.b = paramaquz;
      this.ab = paramFile;
      this.bfi = paramString;
      this.resultCode = -1;
    }
    
    public void run()
    {
      this.resultCode = aqva.a(this.b, this.app);
      if (QLog.isColorLevel()) {
        QLog.d("QvipSpecialSoundManager", 2, "[SyncDownloadRunnable]:resultCode=" + this.resultCode);
      }
      QvipSpecialSoundManager.a(QvipSpecialSoundManager.this, this.resultCode, this.ab, this.bfi);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager
 * JD-Core Version:    0.7.0.1
 */