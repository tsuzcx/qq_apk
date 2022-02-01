package com.tencent.qqmail.note;

import android.net.Uri;
import android.view.View;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$50
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$50(ReadNoteActivity paramReadNoteActivity, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131721918)))
    {
      paramView = ComposeMailActivity.createIntentWithUri(Uri.parse("mailto:" + this.val$mailAddress), 0);
      this.this$0.startActivity(paramView);
      DataCollector.logEvent("Event_Content_Recognize_Compose_Mail");
      paramQMBottomDialog.dismiss();
    }
    while (!paramString.equals(this.this$0.getString(2131692324))) {
      return;
    }
    this.this$0.copy(this.val$mailAddress);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.50
 * JD-Core Version:    0.7.0.1
 */