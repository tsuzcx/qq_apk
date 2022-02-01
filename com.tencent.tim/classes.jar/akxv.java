import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class akxv
  implements Manager
{
  private static final List<String> EA;
  private static final List<String> EB;
  private static final List<String> EC;
  private static final List<String> ED;
  private static final List<String> EE;
  private static final List<String> EF;
  private static final List<String> EG;
  private static final List<String> EH;
  private static final List<String> Ew = new ArrayList();
  private static final List<String> Ex;
  private static final List<String> Ey;
  private static final List<String> Ez;
  private static final int dpH;
  private static final String[][] h;
  private static final String[][] i;
  private static final String[][] j;
  private static final String[][] k;
  private Set<String> cJ;
  private Set<String> cK;
  private QQAppInterface mApp;
  private SharedPreferences.Editor mEditor;
  private SharedPreferences mSharedPreferences;
  
  static
  {
    Ew.add("PicStatisticsManagerSendPicTotalSize");
    Ew.add("PicStatisticsManagerForwardPicTotalSize");
    Ew.add("PicStatisticsManagerSendPicCount");
    Ew.add("PicStatisticsManagerForwardPicCount");
    Ex = new ArrayList();
    Ex.add("PicStatisticsManagerThumbPicTotalSize");
    Ex.add("PicStatisticsManagerBigPicTotalSize");
    Ex.add("PicStatisticsManagerDownloadThumbPicCount");
    Ex.add("PicStatisticsManagerDownloadBigPicCount");
    Ey = new ArrayList();
    Ey.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    Ey.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    Ey.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    Ey.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    Ey.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    Ey.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    Ey.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    Ey.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    Ey.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    Ey.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    Ez = new ArrayList();
    Ez.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    Ez.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    Ez.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    Ez.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    Ez.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    Ez.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    Ez.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    Ez.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    Ez.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    Ez.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    EA = new ArrayList();
    EA.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
    EA.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
    EA.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
    EA.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
    EA.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
    EA.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
    EA.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
    EA.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
    EA.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
    EA.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
    EB = new ArrayList();
    EB.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
    EB.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
    EB.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
    EB.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
    EB.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
    EB.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
    EB.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
    EB.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
    EB.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
    EB.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
    EC = new ArrayList();
    EC.add("PicStatisticsManagerMissPriorityHandlingWifi");
    EC.add("PicStatisticsManagerMissPriorityAIOWifi");
    EC.add("PicStatisticsManagerMissPriorityC2CWifi");
    EC.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    EC.add("PicStatisticsManagerMissPriorityGroupWifi");
    EC.add("PicStatisticsManagerMissPriorityWaitingWifi");
    EC.add("PicStatisticsManagerMissPriorityUnknownWifi");
    ED = new ArrayList();
    ED.add("PicStatisticsManagerMissPriorityHandlingXG");
    ED.add("PicStatisticsManagerMissPriorityAIOXG");
    ED.add("PicStatisticsManagerMissPriorityC2CXG");
    ED.add("PicStatisticsManagerMissPriorityDiscussionXG");
    ED.add("PicStatisticsManagerMissPriorityGroupXG");
    ED.add("PicStatisticsManagerMissPriorityWaitingXG");
    ED.add("PicStatisticsManagerMissPriorityUnknownXG");
    h = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, { "4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount" }, { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" } };
    String[] arrayOfString = { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" };
    i = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, { "4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount" }, arrayOfString };
    j = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, { "4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount" }, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    k = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    dpH = h[0].length;
    EE = new ArrayList();
    EF = new ArrayList();
    EG = new ArrayList();
    int m = 0;
    while (m < dpH)
    {
      EE.add(h[0][m]);
      EE.add(i[0][m]);
      EE.add(j[0][m]);
      EE.add(k[0][m]);
      EF.add(h[1][m]);
      EF.add(i[1][m]);
      EF.add(j[1][m]);
      EF.add(k[1][m]);
      EG.add(h[2][m]);
      EG.add(i[2][m]);
      EG.add(j[2][m]);
      EG.add(k[2][m]);
      m += 1;
    }
    EF.add("4G_C2C_FLOAT_HIT_COUNT");
    EG.add("XG_C2C_FLOAT_HIT_COUNT");
    EH = new ArrayList();
    EH.add("PicStatisticsManagerPreDownloadThumbPicCount");
    EH.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    EH.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  @TargetApi(9)
  public akxv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.cJ = new HashSet();
    this.cK = new HashSet();
    this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.mEditor = this.mSharedPreferences.edit();
  }
  
  @TargetApi(9)
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString, boolean paramBoolean)
  {
    long l;
    String str1;
    String str2;
    if (paramInt1 == 0) {
      if (paramBoolean)
      {
        l = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.mEditor.putLong("PicStatisticsManagerPredownloadCountWifi", l + 1L);
        str1 = "WIFI";
        paramInt1 = 0;
        if (paramInt2 != 3) {
          break label376;
        }
        paramInt2 = 0;
        str2 = "C2C";
        label60:
        if (QLog.isColorLevel()) {
          QLog.d("PicStatisticsManager", 2, "addCount(): networkType=" + str1 + " uin=" + str2);
        }
        paramArrayOfString = paramArrayOfString[paramInt1][paramInt2];
        l = this.mSharedPreferences.getLong(paramArrayOfString, 0L) + 1L;
        if (Build.VERSION.SDK_INT < 9) {
          break label437;
        }
        this.mEditor.putLong(paramArrayOfString, l).apply();
      }
    }
    label376:
    do
    {
      return;
      l = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      this.mEditor.putLong("PicStatisticsManagerPreviewCountWifi", l + 1L);
      str1 = "WIFI";
      paramInt1 = 0;
      break;
      if (paramInt1 == 0)
      {
        if (paramBoolean)
        {
          l = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
          this.mEditor.putLong("PicStatisticsManagerPredownloadCount4G", l + 1L);
          str1 = "4G";
          paramInt1 = 1;
          break;
        }
        l = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.mEditor.putLong("PicStatisticsManagerPreviewCount4G", l + 1L);
        str1 = "4G";
        paramInt1 = 1;
        break;
      }
      if (paramBoolean)
      {
        l = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.mEditor.putLong("PicStatisticsManagerPredownloadCountXG", l + 1L);
        str1 = "XG";
        paramInt1 = 2;
        break;
      }
      l = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      this.mEditor.putLong("PicStatisticsManagerPreviewCountXG", l + 1L);
      str1 = "XG";
      paramInt1 = 2;
      break;
      if (paramInt2 == 2)
      {
        paramInt2 = 1;
        str2 = "Discussion";
        break label60;
      }
      if (paramInt2 == 0)
      {
        paramInt2 = 2;
        str2 = "Group";
        break label60;
      }
      if (paramInt2 == 1)
      {
        paramInt2 = 3;
        str2 = "Digital Group";
        break label60;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PicStatisticsManager", 2, "addCount(): Error! Unknown uin type");
    return;
    label437:
    this.mEditor.putLong(paramArrayOfString, l).commit();
  }
  
  private HashMap<String, String> c(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      long l2 = this.mSharedPreferences.getLong(str, 0L);
      long l1;
      if (l2 >= 0L)
      {
        l1 = l2;
        if (l2 <= 10000L) {}
      }
      else
      {
        l1 = 0L;
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  private String eG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownWifi";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingWifi";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOWifi";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CWifi";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionWifi";
    }
    return "PicStatisticsManagerMissPriorityGroupWifi";
  }
  
  private String eH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownXG";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingXG";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOXG";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CXG";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionXG";
    }
    return "PicStatisticsManagerMissPriorityGroupXG";
  }
  
  @TargetApi(9)
  private void resetData()
  {
    Iterator localIterator = Ew.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = Ex.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = EC.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = ED.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = EE.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = EG.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    localIterator = EH.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.mEditor.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.mEditor.apply();
      return;
    }
    this.mEditor.commit();
  }
  
  @TargetApi(9)
  public void aV(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): networkType=" + paramInt1 + " uin=" + paramInt2 + " preDownloadState=" + paramInt3);
    }
    if (paramInt3 == 1)
    {
      long l1;
      long l2;
      if (paramInt1 == 2)
      {
        l1 = this.mSharedPreferences.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.mEditor.putLong("PicStatisticsManagerPreviewCountXG", l2 + 1L);
        this.mEditor.putLong("XG_C2C_FLOAT_HIT_COUNT", l1 + 1L);
        if (Build.VERSION.SDK_INT >= 9) {
          this.mEditor.apply();
        }
      }
      else
      {
        do
        {
          return;
          if (paramInt1 == 1)
          {
            l1 = this.mSharedPreferences.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L);
            l2 = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
            this.mEditor.putLong("PicStatisticsManagerPreviewCount4G", l2 + 1L);
            this.mEditor.putLong("4G_C2C_FLOAT_HIT_COUNT", l1 + 1L);
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
        return;
      }
      this.mEditor.commit();
      return;
    }
    a(paramInt1, paramInt2, i, false);
  }
  
  @TargetApi(9)
  public void al(int paramInt, long paramLong)
  {
    String str2;
    String str1;
    String str3;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addPicData(): Unknown picture type!");
      }
      return;
    case 13057: 
      str2 = "SendPic";
      str1 = "PicStatisticsManagerSendPicTotalSize";
      str3 = "PicStatisticsManagerSendPicCount";
    }
    long l1;
    long l2;
    for (;;)
    {
      l1 = this.mSharedPreferences.getLong(str1, 0L) + paramLong;
      l2 = this.mSharedPreferences.getLong(str3, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.i("PicStatisticsManager", 2, "addPictureData(): type=" + str2 + " Adding Size=" + paramLong + " Total Size=" + l1 + " Count=" + l2);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.mEditor.putLong(str1, l1).putLong(str3, l2).apply();
      return;
      str2 = "ForwardPic";
      str1 = "PicStatisticsManagerForwardPicTotalSize";
      str3 = "PicStatisticsManagerForwardPicCount";
      continue;
      str2 = "DownloadThumbPic";
      str1 = "PicStatisticsManagerThumbPicTotalSize";
      str3 = "PicStatisticsManagerDownloadThumbPicCount";
      continue;
      str2 = "DownloadBigPic";
      str1 = "PicStatisticsManagerBigPicTotalSize";
      str3 = "PicStatisticsManagerDownloadBigPicCount";
    }
    this.mEditor.putLong(str1, l1).putLong(str3, l2).commit();
  }
  
  @TargetApi(9)
  public void cRT()
  {
    if (!this.mSharedPreferences.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.mEditor.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicStatisticsManager", 2, "dataReport(): Not need to data report!");
        }
        return;
        this.mEditor.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
    }
    String str;
    label115:
    long l1;
    long l2;
    HashMap localHashMap1;
    label170:
    HashMap localHashMap2;
    if (this.mApp != null)
    {
      str = this.mApp.getCurrentAccountUin();
      if (this.mSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L) {
        break label280;
      }
      l1 = this.mSharedPreferences.getLong("PicStatisticsManagerSendPicCount", 0L);
      l2 = this.mSharedPreferences.getLong("PicStatisticsManagerForwardPicCount", 0L);
      localHashMap1 = c(Ew);
      if (l1 + l2 > 0L) {
        break label693;
      }
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
      anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
      l1 = this.mSharedPreferences.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
      l2 = this.mSharedPreferences.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
      localHashMap2 = c(Ex);
      if (l1 + l2 > 0L) {
        break label708;
      }
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "FALSE");
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDownloadPic", false, 0L, 0L, localHashMap2, "");
      resetData();
      return;
      str = null;
      break;
      label280:
      anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, c(EH), "");
      l1 = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.mSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
      long l4 = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l5 = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      long l6 = this.mSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
      if (l1 + l4 > 0L) {
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, c(EE), "");
      }
      if (l3 + l6 > 0L) {
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, c(EF), "");
      }
      if (l2 + l5 > 0L) {
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, c(EG), "");
      }
      if (l4 + l5 > 0L)
      {
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, c(Ey), "");
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, c(Ez), "");
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, c(EA), "");
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, c(EB), "");
      }
      if (l4 > 0L) {
        anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, c(EC), "");
      }
      if (l5 <= 0L) {
        break label115;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, c(ED), "");
      break label115;
      label693:
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
      break label170;
      label708:
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "TRUE");
    }
  }
  
  public void iZ(int paramInt1, int paramInt2)
  {
    if (this.mApp != null) {}
    HashMap localHashMap;
    for (String str = this.mApp.getCurrentAccountUin();; str = null)
    {
      localHashMap = new HashMap();
      localHashMap.put("PredownloadMissReason", String.valueOf(paramInt2));
      if (paramInt1 != 0) {
        break;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, localHashMap, "");
      return;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(str, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, localHashMap, "");
  }
  
  public void ja(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDowonloadBigPicCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, h, true);
  }
  
  public void jb(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicMissCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, j, false);
  }
  
  public void jc(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicStatisticsManager", 2, "addPreDownloadNotSupportCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, k, false);
  }
  
  @TargetApi(9)
  public void jd(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    long l;
    for (String str = eG(paramInt2);; str = eH(paramInt2))
    {
      l = this.mSharedPreferences.getLong(str, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPredownloadMissPriority(): " + str + ", Count=" + l);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.mEditor.putLong(str, l).apply();
      return;
    }
    this.mEditor.putLong(str, l).commit();
  }
  
  public void onDestroy() {}
  
  @TargetApi(9)
  public void r(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d("PicStatisticsManager", 2, "addPreDownloadThumbPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + paramMessageForPic.md5);
        }
        boolean bool = this.cJ.contains(str);
        if (bool) {
          return;
        }
        this.cJ.add(paramMessageForPic.md5);
        long l = this.mSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
        if (Build.VERSION.SDK_INT >= 9)
        {
          this.mEditor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l).apply();
          if (QLog.isColorLevel()) {
            QLog.i("PicStatisticsManager", 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + l);
          }
        }
        else
        {
          this.mEditor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l).commit();
        }
      }
      finally {}
    }
  }
  
  @TargetApi(9)
  public void s(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addDownloadBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int m;
    int n;
    String str1;
    if (akxo.b(this.mApp, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      m = 1;
      n = alyv.g(l1, l2);
      if (n != 0) {
        break label299;
      }
      if (m == 0) {
        break label292;
      }
      str1 = "PicStatisticsManagerPicDownloadSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (avfp.ns(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.mSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addDownloadBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.mEditor.putLong(str2, l3).apply();
      return;
      m = 0;
      break;
      label292:
      str1 = "PicStatisticsManagerPicDownloadSizeLongGroup";
      continue;
      label299:
      if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (m != 0) {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
      }
    }
    label386:
    this.mEditor.putLong(str2, l3).commit();
  }
  
  @TargetApi(9)
  public void t(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addPreviewBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int m;
    int n;
    String str1;
    if (akxo.b(this.mApp, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      m = 1;
      n = alyv.g(l1, l2);
      if (n != 0) {
        break label299;
      }
      if (m == 0) {
        break label292;
      }
      str1 = "PicStatisticsManagerPicPreviewSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (avfp.ns(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.mSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPreviewBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.mEditor.putLong(str2, l3).apply();
      return;
      m = 0;
      break;
      label292:
      str1 = "PicStatisticsManagerPicPreviewSizeLongGroup";
      continue;
      label299:
      if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (m != 0) {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
      }
    }
    label386:
    this.mEditor.putLong(str2, l3).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */