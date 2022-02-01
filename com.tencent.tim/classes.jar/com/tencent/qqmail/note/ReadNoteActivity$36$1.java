package com.tencent.qqmail.note;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadNoteActivity$36$1
  implements DialogInterface.OnDismissListener
{
  ReadNoteActivity$36$1(ReadNoteActivity.36 param36, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131696401))) {
      ReadNoteActivity.access$2900(this.this$1.this$0);
    }
    do
    {
      return;
      if (this.val$tag.equals(this.this$1.this$0.getString(2131696402)))
      {
        ReadNoteActivity.access$3000(this.this$1.this$0);
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695201)))
      {
        ReadNoteActivity.access$3100(this.this$1.this$0);
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131696758)));
    if (ReadNoteActivity.access$1900(this.this$1.this$0) == null)
    {
      ReadNoteActivity.access$3200(this.this$1.this$0);
      return;
    }
    ReadNoteActivity.access$1900(this.this$1.this$0).execJs("isContainAudio();");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.36.1
 * JD-Core Version:    0.7.0.1
 */