package com.tencent.qqmail.attachment.activity;

import android.content.res.Resources;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareLinkDialogHelper;

class ImagePagerActivity$1$1
  implements Runnable
{
  ImagePagerActivity$1$1(ImagePagerActivity.1 param1) {}
  
  public void run()
  {
    new QMShareLinkDialogHelper(this.this$1.this$0, this.this$1.this$0.getResources().getString(2131692325), ImagePagerActivity.access$300(this.this$1.this$0).getShareUrl(), ImagePagerActivity.access$300(this.this$1.this$0).getName()).createDialog().show();
    DataCollector.logEvent("Event_Share_Big_Attach_From_Ftn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */