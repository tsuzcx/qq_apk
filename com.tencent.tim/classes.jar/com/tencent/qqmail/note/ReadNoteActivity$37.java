package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask.CallBack;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadNoteActivity$37
  implements WebviewCaptureTask.CallBack
{
  ReadNoteActivity$37(ReadNoteActivity paramReadNoteActivity, QMTips paramQMTips) {}
  
  public void onError(String paramString)
  {
    this.val$tips.hideDelay(200L);
    this.this$0.runOnMainThread(new ReadNoteActivity.37.2(this, paramString), 500L);
    StringBuilder localStringBuilder = new StringBuilder().append("saveWebviewFullScreenImage onError:");
    if (paramString != null) {}
    for (;;)
    {
      QMLog.log(6, "ReadNoteActivity", paramString);
      return;
      paramString = "";
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (paramString == null) {
      return;
    }
    ReadNoteActivity.access$3300(this.this$0, new ReadNoteActivity.37.1(this, paramString));
    Log.d("ReadNoteActivity", "saveWebviewFullScreenImage onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.37
 * JD-Core Version:    0.7.0.1
 */