import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.FaceScanDownloadManager.1;
import com.tencent.mobileqq.ar.FaceScanDownloadManager.2;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class adfa
{
  public static Handler sMainHandler = new Handler(Looper.getMainLooper());
  private static ArrayList<adfa.a> ui = new ArrayList(2);
  
  public static int G(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).getInt("key_download_cfg_version" + paramQQAppInterface.getLongAccountUin(), 0);
  }
  
  public static void a(adfa.a parama)
  {
    if (parama != null) {}
    try
    {
      if (!ui.contains(parama))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FaceScanDownloadManager", 2, "addDownloadCallback");
        }
        ui.add(parama);
      }
      return;
    }
    finally {}
  }
  
  private static boolean a(afeu paramafeu)
  {
    if (paramafeu == null) {}
    do
    {
      do
      {
        return false;
        paramafeu = paramafeu.b();
      } while (paramafeu == null);
      if ((!TextUtils.isEmpty(paramafeu.strPkgName)) && (!TextUtils.isEmpty(paramafeu.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FaceScanDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramafeu.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramafeu.strResURL_big) + " loadState :" + paramafeu.loadState);
    return false;
    return true;
  }
  
  public static boolean aeb()
  {
    return (adfc.aed()) && (adfb.aec());
  }
  
  public static boolean al(QQAppInterface paramQQAppInterface)
  {
    boolean bool3 = true;
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    afew localafew = (afew)paramQQAppInterface.a("qq.android.ar.face.so_v8.3.6_32");
    boolean bool2 = a(localafew);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (localafew != null)
      {
        bool1 = bool2;
        if (localafew.isSuccess())
        {
          bool1 = bool2;
          if (adfc.aed()) {
            bool1 = true;
          }
        }
      }
    }
    if (bool1) {
      localafew.cYN();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanDownloadManager", 2, "native so config is exist :" + bool1);
    }
    paramQQAppInterface = (afev)paramQQAppInterface.a("qq.android.ar.face.models_v8.2.0");
    bool2 = a(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.isSuccess()) && (adfb.aec())) {
      bool2 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "models config is exist :" + bool2);
      }
      if ((bool1) && (bool2)) {}
      for (bool1 = bool3;; bool1 = false) {
        return bool1;
      }
    }
  }
  
  public static boolean am(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).getBoolean("key_download_cfg_enable" + paramQQAppInterface.getLongAccountUin(), false);
  }
  
  public static void br(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = ui.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        adfa.a locala = (adfa.a)localObject[i];
        sMainHandler.post(new FaceScanDownloadManager.2(locala, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void cG(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
        } while (paramQQAppInterface == null);
        afew localafew = (afew)paramQQAppInterface.a("qq.android.ar.face.so_v8.3.6_32");
        if ((localafew != null) && (localafew.isSuccess()) && (!adfc.aed()))
        {
          localafew.restoreState();
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "reset native so download state");
          }
        }
        paramQQAppInterface = (afev)paramQQAppInterface.a("qq.android.ar.face.models_v8.2.0");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.isSuccess()) || (adfb.aec()));
      paramQQAppInterface.restoreState();
    } while (!QLog.isColorLevel());
    QLog.d("FaceScanDownloadManager", 2, "reset modules so download state");
  }
  
  public static void cH(QQAppInterface paramQQAppInterface)
  {
    s(paramQQAppInterface, 0);
    x(paramQQAppInterface, false);
  }
  
  public static void clearCallback()
  {
    if (ui != null) {
      ui.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanDownloadManager", 2, "clearCallback");
    }
  }
  
  public static void e(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "downloadFaceRes app is null");
      }
      return;
    }
    paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      paramQQAppInterface = null;
    }
    while (paramQQAppInterface != null)
    {
      paramInt = paramQQAppInterface.getVersion();
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanDownloadManager", 2, "initAr version=" + paramQQAppInterface.getVersion());
      }
      if ((bool) && (paramQQAppInterface.isSuccess()) && (paramInt > 1)) {
        break;
      }
      paramQQAppInterface.HL(true);
      return;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.ar.face.models_v8.2.0");
      bool = adfb.aec();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.ar.face.so_v8.3.6_32");
      bool = adfc.aed();
      if (paramQQAppInterface != null) {
        BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", paramQQAppInterface.getVersion()).commit();
      }
    }
  }
  
  public static void hj(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = ui.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        adfa.a locala = (adfa.a)localObject[i];
        sMainHandler.post(new FaceScanDownloadManager.1(locala, paramInt1, paramInt2));
        i += 1;
      }
    }
  }
  
  public static void s(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    localEditor.putInt("key_download_cfg_version" + paramQQAppInterface.getLongAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void s(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
        bool2 = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FaceScanDownloadManager", 2, paramString, paramQQAppInterface);
        return;
      }
      int i = localXmlPullParser.next();
      boolean bool2 = bool1;
      break label173;
      boolean bool1 = bool2;
      if (localXmlPullParser.getName().equalsIgnoreCase("PreDownload"))
      {
        bool1 = bool2;
        if (Integer.valueOf(localXmlPullParser.nextText()).intValue() == 1)
        {
          bool1 = true;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "handleResp_GetArScanFacePreDownConfig success：isPreDownload|version=" + bool2 + "|" + paramInt);
          }
          s(paramQQAppInterface, paramInt);
          x(paramQQAppInterface, bool2);
          return;
          label173:
          if (i != 1)
          {
            bool1 = bool2;
            switch (i)
            {
            }
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public static void x(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    localEditor.putBoolean("key_download_cfg_enable" + paramQQAppInterface.getLongAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static abstract interface a
  {
    public abstract void bq(int paramInt, boolean paramBoolean);
    
    public abstract void onProgress(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */