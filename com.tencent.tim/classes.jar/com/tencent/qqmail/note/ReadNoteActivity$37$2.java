package com.tencent.qqmail.note;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;

class ReadNoteActivity$37$2
  implements Runnable
{
  ReadNoteActivity$37$2(ReadNoteActivity.37 param37, String paramString) {}
  
  public void run()
  {
    if (this.val$msg != null)
    {
      if (this.val$msg.equals(QMApplicationContext.sharedInstance().getString(2131696755)))
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131696754), 0).show();
        return;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), this.val$msg, 0).show();
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131696751), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.37.2
 * JD-Core Version:    0.7.0.1
 */