package com.tencent.qqmini.sdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionSheetDialog$1
  implements View.OnClickListener
{
  ActionSheetDialog$1(ActionSheetDialog paramActionSheetDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.ActionSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */