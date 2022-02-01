package com.tencent.shadow.dynamic.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.core.load_parameters.LoadParameters;
import com.tencent.shadow.core.manager.BasePluginManager;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin.Part;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin.PluginPart;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.NotFoundException;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;
import com.tencent.shadow.dynamic.host.PpsStatus;
import com.tencent.shadow.dynamic.loader.PluginLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class PluginManagerThatUseDynamicLoader
  extends BasePluginManager
  implements PluginManagerImpl
{
  private static final Logger mLogger = LoggerFactory.getLogger(PluginManagerThatUseDynamicLoader.class);
  private AtomicReference<CountDownLatch> mConnectCountDownLatch = new AtomicReference();
  protected PluginLoader mPluginLoader;
  protected PpsController mPpsController;
  private AtomicBoolean mServiceConnecting = new AtomicBoolean(false);
  private List<ServiceConnection> serviceConnectionList = new ArrayList();
  
  protected PluginManagerThatUseDynamicLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  private InstalledApk getInstalledPL(String paramString, int paramInt)
  {
    String str1 = null;
    for (;;)
    {
      InstalledPlugin.Part localPart;
      try
      {
        localPart = getLoaderOrRunTimePart(paramString, paramInt);
        Log.i("InstalledDao", "getLoaderOrRunTimePart done ");
        String str3;
        paramString = localPart.oDexDir.getAbsolutePath();
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          str3 = localPart.pluginFile.getAbsolutePath();
          if (localPart.oDexDir != null) {
            break label155;
          }
          paramString = null;
          if (localPart.libraryDir != null) {
            break label167;
          }
          return new InstalledApk(str3, paramString, str1);
        }
        catch (RuntimeException paramString)
        {
          Log.i("InstalledDao", "getInstalledPL throw new FailedException ");
          throw new FailedException(paramString);
        }
        localRuntimeException = localRuntimeException;
        if (mLogger.isErrorEnabled()) {
          mLogger.error("getInstalledPL exception:", localRuntimeException);
        }
        Log.i("InstalledDao", "getInstalledPL throw new NotFoundException ");
        throw new NotFoundException("uuid==" + paramString + " type==" + paramInt + "没找到。cause：" + localRuntimeException.getMessage());
      }
      label155:
      continue;
      label167:
      String str2 = localPart.libraryDir.getAbsolutePath();
    }
  }
  
  public final void bindPluginProcessService(final String paramString)
  {
    if (this.mServiceConnecting.get()) {
      if (mLogger.isInfoEnabled()) {
        mLogger.info("pps service connecting");
      }
    }
    for (;;)
    {
      return;
      if (mLogger.isInfoEnabled()) {
        mLogger.info("bindPluginProcessService " + paramString);
      }
      this.mConnectCountDownLatch.set(new CountDownLatch(1));
      this.mServiceConnecting.set(true);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      final boolean[] arrayOfBoolean = new boolean[1];
      this.mUiHandler.post(new Runnable()
      {
        public void run()
        {
          Intent localIntent = new Intent();
          localIntent.setComponent(new ComponentName(PluginManagerThatUseDynamicLoader.this.mHostContext, paramString));
          PluginManagerThatUseDynamicLoader.MyServiceConnection localMyServiceConnection = new PluginManagerThatUseDynamicLoader.MyServiceConnection(PluginManagerThatUseDynamicLoader.this);
          PluginManagerThatUseDynamicLoader.this.serviceConnectionList.add(localMyServiceConnection);
          boolean bool = PluginManagerThatUseDynamicLoader.this.mHostContext.bindService(localIntent, localMyServiceConnection, 1);
          arrayOfBoolean[0] = bool;
          localCountDownLatch.countDown();
        }
      });
      try
      {
        localCountDownLatch.await(10L, TimeUnit.SECONDS);
        if (arrayOfBoolean[0] != 0) {
          continue;
        }
        throw new IllegalArgumentException("无法绑定PPS:" + paramString);
      }
      catch (InterruptedException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
  }
  
  public InstalledApk getPlugin(String paramString1, String paramString2)
  {
    for (;;)
    {
      InstalledPlugin.Part localPart;
      try
      {
        localPart = getPluginPartByPartKey(paramString1, paramString2);
        Object localObject1;
        paramString1 = null;
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          if (!(localPart instanceof InstalledPlugin.PluginPart)) {
            break label212;
          }
          paramString1 = ((InstalledPlugin.PluginPart)localPart).businessName;
          if (!(localPart instanceof InstalledPlugin.PluginPart)) {
            break label217;
          }
          localObject1 = ((InstalledPlugin.PluginPart)localPart).dependsOn;
          if (!(localPart instanceof InstalledPlugin.PluginPart)) {
            break label222;
          }
          localObject3 = ((InstalledPlugin.PluginPart)localPart).hostWhiteList;
          paramString2 = new LoadParameters(paramString1, paramString2, (String[])localObject1, (String[])localObject3);
          paramString1 = Parcel.obtain();
          paramString2.writeToParcel(paramString1, 0);
          localObject1 = paramString1.marshall();
          paramString1.recycle();
          localObject3 = localPart.pluginFile.getAbsolutePath();
          if (localPart.oDexDir != null) {
            break label228;
          }
          paramString1 = null;
          if (localPart.libraryDir != null) {
            break label240;
          }
          paramString2 = null;
          return new InstalledApk((String)localObject3, paramString1, paramString2, (byte[])localObject1);
        }
        catch (RuntimeException paramString1)
        {
          if (!mLogger.isErrorEnabled()) {
            break label203;
          }
          mLogger.error("getPlugin exception:", paramString1);
          throw new FailedException(paramString1);
        }
        localRuntimeException = localRuntimeException;
        throw new NotFoundException("uuid==" + paramString1 + "partKey==" + paramString2 + "的Plugin找不到");
      }
      label203:
      label212:
      continue;
      label217:
      Object localObject2 = null;
      continue;
      label222:
      Object localObject3 = null;
      continue;
      label228:
      paramString1 = localPart.oDexDir.getAbsolutePath();
      continue;
      label240:
      paramString2 = localPart.libraryDir.getAbsolutePath();
    }
  }
  
  public InstalledApk getPluginLoader(String paramString)
  {
    return getInstalledPL(paramString, 3);
  }
  
  public InstalledApk getRuntime(String paramString)
  {
    Log.i("InstalledDao", "getRuntime uuid = " + paramString);
    return getInstalledPL(paramString, 4);
  }
  
  public final void loadPluginLoader(String paramString)
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("loadPluginLoader mPluginLoader:" + this.mPluginLoader);
    }
    if (this.mPluginLoader == null)
    {
      if (!this.mPpsController.getPpsStatus().loaderLoaded) {
        this.mPpsController.loadPluginLoader(paramString);
      }
      this.mPluginLoader = new BinderPluginLoader(this.mPpsController.getPluginLoader());
    }
  }
  
  public final void loadRunTime(String paramString)
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("loadRunTime mPpsController:" + this.mPpsController);
    }
    if (!this.mPpsController.getPpsStatus().runtimeLoaded) {
      this.mPpsController.loadRuntime(paramString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("onCreate bundle:" + paramBundle);
    }
  }
  
  public void onDestroy()
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("onDestroy:");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("onSaveInstanceState:" + paramBundle);
    }
  }
  
  protected void unBinderUUIDManager()
  {
    Iterator localIterator = this.serviceConnectionList.iterator();
    while (localIterator.hasNext())
    {
      ServiceConnection localServiceConnection = (ServiceConnection)localIterator.next();
      try
      {
        this.mHostContext.unbindService(localServiceConnection);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        mLogger.warn(localIllegalArgumentException.toString());
      }
    }
    this.mServiceConnecting.set(false);
    this.mPluginLoader = null;
  }
  
  public final void waitServiceConnected(int paramInt, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new RuntimeException("waitServiceConnected 不能在主线程中调用");
    }
    long l;
    for (;;)
    {
      try
      {
        if (mLogger.isInfoEnabled()) {
          mLogger.info("waiting service connect connectCountDownLatch:" + this.mConnectCountDownLatch);
        }
        l = System.currentTimeMillis();
        if (!((CountDownLatch)this.mConnectCountDownLatch.get()).await(paramInt, paramTimeUnit))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          throw new TimeoutException("连接Service超时 ,等待了：" + (System.currentTimeMillis() - l));
        }
      }
      catch (InterruptedException paramTimeUnit)
      {
        throw new RuntimeException(paramTimeUnit);
      }
      paramInt = 0;
    }
    if (mLogger.isInfoEnabled()) {
      mLogger.info("service connected " + (System.currentTimeMillis() - l));
    }
  }
  
  class MyServiceConnection
    implements ServiceConnection
  {
    MyServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (PluginManagerThatUseDynamicLoader.mLogger.isInfoEnabled()) {
        PluginManagerThatUseDynamicLoader.mLogger.info("onServiceConnected connectCountDownLatch:" + PluginManagerThatUseDynamicLoader.this.mConnectCountDownLatch);
      }
      PluginManagerThatUseDynamicLoader.this.mServiceConnecting.set(false);
      PluginManagerThatUseDynamicLoader.this.mPpsController = PluginProcessService.wrapBinder(paramIBinder);
      try
      {
        PluginManagerThatUseDynamicLoader.this.mPpsController.setUuidManager(new UuidManagerBinder(PluginManagerThatUseDynamicLoader.this));
        try
        {
          paramComponentName = PluginManagerThatUseDynamicLoader.this.mPpsController.getPluginLoader();
          if (paramComponentName != null) {
            PluginManagerThatUseDynamicLoader.this.mPluginLoader = new BinderPluginLoader(paramComponentName);
          }
        }
        catch (RemoteException paramComponentName)
        {
          for (;;)
          {
            if (PluginManagerThatUseDynamicLoader.mLogger.isErrorEnabled()) {
              PluginManagerThatUseDynamicLoader.mLogger.error("onServiceConnected mPpsController getPluginLoader:", paramComponentName);
            }
          }
        }
        ((CountDownLatch)PluginManagerThatUseDynamicLoader.this.mConnectCountDownLatch.get()).countDown();
        if (PluginManagerThatUseDynamicLoader.mLogger.isInfoEnabled()) {
          PluginManagerThatUseDynamicLoader.mLogger.info("onServiceConnected countDown:" + PluginManagerThatUseDynamicLoader.this.mConnectCountDownLatch);
        }
        return;
      }
      catch (DeadObjectException paramComponentName)
      {
        for (;;)
        {
          if (PluginManagerThatUseDynamicLoader.mLogger.isErrorEnabled()) {
            PluginManagerThatUseDynamicLoader.mLogger.error("onServiceConnected RemoteException:" + paramComponentName);
          }
        }
      }
      catch (RemoteException paramComponentName)
      {
        while (paramComponentName.getClass().getSimpleName().equals("TransactionTooLargeException")) {
          if (PluginManagerThatUseDynamicLoader.mLogger.isErrorEnabled()) {
            PluginManagerThatUseDynamicLoader.mLogger.error("onServiceConnected TransactionTooLargeException:" + paramComponentName);
          }
        }
        throw new RuntimeException(paramComponentName);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (PluginManagerThatUseDynamicLoader.mLogger.isInfoEnabled()) {
        PluginManagerThatUseDynamicLoader.mLogger.info("onServiceDisconnected");
      }
      PluginManagerThatUseDynamicLoader.this.mServiceConnecting.set(false);
      PluginManagerThatUseDynamicLoader.this.mPpsController = null;
      PluginManagerThatUseDynamicLoader.this.mPluginLoader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.manager.PluginManagerThatUseDynamicLoader
 * JD-Core Version:    0.7.0.1
 */