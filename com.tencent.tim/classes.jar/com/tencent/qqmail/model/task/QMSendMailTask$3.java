package com.tencent.qqmail.model.task;

import com.tencent.qqmail.attachment.model.Attach;
import java.util.Comparator;

class QMSendMailTask$3
  implements Comparator<Attach>
{
  QMSendMailTask$3(QMSendMailTask paramQMSendMailTask) {}
  
  public int compare(Attach paramAttach1, Attach paramAttach2)
  {
    long l1 = paramAttach1.getBelongMailId();
    long l2 = paramAttach2.getBelongMailId();
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.3
 * JD-Core Version:    0.7.0.1
 */