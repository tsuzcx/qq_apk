package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import java.util.HashMap;

class ConvMailListFragment$29$1
  implements Runnable
{
  ConvMailListFragment$29$1(ConvMailListFragment.29 param29, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.val$v.getId() == 2131377335)
    {
      Mail localMail = ConvMailListFragment.access$500(this.this$1.this$0).getItem(this.val$position);
      if ((localMail != null) && (localMail.getInformation() != null))
      {
        ConvMailListFragment.access$1700(this.this$1.this$0).put(Integer.valueOf(this.val$position), Long.valueOf(localMail.getInformation().getId()));
        ConvMailListFragment.access$3100(this.this$1.this$0).deleteMail(ConvMailListFragment.access$3000(this.this$1.this$0), new long[] { localMail.getInformation().getId() }, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.29.1
 * JD-Core Version:    0.7.0.1
 */