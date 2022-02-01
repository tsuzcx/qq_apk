package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiManager
  implements Handler.Callback
{
  private static final Object a = new Object();
  private static HuaweiApiManager b;
  private final Handler c = new Handler(paramLooper, this);
  private final AtomicInteger d = new AtomicInteger(0);
  private final Map<ConnectionManagerKey<?>, ConnectionManager<?>> e = new ConcurrentHashMap(5, 0.75F, 1);
  
  private HuaweiApiManager(Context paramContext, Looper paramLooper, HuaweiApiAvailability paramHuaweiApiAvailability) {}
  
  private void a(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    paramHuaweiApi = (ConnectionManager)this.e.get(paramHuaweiApi.getConnectionManagerKey());
    if (paramHuaweiApi == null)
    {
      paramTaskCompletionSource.setResult(Boolean.valueOf(false));
      return;
    }
    paramTaskCompletionSource.setResult(Boolean.valueOf(paramHuaweiApi.a()));
  }
  
  private void a(b paramb)
  {
    HuaweiApi localHuaweiApi = paramb.b;
    ConnectionManager localConnectionManager = (ConnectionManager)this.e.get(localHuaweiApi.getConnectionManagerKey());
    if (localConnectionManager == null)
    {
      localConnectionManager = new ConnectionManager(localHuaweiApi);
      this.e.put(localHuaweiApi.getConnectionManagerKey(), localConnectionManager);
    }
    for (;;)
    {
      localConnectionManager.a((TaskApiCallWrapper)paramb.a);
      return;
    }
  }
  
  public static HuaweiApiManager getInstance(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("HuaweiApiManager");
        localHandlerThread.start();
        b = new HuaweiApiManager(paramContext.getApplicationContext(), localHandlerThread.getLooper(), HuaweiApiAvailability.getInstance());
      }
      return b;
    }
  }
  
  public void disconnectService(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    if (Looper.myLooper() == this.c.getLooper())
    {
      a(paramHuaweiApi, paramTaskCompletionSource);
      return;
    }
    this.c.post(new HuaweiApiManager.1(this, paramHuaweiApi, paramTaskCompletionSource));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      HMSLog.w("HuaweiApiManager", "Unknown message id: " + paramMessage.what);
      return false;
    }
    a((b)paramMessage.obj);
    return true;
  }
  
  public final <TOption extends Api.ApiOptions, TResult> void sendRequest(HuaweiApi<TOption> paramHuaweiApi, TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    paramTaskApiCall = new TaskApiCallWrapper(paramTaskApiCall, paramTaskCompletionSource);
    this.c.sendMessage(this.c.obtainMessage(4, new b(paramTaskApiCall, this.d.getAndIncrement(), paramHuaweiApi)));
  }
  
  public class ConnectionManager<OptionsT extends Api.ApiOptions>
    implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener
  {
    private final Queue<HuaweiApiManager.a> b = new LinkedList();
    private final AnyClient c;
    private ConnectionResult d;
    private final ConnectionManagerKey e;
    private final HuaweiApi<OptionsT> f;
    
    ConnectionManager()
    {
      Object localObject;
      this.f = localObject;
      this.c = localObject.getClient(HuaweiApiManager.a(HuaweiApiManager.this).getLooper(), this);
      this.d = null;
      this.e = localObject.getConnectionManagerKey();
    }
    
    private String a(String paramString1, String paramString2)
    {
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = TransactionIdCreater.getId(this.f.getAppID(), paramString2);
      }
      return str;
    }
    
    private void a(ConnectionResult paramConnectionResult)
    {
      Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
      this.d = paramConnectionResult;
      Iterator localIterator = this.b.iterator();
      int i = 1;
      TaskApiCallWrapper localTaskApiCallWrapper;
      ResponseHeader localResponseHeader;
      if (localIterator.hasNext())
      {
        localTaskApiCallWrapper = ((HuaweiApiManager.a)localIterator.next()).a();
        localResponseHeader = new ResponseHeader(1, 907135003, "Connection Failed:" + b(paramConnectionResult) + "(" + paramConnectionResult.getErrorCode() + ")");
        localResponseHeader.setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
        com.huawei.hms.support.hianalytics.b.a(this.f.getContext(), localResponseHeader, String.valueOf(this.f.getKitSdkVersion()));
        if ((this.d.getResolution() == null) || (i == 0)) {
          break label229;
        }
        localResponseHeader.setParcelable(this.d.getResolution());
        i = 0;
      }
      label229:
      for (;;)
      {
        localTaskApiCallWrapper.getTaskApiCall().onResponse(this.c, localResponseHeader, null, localTaskApiCallWrapper.getTaskCompletionSource());
        break;
        this.b.clear();
        this.d = null;
        this.c.disconnect();
        HuaweiApiManager.b(HuaweiApiManager.this).remove(this.e);
        return;
      }
    }
    
    private void a(HuaweiApiManager.a parama)
    {
      String str = parama.a().getTaskApiCall().getUri();
      RequestHeader localRequestHeader = new RequestHeader();
      localRequestHeader.setSrvName(str.split("\\.")[0]);
      localRequestHeader.setApiName(str);
      localRequestHeader.setAppID(this.f.getAppID() + "|" + this.f.getSubAppID());
      localRequestHeader.setPkgName(this.f.getContext().getPackageName());
      localRequestHeader.setSessionId(this.c.getSessionId());
      TaskApiCall localTaskApiCall = parama.a().getTaskApiCall();
      localRequestHeader.setTransactionId(a(localTaskApiCall.getTransactionId(), str));
      localRequestHeader.setParcelable(localTaskApiCall.getParcelable());
      localRequestHeader.setKitSdkVersion(this.f.getKitSdkVersion());
      localRequestHeader.setApiLevel(this.f.getApiLevel());
      this.c.post(localRequestHeader, localTaskApiCall.getRequestJson(), parama.b());
    }
    
    private HuaweiApiManager.a b(TaskApiCallWrapper paramTaskApiCallWrapper)
    {
      return new HuaweiApiManager.a(paramTaskApiCallWrapper, new HuaweiApiManager.ConnectionManager.1(this, paramTaskApiCallWrapper));
    }
    
    private String b(ConnectionResult paramConnectionResult)
    {
      switch (paramConnectionResult.getErrorCode())
      {
      default: 
        return "unknown errorReason";
      case 10: 
        return "application configuration error, please developer check configuration";
      case 26: 
        return "update failed, because no activity incoming, can't pop update page";
      case 21: 
        return "device is too old to be support";
      case 3: 
        return "HuaWei Mobile Service is disabled";
      case 27: 
        return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
      case 13: 
        return "update cancelled";
      case 8: 
        return "internal error";
      case 25: 
        return "failed to get update result";
      }
      return "get update result, but has other error codes";
    }
    
    private void b()
    {
      Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
      this.d = null;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        a((HuaweiApiManager.a)localIterator.next());
      }
      this.b.clear();
    }
    
    private void b(int paramInt)
    {
      Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        TaskApiCallWrapper localTaskApiCallWrapper = ((HuaweiApiManager.a)localIterator.next()).a();
        ResponseHeader localResponseHeader = new ResponseHeader(1, 907135003, "Connection Suspended");
        localResponseHeader.setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
        localTaskApiCallWrapper.getTaskApiCall().onResponse(this.c, localResponseHeader, null, localTaskApiCallWrapper.getTaskCompletionSource());
      }
      this.b.clear();
      this.d = null;
      this.c.disconnect();
      HuaweiApiManager.b(HuaweiApiManager.this).remove(this.e);
    }
    
    void a(int paramInt)
    {
      for (;;)
      {
        try
        {
          Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
          if (this.c.isConnected())
          {
            HMSLog.d("HuaweiApiManager", "client is connected");
            return;
          }
          if (this.c.isConnecting()) {
            HMSLog.d("HuaweiApiManager", "client is isConnecting");
          } else {
            this.c.connect(paramInt);
          }
        }
        finally {}
      }
    }
    
    void a(TaskApiCallWrapper paramTaskApiCallWrapper)
    {
      HMSLog.i("HuaweiApiManager", "sendRequest");
      Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
      HuaweiApiManager.a locala = b(paramTaskApiCallWrapper);
      int i = paramTaskApiCallWrapper.getTaskApiCall().getMinApkVersion();
      if (this.c.isConnected())
      {
        if (com.huawei.hms.utils.b.a(this.f.getContext()).a(i))
        {
          a(locala);
          return;
        }
        a();
        this.b.add(locala);
        a(i);
        return;
      }
      this.b.add(locala);
      if ((this.d != null) && (this.d.getErrorCode() != 0))
      {
        onConnectionFailed(this.d);
        return;
      }
      a(i);
    }
    
    boolean a()
    {
      Checker.assertHandlerThread(HuaweiApiManager.a(HuaweiApiManager.this));
      this.c.disconnect();
      return true;
    }
    
    public void onConnected()
    {
      HMSLog.d("HuaweiApiManager", "onConnected");
      if (Looper.myLooper() == HuaweiApiManager.a(HuaweiApiManager.this).getLooper())
      {
        b();
        return;
      }
      HuaweiApiManager.a(HuaweiApiManager.this).post(new HuaweiApiManager.ConnectionManager.3(this));
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      HMSLog.i("HuaweiApiManager", "onConnectionFailed");
      if (Looper.myLooper() == HuaweiApiManager.a(HuaweiApiManager.this).getLooper())
      {
        a(paramConnectionResult);
        return;
      }
      HuaweiApiManager.a(HuaweiApiManager.this).post(new HuaweiApiManager.ConnectionManager.2(this, paramConnectionResult));
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
      if (Looper.myLooper() == HuaweiApiManager.a(HuaweiApiManager.this).getLooper())
      {
        b(paramInt);
        return;
      }
      HuaweiApiManager.a(HuaweiApiManager.this).post(new HuaweiApiManager.ConnectionManager.4(this, paramInt));
    }
  }
  
  static class a
  {
    private final TaskApiCallWrapper a;
    private final AnyClient.CallBack b;
    
    a(TaskApiCallWrapper paramTaskApiCallWrapper, AnyClient.CallBack paramCallBack)
    {
      this.a = paramTaskApiCallWrapper;
      this.b = paramCallBack;
    }
    
    TaskApiCallWrapper a()
    {
      return this.a;
    }
    
    AnyClient.CallBack b()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager
 * JD-Core Version:    0.7.0.1
 */