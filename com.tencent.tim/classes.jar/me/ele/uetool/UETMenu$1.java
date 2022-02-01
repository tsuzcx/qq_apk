package me.ele.uetool;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UETMenu$1
  implements View.OnClickListener
{
  UETMenu$1(UETMenu paramUETMenu) {}
  
  public void onClick(View paramView)
  {
    UETMenu.access$000(this.this$0, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETMenu.1
 * JD-Core Version:    0.7.0.1
 */