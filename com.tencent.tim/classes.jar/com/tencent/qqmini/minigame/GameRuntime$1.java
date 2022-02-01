package com.tencent.qqmini.minigame;

import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;

class GameRuntime$1
  implements FPSCallback
{
  GameRuntime$1(GameRuntime paramGameRuntime) {}
  
  public void onFPSChange(float paramFloat)
  {
    GameRuntime.access$000(this.this$0).onGetFps(paramFloat);
    GameRuntime.access$200(this.this$0).post(new GameRuntime.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.1
 * JD-Core Version:    0.7.0.1
 */