package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;

class QMCalendarManager$19
  implements QMCalendarFolderCache.FolderFilter
{
  QMCalendarManager$19(QMCalendarManager paramQMCalendarManager) {}
  
  public boolean filter(QMCalendarFolder paramQMCalendarFolder)
  {
    return (paramQMCalendarFolder.isEditable()) && (paramQMCalendarFolder.isSelfFolder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.19
 * JD-Core Version:    0.7.0.1
 */