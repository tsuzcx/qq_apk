package com.tencent.qqmail.note;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$49
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$49(ReadNoteActivity paramReadNoteActivity, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131692344))) {}
    while (!paramString.equals(this.this$0.getString(2131689844))) {
      try
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse("qqbooksave:" + this.val$telNumber));
        this.this$0.startActivity(paramView);
        DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_New_Contact");
        paramQMBottomDialog.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          this.this$0.createNewContact(this.val$telNumber);
          DataCollector.logEvent("Event_Content_Recognize_New_Contact");
        }
      }
    }
    try
    {
      paramView = new Intent("android.intent.action.INSERT_OR_EDIT");
      paramView.setType("vnd.android.cursor.item/contact");
      paramView.putExtra("phone", this.val$telNumber);
      paramView.setPackage("com.tencent.pb");
      this.this$0.startActivity(paramView);
      DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Exist_Contact");
      paramQMBottomDialog.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        this.this$0.insertExistContact(this.val$telNumber);
        DataCollector.logEvent("Event_Content_Recognize_Exist_Contact");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.49
 * JD-Core Version:    0.7.0.1
 */