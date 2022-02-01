package eipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public abstract class EIPCModuleManager
{
  public static final int INTERVAL = 1000000;
  static final String MODULE_EVENT = "__event_module";
  public static final int MSG_CALL_MODULE_AYSNC = 1;
  static Handler sHandler;
  int callbackIdStart;
  public EIPCChannel channel;
  public EIPCModuleFactory ipcModuleFactory;
  public final AtomicInteger mCallbackId = new AtomicInteger(1000);
  public SparseArray<EIPCResultCallback> mCallbackMap = new SparseArray();
  SparseArray<ArrayList<WeakReference<EIPCModule>>> mCareMessageModule = new SparseArray();
  public Context mContext;
  HashSet<EIPCOnGetConnectionListener> mListeners = new HashSet();
  ConcurrentHashMap<String, EIPCModule> mModuleMap = new ConcurrentHashMap();
  public SparseArray<EIPCChannel> mProcMap = new SparseArray();
  
  public EIPCModuleManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.channel = new EIPCModuleManager.1(this);
  }
  
  public static void excuteOnAsyncThread(Runnable paramRunnable)
  {
    if (QIPCClientHelper.sThreadEngine != null)
    {
      QIPCClientHelper.sThreadEngine.excute(paramRunnable);
      return;
    }
    getAsyncHandler().post(paramRunnable);
  }
  
  public static Handler getAsyncHandler()
  {
    try
    {
      if (sHandler == null)
      {
        localObject1 = new HandlerThread("ipc", 10);
        ((HandlerThread)localObject1).start();
        sHandler = new Handler(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = sHandler;
      return localObject1;
    }
    finally {}
  }
  
  @Deprecated
  public void addListener(EIPCOnGetConnectionListener paramEIPCOnGetConnectionListener)
  {
    this.mListeners.add(paramEIPCOnGetConnectionListener);
  }
  
  public abstract void callbackResult(int paramInt, EIPCResult paramEIPCResult);
  
  public void destroy()
  {
    this.mModuleMap.clear();
  }
  
  void dispatchMsgToModule(int paramInt, Bundle paramBundle)
  {
    for (;;)
    {
      int i;
      synchronized (this.mCareMessageModule)
      {
        ArrayList localArrayList = (ArrayList)this.mCareMessageModule.get(paramInt);
        if (localArrayList == null) {
          return;
        }
        i = localArrayList.size() - 1;
        if (i >= 0)
        {
          EIPCModule localEIPCModule = (EIPCModule)((WeakReference)localArrayList.get(i)).get();
          if (localEIPCModule != null) {
            localEIPCModule.onReceiveMsg(paramInt, paramBundle);
          } else {
            localArrayList.remove(i);
          }
        }
      }
      return;
      i -= 1;
    }
  }
  
  public void notifyBind(EIPCConnection paramEIPCConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "connection b, " + paramEIPCConnection);
    }
    Iterator localIterator = ((HashSet)this.mListeners.clone()).iterator();
    while (localIterator.hasNext()) {
      ((EIPCOnGetConnectionListener)localIterator.next()).onConnectBind(paramEIPCConnection);
    }
  }
  
  public void notifyUnbind(EIPCConnection paramEIPCConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "connection unbind, " + paramEIPCConnection);
    }
    Iterator localIterator = ((HashSet)this.mListeners.clone()).iterator();
    while (localIterator.hasNext()) {
      ((EIPCOnGetConnectionListener)localIterator.next()).onConnectUnbind(paramEIPCConnection);
    }
  }
  
  public IBinder onSetStubBinder(int paramInt, IBinder paramIBinder)
  {
    return null;
  }
  
  int registerCallback(EIPCResultCallback paramEIPCResultCallback)
  {
    int i = this.mCallbackId.addAndGet(1);
    SparseArray localSparseArray = this.mCallbackMap;
    if (paramEIPCResultCallback != null) {}
    try
    {
      this.mCallbackMap.put(i, paramEIPCResultCallback);
      return i;
    }
    finally {}
  }
  
  public void registerModule(EIPCModule paramEIPCModule)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "registerModule ," + paramEIPCModule);
    }
    paramEIPCModule.mgr = this;
    synchronized (this.mModuleMap)
    {
      if (!this.mModuleMap.containsKey(paramEIPCModule.name))
      {
        int[] arrayOfInt = paramEIPCModule.listenMessages;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          ArrayList localArrayList2 = (ArrayList)this.mCareMessageModule.get(k);
          ArrayList localArrayList1 = localArrayList2;
          if (localArrayList2 == null)
          {
            localArrayList1 = new ArrayList();
            this.mCareMessageModule.put(k, localArrayList1);
          }
          localArrayList1.add(new WeakReference(paramEIPCModule));
          i += 1;
        }
        this.mModuleMap.put(paramEIPCModule.name, paramEIPCModule);
        return;
      }
      throw new RuntimeException("Module duplicated, " + paramEIPCModule.name);
    }
  }
  
  public void removeCallback(EIPCResultCallback paramEIPCResultCallback)
  {
    for (;;)
    {
      int i;
      synchronized (this.mCallbackMap)
      {
        i = this.mCallbackMap.size() - 1;
        if (i >= 0)
        {
          if ((EIPCResultCallback)this.mCallbackMap.valueAt(i) == paramEIPCResultCallback) {
            this.mCallbackMap.removeAt(i);
          }
        }
        else {
          return;
        }
      }
      i -= 1;
    }
  }
  
  @Deprecated
  public void removeListener(EIPCOnGetConnectionListener paramEIPCOnGetConnectionListener)
  {
    this.mListeners.remove(paramEIPCOnGetConnectionListener);
  }
  
  public void sendMsgToLocalModule(int paramInt, Bundle paramBundle)
  {
    dispatchMsgToModule(paramInt, paramBundle);
  }
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
    throws RemoteException
  {
    return 1;
  }
  
  public void setModuleFactory(EIPCModuleFactory paramEIPCModuleFactory)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "initEnvironment");
    }
    this.ipcModuleFactory = paramEIPCModuleFactory;
  }
  
  public void unRegisterModule(EIPCModule paramEIPCModule)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "unRegisterModule ," + paramEIPCModule);
    }
    synchronized (this.mModuleMap)
    {
      this.mModuleMap.remove(paramEIPCModule.name);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPCModuleManager
 * JD-Core Version:    0.7.0.1
 */