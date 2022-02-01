import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class tfi
  implements AdIPCManager.Adapter
{
  private Map<String, AdIPCManager.Handler> map = new HashMap();
  
  public AdIPCManager.Handler getHandler(String paramString)
  {
    return (AdIPCManager.Handler)this.map.get(paramString);
  }
  
  public void init(Context paramContext)
  {
    tkw.i("GdtIPCAdapter", "init");
    QIPCClientHelper.getInstance().register(tfi.c.a());
  }
  
  public boolean register(String paramString, AdIPCManager.Handler paramHandler)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtIPCAdapter", String.format("register action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return bool;
      if (paramHandler == null)
      {
        bool = false;
      }
      else if (this.map.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.map.put(paramString, paramHandler);
        bool = true;
      }
    }
  }
  
  public AdIPCManager.Result send(Context paramContext, AdIPCManager.Params paramParams)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramParams != null)
    {
      localObject1 = paramParams.getAction();
      if (paramParams == null) {
        break label107;
      }
    }
    AdIPCManager.Handler localHandler;
    label107:
    for (String str = paramParams.getToProcessName();; str = null)
    {
      localHandler = getHandler((String)localObject1);
      paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
      if ((Looper.myLooper() != Looper.getMainLooper()) && (!TextUtils.isEmpty(paramContext)) && (localHandler != null) && (paramParams != null) && (paramParams.isValid())) {
        break label113;
      }
      tkw.e("GdtIPCAdapter", String.format("send error actionad:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
      return null;
      localObject1 = null;
      break;
    }
    label113:
    tkw.i("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
    if (TextUtils.equals(paramContext, str)) {
      return localHandler.handle(paramParams);
    }
    if (TextUtils.equals(AdProcessManager.INSTANCE.getMainProcessName(), str))
    {
      localObject1 = QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_sync_module_client_to_server", (String)localObject1, paramParams.bundle);
      paramParams = new AdIPCManager.Result();
      if ((localObject1 != null) && (((EIPCResult)localObject1).isSuccess())) {}
      for (boolean bool = true;; bool = false)
      {
        paramParams.success = bool;
        paramContext = localObject2;
        if (localObject1 != null) {
          paramContext = ((EIPCResult)localObject1).data;
        }
        paramParams.bundle = paramContext;
        return paramParams;
      }
    }
    tkw.e("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", new Object[] { localObject1, paramContext, str }));
    return null;
  }
  
  public void send(Context paramContext, AdIPCManager.Params paramParams, WeakReference<AdIPCManager.Callback> paramWeakReference)
  {
    String str2 = null;
    String str1;
    AdIPCManager.Handler localHandler;
    if (paramParams != null)
    {
      str1 = paramParams.getAction();
      if (paramParams != null) {
        str2 = paramParams.getToProcessName();
      }
      localHandler = getHandler(str1);
      paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
      if ((!TextUtils.isEmpty(paramContext)) && (localHandler != null) && (paramParams != null) && (paramParams.isValid())) {
        break label97;
      }
      tkw.e("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
    }
    label97:
    do
    {
      return;
      str1 = null;
      break;
      tkw.i("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
      if (!TextUtils.equals(paramContext, str2)) {
        break label169;
      }
      paramContext = localHandler.handle(paramParams);
    } while ((paramWeakReference == null) || (paramWeakReference.get() == null));
    ((AdIPCManager.Callback)paramWeakReference.get()).onCallback(paramParams, paramContext);
    return;
    label169:
    if (TextUtils.equals(AdProcessManager.INSTANCE.getMainProcessName(), str2))
    {
      QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", str1, paramParams.bundle, new tfj(this, paramWeakReference, paramParams));
      return;
    }
    QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", str1, paramParams.bundle, new tfk(this, paramWeakReference, paramParams));
  }
  
  public static final class a
    extends QIPCModule
  {
    private static volatile a a;
    
    private a(String paramString)
    {
      super();
    }
    
    public static a a()
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new a("gdt_ipc_async_module_client_to_server");
        }
        return a;
      }
      finally {}
    }
    
    public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
    {
      if (paramEIPCResult != null) {}
      for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
      {
        tkw.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
        super.callbackResult(paramInt, paramEIPCResult);
        return;
      }
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
      String str1;
      String str2;
      if (localParams != null)
      {
        str1 = localParams.getAction();
        if (localParams == null) {
          break label73;
        }
        str2 = localParams.getToProcessName();
        label34:
        tkw.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCall action:%s to:%s", new Object[] { str1, str2 }));
        if (!TextUtils.isEmpty(paramString)) {
          break label79;
        }
      }
      label73:
      label79:
      do
      {
        do
        {
          return null;
          str1 = null;
          break;
          str2 = null;
          break label34;
        } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)));
        str1 = AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext());
        paramString = AdIPCManager.INSTANCE.getHandler(paramString);
        if (!TextUtils.equals(str1, localParams.getToProcessName())) {
          break label206;
        }
      } while (paramString == null);
      paramString = paramString.handle(localParams);
      paramBundle = new EIPCResult();
      int i;
      if ((paramString != null) && (paramString.success))
      {
        i = 0;
        paramBundle.code = i;
        if (paramString == null) {
          break label201;
        }
      }
      label201:
      for (paramString = paramString.bundle;; paramString = null)
      {
        paramBundle.data = paramString;
        callbackResult(paramInt, paramBundle);
        return null;
        i = -102;
        break;
      }
      label206:
      QIPCServerHelper.getInstance().callClient(localParams.getToProcessName(), "gdt_ipc_module_server_to_client", localParams.getAction(), paramBundle, new tfl(this, localParams, paramInt));
      return null;
    }
  }
  
  public static final class b
    extends QIPCModule
  {
    private static volatile b a;
    
    private b(String paramString)
    {
      super();
    }
    
    public static b a()
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new b("gdt_ipc_sync_module_client_to_server");
        }
        return a;
      }
      finally {}
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      Object localObject2 = null;
      AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
      if (localParams != null)
      {
        paramBundle = localParams.getAction();
        if (localParams == null) {
          break label73;
        }
        localObject1 = localParams.getToProcessName();
        label36:
        tkw.i("GdtIPCAdapter", String.format("ClientToServerIPCSyncModule.onCall action:%s to:%s", new Object[] { paramBundle, localObject1 }));
        if (!TextUtils.isEmpty(paramString)) {
          break label79;
        }
      }
      label73:
      label79:
      do
      {
        do
        {
          return null;
          paramBundle = null;
          break;
          localObject1 = null;
          break label36;
        } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)) || (!AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localParams.getToProcessName())));
        paramString = AdIPCManager.INSTANCE.getHandler(paramString);
      } while (paramString == null);
      Object localObject1 = paramString.handle(localParams);
      paramBundle = new EIPCResult();
      if ((localObject1 != null) && (((AdIPCManager.Result)localObject1).success)) {}
      for (paramInt = 0;; paramInt = -102)
      {
        paramBundle.code = paramInt;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = ((AdIPCManager.Result)localObject1).bundle;
        }
        paramBundle.data = paramString;
        return paramBundle;
      }
    }
  }
  
  static final class c
    extends QIPCModule
  {
    private static volatile c a;
    
    private c(String paramString)
    {
      super();
    }
    
    public static c a()
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new c("gdt_ipc_module_server_to_client");
        }
        return a;
      }
      finally {}
    }
    
    public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
    {
      if (paramEIPCResult != null) {}
      for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
      {
        tkw.i("GdtIPCAdapter", String.format("ServerToClientIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
        super.callbackResult(paramInt, paramEIPCResult);
        return;
      }
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
      String str;
      if (localParams != null)
      {
        paramBundle = localParams.getAction();
        if (localParams == null) {
          break label70;
        }
        str = localParams.getToProcessName();
        label33:
        tkw.i("GdtIPCAdapter", String.format("ServerToClientIPCModule.onCall action:%s to:%s", new Object[] { paramBundle, str }));
        if (!TextUtils.isEmpty(paramString)) {
          break label76;
        }
      }
      label70:
      label76:
      do
      {
        do
        {
          return null;
          paramBundle = null;
          break;
          str = null;
          break label33;
        } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localParams.getToProcessName())));
        paramString = AdIPCManager.INSTANCE.getHandler(paramString);
      } while (paramString == null);
      paramString = paramString.handle(localParams);
      paramBundle = new EIPCResult();
      int i;
      if ((paramString != null) && (paramString.success))
      {
        i = 0;
        paramBundle.code = i;
        if (paramString == null) {
          break label194;
        }
      }
      label194:
      for (paramString = paramString.bundle;; paramString = null)
      {
        paramBundle.data = paramString;
        callbackResult(paramInt, paramBundle);
        return null;
        i = -102;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfi
 * JD-Core Version:    0.7.0.1
 */