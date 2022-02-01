package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.activity.tagmail.TagMailActivity;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.ReadMailDetailView;

class ReadMailFragment$58$1
  implements DialogInterface.OnDismissListener
{
  ReadMailFragment$58$1(ReadMailFragment.58 param58, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.this$1.this$0.isAttachedToActivity()) {
      QMLog.log(5, "ReadMailFragment", "showMarkMailPopup onListItemClick fragment not attach.");
    }
    long l;
    do
    {
      return;
      l = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getId();
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695668)))
      {
        ReadMailFragment.access$5602(this.this$1.this$0, true);
        ReadMailFragment.access$5000(this.this$1.this$0).unreadMail(ReadMailFragment.access$12202(this.this$1.this$0, l), false);
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695671)))
      {
        ReadMailFragment.access$5602(this.this$1.this$0, true);
        ReadMailFragment.access$5000(this.this$1.this$0).unreadMail(ReadMailFragment.access$12202(this.this$1.this$0, l), true);
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695672)))
      {
        ReadMailFragment.access$5000(this.this$1.this$0).starMail(l, false);
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695669)))
      {
        ReadMailFragment.access$5000(this.this$1.this$0).starMail(l, true);
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695641)))
      {
        paramDialogInterface = ReadMailFragment.access$5000(this.this$1.this$0);
        if (ReadMailFragment.access$12300(this.this$1.this$0) != 0L) {
          l = ReadMailFragment.access$12300(this.this$1.this$0);
        }
        paramDialogInterface.topMail(l, false);
        ReadMailFragment.access$000(this.this$1.this$0).refreshTopStatus();
        ReadMailFragment.access$11900(this.this$1.this$0).render(ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$11900(this.this$1.this$0).isShowDetail());
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695634)))
      {
        paramDialogInterface = ReadMailFragment.access$5000(this.this$1.this$0);
        if (ReadMailFragment.access$12300(this.this$1.this$0) != 0L) {
          l = ReadMailFragment.access$12300(this.this$1.this$0);
        }
        paramDialogInterface.topMail(l, true);
        ReadMailFragment.access$000(this.this$1.this$0).refreshTopStatus();
        ReadMailFragment.access$11900(this.this$1.this$0).render(ReadMailFragment.access$000(this.this$1.this$0), ReadMailFragment.access$11900(this.this$1.this$0).isShowDetail());
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131689933)));
    int i = ReadMailFragment.access$000(this.this$1.this$0).getInformation().getAccountId();
    boolean bool = ReadMailFragment.access$000(this.this$1.this$0).getStatus().isConversationChild();
    paramDialogInterface = TagMailActivity.createIntent(i, new long[] { l }, bool);
    this.this$1.this$0.startActivityForResult(paramDialogInterface, 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.58.1
 * JD-Core Version:    0.7.0.1
 */