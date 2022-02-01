import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class jpn
  implements jpk
{
  private static HashMap<String, jpi> cR = new HashMap();
  private ITMAssistantDownloadClientListener a = new jpo(this);
  public TMAssistantDownloadClient b;
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, jox paramjox, Map<String, String> paramMap)
  {
    if (paramjox == null) {
      return;
    }
    if (paramContext == null)
    {
      paramjox.loaded(paramString1, 11);
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      paramjox.loaded(paramString1, 12);
      return;
    }
    if (AppNetConnInfo.getRecentNetworkInfo() == null)
    {
      paramjox.loaded(paramString1, 10);
      return;
    }
    Object localObject = new File(paramString3.substring(0, paramString3.lastIndexOf("/")));
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      paramjox.loaded(paramString1, 13);
      return;
    }
    localObject = Md5Utils.getMD5(paramString1);
    paramString2 = new jpi((String)localObject, paramString3, paramString2, paramjox);
    cR.put(paramString1, paramString2);
    this.b = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
    this.b.registerDownloadTaskListener(this.a);
    for (;;)
    {
      int i;
      try
      {
        i = this.b.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", (String)localObject, paramMap);
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflineDownload", 2, "offline downloader start, url: " + paramString1);
          }
          try
          {
            paramString3 = new DownloadInfo();
            paramString3.urlStr = paramString1;
            paramString3.filePath = paramString2.filePath;
            paramString3.packageName = paramString2.fileName;
            arvu.a(paramContext, paramString3);
            return;
          }
          catch (Throwable paramContext)
          {
            return;
          }
        }
        if (i != 4) {
          break label365;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + -1 + ", url: " + paramString1);
        }
        paramjox.loaded(paramString1, 10);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + paramString1);
      }
      a(this.b, paramString2, paramString1);
      continue;
      label365:
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + i + ", url: " + paramString1);
      }
      paramjox.loaded(paramString1, 10);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, jox paramjox)
  {
    a(paramContext, paramString1, "0", paramString2, paramjox, null);
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, jpi paramjpi, String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = null;
    Object localObject = null;
    try
    {
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient == null) {}
      for (paramTMAssistantDownloadClient = localObject;; paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath)
      {
        localTMAssistantDownloadClient = paramTMAssistantDownloadClient;
        if (!TextUtils.isEmpty(paramTMAssistantDownloadClient)) {
          break;
        }
        a(paramjpi.b, paramString, paramjpi.bid, 14, "get current download path fail after download");
        return;
      }
      paramTMAssistantDownloadClient = new File(localTMAssistantDownloadClient);
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      }
    }
    finally
    {
      if (TextUtils.isEmpty(null))
      {
        a(paramjpi.b, paramString, paramjpi.bid, 14, "get current download path fail after download");
        return;
      }
    }
    if (!paramTMAssistantDownloadClient.exists())
    {
      a(paramjpi.b, paramString, paramjpi.bid, 15, "cannot get current file after download");
      return;
    }
    if (!aqhq.copyFile(localTMAssistantDownloadClient, paramjpi.filePath))
    {
      a(paramjpi.b, paramString, paramjpi.bid, 16, "rename file fail after download");
      paramTMAssistantDownloadClient.delete();
      return;
    }
    a(paramjpi.b, paramString, paramjpi.bid, 0, "offline zip download success");
  }
  
  public void a(jox paramjox, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString3 + ", bid: " + paramString2 + ", errCode: " + paramInt);
    }
    if ((paramjox != null) && (paramInt >= 0)) {
      paramjox.loaded(paramString1, paramInt);
    }
    cR.remove(paramString1);
  }
  
  public int m(Context paramContext, String paramString)
  {
    this.b = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
    try
    {
      paramContext = this.b.getDownloadTaskState(paramString);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.mState;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void pauseDownload(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.b == null)) {
      return;
    }
    this.b.pauseDownloadTask(paramString);
    this.b.unRegisterDownloadTaskListener(this.a);
    cR.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpn
 * JD-Core Version:    0.7.0.1
 */