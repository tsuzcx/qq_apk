package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$10$2
  implements Runnable
{
  ReadMailFragment$10$2(ReadMailFragment.10 param10, long paramLong) {}
  
  public void run()
  {
    if (ReadMailFragment.access$000(this.this$1.this$0) != null)
    {
      MailContent localMailContent2 = ReadMailFragment.access$000(this.this$1.this$0).getContent();
      MailContent localMailContent1 = localMailContent2;
      if (localMailContent2 == null)
      {
        localMailContent1 = new MailContent();
        ReadMailFragment.access$000(this.this$1.this$0).setContent(localMailContent1);
      }
      if ((localMailContent1.getBody() == null) || (localMailContent1.getBody().equals("")))
      {
        QMLog.log(4, "ReadMailFragment", "load mail content empty:" + this.val$mailId);
        localMailContent1.setBody(" ");
      }
      QMLog.log(4, "ReadMailFragment", "load mail success and start render");
      ReadMailFragment.access$3100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.10.2
 * JD-Core Version:    0.7.0.1
 */