package com.tencent.qqmail.activity.setting.tableactivity;

import com.tencent.qqmail.activity.setting.tableactivity.model.Table;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import rx.functions.Action1;

class BaseTableActivity$9
  implements Action1<Table>
{
  BaseTableActivity$9(BaseTableActivity paramBaseTableActivity, boolean paramBoolean) {}
  
  public void call(Table paramTable)
  {
    if (paramTable.getLevel() == 0)
    {
      if (this.val$isBonusTest) {
        paramTable.getTableView().setVisibility(0);
      }
    }
    else {
      return;
    }
    paramTable.getTableView().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.9
 * JD-Core Version:    0.7.0.1
 */