package com.huawei.updatesdk.service.otaupdate;

import java.util.List;

public class UpdateParams
{
  private String appStorePkgName = "com.huawei.appmarket";
  private boolean isShowImmediate = false;
  private int minIntervalDay = 0;
  private boolean mustBtnOne = false;
  private List<String> packageList;
  private String serviceZone;
  private String targetPkgName;
  
  private UpdateParams(Builder paramBuilder)
  {
    this.serviceZone = paramBuilder.serviceZone;
    this.appStorePkgName = paramBuilder.appStorePkgName;
    this.targetPkgName = paramBuilder.targetPkgName;
    this.isShowImmediate = paramBuilder.isShowImmediate;
    this.minIntervalDay = paramBuilder.minIntervalDay;
    this.mustBtnOne = paramBuilder.mustBtnOne;
    this.packageList = paramBuilder.packageList;
  }
  
  public String getAppStorePkgName()
  {
    return this.appStorePkgName;
  }
  
  public int getMinIntervalDay()
  {
    return this.minIntervalDay;
  }
  
  public List<String> getPackageList()
  {
    return this.packageList;
  }
  
  public String getServiceZone()
  {
    return this.serviceZone;
  }
  
  public String getTargetPkgName()
  {
    return this.targetPkgName;
  }
  
  public boolean isMustBtnOne()
  {
    return this.mustBtnOne;
  }
  
  public boolean isShowImmediate()
  {
    return this.isShowImmediate;
  }
  
  public static final class Builder
  {
    private String appStorePkgName = "com.huawei.appmarket";
    private boolean isShowImmediate;
    private int minIntervalDay;
    private boolean mustBtnOne;
    private List<String> packageList;
    private String serviceZone;
    private String targetPkgName;
    
    public UpdateParams build()
    {
      return new UpdateParams(this, null);
    }
    
    public Builder setAppStorePkgName(String paramString)
    {
      this.appStorePkgName = paramString;
      return this;
    }
    
    public Builder setIsShowImmediate(boolean paramBoolean)
    {
      this.isShowImmediate = paramBoolean;
      return this;
    }
    
    public Builder setMinIntervalDay(int paramInt)
    {
      this.minIntervalDay = paramInt;
      return this;
    }
    
    public Builder setMustBtnOne(boolean paramBoolean)
    {
      this.mustBtnOne = paramBoolean;
      return this;
    }
    
    public Builder setPackageList(List<String> paramList)
    {
      this.packageList = paramList;
      return this;
    }
    
    public Builder setServiceZone(String paramString)
    {
      this.serviceZone = paramString;
      return this;
    }
    
    public Builder setTargetPkgName(String paramString)
    {
      this.targetPkgName = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.UpdateParams
 * JD-Core Version:    0.7.0.1
 */