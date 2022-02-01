package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class ComposeMailActivity$39
  implements Runnable
{
  ComposeMailActivity$39(ComposeMailActivity paramComposeMailActivity, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$attachInfos.iterator();
    for (;;)
    {
      AttachInfo localAttachInfo;
      if (localIterator.hasNext())
      {
        localAttachInfo = (AttachInfo)localIterator.next();
        if (ComposeMailActivity.access$4400(this.this$0) != ComposeMailActivity.SendMailStatus.SENDCLOSED) {}
      }
      else
      {
        if ((!this.this$0.hasAttachCache) && (this.this$0.composeMail != null) && ((this.this$0.composeMail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) || (this.this$0.composeMail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK)))
        {
          this.this$0.hasAttachCache = true;
          ComposeMailActivity.access$4702(this.this$0, this.this$0.composeMail.toString());
          ComposeMailActivity.access$4802(this.this$0, this.this$0.composeMail.getInformation().getDate().getTime());
        }
        ComposeMailActivity.access$5200(this.this$0, new ComposeMailActivity.39.1(this));
        return;
      }
      ComposeMailActivity.access$4500(this.this$0, localAttachInfo);
      String str = this.this$0.getIntent().getStringExtra("arg_third_image_path");
      if ((localAttachInfo.isShareToContent()) && (str != null) && (str.equals(localAttachInfo.getAbsAttachPath()))) {
        ComposeMailActivity.access$4600(this.this$0, localAttachInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.39
 * JD-Core Version:    0.7.0.1
 */