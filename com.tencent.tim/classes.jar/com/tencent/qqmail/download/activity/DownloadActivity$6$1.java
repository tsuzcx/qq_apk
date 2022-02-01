package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

class DownloadActivity$6$1
  implements QMUIDialogAction.ActionListener
{
  DownloadActivity$6$1(DownloadActivity.6 param6) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = new ArrayList(DownloadActivity.access$600(this.this$1.this$0).getSelectDownloadInfo());
    DownloadActivity.access$600(this.this$1.this$0).getSelectDownloadInfo().clear();
    paramQMUIDialog = paramQMUIDialog.iterator();
    if (paramQMUIDialog.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramQMUIDialog.next();
      Attach localAttach = DownloadActivity.access$600(this.this$1.this$0).getAttachByDownloadInfo(localDownloadInfo);
      if ((localDownloadInfo != null) && (localAttach != null) && ((localDownloadInfo.getStatus() == 1) || (localDownloadInfo.getStatus() == 2)))
      {
        paramInt = localDownloadInfo.getAttachType();
        if ((paramInt != 0) && (paramInt != 3)) {
          break label170;
        }
        DownloadActivity.access$700(this.this$1.this$0, localAttach);
      }
      for (;;)
      {
        QMLog.log(4, "DownloadActivity", "start to delete  attach " + localDownloadInfo.getFileName());
        DownloadInfoManager.shareInstance().deleteDownloadFile(localDownloadInfo);
        break;
        label170:
        if (paramInt == 1) {
          DownloadActivity.access$800(this.this$1.this$0, (MailBigAttach)localAttach);
        } else if (paramInt == 2) {
          DownloadActivity.access$900(this.this$1.this$0, localDownloadInfo);
        } else if (paramInt == 4) {
          DownloadActivity.access$1000(this.this$1.this$0, localDownloadInfo);
        }
      }
    }
    DataCollector.logEvent("Event_MultiDelete_In_DownloadManager");
    DownloadActivity.access$1200(this.this$1.this$0, new DownloadActivity.6.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.6.1
 * JD-Core Version:    0.7.0.1
 */