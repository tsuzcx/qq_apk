package com.tencent.mobileqq.highway;

import android.content.Context;
import com.tencent.mobileqq.highway.api.TransactionOps;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class HwEngine
  implements TransactionOps, INetInfoHandler
{
  public static final boolean ISDEBUG = true;
  public AppRuntime app;
  public int appId;
  public String currentUin;
  public AtomicLong dwFlow_Wifi = new AtomicLong(0L);
  public AtomicLong dwFlow_Xg = new AtomicLong(0L);
  public ConnManager mConnManager;
  private Context mContext;
  public RequestWorker mRequestWorker;
  private HwNetSegConf mSegConfig = null;
  public TransactionWorker mTransWorker;
  public AtomicLong upFlow_Wifi = new AtomicLong(0L);
  public AtomicLong upFlow_Xg = new AtomicLong(0L);
  
  public HwEngine(Context paramContext, String paramString, int paramInt, AppRuntime paramAppRuntime)
  {
    this.mContext = paramContext;
    this.appId = paramInt;
    this.currentUin = paramString;
    this.app = paramAppRuntime;
    initHwEngine();
  }
  
  private void dumpEngineInfo()
  {
    int i = this.mTransWorker.getTransactionNum();
    int j = this.mConnManager.getCurrentConnNum();
    BdhLogUtil.LogEvent("E", "dumpEngineInfo<-- : transNum:" + i + " connNum:" + j);
  }
  
  public void cancelTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.cancelTransaction(paramTransaction);
  }
  
  public void closeEngine()
  {
    BdhLogUtil.LogEvent("E", "Close Engine.");
    this.mTransWorker.onDestroy();
    this.mRequestWorker.onDestroy();
    this.mConnManager.onDestroy();
    this.mContext = null;
    this.app = null;
  }
  
  public Context getAppContext()
  {
    return this.mContext;
  }
  
  public HwNetSegConf getCurrentConfig()
  {
    HwNetSegConf localHwNetSegConf2 = this.mSegConfig;
    HwNetSegConf localHwNetSegConf1 = localHwNetSegConf2;
    if (localHwNetSegConf2 == null)
    {
      localHwNetSegConf1 = ConfigManager.getInstance(getAppContext(), this.app, this.appId, this.currentUin).getNetSegConf(getAppContext());
      this.mSegConfig = localHwNetSegConf1;
    }
    return localHwNetSegConf1;
  }
  
  public void initHwEngine()
  {
    this.mConnManager = new ConnManager(this);
    this.mRequestWorker = new RequestWorker(this);
    this.mTransWorker = new TransactionWorker(this);
    this.mConnManager.onInit();
    this.mRequestWorker.onInit();
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
  }
  
  public void onNetMobile2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2None");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetMobile2Wifi()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2Wifi");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetNone2Mobile()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Mobile");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetNone2Wifi()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Wifi");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetWifi2Mobile()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2Mobile");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetWifi2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2None");
    this.mSegConfig = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this.app, this.appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void preConnect()
  {
    BdhLogUtil.LogEvent("E", "preConnect.");
    this.mRequestWorker.sendConnectRequest(0L, true);
  }
  
  public void resumeTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.resumeTransaction(paramTransaction);
  }
  
  public void stopTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.stopTransaction(paramTransaction);
  }
  
  public int submitTransactionTask(Transaction paramTransaction)
  {
    int i = this.mTransWorker.submitTransation(paramTransaction);
    dumpEngineInfo();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.HwEngine
 * JD-Core Version:    0.7.0.1
 */