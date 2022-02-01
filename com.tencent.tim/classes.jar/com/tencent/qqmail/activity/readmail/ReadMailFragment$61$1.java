package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.readmail.ForwardMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$61$1
  implements DialogInterface.OnDismissListener
{
  ReadMailFragment$61$1(ReadMailFragment.61 param61, View paramView, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    boolean bool = true;
    if (!this.this$1.this$0.isAttachedToActivity()) {
      QMLog.log(5, "ReadMailFragment", "showSendMailPopup onListItemClick fragment not attach.");
    }
    do
    {
      do
      {
        return;
        QMLog.log(3, "ReadMailFragment", "readmail send popwin:" + this.val$itemView.getTag());
        if (this.val$tag.equals(this.this$1.this$0.getString(2131718803)))
        {
          if (SendMailInterAppsManager.getInstance().hasFile()) {
            DataCollector.logEvent("Event_Local_File_Read_Mail_Reply");
          }
          if ((ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupMail()) && (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupOff()))
          {
            ReadMailFragment.access$10500(this.this$1.this$0, 0);
            return;
          }
          ReadMailFragment.access$12600(this.this$1.this$0, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY, null);
          return;
        }
        if (this.val$tag.equals(this.this$1.this$0.getString(2131718802)))
        {
          if (SendMailInterAppsManager.getInstance().hasFile()) {
            DataCollector.logEvent("Event_Local_File_Read_Mail_Reply");
          }
          ReadMailFragment.access$12600(this.this$1.this$0, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL, null);
          return;
        }
        if (!this.val$tag.equals(this.this$1.this$0.getString(2131693977))) {
          break;
        }
        if (SendMailInterAppsManager.getInstance().hasFile()) {
          DataCollector.logEvent("Event_Local_File_Read_Mail_Forward");
        }
        if ((ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupMail()) && (ReadMailFragment.access$000(this.this$1.this$0).getStatus().isGroupOff()))
        {
          ReadMailFragment.access$10500(this.this$1.this$0, 1);
          return;
        }
      } while ((ReadMailFragment.access$2400(this.this$1.this$0).getStatus() != 1) && (ReadMailFragment.access$2400(this.this$1.this$0).getStatus() != 4));
      if ((ReadMailFragment.access$2300(this.this$1.this$0) != null) && (ReadMailFragment.access$2300(this.this$1.this$0).getResourceLoader() != null) && (ReadMailFragment.access$2300(this.this$1.this$0).getResourceLoader().isAllImageCached())) {}
      for (;;)
      {
        ForwardMailHelper.prepareToForwardMail(this.this$1.this$0.getActivity(), ReadMailFragment.access$200(this.this$1.this$0), ReadMailFragment.access$000(this.this$1.this$0), bool, ReadMailFragment.access$2500(this.this$1.this$0));
        return;
        bool = false;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131718665)));
    ReadMailFragment.access$12800(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.61.1
 * JD-Core Version:    0.7.0.1
 */