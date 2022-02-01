package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadMailFragment$77$1$1
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$77$1$1(ReadMailFragment.77.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    boolean bool2 = true;
    MailOperate localMailOperate = ReadMailFragment.access$5000(this.this$2.this$1.this$0);
    paramInt = ReadMailFragment.access$000(this.this$2.this$1.this$0).getInformation().getAccountId();
    int i = ReadMailFragment.access$000(this.this$2.this$1.this$0).getInformation().getFolderId();
    long l = ReadMailFragment.access$000(this.this$2.this$1.this$0).getInformation().getId();
    boolean bool1;
    if (ReadMailFragment.access$7400(this.this$2.this$1.this$0) != 3)
    {
      bool1 = true;
      if (ReadMailFragment.access$7500(this.this$2.this$1.this$0) != 3) {
        break label146;
      }
    }
    for (;;)
    {
      localMailOperate.rejectMail(paramInt, i, new long[] { l }, bool1, bool2);
      paramQMUIDialog.dismiss();
      return;
      bool1 = false;
      break;
      label146:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.77.1.1
 * JD-Core Version:    0.7.0.1
 */