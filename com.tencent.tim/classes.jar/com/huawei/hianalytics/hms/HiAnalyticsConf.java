package com.huawei.hianalytics.hms;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.kl.fg;

public class HiAnalyticsConf
{
  public static class Builder
  {
    String appid;
    Context mContext;
    com.huawei.hianalytics.ab.bc.cd.ab.cd maintData;
    com.huawei.hianalytics.ab.bc.cd.ab.cd operData;
    
    public Builder(Context paramContext)
    {
      if (paramContext != null) {
        this.mContext = paramContext.getApplicationContext();
      }
      this.operData = new com.huawei.hianalytics.ab.bc.cd.ab.cd();
      this.maintData = new com.huawei.hianalytics.ab.bc.cd.ab.cd();
    }
    
    public void create()
    {
      if (this.mContext == null)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.de("hmsSdk", "analyticsConf create(): context is null,create failed!");
        return;
      }
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.create() is execute.");
      com.huawei.hianalytics.ab.fg.cd localcd = new com.huawei.hianalytics.ab.fg.cd("_hms_config_tag");
      localcd.cd(new com.huawei.hianalytics.ab.bc.cd.ab.cd(this.operData));
      localcd.ab(new com.huawei.hianalytics.ab.bc.cd.ab.cd(this.maintData));
      com.huawei.hianalytics.ab.fg.ab.ab().ab(this.mContext);
      com.huawei.hianalytics.ab.fg.bc.ab().ab(this.mContext);
      ab.ab().ab(localcd);
      com.huawei.hianalytics.ab.fg.ab.ab().bc(this.appid);
    }
    
    public void refresh(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.refresh() is execute.");
      com.huawei.hianalytics.ab.bc.cd.ab.cd localcd1 = new com.huawei.hianalytics.ab.bc.cd.ab.cd(this.maintData);
      com.huawei.hianalytics.ab.bc.cd.ab.cd localcd2 = new com.huawei.hianalytics.ab.bc.cd.ab.cd(this.operData);
      com.huawei.hianalytics.ab.fg.cd localcd = ab.ab().bc();
      if (localcd == null) {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _hms_config_tag has no instance. ");
      }
      do
      {
        return;
        localcd.ab(1, localcd1);
        localcd.ab(0, localcd2);
        if (this.appid != null) {
          com.huawei.hianalytics.ab.fg.ab.ab().bc(this.appid);
        }
      } while (!paramBoolean);
      com.huawei.hianalytics.ab.fg.ab.ab().ab("_hms_config_tag");
    }
    
    public Builder setAndroidId(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "setAndroidId(String androidId) is execute.");
      this.operData.bc().cd(paramString);
      this.maintData.bc().cd(paramString);
      return this;
    }
    
    public Builder setAppID(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setAppID is execute");
      this.appid = paramString;
      return this;
    }
    
    public Builder setChannel(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setChannel(String channel) is execute.");
      String str = paramString;
      if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("channel", paramString, 256)) {
        str = "";
      }
      this.operData.ab(str);
      this.maintData.ab(str);
      return this;
    }
    
    public Builder setCollectURL(int paramInt, String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + paramInt);
      String str = paramString;
      if (!fg.ab(paramString)) {
        str = "";
      }
      switch (paramInt)
      {
      default: 
        com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
        return this;
      case 0: 
        this.operData.bc(str);
        return this;
      }
      this.maintData.bc(str);
      return this;
    }
    
    @Deprecated
    public Builder setEnableAndroidID(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setEnableAndroidID(boolean reportAndroidID) is execute.");
      this.operData.bc().de(paramBoolean);
      this.maintData.bc().de(paramBoolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableImei(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
      this.operData.bc().ab(paramBoolean);
      this.maintData.bc().ab(paramBoolean);
      return this;
    }
    
    public Builder setEnableMccMnc(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setEnableMccMnc(boolean enableMccMnc) is execute.");
      this.operData.bc(paramBoolean);
      this.maintData.bc(paramBoolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableSN(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
      this.operData.bc().bc(paramBoolean);
      this.maintData.bc().bc(paramBoolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableUDID(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
      this.operData.bc().cd(paramBoolean);
      this.maintData.bc().cd(paramBoolean);
      return this;
    }
    
    public Builder setEnableUUID(boolean paramBoolean)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "Builder.setEnableUUID() is executed.");
      this.operData.cd(paramBoolean);
      this.maintData.cd(paramBoolean);
      return this;
    }
    
    public Builder setIMEI(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "setIMEI(String imei) is execute.");
      this.operData.bc().ab(paramString);
      this.maintData.bc().ab(paramString);
      return this;
    }
    
    public Builder setSN(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "setSN(String sn) is execute.");
      this.operData.bc().de(paramString);
      this.maintData.bc().de(paramString);
      return this;
    }
    
    public Builder setUDID(String paramString)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "setUDID(String udid) is execute.");
      this.operData.bc().bc(paramString);
      this.maintData.bc().bc(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.hms.HiAnalyticsConf
 * JD-Core Version:    0.7.0.1
 */