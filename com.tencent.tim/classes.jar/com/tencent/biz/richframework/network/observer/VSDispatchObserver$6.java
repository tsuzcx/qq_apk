package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import ram;
import rwy;
import rwz;
import rxc;

public class VSDispatchObserver$6
  implements Runnable
{
  public VSDispatchObserver$6(rxc paramrxc, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.a.getRequestKey();
      ram.d("VSNetworkHelper| Protocol Cache", this.a.getCmdName() + " saveCache CacheKey:" + str);
      rwz.a().a(str, new ByteArrayInputStream(this.bO));
      ram.i("VSNetworkHelper| Protocol Cache", this.a.getCmdName() + " saveCache success");
      return;
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.6
 * JD-Core Version:    0.7.0.1
 */