package com.tencent.qqmail.note;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollector;

class NoteListActivity$22
  implements Runnable
{
  NoteListActivity$22(NoteListActivity paramNoteListActivity) {}
  
  public void run()
  {
    DataCollector.logException(7, 5, "Event_Error", "notelistactivity", false);
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131696288), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.22
 * JD-Core Version:    0.7.0.1
 */