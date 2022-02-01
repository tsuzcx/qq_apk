import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class abyv
{
  public static StringBuilder N = new StringBuilder(100);
  public static CopyOnWriteArrayList<WeakReference<abyv.a>> O = new CopyOnWriteArrayList();
  public static long OU;
  public static long OV;
  private static boolean aiY;
  private static boolean bGo;
  private static boolean bGp;
  public static boolean bGq;
  private static boolean bGr;
  private static AtomicBoolean cx = new AtomicBoolean(false);
  public static final String[] dJ = { "libjsc.so", "libTcHevcDec.so" };
  public static final String[] dK = { "libjsc.so" };
  public static final String[] dL = { "libTcHevcDec.so" };
  public static final String[] dM = { "libv8.so" };
  public static final String[] dN = { "libtinyskia.so", "libsava.so" };
  public static final String[] dO = { "brick.js", "ticker.js", "scene.js", "game.js" };
  private static Runnable fG = new ApolloSoLoader.1();
  private static boolean sIsMainProcess = true;
  
  static
  {
    bGq = true;
  }
  
  private static void E(String[] paramArrayOfString)
  {
    for (;;)
    {
      int i;
      synchronized (aurl.lock)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str2 = paramArrayOfString[i];
          if (jJ(str2)) {
            break label223;
          }
          String str1 = aurl.jg();
          Object localObject1 = str1;
          if (jK(str2)) {
            localObject1 = str1 + "/test";
          }
          localObject1 = new File((String)localObject1, str2);
          QLog.i("ApolloSoLoader", 1, "ready to load [" + ((File)localObject1).getAbsolutePath() + "],[size]:" + ((File)localObject1).length());
          System.load(((File)localObject1).getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "end to load [" + ((File)localObject1).getAbsolutePath() + "]");
          if (!bGp) {
            break label223;
          }
          abwh.b(10, 300, new Object[] { "load [" + ((File)localObject1).getAbsolutePath() + "]" });
        }
      }
      return;
      label223:
      i += 1;
    }
  }
  
  public static void Iq(int paramInt)
  {
    try
    {
      Iterator localIterator = O.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (abyv.a)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((abyv.a)localObject2).hO(paramInt);
          }
        }
      }
    }
    finally {}
  }
  
  public static boolean Zr()
  {
    return aiY;
  }
  
  private static boolean Zs()
  {
    int i = 4;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (sIsMainProcess) {
          i = 0;
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", i);
        String str = localSharedPreferences.getString("res_name", "nothing");
        bool1 = localSharedPreferences.getBoolean("is_handle_reinstall_android.qq.apollo.js.836g1", false);
        if ((bGr) || ((bool1) && (str.equals("android.qq.apollo.js.836g1")))) {
          break label245;
        }
        if (str.equals("android.qq.apollo.js.836g1")) {
          break;
        }
        QLog.i("ApolloSoLoader", 1, "oldRes:" + str + ",newRes:" + "android.qq.apollo.js.836g1");
        if (Zu())
        {
          bool1 = false;
          if (bool1)
          {
            localSharedPreferences.edit().putBoolean("is_handle_reinstall_android.qq.apollo.js.836g1", true).commit();
            bGr = true;
          }
          bool1 = bool2;
          if (!bGp) {
            return bool1;
          }
          abwh.b(10, 100, new Object[] { "reinstall delete old so, oldRes:", str, ",newRes:", "android.qq.apollo.js.836g1" });
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
        if (bGp) {
          abwh.b(10, 100, new Object[] { "reinstall th:", localThrowable });
        }
        Zt();
        return false;
      }
      bool1 = Zt();
    }
    return false;
    label245:
    boolean bool1 = false;
    return bool1;
  }
  
  public static boolean Zt()
  {
    QLog.i("ApolloSoLoader", 1, "[delAllSoButJsc]");
    try
    {
      String str3;
      boolean bool;
      for (;;)
      {
        synchronized (aurl.lock)
        {
          String str1 = aurl.jg();
          arrayOfString = dN;
          j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str3 = arrayOfString[i];
            bool = aqhq.deleteFile(str1 + "/" + str3);
            if (!bool) {
              return false;
            }
            i += 1;
            continue;
          }
          arrayOfString = dO;
          j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            break;
          }
          str3 = arrayOfString[i];
          bool = aqhq.deleteFile(str1 + "/" + str3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      String[] arrayOfString = dM;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str3 = arrayOfString[i];
        bool = aqhq.deleteFile(str2 + "/" + str3);
        if (!bool) {
          return false;
        }
        i += 1;
      }
      aqhq.delete(aurl.gF(1), false);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "Fail to del so files." + localThrowable);
    }
    return false;
  }
  
  private static boolean Zu()
  {
    String str1 = aurl.jg() + "libsava.so" + "." + "android.qq.apollo.js.836g1";
    if (new File(str1).exists())
    {
      QLog.i("ApolloSoLoader", 1, "Bingo, the latest sava has been predownloaded.");
      String str2 = aurl.jg() + "libsava.so";
      aqhq.deleteFile(str2);
      if (!aqhq.rename(str1, str2))
      {
        QLog.w("ApolloSoLoader", 1, "fail to rename.");
        return false;
      }
      return true;
    }
    QLog.i("ApolloSoLoader", 1, "It's a pity that the latest sava hasn't been predownloaded.");
    return false;
  }
  
  private static boolean Zv()
  {
    for (;;)
    {
      try
      {
        if (ApolloGameUtil.yl())
        {
          QLog.i("ApolloSoLoader", 1, "[loadAllSo], Aborting! arch=x86");
          if (!bGp) {
            break;
          }
          abwh.a(10, 300, 1002, new Object[] { "arch=x86" });
          break;
        }
        if (!UpdateArkSo.ad(BaseApplicationImpl.getContext(), UpdateArkSo.Ah()))
        {
          if (!bGp) {
            break label527;
          }
          abwh.a(10, 300, 1003, new Object[] { "png-armeabi-v7a load failed" });
          bGq = true;
          break label527;
        }
        Object localObject = abmt.getAppInterface();
        if (!(localObject instanceof AppInterface)) {
          break label520;
        }
        localObject = (afem)((AppInterface)localObject).getManager(77);
        if (localObject == null) {
          break label520;
        }
        localObject = (afeq)((afem)localObject).a("android.qq.apollo.js.836g1");
        if (localObject == null) {
          break label520;
        }
        localObject = ((afeq)localObject).b();
        if (localObject == null) {
          break label520;
        }
        i = ((XmlData)localObject).Version;
        QLog.i("ApolloSoLoader", 1, "[so info], str:android.qq.apollo.js.836g1,ver:" + i + ", IS_CPU_64_BIT=" + false);
        if (bGp) {
          abwh.b(10, 300, new Object[] { "[so info], str:android.qq.apollo.js.836g1,ver:" + i });
        }
        if (j(dM))
        {
          E(dM);
          E(dN);
          if (!sIsMainProcess) {
            break label515;
          }
          i = 0;
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", i);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().putString("res_name", "android.qq.apollo.js.836g1").commit();
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ArkAppCenter.a().postToMainThread(new ApolloSoLoader.2());
            QLog.e("ApolloSoLoader", 1, "[loadAllSo], Notify ark jsc has loaded.");
          }
          if (!bGp) {
            break label529;
          }
          abwh.a(10, 300, 0, new Object[] { "loadAllSo success" });
          break label529;
        }
        if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
        {
          E(dK);
          continue;
        }
        E(dK);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloSoLoader", 1, "[loadAllSo], Something unexpected happened." + localThrowable);
        cGq();
        if (bGp)
        {
          abwh.a(10, 300, 1004, new Object[] { "[loadAllSo], Something unexpected happened.", localThrowable });
          bGq = true;
        }
        return false;
      }
      abwh.gN(10, 299);
      if (!AVSoUtils.ayu())
      {
        QLog.e("ApolloSoLoader", 1, "[loadAllSo] sharpp load error");
        abwh.a(10, 299, 1005, new Object[] { "sharpp load fail" });
        return false;
      }
      abwh.a(10, 299, 0, new Object[0]);
      continue;
      label515:
      int i = 4;
      continue;
      label520:
      i = -1;
    }
    return false;
    label527:
    return false;
    label529:
    return true;
  }
  
  private static boolean Zw()
  {
    if (!j(dN)) {}
    while (!j(dO)) {
      return false;
    }
    boolean bool = new abya(-1, 3, "", "").Zp();
    QLog.i("ApolloSoLoader", 1, "[isSavaSoExists], check result:" + bool);
    if (bGp) {
      abwh.b(10, 100, new Object[] { "[isSavaSoExists], check result:" + bool });
    }
    return bool;
  }
  
  private static boolean Zx()
  {
    boolean bool;
    if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
    {
      if (j(dK))
      {
        QLog.i("ApolloSoLoader", 1, "jsc exists at new path.");
        if (new File(aurl.jg() + "checkList_jsc").exists())
        {
          bool = new abya(-1, 4, "", "").Zp();
          QLog.i("ApolloSoLoader", 1, "[isJscSoExists], check result:" + bool);
          return bool;
        }
        return true;
      }
    }
    else if (j(dJ))
    {
      QLog.i("ApolloSoLoader", 1, "jsc exists at new path.");
      if (new File(aurl.jg() + "checkList_jsc").exists())
      {
        bool = new abya(-1, 4, "", "").Zp();
        QLog.i("ApolloSoLoader", 1, "[isJscSoExists], check result:" + bool);
        return bool;
      }
      return true;
    }
    String str1 = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/";
    int j;
    int i;
    Object localObject2;
    if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
    {
      ??? = dK;
      j = ???.length;
      i = 0;
      if (i >= j) {
        break label640;
      }
      localObject2 = new File(str1, ???[i]);
      if ((localObject2 == null) || (!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
        i = 0;
      }
    }
    for (;;)
    {
      label316:
      if (i != 0)
      {
        localObject2 = aurl.jg();
        for (;;)
        {
          try
          {
            synchronized (aurl.lock)
            {
              if ((BaseApplicationImpl.sProcessId != 2) && (BaseApplicationImpl.sProcessId != 8)) {
                continue;
              }
              arrayOfString = dK;
              j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                continue;
              }
              str3 = arrayOfString[i];
              bool = aqhq.copyFile(str1 + "/" + str3, (String)localObject2 + str3);
              if (bool) {
                continue;
              }
              return false;
            }
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            String[] arrayOfString;
            String str3;
            QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
            return false;
          }
          ??? = dJ;
          j = ???.length;
          i = 0;
          if (i >= j) {
            break label640;
          }
          localObject2 = new File(str2, ???[i]);
          if ((localObject2 == null) || (!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
          {
            i = 0;
            break label316;
          }
          i += 1;
          continue;
          i += 1;
        }
        arrayOfString = dJ;
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          str3 = arrayOfString[i];
          bool = aqhq.copyFile(str2 + "/" + str3, (String)localObject2 + str3);
          if (!bool) {
            return false;
          }
          i += 1;
        }
        QLog.i("ApolloSoLoader", 1, "copy jsc from old path.");
        return true;
      }
      QLog.i("ApolloSoLoader", 1, "jsc NOT exists at old path.");
      return false;
      label640:
      i = 1;
    }
  }
  
  private static boolean Zy()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (TextUtils.isEmpty(abhh.bfV)) {
        abhh.bfV = aqhq.readFileToString(new File(iU("brick.js"), "brick.js"));
      }
      if (TextUtils.isEmpty(abhh.bfW)) {
        abhh.bfW = aqhq.readFileToString(new File(iU("ticker.js"), "ticker.js"));
      }
      if (TextUtils.isEmpty(abhh.bfX)) {
        abhh.bfX = aqhq.readFileToString(new File(iU("scene.js"), "scene.js"));
      }
      if (TextUtils.isEmpty(abhh.bfY)) {
        abhh.bfY = aqhq.readFileToString(new File(iU("game.js"), "game.js"));
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[initScriptLib]," + localThrowable);
      if (bGp) {
        abwh.b(10, 100, new Object[] { "[initScriptLib], th:", localThrowable });
      }
      return false;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      QLog.i("ApolloSoLoader", 1, "[initScriptLib], costT:" + (l2 - l1));
    }
  }
  
  public static void a(abyv.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = O.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (parama == localWeakReference.get()))
            {
              QLog.i("ApolloSoLoader", 1, "already add, cb:" + parama);
              break;
            }
          }
        }
      }
      finally {}
      O.add(new WeakReference(parama));
    }
  }
  
  /* Error */
  public static void b(abyv.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: getstatic 85	abyv:O	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   10: invokevirtual 559	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 85	abyv:O	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   25: invokevirtual 183	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 189 1 0
    //   35: ifeq -17 -> 18
    //   38: aload_2
    //   39: invokeinterface 193 1 0
    //   44: checkcast 195	java/lang/ref/WeakReference
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -20 -> 29
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 198	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: if_acmpne -28 -> 29
    //   60: getstatic 85	abyv:O	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: aload_3
    //   64: invokevirtual 562	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: invokestatic 565	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -53 -> 18
    //   74: ldc 138
    //   76: iconst_2
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc_w 567
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_0
    //   90: aastore
    //   91: invokestatic 571	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: goto -76 -> 18
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	parama	abyv.a
    //   13	2	1	i	int
    //   28	11	2	localIterator	Iterator
    //   47	17	3	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   7	14	97	finally
    //   22	29	97	finally
    //   29	48	97	finally
    //   52	94	97	finally
  }
  
  public static void cGo() {}
  
  private static void cGp()
  {
    try
    {
      File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libsava.so");
      if ((localFile.exists()) && (localFile.delete())) {
        QLog.i("ApolloSoLoader", 1, "success to del old so.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  private static void cGq()
  {
    try
    {
      File localFile = new File(acbn.SDCARD_PATH + "pddata/prd/early", "android.qq.apollo.js.836g1");
      if (!localFile.exists())
      {
        startDownload(1);
        return;
      }
      if (!bGo)
      {
        aurl.aw(localFile.getAbsolutePath(), 1);
        bGo = true;
        QLog.i("ApolloSoLoader", 1, "[tryUnzipFromBackup], unzip success.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[tryUnzipFromBackup]," + localThrowable);
    }
  }
  
  private static void cGr()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label34;
      }
      ApolloCmdChannel.getChannel((QQAppInterface)localObject).checkSetNative();
    }
    for (;;)
    {
      abhh.cBJ();
      return;
      label34:
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = abmt.a();
        if (localObject != null) {
          ((ApolloCmdChannel)localObject).checkSetNative();
        }
      }
    }
  }
  
  private static String iU(String paramString)
  {
    return aurl.jg();
  }
  
  private static boolean ic(int paramInt)
  {
    try
    {
      synchronized (aurl.lock)
      {
        File localFile1 = new File(aurl.gF(paramInt));
        String str1 = aurl.jg();
        if (localFile1.exists())
        {
          File[] arrayOfFile = localFile1.listFiles();
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile2 = arrayOfFile[i];
            String str2 = localFile2.getAbsolutePath();
            String str3 = str1 + localFile2.getName();
            boolean bool = aqhq.copyFile(str2, str3);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[tryCopyFromTmpDir] fromPath=").append(str2).append(", fromLen=").append(localFile2.length()).append(", toPath=").append(str3).append(", copy ret=").append(bool);
            QLog.i("ApolloSoLoader", 1, localStringBuilder.toString());
            if (bGp) {
              abwh.b(10, 100, new Object[] { localStringBuilder.toString() });
            }
            if (!bool) {
              return false;
            }
            i += 1;
          }
          aqhq.cn(localFile1.getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "[tryCopyFromTmpDir], done. type:" + paramInt);
        }
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  private static boolean j(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    String str1 = aurl.jg();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      File localFile = new File(str1, str2);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
      {
        QLog.w("ApolloSoLoader", 1, "lib " + str2 + " NOT exist.");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean jJ(String paramString)
  {
    if (!AppSetting.aNU) {}
    while (!"libsava.so".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  public static boolean jK(String paramString)
  {
    return false;
  }
  
  public static void loadSo(String paramString)
  {
    boolean bool2 = true;
    try
    {
      QLog.i("ApolloSoLoader", 1, "[loadSo], from:" + paramString + ",sLoadEngineLibDone:" + aiY + ",sIsTaskRunning:" + cx.get());
      bool1 = cx.getAndSet(true);
      if (bool1) {}
      for (;;)
      {
        return;
        if (!aiY) {
          break;
        }
        Iq(0);
        cx.set(false);
      }
      if (BaseApplicationImpl.sProcessId != 1) {
        break label186;
      }
    }
    finally {}
    boolean bool1 = true;
    label109:
    sIsMainProcess = bool1;
    if ((sIsMainProcess) && (abhh.aV(BaseApplicationImpl.getContext()))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bGp = bool1;
      if ((bGp) && (bGq))
      {
        abwh.Il(10);
        abwh.gN(10, 100);
        bGq = false;
      }
      ThreadManager.removeJobFromThreadPool(fG, 192);
      ThreadManager.excute(fG, 192, null, true);
      break;
      label186:
      bool1 = false;
      break label109;
    }
  }
  
  private static void showToast() {}
  
  private static void startDownload(int paramInt)
  {
    QLog.i("ApolloSoLoader", 1, "[startDownload], libType:" + paramInt);
    long l;
    if (paramInt == 0)
    {
      l = System.currentTimeMillis() - OV;
      if (l < 120000L)
      {
        QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading jsc.");
        if (bGp) {
          abwh.b(10, 200, new Object[] { "it's not time for downloading jsc, deltaT:", Long.valueOf(l) });
        }
      }
    }
    do
    {
      do
      {
        return;
        if (bGp) {
          abwh.b(10, 200, new Object[] { "startDownload:", Long.valueOf(l) });
        }
        OV = System.currentTimeMillis();
        afep.cYK();
        return;
      } while (paramInt != 1);
      l = System.currentTimeMillis() - OU;
      if (l >= 120000L) {
        break;
      }
      QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading sava.");
    } while (!bGp);
    abwh.b(10, 201, new Object[] { "it's not time for downloading jsc, deltaT:", Long.valueOf(l) });
    return;
    OU = System.currentTimeMillis();
    if (bGp) {
      abwh.b(10, 201, new Object[] { "startDownload:", Long.valueOf(l) });
    }
    afeq.cYK();
  }
  
  public static abstract interface a
  {
    public abstract void hO(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyv
 * JD-Core Version:    0.7.0.1
 */