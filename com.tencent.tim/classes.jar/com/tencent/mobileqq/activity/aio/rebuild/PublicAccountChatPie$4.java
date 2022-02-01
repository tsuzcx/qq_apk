package com.tencent.mobileqq.activity.aio.rebuild;

import acja;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import ycd;

public class PublicAccountChatPie$4
  implements Runnable
{
  public PublicAccountChatPie$4(ycd paramycd) {}
  
  public void run()
  {
    Object localObject = (acja)this.this$0.app.getManager(56);
    if (localObject != null) {}
    for (localObject = ((acja)localObject).b(this.this$0.sessionInfo.aTl);; localObject = null)
    {
      if (localObject != null) {
        this.this$0.mHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4
 * JD-Core Version:    0.7.0.1
 */