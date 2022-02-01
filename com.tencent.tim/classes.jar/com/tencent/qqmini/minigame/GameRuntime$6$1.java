package com.tencent.qqmini.minigame;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;
import com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;

class GameRuntime$6$1
  implements GameLaunchCallback
{
  GameRuntime$6$1(GameRuntime.6 param6) {}
  
  public void onFirstRender(@NonNull FirstRenderStatistic paramFirstRenderStatistic)
  {
    GameRuntime.access$700(this.this$1.this$0, paramFirstRenderStatistic);
  }
  
  public void onGameLaunched(@NonNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    GameRuntime.access$600(this.this$1.this$0, paramGameLaunchStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.6.1
 * JD-Core Version:    0.7.0.1
 */