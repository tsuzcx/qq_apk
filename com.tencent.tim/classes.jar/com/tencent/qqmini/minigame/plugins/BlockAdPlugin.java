package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class BlockAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CodeMsgMap;
  public static final String API_AD_CREATE_BLOCK_AD = "createBlockAd";
  public static final String API_AD_OPERATE_BLOCK_AD = "operateBlockAd";
  public static final String API_AD_UPDATE_BLOCK_AD = "updateBlockAdSize";
  public static final String EVENT_BLOCK_AD_SHOW_DONE = "onBlockAdShowDone";
  public static final String EVENT_BLOCK_AD_STATE_CHANGE = "onBlockAdStateChange";
  private static final String ORIENTATION_LANDSCAPE = "landscape";
  private static final String ORIENTATION_VERTICAL = "vertical";
  private static final String TAG = "BlockAdPlugin";
  private HashMap<Integer, BlockAdInfo> mBlockAdInfoMap = new HashMap();
  private HashMap<Integer, AdProxy.AbsBlockAdView> mBlockAdViewMap = new HashMap();
  private float mGameDensity = -1.0F;
  
  private void blockErrorStateCallbackDelay(RequestEvent paramRequestEvent, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.7(this, paramInt2, paramString, paramInt1, paramRequestEvent), paramInt3);
  }
  
  private void destroyBlockAd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          return;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          continue;
        }
        localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
      }
      finally {}
      ViewGroup localViewGroup;
      if (localViewGroup == null)
      {
        QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
      }
      else
      {
        localViewGroup.removeView(((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView());
        this.mBlockAdInfoMap.remove(Integer.valueOf(paramInt));
        this.mBlockAdViewMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(this.mGameDensity * paramFloat);
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private BlockAdInfo parseBlockAdInfoFromJson(String paramString)
  {
    int n = -1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        int m;
        int k;
        int j;
        int i;
        label96:
        Object localObject1;
        try
        {
          localObject2 = new JSONObject(paramString);
          str1 = ((JSONObject)localObject2).getString("adUnitId");
        }
        catch (Exception localException1)
        {
          String str1;
          String str2;
          boolean bool;
          int i1;
          j = -1;
          k = -1;
          i = -1;
          localObject2 = "";
          m = -1;
          QMLog.i("BlockAdPlugin", "parseBannerAdPosInfoFromJson error " + paramString, localException1);
          localObject1 = localObject2;
          continue;
        }
        try
        {
          m = ((JSONObject)localObject2).getJSONObject("style").getInt("left");
        }
        catch (Exception localException2)
        {
          j = -1;
          k = -1;
          i = -1;
          m = -1;
          localObject2 = localObject1;
          localObject1 = localException2;
          continue;
        }
        try
        {
          k = ((JSONObject)localObject2).getJSONObject("style").getInt("top");
        }
        catch (Exception localException3)
        {
          j = -1;
          i = -1;
          k = -1;
          localObject2 = localObject1;
          localObject1 = localException3;
          continue;
        }
        try
        {
          j = ((JSONObject)localObject2).optInt("size", 1);
        }
        catch (Exception localException4)
        {
          i = -1;
          j = -1;
          localObject2 = localObject1;
          localObject1 = localException4;
          continue;
        }
        for (;;)
        {
          try
          {
            str2 = ((JSONObject)localObject2).optString("orientation", "landscape");
            bool = "landscape".equals(str2);
            if (bool) {
              i = 90;
            }
          }
          catch (Exception localException5)
          {
            i = -1;
            localObject2 = localObject1;
            localObject1 = localException5;
            break label189;
            break label96;
          }
          try
          {
            i1 = ((JSONObject)localObject2).getInt("compId");
            n = i1;
            if ((TextUtils.isEmpty(str1)) || (m < 0) || (k < 0) || (n < 0) || (i < 0)) {
              break;
            }
            return new BlockAdInfo(str1, m, k, j, i, n);
          }
          catch (Exception localException6)
          {
            localObject2 = localObject1;
            localObject1 = localException6;
            break label189;
            i = -1;
          }
        }
      }
      bool = "vertical".equals(str2);
      if (!bool) {
        break label311;
      }
      i = 0;
    }
  }
  
  private void reportBlockAd(String paramString)
  {
    QMLog.i("BlockAdPlugin", "reportBlockAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new BlockAdPlugin.6(this, paramString));
  }
  
  private boolean showBlockAd(int paramInt)
  {
    for (;;)
    {
      View localView;
      ViewGroup localViewGroup;
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          bool = false;
          return bool;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          bool = false;
          continue;
        }
        Object localObject1 = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
        localView = ((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView();
        if (localView == null)
        {
          bool = false;
          continue;
        }
        localView.setVisibility(0);
        if (localView.getParent() != null)
        {
          bool = true;
          continue;
        }
        localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
        if ((localViewGroup instanceof FrameLayout))
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).leftMargin = gameDpTopx(((BlockAdInfo)localObject1).getLeft());
          ((FrameLayout.LayoutParams)localObject3).topMargin = gameDpTopx(((BlockAdInfo)localObject1).getTop());
          localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject3);
          localObject1 = ((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getReportUrl();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label355;
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label355;
          }
          reportBlockAd((String)((Iterator)localObject1).next());
          continue;
        }
        if (!(localViewGroup instanceof RelativeLayout)) {
          continue;
        }
      }
      finally {}
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = gameDpTopx(localObject2.getLeft());
      ((RelativeLayout.LayoutParams)localObject3).topMargin = gameDpTopx(localObject2.getTop());
      localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject3);
      continue;
      label355:
      boolean bool = true;
    }
  }
  
  private boolean updateBlockAd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          bool = false;
          return bool;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          bool = false;
          continue;
        }
        if ((ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView() == null)
        {
          QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
          bool = false;
          continue;
        }
        BlockAdInfo localBlockAdInfo = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
        if (localBlockAdInfo == null)
        {
          bool = false;
          continue;
        }
        View localView = ((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).updateAdInfo(localBlockAdInfo.getLeft(), localBlockAdInfo.getTop());
        if (localView == null)
        {
          bool = false;
          continue;
        }
        Object localObject2;
        if ((localView.getLayoutParams() instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
          ((FrameLayout.LayoutParams)localObject2).topMargin = gameDpTopx(localBlockAdInfo.getTop());
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        else if ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          localObject2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
          ((RelativeLayout.LayoutParams)localObject2).topMargin = gameDpTopx(localBlockAdInfo.getTop());
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  @JsEvent({"createBlockAd"})
  public String createBlockAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive createBlockAd event");
    if (paramRequestEvent == null)
    {
      QMLog.i("BlockAdPlugin", "handle createBlockAd event, req == null");
      return "";
    }
    int i = -1;
    try
    {
      int j = new JSONObject(paramRequestEvent.jsonParams).getInt("compId");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.i("BlockAdPlugin", "handle createBlockAd,", localJSONException);
      }
      localObject3 = this.mMiniAppInfo;
      if (localObject3 == null) {
        break label419;
      }
    }
    BlockAdInfo localBlockAdInfo = parseBlockAdInfoFromJson(paramRequestEvent.jsonParams);
    if (localBlockAdInfo == null)
    {
      blockErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), i, 300);
      return "";
    }
    Object localObject3;
    String str1;
    label162:
    String str2;
    Object localObject2;
    if (((MiniAppInfo)localObject3).launchParam != null) {
      if (((MiniAppInfo)localObject3).launchParam.entryPath != null)
      {
        localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
        if (((MiniAppInfo)localObject3).launchParam == null) {
          break label400;
        }
        str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
        str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
        localObject2 = localObject1;
      }
    }
    for (Object localObject1 = str2;; localObject1 = "")
    {
      label203:
      Object localObject4;
      String str3;
      Bundle localBundle;
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        localObject3 = this.mApkgInfo.appId;
        i = 1;
        localObject4 = this.mMiniAppContext.getAttachedActivity();
        if (localObject4 != null)
        {
          i = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation;
          initActivitySize((Activity)localObject4);
        }
        str3 = LoginManager.getInstance().getAccount();
        localObject4 = AdUtil.getSpAdGdtCookie(13);
        localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, 13);
        str3 = AdProxy.KEY_ORIENTATION;
        if (i != 2) {
          break label414;
        }
      }
      label400:
      label414:
      for (i = 90;; i = 0)
      {
        localBundle.putInt(str3, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, (String)localObject4);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.1(this, localBlockAdInfo, (String)localObject3, paramRequestEvent, localBundle));
        return "";
        localObject1 = "";
        break;
        str1 = "";
        break label162;
        str2 = "";
        break label203;
      }
      label419:
      str1 = "";
      localObject2 = "";
    }
  }
  
  /* Error */
  public boolean hideBlockAd(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   13: iload_1
    //   14: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +23 -> 43
    //   23: aload_0
    //   24: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   27: iload_1
    //   28: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 124	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView
    //   37: invokevirtual 128	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView:getView	()Landroid/view/View;
    //   40: ifnonnull +16 -> 56
    //   43: ldc 33
    //   45: ldc 130
    //   47: invokestatic 136	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 59	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdInfoMap	Ljava/util/HashMap;
    //   60: ifnull +17 -> 77
    //   63: aload_0
    //   64: getfield 59	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdInfoMap	Ljava/util/HashMap;
    //   67: iload_1
    //   68: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: ifnonnull +15 -> 89
    //   77: ldc 33
    //   79: ldc 138
    //   81: invokestatic 136	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -34 -> 52
    //   89: aload_0
    //   90: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   93: iload_1
    //   94: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 124	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView
    //   103: invokevirtual 128	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView:getView	()Landroid/view/View;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnonnull +8 -> 116
    //   111: iconst_0
    //   112: istore_2
    //   113: goto -61 -> 52
    //   116: aload_3
    //   117: bipush 8
    //   119: invokevirtual 292	android/view/View:setVisibility	(I)V
    //   122: iconst_1
    //   123: istore_2
    //   124: goto -72 -> 52
    //   127: astore_3
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_3
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	BlockAdPlugin
    //   0	132	1	paramInt	int
    //   51	73	2	bool	boolean
    //   106	11	3	localView	View
    //   127	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	127	finally
    //   43	50	127	finally
    //   56	77	127	finally
    //   77	84	127	finally
    //   89	107	127	finally
    //   116	122	127	finally
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if (this.mGameDensity > 0.0F) {}
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      this.mGameDensity = localDisplayMetrics.density;
      QMLog.i("BlockAdPlugin", "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity());
    } while (this.mGameDensity != -1.0F);
    this.mGameDensity = ViewUtils.getDensity();
  }
  
  @JsEvent({"operateBlockAd"})
  public String operateBlockAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive operateBlockAd event");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.getString("type");
      i = localJSONObject.getInt("compId");
      QMLog.i("BlockAdPlugin", "handle operateBlockAd type = " + str);
      if ("show".equals(str)) {
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.2(this, i, paramRequestEvent), 300L);
      }
      for (;;)
      {
        return "";
        if (!"hide".equals(str)) {
          break;
        }
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.3(this, i), 300L);
      }
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        String str;
        int i;
        QMLog.i("BlockAdPlugin", "handle operateBlockAd parse json error", paramRequestEvent);
        continue;
        if ("destroy".equals(str)) {
          AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.4(this, i), 300L);
        } else {
          QMLog.i("BlockAdPlugin", "handle operateBlockAd not define type = " + str);
        }
      }
    }
  }
  
  @JsEvent({"updateBlockAdSize"})
  public String updateBlockAdSize(RequestEvent paramRequestEvent)
  {
    int m = 1;
    int n = 1;
    int k = 1;
    QMLog.i("BlockAdPlugin", "receive updateBlockAdSize event");
    Object localObject;
    int i1;
    int i;
    int j;
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        i1 = ((JSONObject)localObject).getInt("compId");
        if (((JSONObject)localObject).has("left"))
        {
          i = ((JSONObject)localObject).getInt("left");
          j = 1;
          if (j == -1) {
            break label195;
          }
          localObject = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(i1));
          if (localObject == null) {
            break label195;
          }
        }
        switch (j)
        {
        case 1: 
          label108:
          if (j != 0) {
            break label237;
          }
          if (!QMLog.isColorLevel()) {
            break label270;
          }
          QMLog.i("BlockAdPlugin", "updateBlockAd no need to resize");
          break label270;
          if (!((JSONObject)localObject).has("top")) {
            break label257;
          }
          i = ((JSONObject)localObject).getInt("top");
          j = 2;
          continue;
          if (((BlockAdInfo)localObject).getLeft() != i)
          {
            k = m;
            j = k;
            if (k == 0) {
              continue;
            }
            ((BlockAdInfo)localObject).setLeft(i);
            j = k;
            continue;
            return "";
          }
          break;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.i("BlockAdPlugin", "handle updateBlockAdSize parse json error", paramRequestEvent);
      }
      label195:
      k = 0;
    }
    if (((BlockAdInfo)localObject).getTop() != i) {}
    for (k = n;; k = 0)
    {
      j = k;
      if (k == 0) {
        break label108;
      }
      ((BlockAdInfo)localObject).setTop(i);
      j = k;
      break label108;
      label237:
      AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.5(this, i1, (BlockAdInfo)localObject, paramRequestEvent), 0L);
      break label195;
      label257:
      i = -1;
      j = -1;
      break;
      j = k;
      break label108;
      label270:
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin
 * JD-Core Version:    0.7.0.1
 */