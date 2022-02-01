package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MoveActivity$1
  implements View.OnClickListener
{
  MoveActivity$1(MoveActivity paramMoveActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    if (this.this$0.onClickConfirm(paramView)) {
      paramView.setClickable(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      paramView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveActivity.1
 * JD-Core Version:    0.7.0.1
 */