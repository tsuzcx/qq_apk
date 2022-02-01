package com.tencent.tmassistantsdk.internal.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.BaseService;
import com.tencent.assistant.sdk.remote.BaseService.Stub;
import com.tencent.assistant.sdk.remote.SDKActionCallback;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.e;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends com.tencent.tmdownloader.a
{
  ArrayList<a> a = new ArrayList();
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.mServiceCallback = new c(this);
  }
  
  public void a(a parama)
  {
    ab.c("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((parama != null) && (!this.a.contains(parama))) {
      this.a.add(parama);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    ab.c("TMAssistantDownloadOpenSDKClient", "sendSyncData");
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      BaseService localBaseService = (BaseService)super.getServiceInterface();
      if (localBaseService != null) {
        return localBaseService.sendSyncData(this.mClientKey, paramArrayOfByte);
      }
      super.initTMAssistantDownloadSDK();
      ab.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
    }
    return null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    ab.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData");
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      BaseService localBaseService = (BaseService)super.getServiceInterface();
      ab.c("TMAssistantDownloadOpenSDKClient", "sendAsyncData baseService:" + localBaseService);
      if (localBaseService != null)
      {
        ab.c("TMAssistantDownloadOpenSDKClient", "baseService sendAsyncData");
        localBaseService.sendAsyncData(this.mClientKey, paramArrayOfByte);
      }
    }
    else
    {
      return;
    }
    super.initTMAssistantDownloadSDK();
    ab.c("TMAssistantDownloadOpenSDKClient", "initTMAssistantDownloadSDK");
  }
  
  public Intent getBindServiceIntent()
  {
    return null;
  }
  
  public IInterface getServiceInterface()
  {
    return super.getServiceInterface();
  }
  
  public void onDownloadSDKServiceInvalid()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.a();
        }
      }
    }
  }
  
  public void registerServiceCallback()
  {
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = com.tencent.tmassistantbase.util.a.a(new e().b((byte[])localObject, this.mClientKey.getBytes()), 0);
    try
    {
      int i = ((BaseService)this.mServiceInterface).registerActionCallback(this.mClientKey, (String)localObject, (SDKActionCallback)this.mServiceCallback);
      ab.c("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
      if (i == 2) {
        onDownloadSDKServiceInvalid();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
  }
  
  public void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = BaseService.Stub.asInterface(paramIBinder);
  }
  
  public void unRegisterServiceCallback()
  {
    if (((BaseService)this.mServiceInterface).unregisterActionCallback((SDKActionCallback)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.b.b
 * JD-Core Version:    0.7.0.1
 */