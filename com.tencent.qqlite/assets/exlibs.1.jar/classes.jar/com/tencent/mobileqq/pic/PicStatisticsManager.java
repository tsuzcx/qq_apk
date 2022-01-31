package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class PicStatisticsManager
  implements Manager
{
  public static final String A = "PreviewBigPicMissCount";
  public static final String B = "PreDownloadThumbPicHitCount";
  public static final String C = "PreDownloadThumbPicMissCount";
  public static final String D = "PredownloadUtilization";
  public static final String E = "PredownloadBigPicHitRate";
  public static final String F = "PreDownloadThumbPicHitRate";
  private static final String G = "PicStatistics";
  private static final String H = "PicStatisticsForWhiteList";
  private static final String I = "PicStatisticsForInactiveUser";
  private static final String J = "1";
  private static final String K = "2";
  private static final String L = "3";
  private static final String M = "DiffSizePicPreview";
  public static final int a = 13057;
  public static final long a = 40000L;
  public static final String a = "PicStatisticsFirstUsed";
  private static final List jdField_a_of_type_JavaUtilList;
  public static final String[][] a;
  public static final int b = 13058;
  public static final long b = 250000L;
  public static final String b = "InactiveReason";
  private static final List jdField_b_of_type_JavaUtilList;
  public static final String[][] b;
  public static final int c = 13059;
  public static final long c = 691200L;
  public static final String c;
  public static final String[][] c;
  public static final int d = 13060;
  public static final String d = "ManagerInitTimes";
  public static final String[][] d;
  public static final int e;
  public static final String e = "ManagerDestroyTimes";
  public static final int f;
  public static final String f = "SendPicTotalSize";
  public static final String g = "ForwardPicTotalSize";
  public static final String h = "SendPicCount";
  public static final String i = "ForwardPicCount";
  public static final String j = "ThumbPicTotalSize";
  public static final String k = "BigPicTotalSize";
  public static final String l = "DownloadThumbPicCount";
  public static final String m = "DownloadBigPicCount";
  public static final String n = "PicDownloadSizeSmall";
  public static final String o = "PicDownloadSizeMiddle";
  public static final String p = "PicDownloadSizeLarge";
  public static final String q = "PicDownloadSizeExtraLarge";
  public static final String r = "PicDownloadSizeLong";
  public static final String s = "PicPreviewSizeSmall";
  public static final String t = "PicPreviewSizeMiddle";
  public static final String u = "PicPreviewSizeLarge";
  public static final String v = "PicPreivewSizeExtraLarge";
  public static final String w = "PicPreviewSizeLong";
  public static final String x = "PreDownloadThumbPicCount";
  public static final String y = "PreDownloadBigPicCount";
  public static final String z = "PreviewBigPicHitCount";
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map jdField_a_of_type_JavaUtilMap;
  private Set jdField_a_of_type_JavaUtilSet;
  private Set jdField_b_of_type_JavaUtilSet;
  private Set c;
  
  static
  {
    jdField_c_of_type_JavaLangString = PicStatisticsManager.class.getSimpleName();
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" } };
    String[] arrayOfString = { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" };
    jdField_b_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, arrayOfString };
    jdField_c_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    d = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    e = jdField_a_of_type_Array2dOfJavaLangString.length;
    f = jdField_a_of_type_Array2dOfJavaLangString[0].length;
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("ManagerInitTimes");
    jdField_b_of_type_JavaUtilList.add("ManagerDestroyTimes");
    jdField_b_of_type_JavaUtilList.add("SendPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("ForwardPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("SendPicCount");
    jdField_b_of_type_JavaUtilList.add("ForwardPicCount");
    jdField_b_of_type_JavaUtilList.add("ThumbPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("BigPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("DownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("DownloadBigPicCount");
    jdField_b_of_type_JavaUtilList.add("PreDownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("PreDownloadBigPicCount");
    jdField_b_of_type_JavaUtilList.add("PreviewBigPicHitCount");
    jdField_b_of_type_JavaUtilList.add("PreviewBigPicMissCount");
    jdField_b_of_type_JavaUtilList.add("PreDownloadThumbPicHitCount");
    jdField_b_of_type_JavaUtilList.add("PreDownloadThumbPicMissCount");
    int i1 = 0;
    while (i1 < e)
    {
      int i2 = 0;
      while (i2 < f)
      {
        jdField_b_of_type_JavaUtilList.add(jdField_a_of_type_Array2dOfJavaLangString[i1][i2]);
        jdField_b_of_type_JavaUtilList.add(jdField_b_of_type_Array2dOfJavaLangString[i1][i2]);
        jdField_b_of_type_JavaUtilList.add(jdField_c_of_type_Array2dOfJavaLangString[i1][i2]);
        jdField_b_of_type_JavaUtilList.add(d[i1][i2]);
        i2 += 1;
      }
      i1 += 1;
    }
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("PicDownloadSizeSmall");
    jdField_a_of_type_JavaUtilList.add("PicDownloadSizeMiddle");
    jdField_a_of_type_JavaUtilList.add("PicDownloadSizeLarge");
    jdField_a_of_type_JavaUtilList.add("PicDownloadSizeExtraLarge");
    jdField_a_of_type_JavaUtilList.add("PicDownloadSizeLong");
    jdField_a_of_type_JavaUtilList.add("PicPreviewSizeSmall");
    jdField_a_of_type_JavaUtilList.add("PicPreviewSizeMiddle");
    jdField_a_of_type_JavaUtilList.add("PicPreviewSizeLarge");
    jdField_a_of_type_JavaUtilList.add("PicPreivewSizeExtraLarge");
    jdField_a_of_type_JavaUtilList.add("PicPreviewSizeLong");
  }
  
  @TargetApi(9)
  public PicStatisticsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramQQAppInterface = jdField_b_of_type_JavaUtilList.iterator();
    while (paramQQAppInterface.hasNext())
    {
      String str = (String)paramQQAppInterface.next();
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      this.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l1));
    }
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("ManagerInitTimes")).longValue() + 1L;
    this.jdField_a_of_type_JavaUtilMap.put("ManagerInitTimes", Long.valueOf(l1));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("ManagerInitTimes", l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("ManagerInitTimes", l1).commit();
  }
  
  private HashMap a()
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadBigPicCount")).longValue();
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreviewBigPicHitCount")).longValue();
    long l3 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreviewBigPicMissCount")).longValue();
    long l4 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicHitCount")).longValue();
    long l5 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicCount")).longValue();
    float f1 = (float)l2 / (float)l1;
    float f2 = (float)l2 / (float)(l2 + l3);
    float f3 = (float)l4 / (float)l5;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, String.valueOf(((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue()));
    }
    localHashMap.put("PredownloadUtilization", String.valueOf(f1));
    localHashMap.put("PredownloadBigPicHitRate", String.valueOf(f2));
    localHashMap.put("PreDownloadThumbPicHitRate", String.valueOf(f3));
    return localHashMap;
  }
  
  @TargetApi(9)
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString)
  {
    int i2 = 0;
    String str2;
    int i1;
    String str1;
    label28:
    long l1;
    if (paramInt1 == 0)
    {
      str2 = "WIFI";
      i1 = 0;
      if (paramInt2 != 3) {
        break label153;
      }
      str1 = "C2C";
      paramInt1 = i2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "addCount(): networkType=" + str2 + " uin=" + str1);
      }
      paramArrayOfString = paramArrayOfString[i1][paramInt1];
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString)).longValue() + 1L;
      this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString, Long.valueOf(l1));
      if (Build.VERSION.SDK_INT < 9) {
        break label214;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).apply();
    }
    label153:
    do
    {
      return;
      str2 = "XG";
      i1 = 1;
      break;
      if (paramInt2 == 2)
      {
        str1 = "Discussion";
        paramInt1 = 1;
        break label28;
      }
      if (paramInt2 == 0)
      {
        str1 = "Group";
        paramInt1 = 2;
        break label28;
      }
      if (paramInt2 == 1)
      {
        str1 = "Digital Group";
        paramInt1 = 3;
        break label28;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_c_of_type_JavaLangString, 2, "addCount(): Error! Unknown uin type");
    return;
    label214:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).commit();
  }
  
  private HashMap b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  private void b()
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, ((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue());
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PicStatisticsFirstUsed", false)) {
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsFirstUsed", true).apply();
        if (QLog.isColorLevel()) {
          QLog.i(jdField_c_of_type_JavaLangString, 2, "dataReport(): Not need to data report!");
        }
      }
    }
    String str;
    label301:
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsFirstUsed", true).commit();
      break;
      Object localObject1;
      Object localObject2;
      long l1;
      long l2;
      long l3;
      long l4;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = a();
        boolean bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
        l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicCount")).longValue();
        l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadBigPicCount")).longValue();
        l3 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreviewBigPicHitCount")).longValue();
        l4 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreviewBigPicMissCount")).longValue();
        if (!bool) {
          break label301;
        }
        str = "PicStatisticsForWhiteList";
      }
      for (;;)
      {
        HashMap localHashMap = b();
        StatisticCollector.a(BaseApplication.getContext()).a((String)localObject1, str, false, 0L, 0L, (HashMap)localObject2, "");
        StatisticCollector.a(BaseApplication.getContext()).a((String)localObject1, "DiffSizePicPreview", false, 0L, 0L, localHashMap, "");
        localObject1 = jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(0L));
        }
        localObject1 = null;
        break;
        if (l1 == 0L)
        {
          str = "PicStatisticsForInactiveUser";
          ((HashMap)localObject2).put("InactiveReason", "1");
        }
        else if (l2 == 0L)
        {
          str = "PicStatisticsForInactiveUser";
          ((HashMap)localObject2).put("InactiveReason", "2");
        }
        else if (l3 + l4 == 0L)
        {
          str = "PicStatisticsForInactiveUser";
          ((HashMap)localObject2).put("InactiveReason", "3");
        }
        else
        {
          str = "PicStatistics";
        }
      }
      b();
    } while (!QLog.isColorLevel());
    QLog.i(jdField_c_of_type_JavaLangString, 2, "dataReport(): tagName=" + str + " ");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDowonloadBigPicCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_a_of_type_Array2dOfJavaLangString);
  }
  
  @TargetApi(9)
  public void a(int paramInt, long paramLong)
  {
    String str3;
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "addPicData(): Unknown picture type!");
      }
      return;
    case 13057: 
      str3 = "SendPic";
      str2 = "SendPicTotalSize";
      str1 = "SendPicCount";
    }
    long l1;
    long l2;
    for (;;)
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(str2)).longValue() + paramLong;
      l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(str1)).longValue() + 1L;
      this.jdField_a_of_type_JavaUtilMap.put(str2, Long.valueOf(l1));
      this.jdField_a_of_type_JavaUtilMap.put(str1, Long.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "addPictureData(): type=" + str3 + " Adding Size=" + paramLong + " Total Size=" + l1 + " Count=" + l2);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).apply();
      return;
      str3 = "ForwardPic";
      str2 = "ForwardPicTotalSize";
      str1 = "ForwardPicCount";
      continue;
      str3 = "DownloadThumbPic";
      str2 = "ThumbPicTotalSize";
      str1 = "DownloadThumbPicCount";
      continue;
      str3 = "DownloadBigPic";
      str2 = "BigPicTotalSize";
      str1 = "DownloadBigPicCount";
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).commit();
  }
  
  @TargetApi(9)
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "addDownloadBigPicSize(): Width=" + paramLong1 + " Height=" + paramLong2 + ", invalid!");
      }
      return;
    }
    long l1 = paramLong1 * paramLong2;
    String str;
    if ((paramLong1 > 3L * paramLong2) || (paramLong2 > 3L * paramLong1)) {
      str = "PicDownloadSizeLong";
    }
    for (;;)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "addDownloadBigPicSize(): " + str + ", Width=" + paramLong1 + " Height=" + paramLong2 + " Count=" + l1);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1 + 1L).apply();
      return;
      if (l1 <= 40000L) {
        str = "PicDownloadSizeSmall";
      } else if (l1 <= 250000L) {
        str = "PicDownloadSizeMiddle";
      } else if (l1 <= 691200L) {
        str = "PicDownloadSizeLarge";
      } else {
        str = "PicDownloadSizeExtraLarge";
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1 + 1L).commit();
  }
  
  @TargetApi(9)
  public void a(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + paramMessageForPic.md5);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramMessageForPic.md5);
        long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicCount")).longValue() + 1L;
        this.jdField_a_of_type_JavaUtilMap.put("PreDownloadThumbPicCount", Long.valueOf(l1));
        if (Build.VERSION.SDK_INT >= 9)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PreDownloadThumbPicCount", l1).apply();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_c_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + l1);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PreDownloadThumbPicCount", l1).commit();
        }
      }
      finally {}
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDownloadBigPicHitCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_b_of_type_Array2dOfJavaLangString);
  }
  
  @TargetApi(9)
  public void b(long paramLong1, long paramLong2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreviewBigPicSize(): Width=" + paramLong1 + " Height=" + paramLong2 + ", invalid!");
      }
      return;
    }
    long l1 = paramLong1 * paramLong2;
    String str;
    if ((paramLong1 > 3L * paramLong2) || (paramLong2 > 3L * paramLong1)) {
      str = "PicPreviewSizeLong";
    }
    for (;;)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreviewBigPicSize(): " + str + ", Width=" + paramLong1 + " Height=" + paramLong2 + " Count=" + l1);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1 + 1L).apply();
      return;
      if (l1 <= 40000L) {
        str = "PicPreviewSizeSmall";
      } else if (l1 <= 250000L) {
        str = "PicPreviewSizeMiddle";
      } else if (l1 <= 691200L) {
        str = "PicPreviewSizeLarge";
      } else {
        str = "PicPreivewSizeExtraLarge";
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1 + 1L).commit();
  }
  
  @TargetApi(9)
  public void b(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      long l1;
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDownloadBigPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + str);
        }
        boolean bool = this.jdField_b_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_b_of_type_JavaUtilSet.add(str);
        long l3 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadBigPicCount")).longValue() + 1L;
        long l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicHitCount")).longValue();
        l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("PreDownloadThumbPicMissCount")).longValue();
        this.jdField_a_of_type_JavaUtilMap.put("PreDownloadBigPicCount", Long.valueOf(l3));
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PreDownloadBigPicCount", l3);
        if (this.jdField_a_of_type_JavaUtilSet.contains(str))
        {
          l2 += 1L;
          this.jdField_a_of_type_JavaUtilMap.put("PreDownloadThumbPicHitCount", Long.valueOf(l2));
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PreDownloadThumbPicHitCount", l2);
          if (Build.VERSION.SDK_INT < 9) {
            break label342;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i(jdField_c_of_type_JavaLangString, 2, "addPreDownloadBigPic(): PreDownloadBigPicCount=" + l3 + " PreDownloadThumbPicHitCount=" + l2 + " PreDownloadThumbPicMissCount=" + l1);
          continue;
        }
        l1 += 1L;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put("PreDownloadThumbPicMissCount", Long.valueOf(l1));
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PreDownloadThumbPicMissCount", l1);
      continue;
      label342:
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDownloadBigPicMissCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_c_of_type_Array2dOfJavaLangString);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "addPreDownloadNotSupportCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, d);
  }
  
  public void onDestroy()
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("ManagerDestroyTimes")).longValue();
    this.jdField_a_of_type_JavaUtilMap.put("ManagerDestroyTimes", Long.valueOf(l1 + 1L));
    b();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "onDestroy()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicStatisticsManager
 * JD-Core Version:    0.7.0.1
 */