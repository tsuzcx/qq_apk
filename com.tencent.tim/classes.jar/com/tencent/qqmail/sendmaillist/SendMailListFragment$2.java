package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import java.util.Comparator;
import java.util.Date;

final class SendMailListFragment$2
  implements Comparator<QMTask>
{
  public int compare(QMTask paramQMTask1, QMTask paramQMTask2)
  {
    int j = -1;
    int i;
    if ((!(paramQMTask1 instanceof QMSendMailTask)) || (!(paramQMTask2 instanceof QMSendMailTask))) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        paramQMTask1 = (QMSendMailTask)paramQMTask1;
        paramQMTask2 = (QMSendMailTask)paramQMTask2;
        paramQMTask1 = paramQMTask1.getMail().getInformation();
        paramQMTask2 = paramQMTask2.getMail().getInformation();
        i = j;
      } while (paramQMTask1 == null);
      if (paramQMTask2 == null) {
        return 1;
      }
      paramQMTask1 = paramQMTask1.getDate();
      paramQMTask2 = paramQMTask2.getDate();
      i = j;
    } while (paramQMTask1 == null);
    if (paramQMTask2 == null) {
      return 1;
    }
    return paramQMTask2.compareTo(paramQMTask1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.2
 * JD-Core Version:    0.7.0.1
 */