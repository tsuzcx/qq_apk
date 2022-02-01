package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class CacheActivity$2
  implements UITableView.ClickListener
{
  CacheActivity$2(CacheActivity paramCacheActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (paramUITableItemView == CacheActivity.access$800(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        bool = true;
        paramUITableItemView.setChecked(bool);
        QMClearCacheManager.setTestDebug(paramUITableItemView.isChecked());
        CacheActivity.access$900(this.this$0);
        CacheActivity.access$1000(this.this$0);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramUITableItemView == CacheActivity.access$1100(this.this$0))
      {
        CacheActivity.access$900(this.this$0);
        CacheActivity.access$1000(this.this$0);
        return;
      }
      if (paramUITableItemView == CacheActivity.access$1200(this.this$0))
      {
        QMClearCacheManager.clearCardCache();
        paramUITableItemView = QMClearCacheManager.prepareAttachPathsToDelete();
        QMClearCacheManager.clearDownloadInfo(paramUITableItemView);
        QMClearCacheManager.clearFileCache(paramUITableItemView, new CacheActivity.2.1(this));
        CacheActivity.access$900(this.this$0);
        CacheActivity.access$1000(this.this$0);
        return;
      }
      if (paramUITableItemView == CacheActivity.access$1300(this.this$0))
      {
        QMClearCacheManager.reportCache();
        return;
      }
    } while (paramUITableItemView != CacheActivity.access$1400(this.this$0));
    QMSharedPreferenceManager.getInstance().setClearCacheTime(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.CacheActivity.2
 * JD-Core Version:    0.7.0.1
 */