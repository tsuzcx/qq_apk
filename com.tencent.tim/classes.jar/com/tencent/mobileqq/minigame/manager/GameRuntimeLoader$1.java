package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.ArrayList;
import java.util.Iterator;

class GameRuntimeLoader$1
  implements GameRuntimeLoader.GameRuntimeProgressListener
{
  GameRuntimeLoader$1(GameRuntimeLoader paramGameRuntimeLoader) {}
  
  public void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    GameLog.getInstance().i(GameRuntimeLoader.access$000(this.this$0), "gpkg progress:" + paramFloat);
    Iterator localIterator = new ArrayList(GameRuntimeLoader.access$100(this.this$0)).iterator();
    while (localIterator.hasNext()) {
      ((GameRuntimeLoader.GameRuntimeListener)localIterator.next()).onTaskProgress(paramBaseTask, paramFloat, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.1
 * JD-Core Version:    0.7.0.1
 */