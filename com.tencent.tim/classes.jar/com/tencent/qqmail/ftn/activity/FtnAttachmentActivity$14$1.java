package com.tencent.qqmail.ftn.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.protocol.DataCollector;

class FtnAttachmentActivity$14$1
  implements DialogInterface.OnDismissListener
{
  FtnAttachmentActivity$14$1(FtnAttachmentActivity.14 param14, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131695600)))
    {
      FtnAttachmentActivity.access$3300(this.this$1.this$0);
      DataCollector.logEvent("Event_Attach_Send_Email_From_FtnDetail");
    }
    if (this.val$tag.equals(this.this$1.this$0.getString(2131690582)))
    {
      FtnAttachmentActivity.access$3400(this.this$1.this$0);
      DataCollector.logEvent("Event_Click_SaveAs_From_FtnDetail");
    }
    do
    {
      return;
      if (this.val$tag.equals(this.this$1.this$0.getString(2131696697)))
      {
        FtnAttachmentActivity.access$3500(this.this$1.this$0);
        DataCollector.logEvent("Event_Attach_Open_File_From_FtnDetail");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690586)))
      {
        FtnAttachmentActivity.access$3600(this.this$1.this$0, 2131367770);
        DataCollector.logEvent("Event_Share_Big_Attach_From_Ftn");
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131690572)));
    FtnAttachmentActivity.access$3700(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.14.1
 * JD-Core Version:    0.7.0.1
 */