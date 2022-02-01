package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import rxc;
import rxc.a;

public class VSDispatchObserver$7
  implements Runnable
{
  public VSDispatchObserver$7(rxc paramrxc, VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro) {}
  
  public void run()
  {
    try
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)rxc.a(this.this$0).get(Integer.valueOf(this.a.getContextHashCode()));
      int i = this.a.getCurrentSeq();
      if (localConcurrentHashMap != null)
      {
        if (localConcurrentHashMap.get(Integer.valueOf(i)) == null)
        {
          QLog.d("VSNetworkHelper| Protocol Cache", 1, String.format("VSDispatchObserver: onReceive: CmdName:%s Seq:%d CallBack is Null or has Removed", new Object[] { this.a.getCmdName(), Integer.valueOf(this.a.getCurrentSeq()) }));
          return;
        }
        ((rxc.a)localConcurrentHashMap.get(Integer.valueOf(i))).a(true, 0L, "_VSNetworkHelperCache", this.c);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
      return;
    }
    QLog.d("VSNetworkHelper| Protocol Cache", 1, "VSDispatchObserver: onReceive: current context callbacks has all removed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.7
 * JD-Core Version:    0.7.0.1
 */