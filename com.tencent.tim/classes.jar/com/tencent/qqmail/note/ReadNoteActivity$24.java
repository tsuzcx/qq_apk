package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadNoteActivity$24
  implements Runnable
{
  ReadNoteActivity$24(ReadNoteActivity paramReadNoteActivity, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$data == null)
    {
      Log.d("ReadNoteActivity", "error read note null");
      ReadNoteActivity.access$1700(this.this$0);
      ReadNoteActivity.access$1800(this.this$0);
    }
    for (;;)
    {
      return;
      if ((ReadNoteActivity.access$1900(this.this$0) != null) && (!ReadNoteActivity.access$1900(this.this$0).isBigContent(((QMNNote)this.val$data).content).booleanValue())) {
        ReadNoteActivity.access$1700(this.this$0);
      }
      ReadNoteActivity.access$1500(this.this$0);
      ReadNoteActivity.access$2000(this.this$0, true);
      QMComposeNote localQMComposeNote = ReadNoteActivity.access$100(this.this$0);
      if ((this.val$data instanceof QMComposeNote)) {
        ReadNoteActivity.access$102(this.this$0, (QMComposeNote)this.val$data);
      }
      while ((localQMComposeNote == null) || (!this.val$fromNetwork))
      {
        ReadNoteActivity.access$200(this.this$0, (QMNNote)this.val$data);
        return;
        ReadNoteActivity.access$102(this.this$0, new QMComposeNote((QMNNote)this.val$data));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.24
 * JD-Core Version:    0.7.0.1
 */