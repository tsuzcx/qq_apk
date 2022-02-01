package com.tencent.qqmail.activity.setting.tableactivity;

import com.tencent.qqmail.activity.setting.tableactivity.model.TableItem;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import rx.functions.Action1;

class BaseTableActivity$5
  implements Action1<TableItem>
{
  BaseTableActivity$5(BaseTableActivity paramBaseTableActivity, boolean paramBoolean) {}
  
  public void call(TableItem paramTableItem)
  {
    if (this.val$isBonusTest)
    {
      paramTableItem.getTableItemView().setVisibility(0);
      return;
    }
    paramTableItem.getTableItemView().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.5
 * JD-Core Version:    0.7.0.1
 */