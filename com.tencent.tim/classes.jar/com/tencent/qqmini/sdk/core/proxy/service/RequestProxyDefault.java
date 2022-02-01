package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HttpsURLConnection;

@ProxyService(proxy=RequestProxy.class)
public class RequestProxyDefault
  extends RequestProxy
{
  public ConcurrentHashMap<String, RequestTask> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    ((RequestTask)this.taskMap.get(paramString)).mAbort = true;
    this.taskMap.remove(paramString);
  }
  
  public boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    paramArrayOfByte = new RequestTask(paramString1, paramArrayOfByte, paramMap, paramString2.toUpperCase(), paramInt, paramRequestListener);
    this.taskMap.put(paramString1, paramArrayOfByte);
    ThreadManager.executeOnNetworkIOThreadPool(paramArrayOfByte);
    return true;
  }
  
  public class RequestTask
    implements Runnable
  {
    public volatile boolean mAbort;
    public byte[] mBodyData;
    public Map<String, String> mHeader;
    public RequestProxy.RequestListener mListener;
    public String mMethod;
    public int mTimeout;
    public String mUrl;
    
    public RequestTask(byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString, int paramInt, RequestProxy.RequestListener paramRequestListener)
    {
      if (paramMap != null)
      {
        this.mBodyData = new byte[paramMap.length];
        System.arraycopy(paramMap, 0, this.mBodyData, 0, paramMap.length);
      }
      this.mUrl = paramArrayOfByte;
      this.mHeader = paramString;
      this.mMethod = paramInt;
      this.mTimeout = paramRequestListener;
      Object localObject;
      this.mListener = localObject;
    }
    
    public void run()
    {
      Object localObject1;
      Object localObject2;
      int i;
      for (;;)
      {
        byte[] arrayOfByte;
        int j;
        try
        {
          HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(this.mUrl).openConnection();
          localHttpsURLConnection.setConnectTimeout(this.mTimeout * 1000);
          localHttpsURLConnection.setRequestMethod(this.mMethod);
          if (this.mHeader != null)
          {
            localObject1 = this.mHeader.keySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localHttpsURLConnection.setRequestProperty((String)localObject2, (String)this.mHeader.get(localObject2));
              continue;
            }
          }
          RequestProxyDefault.this.taskMap.remove(this.mUrl);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          RequestProxyDefault.this.taskMap.remove(this.mUrl);
          this.mListener.onRequestFailed(-1, localMalformedURLException.getMessage());
          return;
          if ((this.mBodyData != null) && (this.mMethod.equalsIgnoreCase("POST")))
          {
            localMalformedURLException.setDoOutput(true);
            localObject1 = localMalformedURLException.getOutputStream();
            ((OutputStream)localObject1).write(this.mBodyData);
            ((OutputStream)localObject1).close();
          }
          i = localMalformedURLException.getResponseCode();
          if (this.mAbort) {
            continue;
          }
          this.mListener.onRequestHeadersReceived(i, localMalformedURLException.getHeaderFields());
          if (i == 200)
          {
            localObject1 = localMalformedURLException.getInputStream();
            localObject2 = new ByteArrayOutputStream();
            arrayOfByte = new byte[4096];
            j = ((InputStream)localObject1).read(arrayOfByte);
            if (j == -1) {
              break;
            }
            if (!this.mAbort) {
              break label338;
            }
            ((InputStream)localObject1).close();
            ((ByteArrayOutputStream)localObject2).close();
            return;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          RequestProxyDefault.this.taskMap.remove(this.mUrl);
          this.mListener.onRequestFailed(-2, localIOException.getMessage());
          return;
        }
        this.mListener.onRequestFailed(localIOException.getResponseCode(), "http error code");
        return;
        label338:
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, j);
      }
      ((InputStream)localObject1).close();
      ((ByteArrayOutputStream)localObject2).close();
      localIOException.disconnect();
      RequestProxyDefault.this.taskMap.remove(this.mUrl);
      this.mListener.onRequestSucceed(i, ((ByteArrayOutputStream)localObject2).toByteArray(), localIOException.getHeaderFields());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault
 * JD-Core Version:    0.7.0.1
 */