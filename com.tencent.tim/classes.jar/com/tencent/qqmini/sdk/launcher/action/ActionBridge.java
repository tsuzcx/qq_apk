package com.tencent.qqmini.sdk.launcher.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ActionBridge<T>
  implements Action
{
  public static final Map<String, String> ACTION_CLASS = new HashMap();
  private static final String TAG = "ActionBridge";
  private Action<T> realAction;
  
  static
  {
    ACTION_CLASS.put("ShareAction", "com.tencent.qqmini.sdk.action.ShareAction");
    ACTION_CLASS.put("UpdateUIAction", "com.tencent.qqmini.sdk.action.UpdateUIAction");
    ACTION_CLASS.put("PageAction", "com.tencent.qqmini.sdk.action.PageAction");
    ACTION_CLASS.put("RestartAction", "com.tencent.qqmini.sdk.action.RestartAction");
    ACTION_CLASS.put("GetShareState", "com.tencent.qqmini.sdk.action.GetShareState");
    ACTION_CLASS.put("GetLastClickAction", "com.tencent.qqmini.minigame.action.GetLastClickAction");
  }
  
  public static Action obtain(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    try
    {
      localObject = (String)ACTION_CLASS.get(paramString);
      localAction2 = (Action)MiniAppDexLoader.g().create((String)localObject);
    }
    catch (Throwable paramMap)
    {
      Object localObject;
      Action localAction2;
      label55:
      QMLog.e("ActionBridge", "obtain action exception! actionName=" + paramString, paramMap);
      Action localAction1 = null;
      return localAction1;
    }
    try
    {
      localObject = localAction2.getClass().getDeclaredField("what");
      if (localObject != null)
      {
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(localAction2, Integer.valueOf(paramInt));
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
      break label55;
    }
    localObject = localAction2;
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        localObject = localAction2;
        if (!paramMap.hasNext()) {
          break;
        }
        localObject = (Map.Entry)paramMap.next();
        QMLog.i("ActionBridge", "set action field:" + (String)((Map.Entry)localObject).getKey() + " valud:" + ((Map.Entry)localObject).getValue());
        try
        {
          Field localField = localAction2.getClass().getDeclaredField((String)((Map.Entry)localObject).getKey());
          if (localField != null)
          {
            localField.setAccessible(true);
            localField.set(localAction2, ((Map.Entry)localObject).getValue());
          }
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("ActionBridge", "getField exception! actionName=" + paramString, localThrowable1);
        }
      }
    }
  }
  
  public T perform(BaseRuntime paramBaseRuntime)
  {
    if (this.realAction != null) {
      return this.realAction.perform(paramBaseRuntime);
    }
    return null;
  }
  
  public void setRealAction(Action<T> paramAction)
  {
    this.realAction = paramAction;
  }
  
  public static class GetLastClicksActionBridge
    extends ActionBridge<String>
  {
    public static GetLastClicksActionBridge obtain()
    {
      GetLastClicksActionBridge localGetLastClicksActionBridge = new GetLastClicksActionBridge();
      localGetLastClicksActionBridge.setRealAction(obtain("GetLastClickAction", 0, null));
      return localGetLastClicksActionBridge;
    }
  }
  
  public static class GetShareStateActionBridge
    extends ActionBridge<ShareState>
  {
    public static GetShareStateActionBridge obtain()
    {
      GetShareStateActionBridge localGetShareStateActionBridge = new GetShareStateActionBridge();
      localGetShareStateActionBridge.setRealAction(obtain("GetShareState", 0, null));
      return localGetShareStateActionBridge;
    }
    
    public ShareState perform(BaseRuntime paramBaseRuntime)
    {
      return (ShareState)super.perform(paramBaseRuntime);
    }
  }
  
  public static class PageActionBridge
    extends ActionBridge<AppPageInfo>
  {
    public static String getPageUrl(IMiniAppContext paramIMiniAppContext)
    {
      paramIMiniAppContext = (AppPageInfo)paramIMiniAppContext.performAction(obtain(1));
      if (paramIMiniAppContext != null) {
        return paramIMiniAppContext.pageUrl;
      }
      return null;
    }
    
    public static PageActionBridge obtain(int paramInt)
    {
      PageActionBridge localPageActionBridge = new PageActionBridge();
      HashMap localHashMap = new HashMap();
      localHashMap.put("flag", Integer.valueOf(paramInt));
      localPageActionBridge.setRealAction(obtain("PageAction", 0, localHashMap));
      return localPageActionBridge;
    }
  }
  
  public static class RestartActionBridge
    extends ActionBridge<Boolean>
  {
    public static RestartActionBridge obtain()
    {
      RestartActionBridge localRestartActionBridge = new RestartActionBridge();
      localRestartActionBridge.setRealAction(obtain("RestartAction", 0, null));
      return localRestartActionBridge;
    }
  }
  
  public static class ShareActionBridge
    extends ActionBridge<Boolean>
  {
    public static final int SHARE_OTHER = 6;
    public static final int SHARE_QQ = 1;
    public static final int SHARE_QQ_CHAT = 5;
    public static final int SHARE_QZONE = 2;
    public static final int SHARE_WX_FRIEND = 3;
    public static final int SHARE_WX_MOMENT = 4;
    
    public static ShareActionBridge obtain(int paramInt, Bundle paramBundle)
    {
      HashMap localHashMap = null;
      if (paramBundle != null)
      {
        localHashMap = new HashMap();
        localHashMap.put("data", paramBundle);
      }
      paramBundle = new ShareActionBridge();
      paramBundle.setRealAction(obtain("ShareAction", paramInt, localHashMap));
      return paramBundle;
    }
  }
  
  public static class UpdateUIActionBridge
    extends ActionBridge<Boolean>
  {
    public static final int TOGGLE_DEBUG_PANEL = 2;
    public static final int TOGGLE_MONITOR_PANEL = 1;
    public static final int UPDATE_RED_DOT = 3;
    
    public static UpdateUIActionBridge obtain(int paramInt)
    {
      UpdateUIActionBridge localUpdateUIActionBridge = new UpdateUIActionBridge();
      localUpdateUIActionBridge.setRealAction(obtain("UpdateUIAction", paramInt, null));
      return localUpdateUIActionBridge;
    }
    
    public static Boolean toggleDebugPanel(IMiniAppContext paramIMiniAppContext)
    {
      return (Boolean)paramIMiniAppContext.performAction(obtain(2));
    }
    
    public static Boolean toggleMonitorPanel(IMiniAppContext paramIMiniAppContext)
    {
      return (Boolean)paramIMiniAppContext.performAction(obtain(1));
    }
    
    public static Boolean updateRedDot(IMiniAppContext paramIMiniAppContext)
    {
      return (Boolean)paramIMiniAppContext.performAction(obtain(3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge
 * JD-Core Version:    0.7.0.1
 */