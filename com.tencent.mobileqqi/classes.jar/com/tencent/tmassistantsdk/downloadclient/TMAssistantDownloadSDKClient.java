package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.a.a;
import com.tencent.tmassistantsdk.a.d;
import com.tencent.tmassistantsdk.f.j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient
  extends f
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue mListenerReferenceQueue = new ReferenceQueue();
  protected ArrayList mWeakListenerArrayList = new ArrayList();
  
  public TMAssistantDownloadSDKClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService");
    this.mServiceCallback = new e(this);
  }
  
  public static String about()
  {
    return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      j.b("TMAssistantDownloadSDKClient", "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null) {
      locald.c(this.mClientKey, paramString);
    }
    for (;;)
    {
      return;
      super.initTMAssistantDownloadSDK();
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      j.b("TMAssistantDownloadSDKClient", "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null) {}
    for (paramString = locald.a(this.mClientKey, paramString);; paramString = null)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)((WeakReference)localIterator.next()).get();
      g.a();
      g.a(this, localITMAssistantDownloadSDKClientListener);
    }
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      j.b("TMAssistantDownloadSDKClient", "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null) {
      locald.b(this.mClientKey, paramString);
    }
    for (;;)
    {
      return;
      super.initTMAssistantDownloadSDK();
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadSDKClientListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject;
      try
      {
        for (;;)
        {
          localObject = this.mListenerReferenceQueue.poll();
          if (localObject == null) {
            break;
          }
          j.b("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadSDKClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadSDKClientListener)
          {
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadSDKClientListener = new WeakReference(paramITMAssistantDownloadSDKClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadSDKClientListener);
      bool = true;
    }
  }
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (a)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, int paramInt, String paramString2, String paramString3, Map paramMap)
  {
    try
    {
      j.b("TMAssistantDownloadSDKClient", "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString1);
      if (paramString1 == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    if ((paramString2.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
    }
    d locald = (d)super.getServiceInterface();
    if (locald != null) {}
    for (paramInt = locald.a(this.mClientKey, paramString1, 0, paramString2, paramString3, paramMap);; paramInt = 0)
    {
      return paramInt;
      super.initTMAssistantDownloadSDK();
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      int i = startDownloadTask(paramString1, 0, paramString2, null, null);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = startDownloadTask(paramString1, 0, paramString2, paramString3, null);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, Map paramMap)
  {
    try
    {
      int i = startDownloadTask(paramString1, 0, paramString2, null, paramMap);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = com.tencent.tmassistantsdk.a.e.a(paramIBinder);
  }
  
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadSDKClientListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        Iterator localIterator = this.mWeakListenerArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((ITMAssistantDownloadSDKClientListener)localWeakReference.get() == paramITMAssistantDownloadSDKClientListener)
            {
              this.mWeakListenerArrayList.remove(localWeakReference);
              bool = true;
              break;
            }
          }
        }
        bool = false;
      }
      finally {}
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient
 * JD-Core Version:    0.7.0.1
 */