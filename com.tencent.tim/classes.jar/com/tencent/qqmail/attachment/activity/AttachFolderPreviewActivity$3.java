package com.tencent.qqmail.attachment.activity;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class AttachFolderPreviewActivity$3
  implements Runnable
{
  AttachFolderPreviewActivity$3(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void run()
  {
    AttachFolderPreviewActivity.access$900(this.this$0);
    long l1 = StringExtention.sizeStrToLong(AttachFolderPreviewActivity.access$1000(this.this$0).getSize());
    long l2 = Long.parseLong(AttachFolderPreviewActivity.access$1000(this.this$0).getState().getDownloadSize());
    AttachFolderPreviewActivity.access$1100(this.this$0).setMax((int)l1);
    AttachFolderPreviewActivity.access$1100(this.this$0).setProgress(Integer.parseInt(AttachFolderPreviewActivity.access$1000(this.this$0).getState().getDownloadSize()));
    AttachFolderPreviewActivity.access$1200(this.this$0).setText(StringExtention.getHumanReadableSizeString(l2) + " / " + StringExtention.getHumanReadableSizeString(l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */