package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnInputListener;

class QMComposeNoteView$2
  implements QMUIRichEditor.OnInputListener
{
  QMComposeNoteView$2(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void onInput()
  {
    if (QMComposeNoteView.access$200(this.this$0) != null) {
      QMComposeNoteView.access$200(this.this$0).packUpFontAndColorPane();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.2
 * JD-Core Version:    0.7.0.1
 */