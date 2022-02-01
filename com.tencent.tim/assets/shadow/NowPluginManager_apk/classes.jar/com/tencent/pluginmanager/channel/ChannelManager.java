package com.tencent.pluginmanager.channel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.now.channel.Data;
import com.tencent.now.channel.IPluginInterface;
import com.tencent.now.channel.IPluginInterface.Stub;
import com.tencent.pluginmanager.channel.listener.IBeaconDataReportListener;
import com.tencent.pluginmanager.channel.listener.IBizReqListener;
import com.tencent.pluginmanager.channel.listener.ICGIReqListener;
import com.tencent.pluginmanager.channel.listener.ICsListener;
import com.tencent.pluginmanager.channel.listener.IDataReportListener;
import com.tencent.pluginmanager.channel.listener.IDownloadReqListener;
import com.tencent.pluginmanager.channel.listener.ILogListener;
import com.tencent.pluginmanager.channel.log.ILogger;
import com.tencent.pluginmanager.channel.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChannelManager
{
  private static final String TAG = "ChannelManager";
  private static final String TARGET_QQ = "QQ";
  private static ChannelManager sInstance = new ChannelManager();
  private List<IBeaconDataReportListener> mBeaconDataReportListeners = new CopyOnWriteArrayList();
  private List<IBizReqListener> mBizReqListeners = new CopyOnWriteArrayList();
  private List<ICGIReqListener> mCGIReqListeners = new CopyOnWriteArrayList();
  private List<ICsListener> mCsListeners = new CopyOnWriteArrayList();
  private List<IDataReportListener> mDataReportListeners = new CopyOnWriteArrayList();
  private List<IDownloadReqListener> mDownloadListeners = new CopyOnWriteArrayList();
  private HostChannel mHostChannelImpl = new HostChannel()
  {
    public void beaconReportData(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      paramAnonymousString = ChannelManager.this.mBeaconDataReportListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((IBeaconDataReportListener)paramAnonymousString.next()).onBeaconReportData(paramAnonymousBundle);
      }
    }
    
    public void download(String paramAnonymousString, Bundle paramAnonymousBundle, ChannelCallback paramAnonymousChannelCallback)
    {
      paramAnonymousString = ChannelManager.this.mDownloadListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((IDownloadReqListener)paramAnonymousString.next()).onDownload(paramAnonymousBundle, paramAnonymousChannelCallback);
      }
    }
    
    public void handleCgiReq(Data paramAnonymousData, ChannelCallback paramAnonymousChannelCallback)
    {
      Iterator localIterator = ChannelManager.this.mCGIReqListeners.iterator();
      while (localIterator.hasNext()) {
        ((ICGIReqListener)localIterator.next()).doHttp(paramAnonymousData.bundle, paramAnonymousChannelCallback);
      }
    }
    
    public void printLog(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      paramAnonymousString = ChannelManager.this.mLogListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((ILogListener)paramAnonymousString.next()).onPrintLog(paramAnonymousBundle);
      }
    }
    
    public void reportData(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      paramAnonymousString = ChannelManager.this.mDataReportListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((IDataReportListener)paramAnonymousString.next()).onReportData(paramAnonymousBundle);
      }
    }
    
    public void sendBizTask(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle, ChannelCallback paramAnonymousChannelCallback)
    {
      paramAnonymousString = ChannelManager.this.mBizReqListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((IBizReqListener)paramAnonymousString.next()).onReceiveBizTask(paramAnonymousInt, paramAnonymousBundle, paramAnonymousChannelCallback);
      }
    }
    
    public void sendCsTask(String paramAnonymousString, Bundle paramAnonymousBundle, ChannelCallback paramAnonymousChannelCallback)
    {
      paramAnonymousString = ChannelManager.this.mCsListeners.iterator();
      while (paramAnonymousString.hasNext()) {
        ((ICsListener)paramAnonymousString.next()).onReceiveCsRequest(paramAnonymousBundle, paramAnonymousChannelCallback);
      }
    }
  };
  private IPluginInterface mIPluginInterface;
  private List<ILogListener> mLogListeners = new CopyOnWriteArrayList();
  
  static ChannelManager getInstance()
  {
    return sInstance;
  }
  
  void addBeaconDataReportListener(IBeaconDataReportListener paramIBeaconDataReportListener)
  {
    this.mBeaconDataReportListeners.add(paramIBeaconDataReportListener);
  }
  
  void addBizReqListener(IBizReqListener paramIBizReqListener)
  {
    this.mBizReqListeners.add(paramIBizReqListener);
  }
  
  void addCGIReqListener(ICGIReqListener paramICGIReqListener)
  {
    this.mCGIReqListeners.add(paramICGIReqListener);
  }
  
  void addCsListener(ICsListener paramICsListener)
  {
    this.mCsListeners.add(paramICsListener);
  }
  
  void addDataReportListener(IDataReportListener paramIDataReportListener)
  {
    this.mDataReportListeners.add(paramIDataReportListener);
  }
  
  void addDownloadReqListener(IDownloadReqListener paramIDownloadReqListener)
  {
    this.mDownloadListeners.add(paramIDownloadReqListener);
  }
  
  void addLogListener(ILogListener paramILogListener)
  {
    this.mLogListeners.add(paramILogListener);
  }
  
  void removeAllListener()
  {
    this.mLogListeners.clear();
    this.mCsListeners.clear();
    this.mDataReportListeners.clear();
    this.mDownloadListeners.clear();
    this.mBizReqListeners.clear();
    this.mCGIReqListeners.clear();
    this.mBeaconDataReportListeners.clear();
  }
  
  void removeBeaconDataReportListener(IBeaconDataReportListener paramIBeaconDataReportListener)
  {
    this.mBeaconDataReportListeners.remove(paramIBeaconDataReportListener);
  }
  
  void removeBizReqListener(IBizReqListener paramIBizReqListener)
  {
    this.mBizReqListeners.remove(paramIBizReqListener);
  }
  
  void removeCGIReqListener(ICGIReqListener paramICGIReqListener)
  {
    this.mCGIReqListeners.remove(paramICGIReqListener);
  }
  
  void removeCsListener(ICsListener paramICsListener)
  {
    this.mCsListeners.remove(paramICsListener);
  }
  
  void removeDataReportListener(IDataReportListener paramIDataReportListener)
  {
    this.mDataReportListeners.remove(paramIDataReportListener);
  }
  
  void removeDownloadReqListener(IDownloadReqListener paramIDownloadReqListener)
  {
    this.mDownloadListeners.remove(paramIDownloadReqListener);
  }
  
  void removeLogListener(ILogListener paramILogListener)
  {
    this.mLogListeners.remove(paramILogListener);
  }
  
  void sendToPlugin(Data paramData)
  {
    try
    {
      if (this.mIPluginInterface != null) {
        this.mIPluginInterface.sendToPlugin(paramData);
      }
      return;
    }
    catch (RemoteException paramData)
    {
      paramData.printStackTrace();
    }
  }
  
  void setBindler(IBinder paramIBinder)
  {
    this.mIPluginInterface = IPluginInterface.Stub.asInterface(paramIBinder);
    this.mIPluginInterface.setHostInterface(this.mHostChannelImpl);
  }
  
  void setLogger(ILogger paramILogger)
  {
    Logger.getInstance().setLogger(paramILogger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.ChannelManager
 * JD-Core Version:    0.7.0.1
 */