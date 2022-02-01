package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor;

class QMComposeNoteView$4
  implements View.OnFocusChangeListener
{
  QMComposeNoteView$4(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMComposeNoteView.access$300(this.this$0).blurFocus();
      this.this$0.hideformatToolbar(true);
      if (QMComposeNoteView.access$400(this.this$0) != null) {
        QMComposeNoteView.access$400(this.this$0).onSubjectTextFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.4
 * JD-Core Version:    0.7.0.1
 */