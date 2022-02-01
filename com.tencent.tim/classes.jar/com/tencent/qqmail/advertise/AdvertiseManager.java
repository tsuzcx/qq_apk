package com.tencent.qqmail.advertise;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.uma.QMUmaManager;
import com.tencent.qqmail.utilities.CrashGuard;
import com.tencent.qqmail.utilities.CrashGuard.Key;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvertiseManager
{
  public static final String PULL_DOWN_IMAGE_GIF_FILE_NAME = "lastpush.gif";
  public static final String PULL_DOWN_IMAGE_PNG_FILE_NAME = "lastpush.png";
  public static final String TAG = "AdvertiseManager";
  private static volatile AdvertiseManager instance;
  private boolean showPullDownIcon = false;
  
  public static AdvertiseManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AdvertiseManager();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean needToUpdate()
  {
    bool1 = false;
    bool2 = true;
    Object localObject1 = QMSharedPreferenceManager.getInstance().getPullDownADLastUpdateTime();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      QMLog.log(4, "AdvertiseManager", "needToUpdate true_ ");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            try
            {
              long l1 = Long.parseLong((String)localObject1);
              long l2 = System.currentTimeMillis();
              if (l2 - l1 > 86400000L) {
                bool1 = true;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                Matcher localMatcher;
                localNumberFormatException.printStackTrace();
                bool1 = false;
                continue;
                bool2 = bool1;
              }
            }
            if (bool1) {
              break label335;
            }
            QMLog.log(4, "AdvertiseManager", "needToUpdate getPopularizeUpdateFactor");
            localObject2 = AccountManager.shareInstance().getAccountList();
            localObject1 = ((AccountList)localObject2).getDefaultMailAccount();
            if (localObject1 == null) {
              break;
            }
            str = QMSharedPreferenceManager.getInstance().getPopularizeUpdateFactor();
            localMatcher = Pattern.compile("email=(.*?)(,\\s|\\}$)").matcher(str);
          } while ((localMatcher.find()) && (!Uri.encode(((Account)localObject1).getEmail()).equals(localMatcher.group(1))));
          localMatcher = Pattern.compile("nick=(.*?)(,\\s|\\}$)").matcher(str);
        } while ((localMatcher.find()) && (((AccountList)localObject2).getDefaultNickName() != null) && (!Uri.encode(((AccountList)localObject2).getDefaultNickName()).equals(localMatcher.group(1))));
        localObject2 = Pattern.compile("sid=(.*?)(,\\s|\\}$)").matcher(str);
      } while ((((Matcher)localObject2).find()) && (((QQMailAccount)localObject1).getSid() != null) && ((!(localObject1 instanceof QQMailAccount)) || (!Uri.encode(((QQMailAccount)localObject1).getSid()).equals(((Matcher)localObject2).group(1)))));
      localObject1 = Pattern.compile("session=(.*?)(,\\s|\\}$)").matcher(str);
    } while ((((Matcher)localObject1).find()) && (QMUmaManager.sharedInstance().getUmaLoginSessionKey() != null) && (!Uri.encode(QMUmaManager.sharedInstance().getUmaLoginSessionKey()).equals(((Matcher)localObject1).group(1))));
    bool2 = bool1;
    QMLog.log(4, "AdvertiseManager", "needToUpdate " + bool2);
    return bool2;
  }
  
  private void updatePullDownImage()
  {
    QMLog.log(4, "AdvertiseManager", "updatePullDownImage");
    Popularize localPopularize = getPullDownPopularize();
    if (localPopularize == null) {
      return;
    }
    QMSettingManager.sharedInstance().setPullDownPopularizeURL(localPopularize.getOpenUrl());
    boolean bool1 = ensureLastPushAdvertiseImage();
    boolean bool2 = ensureAdvertiseImage();
    boolean bool3 = SharedPreferenceUtil.getHasLastPushAdvertiseImage();
    QMLog.log(4, "AdvertiseManager", "hasNewPushAdvertiseImg = " + bool3 + " hasDecodeAdvertiseGif = " + bool2);
    if ((bool1) && ((!bool2) || (bool3 == true)))
    {
      QMLog.log(4, "AdvertiseManager", "Try to decode advertise-image-again! hasNewPushAdvertiseImg = " + bool3 + " hasDecodeAdvertiseGif = " + bool2);
      AdvertiseImageDecoder.getInstance().startDecode();
      return;
    }
    if ((!bool2) && (!bool1))
    {
      QMLog.log(4, "AdvertiseManager", "May be the device losed to download image, or the local image has been deleted. Now We try to downlaod it again");
      downloadPullDownImage(localPopularize.getResourceType(), localPopularize.getImageUrl(), localPopularize.getImageMd5());
      return;
    }
    QMLog.log(4, "AdvertiseManager", "It's OK! hasNewPushAdvertiseImg = " + bool3 + " hasDecodeAdvertiseGif = " + bool2);
  }
  
  public void clearLastPushImage()
  {
    AdvertiseFileUtils.getInstance().clearLastPushImagePath();
  }
  
  public void downloadPullDownImage(int paramInt, String paramString1, String paramString2)
  {
    QMLog.log(4, "AdvertiseManager", "downloadPullDownImage");
    if (!URLUtil.isValidUrl(paramString1))
    {
      QMLog.log(5, "AdvertiseManager", "downloadPullDownImage url is invalid!!! " + paramString1);
      return;
    }
    DownloadTask localDownloadTask = new DownloadTask();
    localDownloadTask.setUrl(paramString1);
    if ((isSameImage(getPullDownPopularize(), paramString2)) && (ensureLastPushAdvertiseImage()))
    {
      QMLog.log(4, "AdvertiseManager", "The same picture! downloadPullDownImage quit! md5 = " + paramString2);
      return;
    }
    if (paramInt == 0) {}
    for (paramString1 = "lastpush.png";; paramString1 = "lastpush.gif")
    {
      localDownloadTask.setFileName(paramString1);
      localDownloadTask.setFilePath(FileUtil.getLastPushAdvertiseImgDir() + localDownloadTask.getFileName());
      localDownloadTask.setSingleTaskDownload(true);
      localDownloadTask.setId(DownloadTask.generateHashId(localDownloadTask.getUrl(), localDownloadTask.getFilePath()));
      localDownloadTask.setListener(new AdvertiseManager.3(this, paramString2));
      localDownloadTask.start();
      return;
      if (paramInt != 1) {
        break;
      }
    }
    QMLog.log(6, "AdvertiseManager", "resourceType MUST be PopularizeResourceImage or PopularizeResourceGif, current value is " + paramInt);
  }
  
  public boolean ensureAdvertiseAvailable()
  {
    try
    {
      boolean bool;
      if ((ensureAdvertiseConfigAndTime()) && (ensureAdvertiseURL()) && (ensureAdvertiseHtml()) && (ensureAdvertiseImage())) {
        bool = hasCrashTooMuch();
      }
      return !bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean ensureAdvertiseConfigAndTime()
  {
    QMLog.log(4, "AdvertiseManager", "ensureAdvertiseConfigAndTime");
    Popularize localPopularize = getPullDownPopularize();
    if (localPopularize == null)
    {
      QMLog.log(4, "AdvertiseManager", "ensureAdvertiseConfigAndTime There is not Popularize about pull-down-ads");
      return false;
    }
    QMLog.log(4, "AdvertiseManager", "ensureAdvertiseConfigAndTime There is A Popularize about Pull-DOWN-ADS : " + localPopularize.toString());
    QMSettingManager.sharedInstance().setPullDownPopularizeURL(localPopularize.getOpenUrl());
    if (localPopularize.isExpire())
    {
      QMLog.log(4, "AdvertiseManager", "ensureAdvertiseConfigAndTime Popularize about pull-down-ads is Expire");
      return false;
    }
    QMLog.log(4, "AdvertiseManager", "ensureAdvertiseConfigAndTime Popularize about pull-down-ads is-NOT-Expire");
    return true;
  }
  
  public boolean ensureAdvertiseHtml()
  {
    return !TextUtils.isEmpty(QMSharedPreferenceManager.getInstance().getPullDownADHtml());
  }
  
  public boolean ensureAdvertiseImage()
  {
    String[] arrayOfString = AdvertiseFileUtils.getInstance().listCurrAdvertiseImagePath();
    return (arrayOfString != null) && (arrayOfString.length > 0);
  }
  
  public boolean ensureAdvertiseURL()
  {
    return !TextUtils.isEmpty(QMSettingManager.sharedInstance().getPullDownPopularizeURL());
  }
  
  public boolean ensureLastPushAdvertiseImage()
  {
    String[] arrayOfString = AdvertiseFileUtils.getInstance().listLastPushImagePath();
    return (arrayOfString != null) && (arrayOfString.length > 0);
  }
  
  public Popularize getPullDownPopularize()
  {
    ArrayList localArrayList = PopularizeManager.sharedInstance().getPopularizeByType(8);
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Popularize localPopularize = (Popularize)localIterator.next();
      if (!localPopularize.isExpire()) {
        return localPopularize;
      }
    }
    return (Popularize)localArrayList.get(0);
  }
  
  public boolean hasCrashTooMuch()
  {
    CrashGuard localCrashGuard = new CrashGuard(CrashGuard.Key.PULL_DOWN_WEBVIEW, 3);
    QMLog.log(4, "AdvertiseManager", "if hasCrashTooMuch times = " + localCrashGuard.getCrashTimes());
    boolean bool = localCrashGuard.isDuringCloseDelayPeriod();
    return (localCrashGuard.getCrashTimes() >= 3) && (!bool);
  }
  
  public boolean isSameImage(Popularize paramPopularize, String paramString)
  {
    if ((paramPopularize == null) || (paramPopularize.getImageMd5() == null)) {}
    while (!paramPopularize.getImageMd5().equals(paramString)) {
      return false;
    }
    return true;
  }
  
  public boolean isShowPullDownIcon()
  {
    return this.showPullDownIcon;
  }
  
  public void logDetailAboutAds()
  {
    QMLog.log(4, "AdvertiseManager", "logDetailAboutAds");
    if (ensureAdvertiseConfigAndTime())
    {
      QMLog.log(4, "AdvertiseManager", "logDetailAboutAds。 There is a popularize, Now log detail about it");
      DataCollector.logEvent("Event_Pulldown_Webview_Config");
      if (ensureAdvertiseAvailable()) {
        DataCollector.logEvent("Event_Pulldown_Webview_Config_ready");
      }
    }
    int i = SharedPreferenceUtil.getPullAdvertiseCrashGuardLastValue();
    int j = new CrashGuard(CrashGuard.Key.PULL_DOWN_WEBVIEW, 3).getCrashTimes();
    QMLog.log(4, "AdvertiseManager", "crashGuardLastValue = " + i + " crashGuardCurrValue = " + j);
    if (i != j)
    {
      if (j != 3) {
        break label129;
      }
      Log.i("AdvertiseManager", "logDetailAboutAds has crash too much");
      DataCollector.logEvent("Event_Pulldown_Webview_Crashguard");
    }
    for (;;)
    {
      SharedPreferenceUtil.setPullAdvertiseCrashGuardLastValue(j);
      return;
      label129:
      if (j == 1)
      {
        Log.i("AdvertiseManager", "logDetailAboutAds has crash for first time");
        DataCollector.logEvent("Event_Pulldown_Webview_Crashguard_One_Time");
      }
      else if (j == 2)
      {
        Log.i("AdvertiseManager", "logDetailAboutAds has crash for second times");
        DataCollector.logEvent("Event_Pulldown_Webview_Crashguard_Two_Times");
      }
    }
  }
  
  public void setShowPullDownIcon(boolean paramBoolean)
  {
    this.showPullDownIcon = paramBoolean;
  }
  
  public void updatePullDownHtml()
  {
    QMLog.log(4, "AdvertiseManager", "updatePullDownHtml");
    Object localObject1 = getPullDownPopularize();
    if ((localObject1 == null) || (((Popularize)localObject1).getOpenUrl() == null)) {}
    do
    {
      return;
      localObject2 = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
      QMLog.log(4, "AdvertiseManager", "updatePullDownHtml defaultAccount = " + localObject2);
    } while (localObject2 == null);
    String str1 = QMSharedPreferenceManager.getInstance().getPullDownADHtml();
    if ((str1 != null) && (str1.length() != 0) && (!needToUpdate()))
    {
      QMLog.log(4, "AdvertiseManager", "loadContent: length = " + str1.length() + " cache-available");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(((Popularize)localObject1).getOpenUrl());
    HashMap localHashMap;
    if (!localStringBuilder.toString().contains("resp_charset=UTF8"))
    {
      if (localStringBuilder.toString().contains("?")) {
        localStringBuilder.append("&resp_charset=UTF8");
      }
    }
    else
    {
      localHashMap = new HashMap();
      if (!localStringBuilder.toString().contains("?")) {
        break label504;
      }
    }
    label504:
    for (str1 = "&email=";; str1 = "?email=")
    {
      localStringBuilder.append(str1).append(((Account)localObject2).getEmail());
      localHashMap.put("email", Uri.encode(((Account)localObject2).getEmail()));
      localHashMap.put("nick", Uri.encode(AccountManager.shareInstance().getAccountList().getDefaultNickName()));
      if (((localObject2 instanceof QQMailAccount)) && (((Popularize)localObject1).getSessionType() == 1))
      {
        str1 = ((QQMailAccount)localObject2).getSid();
        String str2 = str1 + " " + new Random().nextInt();
        str2 = QMUmaManager.sharedInstance().encodeStringWithPublickKey(str2);
        localStringBuilder.append("&uin=").append(((Account)localObject2).getUin()).append("&token=").append(Uri.encode(str2));
        localHashMap.put("sid", Uri.encode(str1));
      }
      if (((Popularize)localObject1).getSessionType() == 2)
      {
        localStringBuilder.append("&vid=").append(QMApplicationContext.sharedInstance().getVid()).append("&session=").append(Uri.encode(QMUmaManager.sharedInstance().getEncodeUmaSession()));
        localHashMap.put("session", Uri.encode(QMUmaManager.sharedInstance().getUmaLoginSessionKey()));
      }
      QMSharedPreferenceManager.getInstance().setPopularizeUpdateFactor(localHashMap.toString());
      str1 = localStringBuilder.toString().replaceAll("\\s+", "");
      if (URLUtil.isValidUrl(str1)) {
        break label511;
      }
      QMLog.log(5, "AdvertiseManager", "updatePullDownHtml modifyUrl is invalid!!!" + localStringBuilder.toString());
      return;
      localStringBuilder.append("?resp_charset=UTF8");
      break;
    }
    label511:
    QMLog.log(4, "AdvertiseManager", "loadContent: " + str1 + ", cache-not-available");
    localObject1 = new QMNetworkRequest(str1, QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    Object localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnSuccess(new AdvertiseManager.1(this, str1));
    ((QMCallback)localObject2).setOnError(new AdvertiseManager.2(this, str1));
    ((QMNetworkRequest)localObject1).setRequestCallback((QMCallback)localObject2);
    QMHttpUtil.asyncSend((QMNetworkRequest)localObject1);
  }
  
  public void updatePullDownResource()
  {
    QMLog.log(4, "AdvertiseManager", "Method updatePullDownResource called");
    if (ensureAdvertiseConfigAndTime())
    {
      updatePullDownImage();
      updatePullDownHtml();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseManager
 * JD-Core Version:    0.7.0.1
 */