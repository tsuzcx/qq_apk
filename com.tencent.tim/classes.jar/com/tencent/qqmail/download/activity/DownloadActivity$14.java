package com.tencent.qqmail.download.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class DownloadActivity$14
  implements AdapterView.OnItemLongClickListener
{
  DownloadActivity$14(DownloadActivity paramDownloadActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!(paramView instanceof HorizontalScrollItemView)) || (!((HorizontalScrollItemView)paramView).getContentView().isEnabled())) {
      return true;
    }
    if (!DownloadActivity.access$600(this.this$0).isEditMode())
    {
      DownloadActivity.access$2200(this.this$0);
      int i = DownloadActivity.access$1900(this.this$0).getHeaderViewsCount();
      boolean bool = DownloadActivity.access$600(this.this$0).toggleSelect(paramInt - i);
      DownloadActivity.access$1900(this.this$0).setItemChecked(paramInt, bool);
      DownloadActivity.access$2000(this.this$0);
      QMLog.log(4, "DownloadActivity", "long click into editState");
    }
    DownloadActivity.access$2300(this.this$0, paramView, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.14
 * JD-Core Version:    0.7.0.1
 */