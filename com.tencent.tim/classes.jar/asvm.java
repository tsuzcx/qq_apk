import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.1;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.2;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class asvm
  extends QIPCModule
{
  private asvm(String paramString)
  {
    super(paramString);
  }
  
  private void Vh(boolean paramBoolean)
  {
    Object localObject1 = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
    if (localObject1 == null) {}
    BaseRuntime localBaseRuntime;
    ShareState localShareState;
    Object localObject2;
    for (;;)
    {
      return;
      localBaseRuntime = ((BaseRuntimeLoader)localObject1).getRuntime();
      if (localBaseRuntime != null) {
        try
        {
          localObject1 = localBaseRuntime.getJsService();
          if (localObject1 != null)
          {
            localShareState = localBaseRuntime.getShareState();
            if (localShareState != null) {
              if (paramBoolean)
              {
                localObject3 = ApiUtil.wrapCallbackOk(localShareState.shareEvent, null);
                if (localObject3 != null)
                {
                  localObject3 = ((JSONObject)localObject3).toString();
                  ((IJsService)localObject1).evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject3);
                  ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.1(this, localBaseRuntime));
                  return;
                }
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject2 = null;
            continue;
            localObject3 = "";
          }
          localObject3 = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
          if (localObject3 == null) {}
        }
      }
    }
    for (Object localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      localObject2.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject3);
      ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.2(this, localBaseRuntime));
      return;
    }
  }
  
  public static asvm a()
  {
    return asvm.a.b();
  }
  
  private void a(IJsService paramIJsService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramString4, new asvn(this, paramString1, paramIJsService, paramInt3));
  }
  
  private void dW(Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("param_proc_badge_count");
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniSDKClientQIPCModule", "count is " + i);
      }
      paramBundle = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
      if (paramBundle != null) {}
    }
    else
    {
      return;
    }
    paramBundle = paramBundle.getRuntime();
    if ((paramBundle == null) || (paramBundle.getPage() == null))
    {
      QMLog.w("MiniSDKClientQIPCModule", "runtime or page is null");
      return;
    }
    paramBundle = paramBundle.getPage().getCapsuleButton();
    if (paramBundle == null)
    {
      QMLog.w("MiniSDKClientQIPCModule", "capsule button is null");
      return;
    }
    QMLog.i("MiniSDKClientQIPCModule", BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + i);
    paramBundle.setUnReadCount(i, true);
  }
  
  private void onShareUpdatableMsgCallback(Bundle paramBundle)
  {
    int i = 0;
    Object localObject1 = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
    if (localObject1 == null) {}
    label42:
    do
    {
      Object localObject2;
      do
      {
        return;
        localObject2 = ((BaseRuntimeLoader)localObject1).getRuntime();
      } while (localObject2 == null);
      localObject1 = null;
      try
      {
        localObject2 = ((BaseRuntime)localObject2).getJsService();
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable2)
      {
        boolean bool;
        String str1;
        String str2;
        int j;
        int k;
        int m;
        break label42;
      }
    } while (localObject1 == null);
    bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
    localObject2 = paramBundle.getString("miniAppShareEvent");
    str1 = paramBundle.getString("miniAppShareAppid");
    str2 = paramBundle.getString("miniAppShareTemplateId");
    j = paramBundle.getInt("miniAppShareCallbackId");
    k = paramBundle.getInt("miniAppShareAppType");
    if (bool)
    {
      m = paramBundle.getInt("uintype");
      if (m == 1) {}
      for (;;)
      {
        paramBundle = paramBundle.getString("uin");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
          localStringBuilder.append(", appid:").append(str1).append(", templateId:").append(str2).append(", from:").append(k).append(", scene:").append(i).append(", uin:").append(paramBundle);
          QLog.i("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
        }
        a((IJsService)localObject1, (String)localObject2, str1, str2, k, i, paramBundle, j);
        return;
        if (m == 0) {
          i = 1;
        }
      }
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("retCode", 1);
      paramBundle.put("errMsg", "用户取消");
      ((IJsService)localObject1).evaluateCallbackJs(j, paramBundle.toString());
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localThrowable1.printStackTrace();
      }
    }
  }
  
  public static void registerModule()
  {
    asvm localasvm = a();
    try
    {
      QMLog.i("MiniSDKClientQIPCModule", "register " + localasvm);
      QIPCClientHelper.getInstance().register(localasvm);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "register ipc module error.", localException);
    }
  }
  
  public static void unRegisterModule()
  {
    QMLog.i("MiniSDKClientQIPCModule", "unregister");
    QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniSDKClientQIPCModule", 2, "onCall main server action=" + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString)) {
      dW(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("actionMiniShareSucCallback".equals(paramString)) {
        Vh(true);
      } else if ("actionMiniShareFailCallback".equals(paramString)) {
        Vh(false);
      } else if ((!"actionMiniDirectShareSucCallback".equals(paramString)) && (!"actionMiniDirectShareFailCallback".equals(paramString)) && (!"actionMiniReportEvent".equals(paramString)) && ("actionMiniCreateUpdatableMsgCallback".equals(paramString))) {
        onShareUpdatableMsgCallback(paramBundle);
      }
    }
  }
  
  static class a
  {
    private static asvm a = new asvm("mini_sdk_client_module", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvm
 * JD-Core Version:    0.7.0.1
 */