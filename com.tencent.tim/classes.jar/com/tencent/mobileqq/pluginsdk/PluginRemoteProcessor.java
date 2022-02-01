package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub1;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginRemoteProcessor
{
  private static PluginRemoteProcessor sInstance;
  private Handler mHandler;
  private volatile boolean mProcessing;
  private LinkedList<WrappedServiceConnection> mQueue = new LinkedList();
  
  private PluginRemoteProcessor()
  {
    Object localObject = IPluginAdapterProxy.getProxy();
    Looper localLooper = null;
    if (localObject != null) {
      localLooper = ((IPluginAdapterProxy)localObject).getSubThreadLooper();
    }
    localObject = localLooper;
    if (localLooper == null) {
      localObject = Looper.getMainLooper();
    }
    this.mHandler = new Handler((Looper)localObject);
  }
  
  public static PluginRemoteProcessor get()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new PluginRemoteProcessor();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void processInner(WrappedServiceConnection paramWrappedServiceConnection)
  {
    Object localObject = null;
    switch (paramWrappedServiceConnection.mBinderType)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "processInner, " + paramWrappedServiceConnection + ", " + localObject);
      }
      if (localObject != null) {
        break;
      }
      return;
      localObject = PluginRemoteService.Sub1.class;
      continue;
      localObject = PluginRemoteService.Sub2.class;
    }
    Context localContext = paramWrappedServiceConnection.mContext.getApplicationContext();
    Intent localIntent = new Intent(localContext, (Class)localObject);
    localIntent.putExtra("key_binder_type", paramWrappedServiceConnection.mBinderType);
    try
    {
      localContext.bindService(localIntent, paramWrappedServiceConnection, 1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.i("plugin_tag", 1, "processInner", localSecurityException);
      paramWrappedServiceConnection.onServiceDisconnected(new ComponentName(paramWrappedServiceConnection.mContext, ((Class)localObject).getCanonicalName()));
    }
  }
  
  private void processInnerDelay(WrappedServiceConnection paramWrappedServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "processInnerDelay. " + paramInt + ", " + paramWrappedServiceConnection);
    }
    this.mHandler.postDelayed(new PluginRemoteProcessor.1(this, paramWrappedServiceConnection), paramInt);
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.mQueue)
    {
      Iterator localIterator = this.mQueue.iterator();
      for (;;)
      {
        WrappedServiceConnection localWrappedServiceConnection;
        if (localIterator.hasNext()) {
          localWrappedServiceConnection = (WrappedServiceConnection)localIterator.next();
        }
        try
        {
          if (localWrappedServiceConnection.mWrappedConnection != paramServiceConnection) {
            continue;
          }
          localWrappedServiceConnection.mContext.unbindService(localWrappedServiceConnection);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new WrappedServiceConnection(paramServiceConnection, ???, paramInt);
    if (this.mProcessing)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "queue");
      }
      synchronized (this.mQueue)
      {
        this.mQueue.offer(paramServiceConnection);
        return;
      }
    }
    this.mProcessing = true;
    processInnerDelay(paramServiceConnection, 0);
  }
  
  class WrappedServiceConnection
    implements ServiceConnection
  {
    private int mBinderType;
    private Context mContext;
    private ServiceConnection mWrappedConnection;
    
    public WrappedServiceConnection(ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
    {
      this.mWrappedConnection = paramServiceConnection;
      this.mContext = paramContext;
      this.mBinderType = paramInt;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      do
      {
        try
        {
          this.mContext.getApplicationContext().unbindService(this);
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "onServiceConnected, " + this);
          }
          this.mWrappedConnection.onServiceConnected(???, paramIBinder);
        }
        catch (Exception localException)
        {
          synchronized (PluginRemoteProcessor.this.mQueue)
          {
            do
            {
              paramIBinder = (WrappedServiceConnection)PluginRemoteProcessor.this.mQueue.poll();
              if (paramIBinder == null) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "continue process");
              }
              PluginRemoteProcessor.this.processInnerDelay(paramIBinder, 300);
              return;
              localException = localException;
            } while (!QLog.isColorLevel());
            QLog.i("plugin_tag", 2, "unbindService, " + this);
          }
        }
        PluginRemoteProcessor.access$602(PluginRemoteProcessor.this, false);
      } while (!QLog.isColorLevel());
      QLog.i("plugin_tag", 2, "queue empty");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceDisconnected, " + this);
      }
      this.mWrappedConnection.onServiceDisconnected(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor
 * JD-Core Version:    0.7.0.1
 */