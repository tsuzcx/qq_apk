package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadNoteActivity$26
  implements View.OnClickListener
{
  ReadNoteActivity$26(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadNoteActivity.access$1900(this.this$0) != null) && (ReadNoteActivity.access$1900(this.this$0).getWebView() != null)) {
      ReadNoteActivity.access$1900(this.this$0).getWebView().smoothToTop();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.26
 * JD-Core Version:    0.7.0.1
 */