import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.1;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.10;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.11;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.12;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.13;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.15;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.2;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.3;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.6;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.7;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.8;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9;
import com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aglz
{
  private static aglz b;
  private List<aglz.c> Bk = new ArrayList();
  public QQAppInterface app;
  private BroadcastReceiver bg;
  private boolean ceh = false;
  private boolean cei = true;
  private Map<String, aglz.a> kA = new HashMap();
  private Map<String, ahcj.b> kB = new HashMap();
  
  private aglz()
  {
    try
    {
      UniformDownloadPkgInstallReceiver.cx(BaseApplication.getContext());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void E(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "params is null");
      }
      return;
    }
    anqb.a().addDownloadURL(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    localHashMap.put("NetworkType", aqiw.getNetworkType(this.app.getApp()) + "");
    if (arvu.isAppOnForeground(this.app.getApp())) {}
    Object localObject2;
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      localHashMap.put("isForeground", localObject1);
      localHashMap.put("reportVia", "1");
      localObject1 = new Throwable().getStackTrace();
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < localObject1.length)
      {
        ((StringBuilder)localObject2).append(localObject1[i].toString());
        i += 1;
      }
    }
    if (((StringBuilder)localObject2).length() < 950)
    {
      localHashMap.put("Stack", ((StringBuilder)localObject2).toString());
      label198:
      localHashMap.put("_filesize_from_dlg", paramBundle.getLong("_filesize_from_dlg") + "");
      localObject1 = paramBundle.getString("_filename_from_dlg");
      localHashMap.put("_filename_from_dlg", localObject1);
      if (((localObject1 == null) || (!((String)localObject1).endsWith(".apk"))) && (!paramBundle.getString("FILE_MIME_TYPE", "").equals("application/vnd.android.package-archive"))) {
        break label683;
      }
      localHashMap.put("isAPK", "1");
      label289:
      localHashMap.put("ReferURL", paramBundle.getString("param_refer_url", ""));
      paramBundle = paramBundle.getString("DOWNLOAD_BIG_BROTHER_SOURCE");
      paramString = new StringBuilder(paramString);
      paramString.append("|").append((String)localHashMap.get("NetworkType")).append("|").append(paramBundle).append("|").append((String)localObject1).append("|").append((String)localHashMap.get("_filesize_from_dlg")).append("|").append((String)localHashMap.get("ReferURL"));
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        anpc.a(this.app.getApp()).collectPerformance(this.app.getCurrentUin(), "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
        paramBundle = (String)localHashMap.get("isForeground");
        localObject1 = (String)localHashMap.get("isAPK");
        localObject2 = paramString.toString();
        localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
        if (!localHashMap.containsKey("Stack1")) {
          continue;
        }
        paramString = (String)localHashMap.get("Stack1");
        anot.a(null, "dc00898", "", "", "0X800A003", "0X800A003", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        label683:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UniformDownloadMgr<FileAssistant>", 2, paramString.toString());
        continue;
        paramString = "";
        continue;
        QLog.d("UniformDownloadEvent", 2, paramString.toString());
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramString = new StringBuilder();
      paramBundle = localHashMap.keySet().iterator();
      if (!paramBundle.hasNext()) {
        continue;
      }
      localObject1 = (String)paramBundle.next();
      paramString.append((String)localObject1).append("=").append((String)localHashMap.get(localObject1)).append("\n");
      continue;
      localHashMap.put("Stack", ((StringBuilder)localObject2).substring(0, 950));
      if (((StringBuilder)localObject2).length() < 1901)
      {
        localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950));
        break label198;
      }
      localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950, 1900));
      break label198;
      localHashMap.put("isAPK", "0");
      break label289;
      paramString = "";
      continue;
      localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramBundle);
      anpc.a(this.app.getApp()).collectPerformance(this.app.getCurrentUin(), "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      paramBundle = (String)localHashMap.get("isForeground");
      localObject1 = (String)localHashMap.get("isAPK");
      localObject2 = paramString.toString();
      localStringBuilder = new StringBuilder().append((String)localHashMap.get("Stack"));
      if (!localHashMap.containsKey("Stack1")) {
        continue;
      }
      paramString = (String)localHashMap.get("Stack1");
      anot.a(null, "dc00898", "", "", "0X800A002", "0X800A002", 0, 0, paramBundle, (String)localObject1, (String)localObject2, paramString);
    }
  }
  
  private int a(String paramString, Bundle paramBundle)
  {
    int j = 0;
    int i;
    if ((paramString == null) || (paramBundle == null)) {
      i = -1;
    }
    Object localObject1;
    String str;
    long l;
    label209:
    do
    {
      return i;
      localObject1 = paramBundle.getString("_filename_from_dlg");
      try
      {
        localObject2 = URLDecoder.decode((String)localObject1, "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          paramBundle = localUnsupportedEncodingException;
          if (localUnsupportedEncodingException == null) {
            paramBundle = new Bundle();
          }
        }
        int k = localUnsupportedEncodingException.a.getStatus();
        QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. instance is exist.status:" + k + " may be do something. url:" + paramString);
        i = j;
        switch (k)
        {
        }
      }
      E(paramString, paramBundle);
      str = paramBundle.getString("_notify_name_dialog", "");
      l = paramBundle.getLong("_filesize_from_dlg");
      localObject2 = paramBundle.getBundle("_user_data");
      if ((localObject2 == null) && (paramBundle.containsKey("big_brother_source_key")))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("big_brother_source_key", paramBundle.getString("big_brother_source_key"));
        paramBundle = (Bundle)localObject2;
        localObject2 = a(paramString);
        if ((localObject2 != null) && ((localObject2 == null) || (((aglz.a)localObject2).a != null))) {
          break label209;
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. run a new download. url:" + paramString);
        return a(paramString, (String)localObject1, l, str, paramBundle, -1, false);
      }
      return -4;
      return -3;
      paramString = a(paramString);
      i = j;
    } while (paramString == null);
    localUnsupportedEncodingException.a.a(paramString);
    localUnsupportedEncodingException.a.a(paramString, false);
    return 0;
    cX(paramString);
    return 0;
    cU(paramString);
    a(paramString, (String)localObject1, l, str, paramBundle, -1, false);
    return 0;
    cX(paramString);
    return 0;
    cU(paramString);
    return 0;
  }
  
  private int a(String paramString1, String paramString2, long paramLong, String paramString3, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] createAndStartDownloadTask.. param = null");
      return -1;
    }
    long l = fI();
    ahcj localahcj = new ahcj(l, paramString1, paramBundle);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_PARAM_FILENAME", paramString2);
    ((Bundle)localObject).putLong("_PARAM_FILESIZE", paramLong);
    ((Bundle)localObject).putBundle("_PARAM_USER_DATA", paramBundle);
    localahcj.A((Bundle)localObject);
    if (1 == localahcj.getType())
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + paramString1);
      localahcj.a(new agmc(this), true);
      localObject = a(paramString1);
      if (localObject != null) {
        localahcj.a((ahcj.b)localObject, false);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("_notify_param_Filename", paramString2);
      if (TextUtils.isEmpty(paramString3)) {
        break label443;
      }
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramString3);
      label202:
      ((Bundle)localObject).putString("_notify_param_Url", paramString1);
      ((Bundle)localObject).putLong("_notify_param_Filesize", paramLong);
      ((Bundle)localObject).putBundle("_notify_param_userdata", paramBundle);
      paramInt = agme.a().a(localahcj, (Bundle)localObject, l, paramInt);
      a(paramString1, new aglz.a(null, localahcj.getType(), localahcj, l, paramInt));
      if (!paramBoolean) {
        break label455;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramString1);
      localahcj.Ki(true);
    }
    for (;;)
    {
      if (cV(paramString1) == 0)
      {
        localahcj.Ki(true);
        agme.a().E(paramInt, (Bundle)localObject);
      }
      this.cei = false;
      return 0;
      if (2 == localahcj.getType())
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID]. >>>create UniformDownloader.using common. url:" + paramString1);
        break;
      }
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + " - NEW_ID] create UniformDownloader failed. url:" + paramString1);
      return -2;
      label443:
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramString2);
      break label202;
      label455:
      if (this.app != null) {
        if (1 == localahcj.getType()) {
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Start_download_2-0_3-0");
        } else if (2 == localahcj.getType()) {
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Start_download_2-0_3-1");
        }
      }
    }
  }
  
  private aglz.a a(String paramString)
  {
    synchronized (this.kA)
    {
      paramString = (aglz.a)this.kA.get(paramString);
      return paramString;
    }
  }
  
  private aglz.b a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 4)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] rBobjectOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    paramString = new aglz.b();
    paramString.cXM = Integer.parseInt(arrayOfString[0]);
    paramString.fileName = arrayOfString[1];
    paramString.fileSize = Long.parseLong(arrayOfString[2]);
    paramString.ng = Boolean.parseBoolean(arrayOfString[3]);
    if (arrayOfString.length > 4)
    {
      paramString.notifyTitle = arrayOfString[4];
      return paramString;
    }
    paramString.notifyTitle = paramString.fileName;
    return paramString;
  }
  
  private aglz.c a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 2)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] sucInfoOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    return new aglz.c(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  public static aglz a()
  {
    try
    {
      if (b == null)
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr.getInstance.create");
        b = new aglz();
      }
      aglz localaglz = b;
      return localaglz;
    }
    finally {}
  }
  
  private ahcj.b a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (ahcj.b)this.kB.get(paramString);
      }
      finally {}
    }
  }
  
  private String a(aglz.b paramb)
  {
    if (paramb == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramb.cXM) + "^" + paramb.fileName + "^" + String.valueOf(paramb.fileSize) + "^" + String.valueOf(paramb.ng) + "^" + paramb.notifyTitle;
  }
  
  private String a(aglz.c paramc)
  {
    if (paramc == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfSucInfo err, obj=null");
      return null;
    }
    return String.valueOf(paramc.pkgName) + "^" + String.valueOf(paramc.notificationId);
  }
  
  private void a(String paramString, ahcj.b paramb)
  {
    if ((paramString != null) && (paramb != null)) {}
    try
    {
      this.kB.put(paramString, paramb);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean a(String paramString, aglz.a parama)
  {
    if ((paramString == null) || (parama == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. param null");
      return false;
    }
    synchronized (this.kA)
    {
      if (this.kA.containsKey(paramString)) {
        return false;
      }
    }
    this.kA.put(paramString, parama);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] addDownloadInst.. total[" + this.kA.size() + "] add it. url[" + paramString + "]");
    return true;
  }
  
  private int b(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRPauseDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRPauseDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == cW(paramString))
    {
      ahch.a(paramString, new agmd(this));
      agme.a().D(i, (Bundle)paramBundle.clone());
      cV(null);
    }
    return 0;
  }
  
  private ahcj.b b(String paramString)
  {
    try
    {
      paramString = (ahcj.b)this.kB.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private int c(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inRResumeDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    String str1 = paramBundle.getString("_notify_param_Filename");
    String str2 = paramBundle.getString("_notify_param_ContentTitle", "");
    long l = paramBundle.getLong("_notify_param_Filesize");
    paramBundle = paramBundle.getBundle("_notify_param_userdata");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRResumeDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == cX(paramString)) {
      a(paramString, str1, l, str2, paramBundle, i, true);
    }
    return 0;
  }
  
  private int cU(String paramString)
  {
    synchronized (this.kA)
    {
      aglz.a locala = (aglz.a)this.kA.remove(paramString);
      if (locala != null)
      {
        ahcj.b localb = a(paramString);
        if ((locala.a != null) && (localb != null)) {
          locala.a.a(localb);
        }
      }
      int i = this.kA.size();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] delDownloadInst.. total[" + this.kA.size() + "] del it. url[" + paramString + "]");
      return i;
    }
  }
  
  private int cV(String paramString)
  {
    int i = 0;
    if ((aqiw.isNetSupport(BaseApplication.getContext())) && (!ahav.amK())) {}
    for (int m = 2;; m = 1)
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload. togetherDownloadMaxCount=" + m);
      Object localObject2 = new ArrayList();
      synchronized (this.kA)
      {
        if (this.kA.size() <= 0) {
          break label539;
        }
        Iterator localIterator = this.kA.entrySet().iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          aglz.a locala = (aglz.a)((Map.Entry)localIterator.next()).getValue();
          int n = j;
          k = i;
          if (locala.a != null)
          {
            n = j;
            k = i;
            if (locala.a.amN())
            {
              i += 1;
              n = j;
              k = i;
              if (paramString != null)
              {
                n = j;
                k = i;
                if (paramString.equalsIgnoreCase(locala.mUrl))
                {
                  QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is runing. traceUrl:" + paramString);
                  n = 1;
                  k = i;
                }
              }
            }
          }
          ((List)localObject2).add(locala);
          j = n;
          i = k;
        }
      }
      int k = j;
      int j = i;
      i = k;
      for (;;)
      {
        if (j < m)
        {
          ??? = ((List)localObject2).iterator();
          k = i;
          if (((Iterator)???).hasNext())
          {
            localObject2 = (aglz.a)((Iterator)???).next();
            k = j;
            if (((aglz.a)localObject2).a == null) {
              break label533;
            }
            k = j;
            if (!((aglz.a)localObject2).a.amM()) {
              break label533;
            }
            if (j < m)
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((aglz.a)localObject2).mUrl + "]");
              j += 1;
              ((aglz.a)localObject2).a.start();
              k = j;
              if (paramString == null) {
                break label533;
              }
              k = j;
              if (!paramString.equalsIgnoreCase(((aglz.a)localObject2).mUrl)) {
                break label533;
              }
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. download is started. traceUrl:" + paramString);
              i = 2;
            }
          }
        }
        for (;;)
        {
          break;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload.. total[" + this.kA.size() + "] the task of downloading is overload,other need waiting... 1");
          for (k = i;; k = i)
          {
            dig();
            return k;
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTrystartNextDownload.. total[" + this.kA.size() + "] the task of downloading is overload,other need waiting... 2");
          }
          label533:
          j = k;
        }
        label539:
        j = 0;
      }
    }
  }
  
  private int cW(String paramString)
  {
    aglz.a locala = a(paramString);
    if (locala != null)
    {
      if (this.app != null)
      {
        if (locala.mDownloadType != 1) {
          break label71;
        }
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Stop_download_2-2_3-0");
      }
      for (;;)
      {
        if (locala.a != null) {
          locala.a.pause();
        }
        cV(null);
        return 0;
        label71:
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Stop_download_2-2_3-1");
      }
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPPauseDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int cX(String paramString)
  {
    aglz.a locala = a(paramString);
    if (locala != null)
    {
      if (locala.a != null)
      {
        paramString = a(paramString);
        if (paramString != null) {
          locala.a.a(paramString, false);
        }
        locala.a.EN();
      }
      cV(null);
      return 0;
    }
    QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPResumeDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int cY(String paramString)
  {
    aglz.a locala = a(paramString);
    if (locala != null)
    {
      if (locala.a != null) {
        locala.a.stop();
      }
      return 0;
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPStopDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  private int d(String paramString, Bundle paramBundle)
  {
    return c(paramString, paramBundle);
  }
  
  private void dig() {}
  
  private void dii()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.6(this));
  }
  
  private void dij()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] pauseSlienceRuningGenDownloadOfOldApp ...");
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.14(this));
  }
  
  private void dik()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.15(this));
  }
  
  private void din()
  {
    for (;;)
    {
      try
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo...");
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).getAll();
        if (??? != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, size:[" + ((Map)???).size() + "]");
        }
        if ((??? != null) && (((Map)???).size() > 0))
        {
          Iterator localIterator = ((Map)???).entrySet().iterator();
          if (localIterator.hasNext())
          {
            aglz.c localc = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localc == null) {
              break label211;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + localc.pkgName + "]] nId:[" + localc.notificationId + "] ");
            synchronized (this.Bk)
            {
              this.Bk.add(localc);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label211:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, value error. ");
    }
  }
  
  private long fI()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public void A(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.10(this, paramString, paramBundle));
  }
  
  public void B(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.11(this, paramString, paramBundle));
  }
  
  public void C(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.12(this, paramString, paramBundle));
  }
  
  public void D(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.13(this, paramString, paramBundle));
  }
  
  public void IW(String paramString)
  {
    ahcj.b localb = b(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString != null) && (paramString.a != null) && (localb != null)) {
        paramString.a.a(localb);
      }
    }
  }
  
  public void IX(String paramString)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeDownloadingRbResmeInfo, url:[" + paramString + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(aglz.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (!this.ceh)
    {
      din();
      this.ceh = true;
    }
    synchronized (this.Bk)
    {
      this.Bk.add(paramc);
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + paramc.pkgName + " notificationId:" + paramc.notificationId + " size:" + this.Bk.size());
      try
      {
        ??? = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        ((SharedPreferences.Editor)???).putString(a(paramc), "-");
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception paramc)
      {
        paramc.printStackTrace();
        return;
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle, ahcj.b paramb)
  {
    ahcj.b localb = a(paramString);
    a(paramString, paramb);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramBundle, paramString, localb));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "] nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      aglz.b localb = new aglz.b();
      localb.cXM = paramInt;
      localb.fileName = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {}
      for (localb.notifyTitle = paramString3;; localb.notifyTitle = paramString2)
      {
        localb.fileSize = paramLong;
        localb.ng = paramBoolean;
        localb.aV = paramBundle;
        localEditor.putString(paramString1, a(localb));
        localEditor.commit();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public Map<String, aglz.b> an()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str;
      try
      {
        Object localObject1 = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).getAll();
        if (localObject1 != null) {
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, size:[" + ((Map)localObject1).size() + "]");
        }
        if ((localObject1 != null) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject2 = a((String)((Map.Entry)localObject2).getValue());
            if (localObject2 == null) {
              break label224;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + ((aglz.b)localObject2).cXM + "] w:[" + ((aglz.b)localObject2).ng + "]");
            localHashMap.put(str, localObject2);
            continue;
          }
        }
        return localHashMap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label224:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
    }
  }
  
  public void aoq()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppDestroy...");
    this.app = null;
    dij();
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.2(this));
  }
  
  public void cU(QQAppInterface paramQQAppInterface)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppInit...");
    this.app = paramQQAppInterface;
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.1(this));
  }
  
  public List<aglz.c> d(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (!this.ceh)
    {
      din();
      this.ceh = true;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    aglz.c localc;
    synchronized (this.Bk)
    {
      localIterator = this.Bk.iterator();
      while (localIterator.hasNext())
      {
        localc = (aglz.c)localIterator.next();
        if ((localc != null) && (paramString.equalsIgnoreCase("package:" + localc.pkgName))) {
          localArrayList.add(localc);
        }
      }
    }
    if ((localArrayList.size() > 0) && (paramBoolean))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove before size:" + this.Bk.size());
      try
      {
        paramString = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localc = (aglz.c)localIterator.next();
          this.Bk.remove(localc);
          paramString.remove(a(localc));
          continue;
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove after size:" + this.Bk.size());
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    for (;;)
    {
      return localArrayList;
      paramString.commit();
    }
  }
  
  public void dih()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
    synchronized (this.kA)
    {
      if (this.kA.size() > 0)
      {
        Iterator localIterator = this.kA.entrySet().iterator();
        if (localIterator.hasNext())
        {
          aglz.a locala = (aglz.a)((Map.Entry)localIterator.next()).getValue();
          if ((locala.a != null) && (locala.a.amN())) {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + locala.mUrl);
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("_notify_param_Url", locala.mUrl);
          agme.a().F(locala.cXL, localBundle);
          QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + locala.cXL);
        }
      }
    }
    dim();
    dil();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.3(this));
  }
  
  public void dil()
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearDownloadingRbResmeInfo...");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void dim()
  {
    synchronized (this.Bk)
    {
      int i = this.Bk.size();
      this.Bk.clear();
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] clearSucDownloadInfo...size:" + i);
    }
  }
  
  public void eF(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo. pkgName:" + paramString + " notificationId:" + paramInt);
    for (;;)
    {
      synchronized (this.Bk)
      {
        Iterator localIterator = this.Bk.iterator();
        if (localIterator.hasNext())
        {
          localObject = (aglz.c)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((aglz.c)localObject).pkgName)) || (paramInt != ((aglz.c)localObject).notificationId)) {
            continue;
          }
          if (localObject != null)
          {
            this.Bk.remove(localObject);
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] removeSucDownloadInfo done. pkgName:" + paramString + " notificationId:" + paramInt + " size:" + this.Bk.size());
          }
          try
          {
            localObject = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).edit();
            ((SharedPreferences.Editor)localObject).remove(a(new aglz.c(paramString, paramInt)));
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public void fJ(String paramString1, String paramString2)
  {
    ahch.a(paramString1, new agmb(this, paramString1, paramString2));
  }
  
  public QQAppInterface getApp()
  {
    if (this.app == null) {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] APP=null.");
    }
    return this.app;
  }
  
  public boolean ms(String paramString)
  {
    return a(paramString) != null;
  }
  
  public void onActiveAccount()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
    dik();
  }
  
  public void y(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.7(this, paramString, paramBundle));
  }
  
  public void z(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.8(this, paramBundle, paramString));
  }
  
  public class a
  {
    final long Zd;
    public ahcj a;
    final Bundle aU;
    public final int cXL;
    public final int mDownloadType;
    public final String mUrl;
    
    public a(Bundle paramBundle, int paramInt1, ahcj paramahcj, long paramLong, int paramInt2)
    {
      this.aU = paramBundle;
      this.mDownloadType = paramInt1;
      this.a = paramahcj;
      this.Zd = paramLong;
      this.mUrl = paramahcj.getUrl();
      this.cXL = paramInt2;
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] new DownloadInst.[ mUDID:[" + this.Zd + "] url:" + this.mUrl + " ]");
    }
  }
  
  public class b
  {
    public Bundle aV;
    public int cXM;
    public String fileName;
    public long fileSize;
    public boolean ng;
    public String notifyTitle;
    
    b() {}
  }
  
  public static class c
  {
    public Bundle aW;
    public String bIe;
    public int notificationId;
    String pkgName;
    
    public c(String paramString, int paramInt)
    {
      this.pkgName = paramString;
      this.notificationId = paramInt;
      this.aW = new Bundle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglz
 * JD-Core Version:    0.7.0.1
 */