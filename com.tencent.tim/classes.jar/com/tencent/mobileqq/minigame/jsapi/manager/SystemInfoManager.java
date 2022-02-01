package com.tencent.mobileqq.minigame.jsapi.manager;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.View;
import aqgz;
import ayxa;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.utils.DeviceUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

public class SystemInfoManager
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  private static final String TAG = "SystemInfoManager";
  private Context mAppContext;
  private float mDensity;
  private IGameUI mIGameUI;
  private boolean mIsHideNotchSwitchOpen;
  private boolean mIsLandscape;
  private int mScreenHeightPixels;
  private int mScreenWidthPixels;
  private int mStatusBarHeight;
  private JSONObject mSystemInfo;
  
  public SystemInfoManager(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
    DisplayMetrics localDisplayMetrics = DisplayUtil.getDisplayMetrics(paramContext);
    this.mDensity = localDisplayMetrics.density;
    this.mScreenWidthPixels = localDisplayMetrics.widthPixels;
    this.mScreenHeightPixels = localDisplayMetrics.heightPixels;
    this.mStatusBarHeight = DisplayUtil.getStatusBarHeight(paramContext);
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
      if (Settings.Secure.getInt(paramContext.getContentResolver(), "display_notch_status", 0) != 1) {
        break label82;
      }
    }
    for (;;)
    {
      this.mIsHideNotchSwitchOpen = bool;
      return;
      label82:
      bool = false;
    }
  }
  
  private boolean isLandscape()
  {
    return this.mIsLandscape;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeightPixels;
  }
  
  public float getScreenWidth()
  {
    return this.mScreenWidthPixels;
  }
  
  public JSONObject getSystemInfo()
  {
    if (this.mSystemInfo != null) {
      return this.mSystemInfo;
    }
    JSONObject localJSONObject1 = new JSONObject();
    label582:
    label587:
    for (;;)
    {
      try
      {
        localJSONObject1.put("brand", Build.BRAND);
        localJSONObject1.put("model", Build.MODEL);
        if (isLandscape())
        {
          j = Math.min(this.mScreenWidthPixels, this.mScreenHeightPixels);
          i = Math.max(this.mScreenWidthPixels, this.mScreenHeightPixels);
          j = (int)(j / this.mDensity);
          int k = (int)(i / this.mDensity);
          localJSONObject1.put("pixelRatio", this.mDensity);
          localJSONObject1.put("devicePixelRatio", this.mDensity);
          int n = (int)(this.mStatusBarHeight / this.mDensity);
          i = k;
          if (isLandscape())
          {
            i = k;
            if (this.mIsHideNotchSwitchOpen) {
              i = k - n;
            }
          }
          if ((this.mIGameUI == null) || (this.mIGameUI.getGameView() == null)) {
            break label587;
          }
          k = (int)(this.mIGameUI.getGameView().getMeasuredWidth() / this.mDensity);
          int m = (int)(this.mIGameUI.getGameView().getMeasuredHeight() / this.mDensity);
          if ((k == 0) || (m == 0)) {
            break label587;
          }
          j = m;
          i = k;
          localJSONObject1.put("screenWidth", i);
          localJSONObject1.put("screenHeight", j);
          localJSONObject1.put("windowWidth", i);
          localJSONObject1.put("windowHeight", j);
          localJSONObject1.put("statusBarHeight", n);
          localJSONObject1.put("language", "zh_CN");
          localJSONObject1.put("system", "Android " + Build.VERSION.RELEASE);
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("fontSizeSetting", 16);
          localJSONObject1.put("benchmarkLevel", DeviceUtil.getDeviceBenchmarkLevel());
          localJSONObject1.put("version", aqgz.getQQVersion());
          localJSONObject1.put("AppPlatform", "qq");
          JSONObject localJSONObject2 = new JSONObject();
          j = DisplayUtil.dip2px(this.mAppContext, 9.0F);
          if ((!ayxa.isLiuHaiUseValid()) || (isLandscape())) {
            break label582;
          }
          i = this.mStatusBarHeight;
          localJSONObject2.put("marginTop", i + j);
          localJSONObject2.put("navbarHeight", DisplayUtil.dip2px(this.mAppContext, 30.0F));
          localJSONObject2.put("marginRight", DisplayUtil.dip2px(this.mAppContext, 12.5F));
          localJSONObject2.put("navbarWidth", DisplayUtil.dip2px(this.mAppContext, 80.0F));
          localJSONObject1.put("navbarPosition", localJSONObject2);
          this.mSystemInfo = localJSONObject1;
          GameLog.getInstance().i("SystemInfoManager", "getSystemInfo : " + this.mSystemInfo.toString());
          return localJSONObject1;
        }
      }
      catch (Exception localException)
      {
        GameLog.getInstance().e("SystemInfoManager", "getSystemInfo error " + localException.getMessage());
        return localJSONObject1;
      }
      int j = Math.max(this.mScreenWidthPixels, this.mScreenHeightPixels);
      int i = Math.min(this.mScreenWidthPixels, this.mScreenHeightPixels);
      continue;
      i = 0;
    }
  }
  
  public void setGameUI(IGameUI paramIGameUI)
  {
    this.mIGameUI = paramIGameUI;
  }
  
  public void setLandscape(boolean paramBoolean)
  {
    this.mIsLandscape = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.SystemInfoManager
 * JD-Core Version:    0.7.0.1
 */