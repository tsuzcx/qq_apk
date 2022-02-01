package me.ele.uetool;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.dialog.FragmentListTreeDialog;
import me.ele.uetool.util.Util;

class UETCore$DevAttrs$1
  implements View.OnClickListener
{
  UETCore$DevAttrs$1(UETCore.DevAttrs paramDevAttrs) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = Util.getCurrentActivity();
    if ((localActivity instanceof TransparentActivity)) {
      ((TransparentActivity)localActivity).dismissAttrsDialog();
    }
    try
    {
      new FragmentListTreeDialog(paramView.getContext()).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETCore.DevAttrs.1
 * JD-Core Version:    0.7.0.1
 */