package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MoveActivity$2
  implements View.OnClickListener
{
  MoveActivity$2(MoveActivity paramMoveActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveActivity.2
 * JD-Core Version:    0.7.0.1
 */