package com.tencent.qqmini.sdk.manager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel.Receiver;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EngineManager
{
  public static final String LOG_TAG = "EngineManager";
  private static volatile EngineManager sInstance;
  private SparseArray<EngineChannel> mChannels;
  private SparseArray<EngineInstaller> mEngineInstallers;
  private SparseArray<EngineChannel> mOutChannels;
  
  private EngineManager()
  {
    QMLog.i("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.mEngineInstallers = new SparseArray();
    this.mChannels = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("MainGame");
    localEngineChannel.setReceiver(new EngineChannelReceiver());
    this.mChannels.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.setName("MainApp");
    localEngineChannel.setReceiver(new EngineChannelReceiver());
    this.mChannels.put(3, localEngineChannel);
    this.mOutChannels = new SparseArray();
    EngineInstaller.updateInstalledEngine();
    EngineInstaller.removeOutDatedEngine(2);
    EngineInstaller.removeOldEngine(2);
    EngineInstaller.removeOldEngine(3);
    QMLog.i("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static EngineManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EngineManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private ArrayList<Integer> getRunningPidList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid));
    }
    return localArrayList;
  }
  
  private void installBaseLibForChannel(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    QMLog.i("EngineManager", "[MiniEng] installBaseLibForChannel " + paramBaseLibInfo + "," + paramEngineChannel);
    installBaseLib(paramBaseLibInfo, new EngineManager.3(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  private void installEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.executeOnDiskIOThreadPool(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  private void preInstallLocalGameLib()
  {
    Iterator localIterator = getEngineList(2).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if ((localInstalledEngine.isPersist) && (localInstalledEngine.isVerify))
      {
        QMLog.i("EngineManager", "[MiniEng] installLocalLib skip already installed");
        return;
      }
    }
    QMLog.i("EngineManager", "[MiniEng] installLocalGameEngine " + LocalGameEngine.g().mLocalBaseLibInfo);
    installBaseLib(LocalGameEngine.g().mLocalBaseLibInfo, null);
  }
  
  private void removeDeadChannelExcept(EngineChannel paramEngineChannel)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = getRunningPidList();
        if (this.mOutChannels != null)
        {
          i = 0;
          if (i < this.mOutChannels.size())
          {
            int j = this.mOutChannels.keyAt(i);
            if (localArrayList.contains(Integer.valueOf(j))) {
              break label139;
            }
            if (((EngineChannel)this.mOutChannels.valueAt(i)).equals(paramEngineChannel))
            {
              QMLog.e("EngineManager", "[MiniEng] removeDeadChannelExcept error pid=" + j);
            }
            else
            {
              this.mOutChannels.remove(j);
              QMLog.i("EngineManager", "[MiniEng] removeDeadChannelExcept pid=" + j);
            }
          }
        }
      }
      finally {}
      return;
      label139:
      i += 1;
    }
  }
  
  private void upgradeEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.executeOnDiskIOThreadPool(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  public EngineChannel getChannelForType(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.mChannels.get(paramInt);
    if (localEngineChannel == null) {
      QMLog.e("EngineManager", "[MiniEng]getChannelForType error type" + paramInt);
    }
    return localEngineChannel;
  }
  
  public ArrayList<InstalledEngine> getEngineList(int paramInt)
  {
    return EngineInstaller.getInstalledEngine(paramInt);
  }
  
  public void installBaseLib(BaseLibInfo paramBaseLibInfo, EngineInstaller.Callback paramCallback)
  {
    if (paramBaseLibInfo != null)
    {
      EngineInstaller localEngineInstaller2 = (EngineInstaller)this.mEngineInstallers.get(paramBaseLibInfo.baseLibType);
      EngineInstaller localEngineInstaller1 = localEngineInstaller2;
      if (localEngineInstaller2 == null)
      {
        localEngineInstaller1 = new EngineInstaller();
        this.mEngineInstallers.put(paramBaseLibInfo.baseLibType, localEngineInstaller1);
      }
      localEngineInstaller1.installWithCallback(paramBaseLibInfo, paramCallback);
      return;
    }
    QMLog.i("EngineManager", "[MiniEng] libInfo is null ");
  }
  
  public class EngineChannelReceiver
    implements EngineChannel.Receiver
  {
    public EngineChannelReceiver() {}
    
    public void onReceiveData(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      int i = paramBundle.getInt("baseLibType");
      int j = paramBundle.getInt("enginePid");
      EngineChannel localEngineChannel = (EngineChannel)paramBundle.getParcelable("engineChannel");
      if (localEngineChannel != null)
      {
        if (EngineManager.this.mOutChannels.indexOfKey(j) > 0) {
          QMLog.w("EngineManager", "[MiniEng] channel already exists for pid " + j + " replacing");
        }
        EngineManager.this.mOutChannels.put(j, localEngineChannel);
      }
      localEngineChannel = (EngineChannel)EngineManager.this.mOutChannels.get(j);
      if (localEngineChannel == null)
      {
        QMLog.e("EngineManager", "[MiniEng]no channel available for pid " + j);
        return;
      }
      QMLog.i("EngineManager", "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + localEngineChannel + ",channelCount=" + EngineManager.this.mOutChannels.size());
      localEngineChannel.send(55, null);
      Object localObject;
      if (paramInt == 1)
      {
        paramBundle = EngineManager.g().getEngineList(i);
        localObject = new Bundle();
        ((Bundle)localObject).putParcelableArrayList("installedEngineList", paramBundle);
        localEngineChannel.send(51, (Bundle)localObject);
        EngineManager.this.removeDeadChannelExcept(localEngineChannel);
        QMLog.i("EngineManager", "[MiniEng]LiveChannel count " + EngineManager.this.mOutChannels.size());
        return;
      }
      if (paramInt == 3) {
        if (i == 2)
        {
          paramBundle = EngineManager.this.getEngineList(i).iterator();
          do
          {
            if (!paramBundle.hasNext()) {
              break;
            }
            localObject = (InstalledEngine)paramBundle.next();
          } while ((!((InstalledEngine)localObject).isPersist) || (!((InstalledEngine)localObject).isVerify));
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if ((!LocalGameEngine.g().isDisabled()) && (paramInt == 0) && ((QUAUtil.isQQMainApp()) || (QUAUtil.isDemoApp()) || (!TextUtils.isEmpty(paramBundle.getSoPath()))))
        {
          ThreadManager.executeOnDiskIOThreadPool(new EngineManager.EngineChannelReceiver.1(this, localEngineChannel));
          return;
        }
        if (LocalGameEngine.g().isWnsConfigModel())
        {
          paramBundle = WnsUtil.getGameBaseLibInfo();
          QMLog.i("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + paramBundle);
          if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
            break;
          }
          EngineManager.this.installEngine(paramBundle, localEngineChannel);
          return;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new EngineManager.EngineChannelReceiver.2(this, i, localEngineChannel));
        return;
        if (paramInt == 5)
        {
          if ((i == 2) && (LocalGameEngine.g().isWnsConfigModel()))
          {
            paramBundle = WnsUtil.getGameBaseLibInfo();
            QMLog.i("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + paramBundle);
            if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
              break;
            }
            EngineManager.this.upgradeEngine(paramBundle, localEngineChannel);
            return;
          }
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new EngineManager.EngineChannelReceiver.3(this, i, localEngineChannel));
          return;
        }
        if (paramInt != 56) {
          break;
        }
        paramBundle = (InstalledEngine)paramBundle.getParcelable("invalidEngine");
        QMLog.i("EngineManager", "[MiniEng] receive delete InstalledEngine from pid:" + j + ", baseLibType:" + i + ", targetEngine:" + paramBundle);
        if (paramBundle == null) {
          break;
        }
        EngineInstaller.removeEngine(paramBundle);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager
 * JD-Core Version:    0.7.0.1
 */