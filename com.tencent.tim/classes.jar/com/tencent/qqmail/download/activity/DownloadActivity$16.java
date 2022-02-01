package com.tencent.qqmail.download.activity;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class DownloadActivity$16
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  DownloadActivity$16(DownloadActivity paramDownloadActivity, Attach paramAttach, DownloadInfo paramDownloadInfo) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    QMLog.log(4, "DownloadActivity", "click action:" + paramString);
    if (paramString.equals(this.this$0.getString(2131692963)))
    {
      if (this.val$attach != null) {
        QMAttachUtils.attachOpenOssLog(String.valueOf(this.val$attach.getHashId()), this.val$attach.getPreview().getMyDisk());
      }
      DownloadActivity.access$2900(this.this$0, this.val$info, this.val$attach);
      DataCollector.logEvent("Event_Click_Attach_In_DownloadManager");
    }
    for (;;)
    {
      paramQMBottomDialog.dismiss();
      return;
      if (paramString.equals(this.this$0.getString(2131692965)))
      {
        paramView = this.val$info.getFilePath();
        DownloadActivity.access$1300(this.this$0, new String[] { paramView });
        DataCollector.logEvent("Event_Attach_Send_Email_From_DownloadManager");
      }
      else if (paramString.equals(this.this$0.getString(2131692966)))
      {
        DownloadActivity.access$3000(this.this$0, this.val$info, this.val$attach);
        DataCollector.logEvent("Event_Share_Attach_From_DownloadManager");
      }
      else if (paramString.equals(this.this$0.getString(2131692964)))
      {
        DownloadActivity.access$3100(this.this$0, this.val$info);
        DataCollector.logEvent("Event_Attach_Open_Save_Path_From_DownloadManager");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.16
 * JD-Core Version:    0.7.0.1
 */