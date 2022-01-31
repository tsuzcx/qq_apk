package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.a.a.a.b;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  extends f
{
  ArrayList a = new ArrayList();
  
  public c(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.mServiceCallback = new d(this);
  }
  
  public final void a(a parama)
  {
    k.b("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((parama != null) && (!this.a.contains(parama))) {
      this.a.add(parama);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      com.tencent.a.a.a.a locala = (com.tencent.a.a.a.a)super.getServiceInterface();
      if (locala != null) {
        return locala.a(this.mClientKey, paramArrayOfByte);
      }
    }
    return null;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    k.b("TMAssistantDownloadOpenSDKClient", "sendAsyncData");
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      com.tencent.a.a.a.a locala = (com.tencent.a.a.a.a)super.getServiceInterface();
      k.b("TMAssistantDownloadOpenSDKClient", "sendAsyncData baseService:" + locala);
      if (locala != null)
      {
        k.b("TMAssistantDownloadOpenSDKClient", "baseService sendAsyncData");
        locala.b(this.mClientKey, paramArrayOfByte);
      }
    }
  }
  
  protected final Intent getBindServiceIntent()
  {
    return new Intent(this.mDwonloadServiceName).setClassName("com.tencent.android.qqdownloader", "com.tencent.assistant.sdk.SDKSupportService");
  }
  
  protected final void onDownloadSDKServiceInvalid()
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
  
  protected final void registerServiceCallback()
  {
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = com.tencent.tmassistantsdk.f.a.a(new e().b((byte[])localObject, this.mClientKey.getBytes()), 0);
    int i = ((com.tencent.a.a.a.a)this.mServiceInterface).a(this.mClientKey, (String)localObject, (com.tencent.a.a.a.d)this.mServiceCallback);
    k.b("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
    if (i == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
  
  protected final void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = b.a(paramIBinder);
  }
  
  protected final void unRegisterServiceCallback()
  {
    if (((com.tencent.a.a.a.a)this.mServiceInterface).a((com.tencent.a.a.a.d)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.c
 * JD-Core Version:    0.7.0.1
 */