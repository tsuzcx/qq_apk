package com.tencent.qqmail.note;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import java.util.HashMap;

class ReadNoteActivity$20
  implements Runnable
{
  ReadNoteActivity$20(ReadNoteActivity paramReadNoteActivity, Object paramObject) {}
  
  public void run()
  {
    boolean bool = ((Boolean)((HashMap)this.val$data).get("star")).booleanValue();
    View localView = ReadNoteActivity.access$1400(this.this$0).findViewById(2131379853);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      Log.d("ReadNoteActivity", "star note succ:");
      ReadNoteActivity.access$100(this.this$0).status.starred = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.20
 * JD-Core Version:    0.7.0.1
 */