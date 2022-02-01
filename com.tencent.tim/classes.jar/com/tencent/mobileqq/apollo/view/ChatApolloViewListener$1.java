package com.tencent.mobileqq.apollo.view;

import abrg;
import abyy;
import acbh;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ChatApolloViewListener$1
  implements Runnable
{
  public ChatApolloViewListener$1(acbh paramacbh) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady threadPriority:" + i);
    if (this.this$0.fj == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.this$0.fj.get();
    } while (localBaseChatPie == null);
    if ((localBaseChatPie.app != null) && (localBaseChatPie.sessionInfo != null)) {
      ((abrg)localBaseChatPie.app.getManager(249)).dj(localBaseChatPie.sessionInfo.aTl, localBaseChatPie.sessionInfo.cZ);
    }
    abyy.Dg("TraceReport_initApolloSurfaceView_PreLoadJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */