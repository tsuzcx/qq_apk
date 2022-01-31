package common.config.service;

import android.text.TextUtils;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneConfig
{
  public static final String A = "QZONE_FLASH_ENDTIME";
  public static final String B = "BeginTime";
  public static final String C = "EndTime";
  public static final String D = "ShowSigninBanner";
  public static final String E = "ExtraConfig";
  public static final String F = "WifiCarrierType";
  public static final String G = "MinBytes";
  public static final String H = "MaxNum";
  public static final String I = "LowSpeed";
  public static final String J = "HighSpeed";
  public static final String K = "KeepAlive";
  public static final String L = "KeepAliveProxy";
  public static final String M = "AutoWiFi";
  public static final String N = "Auto3G";
  public static final String O = "Auto2G";
  public static final String P = "QualityLow";
  public static final String Q = "QualityMid";
  public static final String R = "QualityHigh";
  public static final String S = "ResolutionLow";
  public static final String T = "ResolutionHigh";
  public static final String U = "WebPQualityLow";
  public static final String V = "WebPQualityHigh";
  public static final String W = "Description";
  public static final String X = "UploadQuality";
  public static final String Y = "UseLocalQuality";
  public static final String Z = "RemindUploadSizeIsLargeThreshold";
  public static final int a = 0;
  private static QzoneConfig jdField_a_of_type_CommonConfigServiceQzoneConfig = new QzoneConfig();
  public static final String a = "LoadingPhoto";
  public static final String aA = "PhotoURL3";
  public static final String aB = "BackupIP1";
  public static final String aC = "BackupIP2";
  public static final String aD = "AllowVoiceMood";
  public static final String aE = "AllowVoiceOP";
  public static final String aF = "AllowVoiceForward";
  public static final String aG = "MaxReceiverCount";
  public static final String aH = "ShowOPDelay";
  public static final String aI = "RestrictBeginTime";
  public static final String aJ = "RestrictEndTime";
  public static final String aK = "RestrictFlag";
  public static final String aL = "PreloadQuanCount";
  public static final String aM = "LevelFlag";
  public static final String aN = "FeedsLevelFlag";
  public static final String aO = "DetailLevelFlag";
  public static final String aP = "RestrictFlag";
  public static final String aQ = "MergeMessage";
  public static final String aR = "BlackListVersion";
  public static final String aS = "TraceReportURL";
  public static final String aT = "TraceReportInterval";
  public static final String aU = "TraceReportCount";
  public static final String aV = "TraceReportSamples";
  public static final String aW = "VisitorReportStopSeconds";
  public static final String aX = "VisitorReportCount";
  public static final String aY = "VisitorReportInteval";
  public static final String aZ = "DisableVipInfoOnFriendFeed";
  public static final String aa = "MaxNum";
  public static final String ab = "3GQuality";
  public static final String ac = "WIFIQuality";
  public static final String ad = "UploadPort";
  public static final String ae = "ConnectTimeout";
  public static final String af = "DataTimeout";
  public static final String ag = "TimeoutRetryCount";
  public static final String ah = "MaxConcurrentNum";
  public static final String ai = "VideoPartRetryCount";
  public static final String aj = "VideoFileRetryCount";
  public static final String ak = "VideoPartSize";
  public static final String al = "VideoPartSizeFor2G";
  public static final String am = "VideoPartSizeFor3G";
  public static final String an = "VideoPartConcurrentCount";
  public static final String ao = "AlbumMaxPhotoCount";
  public static final String ap = "EnableWatermarkCamera";
  public static final String aq = "ReportLogSample";
  public static final String ar = "MoodPreloadNetConfig";
  public static final String as = "PreloadCountWifi";
  public static final String at = "PreloadCount3G";
  public static final String au = "PreloadCount2G";
  public static final String av = "IPList";
  public static final String aw = "OptimumIP1";
  public static final String ax = "OptimumIP2";
  public static final String ay = "PhotoURL1";
  public static final String az = "PhotoURL2";
  public static final int b = 1;
  public static final String b = "PhotoDownload";
  public static final String bA = "DownloadDirectIP";
  public static final String bB = "SwitchTimes";
  public static final String bC = "RetryTimes";
  public static final String bD = "photo_masterIplist";
  public static final String bE = "photo_backupIplist";
  public static final String bF = "DownloadAccessPortList";
  public static final String bG = "DownloadIPValidTime";
  public static final String bH = "DownloadCustomDnsEnable";
  public static final String bI = "DownloadDirectIP_a";
  public static final String bJ = "DownloadDirectIP_b";
  public static final String bK = "DownloadBackupIP_a";
  public static final String bL = "DownloadBackupIP_b";
  public static final String bM = "photo_masterIplist_a";
  public static final String bN = "photo_backupIplist_a";
  public static final String bO = "photo_masterIplist_b";
  public static final String bP = "photo_backupIplist_b";
  public static final String bQ = "KpDomainList";
  public static final String bR = "DownloadDirectIPVideo";
  public static final String bS = "DownloadBackupIPVideo";
  public static final String bT = "video_masterIplist";
  public static final String bU = "video_backupIplist";
  public static final String bV = "quoteMaxNum";
  public static final String bW = "CoverBannerSwitch";
  public static final String bX = "FeedTextMaxLine";
  public static final String bY = "UploadQuality";
  public static final String bZ = "UploadResolution";
  public static final String ba = "TouchQzoneBlog";
  public static final String bb = "TouchQzoneMsgb";
  public static final String bc = "TouchQzoneMood";
  public static final String bd = "TouchQzoneGift";
  public static final String be = "TouchQzonePhoto";
  public static final String bf = "TouchQzoneShare";
  public static final String bg = "TouchQzoneOther";
  public static final String bh = "TouchQzoneProfile";
  public static final String bi = "ReConnCount";
  public static final String bj = "RetryTime";
  public static final String bk = "RetryInterval";
  public static final String bl = "AccReportCount";
  public static final String bm = "AccReportSamples";
  public static final String bn = "AccReportInterval";
  public static final String bo = "CoordinateCacheTime";
  public static final String bp = "POICacheDistance";
  public static final String bq = "POICacheTime";
  public static final String br = "WeatherCacheTime";
  public static final String bs = "LBSPreload";
  public static final String bt = "GPSPrelocateMaxTimeout";
  public static final String bu = "GPSLocateMaxTimeout";
  public static final String bv = "AvatarURL";
  public static final String bw = "EmotionURL";
  public static final String bx = "FlowerVineURL";
  public static final String by = "PhotoABSvrList";
  public static final String bz = "DownloadBackupIP";
  public static final int c = 2;
  public static final String c = "PhotoUpload";
  public static final String cA = "DbOptiSync";
  public static final String cB = "EnableFeedPreload";
  public static final String cC = "MusicPlayDetailUrl";
  public static final String cD = "BgMusicManagerUrl";
  public static final String cE = "JsBridgeAllowHostsList";
  public static final String cF = "QunAioRememberUpload";
  public static final String cG = "TimeZone";
  public static final String cH = "MaxDays";
  public static final String cI = "StatTimeRegion";
  public static final String cJ = "ShowNavigatorGameTab";
  public static final String cK = "ItemCount";
  public static final String cL = "ItemAttribute";
  public static final String cM = "ItemDownURLPrefix";
  private static final String cN = "QzoneConfig";
  public static final String ca = "ip_no_pmtu_disc";
  public static final String cb = "CompressToWebp";
  public static final String cc = "TextToBitmap";
  public static final String cd = "BitmapMemoryThreshold";
  public static final String ce = "MoodRecentPhotoTime";
  public static final String cf = "MoodRecentPhotoCount";
  public static final String cg = "StartDuration";
  public static final String ch = "CrashMax";
  public static final String ci = "CrashClearItems";
  public static final String cj = "FriendMaxSelectCount";
  public static final String ck = "FriendMaxSelectCountComment";
  public static final String cl = "GroupTimeMin";
  public static final String cm = "GroupTimeMax";
  public static final String cn = "GroupDistanceMax";
  public static final String co = "GroupMergeCount";
  public static final String cp = "RecentPhotoTipsCount";
  public static final String cq = "GroupOldDate";
  public static final String cr = "FeedBannerDuration";
  public static final String cs = "FeedBannerActiveMaxCount";
  public static final String ct = "PluginErrorHandleCount";
  public static final String cu = "PluginPermissionErrorHandle";
  public static final String cv = "PreLoadActiveFeeds";
  public static final String cw = "PreLoadGroupFeeds";
  public static final String cx = "ExifEnable";
  public static final String cy = "BlobCacheEnable";
  public static final String cz = "ShowFeedOpLayer";
  public static final String d = "PhotoDomainIP";
  public static final String e = "VoiceMood";
  public static final String f = "PhotoSvrList";
  public static final String g = "VideoSvrList";
  public static final String h = "Gift";
  public static final String i = "PhotoView";
  public static final String j = "FeedsPre";
  public static final String k = "Push";
  public static final String l = "ReportSetting";
  public static final String m = "JumpQzone";
  public static final String n = "OutBox";
  public static final String o = "WNSSettting";
  public static final String p = "QZoneSetting";
  public static final String q = "TraceLog";
  public static final String r = "QunAlbumSetting";
  public static final String s = "QzoneCover";
  public static final String t = "SafeModeSetting";
  public static final String u = "NavigationBar";
  public static final String v = "ADFeedExposeTime";
  public static final String w = "UpdateCountIntervalWhenClickFeedTab";
  public static final String x = "URL";
  public static final String y = "QZONE_FLASH_URL";
  public static final String z = "QZONE_FLASH_BEGINTIME";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static QzoneConfig a()
  {
    return jdField_a_of_type_CommonConfigServiceQzoneConfig;
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      int i1 = Integer.valueOf(paramString1).intValue();
      return i1;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public String a(String paramString1, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap;
    if ((paramString1 != null) && (paramString2 != null))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (localConcurrentHashMap != null) {
        break label93;
      }
      localConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localConcurrentHashMap);
    }
    label93:
    for (;;)
    {
      if (localConcurrentHashMap != null)
      {
        String str2 = (String)localConcurrentHashMap.get(paramString2);
        String str1 = str2;
        if (str2 == null)
        {
          paramString1 = QZConfigProviderUtil.a(paramString1, paramString2);
          str1 = paramString1;
          if (paramString1 != null)
          {
            localConcurrentHashMap.put(paramString2, paramString1);
            str1 = paramString1;
          }
        }
        return str1;
      }
      return null;
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public void a()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QzoneConfig.QzoneConfigChangeListener localQzoneConfigChangeListener = (QzoneConfig.QzoneConfigChangeListener)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localQzoneConfigChangeListener != null) {
        localQzoneConfigChangeListener.a();
      }
      i1 += 1;
    }
  }
  
  public void a(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if ((paramQzoneConfigChangeListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramQzoneConfigChangeListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQzoneConfigChangeListener);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    ConcurrentHashMap localConcurrentHashMap1;
    do
    {
      return;
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localConcurrentHashMap1);
      }
    } while (localConcurrentHashMap1 == null);
    localConcurrentHashMap1.put(paramString2, paramString3);
  }
  
  public void b(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if (paramQzoneConfigChangeListener != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramQzoneConfigChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.config.service.QzoneConfig
 * JD-Core Version:    0.7.0.1
 */