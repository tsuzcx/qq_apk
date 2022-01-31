package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.tmassistantsdk.a.b;
import com.tencent.tmassistantsdk.f.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class e
  extends b
{
  e(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient) {}
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    j.b("TMAssistantDownloadSDKClient", "OnDownloadStateChanged,clientKey:" + paramString1 + ",state:" + paramInt1 + ", errorcode" + paramInt2 + ",url:" + paramString2);
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)localWeakReference.get();
      if (localITMAssistantDownloadSDKClientListener == null) {
        j.b("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + localWeakReference);
      }
      g.a();
      g.a(this.a, localITMAssistantDownloadSDKClientListener, paramString2, paramInt1, paramInt2, paramString3);
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    j.b("TMAssistantDownloadSDKClient", "OnDownloadProgressChanged,clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",totalLen:" + paramLong2 + ",url:" + paramString2);
    paramString1 = this.a.mWeakListenerArrayList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)localWeakReference.get();
      if (localITMAssistantDownloadSDKClientListener == null) {
        j.b("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + localWeakReference);
      }
      g.a();
      g.a(this.a, localITMAssistantDownloadSDKClientListener, paramString2, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.e
 * JD-Core Version:    0.7.0.1
 */