package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingSyncAdapterActivity$1
  implements UITableView.ClickListener
{
  SettingSyncAdapterActivity$1(SettingSyncAdapterActivity paramSettingSyncAdapterActivity, UITableItemView paramUITableItemView1, UITableItemView paramUITableItemView2, UITableItemView paramUITableItemView3) {}
  
  private long[] getTime(UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == this.val$periodItem) {
      return new long[] { 1L, 10L, 15L, 30L, 60L, 120L, 240L, 360L, 480L };
    }
    if (paramUITableItemView == this.val$normalLimitItem) {
      return new long[] { 1L, 10L, 15L, 30L, 60L, 120L, 240L, 360L, 480L };
    }
    if (paramUITableItemView == this.val$jobSchedulerPeriodItem) {
      return new long[] { 1L, 10L, 15L, 30L, 60L, 120L, 240L, 360L, 480L };
    }
    return new long[0];
  }
  
  private void update(UITableItemView paramUITableItemView, long paramLong)
  {
    if (paramUITableItemView == this.val$periodItem) {
      QMSyncAdapterManager.setPeriod(paramLong);
    }
    do
    {
      return;
      if (paramUITableItemView == this.val$normalLimitItem)
      {
        QMSyncAdapterManager.setNormalLimit(paramLong);
        return;
      }
    } while (paramUITableItemView != this.val$jobSchedulerPeriodItem);
    QMSyncAdapterManager.setJobschedulerPeriod(paramLong);
  }
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new SettingSyncAdapterActivity.1.1(this, paramUITableItemView));
    paramUITableItemView = getTime(paramUITableItemView);
    int i = paramUITableItemView.length;
    paramInt = 0;
    while (paramInt < i)
    {
      long l = paramUITableItemView[paramInt];
      localBottomListSheetBuilder.addItem(l + "分钟", String.valueOf(l));
      paramInt += 1;
    }
    localBottomListSheetBuilder.build().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncAdapterActivity.1
 * JD-Core Version:    0.7.0.1
 */