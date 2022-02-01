import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArNativeSoManager.1;
import com.tencent.mobileqq.ar.ArNativeSoManager.3;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;>;
import mqq.os.MqqHandler;

public class ades
{
  adis a;
  private WeakReference<adis.a> gn;
  private WeakReference<adis.a> go;
  private WeakReference<adis.a> gp;
  private WeakReference<adis.a> gq;
  
  public ades(QQAppInterface paramQQAppInterface)
  {
    this.a = new adis(paramQQAppInterface);
  }
  
  private void Gu(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private adis.a a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString.equalsIgnoreCase("arsdk2"))
    {
      localObject1 = localObject2;
      if (this.gn != null) {
        localObject1 = (adis.a)this.gn.get();
      }
    }
    do
    {
      adgv localadgv;
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject1;
              if (!paramString.equalsIgnoreCase("arcloud")) {
                break;
              }
              localObject1 = localObject2;
            } while (this.go == null);
            return (adis.a)this.go.get();
            if (!paramString.equalsIgnoreCase("arfeature")) {
              break;
            }
            localObject1 = localObject2;
          } while (this.gq == null);
          return (adis.a)this.gq.get();
          localadgv = adgt.a();
          localObject1 = localObject2;
        } while (localadgv == null);
        localObject1 = localObject2;
      } while (!paramString.equalsIgnoreCase(localadgv.getKey()));
      localObject1 = localObject2;
    } while (this.gp == null);
    return (adis.a)this.gp.get();
  }
  
  private void a(ARCommonConfigInfo.NativeSoRes paramNativeSoRes, adis.b paramb)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes. fileName = " + paramb.fileName + ", url = " + paramb.url);
    if (this.a == null) {
      return;
    }
    this.a.a(paramb, new adeu(this, paramNativeSoRes));
  }
  
  private void a(String paramString, adis.a parama)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      this.gn = new WeakReference(parama);
    }
    adgv localadgv;
    do
    {
      return;
      if (paramString.equalsIgnoreCase("arcloud"))
      {
        this.go = new WeakReference(parama);
        return;
      }
      if (paramString.equalsIgnoreCase("arfeature"))
      {
        this.gq = new WeakReference(parama);
        return;
      }
      localadgv = adgt.a();
    } while ((localadgv == null) || (!paramString.equalsIgnoreCase(localadgv.getKey())));
    this.gp = new WeakReference(parama);
  }
  
  private boolean aF(String paramString1, String paramString2)
  {
    int i = 0;
    QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. dir = " + paramString1 + ", excludeSubDirOrFile = " + paramString2);
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    if (i < paramString1.length)
    {
      Object localObject = paramString1[i];
      if (!localObject.getAbsolutePath().equalsIgnoreCase(paramString2)) {
        if (localObject.isDirectory())
        {
          bool = aF(localObject.getAbsolutePath(), paramString2);
          if (bool)
          {
            QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
            bool = true;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
        bool = true;
      }
    }
    return bool;
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, adis.a parama)
  {
    boolean bool = false;
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadArNativeSo. resName = " + paramString);
    String str = jL(paramString);
    a(paramString, parama);
    Object localObject1 = new ARCommonConfigInfo.NativeSoRes();
    int i = 0;
    Object localObject2;
    if (i < paramArrayList.size())
    {
      localObject2 = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
      if ((((ARCommonConfigInfo.NativeSoRes)localObject2).name.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject2).version.equalsIgnoreCase(str)))
      {
        paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject2;
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.a != null))
      {
        localObject1 = ader.z(paramArrayList.name, paramArrayList.version, paramArrayList.md5) + File.separator + paramArrayList.md5 + ".zip";
        if (!x((String)localObject1, paramArrayList.md5))
        {
          Gu((String)localObject1);
          if ((!TextUtils.isEmpty(paramArrayList.url)) && (!TextUtils.isEmpty(paramArrayList.md5)))
          {
            localObject2 = new adis.b();
            ((adis.b)localObject2).type = 5;
            ((adis.b)localObject2).url = paramArrayList.url;
            ((adis.b)localObject2).md5 = paramArrayList.md5;
            ((adis.b)localObject2).name = paramArrayList.name;
            ((adis.b)localObject2).fileName = ((String)localObject1);
            ((adis.b)localObject2).bNI = true;
            this.a.a((adis.b)localObject2, new adet(this, paramString, parama));
          }
        }
      }
      label370:
      while (parama == null)
      {
        do
        {
          do
          {
            do
            {
              return;
              i += 1;
              break;
              QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + (String)localObject1);
            } while (parama == null);
            parama.a(false, null);
            return;
            if (kS(paramString)) {
              break label370;
            }
            i = h(paramString, (String)localObject1, paramArrayList.md5);
          } while (parama == null);
          if (i == 0) {
            bool = true;
          }
          parama.a(bool, null);
          return;
        } while (parama == null);
        parama.a(true, null);
        return;
      }
      parama.a(false, null);
      return;
      i = 0;
      paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject1;
    }
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. resName = " + paramString);
    String str1 = jL(paramString);
    int i = 0;
    if (i < paramArrayList2.size())
    {
      ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList2.get(i);
      String str2;
      if (localNativeSoRes.name.equalsIgnoreCase(paramString)) {
        if (localNativeSoRes.version.equalsIgnoreCase(str1))
        {
          str2 = ader.z(localNativeSoRes.name, localNativeSoRes.version, localNativeSoRes.md5) + File.separator + localNativeSoRes.md5 + ".zip";
          if (!x(str2, localNativeSoRes.md5))
          {
            Gu(str2);
            if ((!TextUtils.isEmpty(localNativeSoRes.url)) && (!TextUtils.isEmpty(localNativeSoRes.md5)))
            {
              int j = 0;
              while (j < paramArrayList1.size())
              {
                localObject = (ARCommonConfigInfo.NativeSoRes)paramArrayList1.get(j);
                if ((((ARCommonConfigInfo.NativeSoRes)localObject).name.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject).version.equalsIgnoreCase(str1))) {
                  aF(ader.jK(((ARCommonConfigInfo.NativeSoRes)localObject).name), ader.z(((ARCommonConfigInfo.NativeSoRes)localObject).name, ((ARCommonConfigInfo.NativeSoRes)localObject).version, ((ARCommonConfigInfo.NativeSoRes)localObject).md5));
                }
                j += 1;
              }
              Object localObject = new adis.b();
              ((adis.b)localObject).type = 5;
              ((adis.b)localObject).url = localNativeSoRes.url;
              ((adis.b)localObject).md5 = localNativeSoRes.md5;
              ((adis.b)localObject).name = localNativeSoRes.name;
              ((adis.b)localObject).fileName = str2;
              ((adis.b)localObject).bNI = true;
              a(localNativeSoRes, (adis.b)localObject);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + str2);
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soRes exists, not need to download. soZipFilename = " + str2);
        if (h(paramString, str2, localNativeSoRes.md5) == 0)
        {
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResVersion is not need to download. soResName = " + localNativeSoRes.name + ", soResVersionFromConfig = " + localNativeSoRes.version + ", soResVersionFromLocal = " + str1);
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResName is not need to download. soResName = " + localNativeSoRes.name);
        }
      }
    }
  }
  
  private String jL(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return adey.so();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return "v8.2.0.1";
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return "v8.0.0";
    }
    adgv localadgv = adgt.a();
    if ((localadgv != null) && (paramString.equalsIgnoreCase(localadgv.getKey()))) {
      return localadgv.getVersion();
    }
    return "";
  }
  
  private boolean kS(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return adey.adM();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return adee.adM();
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return adep.adM();
    }
    adgv localadgv = adgt.a();
    if ((localadgv != null) && (paramString.equalsIgnoreCase(localadgv.getKey()))) {
      return adgt.b(localadgv);
    }
    return true;
  }
  
  private boolean x(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(alab.getFileMD5String(paramString1)))
      {
        QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. check md5 failed. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. file is not exist. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, adis.a parama)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.1(this, paramArrayList, paramString, parama));
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.3(this, paramArrayList1, paramArrayList2, paramString));
  }
  
  public boolean b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "isArNativeSoDownload. resName = " + paramString);
    String str = jL(paramString);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
        if ((!localNativeSoRes.name.equalsIgnoreCase(paramString)) || (!localNativeSoRes.version.equalsIgnoreCase(str))) {
          break label155;
        }
        paramArrayList = ader.z(localNativeSoRes.name, localNativeSoRes.version, localNativeSoRes.md5) + File.separator + localNativeSoRes.md5 + ".zip";
        if (!x(paramArrayList, localNativeSoRes.md5)) {
          Gu(paramArrayList);
        }
      }
      else
      {
        return false;
      }
      return kS(paramString);
      label155:
      i += 1;
    }
  }
  
  /* Error */
  public int h(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 43
    //   5: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   8: ifeq +15 -> 23
    //   11: aload_2
    //   12: aload_3
    //   13: invokestatic 322	adey:E	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: aload_1
    //   24: ldc 61
    //   26: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   29: ifeq +13 -> 42
    //   32: aload_2
    //   33: aload_3
    //   34: invokestatic 323	adee:E	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: istore 4
    //   39: goto -21 -> 18
    //   42: aload_1
    //   43: ldc 65
    //   45: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   48: ifeq +13 -> 61
    //   51: aload_2
    //   52: aload_3
    //   53: invokestatic 324	adep:E	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: istore 4
    //   58: goto -40 -> 18
    //   61: invokestatic 72	adgt:a	()Ladgv;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +29 -> 97
    //   71: aload_1
    //   72: aload 5
    //   74: invokeinterface 78 1 0
    //   79: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +15 -> 97
    //   85: aload 5
    //   87: aload_2
    //   88: aload_3
    //   89: invokestatic 327	adgt:a	(Ladgv;Ljava/lang/String;Ljava/lang/String;)I
    //   92: istore 4
    //   94: goto -76 -> 18
    //   97: iconst_m1
    //   98: istore 4
    //   100: goto -82 -> 18
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ades
    //   0	108	1	paramString1	String
    //   0	108	2	paramString2	String
    //   0	108	3	paramString3	String
    //   16	83	4	i	int
    //   64	22	5	localadgv	adgv
    // Exception table:
    //   from	to	target	type
    //   2	18	103	finally
    //   23	39	103	finally
    //   42	58	103	finally
    //   61	66	103	finally
    //   71	94	103	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ades
 * JD-Core Version:    0.7.0.1
 */