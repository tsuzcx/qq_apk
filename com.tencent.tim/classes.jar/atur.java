import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.10;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.11;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.12;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.5;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.8;
import com.tencent.tim.filemanager.core.UniformDownloadMgr.9;
import com.tencent.tim.filemanager.core.UniformDownloadPkgInstallReceiver;
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

public class atur
{
  private static atur a;
  private List<atur.c> Bk = new ArrayList();
  public QQAppInterface app;
  private boolean ceh = false;
  private boolean cei = true;
  private Map<String, atur.a> kA = new HashMap();
  private Map<String, ahcj.b> kB = new HashMap();
  
  private atur()
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
  
  private int a(String paramString, Bundle paramBundle)
  {
    int i = 0;
    if ((paramString == null) || (paramBundle == null))
    {
      i = -1;
      return i;
    }
    Object localObject3 = paramBundle.getString("_filename_from_dlg");
    Object localObject1 = localObject3;
    long l;
    int j;
    Object localObject2;
    try
    {
      if (!paramBundle.getBoolean("_filename_disable_urldecode_", false)) {
        localObject1 = URLDecoder.decode((String)localObject3, "utf-8");
      }
      l = paramBundle.getLong("_filesize_from_dlg");
      localObject3 = paramBundle.getBundle("_user_data");
      j = paramBundle.getInt("_notify_param_Id", -1);
      paramBundle = a(paramString);
      if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.a == null)))
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. run a new download. url:" + paramString);
        return a(paramString, (String)localObject1, l, (Bundle)localObject3, j, false);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        localObject2 = localObject3;
      }
      int k = paramBundle.a.getStatus();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRStartDownload. instance is exist.status:" + k + " may be do something. url:" + paramString);
      switch (k)
      {
      }
    }
    return -4;
    return -3;
    cX(paramString);
    return 0;
    cU(paramString);
    a(paramString, localObject2, l, (Bundle)localObject3, j, false);
    return 0;
    cX(paramString);
    return 0;
    cU(paramString);
    return 0;
  }
  
  private int a(String paramString1, String paramString2, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
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
      localahcj.a(new atut(this), true);
      localObject = a(paramString1);
      if (localObject != null) {
        localahcj.a((ahcj.b)localObject, false);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("_notify_param_Filename", paramString2);
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramString2);
      ((Bundle)localObject).putString("_notify_param_Url", paramString1);
      ((Bundle)localObject).putLong("_notify_param_Filesize", paramLong);
      ((Bundle)localObject).putBundle("_notify_param_userdata", paramBundle);
      paramInt = atuv.a().a(localahcj, (Bundle)localObject, l, paramInt);
      a(paramString1, new atur.a(null, localahcj.getType(), localahcj, l, paramInt));
      if (!paramBoolean) {
        break label414;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramString1);
      localahcj.Ki(true);
    }
    for (;;)
    {
      if (cV(paramString1) == 0)
      {
        localahcj.Ki(true);
        atuv.a().E(paramInt, (Bundle)localObject);
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
      label414:
      if (this.app != null) {
        if (1 == localahcj.getType()) {
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Start_download_2-0_3-0");
        } else if (2 == localahcj.getType()) {
          anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "Start_download_2-0_3-1");
        }
      }
    }
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
  
  private atur.b a(String paramString)
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
    paramString = new atur.b();
    paramString.cXM = Integer.parseInt(arrayOfString[0]);
    paramString.fileName = arrayOfString[1];
    paramString.fileSize = Long.parseLong(arrayOfString[2]);
    paramString.ng = Boolean.parseBoolean(arrayOfString[3]);
    return paramString;
  }
  
  private atur.c a(String paramString)
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
    return new atur.c(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  public static atur a()
  {
    try
    {
      if (a == null)
      {
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr.getInstance.create");
        a = new atur();
      }
      atur localatur = a;
      return localatur;
    }
    finally {}
  }
  
  private String a(atur.b paramb)
  {
    if (paramb == null)
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramb.cXM) + "^" + paramb.fileName + "^" + String.valueOf(paramb.fileSize) + "^" + String.valueOf(paramb.ng);
  }
  
  private String a(atur.c paramc)
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
  
  private boolean a(String paramString, atur.a parama)
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
      ahch.a(paramString, new atuu(this));
      atuv.a().D(i, (Bundle)paramBundle.clone());
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
    String str = paramBundle.getString("_notify_param_Filename");
    long l = paramBundle.getLong("_notify_param_Filesize");
    paramBundle = paramBundle.getBundle("_notify_param_userdata");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>inRResumeDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == cX(paramString)) {
      a(paramString, str, l, paramBundle, i, true);
    }
    return 0;
  }
  
  private int cU(String paramString)
  {
    synchronized (this.kA)
    {
      atur.a locala = (atur.a)this.kA.remove(paramString);
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
    if ((aqiw.isNetSupport(BaseApplication.getContext())) && (!audx.amK())) {}
    for (int m = 2;; m = 1)
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] inPTryStartNextDownload. togetherDownloadMaxCount=" + m);
      Object localObject2 = new ArrayList();
      synchronized (this.kA)
      {
        if (this.kA.size() <= 0) {
          break label533;
        }
        Iterator localIterator = this.kA.entrySet().iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          atur.a locala = (atur.a)((Map.Entry)localIterator.next()).getValue();
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
            localObject2 = (atur.a)((Iterator)???).next();
            k = j;
            if (((atur.a)localObject2).a == null) {
              break label527;
            }
            k = j;
            if (!((atur.a)localObject2).a.amM()) {
              break label527;
            }
            if (j < m)
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((atur.a)localObject2).mUrl + "]");
              j += 1;
              ((atur.a)localObject2).a.start();
              k = j;
              if (paramString == null) {
                break label527;
              }
              k = j;
              if (!paramString.equalsIgnoreCase(((atur.a)localObject2).mUrl)) {
                break label527;
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
          label527:
          j = k;
        }
        label533:
        j = 0;
      }
    }
  }
  
  private int cW(String paramString)
  {
    atur.a locala = a(paramString);
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
    atur.a locala = a(paramString);
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
    atur.a locala = a(paramString);
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
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.5(this));
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
            atur.c localc = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localc == null) {
              break label208;
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
      label208:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] initSucDownloadInfo, value error. ");
    }
  }
  
  private long fI()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public void A(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramString, paramBundle));
  }
  
  public void B(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.10(this, paramString, paramBundle));
  }
  
  public void C(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.11(this, paramString, paramBundle));
  }
  
  public void D(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.12(this, paramString, paramBundle));
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
  
  public void Zd(String paramString)
  {
    ahch.a(paramString, new atus(this, paramString));
  }
  
  public atur.a a(String paramString)
  {
    synchronized (this.kA)
    {
      paramString = (atur.a)this.kA.get(paramString);
      return paramString;
    }
  }
  
  public void a(atur.c paramc)
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
    a(paramString, paramb);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.8(this, paramBundle, paramString));
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "] nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0).edit();
      atur.b localb = new atur.b();
      localb.cXM = paramInt;
      localb.fileName = paramString2;
      localb.fileSize = paramLong;
      localb.ng = paramBoolean;
      localb.aV = paramBundle;
      localEditor.putString(paramString1, a(localb));
      localEditor.commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public Map<String, atur.b> an()
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
              break label222;
            }
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + ((atur.b)localObject2).cXM + "] w:[" + ((atur.b)localObject2).ng + "]");
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
      label222:
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
    }
  }
  
  public List<atur.c> d(String paramString, boolean paramBoolean)
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
    atur.c localc;
    synchronized (this.Bk)
    {
      localIterator = this.Bk.iterator();
      while (localIterator.hasNext())
      {
        localc = (atur.c)localIterator.next();
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
          localc = (atur.c)localIterator.next();
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
          localObject = (atur.c)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((atur.c)localObject).pkgName)) || (paramInt != ((atur.c)localObject).notificationId)) {
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
            ((SharedPreferences.Editor)localObject).remove(a(new atur.c(paramString, paramInt)));
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
    
    b() {}
  }
  
  public static class c
  {
    public int notificationId;
    String pkgName;
    
    public c(String paramString, int paramInt)
    {
      this.pkgName = paramString;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atur
 * JD-Core Version:    0.7.0.1
 */