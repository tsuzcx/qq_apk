package com.tencent.qqmail.utilities.audio;

import android.app.Dialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class QMAudioRecorder$7
  implements QMUIDialogAction.ActionListener
{
  QMAudioRecorder$7(QMAudioRecorder paramQMAudioRecorder) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.stopRecording();
    if (QMAudioRecorder.access$800(this.this$0) != null) {
      QMAudioRecorder.access$800(this.this$0).onCancel();
    }
    paramQMUIDialog.dismiss();
    QMAudioRecorder.access$000(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.7
 * JD-Core Version:    0.7.0.1
 */