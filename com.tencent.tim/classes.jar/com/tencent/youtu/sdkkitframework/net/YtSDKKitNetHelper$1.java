package com.tencent.youtu.sdkkitframework.net;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

class YtSDKKitNetHelper$1
  implements Runnable
{
  YtSDKKitNetHelper$1(YtSDKKitNetHelper paramYtSDKKitNetHelper, String paramString1, HashMap paramHashMap, String paramString2, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser) {}
  
  public void run()
  {
    Object localObject1;
    try
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(this.val$url).openConnection();
      localHttpsURLConnection.setRequestMethod("POST");
      if (this.val$requestHeader != null)
      {
        localObject1 = this.val$requestHeader.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localHttpsURLConnection.addRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
      }
      localObject1 = localIOException.getOutputStream();
    }
    catch (IOException localIOException)
    {
      YtLogger.e(YtSDKKitNetHelper.access$000(), "Network response failed " + localIOException.getLocalizedMessage());
      this.val$parser.onNetworkResponseEvent(null, localIOException);
      return;
    }
    Object localObject2 = new BufferedWriter(new OutputStreamWriter((OutputStream)localObject1, "UTF-8"));
    ((BufferedWriter)localObject2).write(this.val$requestContent);
    ((BufferedWriter)localObject2).flush();
    ((BufferedWriter)localObject2).close();
    ((OutputStream)localObject1).close();
    int i = localIOException.getResponseCode();
    if (i == 200)
    {
      localObject1 = new BufferedReader(new InputStreamReader(localIOException.getInputStream()));
      StringBuffer localStringBuffer = new StringBuffer("");
      localObject2 = ((BufferedReader)localObject1).readLine();
      if (localObject2 != null) {
        localStringBuffer.append((String)localObject2);
      }
      ((BufferedReader)localObject1).close();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("response", localStringBuffer.toString());
      this.val$parser.onNetworkResponseEvent((HashMap)localObject1, null);
      return;
    }
    YtLogger.e(YtSDKKitNetHelper.access$000(), "Network response failed " + i);
    this.val$parser.onNetworkResponseEvent(null, new Exception("Https Response Failed with code:" + i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.1
 * JD-Core Version:    0.7.0.1
 */