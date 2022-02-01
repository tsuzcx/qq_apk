package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import aqmr;
import awmt;
import awmu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class DesktopDittoAreaView
  extends DittoAreaView
{
  public static final String TAG = "DesktopDittoAreaView";
  private WeakReference<Activity> activityWeakReference;
  private DesktopDittoInfo dittoInfo;
  
  public DesktopDittoAreaView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.activityWeakReference = new WeakReference((Activity)paramContext);
  }
  
  public DesktopDittoAreaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getTianShuAdId()
  {
    if (this.dittoInfo == null) {
      return 0;
    }
    int i = this.dittoInfo.appInfoMap.size();
    if (i > 0) {}
    for (;;)
    {
      int j = this.dittoInfo.currentIndex;
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(j % i);
      if ((localMiniAppInfo == null) || (localMiniAppInfo.tianshuAdId <= 0)) {
        break;
      }
      return localMiniAppInfo.tianshuAdId;
      i = 1;
    }
    return 0;
  }
  
  public void handleExposureReport()
  {
    if (this.exposureReportingAreas.size() <= 0) {}
    do
    {
      return;
      localObject1 = MiniAppUtils.getAppInterface();
    } while (localObject1 == null);
    MiniAppExposureManager localMiniAppExposureManager = (MiniAppExposureManager)((AppInterface)localObject1).getManager(322);
    Iterator localIterator = this.exposureReportingAreas.iterator();
    Object localObject1 = "";
    Object localObject4;
    label900:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject4 = ((DittoArea)localIterator.next()).getLayoutAttr().getAttr("extendString", "");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          for (;;)
          {
            try
            {
              localJSONObject = new JSONObject((String)localObject4);
              QLog.e("DesktopDittoAreaView", 1, "handleExposureReport: data" + localJSONObject.toString());
              localObject4 = localJSONObject.optString("refer");
            }
            catch (Exception localException3)
            {
              JSONObject localJSONObject;
              String str1;
              String str2;
              Object localObject6;
              int i;
              Object localObject5;
              String str3;
              Object localObject2;
              continue;
              i += 1;
              continue;
              Object localObject3 = localObject4;
            }
            try
            {
              localObject1 = localJSONObject.optString("actionType");
              str1 = localJSONObject.optString("subAction");
              str2 = localJSONObject.optString("reservesAction");
              localObject6 = localJSONObject.optJSONArray("report");
              if ((localObject6 != null) && (((JSONArray)localObject6).length() > 0))
              {
                i = 0;
                if (i < ((JSONArray)localObject6).length())
                {
                  localObject5 = ((JSONArray)localObject6).optJSONObject(i);
                  localObject1 = ((JSONObject)localObject5).optString("appId");
                  str3 = ((JSONObject)localObject5).optString("reserves2");
                  if (this.dittoInfo != null)
                  {
                    localObject5 = (MiniAppInfo)this.dittoInfo.appInfoMap.get(localObject1);
                    localObject1 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject1 = localObject5;
                      if (localJSONObject.has("position"))
                      {
                        int j = localJSONObject.getInt("position");
                        localObject1 = (MiniAppInfo)this.dittoInfo.appInfoList.get(j);
                      }
                    }
                    if (localObject1 != null)
                    {
                      localObject1 = new MiniAppConfig((MiniAppInfo)localObject1);
                      ((MiniAppConfig)localObject1).launchParam.scene = Integer.valueOf((String)localObject4).intValue();
                      localObject5 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject1, "page_view", "expo");
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append(((MiniAppConfig)localObject1).config.appId).append("_").append(((MiniAppConfig)localObject1).config.verType).append("_").append(this.dittoInfo.getModuleType());
                      localMiniAppExposureManager.putReportDataToMap(localStringBuilder.toString(), (MiniAppExposureManager.BaseExposureReport)localObject5);
                    }
                  }
                  if (TextUtils.isEmpty(str1)) {
                    continue;
                  }
                  localMiniAppExposureManager.putReportDataToMap(str1, new MiniAppExposureManager.CardModuleExposureData("desktop", str1, str2, str3));
                  continue;
                }
              }
              else
              {
                localObject6 = localJSONObject.optString("reserves2");
                localObject5 = localJSONObject.optString("reserves3");
                str3 = localJSONObject.optString("reserves4");
                if (!aqmr.isEmpty((String)localObject1)) {
                  continue;
                }
                localObject1 = new MiniAppExposureManager.CardModuleExposureData("desktop", str1, str2, (String)localObject6, (String)localObject5, str3);
                localObject5 = str1;
                if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                  localObject5 = str1 + "_" + (String)localObject6;
                }
                localMiniAppExposureManager.putReportDataToMap((String)localObject5, (MiniAppExposureManager.BaseExposureReport)localObject1);
              }
              if (!localJSONObject.has("dubheReportData")) {
                continue;
              }
              localObject1 = localJSONObject.optJSONObject("dubheReportData");
              localObject5 = ((JSONObject)localObject1).optString("appId");
              str1 = ((JSONObject)localObject1).optString("pageId");
              if (!((JSONObject)localObject1).has("useMiniAppInfoTianShuId")) {
                continue;
              }
              i = getTianShuAdId();
              if (i == 0) {
                continue;
              }
              localObject1 = String.valueOf(i);
              localMiniAppExposureManager.putReportDataToMap((String)localObject1, new MiniAppExposureManager.TianShuExposureData((String)localObject5, str1, (String)localObject1, 101));
              continue;
              localObject1 = new MiniAppExposureManager.CardModuleExposureData((String)localObject1, str1, str2, (String)localObject6, (String)localObject5, str3);
              continue;
              QLog.e("DesktopDittoAreaView", 1, "handleExposureReport exception: " + Log.getStackTraceString((Throwable)localObject5));
            }
            catch (Exception localException1)
            {
              localObject5 = localException1;
              localObject2 = localObject4;
            }
            break label900;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            continue;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
          }
        }
      }
      else
      {
        if ((this.dittoInfo == null) || (this.dittoInfo.jumpMoreInfo == null) || (TextUtils.isEmpty(this.dittoInfo.jumpMoreInfo.appId)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break;
        }
        try
        {
          localObject4 = new MiniAppConfig(this.dittoInfo.jumpMoreInfo);
          ((MiniAppConfig)localObject4).launchParam.scene = Integer.valueOf((String)localObject2).intValue();
          localObject2 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject4, "page_view", "expo");
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((MiniAppConfig)localObject4).config.appId).append("_").append(((MiniAppConfig)localObject4).config.verType).append("_").append(this.dittoInfo.getModuleType());
          localMiniAppExposureManager.putReportDataToMap(((StringBuilder)localObject5).toString(), (MiniAppExposureManager.BaseExposureReport)localObject2);
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("DesktopDittoAreaView", 1, "handleExposureReport, app store, exception: " + Log.getStackTraceString(localException2));
          return;
        }
      }
    }
  }
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    label279:
    label290:
    label328:
    label367:
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramMotionEvent = new JSONObject(paramString);
        if (paramMotionEvent.has("dubheReportData"))
        {
          paramString = paramMotionEvent.optJSONObject("dubheReportData");
          localObject1 = paramString.optString("appId");
          localObject2 = paramString.optString("pageId");
          if (!paramString.has("useMiniAppInfoTianShuId")) {
            break label290;
          }
          i = getTianShuAdId();
          if (i == 0) {
            break label279;
          }
          paramString = String.valueOf(i);
          break label1269;
        }
        for (;;)
        {
          localObject3 = new awmu();
          localObject4 = BaseApplicationImpl.getApplication().getRuntime();
          paramDittoArea = "";
          if (localObject4 != null) {
            paramDittoArea = ((AppRuntime)localObject4).getAccount();
          }
          long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          ((awmu)localObject3).mTraceId = (paramDittoArea + "_" + l);
          ((awmu)localObject3).eBX = 1;
          ((awmu)localObject3).mAppId = ((String)localObject1);
          ((awmu)localObject3).cNQ = ((String)localObject2);
          ((awmu)localObject3).cNR = paramString;
          ((awmu)localObject3).mActionId = 102;
          ((awmu)localObject3).eBB = 1;
          ((awmu)localObject3).aBn = l;
          awmt.a().a((awmu)localObject3);
          if (!paramMotionEvent.has("appId")) {
            break label493;
          }
          paramString = paramMotionEvent.optString("appId");
          paramDittoArea = paramMotionEvent.optString("refer");
          if (this.dittoInfo == null) {
            break label1272;
          }
          if (!"jump_app_store".equals(paramString)) {
            break;
          }
          if (this.activityWeakReference == null) {
            break label1272;
          }
          MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), this.dittoInfo.jumpMoreInfo, Integer.valueOf(paramDittoArea).intValue());
          return;
          paramString = paramString.optString("itemId");
          break label1269;
          paramString = paramString.optString("itemId");
        }
        if (this.dittoInfo.appInfoMap == null) {
          break label1264;
        }
        paramString = (MiniAppInfo)this.dittoInfo.appInfoMap.get(paramString);
        if ((paramString != null) || (!paramMotionEvent.has("position"))) {
          break label1261;
        }
        i = paramMotionEvent.getInt("position");
        paramString = (MiniAppInfo)this.dittoInfo.appInfoList.get(i);
        if ((paramString != null) && (this.activityWeakReference != null)) {
          MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), paramString, Integer.valueOf(paramDittoArea).intValue());
        }
        paramString = paramMotionEvent.optString("report");
        if ((!TextUtils.isEmpty(paramString)) && ("no".equals(paramString))) {
          break label1272;
        }
        MiniProgramLpReportDC04239.reportAsync("desktop", paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), paramMotionEvent.optString("reserves2"), paramMotionEvent.optString("reserves3"), paramMotionEvent.optString("reserves4"));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("DesktopDittoAreaView", 1, "handleUri, exception: " + Log.getStackTraceString(paramString));
        return;
      }
      label493:
      if (paramMotionEvent.has("scheme"))
      {
        paramString = paramMotionEvent.optString("scheme");
        paramDittoArea = paramMotionEvent.optString("refer");
        i = 3011;
        try
        {
          j = Integer.valueOf(paramDittoArea).intValue();
          i = j;
        }
        catch (NumberFormatException paramDittoArea)
        {
          for (;;)
          {
            QLog.e("DesktopDittoAreaView", 1, "handleUri, get scene failed: NumberFormatException: " + Log.getStackTraceString(paramDittoArea));
            continue;
            if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
            {
              paramDittoArea = new Intent((Context)this.activityWeakReference.get(), QQBrowserActivity.class);
              paramDittoArea.putExtra("url", paramString);
              paramDittoArea.putExtra("webStyle", "noBottomBar");
              paramDittoArea.putExtra("startOpenPageTime", System.currentTimeMillis());
              ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
            }
            else if (paramString.startsWith("mqqapi"))
            {
              paramDittoArea = new Intent((Context)this.activityWeakReference.get(), JumpActivity.class);
              paramDittoArea.setData(Uri.parse(paramString));
              ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
              continue;
              QLog.e("DesktopDittoAreaView", 1, "object.has(scheme), activityWeakReference.get() is null ?!");
            }
          }
        }
        if (this.activityWeakReference.get() != null) {
          if (MiniAppLauncher.isMiniAppUrl(paramString))
          {
            MiniAppLauncher.startMiniApp((Context)this.activityWeakReference.get(), paramString, i, null);
            MiniProgramLpReportDC04239.reportAsync(paramMotionEvent.optString("actionType"), paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), null);
            return;
          }
        }
      }
      if (paramMotionEvent.has("quickMatch"))
      {
        paramString = paramMotionEvent.optString("refer");
        j = this.dittoInfo.appInfoMap.size();
        if (j <= 0) {
          break label1273;
        }
        i = j;
        label825:
        i = this.dittoInfo.currentIndex % i;
        paramDittoArea = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(i);
        if (paramDittoArea != null)
        {
          QLog.d("DesktopDittoAreaView", 1, "handleUri, name: " + paramDittoArea.name + ", appId: " + paramDittoArea.appId + ", index: " + i + ", currentIndex: " + this.dittoInfo.currentIndex + ", size: " + j);
          MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), paramDittoArea, Integer.valueOf(paramString).intValue());
        }
        for (;;)
        {
          this.dittoInfo.incrementIndex();
          return;
          QLog.e("DesktopDittoAreaView", 1, "handleUri, index = " + i + ", currentIndex: " + this.dittoInfo.currentIndex + ", size: " + j + ", appInfo is null.");
        }
      }
      if (!paramMotionEvent.has("refresh")) {
        break label1272;
      }
      i = paramMotionEvent.optInt("refresh");
      paramString = (DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336);
      paramDittoArea = new ArrayList();
      paramDittoArea.add(Integer.valueOf(7));
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Integer.valueOf(i));
      localObject2 = new ArrayList();
      localObject3 = paramMotionEvent.optJSONArray("itemIds");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = ((JSONArray)localObject3).length();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject4 = ((JSONArray)localObject3).optString(i);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
      else
      {
        paramString.sendModuleRequest(paramDittoArea, (ArrayList)localObject1, (ArrayList)localObject2);
        MiniProgramLpReportDC04239.reportAsync(paramMotionEvent.optString("actionType"), paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), null);
        QLog.d("DesktopDittoAreaView", 1, "refresh, itemIds: " + ((ArrayList)localObject2).toString());
        return;
        QLog.e("DesktopDittoAreaView", 1, "handleUri, uri is null.");
        return;
        label1261:
        break label367;
        label1264:
        paramString = null;
        break label328;
        label1269:
        break;
        label1272:
        return;
        label1273:
        i = 1;
        break label825;
      }
      i += 1;
    }
  }
  
  public void setDittoData(DesktopDittoInfo paramDesktopDittoInfo)
  {
    this.dittoInfo = paramDesktopDittoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView
 * JD-Core Version:    0.7.0.1
 */