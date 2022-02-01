package com.tencent.qqmini.minigame;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.DebugSocketAction;

class GamePage$4
  implements View.OnClickListener
{
  GamePage$4(GamePage paramGamePage) {}
  
  public void onClick(View paramView)
  {
    DebugSocketAction.obtain(GamePage.access$800(this.this$0)).quitDebugSocket();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.4
 * JD-Core Version:    0.7.0.1
 */