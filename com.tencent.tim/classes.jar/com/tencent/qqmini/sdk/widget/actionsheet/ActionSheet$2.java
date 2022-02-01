package com.tencent.qqmini.sdk.widget.actionsheet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionSheet$2
  implements View.OnClickListener
{
  ActionSheet$2(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    if (ActionSheet.access$700(this.this$0) != null) {
      ActionSheet.access$700(this.this$0).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */