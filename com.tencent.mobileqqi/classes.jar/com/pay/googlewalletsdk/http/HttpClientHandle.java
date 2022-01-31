package com.pay.googlewalletsdk.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

public class HttpClientHandle
  extends Handler
{
  private static HttpClientHandle handle;
  private static Object lock = new Object();
  private List<IAppInstallObsrver> appInstallObsrvers = new ArrayList();
  private List<IHttpResolveObserver> observers = new ArrayList();
  
  public static HttpClientHandle getIntanceHandel()
  {
    if (handle == null) {}
    synchronized (lock)
    {
      if (handle == null) {
        handle = new HttpClientHandle();
      }
      return handle;
    }
  }
  
  private void runObserverOnMainThread(Message paramMessage)
  {
    int j = this.observers.size();
    int k = this.appInstallObsrvers.size();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onReady((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onStart((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        IHttpResolveObserver localIHttpResolveObserver = (IHttpResolveObserver)this.observers.get(i);
        BaseHttpResolve localBaseHttpResolve = (BaseHttpResolve)paramMessage.obj;
        Bundle localBundle = paramMessage.getData();
        byte[] arrayOfByte = localBundle.getByteArray("bytes");
        long l = localBundle.getLong("downsize");
        localIHttpResolveObserver.onDownLoading(arrayOfByte, paramMessage.arg1, l, localBaseHttpResolve);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onFinish((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onError((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onPause((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < j)
      {
        ((IHttpResolveObserver)this.observers.get(i)).onStop((BaseHttpResolve)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < k)
      {
        ((IAppInstallObsrver)this.appInstallObsrvers.get(i)).oninstall((String)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < k)
      {
        ((IAppInstallObsrver)this.appInstallObsrvers.get(i)).onuninstall((String)paramMessage.obj);
        i += 1;
      }
      continue;
      i = 0;
      while (i < k)
      {
        ((IAppInstallObsrver)this.appInstallObsrvers.get(i)).oninstallFail((String)paramMessage.obj);
        i += 1;
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    runObserverOnMainThread(paramMessage);
  }
  
  public void register(IHttpResolveObserver paramIHttpResolveObserver)
  {
    this.observers.add(paramIHttpResolveObserver);
  }
  
  public void registerAppInstall(IAppInstallObsrver paramIAppInstallObsrver)
  {
    this.appInstallObsrvers.add(paramIAppInstallObsrver);
  }
  
  public void unregister(IHttpResolveObserver paramIHttpResolveObserver)
  {
    this.observers.remove(paramIHttpResolveObserver);
  }
  
  public void unregisterAppUnInstall(IAppInstallObsrver paramIAppInstallObsrver)
  {
    this.appInstallObsrvers.remove(paramIAppInstallObsrver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.HttpClientHandle
 * JD-Core Version:    0.7.0.1
 */