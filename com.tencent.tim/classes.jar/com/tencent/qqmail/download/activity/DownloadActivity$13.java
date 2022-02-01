package com.tencent.qqmail.download.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class DownloadActivity$13
  implements AdapterView.OnItemClickListener
{
  DownloadActivity$13(DownloadActivity paramDownloadActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = DownloadActivity.access$1900(this.this$0).getHeaderViewsCount();
    if ((!(paramView instanceof HorizontalScrollItemView)) || (!((HorizontalScrollItemView)paramView).getContentView().isEnabled())) {}
    DownloadInfo localDownloadInfo;
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (DownloadActivity.access$1500(this.this$0))
      {
        boolean bool = DownloadActivity.access$600(this.this$0).toggleSelect(paramInt - i);
        DownloadActivity.access$1900(this.this$0).setItemChecked(paramInt, bool);
        DownloadActivity.access$2000(this.this$0);
      }
      else
      {
        localObject = DownloadActivity.access$600(this.this$0).getAttachByPosition(paramInt - i);
        localDownloadInfo = DownloadActivity.access$600(this.this$0).getItem(paramInt - i);
        if ((localDownloadInfo == null) || (localDownloadInfo.getStatus() != 4) || (!FileUtil.isFileExist(localDownloadInfo.getFilePath()))) {
          break;
        }
        QMLog.log(4, "DownloadActivity", "click complete file to action:" + localDownloadInfo.getFileName());
        DownloadActivity.access$2100(this.this$0, localDownloadInfo, (Attach)localObject);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("click unComplete file to ");
    if (localDownloadInfo.getStatus() == 2) {}
    for (Object localObject = "pause:";; localObject = "continue:")
    {
      QMLog.log(4, "DownloadActivity", (String)localObject + localDownloadInfo.getFileName());
      localObject = (DownloadAdapter.ViewHolder)paramView.getTag();
      DownloadActivity.access$600(this.this$0).changeDownloadState((DownloadAdapter.ViewHolder)localObject, paramInt - i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.13
 * JD-Core Version:    0.7.0.1
 */