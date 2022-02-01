package com.tencent.qqmail.widget.notelist;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;

class NoteWidgetManager$1
  implements ICallBack
{
  NoteWidgetManager$1(NoteWidgetManager paramNoteWidgetManager) {}
  
  public void callback(Object paramObject)
  {
    QMLog.log(4, "NoteWidgetManager", "NoteListUpdateIObserver callback");
    this.this$0.notifyDataChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetManager.1
 * JD-Core Version:    0.7.0.1
 */