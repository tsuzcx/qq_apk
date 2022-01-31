package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;

public abstract class EarlyHandler
{
  public static final int a = 86400000;
  static final String jdField_a_of_type_JavaLangString = "early";
  public static final int b = 21600000;
  static final String b;
  private static final String c = "actEarlyDownUse";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList a;
  protected boolean a;
  protected boolean b;
  private String d;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.as + "early";
  }
  
  public EarlyHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.d = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    int i = 0;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = EarlyDataFactory.a(a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public abstract Class a();
  
  public String a()
  {
    File localFile = BaseApplication.getContext().getDir("early", 0);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.d;
  }
  
  public GetResourceReqInfo a()
  {
    if (!e()) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = this.d;
    localGetResourceReqInfo.uiCurVer = a();
    localGetResourceReqInfo.sResType = 3;
    localGetResourceReqInfo.sLanType = 1;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(long paramLong)
  {
    XmlData localXmlData = a();
    localXmlData.timeSync = paramLong;
    EarlyDataFactory.a(localXmlData, new String[] { "timeSync" });
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "updateSyncTime() name=" + localXmlData.Name + " time=" + paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if (paramEarlyDownLoadListener != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEarlyDownLoadListener);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    Object localObject1 = null;
    if (paramXmlData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "doOnServerResp() return respData == null.");
      }
      return;
    }
    XmlData localXmlData = a();
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnServerResp() serverVer=" + paramXmlData.Version + " localVer=" + localXmlData.Version + " localState=" + localXmlData.loadState);
    }
    File localFile1 = new File(a());
    if (localFile1.exists()) {}
    for (;;)
    {
      for (;;)
      {
        File localFile2;
        Object localObject4;
        try
        {
          String str = MD5FileUtil.a(localFile1);
          if ((str != null) && (str.equals(paramXmlData.MD5)))
          {
            localObject1 = localFile1;
            localFile2 = new File(b());
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              localObject3 = localObject1;
              if (localXmlData.StoreBackup)
              {
                localObject3 = localObject1;
                if (!localFile2.exists()) {}
              }
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            Object localObject3 = MD5FileUtil.a(localFile2);
            if ((localObject3 != null) && (((String)localObject3).equals(paramXmlData.MD5)))
            {
              localObject3 = localFile2;
              localXmlData.timeSync = System.currentTimeMillis();
              if (localObject3 != null) {
                break label419;
              }
              if (paramXmlData.Version < localXmlData.Version) {
                break;
              }
              if (paramXmlData.Version != localXmlData.Version) {
                break label386;
              }
              if (localXmlData.loadState == 1) {
                break;
              }
              localXmlData.updateServerInfo(paramXmlData);
              EarlyDataFactory.a(localXmlData, new String[0]);
              d();
              return;
              localException2 = localException2;
              localException2.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + localFile1.getAbsolutePath());
              }
              localObject2 = null;
              continue;
              localFile1.delete();
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            localObject4 = localObject2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed:" + localFile2.getAbsolutePath());
            localObject4 = localObject2;
            continue;
            localFile2.delete();
            localObject4 = localObject1;
            continue;
          }
        }
        label386:
        if (paramXmlData.Version <= localXmlData.Version) {
          break;
        }
        localXmlData.updateServerInfo(paramXmlData);
        EarlyDataFactory.a(localXmlData, new String[0]);
        d();
        return;
        label419:
        localXmlData.updateServerInfo(paramXmlData);
        localXmlData.Version = paramXmlData.Version;
        localXmlData.loadState = 1;
        EarlyDataFactory.a(localXmlData, new String[0]);
        if ((localFile1.exists()) || (!a())) {}
        try
        {
          for (;;)
          {
            FileUtils.a(localObject4, localFile1);
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + localObject4.getAbsolutePath() + "] to [" + localFile1.getAbsolutePath() + "]");
            }
            label526:
            a(localObject4.getAbsolutePath());
            if ((localFile2.exists()) || (!paramXmlData.StoreBackup)) {
              break;
            }
            try
            {
              FileUtils.a(localObject4, localFile2);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("EarlyDown", 2, "doOnServerResp() copy[" + localObject4.getAbsolutePath() + "] to [" + localFile2.getAbsolutePath() + "]");
              return;
            }
            catch (Exception paramXmlData)
            {
              return;
            }
          }
        }
        catch (Exception localException1)
        {
          break label526;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    if (paramBoolean) {
      a(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(paramXmlData, paramBoolean, paramInt, a(), paramString);
      }
    }
  }
  
  public abstract void a(String paramString);
  
  public void a(boolean paramBoolean)
  {
    new File(a()).delete();
    XmlData localXmlData = a();
    localXmlData.Version = 0;
    localXmlData.timeSync = 0L;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "timeSync", "loadState", "tLoadFail" });
    localXmlData.isUserClick = paramBoolean;
    ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { a() });
  }
  
  public abstract boolean a();
  
  public boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData + ", filepath=" + paramString);
    }
    if ((paramXmlData == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (TextUtils.isEmpty(paramXmlData.MD5)) {
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "verifyResource() file[" + paramString + "] not exist..");
      }
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = MD5FileUtil.a(localFile);
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource() data.md5=" + paramXmlData.MD5 + ", file.md5=" + paramString);
      }
      if (paramXmlData.MD5.toLowerCase().equals(paramString.toLowerCase())) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed");
          paramString = localObject;
        }
      }
    }
    return false;
  }
  
  public String b()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.d;
  }
  
  public void b()
  {
    if (!a()) {
      new File(a()).delete();
    }
  }
  
  public void b(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if ((paramEarlyDownLoadListener != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramEarlyDownLoadListener);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    paramXmlData.loadState = 2;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() isInUsed=" + paramBoolean + " pkg:" + this.d);
    }
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      if (!paramBoolean) {
        break label97;
      }
      if (localXmlData.loadState == 1) {
        localXmlData.loadState = 0;
      }
    }
    for (;;)
    {
      EarlyDataFactory.a(localXmlData, new String[] { "loadState", "timeSync", "Version" });
      return;
      label97:
      localXmlData.loadState = 0;
      localXmlData.timeSync = 0L;
      localXmlData.Version = 0;
    }
  }
  
  public boolean b()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label310;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.getStrPkgName() + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (NetworkUtil.c(BaseApplicationImpl.getContext())) {
        if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label305;
          }
        }
      }
      label305:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.getStrPkgName() + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.getStrPkgName() + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label310:
      bool2 = false;
    }
  }
  
  public void c()
  {
    if (a())
    {
      File localFile = new File(a());
      boolean bool = localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
      }
    }
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    paramXmlData.loadState = 0;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strPkgName", this.d);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strPkgName=" + this.d + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        i = 1;
      }
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool1 = bool2;
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool2;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool2;
          if (localXmlData.tLoadFail + 21600000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " tLoadFail=" + localXmlData.tLoadFail);
    }
    return bool1;
  }
  
  public boolean d()
  {
    XmlData localXmlData = a();
    boolean bool = b();
    if (bool)
    {
      ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(localXmlData, a());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool + " strPkgName=" + this.d);
    }
    return false;
  }
  
  public boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    XmlData localXmlData = a();
    if (localXmlData == null)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNeedServerInfo() data==null,return true");
        bool2 = bool1;
      }
      return bool2;
    }
    long l = System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      if (!a())
      {
        bool1 = bool2;
        if (!new File(a()).exists())
        {
          b(false);
          b();
          bool1 = bool2;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNeedServerInfo() need=" + bool1 + " syncTime=" + localXmlData.timeSync + " tLoadFil=" + localXmlData.tLoadFail + " curTime=" + l + " isWifi=" + NetworkUtil.g(BaseApplicationImpl.getContext()) + " name=" + localXmlData.Name);
        return bool1;
        bool1 = bool2;
        if (localXmlData.timeSync <= l)
        {
          bool1 = bool2;
          if (l - localXmlData.timeSync <= 86400000L) {
            bool1 = false;
          }
        }
      }
    }
    if ((localXmlData.Version != 0) || (localXmlData.timeSync != 0L))
    {
      if (localXmlData.Version == 0) {
        break label327;
      }
      localXmlData.Version = 0;
    }
    label327:
    for (int i = 1;; i = 0)
    {
      if (localXmlData.timeSync != 0L)
      {
        localXmlData.timeSync = 0L;
        i = 1;
      }
      if (i != 0) {
        EarlyDataFactory.a(localXmlData, new String[] { "Version", "timeSync" });
      }
      bool1 = bool2;
      if (c()) {
        break;
      }
      bool1 = bool2;
      if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public boolean f()
  {
    XmlData localXmlData = a();
    if (localXmlData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. data == null");
      }
    }
    do
    {
      return false;
      if (NetworkUtil.g(BaseApplicationImpl.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() isWifi, return " + localXmlData.net_2_wifi + " strPkgName=" + localXmlData.getStrPkgName());
        }
        return localXmlData.net_2_wifi;
      }
      if (NetworkUtil.c(BaseApplicationImpl.getContext()))
      {
        if (NetworkUtil.d(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is3Gor4G, return " + localXmlData.net_2_3G + " strPkgName=" + localXmlData.getStrPkgName());
          }
          return localXmlData.net_2_3G;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is2G, return " + localXmlData.net_2_2G + " strPkgName=" + localXmlData.getStrPkgName());
        }
        return localXmlData.net_2_2G;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. no wifi or mobile net. strPkgName=" + localXmlData.getStrPkgName());
    return false;
  }
  
  public boolean g()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.EarlyHandler
 * JD-Core Version:    0.7.0.1
 */