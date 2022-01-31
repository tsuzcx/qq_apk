package common.config.service;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneConfig
{
  public static final String A = "ShowSigninBanner";
  public static final String B = "ExtraConfig";
  public static final String C = "WifiCarrierType";
  public static final String D = "MinBytes";
  public static final String E = "MaxNum";
  public static final String F = "LowSpeed";
  public static final String G = "HighSpeed";
  public static final String H = "KeepAlive";
  public static final String I = "KeepAliveProxy";
  public static final String J = "AutoWiFi";
  public static final String K = "Auto3G";
  public static final String L = "Auto2G";
  public static final String M = "QualityLow";
  public static final String N = "QualityMid";
  public static final String O = "QualityHigh";
  public static final String P = "ResolutionLow";
  public static final String Q = "ResolutionHigh";
  public static final String R = "WebPQualityLow";
  public static final String S = "WebPQualityHigh";
  public static final String T = "Description";
  public static final String U = "UploadQuality";
  public static final String V = "UseLocalQuality";
  public static final String W = "RemindUploadSizeIsLargeThreshold";
  public static final String X = "MaxNum";
  public static final String Y = "3GQuality";
  public static final String Z = "WIFIQuality";
  public static final int a = 0;
  private static QzoneConfig jdField_a_of_type_CommonConfigServiceQzoneConfig = new QzoneConfig();
  public static final String a = "LoadingPhoto";
  public static final String aA = "AllowVoiceMood";
  public static final String aB = "AllowVoiceOP";
  public static final String aC = "AllowVoiceForward";
  public static final String aD = "MaxReceiverCount";
  public static final String aE = "ShowOPDelay";
  public static final String aF = "RestrictBeginTime";
  public static final String aG = "RestrictEndTime";
  public static final String aH = "RestrictFlag";
  public static final String aI = "PreloadQuanCount";
  public static final String aJ = "LevelFlag";
  public static final String aK = "FeedsLevelFlag";
  public static final String aL = "DetailLevelFlag";
  public static final String aM = "RestrictFlag";
  public static final String aN = "MergeMessage";
  public static final String aO = "BlackListVersion";
  public static final String aP = "TraceReportURL";
  public static final String aQ = "TraceReportInterval";
  public static final String aR = "TraceReportCount";
  public static final String aS = "TraceReportSamples";
  public static final String aT = "VisitorReportStopSeconds";
  public static final String aU = "VisitorReportCount";
  public static final String aV = "VisitorReportInteval";
  public static final String aW = "DisableVipInfoOnFriendFeed";
  public static final String aX = "TouchQzoneBlog";
  public static final String aY = "TouchQzoneMsgb";
  public static final String aZ = "TouchQzoneMood";
  public static final String aa = "UploadPort";
  public static final String ab = "ConnectTimeout";
  public static final String ac = "DataTimeout";
  public static final String ad = "TimeoutRetryCount";
  public static final String ae = "MaxConcurrentNum";
  public static final String af = "VideoPartRetryCount";
  public static final String ag = "VideoFileRetryCount";
  public static final String ah = "VideoPartSize";
  public static final String ai = "VideoPartSizeFor2G";
  public static final String aj = "VideoPartSizeFor3G";
  public static final String ak = "VideoPartConcurrentCount";
  public static final String al = "AlbumMaxPhotoCount";
  public static final String am = "EnableWatermarkCamera";
  public static final String an = "ReportLogSample";
  public static final String ao = "MoodPreloadNetConfig";
  public static final String ap = "PreloadCountWifi";
  public static final String aq = "PreloadCount3G";
  public static final String ar = "PreloadCount2G";
  public static final String as = "IPList";
  public static final String at = "OptimumIP1";
  public static final String au = "OptimumIP2";
  public static final String av = "PhotoURL1";
  public static final String aw = "PhotoURL2";
  public static final String ax = "PhotoURL3";
  public static final String ay = "BackupIP1";
  public static final String az = "BackupIP2";
  public static final int b = 1;
  public static final String b = "PhotoDownload";
  public static final String bA = "photo_masterIplist";
  public static final String bB = "photo_backupIplist";
  public static final String bC = "DownloadAccessPortList";
  public static final String bD = "DownloadIPValidTime";
  public static final String bE = "DownloadCustomDnsEnable";
  public static final String bF = "DownloadDirectIP_a";
  public static final String bG = "DownloadDirectIP_b";
  public static final String bH = "DownloadBackupIP_a";
  public static final String bI = "DownloadBackupIP_b";
  public static final String bJ = "photo_masterIplist_a";
  public static final String bK = "photo_backupIplist_a";
  public static final String bL = "photo_masterIplist_b";
  public static final String bM = "photo_backupIplist_b";
  public static final String bN = "KpDomainList";
  public static final String bO = "quoteMaxNum";
  public static final String bP = "CoverBannerSwitch";
  public static final String bQ = "FeedTextMaxLine";
  public static final String bR = "UploadQuality";
  public static final String bS = "UploadResolution";
  public static final String bT = "ip_no_pmtu_disc";
  public static final String bU = "CompressToWebp";
  public static final String bV = "TextToBitmap";
  public static final String bW = "BitmapMemoryThreshold";
  public static final String bX = "MoodRecentPhotoTime";
  public static final String bY = "MoodRecentPhotoCount";
  public static final String bZ = "StartDuration";
  public static final String ba = "TouchQzoneGift";
  public static final String bb = "TouchQzonePhoto";
  public static final String bc = "TouchQzoneShare";
  public static final String bd = "TouchQzoneOther";
  public static final String be = "TouchQzoneProfile";
  public static final String bf = "ReConnCount";
  public static final String bg = "RetryTime";
  public static final String bh = "RetryInterval";
  public static final String bi = "AccReportCount";
  public static final String bj = "AccReportSamples";
  public static final String bk = "AccReportInterval";
  public static final String bl = "CoordinateCacheTime";
  public static final String bm = "POICacheDistance";
  public static final String bn = "POICacheTime";
  public static final String bo = "WeatherCacheTime";
  public static final String bp = "LBSPreload";
  public static final String bq = "GPSPrelocateMaxTimeout";
  public static final String br = "GPSLocateMaxTimeout";
  public static final String bs = "AvatarURL";
  public static final String bt = "EmotionURL";
  public static final String bu = "FlowerVineURL";
  public static final String bv = "PhotoABSvrList";
  public static final String bw = "DownloadBackupIP";
  public static final String bx = "DownloadDirectIP";
  public static final String by = "SwitchTimes";
  public static final String bz = "RetryTimes";
  public static final int c = 2;
  public static final String c = "PhotoUpload";
  public static final String ca = "CrashMax";
  public static final String cb = "CrashClearItems";
  public static final String cc = "FriendMaxSelectCount";
  public static final String cd = "FriendMaxSelectCountComment";
  public static final String ce = "GroupTimeMin";
  public static final String cf = "GroupTimeMax";
  public static final String cg = "GroupDistanceMax";
  public static final String ch = "GroupMergeCount";
  public static final String ci = "RecentPhotoTipsCount";
  public static final String cj = "GroupOldDate";
  public static final String ck = "FeedBannerDuration";
  public static final String cl = "FeedBannerActiveMaxCount";
  public static final String cm = "PluginErrorHandleCount";
  public static final String cn = "PluginPermissionErrorHandle";
  public static final String co = "PreLoadActiveFeeds";
  public static final String cp = "PreLoadGroupFeeds";
  public static final String cq = "ExifEnable";
  public static final String cr = "BlobCacheEnable";
  public static final String cs = "DbOptiSync";
  public static final String ct = "MusicPlayDetailUrl";
  public static final String cu = "BgMusicManagerUrl";
  public static final String cv = "JsBridgeAllowHostsList";
  public static final String d = "PhotoDomainIP";
  public static final String e = "VoiceMood";
  public static final String f = "PhotoSvrList";
  public static final String g = "Gift";
  public static final String h = "PhotoView";
  public static final String i = "FeedsPre";
  public static final String j = "Push";
  public static final String k = "ReportSetting";
  public static final String l = "JumpQzone";
  public static final String m = "OutBox";
  public static final String n = "WNSSettting";
  public static final String o = "QZoneSetting";
  public static final String p = "TraceLog";
  public static final String q = "QunAlbumSetting";
  public static final String r = "QzoneCover";
  public static final String s = "SafeModeSetting";
  public static final String t = "ADFeedExposeTime";
  public static final String u = "URL";
  public static final String v = "QZONE_FLASH_URL";
  public static final String w = "QZONE_FLASH_BEGINTIME";
  public static final String x = "QZONE_FLASH_ENDTIME";
  public static final String y = "BeginTime";
  public static final String z = "EndTime";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  public static QzoneConfig a()
  {
    return jdField_a_of_type_CommonConfigServiceQzoneConfig;
  }
  
  private void a()
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
    if ((paramString1 != null) && (paramString2 != null))
    {
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null) {
        localConcurrentHashMap1 = a(paramString1);
      }
      if (localConcurrentHashMap1 != null) {
        return (String)localConcurrentHashMap1.get(paramString2);
      }
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public ConcurrentHashMap a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {}
    do
    {
      return null;
      localObject = a(paramString);
    } while ((localObject == null) || (localObject.length <= 0));
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.decode((byte[])localObject);
    Object localObject = new ConcurrentHashMap();
    Iterator localIterator = localUniAttribute.getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((ConcurrentHashMap)localObject).put(str, (String)localUniAttribute.get(str));
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    return localObject;
  }
  
  public void a(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if ((paramQzoneConfigChangeListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramQzoneConfigChangeListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQzoneConfigChangeListener);
    }
  }
  
  public void a(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneConfig", 2, "configDatas invalid");
      }
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((localEntry.getValue() != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())))
      {
        this.b.remove(localEntry.getKey());
        this.b.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a();
  }
  
  public byte[] a(String paramString)
  {
    if ((this.b != null) && (this.b.containsKey(paramString))) {
      return (byte[])this.b.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.config.service.QzoneConfig
 * JD-Core Version:    0.7.0.1
 */