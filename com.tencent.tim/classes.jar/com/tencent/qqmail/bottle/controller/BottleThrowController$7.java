package com.tencent.qqmail.bottle.controller;

import android.app.PendingIntent;
import android.content.Context;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.util.Iterator;

class BottleThrowController$7
  implements Runnable
{
  BottleThrowController$7(BottleThrowController paramBottleThrowController, QMNetworkError paramQMNetworkError, BottleConversationCursor paramBottleConversationCursor, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (BottleThrowController.access$600(this.this$0).length() > 0)
    {
      localObject1 = BottleThrowController.access$600(this.this$0).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((BottleThrowController.OnBottleThrowWatcher)((Iterator)localObject1).next()).onErrorInMainThread(this.val$error, this.val$cursor);
      }
    }
    Context localContext;
    int i;
    String str;
    Object localObject2;
    PendingIntent localPendingIntent;
    if (this.val$notify)
    {
      localContext = BottleThrowController.access$200(this.this$0).mContext;
      if (!BottleThrowController.isUnsendBottleId(this.val$bottleId)) {
        break label199;
      }
      i = 2131690995;
      str = localContext.getString(i);
      localObject2 = null;
      localPendingIntent = BottleThrowController.access$700(this.this$0, this.val$bottleId);
      localObject1 = localObject2;
      if ((this.val$error instanceof BottleThrowController.BottleThrowError)) {
        switch (((BottleThrowController.BottleThrowError)this.val$error).code)
        {
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = localContext.getString(2131690998))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.val$error.desp;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localContext.getString(2131690996);
      }
      QMNotificationConstructor.getInstance().notifySendBottle(str, str, (CharSequence)localObject1, 2130840992, localPendingIntent, false);
      return;
      label199:
      i = 2131690988;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.7
 * JD-Core Version:    0.7.0.1
 */