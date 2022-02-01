import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.2;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class adsm
{
  private static adsm.a a;
  private static boolean bQC;
  private static boolean bQD;
  private static String bvq = "";
  private static int cJM;
  private static Object dh = new Object();
  private static Runnable fG = new JSDebuggerSoLoader.3();
  private static Map<String, Pair<String, String>> jK;
  
  static
  {
    cJM = 1;
    jK = new HashMap();
  }
  
  private static void GR(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new File(paramString);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            File localFile = new File(paramString, localObject[i]);
            if ((localFile.exists()) && (localFile.isFile())) {
              localFile.delete();
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
      }
    }
  }
  
  private static void GS(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
    }
  }
  
  private static void Lu(int paramInt)
  {
    if (a != null) {
      a.onStatusChanged(paramInt);
    }
  }
  
  public static void a(int paramInt, adsm.a parama)
  {
    try
    {
      cUk();
      a = parama;
      cJM = paramInt;
      ThreadManager.remove(fG);
      ThreadManager.post(fG, 5, null, true);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private static boolean afz()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    try
    {
      synchronized (dh)
      {
        if (bQC)
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.sync failed");
          return bool1;
        }
        if (bQD)
        {
          Lu(2);
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.has succeed");
          bool1 = true;
        }
      }
      Lu(0);
    }
    finally {}
    String str1 = sV();
    String str2 = sW();
    Object localObject5;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      GS(str1);
      localObject5 = new File(str1 + "libarkDebuggerJSImpl.so");
      if (((File)localObject5).exists())
      {
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.js debugger so exists:" + localObject5);
        fu(str1, "libarkDebuggerJSImpl.so");
        Lu(2);
        bool1 = bool2;
        break label564;
      }
    }
    label564:
    for (;;)
    {
      bQD = bool1;
      break;
      localObject5 = (Pair)jK.get("");
      if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).second)))
      {
        GS(str2);
        String str3 = str2 + (String)((Pair)localObject5).second;
        if ((new File(str3).exists()) && (g(str2, (String)((Pair)localObject5).second, (String)((Pair)localObject5).second, str1)))
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 1 succeed");
          Lu(3);
          fu(str1, "libarkDebuggerJSImpl.so");
          bool1 = true;
          break label567;
        }
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).first))
        {
          ??? = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (??? != null)
          {
            ??? = (ArkAppCenter)((QQAppInterface)???).getManager(121);
            if (??? != null)
            {
              adqb localadqb = ((ArkAppCenter)???).a();
              if (localadqb != null)
              {
                String str4 = (String)((Pair)localObject5).second;
                GR(str2);
                for (;;)
                {
                  synchronized (dh)
                  {
                    if (!bQC)
                    {
                      Lu(1);
                      localadqb.b((String)((Pair)localObject5).first, 0L, new adsn(str3, str2, str4, str1));
                      bQC = true;
                      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger");
                      bool1 = true;
                    }
                  }
                  QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger.sync failed");
                  bool1 = false;
                }
              }
              QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCGI is null");
              break label570;
            }
            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCenter is null");
            break label570;
          }
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.QQAppInterface is null");
          break label570;
        }
        Lu(7);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage URL is null");
        break label570;
      }
      Lu(7);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage MD5 is null");
      bool1 = false;
      break label564;
      Lu(9);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.necessary dir path is null");
      bool1 = bool3;
    }
    for (;;)
    {
      label567:
      break;
      label570:
      bool1 = false;
    }
  }
  
  private static void cUk()
  {
    Object localObject1 = aeiy.b(186).a();
    if (localObject1 == null) {
      ArkAppCenter.r("JSDebuggerSoLoader", "updateJSDebuggerConfig, confBean is null");
    }
    do
    {
      return;
      localObject1 = ((aeix.b)localObject1).a();
      if (localObject1 == null)
      {
        ArkAppCenter.r("JSDebuggerSoLoader", String.format("updateJSDebuggerConfig, aiKeywordConfig is null", new Object[0]));
        return;
      }
      localObject1 = ((aeje.b)localObject1).vw;
    } while (localObject1 == null);
    jK.clear();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (aeje.e)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        String str1 = ((aeje.e)localObject2).bxQ;
        String str2 = ((aeje.e)localObject2).mUrl;
        localObject2 = ((aeje.e)localObject2).mMd5;
        if ((str1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2))) {
          jK.put(str1, new Pair(str2, localObject2));
        }
      }
    }
    ArkAppCenter.r("JSDebuggerSoLoader", String.format("updateJSDebuggerConfig success.", new Object[0]));
  }
  
  private static void clearState()
  {
    bQD = false;
  }
  
  private static void fu(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ArkAppCenter.ad(new JSDebuggerSoLoader.2(paramString1, paramString2));
    }
  }
  
  private static boolean g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      try
      {
        GR(paramString4);
        paramString2 = new File(paramString1 + paramString2);
        if (paramString2.exists())
        {
          String str = aszr.getFileMD5String(paramString2);
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramString3)))
          {
            aqhq.W(paramString2.getAbsolutePath(), paramString1, false);
            paramString2 = new File(paramString1 + "libarkDebuggerJSImpl.so");
            if ((paramString2 == null) || (!paramString2.exists())) {
              break label406;
            }
            if (aqhq.copyFile(paramString1 + "libarkDebuggerJSImpl.so", paramString4 + "libarkDebuggerJSImpl.so")) {
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libarkDebuggerJSImpl.so");
            }
            for (i = 0;; i = 1)
            {
              paramString2 = new File(paramString1 + "libjsc_ark.so");
              if ((paramString2 == null) || (!paramString2.exists())) {
                break label404;
              }
              if (!aqhq.copyFile(paramString1 + "libjsc_ark.so", paramString4 + "libjsc_ark.so")) {
                break;
              }
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libjsc_ark.so");
              break label412;
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libarkDebuggerJSImpl.so");
            }
            QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libjsc_ark.so");
            i = 1;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString1, new Object[0]);
      }
    }
    label404:
    label406:
    label412:
    do
    {
      return false;
      i = 0;
      break;
    } while (i != 0);
    return true;
  }
  
  public static String sV()
  {
    if (TextUtils.isEmpty(bvq))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label62;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (localObject != null) {
        bvq = ((File)localObject).getParent() + "/txlib/" + "arkdebugger/";
      }
    }
    for (;;)
    {
      return bvq;
      label62:
      QLog.w("JSDebuggerSoLoader", 2, "getLibDirPath but context is null");
    }
  }
  
  private static String sW()
  {
    String str = sV();
    if (!TextUtils.isEmpty(str)) {
      return str + "temp/";
    }
    return "";
  }
  
  public static abstract class a
  {
    public abstract void onStatusChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsm
 * JD-Core Version:    0.7.0.1
 */