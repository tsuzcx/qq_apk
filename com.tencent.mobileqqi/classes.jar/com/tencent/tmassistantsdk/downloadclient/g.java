package com.tencent.tmassistantsdk.downloadclient;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
  extends Handler
{
  private static g a = null;
  private static HandlerThread b = null;
  
  private g(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static g a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = new HandlerThread("TMAssistantDownloadSDKMessageThread");
        b = (HandlerThread)localObject1;
        ((HandlerThread)localObject1).start();
        a = new g(b.getLooper());
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public static void a(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new com.tencent.tmassistantsdk.f.g(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    localMessage.sendToTarget();
  }
  
  public static void a(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new com.tencent.tmassistantsdk.f.g(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    paramTMAssistantDownloadSDKClient = new Bundle();
    paramTMAssistantDownloadSDKClient.putString("url", paramString1);
    paramTMAssistantDownloadSDKClient.putInt("state", paramInt1);
    paramTMAssistantDownloadSDKClient.putInt("errorCode", paramInt2);
    paramTMAssistantDownloadSDKClient.putString("errorMsg", paramString2);
    localMessage.setData(paramTMAssistantDownloadSDKClient);
    localMessage.sendToTarget();
  }
  
  public static void a(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener, String paramString, long paramLong1, long paramLong2)
  {
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null))
    {
      j.b("TMAssistantDownloadSDKMessageThread", "listenr:" + paramITMAssistantDownloadSDKClientListener + " === sdkClient" + paramTMAssistantDownloadSDKClient);
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 2;
    localMessage.obj = new com.tencent.tmassistantsdk.f.g(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    paramTMAssistantDownloadSDKClient = new Bundle();
    paramTMAssistantDownloadSDKClient.putString("url", paramString);
    paramTMAssistantDownloadSDKClient.putLong("receiveDataLen", paramLong1);
    paramTMAssistantDownloadSDKClient.putLong("totalDataLen", paramLong2);
    localMessage.setData(paramTMAssistantDownloadSDKClient);
    localMessage.sendToTarget();
  }
  
  public static void a(byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new com.tencent.tmassistantsdk.f.g(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject2 = (com.tencent.tmassistantsdk.f.g)paramMessage.obj;
      Object localObject1 = (TMAssistantDownloadSDKClient)((com.tencent.tmassistantsdk.f.g)localObject2).a;
      localObject2 = (ITMAssistantDownloadSDKClientListener)((com.tencent.tmassistantsdk.f.g)localObject2).b;
      Object localObject3 = paramMessage.getData();
      paramMessage = ((Bundle)localObject3).getString("url");
      int i = ((Bundle)localObject3).getInt("state");
      int j = ((Bundle)localObject3).getInt("errorCode");
      localObject3 = ((Bundle)localObject3).getString("errorMsg");
      if (localObject2 != null)
      {
        ((ITMAssistantDownloadSDKClientListener)localObject2).OnDownloadSDKTaskStateChanged((TMAssistantDownloadSDKClient)localObject1, paramMessage, i, j, (String)localObject3);
        return;
        localObject2 = (com.tencent.tmassistantsdk.f.g)paramMessage.obj;
        localObject1 = (TMAssistantDownloadSDKClient)((com.tencent.tmassistantsdk.f.g)localObject2).a;
        localObject2 = (ITMAssistantDownloadSDKClientListener)((com.tencent.tmassistantsdk.f.g)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        long l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null)
        {
          ((ITMAssistantDownloadSDKClientListener)localObject2).OnDownloadSDKTaskProgressChanged((TMAssistantDownloadSDKClient)localObject1, (String)localObject3, l1, l2);
          return;
          localObject1 = (com.tencent.tmassistantsdk.f.g)paramMessage.obj;
          paramMessage = (TMAssistantDownloadSDKClient)((com.tencent.tmassistantsdk.f.g)localObject1).a;
          localObject1 = (ITMAssistantDownloadSDKClientListener)((com.tencent.tmassistantsdk.f.g)localObject1).b;
          if (localObject1 != null)
          {
            ((ITMAssistantDownloadSDKClientListener)localObject1).OnDwonloadSDKServiceInvalid(paramMessage);
            return;
            localObject1 = (com.tencent.tmassistantsdk.f.g)paramMessage.obj;
            paramMessage = (byte[])((com.tencent.tmassistantsdk.f.g)localObject1).a;
            localObject1 = (ArrayList)((com.tencent.tmassistantsdk.f.g)localObject1).b;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (a)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((a)localObject2).a(paramMessage);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.g
 * JD-Core Version:    0.7.0.1
 */