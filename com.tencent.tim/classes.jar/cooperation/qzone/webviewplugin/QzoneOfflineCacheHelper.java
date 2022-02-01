package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import avsu;
import avsw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneOfflineCacheHelper
{
  private static final int DOWNLOAD_DELAY_TIME = 10000;
  private static final String TAG = "QzoneOfflineCacheHelper";
  private static final int UPDATE_LRU_FILE_DELAY_TIME = 20000;
  private static final byte[] URL_LOCK = new byte[0];
  private static ConcurrentHashMap<String, ArrayList<Object>> downloadindUrlMap = new ConcurrentHashMap();
  private static avsw mFileCache;
  
  public static boolean checkFileIfExist(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    String str;
    do
    {
      return false;
      str = urlKey2FileName(paramString, true);
      str = getFileCache().getPath(str);
      if (new File(str).exists())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file exist,url:%s,path:%s", new Object[] { paramString, str }));
        }
        return true;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file not exist,url:%s,path:%s", new Object[] { paramString, str }));
    return false;
  }
  
  public static File downLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack, boolean paramBoolean, String paramString2)
  {
    File localFile1;
    for (;;)
    {
      try
      {
        if (!URLUtil.isNetworkUrl(paramString1)) {
          return null;
        }
        str2 = urlKey2FileName(paramString1, true);
        if (!paramBoolean)
        {
          str1 = avsu.e().getPath("dressup");
          localFile1 = new File(str1);
          if (!localFile1.exists()) {
            localFile1.mkdirs();
          }
          str2 = str1 + File.separator + str2;
          localFile1 = new File(str2);
          File localFile2 = new File(str2 + ".headers");
          if ((!localFile1.exists()) || (localFile1.length() <= 0L) || (!localFile2.exists()) || (localFile2.length() <= 0L)) {
            break label253;
          }
          if (paramBoolean) {
            break label245;
          }
          updateLruFileInNewThread(str1);
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflineCacheHelper", 2, String.format("file exist,update lru,url:%s ,path:%s", new Object[] { paramString1, str2 }));
          }
          if (paramQzoneOfflineCacheHelperCallBack == null) {
            break;
          }
          paramQzoneOfflineCacheHelperCallBack.onResultOfNativeRequest(true, str2);
          return localFile1;
        }
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("QzoneOfflineCacheHelper", 1, paramAppInterface, new Object[0]);
        return null;
      }
      String str2 = getFileCache().getPath(str2);
      String str1 = "";
      continue;
      label245:
      updateLruFileInNewThread(str2);
      continue;
      label253:
      if (paramBoolean)
      {
        int i = getTBSCoreVersion();
        if (!TextUtils.isEmpty(paramString2)) {
          downloadAfterGetDomainAndTBSVersion(paramAppInterface, paramString1, str2, getProtocolAndDomainOfCurrentWebPage(paramString2), i, paramQzoneOfflineCacheHelperCallBack);
        } else if (QLog.isDevelopLevel()) {
          QLog.e("QzoneOfflineCacheHelper", 1, "offline webview Url is empty!");
        }
      }
      else
      {
        downloadAfterGetDomainAndTBSVersion(paramAppInterface, paramString1, str2, "", 0, paramQzoneOfflineCacheHelperCallBack);
      }
    }
    return localFile1;
  }
  
  public static void downloadAfterGetDomainAndTBSVersion(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    for (;;)
    {
      synchronized (URL_LOCK)
      {
        if (downloadindUrlMap != null)
        {
          ArrayList localArrayList = (ArrayList)downloadindUrlMap.get(paramString1);
          if (localArrayList != null) {
            break label133;
          }
          i = 0;
          localArrayList = new ArrayList();
          if (!localArrayList.contains(paramQzoneOfflineCacheHelperCallBack))
          {
            if (paramQzoneOfflineCacheHelperCallBack != null)
            {
              localArrayList.add(paramQzoneOfflineCacheHelperCallBack);
              downloadindUrlMap.put(paramString1, localArrayList);
            }
          }
          else
          {
            if (i == 0) {
              break label103;
            }
            return;
          }
          paramQzoneOfflineCacheHelperCallBack = new Object();
        }
      }
      label103:
      paramAppInterface = new QzoneOfflineCacheHelper.2(paramString1, paramString2, paramAppInterface, paramString3, paramInt);
      QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(paramAppInterface, 10000L);
      return;
      label133:
      int i = 1;
    }
  }
  
  private static avsw getFileCache()
  {
    if (mFileCache == null) {
      mFileCache = avsu.b();
    }
    return mFileCache;
  }
  
  private static String getProtocolAndDomainOfCurrentWebPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString);
      paramString = paramString.getProtocol() + "://" + paramString.getHost();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneOfflineCacheHelper", 2, "getProtocolAndDomainOfCurrentWebPage error", paramString);
    }
    return null;
  }
  
  public static long getSmallGameLastCacheTime(long paramLong)
  {
    long l1 = 0L;
    if (paramLong <= 0L) {}
    long l2;
    do
    {
      return l1;
      l2 = LocalMultiProcConfig.getLong4Uin("key_qzone_preload_small_game_finish_", 0L, paramLong);
      l1 = l2;
    } while (!QLog.isDevelopLevel());
    QLog.i("QzoneOfflineCacheHelper", 2, "uin=" + paramLong + ",getSmallGameLastCacheTime cacheTime=" + l2);
    return l2;
  }
  
  private static int getTBSCoreVersion()
  {
    int i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.i("QzoneOfflineCacheHelper", 2, "tbsCoreVersion= " + i);
    }
    return i;
  }
  
  public static void updataSmallGameLastCacheFinishTime(long paramLong1, long paramLong2)
  {
    if (paramLong1 <= 0L) {}
    try
    {
      QLog.w("QzoneOfflineCacheHelper", 1, "updataSmallGameLastCacheFinishTime uin is invalid,uin=" + paramLong1);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QzoneOfflineCacheHelper", 1, "updataSmallGameLastCacheFinishTime error.", localException);
    }
    LocalMultiProcConfig.putLong4Uin("key_qzone_preload_small_game_finish_", paramLong2, paramLong1);
    if (QLog.isDevelopLevel())
    {
      QLog.i("QzoneOfflineCacheHelper", 2, "uin=" + paramLong1 + ",updataSmallGameLastCacheFinishTime timestamp=" + paramLong2);
      return;
    }
  }
  
  public static void updateLruFileInNewThread(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(new QzoneOfflineCacheHelper.1(paramString), 20000L);
  }
  
  private static String urlKey2FileName(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = String.valueOf(paramString.hashCode());
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith("file://"));
    return paramString.substring("file://".length(), paramString.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper
 * JD-Core Version:    0.7.0.1
 */