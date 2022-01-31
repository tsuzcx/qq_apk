package com.qzone.download.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qzone.cache.file.FileCacheService;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.utils.Utils;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class ImageResumeDownloadProcessor
  implements DownloaderImpl.ResumeDownloadProcessor
{
  private FileCacheService mCache;
  private Map<String, CacheFileAttribute> mCacheAttributes = new HashMap();
  private boolean mCheckContentType = false;
  private Context mContext;
  public Map<String, Pattern> mDominPatterns = new HashMap();
  public boolean mForceEnable = false;
  private final Object mLock = new Object();
  private String mName;
  private SharedPreferences mSharePre;
  
  public ImageResumeDownloadProcessor(Context paramContext, String paramString, FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mName = paramString;
    this.mCache = paramFileCacheService;
    this.mCheckContentType = paramBoolean;
    initUrlPatterns();
    if (this.mCheckContentType)
    {
      this.mSharePre = PreferenceManager.getDefaultSharedPreferences(DownloaderFactory.getContext());
      loadConfig();
    }
  }
  
  private boolean checkContentRange(String paramString, HttpResponse paramHttpResponse)
  {
    if ((paramHttpResponse == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206)) {
      return true;
    }
    long l1 = 0L;
    l3 = 0L;
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity != null) {
      l1 = localHttpEntity.getContentLength();
    }
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Range");
    l2 = l3;
    int i;
    if (paramHttpResponse != null)
    {
      paramHttpResponse = paramHttpResponse.getValue();
      l2 = l3;
      if (!TextUtils.isEmpty(paramHttpResponse)) {
        i = paramHttpResponse.indexOf("/");
      }
    }
    try
    {
      i = Integer.valueOf(paramHttpResponse.substring(i + 1)).intValue();
      l2 = i;
    }
    catch (Exception paramHttpResponse)
    {
      for (;;)
      {
        long l4;
        l2 = l3;
      }
    }
    paramString = getTmpCacheFileName(paramString);
    paramString = this.mCache.getFile(paramString);
    l4 = 0L;
    l3 = l4;
    if (paramString != null)
    {
      l3 = l4;
      if (paramString.exists()) {
        l3 = paramString.length();
      }
    }
    QDLog.i("downloader", "download content range check --- content_range:" + l2 + " content_length:" + l1 + " tmpfile_size:" + l3);
    return l3 + l1 == l2;
  }
  
  private String getTmpCacheFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return String.valueOf(paramString.hashCode());
  }
  
  private CacheFileAttribute getTmpFileAttr(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {
      return null;
    }
    return (CacheFileAttribute)this.mCacheAttributes.get(paramString);
  }
  
  private String getTmpFileContentType(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {}
    do
    {
      return null;
      paramString = (CacheFileAttribute)this.mCacheAttributes.get(paramString);
    } while (paramString == null);
    return paramString.ContentType;
  }
  
  private void initUrlPatterns()
  {
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = ".*qzonestyle.gtimg.cn";
    arrayOfString[3] = ".*qzs.qq.com";
    arrayOfString[4] = ".*i.gtimg.cn";
    arrayOfString[5] = "a\\d+.photo.store.qq.com";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length) {
        return;
      }
      Pattern localPattern = Pattern.compile(arrayOfString[i], 2);
      this.mDominPatterns.put(arrayOfString[i], localPattern);
      i += 1;
    }
  }
  
  private boolean isCacheFileVaild(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    long l;
    do
    {
      return false;
      l = paramFile.lastModified();
      l = System.currentTimeMillis() - l;
    } while ((l < 0L) || (l > 86400000L));
    return true;
  }
  
  private void loadConfig()
  {
    this.mCacheAttributes = ((Map)Utils.convertToObject(this.mSharePre.getString("contenttype_" + this.mName, null)));
    if (this.mCacheAttributes == null) {
      this.mCacheAttributes = new HashMap();
    }
  }
  
  private CacheFileAttribute parseAttrs(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return null;
    }
    Object localObject2 = null;
    Header localHeader = null;
    Object localObject3 = paramHttpResponse.getEntity();
    Object localObject1 = localHeader;
    if (localObject3 != null)
    {
      localObject3 = ((HttpEntity)localObject3).getContentType();
      localObject1 = localHeader;
      if (localObject3 != null) {
        localObject1 = ((Header)localObject3).getValue();
      }
    }
    localHeader = paramHttpResponse.getFirstHeader("Last-Modified");
    paramHttpResponse = localObject2;
    if (localHeader != null) {
      paramHttpResponse = localHeader.getValue();
    }
    return new CacheFileAttribute((String)localObject1, paramHttpResponse);
  }
  
  private void saveConfig()
  {
    String str = Utils.convertToString(this.mCacheAttributes);
    this.mSharePre.edit().putString("contenttype_" + this.mName, str).commit();
  }
  
  private boolean supportResumeDownload(String paramString)
  {
    boolean bool1;
    if (this.mForceEnable)
    {
      bool1 = true;
      return bool1;
    }
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = Utils.getDomin(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.mDominPatterns.entrySet().iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!Utils.match((Pattern)((Map.Entry)localIterator.next()).getValue(), paramString));
    return true;
  }
  
  public void addCacheTmpFile(String paramString1, String arg2, HttpResponse paramHttpResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.mCache.putFile(getTmpCacheFileName(paramString1))) || (!this.mCheckContentType) || (paramHttpResponse == null));
    paramHttpResponse = parseAttrs(paramHttpResponse);
    StringBuilder localStringBuilder = new StringBuilder("Downloader Resume Response url:").append(paramString1).append(" curr:");
    if (paramHttpResponse != null) {}
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      QDLog.i("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.mLock)
      {
        this.mCacheAttributes.put(getTmpCacheFileName(paramString1), paramHttpResponse);
        saveConfig();
        return;
      }
    }
  }
  
  public String getResumeTmpFile(String paramString)
  {
    paramString = this.mCache.getFile(getTmpCacheFileName(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public boolean handleResponse(String paramString, HttpResponse paramHttpResponse)
  {
    if ((!this.mCheckContentType) || (!supportResumeDownload(paramString))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || (paramHttpResponse == null)) {
      return false;
    }
    if (!checkContentRange(paramString, paramHttpResponse)) {
      return false;
    }
    CacheFileAttribute localCacheFileAttribute = getTmpFileAttr(paramString);
    if (localCacheFileAttribute == null) {
      return true;
    }
    paramHttpResponse = parseAttrs(paramHttpResponse);
    StringBuilder localStringBuilder = new StringBuilder("download content-type check url:").append(paramString).append(" old:");
    if (localCacheFileAttribute != null)
    {
      paramString = localCacheFileAttribute.toString();
      localStringBuilder = localStringBuilder.append(paramString).append(" curr:");
      if (paramHttpResponse == null) {
        break label144;
      }
    }
    label144:
    for (paramString = paramHttpResponse.toString();; paramString = "N/A")
    {
      QDLog.i("downloader", paramString);
      if (!localCacheFileAttribute.equals(paramHttpResponse)) {
        break label151;
      }
      return true;
      paramString = "N/A";
      break;
    }
    label151:
    return false;
  }
  
  public void onDownloadResult(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.mCache)
      {
        this.mCache.deleteFile(getTmpCacheFileName(paramString));
        if (!this.mCheckContentType) {}
      }
    }
    synchronized (this.mLock)
    {
      if (this.mCacheAttributes.containsKey(getTmpCacheFileName(paramString)))
      {
        this.mCacheAttributes.remove(getTmpCacheFileName(paramString));
        saveConfig();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void prepareRequest(HttpGet paramHttpGet, String paramString)
  {
    if (!supportResumeDownload(paramString)) {
      return;
    }
    String str = getTmpCacheFileName(paramString);
    File localFile = this.mCache.getFile(str);
    long l2 = 0L;
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists())
      {
        if (!isCacheFileVaild(localFile)) {
          break label158;
        }
        l1 = localFile.length();
      }
    }
    str = getTmpFileContentType(paramString);
    if (l1 > 0L)
    {
      if (this.mCheckContentType) {
        break label173;
      }
      paramHttpGet.addHeader("Range", "bytes=" + l1 + "-");
    }
    for (;;)
    {
      QDLog.i("downloader", "Downloader Resume --- begin range:" + l1 + " Accept:" + str + " url:" + paramString);
      return;
      label158:
      this.mCache.deleteFile(str);
      l1 = l2;
      break;
      label173:
      if (!TextUtils.isEmpty(str))
      {
        paramHttpGet.addHeader("Range", "bytes=" + l1 + "-");
        paramHttpGet.addHeader("Accept", str);
        paramHttpGet.addHeader("Q-Accept", str);
      }
    }
  }
  
  public static class CacheFileAttribute
    implements Serializable
  {
    public String ContentType;
    public String LastModifyTime;
    
    public CacheFileAttribute(String paramString1, String paramString2)
    {
      this.ContentType = paramString1;
      this.LastModifyTime = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof CacheFileAttribute))) {
          break;
        }
        paramObject = (CacheFileAttribute)paramObject;
      } while ((TextUtils.equals(this.ContentType, paramObject.ContentType)) && (TextUtils.equals(this.LastModifyTime, paramObject.LastModifyTime)));
      return false;
      return false;
    }
    
    public String toString()
    {
      return "CacheFileAttr --- ContentType:" + this.ContentType + " LastModify:" + this.LastModifyTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.ImageResumeDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */