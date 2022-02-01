package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnInputListener;

class QMComposeMailView$2
  implements QMUIRichEditor.OnInputListener
{
  QMComposeMailView$2(QMComposeMailView paramQMComposeMailView) {}
  
  public void onInput()
  {
    if (QMComposeMailView.access$300(this.this$0) != null) {
      QMComposeMailView.access$300(this.this$0).packUpFontAndColorPane();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.2
 * JD-Core Version:    0.7.0.1
 */