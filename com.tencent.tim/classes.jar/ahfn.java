import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ahfn
{
  private static ahfn.a a = new ahfn.a(null);
  private static ahfn.a b = new ahfn.a(null);
  private static final String[] fh = { "libflutter.so" };
  private static final String[] fi = { "libapp.so", "libqflutter-resource-loader.so", "res.apk" };
  private static ArrayList<ahfn.b> mCallbacks;
  private static volatile boolean mIsDownloading;
  public static Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    mCallbacks = new ArrayList();
  }
  
  private static void a(ahfn.b paramb)
  {
    if (paramb != null) {}
    try
    {
      if (!mCallbacks.contains(paramb)) {
        mCallbacks.add(paramb);
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ahfn.b paramb)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      try
      {
        bool2 = aQ(paramQQAppInterface);
        bool3 = aR(paramQQAppInterface);
        a(paramb);
        StringBuilder localStringBuilder = new StringBuilder().append("install isEngineReady:").append(bool2).append(" isAppReady:").append(bool3).append(" installCallback:");
        if (paramb != null)
        {
          QLog.i("QFlutter.QFlutterDownloadManager", 1, bool1);
          if ((bool2) && (bool3)) {
            u(true, true, true);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        if (mIsDownloading)
        {
          QLog.d("QFlutter.QFlutterDownloadManager", 1, "install, is downloading...");
          continue;
        }
        mIsDownloading = true;
      }
      finally {}
      paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
      if (!bool2)
      {
        a.restart();
        ((ahfm)paramQQAppInterface.a("qq.android.flutter.engine.v8.3.3")).HL(true);
      }
      for (;;)
      {
        if (bool3) {
          break label194;
        }
        b.restart();
        ((ahfl)paramQQAppInterface.a("qq.android.flutter.app.v8.3.6")).HL(true);
        break;
        a.bZ(true, true);
      }
      label194:
      a.bZ(true, true);
    }
  }
  
  private static boolean a(QFlutterAppData paramQFlutterAppData)
  {
    if (paramQFlutterAppData == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkAppFiles, engineData == null");
      return false;
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put(ll("libapp.so"), paramQFlutterAppData.libAppSoMD5);
    ((HashMap)localObject1).put(ll("libqflutter-resource-loader.so"), paramQFlutterAppData.libSkinSoMD5);
    ((HashMap)localObject1).put(ll("res.apk"), paramQFlutterAppData.assetResMD5);
    paramQFlutterAppData = ((HashMap)localObject1).entrySet().iterator();
    Object localObject2;
    boolean bool;
    if (paramQFlutterAppData.hasNext())
    {
      localObject2 = (Map.Entry)paramQFlutterAppData.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      if (!ahbj.isFileExists((String)localObject1))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkAppFiles, %s is not exist", new Object[] { localObject1 }));
        bool = false;
      }
    }
    for (;;)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkAppFiles result: " + bool);
      return bool;
      String str = alab.getFileMD5String((String)localObject1);
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equalsIgnoreCase(str))) {
        break;
      }
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkAppFiles, %s md5 check fail, md5: %s fileMD5: %s", new Object[] { localObject1, localObject2, str }));
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private static boolean a(QFlutterEngineData paramQFlutterEngineData)
  {
    if (paramQFlutterEngineData == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles, engineData == null");
      return false;
    }
    Object localObject = new File(wj(), "libflutter.so");
    if (!((File)localObject).exists())
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles, libEngineFile is not exist");
      return false;
    }
    localObject = alab.getFileMD5String(((File)localObject).getAbsolutePath());
    if ((TextUtils.isEmpty(paramQFlutterEngineData.libEngineSoMD5)) || (!paramQFlutterEngineData.libEngineSoMD5.equalsIgnoreCase((String)localObject)))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("checkEngineFiles, libEngineFile md5 check fail, md5: %s fileMD5: %s", new Object[] { paramQFlutterEngineData.libEngineSoMD5, localObject }));
      return false;
    }
    QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkEngineFiles success");
    return true;
  }
  
  public static boolean a(String paramString, QFlutterAppData paramQFlutterAppData)
  {
    try
    {
      dni();
      aqhq.W(paramString, wj(), false);
      if (!a(paramQFlutterAppData))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "installApp check failed, srcPath: " + paramString);
        dni();
        return false;
      }
    }
    catch (IOException paramQFlutterAppData)
    {
      paramQFlutterAppData.printStackTrace();
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "uncompressZip fail: " + paramString);
      dni();
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, QFlutterEngineData paramQFlutterEngineData)
  {
    try
    {
      dnj();
      aqhq.W(paramString, wj(), false);
      if (!a(paramQFlutterEngineData))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "installEngine check failed, srcPath: " + paramString);
        dnj();
        return false;
      }
    }
    catch (IOException paramQFlutterEngineData)
    {
      paramQFlutterEngineData.printStackTrace();
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "uncompressZip fail: " + paramString);
      dnj();
      return false;
    }
    return true;
  }
  
  private static boolean aQ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (ahfm)((afem)paramQQAppInterface.getManager(77)).a("qq.android.flutter.engine.v8.3.3");
    boolean bool2 = b(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.isSuccess()) && (a((QFlutterEngineData)paramQQAppInterface.b()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isEngineConfigReady : %s, isEngineInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
  
  private static boolean aR(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (ahfl)((afem)paramQQAppInterface.getManager(77)).a("qq.android.flutter.app.v8.3.6");
    boolean bool2 = b(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.isSuccess()) && (a((QFlutterAppData)paramQQAppInterface.b()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isAppConfigReady: %s, isAppInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
  
  private static boolean b(afeu paramafeu)
  {
    if (paramafeu == null) {
      return false;
    }
    paramafeu = paramafeu.b();
    if (paramafeu == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "isEarlyDownloadConfigReady, data == null");
      return false;
    }
    if ((TextUtils.isEmpty(paramafeu.strPkgName)) || (TextUtils.isEmpty(paramafeu.strResURL_big)))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("isEarlyDownloadConfigReady, strPkgName: %s, strResURL_big: %s", new Object[] { paramafeu.strPkgName, paramafeu.strResURL_big }));
      return false;
    }
    return true;
  }
  
  public static void bA(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    label162:
    for (;;)
    {
      try
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("onDownloadFinish, type: %s, isSuccess: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
        if (paramInt == 0)
        {
          a.bZ(paramBoolean, false);
          if ((b.isFinished()) && (a.isFinished()))
          {
            if ((!b.isSuccess) || (!a.isSuccess)) {
              break label162;
            }
            paramBoolean = bool;
            long l = Math.max(ahfn.a.a(b), ahfn.a.a(a));
            u(paramBoolean, ahfn.a.a(a), ahfn.a.a(b));
            ahgd.a(paramBoolean, l, ahfn.a.a(a), ahfn.a.a(b));
          }
        }
        else
        {
          if (paramInt != 1) {
            continue;
          }
          b.bZ(paramBoolean, false);
          continue;
        }
        paramBoolean = false;
      }
      finally {}
    }
  }
  
  private static void dni()
  {
    String[] arrayOfString = fi;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      aqhq.deleteFile(ll(arrayOfString[i]));
      i += 1;
    }
  }
  
  private static void dnj()
  {
    String[] arrayOfString = fh;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      aqhq.deleteFile(ll(arrayOfString[i]));
      i += 1;
    }
  }
  
  public static void i(int paramInt, long paramLong1, long paramLong2) {}
  
  public static String ll(String paramString)
  {
    return new File(wj(), paramString).getAbsolutePath();
  }
  
  private static void u(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      int i;
      try
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("notifyResult, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
        i = 0;
        if (i < mCallbacks.size())
        {
          ahfn.b localb = (ahfn.b)mCallbacks.get(i);
          if (paramBoolean1) {
            localb.b(true, wj(), paramBoolean2, paramBoolean3);
          } else {
            localb.b(false, null, paramBoolean2, paramBoolean3);
          }
        }
      }
      finally {}
      mCallbacks.clear();
      mIsDownloading = false;
      return;
      i += 1;
    }
  }
  
  public static String wj()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    return localFile.getAbsolutePath() + File.separator + "qflutter";
  }
  
  static class a
  {
    private long aax;
    private boolean cgE;
    private long costTime;
    public boolean isSuccess;
    private long startTime;
    public int status = 1;
    private long totalLen;
    
    public void bZ(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.isSuccess = paramBoolean1;
      this.status = 2;
      this.cgE = paramBoolean2;
      this.costTime = (System.currentTimeMillis() - this.startTime);
    }
    
    public boolean isFinished()
    {
      return this.status == 2;
    }
    
    public void restart()
    {
      this.status = 1;
      this.isSuccess = false;
      this.aax = 0L;
      this.totalLen = 0L;
      this.cgE = false;
      this.startTime = System.currentTimeMillis();
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void onProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfn
 * JD-Core Version:    0.7.0.1
 */