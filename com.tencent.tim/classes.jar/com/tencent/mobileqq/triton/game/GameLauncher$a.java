package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.bridge.TTJSBridge;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;
import com.tencent.mobileqq.triton.sdk.game.GameLaunchParam;
import com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;

class GameLauncher$a
  implements Runnable
{
  GameLauncher$a(GameLauncher paramGameLauncher, GameLaunchParam paramGameLaunchParam) {}
  
  public void run()
  {
    GameLauncher.a(this.b, this.a.gameInfo);
    GameLauncher.a(this.b, this.a.gameLaunchCallback);
    GameLauncher.b(this.b).a(this.a.inspectorAgent);
    if (!GameLauncher.c(this.b).success) {
      GameLauncher.a(this.b).onGameLaunched(new GameLaunchStatistic(false, 0L, GameLauncher.d(this.b), GameLauncher.c(this.b)));
    }
    do
    {
      return;
      GameLauncher.f(this.b).a(new GameLauncher.a.a(this));
    } while (GameLauncher.b(this.b).i() == null);
    GameLauncher.b(this.b).i().onGameLaunched();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.a
 * JD-Core Version:    0.7.0.1
 */