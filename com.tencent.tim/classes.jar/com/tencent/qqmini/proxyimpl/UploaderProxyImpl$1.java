package com.tencent.qqmini.proxyimpl;

import asum;
import asxd;
import asxe;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class UploaderProxyImpl$1
  implements Runnable
{
  public UploaderProxyImpl$1(asxd paramasxd, String paramString1, Map paramMap1, String paramString2, Map paramMap2, String paramString3, String paramString4, UploaderProxy.UploadListener paramUploadListener) {}
  
  public void run()
  {
    Object localObject = MiniOkHttpClientFactory.getUploadClient();
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.tag(localObject).url(this.val$url).addHeader("Charset", "utf-8").addHeader("connection", "keep-alive");
    if (this.val$header != null)
    {
      Iterator localIterator = this.val$header.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.addHeader(str, (String)this.val$header.get(str));
      }
    }
    localBuilder.method("POST", asum.a(this.val$filePath, this.pm, this.val$name, this.cFV, this.a));
    localObject = ((OkHttpClient)localObject).newCall(localBuilder.build());
    ((Call)localObject).enqueue(new asxe(this));
    this.this$0.taskMap.put(this.val$url, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */