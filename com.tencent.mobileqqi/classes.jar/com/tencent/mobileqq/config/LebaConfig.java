package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import frc;
import frd;
import fre;
import frf;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class LebaConfig
{
  public static final String a = "qzone_feedlist";
  private static final int jdField_b_of_type_Int = 3;
  public static final String b = "nearby_friends";
  public static final String c = "nearby_troops";
  public static final String d = "file_manager";
  public static final String e = "sao_yi_sao";
  public static final String f = "transfer_file";
  public static final String g = "com.tx.xingqubuluo.android";
  public static final String h = "personal_album";
  public static final String i = "my_profile";
  public static final String j = "what_is_up";
  public static final String k = "my_favorite";
  public static final String l = "privacy_item";
  private static final String m = "Q.lebatab.config";
  private static final String n = "mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqqi&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s";
  private static final String o = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqqi&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
  private static final String p = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqqi&cmp=com.tencent.mobileqq.troop.activity.NearbyTroopsActivity";
  private static final String q = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqqi&cmp=com.tencent.mobileqq.filemanager.activity.FileAssistantActivity";
  private static final String r = "mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&pkg=com.tencent.mobileqqi&cmp=com.tencent.biz.qrcode.activity.ScannerActivity";
  private static final String s = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqqi&cmp=com.dataline.activities.LiteActivity";
  private static final String t = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=aHR0cDovL3hpYW9xdS5xcS5jb20vbW9iaWxlL2luZGV4Lmh0bWw/X3d2PTEwMjcmX2JpZD0xMjgjZnJvbT1kb25ndGFpJnRhcmdldD1ob3Q=";
  private int jdField_a_of_type_Int = 0;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new frd(this);
  private boolean jdField_a_of_type_Boolean = true;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private List c;
  
  public LebaConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    if ((i1 > 300) && (i2 > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562713);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqqi&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "tab_qzone" });
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 860;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "nearby_friends";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562328);
    localResourcePluginInfo.strResURL = "icon_recent_lbs_hello_90px";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562328);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 270;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "transfer_file";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562422);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_computer";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 0;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 330;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqqi&cmp=com.dataline.activities.LiteActivity";
    localResourcePluginInfo.iPluginType = 64;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "personal_album";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561635);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_my_album";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 850;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "my_profile";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562665);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_profile";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 440;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "what_is_up";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561478);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_status";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 435;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "file_manager";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131558673);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_folder";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 379;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "my_favorite";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131560774);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_my_favorite";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 340;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "privacy_item";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563020);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_my_privacy";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 240;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = null;
    localArrayList.add(localResourcePluginInfo);
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.config", 2, "Download success icon key = " + paramString);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Map localMap;
    while (localIterator.hasNext())
    {
      localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          if (!localMap.containsKey("TIME")) {
            break label187;
          }
        }
      }
    }
    label187:
    for (int i1 = ((Integer)localMap.get("TIME")).intValue();; i1 = 0)
    {
      if (i1 >= 3) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.config", 2, "Download failed icon key = " + paramString + ",time=" + i1);
        }
        return;
        i1 += 1;
        localMap.put("TIME", Integer.valueOf(i1));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.config", 2, "Load leba config from DB begin ");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    ThreadManager.b(new frc(this, localArrayList));
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("mobileQQi", 0);
    } while (!((SharedPreferences)localObject).getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.config", 4, "clearLocalDBPlugin.local plugin.");
    }
    ThreadManager.b(new frf(this));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.config", 2, "Leba config init");
    }
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(false);
      return;
    }
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.config", 2, "send to get leba config");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
        if (localResourcePluginInfo.cDataType == 0)
        {
          GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
          localGetResourceReqInfoV2.cState = 0;
          localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
          localGetResourceReqInfoV2.sResSubType = 0;
          localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
          localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.config", 2, "on Get Leba start send: " + localArrayList.size());
    }
    paramPluginConfigProxy.a(64, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    if (!this.c.contains(paramDownloadIconsListener)) {
      this.c.add(paramDownloadIconsListener);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
      this.jdField_b_of_type_JavaUtilList.add(paramResourcePluginListener);
    }
  }
  
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramResourcePluginInfo != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
        if (localResourcePluginInfo.strPkgName.equals(paramResourcePluginInfo.strPkgName))
        {
          localResourcePluginInfo.cLocalState = paramResourcePluginInfo.cLocalState;
          localResourcePluginInfo.isNew = paramResourcePluginInfo.isNew;
        }
      }
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.config", 2, "Download icon for " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fre(this, paramURL, paramFile, paramString));
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.config", 2, "Download " + paramList.size() + " icons");
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Map localMap = (Map)paramList.next();
        String str = (String)localMap.get("KEY");
        URL localURL = (URL)localMap.get("URL");
        File localFile = (File)localMap.get("FILE");
        if (this.jdField_a_of_type_JavaUtilSet.add(str))
        {
          a(str, localURL, localFile);
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.config", 2, "Download icon key = " + str);
          }
          localMap.put("LOADING", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.config", 2, "error happens: loadLebaConfig while current account is null, which means there is no logined account now");
      }
    }
    do
    {
      return;
      if ((paramBoolean) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.config", 2, "there has leba data in memory cache, do not need load from DB");
    return;
    this.jdField_a_of_type_JavaUtilList = a();
    f();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    this.c.remove(paramDownloadIconsListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramResourcePluginListener);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return;
    }
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
    label33:
    label217:
    label220:
    for (;;)
    {
      Map localMap;
      String str;
      URL localURL;
      File localFile;
      Object localObject;
      if (localIterator.hasNext())
      {
        localMap = (Map)localIterator.next();
        if (localMap == null) {
          continue;
        }
        str = (String)localMap.get("KEY");
        localURL = (URL)localMap.get("URL");
        localFile = (File)localMap.get("FILE");
        localObject = localMap.get("LOADING");
        if ((localObject == null) || (!(localObject instanceof Boolean))) {
          break label217;
        }
      }
      for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
      {
        if ((TextUtils.isEmpty(str)) || (bool) || (!this.jdField_a_of_type_JavaUtilSet.add(str))) {
          break label220;
        }
        a(str, localURL, localFile);
        localMap.put("LOADING", Boolean.valueOf(true));
        if (!QLog.isColorLevel()) {
          break label33;
        }
        QLog.d("Q.lebatab.config", 2, "reDownload icon key = " + str);
        break label33;
        break;
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = new ArrayList(this.jdField_b_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_b_of_type_Boolean = false;
      PluginConfigProxy localPluginConfigProxy = new PluginConfigProxy();
      a(localPluginConfigProxy);
      localPluginConfigProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.LebaConfig
 * JD-Core Version:    0.7.0.1
 */