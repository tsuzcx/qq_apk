package me.ele.uetool;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.util.ChangePool;

class UETCore$3
  implements View.OnClickListener
{
  UETCore$3(UETCore paramUETCore) {}
  
  public void onClick(View paramView)
  {
    ChangePool.getInstance().clearAll();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETCore.3
 * JD-Core Version:    0.7.0.1
 */