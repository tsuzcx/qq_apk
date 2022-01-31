package com.qzone.download;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DownloadRequest
{
  private DownloadListener mListener;
  private String mPath;
  private String mUrl;
  public OutputStream outputStream;
  public Map<String, Object> params;
  public long range;
  
  public DownloadRequest(String paramString, DownloadListener paramDownloadListener)
  {
    AssertUtil.assertTrue(checkParameter(paramString));
    this.mUrl = paramString;
    this.mListener = paramDownloadListener;
  }
  
  public DownloadRequest(String paramString1, String paramString2, DownloadListener paramDownloadListener)
  {
    AssertUtil.assertTrue(checkParameter(paramString1));
    this.mUrl = paramString1;
    this.mPath = paramString2;
    this.mListener = paramDownloadListener;
  }
  
  public static boolean checkParameter(String paramString)
  {
    return checkUrl(paramString);
  }
  
  public static boolean checkUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (URLUtil.isNetworkUrl(paramString));
  }
  
  private static boolean equalsObject(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static int hashCodeObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public void addParam(String paramString, Object paramObject)
  {
    if ((paramString == null) || (paramObject == null)) {
      return;
    }
    if (this.params == null) {
      this.params = new HashMap();
    }
    this.params.put(paramString, paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof DownloadRequest))) {
        return false;
      }
      paramObject = (DownloadRequest)paramObject;
    } while ((this.mUrl.equalsIgnoreCase(paramObject.mUrl)) && (equalsObject(this.mListener, paramObject.mListener)));
    return false;
  }
  
  public DownloadListener getListener()
  {
    return this.mListener;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public int hashCode()
  {
    return (this.mUrl.hashCode() + 527) * 31 + hashCodeObject(this.mListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.DownloadRequest
 * JD-Core Version:    0.7.0.1
 */