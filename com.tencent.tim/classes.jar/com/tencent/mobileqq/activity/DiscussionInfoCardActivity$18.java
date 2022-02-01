package com.tencent.mobileqq.activity;

import android.app.Activity;
import apzg;
import com.tencent.mobileqq.app.QQAppInterface;
import rwt;

final class DiscussionInfoCardActivity$18
  implements Runnable
{
  DiscussionInfoCardActivity$18(String paramString1, Activity paramActivity, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = "temp_discuss_link_share_" + this.aKo + ".png";
    str = rwt.a(this.val$context, str, apzg.b(this.aML, this.val$context.getResources()));
    this.val$context.runOnUiThread(new DiscussionInfoCardActivity.18.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.18
 * JD-Core Version:    0.7.0.1
 */