package com.tencent.qqmini.sdk.entry;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniAppExposureManager
{
  public static final String TAG = "MiniAppExposureManager";
  private int desktopPullDownState = 1;
  private Map<String, BaseExposureReport> duplicateItemMap = new HashMap();
  private List<BaseExposureReport> reportItemList = new ArrayList();
  
  public static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
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
  
  public void clear()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
  }
  
  public int getDesktopPullDownState()
  {
    return this.desktopPullDownState;
  }
  
  public Map<String, BaseExposureReport> getDuplicateItemMap()
  {
    return this.duplicateItemMap;
  }
  
  public List<BaseExposureReport> getReportItemList()
  {
    return this.reportItemList;
  }
  
  public void onDestroy()
  {
    this.reportItemList.clear();
    this.duplicateItemMap.clear();
    QMLog.d("MiniAppExposureManager", "onDestroy");
  }
  
  public void putReportDataToMap(String paramString, BaseExposureReport paramBaseExposureReport)
  {
    this.duplicateItemMap.put(paramString, paramBaseExposureReport);
  }
  
  public void setDesktopPullDownState(int paramInt)
  {
    this.desktopPullDownState = paramInt;
  }
  
  public static abstract interface BaseExposureReport
  {
    public abstract void report();
  }
  
  public static class CardModuleExposureData
    implements MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private String reserves;
    private String reserves2;
    private String subActionType;
    
    public CardModuleExposureData(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.reserves = paramString3;
      this.reserves2 = paramString4;
    }
    
    public void report()
    {
      SDKMiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, null, null, false);
    }
  }
  
  public static class CommonExposureData
    implements MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private String reserves;
    private String reserves2;
    private String reserves3;
    private String reserves4 = null;
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
      SDKMiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
    }
  }
  
  public static class MiniAppExposureData
    implements MiniAppExposureManager.BaseExposureReport
  {
    private MiniAppInfo appConfig;
    private int position;
    private String reserves2;
    
    public MiniAppExposureData(MiniAppInfo paramMiniAppInfo, int paramInt)
    {
      this.appConfig = paramMiniAppInfo;
      this.position = paramInt;
    }
    
    public MiniAppExposureData(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
    {
      this.appConfig = paramMiniAppInfo;
      this.position = paramInt;
      this.reserves2 = paramString;
    }
    
    public MiniAppInfo getMiniAppConfig()
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
    implements MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private MiniAppInfo appConfig;
    private String subActionType;
    
    public MiniAppModuleExposureData(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.appConfig = paramMiniAppInfo;
    }
    
    public void report()
    {
      SDKMiniProgramLpReportDC04239.exposureReport(this.appConfig, MiniAppExposureManager.getAppType(this.appConfig), null, this.actionType, this.subActionType, null, null);
    }
  }
  
  public static class MiniAppRedDotExposureData
    implements MiniAppExposureManager.BaseExposureReport
  {
    private String actionType;
    private MiniAppInfo appConfig;
    private int redDotNum;
    private String subActionType;
    
    public MiniAppRedDotExposureData(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt)
    {
      this.actionType = paramString1;
      this.subActionType = paramString2;
      this.appConfig = paramMiniAppInfo;
      this.redDotNum = paramInt;
    }
    
    public MiniAppInfo getMiniAppConfig()
    {
      return this.appConfig;
    }
    
    public void report()
    {
      MiniAppInfo localMiniAppInfo = this.appConfig;
      String str2 = MiniAppExposureManager.getAppType(this.appConfig);
      String str3 = this.actionType;
      String str4 = this.subActionType;
      if (this.redDotNum > 0) {}
      for (String str1 = String.valueOf(this.redDotNum);; str1 = "0")
      {
        SDKMiniProgramLpReportDC04239.exposureReport(localMiniAppInfo, str2, null, str3, str4, null, str1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.entry.MiniAppExposureManager
 * JD-Core Version:    0.7.0.1
 */