package com.tencent.qqmail.activity.setting.tableactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BaseTableActivity$2
  implements View.OnClickListener
{
  BaseTableActivity$2(BaseTableActivity paramBaseTableActivity, Method paramMethod) {}
  
  public void onClick(View paramView)
  {
    try
    {
      this.val$method.invoke(this.this$0, new Object[0]);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
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
      do
      {
        localInvocationTargetException.printStackTrace();
      } while ((localInvocationTargetException.getCause() == null) || (!(localInvocationTargetException.getCause() instanceof DevRuntimeException)));
      throw new DevRuntimeException(localInvocationTargetException.getCause().getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity.2
 * JD-Core Version:    0.7.0.1
 */