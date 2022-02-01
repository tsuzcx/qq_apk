package com.tencent.qqmail.activity.setting.tableactivity;

import com.tencent.qqmail.activity.setting.tableactivity.model.Table;
import com.tencent.qqmail.activity.setting.tableactivity.model.TableItem;
import rx.Observable;
import rx.functions.Func1;

class BaseTableActivity$7
  implements Func1<Table, Observable<TableItem>>
{
  BaseTableActivity$7(BaseTableActivity paramBaseTableActivity) {}
  
  public Observable<TableItem> call(Table paramTable)
  {
    return Observable.from(paramTable.getTableItems());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.7
 * JD-Core Version:    0.7.0.1
 */