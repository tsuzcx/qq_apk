package com.tencent.thumbplayer.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPDownloadProxyService
  extends Service
{
  private static final String FILE_NAME = "TPDownloadProxyService";
  private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
  private int pid = -1;
  
  private boolean isExistMainProcess()
  {
    try
    {
      Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        if ((!TextUtils.isEmpty(str)) && (str.equals(getPackageName())))
        {
          if ((this.pid != -1) && (this.pid != localRunningAppProcessInfo.pid))
          {
            this.pid = localRunningAppProcessInfo.pid;
            return false;
          }
          this.pid = localRunningAppProcessInfo.pid;
          TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "app main exist!");
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "isExistMainProcess failed, error:" + localThrowable.toString());
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.downloadProxyFactory == null) {
      this.downloadProxyFactory = new DownloadProxyFactory(null);
    }
    isExistMainProcess();
    return this.downloadProxyFactory;
  }
  
  public void onRebind(Intent paramIntent)
  {
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on rebind!");
    isExistMainProcess();
    super.onRebind(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on unbind!");
    super.onUnbind(paramIntent);
    if (!isExistMainProcess()) {}
    try
    {
      TPDownloadProxyNative.getInstance().stopAllDownload(3);
      TPListenerManager.getInstance().removeAllPlayListener();
      TPListenerManager.getInstance().removeAllPreLoadListener();
      return true;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramIntent.toString());
      }
    }
  }
  
  class DownloadProxy
    extends ITPDownloadProxyAidl.Stub
  {
    private ITPDownloadProxy downloadProxy = null;
    
    public DownloadProxy(int paramInt)
    {
      this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    }
    
    public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
    {
      return this.downloadProxy.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
    }
    
    public String getNativeInfo(int paramInt)
    {
      try
      {
        String str = this.downloadProxy.getNativeInfo(paramInt);
        return str;
      }
      catch (Exception localException)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getNativeInfo failed, error:" + localException.toString());
      }
      return null;
    }
    
    public String getPlayErrorCodeStr(int paramInt)
    {
      return this.downloadProxy.getPlayErrorCodeStr(paramInt);
    }
    
    public String getPlayUrl(int paramInt1, int paramInt2)
    {
      return this.downloadProxy.getPlayUrl(paramInt1, paramInt2);
    }
    
    public int init(String paramString)
    {
      try
      {
        paramString = (TPDLProxyInitParam)TPDLProxyUtils.serializeToObject(paramString);
        if (paramString == null)
        {
          TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "param is null");
          return -1;
        }
        int i = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "init failed, error:" + paramString.toString());
      }
      return -2;
    }
    
    public int pauseDownload(int paramInt)
    {
      return this.downloadProxy.pauseDownload(paramInt);
    }
    
    public void pushEvent(int paramInt)
    {
      this.downloadProxy.pushEvent(paramInt);
    }
    
    public int resumeDownload(int paramInt)
    {
      return this.downloadProxy.resumeDownload(paramInt);
    }
    
    public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.downloadProxy.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
    {
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      return this.downloadProxy.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParamAidl);
    }
    
    public void setMaxStorageSizeMB(long paramLong)
    {
      this.downloadProxy.setMaxStorageSizeMB(paramLong);
    }
    
    public void setPlayState(int paramInt1, int paramInt2)
    {
      this.downloadProxy.setPlayState(paramInt1, paramInt2);
    }
    
    public void setUpdatePlayerInfoInterval(int paramInt)
    {
      this.downloadProxy.setUpdatePlayerInfoInterval(paramInt);
    }
    
    public void setUserData(Map paramMap)
    {
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (localEntry != null) {
            try
            {
              if (localEntry.getValue() != null) {
                this.downloadProxy.setUserData((String)localEntry.getKey(), localEntry.getValue());
              }
            }
            catch (Throwable localThrowable)
            {
              TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "setUserData failed, error:" + localThrowable.toString());
            }
          }
        }
      }
    }
    
    public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.2(this, paramITPPlayListenerAidl);
      return this.downloadProxy.startClipPlay(paramString, paramInt, paramITPPlayListenerAidl);
    }
    
    public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      try
      {
        paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
        paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.1(this, paramITPPlayListenerAidl);
        int i = this.downloadProxy.startPlay(paramString, paramTPDownloadParamAidl, paramITPPlayListenerAidl);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      }
      return -1;
    }
    
    public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
    {
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      paramITPPreLoadListenerAidl = new TPDownloadProxyService.DownloadProxy.3(this, paramITPPreLoadListenerAidl);
      return this.downloadProxy.startPreload(paramString, paramTPDownloadParamAidl, paramITPPreLoadListenerAidl);
    }
    
    public void stopPlay(int paramInt)
    {
      this.downloadProxy.stopPlay(paramInt);
    }
    
    public void stopPreload(int paramInt)
    {
      this.downloadProxy.stopPreload(paramInt);
    }
  }
  
  class DownloadProxyFactory
    extends TPDownloadProxyFactoryAidl.Stub
  {
    private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap = new HashMap();
    
    private DownloadProxyFactory() {}
    
    public String getNativeVersion()
    {
      return TPDownloadProxyFactory.getNativeVersion();
    }
    
    public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
    {
      try
      {
        ITPDownloadProxyAidl localITPDownloadProxyAidl = (ITPDownloadProxyAidl)this.mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localITPDownloadProxyAidl;
        if (localITPDownloadProxyAidl == null)
        {
          localObject1 = new TPDownloadProxyService.DownloadProxy(TPDownloadProxyService.this, paramInt);
          this.mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
        }
        return localObject1;
      }
      finally {}
    }
    
    public boolean isReadyForDownload()
    {
      return TPDownloadProxyFactory.isReadyForDownload();
    }
    
    public boolean isReadyForPlay()
    {
      return TPDownloadProxyFactory.isReadyForPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService
 * JD-Core Version:    0.7.0.1
 */