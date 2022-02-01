package com.tencent.mobileqq.minigame.ui;

import arxa;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.OnChooseAdEndListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$14
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  GameActivity$14(GameActivity paramGameActivity) {}
  
  public void onChooseAdEnd(String paramString, GdtAd paramGdtAd)
  {
    if (GameActivity.access$2700(this.this$0) != 2)
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki onChooseAdEnd 还没加载完 显示广告");
      GameActivity.access$2800(this.this$0, 2);
      this.this$0.runOnUiThread(new GameActivity.14.1(this, paramString, paramGdtAd));
      return;
    }
    arxa.a().showToast("onChooseAdEnd 已经加载完了");
    QLog.d("MiniLoadingAdManager", 1, "yuki onChooseAdEnd 已经加载完了 上报");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.14
 * JD-Core Version:    0.7.0.1
 */