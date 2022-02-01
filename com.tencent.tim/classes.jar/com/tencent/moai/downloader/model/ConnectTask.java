package com.tencent.moai.downloader.model;

import android.util.Log;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.moai.downloader.exception.ConnectTaskError;
import com.tencent.moai.downloader.listener.ConnectTaskListener;
import com.tencent.moai.downloader.network.DefaultHttpClient;
import com.tencent.moai.downloader.thread.ThreadManager;
import com.tencent.moai.downloader.util.Logger;
import java.util.List;
import java.util.Map;

public class ConnectTask
  implements ConnectInterface, Runnable
{
  private static final String TAG = "ConnectTask";
  private ConnectStatus connectStatus;
  private ConnectTaskListener listener;
  private String url;
  
  public ConnectTask(String paramString)
  {
    this.url = paramString;
    this.connectStatus = new ConnectStatus();
  }
  
  private void parseResponse(Map<String, List<String>> paramMap, boolean paramBoolean)
  {
    paramMap = (List)paramMap.get("Content-Length");
    if ((paramMap != null) && (paramMap.size() > 0)) {}
    for (long l = Long.parseLong((String)paramMap.get(0));; l = 0L)
    {
      this.connectStatus.setStatus(1);
      this.listener.onConnectSuccess(this.url, l, paramBoolean);
      return;
    }
  }
  
  public void connect()
  {
    ThreadManager.shareInstance().start(this);
  }
  
  public ConnectStatus getConnectStatus()
  {
    return this.connectStatus;
  }
  
  public ConnectTaskListener getListener()
  {
    return this.listener;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isConnected()
  {
    return this.connectStatus.getStatus() == 1;
  }
  
  public boolean isConnecting()
  {
    return this.connectStatus.getStatus() == 0;
  }
  
  public void run()
  {
    this.connectStatus.setStatus(0);
    this.listener.onConnecting(this.url);
    Object localObject = new Request.Builder();
    ((Request.Builder)localObject).addHeader("range", "bytes=0-");
    ((Request.Builder)localObject).url(this.url);
    localObject = ((Request.Builder)localObject).build();
    try
    {
      localObject = DefaultHttpClient.shareInstance().getClient().newCall((Request)localObject).execute();
      int i = ((Response)localObject).code();
      if (i == 200)
      {
        parseResponse(((Response)localObject).headers().toMultimap(), false);
        return;
      }
      if (i == 206)
      {
        parseResponse(((Response)localObject).headers().toMultimap(), true);
        return;
      }
    }
    catch (Exception localException)
    {
      this.connectStatus.setStatus(2);
      this.listener.onConnectError(this.url, new ConnectTaskError(3, "connect error"));
      Logger.e("ConnectTask", Log.getStackTraceString(localException));
      return;
    }
    this.connectStatus.setStatus(2);
    this.listener.onConnectError(getUrl(), new ConnectTaskError(3, "connect error"));
  }
  
  public void setConnectStatus(ConnectStatus paramConnectStatus)
  {
    this.connectStatus = paramConnectStatus;
  }
  
  public void setListener(ConnectTaskListener paramConnectTaskListener)
  {
    this.listener = paramConnectTaskListener;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.ConnectTask
 * JD-Core Version:    0.7.0.1
 */