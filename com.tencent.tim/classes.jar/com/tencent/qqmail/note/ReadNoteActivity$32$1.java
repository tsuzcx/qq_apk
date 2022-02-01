package com.tencent.qqmail.note;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ReadNoteActivity$32$1
  implements DialogInterface.OnDismissListener
{
  ReadNoteActivity$32$1(ReadNoteActivity.32 param32, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    String str;
    if ((this.val$tag.equals(this.this$1.this$0.getString(2131695669))) || (this.val$tag.equals(this.this$1.this$0.getString(2131695672))))
    {
      paramDialogInterface = this.this$1.this$0;
      str = this.this$1.val$noteId;
      if (this.this$1.val$starred) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      ReadNoteActivity.access$2400(paramDialogInterface, str, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.32.1
 * JD-Core Version:    0.7.0.1
 */