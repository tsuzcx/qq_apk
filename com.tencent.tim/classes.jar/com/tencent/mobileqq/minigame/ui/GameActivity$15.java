package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

class GameActivity$15
  implements MiniLoadingAdLayout.OnDismissListener
{
  GameActivity$15(GameActivity paramGameActivity) {}
  
  public void onDismiss()
  {
    GameActivity.access$3000(this.this$0, 3);
    ITTEngine localITTEngine = GameActivity.access$1500(this.this$0).getGameEngine();
    if (localITTEngine != null) {
      localITTEngine.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.15
 * JD-Core Version:    0.7.0.1
 */