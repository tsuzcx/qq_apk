package com.tencent.av.ui;

import acdt;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

class ConferenceFlyTicketActivity$2
  implements Runnable
{
  ConferenceFlyTicketActivity$2(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString) {}
  
  public void run()
  {
    QLog.w(this.this$0.TAG, 1, "getRedirectInfo, url[" + this.val$url + "]");
    AudioHelper.rw("加入讨论组_获取讨论组签名");
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    Object localObject1 = new BasicHttpContext();
    HttpGet localHttpGet = new HttpGet(this.val$url);
    try
    {
      localDefaultHttpClient.execute(localHttpGet, (HttpContext)localObject1);
      localObject1 = ((HttpUriRequest)((HttpContext)localObject1).getAttribute("http.request")).getURI().toString();
      if (localObject2 == null) {
        break label368;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1 = localException1;
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "getRedirectInfo.run e = " + localException1);
        }
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
    }
    finally
    {
      localDefaultHttpClient.getConnectionManager().shutdown();
    }
    if (localObject2.startsWith("https://qm.qq.com/cgi-bin/dc/ft?k="))
    {
      String str = localObject2.substring("https://qm.qq.com/cgi-bin/dc/ft?k=".length());
      QLog.w(this.this$0.TAG, 1, "getRedirectInfo.run, sig[" + str + "]");
      this.this$0.a.ds(str, 0);
      return;
    }
    label368:
    this.this$0.bT(0, -161);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.2
 * JD-Core Version:    0.7.0.1
 */