package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.cache.a.b;
import com.tencent.component.network.utils.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public final class QzoneResumeTransfer
  implements ResumeTransfer
{
  private Context a;
  private String b;
  private b c;
  private boolean d = false;
  private Map<String, CacheFileAttribute> e = new ConcurrentHashMap();
  private final Object f = new Object();
  private SharedPreferences g;
  private Map<String, Pattern> h = new HashMap();
  private List<String> i = Collections.synchronizedList(new ArrayList());
  
  public QzoneResumeTransfer(Context paramContext, String paramString, b paramb)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramb;
    this.d = true;
    b();
    if (this.d)
    {
      this.g = PreferenceManager.getDefaultSharedPreferences(this.a);
      paramb = this.g.getString("contenttype_" + this.b, null);
      if (paramb != null)
      {
        paramContext = localObject2;
        paramString = localObject1;
      }
    }
    try
    {
      paramb = Const.a(Base64.decode(paramb, 0));
      paramContext = paramb;
      paramString = paramb;
      this.e.clear();
      paramContext = paramb;
      paramString = paramb;
      paramb.readMap(this.e, this.a.getClassLoader());
    }
    catch (Throwable paramb)
    {
      for (;;)
      {
        paramString = paramContext;
        Const.d("download", "download", paramb);
        if (paramContext != null) {
          paramContext.recycle();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label243;
      }
      paramString.recycle();
    }
    if (this.e == null) {
      this.e = new HashMap();
    }
  }
  
  private static CacheFileAttribute a(HttpResponse paramHttpResponse)
  {
    Object localObject2 = null;
    if (paramHttpResponse == null) {
      return null;
    }
    Object localObject1 = paramHttpResponse.getEntity();
    if (localObject1 != null)
    {
      localObject1 = ((HttpEntity)localObject1).getContentType();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Header)localObject1).getValue();; localObject1 = null)
    {
      Header localHeader = paramHttpResponse.getFirstHeader("Last-Modified");
      paramHttpResponse = localObject2;
      if (localHeader != null) {
        paramHttpResponse = localHeader.getValue();
      }
      return new CacheFileAttribute((String)localObject1, paramHttpResponse);
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return String.valueOf(paramString.hashCode());
  }
  
  private void a()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localObject3 = localParcel;
      localParcel.writeMap(this.e);
      localObject1 = localParcel;
      localObject3 = localParcel;
      String str = new String(Base64.encode(localParcel.marshall(), 0));
      localObject1 = localParcel;
      localObject3 = localParcel;
      this.g.edit().putString("contenttype_" + this.b, str).commit();
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Const.b("download", "download", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.recycle();
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    while (this.i.contains(paramString2)) {
      return bool;
    }
    paramString1 = this.h.entrySet().iterator();
    if (!paramString1.hasNext()) {}
    for (bool = false;; bool = true)
    {
      return bool;
      if (!Const.a((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2)) {
        break;
      }
      this.i.add(paramString2);
    }
  }
  
  private boolean a(String paramString, HttpResponse paramHttpResponse)
  {
    long l4 = 0L;
    if ((paramHttpResponse == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206)) {
      return true;
    }
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity != null) {}
    for (long l1 = localHttpEntity.getContentLength();; l1 = 0L)
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Range");
      int j;
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        if (!TextUtils.isEmpty(paramHttpResponse)) {
          j = paramHttpResponse.indexOf("/");
        }
      }
      for (;;)
      {
        try
        {
          j = Integer.valueOf(paramHttpResponse.substring(j + 1)).intValue();
          l2 = j;
          paramString = a(paramString);
          paramString = this.c.b(paramString);
          long l3 = l4;
          if (paramString != null)
          {
            l3 = l4;
            if (paramString.exists()) {
              l3 = paramString.length();
            }
          }
          if (l1 + l3 != l2) {
            break;
          }
          return true;
        }
        catch (Exception paramHttpResponse) {}
        long l2 = 0L;
      }
      return false;
    }
  }
  
  private void b()
  {
    int j = 0;
    String[] arrayOfString = new String[9];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = ".*qzonestyle.gtimg.cn";
    arrayOfString[3] = ".*qzs.qq.com";
    arrayOfString[4] = ".*i.gtimg.cn";
    arrayOfString[5] = "a\\d+.photo.store.qq.com";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    arrayOfString[7] = "vqzone.tc.qq.com";
    arrayOfString[8] = "vwecam.tc.qq.com";
    for (;;)
    {
      if (j >= 9) {
        return;
      }
      Pattern localPattern = Pattern.compile(arrayOfString[j], 2);
      this.h.put(arrayOfString[j], localPattern);
      j += 1;
    }
  }
  
  public final void addCacheTmpFile(String paramString1, String arg2, HttpResponse paramHttpResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.c.c(a(paramString1))) || (!this.d) || (paramHttpResponse == null));
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder = new StringBuilder("Downloader Resume Response url:").append(paramString1).append(" curr:");
    if (paramHttpResponse != null) {}
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      Const.b("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.f)
      {
        if (!paramHttpResponse.equals((CacheFileAttribute)this.e.get(a(paramString1))))
        {
          this.e.put(a(paramString1), paramHttpResponse);
          a();
        }
        return;
      }
    }
  }
  
  public final String getResumeTmpFile(String paramString)
  {
    paramString = this.c.b(a(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public final boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    if ((!this.d) || (!a(paramString1, paramString2))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramHttpResponse == null)) {
      return false;
    }
    if (!a(paramString1, paramHttpResponse)) {
      return false;
    }
    paramString2 = a(paramString1);
    if (paramString2 == null) {}
    for (paramString2 = null; paramString2 == null; paramString2 = (CacheFileAttribute)this.e.get(paramString2)) {
      return true;
    }
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder = new StringBuilder("download content-type check url:").append(paramString1).append(" old:");
    if (paramString2 != null)
    {
      paramString1 = paramString2.toString();
      localStringBuilder = localStringBuilder.append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label167;
      }
    }
    label167:
    for (paramString1 = paramHttpResponse.toString();; paramString1 = "N/A")
    {
      Const.c("downloader", paramString1);
      if (!paramString2.equals(paramHttpResponse)) {
        break label174;
      }
      return true;
      paramString1 = "N/A";
      break;
    }
    label174:
    return false;
  }
  
  public final void onDownloadResult(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.c)
      {
        this.c.d(a(paramString));
        if (!this.d) {}
      }
    }
    synchronized (this.f)
    {
      if (this.e.containsKey(a(paramString)))
      {
        this.e.remove(a(paramString));
        a();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void prepareRequest(HttpGet paramHttpGet, String paramString1, String paramString2)
  {
    int k = 0;
    if (!a(paramString1, paramString2)) {
      return;
    }
    paramString2 = a(paramString1);
    File localFile = this.c.b(paramString2);
    int j;
    long l;
    if ((localFile != null) && (localFile.exists()))
    {
      j = k;
      if (localFile != null)
      {
        if (!localFile.exists()) {
          j = k;
        }
      }
      else
      {
        if (j == 0) {
          break label241;
        }
        l = localFile.length();
        label74:
        paramString2 = a(paramString1);
        if (paramString2 == null) {
          break label255;
        }
        paramString2 = (CacheFileAttribute)this.e.get(paramString2);
        if (paramString2 == null) {
          break label255;
        }
        paramString2 = paramString2.a;
        label106:
        if (l > 0L)
        {
          if (this.d) {
            break label260;
          }
          paramHttpGet.addHeader("Range", "bytes=" + l + "-");
        }
      }
    }
    for (;;)
    {
      Const.c("downloader", "Downloader Resume --- begin range:" + l + " Accept:" + paramString2 + " url:" + paramString1);
      return;
      l = localFile.lastModified();
      l = System.currentTimeMillis() - l;
      j = k;
      if (l < 0L) {
        break;
      }
      j = k;
      if (l > 86400000L) {
        break;
      }
      j = 1;
      break;
      label241:
      this.c.d(paramString2);
      l = 0L;
      break label74;
      label255:
      paramString2 = null;
      break label106;
      label260:
      if (!TextUtils.isEmpty(paramString2))
      {
        paramHttpGet.addHeader("Range", "bytes=" + l + "-");
        paramHttpGet.addHeader("Accept", paramString2);
        paramHttpGet.addHeader("Q-Accept", paramString2);
      }
    }
  }
  
  public static class CacheFileAttribute
    implements Parcelable
  {
    public static final Parcelable.Creator<CacheFileAttribute> CREATOR = new a();
    public String a;
    private String b;
    
    public CacheFileAttribute(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
    }
    
    public CacheFileAttribute(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
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
      } while ((TextUtils.equals(this.a, paramObject.a)) && (TextUtils.equals(this.b, paramObject.b)));
      return false;
      return false;
    }
    
    public String toString()
    {
      return "CacheFileAttr --- ContentType:" + this.a + " LastModify:" + this.b;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.a);
      paramParcel.writeString(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer
 * JD-Core Version:    0.7.0.1
 */