package com.tencent.qqmail.attachment.activity;

import android.content.res.Resources;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class AttachFolderPreviewActivity$5
  implements Runnable
{
  AttachFolderPreviewActivity$5(AttachFolderPreviewActivity paramAttachFolderPreviewActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (!QMNetworkUtils.isNetworkConnected()) {}
    for (String str = this.this$0.getResources().getString(2131697131);; str = this.this$0.getResources().getString(2131690540))
    {
      AttachFolderPreviewActivity.access$1300(this.this$0, str, this.val$retry);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */