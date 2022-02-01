package com.tencent.biz.richframework.network.servlet;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import ram;
import rwy;
import rwy.a;
import rwz;
import rxc;
import rxh;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(rxh paramrxh, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.b.getRequestKey();
      localObject = rwz.a().a((String)localObject);
      if ((localObject == null) || (((rwy.a)localObject).getInputStream() == null))
      {
        ram.d("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.b.decode(rxh.a(this.this$0, ((rwy.a)localObject).getInputStream()));
      VSNetworkHelper.a().a(this.b, (MessageMicro)localObject);
      ram.d("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      ram.w("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */