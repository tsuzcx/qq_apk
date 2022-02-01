package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import awmt;
import awmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class MiniAppExposureManager
  implements Manager
{
  public static final String TAG = "MiniAppExposureManager";
  private Map<String, BaseExposureReport> duplicateItemMap = new HashMap();
  private List<BaseExposureReport> reportItemList = new ArrayList();
  private List<BaseExposureReport> searchItemList = new ArrayList();
  
  public MiniAppExposureManager(QQAppInterface paramQQAppInterface) {}
  
  public static String getAppType(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
  }
  
  public void addReportItem(BaseExposureReport paramBaseExposureReport)
  {
    this.reportItemList.add(paramBaseExposureReport);
  }
  
  public void addSearchItemAndCheckReport(BaseExposureReport paramBaseExposureReport)
  {
    this.searchItemList.add(paramBaseExposureReport);
    if (searchReportCheck()) {
      submitSearchReportData();
    }
  }
  
  public void clear()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
  }
  
  public void clearSearchItemData()
  {
    this.searchItemList.clear();
  }
  
  public Map<String, BaseExposureReport> getDuplicateItemMap()
  {
    return this.duplicateItemMap;
  }
  
  public List<BaseExposureReport> getReportItemList()
  {
    return this.reportItemList;
  }
  
  public List<BaseExposureReport> getSearchItemList()
  {
    return this.searchItemList;
  }
  
  public void onDestroy()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
    QLog.d("MiniAppExposureManager", 2, "onDestroy");
  }
  
  public void putReportDataToMap(String paramString, BaseExposureReport paramBaseExposureReport)
  {
    if (this.duplicateItemMap.get(paramString) == null) {
      this.duplicateItemMap.put(paramString, paramBaseExposureReport);
    }
  }
  
  public boolean searchReportCheck()
  {
    return this.searchItemList.size() >= 20;
  }
  
  public void submitSearchReportData()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(getSearchItemList());
    MiniProgramLpReportDC04239.exposureReport(localArrayList);
    clearSearchItemData();
  }
  
  public static abstract class BaseExposureReport
  {
    private volatile boolean hasReport;
    
    public void handleReport()
    {
      if (hasReport()) {
        return;
      }
      report();
      setHasReport(true);
    }
    
    public boolean hasReport()
    {
      return this.hasReport;
    }
    
    public abstract void report();
    
    public void setHasReport(boolean paramBoolean)
    {
      this.hasReport = paramBoolean;
    }
  }
  
  public static class CardModuleExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private String reserves;
    private String reserves2;
    private String reserves3;
    private String reserves4;
    private String subActionType;
    
    public CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.reserves = paramString3;
      this.reserves2 = paramString4;
    }
    
    public CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.reserves = paramString3;
      this.reserves2 = paramString4;
      this.reserves3 = paramString5;
      this.reserves4 = paramString6;
    }
    
    public void report()
    {
      MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
    }
  }
  
  public static class CommonExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private String reserves;
    private String reserves2;
    private String reserves3;
    private String reserves4;
    private String subActionType;
    
    public CommonExposureData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.reserves = paramString3;
      this.reserves2 = paramString4;
      this.reserves3 = paramString5;
    }
    
    public void report()
    {
      MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
    }
  }
  
  public static class MiniAppExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private MiniAppConfig appConfig;
    private int position;
    private String reserves2;
    
    public MiniAppExposureData(MiniAppConfig paramMiniAppConfig, int paramInt)
    {
      this.appConfig = paramMiniAppConfig;
      this.position = paramInt;
    }
    
    public MiniAppExposureData(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString)
    {
      this.appConfig = paramMiniAppConfig;
      this.position = paramInt;
      this.reserves2 = paramString;
    }
    
    public MiniAppConfig getMiniAppConfig()
    {
      return this.appConfig;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    public String getReserves2()
    {
      return this.reserves2;
    }
    
    public void report() {}
  }
  
  public static class MiniAppModuleExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private MiniAppConfig appConfig;
    private String subActionType;
    
    public MiniAppModuleExposureData(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.appConfig = paramMiniAppConfig;
    }
    
    public void report()
    {
      MiniProgramLpReportDC04239.exposureReport(this.appConfig, MiniAppExposureManager.getAppType(this.appConfig), null, this.actionType, this.subActionType, null, null);
    }
  }
  
  public static class MiniAppRedDotExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private MiniAppConfig appConfig;
    private int redDotNum;
    private String subActionType;
    
    public MiniAppRedDotExposureData(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, int paramInt)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.appConfig = paramMiniAppConfig;
      this.redDotNum = paramInt;
    }
    
    public MiniAppConfig getMiniAppConfig()
    {
      return this.appConfig;
    }
    
    public void report()
    {
      MiniAppConfig localMiniAppConfig = this.appConfig;
      String str2 = MiniAppExposureManager.getAppType(this.appConfig);
      String str3 = this.actionType;
      String str4 = this.subActionType;
      if (this.redDotNum > 0) {}
      for (String str1 = String.valueOf(this.redDotNum);; str1 = "0")
      {
        MiniProgramLpReportDC04239.exposureReport(localMiniAppConfig, str2, null, str3, str4, null, str1);
        return;
      }
    }
  }
  
  public static class TianShuExposureData
    extends MiniAppExposureManager.BaseExposureReport
  {
    private int actionId;
    private String appId;
    private String itemId;
    private String pageId;
    
    public TianShuExposureData(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.appId = paramString1;
      this.pageId = paramString2;
      this.itemId = paramString3;
      this.actionId = paramInt;
    }
    
    public void report()
    {
      try
      {
        awmu localawmu = new awmu();
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        String str = "";
        if (localAppRuntime != null) {
          str = localAppRuntime.getAccount();
        }
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        localawmu.mTraceId = (str + "_" + l);
        localawmu.eBX = 1;
        localawmu.mAppId = this.appId;
        localawmu.cNQ = this.pageId;
        localawmu.cNR = this.itemId;
        localawmu.mActionId = this.actionId;
        localawmu.eBB = 1;
        localawmu.aBn = l;
        awmt.a().a(localawmu);
        if (QLog.isColorLevel()) {
          QLog.i("MiniAppExposureManager", 2, "TianShuExposureData, report itemId: " + this.itemId);
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("MiniAppExposureManager", 1, "TianShuExposureData, report exception: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager
 * JD-Core Version:    0.7.0.1
 */