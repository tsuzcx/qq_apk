package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import tlo;
import tlo.a;

class GameActivity$29
  implements Runnable
{
  GameActivity$29(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$4000(this.this$0);
    tlo.a().a(this.this$0, new tlo.a());
    MiniGameAdBannerPopup.checkShouldShow(this.this$0, this.this$0.mGameAppConfig);
    if ((GameActivity.access$4100(this.this$0) != null) && (GameActivity.access$4100(this.this$0).getCapsuleButton() != null))
    {
      GameActivity.access$4100(this.this$0).getCapsuleButton().showKingCardTips();
      GameActivity.access$4100(this.this$0).getCapsuleButton().updateRedDotVisible();
    }
    if (GameActivity.access$4200(this.this$0) == 2)
    {
      ITTEngine localITTEngine = GameActivity.access$1500(this.this$0).getGameEngine();
      if (localITTEngine != null)
      {
        localITTEngine.onPause();
        QLog.d("MiniLoadingAdManager", 1, "yuki currentEngine.onPause()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.29
 * JD-Core Version:    0.7.0.1
 */