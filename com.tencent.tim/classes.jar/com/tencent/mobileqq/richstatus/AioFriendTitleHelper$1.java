package com.tencent.mobileqq.richstatus;

import amey;
import amhj;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class AioFriendTitleHelper$1
  implements Runnable
{
  public void run()
  {
    RichStatus localRichStatus = ((amhj)amey.a(this.this$0).app.getManager(15)).a(amey.a(this.this$0).sessionInfo.aTl, true);
    amey.a(this.this$0).mActivity.runOnUiThread(new AioFriendTitleHelper.1.1(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1
 * JD-Core Version:    0.7.0.1
 */