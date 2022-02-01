package com.tencent.viola.core;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.module.Association;
import com.tencent.viola.module.BackAndroidModule;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.DeviceModule;
import com.tencent.viola.module.EventModule;
import com.tencent.viola.module.HttpModule;
import com.tencent.viola.module.IModuleHolder;
import com.tencent.viola.module.JSTimerModule;
import com.tencent.viola.module.ModuleSimpleHolder;
import com.tencent.viola.module.MonitorModule;
import com.tencent.viola.module.RouterModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.module.WebSocketModule;
import com.tencent.viola.ui.animation.AnimationModule;
import com.tencent.viola.ui.baseComponent.ComponentRegistry;
import com.tencent.viola.ui.baseComponent.ComponentSimpleHolder;
import com.tencent.viola.ui.baseComponent.IFComponentHolder;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.component.VAudio;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.component.VFooter;
import com.tencent.viola.ui.component.VFooterCell;
import com.tencent.viola.ui.component.VGif2;
import com.tencent.viola.ui.component.VHeaderView;
import com.tencent.viola.ui.component.VIndicateLoading;
import com.tencent.viola.ui.component.VInput;
import com.tencent.viola.ui.component.VKdRefresh;
import com.tencent.viola.ui.component.VLoading;
import com.tencent.viola.ui.component.VLottie;
import com.tencent.viola.ui.component.VModal;
import com.tencent.viola.ui.component.VPage;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.component.VScroller;
import com.tencent.viola.ui.component.VSeekBar;
import com.tencent.viola.ui.component.VSlider;
import com.tencent.viola.ui.component.VSmartHeader;
import com.tencent.viola.ui.component.VSmartLayout;
import com.tencent.viola.ui.component.VSwitch;
import com.tencent.viola.ui.component.VText;
import com.tencent.viola.ui.component.VTransform;
import com.tencent.viola.ui.component.image.VImage2;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.vinstance.VInstance;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ViolaSDKEngine
{
  public static final int SDK_INIT_OTHER_ERR = 999;
  public static final int SDK_MAIN_JS_ERROR = 102;
  public static final int SDK_MAIN_JS_HAS_INITED = 1;
  public static final int SDK_MAIN_JS_PATH_ERR = 100;
  public static final int SDK_MAIN_JS_SUCC = 0;
  public static final int SDK_REGISTER_COMPONET_ERR = 200;
  public static final int SDK_REGISTER_MODULE_ERR = 201;
  public static final int SDM_MAIN_JS_STRING_NULL = 101;
  private static final String TAG = "ViolaSDKEngine";
  public static volatile boolean baseRegisterInit = false;
  private static final Object mLock = new Object();
  
  private static void doInitInternal(Application paramApplication, InitConfig paramInitConfig, InitCallback paramInitCallback, String paramString)
  {
    ViolaEnvironment.sApplication = paramApplication;
    if (paramApplication == null)
    {
      if (paramInitCallback != null) {
        paramInitCallback.onFinish(999, 0L, " doInitInternal application is null");
      }
      ViolaLogUtils.e("ViolaSDKEngine", " doInitInternal application is null");
    }
    ViolaBridgeManager.getInstance().post(new ViolaSDKEngine.1(paramInitConfig, paramInitCallback, paramString));
  }
  
  public static void initialize(Application paramApplication, InitConfig paramInitConfig, @NonNull InitCallback paramInitCallback)
  {
    synchronized (mLock)
    {
      if (isInitialized()) {
        return;
      }
      doInitInternal(paramApplication, paramInitConfig, paramInitCallback, new JSONObject().toString());
      return;
    }
  }
  
  public static void initialize(Application paramApplication, InitConfig paramInitConfig, @NonNull InitCallback paramInitCallback, String paramString)
  {
    for (;;)
    {
      synchronized (mLock)
      {
        if (isInitialized()) {
          return;
        }
        if (TextUtils.isEmpty(paramString))
        {
          initialize(paramApplication, paramInitConfig, paramInitCallback, paramString);
          return;
        }
      }
      doInitInternal(paramApplication, paramInitConfig, paramInitCallback, paramString);
    }
  }
  
  public static boolean isInitialized()
  {
    for (;;)
    {
      synchronized (mLock)
      {
        if ((baseRegisterInit) && (ViolaBridgeManager.getInstance().isJSFrameworkInit()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static void registerBase()
  {
    try
    {
      registerComponent(VText.class, false, new String[] { "text" });
      registerComponent(VDiv.class, false, new String[] { "container", "div", "header", "footer", "cell" });
      registerComponent(VImage2.class, false, new String[] { "image", "img" });
      registerComponent(VScroller.class, false, new String[] { "scroller" });
      registerComponent(VSlider.class, false, new String[] { "slider", "cycleslider" });
      registerComponent(VRecyclerList.class, false, new String[] { "list" });
      registerComponent(VRefresh.class, false, new String[] { "refresh" });
      registerComponent(VCell.class, false, new String[] { "cell" });
      registerComponent(VInput.class, false, new String[] { "input", "textarea" });
      registerComponent(VSwitch.class, false, new String[] { "switch" });
      registerComponent(VFooter.class, false, new String[] { "footer-refresh" });
      registerComponent(VPageSlider.class, false, new String[] { "page-slider" });
      registerComponent(VPage.class, false, new String[] { "page" });
      registerComponent(VHeaderView.class, false, new String[] { "header-view" });
      registerComponent(VLoading.class, false, new String[] { "loading" });
      registerComponent(VIndicateLoading.class, false, new String[] { "indicate-loading" });
      registerComponent(VGif2.class, false, new String[] { "gif" });
      registerComponent(VModal.class, false, new String[] { "modal" });
      registerComponent(VAudio.class, false, new String[] { "audio" });
      registerComponent(VRecyclerList.class, false, new String[] { "waterfall-list" });
      registerComponent(VFooterCell.class, false, new String[] { "footer-cell" });
      registerComponent(VKdRefresh.class, false, new String[] { "kdrefresh" });
      registerComponent(VSmartHeader.class, false, new String[] { "smart-header" });
      registerComponent(VSmartLayout.class, false, new String[] { "smart-layout" });
      registerComponent(VSeekBar.class, false, new String[] { "seek-bar" });
      registerComponent(VTransform.class, false, new String[] { "transform" });
      registerComponent(VLottie.class, false, new String[] { "vlottie" });
      registerComponent(VInstance.class, false, new String[] { "instance" });
      registerModule("jsTimer", JSTimerModule.class, true);
      registerModule("http", HttpModule.class, true);
      registerModule("event", EventModule.class, true);
      registerModule("animation", AnimationModule.class, false);
      registerModule("webSocket", WebSocketModule.class, false);
      registerModule("association", Association.class, true);
      registerModule("monitor", MonitorModule.class, true);
      registerModule("device", DeviceModule.class, false);
      registerModule("backAndroid", BackAndroidModule.class, false);
      registerModule("router", RouterModule.class, false);
      baseRegisterInit = true;
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("ViolaSDKEngine", "[SDKEngine] register exception e:" + localException);
    }
  }
  
  public static boolean registerComponent(IFComponentHolder paramIFComponentHolder, boolean paramBoolean, String... paramVarArgs)
    throws Exception
  {
    int j = paramVarArgs.length;
    int i = 0;
    boolean bool = true;
    if (i < j)
    {
      String str = paramVarArgs[i];
      HashMap localHashMap = new HashMap();
      if (paramBoolean) {
        localHashMap.put("append", "tree");
      }
      if ((bool) && (ComponentRegistry.registerComponent(str, paramIFComponentHolder, localHashMap))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    return bool;
  }
  
  public static boolean registerComponent(Class<? extends VComponent> paramClass, boolean paramBoolean, String... paramVarArgs)
    throws Exception
  {
    if (paramClass == null) {
      return false;
    }
    return registerComponent(new ComponentSimpleHolder(paramClass), paramBoolean, paramVarArgs);
  }
  
  public static boolean registerModule(String paramString, IModuleHolder paramIModuleHolder, boolean paramBoolean)
    throws Exception
  {
    return ViolaModuleManager.registerModule(paramString, paramIModuleHolder, paramBoolean);
  }
  
  public static <T extends BaseModule> boolean registerModule(String paramString, Class<T> paramClass, boolean paramBoolean)
    throws Exception
  {
    return (paramClass != null) && (registerModule(paramString, new ModuleSimpleHolder(paramClass), paramBoolean));
  }
  
  public static abstract interface InitCallback
  {
    public abstract void onFinish(int paramInt, long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaSDKEngine
 * JD-Core Version:    0.7.0.1
 */