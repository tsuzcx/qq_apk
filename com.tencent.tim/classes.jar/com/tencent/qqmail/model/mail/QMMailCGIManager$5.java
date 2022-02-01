package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.Comparator;

class QMMailCGIManager$5
  implements Comparator<QMFolder>
{
  QMMailCGIManager$5(QMMailCGIManager paramQMMailCGIManager) {}
  
  public int compare(QMFolder paramQMFolder1, QMFolder paramQMFolder2)
  {
    return paramQMFolder1.getSequence() - paramQMFolder2.getSequence();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.5
 * JD-Core Version:    0.7.0.1
 */