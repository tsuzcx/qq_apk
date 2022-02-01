package com.tencent.ark.open;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class ArkAppInfo
{
  public static final int APP_SCENE_TYPE_INPUT = 2;
  public static final int APP_SCENE_TYPE_MSG_FLOW = 1;
  public static final int APP_SCENE_TYPE_MSG_FLOW_SEARCH = 4;
  public static final int APP_SCENE_TYPE_NONE = 0;
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkAppInfo";
  
  public static class AppConfig
  {
    public long entry;
    public int flag;
    public ArrayList<String> forwardViews;
    public String iconUrl;
    public String name;
    public int type;
    public ArkAppInfo.AppUrlWhiteList urlWhitelist;
    public long ver;
    public ArrayList<ArkAppInfo.AppTemplateView> views;
  }
  
  public static class AppDesc
  {
    public String desc;
    public String iconPath;
    public boolean isTempApp;
    public String name;
    public String version;
    public String view;
  }
  
  public static class AppDownloadInfo
  {
    public ArkAppInfo.AppConfig config;
    public ArkAppInfo.AppDesc desc;
    public String downloadUrl;
    public String iconPath;
    public byte[] sign;
    public int updatePeriodByMinutes;
  }
  
  public static class AppTemplateView
  {
    public String template;
    public String templateView;
    public String view;
  }
  
  public static class AppUrlWhiteList
  {
    public final ArrayList<ArkAppInfo.ArkWhiteUrlItem> navigationList = new ArrayList();
    public final ArrayList<ArkAppInfo.ArkWhiteUrlItem> resourceList = new ArrayList();
  }
  
  public static class ArkWhiteUrlItem
    implements Parcelable
  {
    public static final Parcelable.Creator<ArkWhiteUrlItem> CREATOR = new ArkAppInfo.ArkWhiteUrlItem.1();
    public String ruleDomain;
    public String rulePath;
    
    public ArkWhiteUrlItem() {}
    
    protected ArkWhiteUrlItem(Parcel paramParcel)
    {
      this.ruleDomain = paramParcel.readString();
      this.rulePath = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return this.ruleDomain + this.rulePath;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.ruleDomain);
      paramParcel.writeString(this.rulePath);
    }
  }
  
  public static class Context
  {
    public String action;
    public String context;
  }
  
  public static class ContextActionAppInfo
  {
    public String action;
    public long appID;
    public String appName;
    public String context;
    public long updateTime;
  }
  
  public static class ContextWithMeta
  {
    public final ArkAppInfo.Context context = new ArkAppInfo.Context();
    public final ArkAppInfo.MetaValue meta = new ArkAppInfo.MetaValue();
  }
  
  public static class Meta
  {
    public final ArrayList<String> metaList = new ArrayList();
    public final ArrayList<String> metaListEx = new ArrayList();
  }
  
  public static class MetaValue
  {
    public final HashMap<String, String> metaList = new HashMap();
    public final HashMap<String, String> metaListEx = new HashMap();
  }
  
  public static class Size
  {
    public int height;
    public int width;
    
    public Size(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
  
  public static class TimeRecord
  {
    public long beginOfGetApp = 0L;
    public long endOfGetApp = 0L;
    public boolean getAppFromLocal = false;
    public ArkViewModelBase.TimeRecord mRecord;
    
    public TimeRecord(ArkViewModelBase.TimeRecord paramTimeRecord)
    {
      this.mRecord = paramTimeRecord;
    }
    
    private boolean isValid()
    {
      return (this.endOfGetApp != 0L) && (this.beginOfGetApp != 0L) && (this.mRecord.endOfCreateView != 0L) && (this.mRecord.beginOfCreateView != 0L) && (this.mRecord.endOfDisplyView != 0L) && (this.mRecord.beginOfDisplyView != 0L);
    }
    
    public void doExtraTimeReport()
    {
      int i = (int)(this.mRecord.beginOfCreateContext - this.mRecord.endOfDisplyView);
      int j = (int)(this.mRecord.endOfCreateDrawTarget - this.mRecord.beginOfCreateContext);
      int k = (int)(this.mRecord.endOfFirstDraw - this.mRecord.beginOfFirstDraw);
      int m = (int)(this.mRecord.endOfFirstDraw - this.mRecord.beginOfDisplyView);
      String str1 = this.mRecord.appName;
      String str2 = this.mRecord.view;
      ArkAppInfo.ENV.logI("ArkApp.ArkAppInfo", String.format(Locale.CHINA, "TimeRecord.appName.%s.view.%s.surfaceprepare.%d.createcontext.%d.firstdraw.%d.totalcost.%d.", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
      if ((str1 == null) || (str2 == null)) {
        return;
      }
      ArkAppReport.platformEventReport(str1, "PerfSurfacePrepare", 0, 0, i, 0L, 0L, str2, "");
      ArkAppReport.platformEventReport(str1, "PerfCreateContext", 0, 0, j, 0L, 0L, str2, "");
      ArkAppReport.platformEventReport(str1, "PerfFirstDraw", 0, 0, k, 0L, 0L, str2, "");
      ArkAppReport.platformEventReport(str1, "PerfDisplayTotalCost", 0, 0, m, 0L, 0L, str2, "");
    }
    
    public void doReport()
    {
      if (!isValid()) {}
      int j;
      int k;
      int m;
      String str1;
      String str2;
      do
      {
        return;
        j = (int)(this.endOfGetApp - this.beginOfGetApp);
        k = (int)(this.mRecord.endOfCreateView - this.mRecord.beginOfCreateView);
        m = (int)(this.mRecord.endOfDisplyView - this.mRecord.beginOfDisplyView);
        str1 = this.mRecord.appName;
        str2 = this.mRecord.view;
        ArkAppInfo.ENV.logI("ArkApp.ArkAppInfo", String.format(Locale.CHINA, "TimeRecord.appName.%s.view:%s.getapp.%d.createview.%d.dispview.%d.", new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
      } while ((str1 == null) || (str2 == null));
      if (this.getAppFromLocal) {}
      for (int i = 1;; i = 2)
      {
        ArkAppReport.platformEventReport(str1, "PerfGetApp", 0, i, j, 0L, 0L, str2, "");
        ArkAppReport.platformEventReport(str1, "PerfCreateView", 0, 0, k, 0L, 0L, str2, "");
        ArkAppReport.platformEventReport(str1, "PerfDisplayView", 0, 0, m, 0L, 0L, str2, "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppInfo
 * JD-Core Version:    0.7.0.1
 */