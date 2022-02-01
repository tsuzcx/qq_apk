package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import com.tencent.kwstudio.office.base.Global;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface;
import com.tencent.kwstudio.office.preview.IHostInterface.IPreferencesCallback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class Debugger
{
  private static final String CGI_RSP_IS_WHITE = "is_white_uin";
  private static final String CGI_RSP_RET_CODE = "retcode";
  private static final String CGI_URL_CONFIG_GET = "https://preview-report.docs.qq.com/online_docs_cgi/preview/config_get";
  private static final Map<String, List<IDebugger>> DEBUGGER_MAP = new HashMap();
  private static final String KEY_USER_ENABLE = "key_user_enable";
  private static final String KEY_WHITE_LIST = "key_white_list";
  private static final String TAG = "Debugger";
  private static volatile boolean sIsUserEnable = true;
  private static volatile boolean sIsWhiteList = true;
  
  static void active()
  {
    Noumenon.sHostInterface.queryPreferences(wrapKey("key_user_enable", "11"), true, false, new PreferencesCallbackImpl("key_user_enable"));
    Noumenon.sHostInterface.queryPreferences(wrapKey("key_white_list", "11"), true, true, new PreferencesCallbackImpl("key_white_list"));
  }
  
  public static void checkWhiteListFromRemote(String paramString)
  {
    Noumenon.sHostInterface.sendHttpRequest("https://preview-report.docs.qq.com/online_docs_cgi/preview/config_get", true, "", new Debugger.1(paramString));
  }
  
  public static void cleanCache(String paramString, IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new RunnableImpl(3, paramString, paramIDebugCallback, null));
  }
  
  public static void cleanPlugin(String paramString, IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new RunnableImpl(1, paramString, paramIDebugCallback, null));
  }
  
  private static IDebugger getDebugger(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (DEBUGGER_MAP)
      {
        paramString = (List)DEBUGGER_MAP.get(paramString);
        if (paramString == null) {
          break label68;
        }
        if (paramInt >= paramString.size())
        {
          break label68;
          return paramString;
        }
      }
      paramString = (IDebugger)paramString.get(paramInt);
      continue;
      label68:
      paramString = null;
    }
  }
  
  private static int getDebuggersSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (DEBUGGER_MAP)
      {
        paramString = (List)DEBUGGER_MAP.get(paramString);
        if (paramString == null)
        {
          i = 0;
          return i;
        }
      }
      int i = paramString.size();
    }
  }
  
  public static String getVersionInfo(String paramString)
  {
    if (TextUtils.equals(paramString, "11")) {
      return "PoLib-" + Noumenon.getLibVersion("1") + "\nPrLib-" + Noumenon.getLibVersion("11") + "\nDoLib-" + Noumenon.getLibVersion("12") + "\nShLib-" + Noumenon.getLibVersion("13") + "\nSlLib-" + Noumenon.getLibVersion("14") + "\nViLib-" + Noumenon.getLibVersion("15");
    }
    return "";
  }
  
  public static boolean isUserEnable(String paramString)
  {
    return sIsUserEnable;
  }
  
  public static void setDebugger(String paramString, int paramInt, IDebugger paramIDebugger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIDebugger == null)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (DEBUGGER_MAP)
      {
        localObject = (List)DEBUGGER_MAP.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          DEBUGGER_MAP.put(paramString, localObject);
          paramString = (String)localObject;
          int i = paramString.size();
          if (paramInt >= i) {
            if (i < paramInt + 1)
            {
              paramString.add(null);
              i += 1;
              continue;
            }
          }
          paramString.set(paramInt, paramIDebugger);
          return;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  private static void setInWhiteList(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("moduleId should be no-null.");
    }
    if (sIsWhiteList == paramBoolean) {
      return;
    }
    sIsWhiteList = paramBoolean;
    Noumenon.sHostInterface.commitPreferences(wrapKey("key_white_list", paramString), paramBoolean, true);
  }
  
  public static void setUserEnable(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("moduleId should be no-null.");
    }
    if (sIsUserEnable == paramBoolean) {
      return;
    }
    sIsUserEnable = paramBoolean;
    Noumenon.sHostInterface.commitPreferences(wrapKey("key_user_enable", paramString), paramBoolean, false);
  }
  
  public static boolean shouldDisable(String paramString)
  {
    if ((!sIsUserEnable) || (!sIsWhiteList)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.w("Debugger", "shouldDisable, userEnable=" + sIsUserEnable + ", whiteList=" + sIsWhiteList);
      }
      return bool;
    }
  }
  
  public static void upgradePlugin(String paramString, IDebugCallback paramIDebugCallback)
  {
    Global.getExecutor().execute(new RunnableImpl(2, paramString, paramIDebugCallback, null));
  }
  
  private static String wrapKey(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public static abstract interface IDebugCallback
  {
    public abstract void onCleanCache(String paramString, int paramInt);
    
    public abstract void onCleanPlugin(String paramString, int paramInt);
    
    public abstract void onUpgradePlugin(String paramString, int paramInt);
  }
  
  static final class PreferencesCallbackImpl
    implements IHostInterface.IPreferencesCallback
  {
    private final String mKey;
    
    public PreferencesCallbackImpl(String paramString)
    {
      this.mKey = paramString;
    }
    
    public void onResult(boolean paramBoolean)
    {
      if (TextUtils.equals(this.mKey, "key_user_enable")) {
        Debugger.access$202(paramBoolean);
      }
      while (!TextUtils.equals(this.mKey, "key_white_list")) {
        return;
      }
      Debugger.access$302(paramBoolean);
    }
  }
  
  static final class RunnableImpl
    implements Runnable
  {
    private static final int JOB_TYPE_CLEAN_CACHE = 3;
    private static final int JOB_TYPE_CLEAN_PLUGIN = 1;
    private static final int JOB_TYPE_UPGRADE_PLUGIN = 2;
    private final Debugger.IDebugCallback mCallback;
    private final int mJobType;
    private final String mModuleId;
    
    private RunnableImpl(int paramInt, String paramString, Debugger.IDebugCallback paramIDebugCallback)
    {
      this.mJobType = paramInt;
      this.mModuleId = paramString;
      this.mCallback = paramIDebugCallback;
    }
    
    public void run()
    {
      int i = -1;
      int n = Debugger.getDebuggersSize(this.mModuleId);
      if (n > 0)
      {
        int k = 0;
        int m = 1;
        if (k < n)
        {
          IDebugger localIDebugger = Debugger.getDebugger(this.mModuleId, k);
          i = m;
          if (localIDebugger != null) {
            switch (this.mJobType)
            {
            default: 
              i = m;
            }
          }
          for (;;)
          {
            k += 1;
            m = i;
            break;
            j = m & localIDebugger.discardPlugin(Noumenon.sHostInterface);
            continue;
            j = m & localIDebugger.upgradePlugin(Noumenon.sHostInterface);
            continue;
            j = m & localIDebugger.cleanCache(Noumenon.sHostInterface);
          }
        }
        if (m == 0) {
          break label177;
        }
      }
      label177:
      for (int j = 0;; j = 1)
      {
        if (this.mCallback != null) {}
        switch (this.mJobType)
        {
        default: 
          return;
        }
      }
      this.mCallback.onCleanPlugin(this.mModuleId, j);
      return;
      this.mCallback.onUpgradePlugin(this.mModuleId, j);
      return;
      this.mCallback.onCleanCache(this.mModuleId, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger
 * JD-Core Version:    0.7.0.1
 */