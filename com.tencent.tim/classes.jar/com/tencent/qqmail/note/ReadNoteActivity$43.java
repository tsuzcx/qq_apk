package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadNoteActivity$43
  implements Runnable
{
  ReadNoteActivity$43(ReadNoteActivity paramReadNoteActivity) {}
  
  public void run()
  {
    if ((ReadNoteActivity.access$1900(this.this$0) != null) && (ReadNoteActivity.access$1900(this.this$0).getWebView() != null))
    {
      ReadNoteActivity.access$1900(this.this$0).getWebView().scrollBy(0, -1);
      ReadNoteActivity.access$1900(this.this$0).getWebView().scrollBy(0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.43
 * JD-Core Version:    0.7.0.1
 */