package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import java.util.Comparator;

class QMCalendarManager$4
  implements Comparator<QMCalendarFolder>
{
  QMCalendarManager$4(QMCalendarManager paramQMCalendarManager) {}
  
  public int compare(QMCalendarFolder paramQMCalendarFolder1, QMCalendarFolder paramQMCalendarFolder2)
  {
    int i = QMCalendarManager.access$500(this.this$0, paramQMCalendarFolder1);
    int j = QMCalendarManager.access$500(this.this$0, paramQMCalendarFolder2);
    if (i == j) {
      return (int)(paramQMCalendarFolder1.getCreateTime() - paramQMCalendarFolder2.getCreateTime());
    }
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.4
 * JD-Core Version:    0.7.0.1
 */