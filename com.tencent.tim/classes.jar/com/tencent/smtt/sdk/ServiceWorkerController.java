package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

public abstract class ServiceWorkerController
{
  public static ServiceWorkerController getInstance(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = y.a();
    ((y)localObject2).a(paramContext, null);
    if (((y)localObject2).b())
    {
      localObject2 = y.a().c().p();
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = new ServiceWorkerController.1((IX5CoreServiceWorkerController)localObject2);
      }
    }
    do
    {
      return paramContext;
      paramContext = localObject1;
    } while (Build.VERSION.SDK_INT < 24);
    return new l();
  }
  
  public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();
  
  public abstract void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.ServiceWorkerController
 * JD-Core Version:    0.7.0.1
 */