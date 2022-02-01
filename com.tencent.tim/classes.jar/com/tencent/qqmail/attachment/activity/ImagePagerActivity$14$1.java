package com.tencent.qqmail.attachment.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.protocol.DataCollector;

class ImagePagerActivity$14$1
  implements DialogInterface.OnDismissListener
{
  ImagePagerActivity$14$1(ImagePagerActivity.14 param14, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131690582)))
    {
      ImagePagerActivity.access$2600(this.this$1.this$0);
      DataCollector.logEvent("Event_Click_SaveAs_From_FtnDetail");
    }
    do
    {
      return;
      if (this.val$tag.equals(this.this$1.this$0.getString(2131695600)))
      {
        ImagePagerActivity.access$2700(this.this$1.this$0);
        DataCollector.logEvent("Event_Attach_Send_Email_From_FtnDetail");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131696697)))
      {
        ImagePagerActivity.access$2800(this.this$1.this$0);
        DataCollector.logEvent("Event_Attach_Open_File_From_FtnDetail");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690586)))
      {
        ImagePagerActivity.access$2900(this.this$1.this$0, 2131367770);
        DataCollector.logEvent("Event_Share_Big_Attach_From_Readmail");
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131690572)));
    ImagePagerActivity.access$3000(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.14.1
 * JD-Core Version:    0.7.0.1
 */