package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import anpb;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class JumpActivity$4
  implements Runnable
{
  JumpActivity$4(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.val$intent.getType();
    Uri localUri = this.val$intent.getData();
    anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_open_via_qq");
    Intent localIntent = new Intent(this.this$0, ForwardRecentActivity.class);
    if ((str != null) && (str.startsWith("image"))) {}
    for (int i = 1;; i = 0)
    {
      this.ab.putParcelable("android.intent.extra.STREAM", localUri);
      localIntent.putExtras(this.ab);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", i);
      localIntent.putExtra("forward_from_jump", true);
      localIntent.setData(localUri);
      localIntent.putExtra("sendMultiple", false);
      this.this$0.startActivity(localIntent);
      this.this$0.finish();
      return;
      this.ab.putBoolean("not_forward", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.4
 * JD-Core Version:    0.7.0.1
 */