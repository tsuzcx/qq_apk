package com.tencent.mobileqq.minigame.ui;

import asvo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.mobileqq.triton.sdk.game.GameLaunchParam.Builder;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qphone.base.util.QLog;

class GameActivity$34
  implements Runnable
{
  GameActivity$34(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$4802(this.this$0, System.currentTimeMillis());
    QLog.e("[minigame] GameActivity", 1, "start launchGame, execJS");
    GameActivity.access$000(this.this$0).recordInitialMemory();
    MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load", null);
    MiniAppReportManager2.reportPageView("2load", null, null, this.this$0.mGameAppConfig);
    GameActivity.access$3000(this.this$0, 1);
    MiniReportManager.reportEventType(this.this$0.mGameAppConfig, 1007, "1");
    IGameLauncher localIGameLauncher = GameActivity.access$1500(this.this$0).getGameEngine().getGameLauncher();
    if (localIGameLauncher != null)
    {
      if (asvo.aII()) {
        GameActivity.access$1500(this.this$0).getGameEngine().setJankTraceLevel(JankTraceLevel.BRIEF);
      }
      localIGameLauncher.launchGame(new GameLaunchParam.Builder().setGameInfo(GameActivity.access$5200(this.this$0)).setInspectorAgent(GameActivity.access$5100(this.this$0)).setGameLaunchCallback(new GameActivity.34.1(this)).build());
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "launchGame execJS fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.34
 * JD-Core Version:    0.7.0.1
 */