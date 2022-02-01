package com.tencent.qqmail.download.activity;

import android.view.View;
import android.widget.ListView;
import com.tencent.qqmail.qmui.view.QMUIProgressBar;

class DownloadAdapter$4
  implements Runnable
{
  DownloadAdapter$4(DownloadAdapter paramDownloadAdapter, ListView paramListView, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    View localView = this.val$mListView.getChildAt(this.val$pos);
    Object localObject = (DownloadAdapter.ViewHolder)localView.getTag();
    if ((localObject != null) && (((DownloadAdapter.ViewHolder)localObject).mViewStub != null))
    {
      localObject = (QMUIProgressBar)((DownloadAdapter.ViewHolder)localObject).mViewStub.findViewById(2131373659);
      if (localObject != null)
      {
        if ((int)(this.val$downloadSize * 100.0D / this.val$totalSize) > ((QMUIProgressBar)localObject).getProgress()) {
          ((QMUIProgressBar)localObject).setProgress((int)(this.val$downloadSize * 100.0D / this.val$totalSize));
        }
        localView.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadAdapter.4
 * JD-Core Version:    0.7.0.1
 */