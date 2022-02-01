package com.tencent.moai.downloader.network;

import com.tencent.moai.downloader.algorithm.Hash;
import java.util.List;
import java.util.Map;

public class HttpRequest
{
  private long id;
  private List<HttpFileEntity> requestFile;
  private Map<String, String> requestHeader;
  private HttpListener requestListener;
  private HttpMethod requestMethod;
  private String requestParam;
  private HttpStatus requestStatus;
  private String requestUrl;
  
  public HttpRequest(String paramString)
  {
    this.requestUrl = paramString;
    this.requestMethod = HttpMethod.HttpMethod_GET;
    this.requestStatus = new HttpStatus(0);
  }
  
  public HttpRequest(String paramString1, String paramString2)
  {
    this.requestUrl = paramString1;
    this.requestParam = paramString2;
    this.requestMethod = HttpMethod.HttpMethod_POST;
    this.requestStatus = new HttpStatus(0);
  }
  
  public HttpRequest(String paramString1, String paramString2, List<HttpFileEntity> paramList)
  {
    this.requestUrl = paramString1;
    this.requestParam = paramString2;
    this.requestFile = paramList;
    this.requestMethod = HttpMethod.HttpMethod_MULTIPART;
    this.requestStatus = new HttpStatus(0);
  }
  
  public static long generateId(String paramString1, Map<String, String> paramMap, HttpMethod paramHttpMethod, String paramString2)
  {
    if (paramMap == null)
    {
      paramMap = "";
      if (paramHttpMethod != null) {
        break label74;
      }
      paramHttpMethod = "";
      label14:
      if (paramString2 != null) {
        break label82;
      }
    }
    label74:
    label82:
    for (paramString2 = "";; paramString2 = paramString2.toString())
    {
      return Hash.hashLong(paramString1 + "_" + paramMap + "_" + paramHttpMethod + "_" + paramString2);
      paramMap = paramMap.toString();
      break;
      paramHttpMethod = paramHttpMethod.toString();
      break label14;
    }
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public List<HttpFileEntity> getRequestFile()
  {
    return this.requestFile;
  }
  
  public Map<String, String> getRequestHeader()
  {
    return this.requestHeader;
  }
  
  public HttpListener getRequestListener()
  {
    return this.requestListener;
  }
  
  public HttpMethod getRequestMethod()
  {
    return this.requestMethod;
  }
  
  public String getRequestParam()
  {
    return this.requestParam;
  }
  
  public HttpStatus getRequestStatus()
  {
    return this.requestStatus;
  }
  
  public String getRequestUrl()
  {
    return this.requestUrl;
  }
  
  public void onAbort(HttpError paramHttpError)
  {
    if (this.requestListener != null) {
      this.requestListener.onAbort(this, paramHttpError);
    }
  }
  
  public void onComplete(HttpResponse paramHttpResponse, HttpError paramHttpError)
  {
    if (this.requestListener != null) {
      this.requestListener.onComplete(this, paramHttpResponse, paramHttpError);
    }
  }
  
  public void onError(HttpError paramHttpError, HttpResponse paramHttpResponse)
  {
    if (this.requestListener != null) {
      this.requestListener.onFail(this, paramHttpError, paramHttpResponse);
    }
  }
  
  public void onPostData(long paramLong1, long paramLong2)
  {
    if (this.requestListener != null) {
      this.requestListener.onPostData(this, paramLong1, paramLong2);
    }
  }
  
  public void onPrepare()
  {
    if (this.requestListener != null) {
      this.requestListener.onPrepare(this);
    }
  }
  
  public void onReceiveData(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    if (this.requestListener != null) {
      this.requestListener.onReceiveData(this, paramArrayOfByte, paramLong1, paramLong2);
    }
  }
  
  public boolean onReceiveHeader(Map<String, List<String>> paramMap)
  {
    if (this.requestListener != null) {
      return this.requestListener.onReceiveHeader(this, paramMap);
    }
    return true;
  }
  
  public void onSuccess(HttpResponse paramHttpResponse)
  {
    if (this.requestListener != null) {
      this.requestListener.onSuccess(this, paramHttpResponse);
    }
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setRequestFile(List<HttpFileEntity> paramList)
  {
    this.requestFile = paramList;
  }
  
  public void setRequestHeader(Map<String, String> paramMap)
  {
    this.requestHeader = paramMap;
  }
  
  public void setRequestListener(HttpListener paramHttpListener)
  {
    this.requestListener = paramHttpListener;
  }
  
  public void setRequestMethod(HttpMethod paramHttpMethod)
  {
    this.requestMethod = paramHttpMethod;
  }
  
  public void setRequestParam(String paramString)
  {
    this.requestParam = paramString;
  }
  
  public void setRequestStatus(HttpStatus paramHttpStatus)
  {
    this.requestStatus = paramHttpStatus;
  }
  
  public void setRequestUrl(String paramString)
  {
    this.requestUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpRequest
 * JD-Core Version:    0.7.0.1
 */