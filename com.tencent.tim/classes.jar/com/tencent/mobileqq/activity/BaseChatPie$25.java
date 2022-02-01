package com.tencent.mobileqq.activity;

import android.view.ViewGroup;
import aogk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;
import mqq.os.MqqHandler;
import wkj;

class BaseChatPie$25
  implements Runnable
{
  BaseChatPie$25(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (aogk.a().azB()) {}
    do
    {
      return;
      if ((wkj.a(this.this$0.mContext, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.aTl, true, 3, this.this$0.sessionInfo.a)) || (this.this$0.sessionInfo.a.img != this.this$0.cL.getBackground())) {
        this.this$0.uiHandler.sendMessage(this.this$0.uiHandler.obtainMessage(60, this.this$0.sessionInfo.a.img));
      }
    } while (!ChatBackgroundManager.isApngFile(new File(wkj.g(this.this$0.mContext, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.aTl))));
    ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.25.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.25
 * JD-Core Version:    0.7.0.1
 */