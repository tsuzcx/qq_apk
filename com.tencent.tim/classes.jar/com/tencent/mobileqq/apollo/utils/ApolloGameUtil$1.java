package com.tencent.mobileqq.apollo.utils;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import wyk;
import wyk.a;
import wzb.a;

final class ApolloGameUtil$1
  implements Runnable
{
  ApolloGameUtil$1(WeakReference paramWeakReference, MessageForApollo paramMessageForApollo, Bundle paramBundle, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (this.fU == null) {
          break label293;
        }
        if (this.c == null) {
          return;
        }
        localAbsListView = (AbsListView)this.fU.get();
        if (localAbsListView == null) {
          break label293;
        }
        j = localAbsListView.getFirstVisiblePosition();
        k = localAbsListView.getLastVisiblePosition();
        if (!QLog.isColorLevel()) {
          break label294;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[notifyUIUpdate] firstVPos:", Integer.valueOf(j), ",lastVPos:", Integer.valueOf(k) });
      }
      catch (Throwable localThrowable)
      {
        AbsListView localAbsListView;
        int k;
        Object localObject;
        MessageForApollo localMessageForApollo;
        localThrowable.printStackTrace();
        QLog.e("ApolloGameUtil", 1, "[notifyUIUpdate],errInfo->" + localThrowable.getMessage());
      }
      if (i <= k)
      {
        localObject = localAbsListView.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof wzb.a))
          {
            localObject = (wyk.a)localObject;
            localMessageForApollo = (MessageForApollo)((wyk.a)localObject).mMessage;
            if ((ApolloGameUtil.ib(localMessageForApollo.msgType)) && (localMessageForApollo.roomId == this.c.roomId))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameUtil", 2, new Object[] { "find the view with the same roomId,", Long.valueOf(this.c.roomId) });
              }
              if ((this.val$data != null) && (this.val$data.getInt("type") == 1)) {
                wyk.a((wyk.a)localObject, this.c, this.val$app, this.val$data.getInt("gameId"), this.val$data.getInt("process"));
              }
            }
          }
        }
      }
      else
      {
        label293:
        return;
        label294:
        i = j;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.1
 * JD-Core Version:    0.7.0.1
 */