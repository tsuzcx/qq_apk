package com.tencent.qqmail.note;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadNoteActivity$37$1
  implements Runnable
{
  ReadNoteActivity$37$1(ReadNoteActivity.37 param37, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$1.this$0.getActivity();
    this.this$1.val$tips.dismissTipsManually();
    if (localActivity == null) {
      return;
    }
    new QMShareFileDialogHelper(localActivity, this.this$1.this$0.getResources().getString(2131696757), this.val$filePath, QMShareFileDialogHelper.SHARE_TYPE_IMG, QMShareFileDialogHelper.FROM_SHARE_MAIL_OR_NOTE_CONTENT).createDialog().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.37.1
 * JD-Core Version:    0.7.0.1
 */