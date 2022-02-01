package com.tencent.qqmail.download.activity;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;

class DownloadActivity$12
  implements ItemScrollListView.OnRightViewClickListener
{
  DownloadActivity$12(DownloadActivity paramDownloadActivity) {}
  
  public void onRightViewClick(View paramView, int paramInt)
  {
    paramView = DownloadActivity.access$600(this.this$0).getItem(paramInt);
    Attach localAttach = DownloadActivity.access$600(this.this$0).getAttachByPosition(paramInt);
    if ((paramView != null) && (localAttach != null) && ((paramView.getStatus() == 1) || (paramView.getStatus() == 2)))
    {
      paramInt = paramView.getAttachType();
      if ((paramInt != 0) && (paramInt != 3)) {
        break label118;
      }
      DownloadActivity.access$700(this.this$0, localAttach);
    }
    for (;;)
    {
      QMLog.log(4, "DownloadActivity", "start to delete  attach " + paramView.getFileName());
      DownloadInfoManager.shareInstance().deleteDownloadFile(paramView);
      DownloadActivity.access$000(this.this$0);
      DataCollector.logEvent("Event_Scroll_Delete_In_DownloadManager");
      return;
      label118:
      if (paramInt == 1) {
        DownloadActivity.access$800(this.this$0, (MailBigAttach)localAttach);
      } else if (paramInt == 2) {
        DownloadActivity.access$900(this.this$0, paramView);
      } else if (paramInt == 4) {
        DownloadActivity.access$1000(this.this$0, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.12
 * JD-Core Version:    0.7.0.1
 */