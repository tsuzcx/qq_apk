package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginRemoteProcessor
{
  private static PluginRemoteProcessor sInstance;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private volatile boolean mProcessing;
  private LinkedList<WrappedServiceConnection> mQueue = new LinkedList();
  
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
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "processInner");
    }
    Context localContext = paramWrappedServiceConnection.mContext.getApplicationContext();
    Intent localIntent = new Intent(localContext, PluginRemoteService.class);
    localIntent.putExtra("key_binder_type", paramWrappedServiceConnection.mBinderType);
    localContext.bindService(localIntent, paramWrappedServiceConnection, 1);
  }
  
  private void processInnerDelay(final WrappedServiceConnection paramWrappedServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "processInnerDelay." + paramInt);
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        PluginRemoteProcessor.this.processInner(paramWrappedServiceConnection);
      }
    }, paramInt);
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.mQueue)
    {
      Iterator localIterator = this.mQueue.iterator();
      while (localIterator.hasNext())
      {
        WrappedServiceConnection localWrappedServiceConnection = (WrappedServiceConnection)localIterator.next();
        if (localWrappedServiceConnection.mWrappedConnection == paramServiceConnection) {
          localWrappedServiceConnection.mContext.unbindService(localWrappedServiceConnection);
        }
      }
      return;
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteProcessor.process");
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
    processInner(paramServiceConnection);
  }
  
  private class WrappedServiceConnection
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
      this.mContext.getApplicationContext().unbindService(this);
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceConnected");
      }
      this.mWrappedConnection.onServiceConnected(???, paramIBinder);
      do
      {
        synchronized (PluginRemoteProcessor.this.mQueue)
        {
          paramIBinder = (WrappedServiceConnection)PluginRemoteProcessor.this.mQueue.poll();
          if (paramIBinder != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("plugin_tag", 2, "continue process");
            }
            PluginRemoteProcessor.this.processInnerDelay(paramIBinder, 200);
            return;
          }
        }
        PluginRemoteProcessor.access$602(PluginRemoteProcessor.this, false);
      } while (!QLog.isColorLevel());
      QLog.i("plugin_tag", 2, "queue empty");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceDisconnected");
      }
      this.mWrappedConnection.onServiceDisconnected(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor
 * JD-Core Version:    0.7.0.1
 */