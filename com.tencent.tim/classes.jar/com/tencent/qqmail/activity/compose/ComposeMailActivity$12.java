package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;

class ComposeMailActivity$12
  implements View.OnClickListener
{
  ComposeMailActivity$12(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.composeMail == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = SendMailHelper.generateOriginMail(this.this$0.composeMail);
      if ((localObject != null) && (((Mail)localObject).getInformation().getAccountId() != this.this$0.composeMail.getInformation().getAccountId())) {}
      long l1;
      for (boolean bool = true;; bool = false)
      {
        localObject = SendMailHelper.prepareUploadAttachList(this.this$0.composeMail, bool);
        long l2 = 0L;
        l1 = l2;
        if (localObject == null) {
          break;
        }
        l1 = l2;
        if (((ArrayList)localObject).size() <= 0) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        for (l1 = 0L; ((Iterator)localObject).hasNext(); l1 = StringExtention.sizeStrToLong(((Attach)((Iterator)localObject).next()).getSize()) + l1) {}
      }
      if ((l1 > 2097152L) && (QMNetworkUtils.isMobileConnected()))
      {
        QMLog.log(4, "ComposeMailActivity", "show attach download dialog to handle send button,size:" + l1);
        ComposeMailActivity.access$800(this.this$0, StringExtention.getHumanReadableSizeString(l1), new ComposeMailActivity.12.1(this), new ComposeMailActivity.12.2(this), new ComposeMailActivity.12.3(this));
      }
      else
      {
        this.this$0.handleSendButton();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.12
 * JD-Core Version:    0.7.0.1
 */