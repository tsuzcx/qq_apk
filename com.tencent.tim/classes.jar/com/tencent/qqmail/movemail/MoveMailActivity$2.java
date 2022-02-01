package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MoveMailActivity$2
  implements View.OnClickListener
{
  MoveMailActivity$2(MoveMailActivity paramMoveMailActivity) {}
  
  public void onClick(View paramView)
  {
    String str = MoveMailActivity.access$200(this.this$0);
    this.this$0.startActivityForResult(ManageFolderActivity.createIntentForMoveFolder(MoveMailActivity.access$300(this.this$0), null, str, false, false, MoveMailActivity.access$400(this.this$0), MoveMailActivity.access$500(this.this$0)), 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveMailActivity.2
 * JD-Core Version:    0.7.0.1
 */