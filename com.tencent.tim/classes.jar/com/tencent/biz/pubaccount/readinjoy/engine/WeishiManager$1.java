package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import lcr;
import ujt;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(lcr paramlcr, Activity paramActivity) {}
  
  public void run()
  {
    if (lcr.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.aTl = acbn.blN;
      localSessionInfo.cZ = 1008;
      ujt.a(lcr.a(this.this$0), localSessionInfo);
      lcr.a(this.this$0).b().ca(acbn.blN, 1008);
    } while (!(this.val$activity instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.val$activity).aQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */