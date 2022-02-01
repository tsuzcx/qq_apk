package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class PluginConfigProxy
  extends ServerConfigObserver
{
  private int cxg = 0;
  private final ArrayList<ServerConfigObserver> mObservers = new ArrayList();
  private ArrayList<GetResourceReqInfoV2> tr = new ArrayList();
  
  public void a(int paramInt, List<GetResourceReqInfoV2> paramList, ServerConfigObserver paramServerConfigObserver)
  {
    this.tr.addAll(paramList);
    this.cxg |= paramInt;
    if (paramServerConfigObserver != null) {
      this.mObservers.add(paramServerConfigObserver);
    }
  }
  
  public void ct(QQAppInterface paramQQAppInterface)
  {
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(this.cxg, localReqUserInfo, this.tr, this, AppSetting.getAppId());
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((this.cxg & paramInt) == 0) {}
    for (;;)
    {
      return;
      if (!this.mObservers.isEmpty())
      {
        Iterator localIterator = this.mObservers.iterator();
        while (localIterator.hasNext())
        {
          ServerConfigObserver localServerConfigObserver = (ServerConfigObserver)localIterator.next();
          ThreadManager.getSubThreadHandler().post(new CallbackRunner(localServerConfigObserver, paramBoolean, paramInt, paramGetResourceRespV2));
        }
      }
    }
  }
  
  class CallbackRunner
    implements Runnable
  {
    private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver;
    private GetResourceRespV2 jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2;
    private int cdu;
    private boolean mIsSuccess;
    
    public CallbackRunner(ServerConfigObserver paramServerConfigObserver, boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
    {
      this.jdField_a_of_type_MqqObserverServerConfigObserver = paramServerConfigObserver;
      this.mIsSuccess = paramBoolean;
      this.cdu = paramInt;
      this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2 = paramGetResourceRespV2;
    }
    
    public void run()
    {
      this.jdField_a_of_type_MqqObserverServerConfigObserver.onGetPluginConfig(this.mIsSuccess, this.cdu, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PluginConfigProxy
 * JD-Core Version:    0.7.0.1
 */