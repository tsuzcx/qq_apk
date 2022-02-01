package com.tencent.qqmail.activity.setting.tableactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BaseTableActivity$4
  implements View.OnClickListener
{
  BaseTableActivity$4(BaseTableActivity paramBaseTableActivity, Method paramMethod, UITableItemView paramUITableItemView) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject = BaseTableActivity.access$100(this.this$0, this.val$method, this.val$tableItemView.isChecked());
      if (localObject != null) {
        this.val$tableItemView.setChecked(((Boolean)localObject).booleanValue());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.4
 * JD-Core Version:    0.7.0.1
 */