package com.tencent.qqmail.utilities.audio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class QMAudioRecorder$3
  implements DialogInterface.OnKeyListener
{
  QMAudioRecorder$3(QMAudioRecorder paramQMAudioRecorder, Context paramContext) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 4) && (QMAudioRecorder.access$100(this.this$0)))
    {
      this.this$0.confirmDialog(this.val$context);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.3
 * JD-Core Version:    0.7.0.1
 */