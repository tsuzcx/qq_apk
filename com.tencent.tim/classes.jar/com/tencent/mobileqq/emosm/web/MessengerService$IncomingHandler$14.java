package com.tencent.mobileqq.emosm.web;

import aevs;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Iterator;
import java.util.List;
import zjq;

class MessengerService$IncomingHandler$14
  implements Runnable
{
  MessengerService$IncomingHandler$14(MessengerService.a parama, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2 = zjq.a().dp();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      zjq.a().a(this.val$service, this.val$qqApp);
      localObject1 = zjq.a().dp();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aevs)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((aevs)localObject2).a == null) || (((aevs)localObject2).a.uiResId != this.aDL));
    }
    for (int i = ((aevs)localObject2).bo;; i = -1)
    {
      localObject1 = new Bundle();
      if (i == -1)
      {
        ((Bundle)localObject1).putInt("ret", 1);
        if (i != 0) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject1).putInt("type", i);
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.cp(this.val$reqbundle);
        return;
        ((Bundle)localObject1).putInt("ret", 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */