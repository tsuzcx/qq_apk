package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import ycd;

class PublicAccountChatPie$26$1
  implements Runnable
{
  PublicAccountChatPie$26$1(PublicAccountChatPie.26 param26) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.this$0.mActivity.setResult(-1, localIntent);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.26.1
 * JD-Core Version:    0.7.0.1
 */