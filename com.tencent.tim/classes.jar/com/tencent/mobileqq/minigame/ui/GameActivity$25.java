package com.tencent.mobileqq.minigame.ui;

import aebf;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class GameActivity$25
  implements aebf
{
  GameActivity$25(GameActivity paramGameActivity) {}
  
  public ColorNote getColorNote()
  {
    if ((this.this$0.mGameAppConfig == null) || (this.this$0.mGameAppConfig.config == null))
    {
      QLog.e("[minigame] GameActivity", 1, "getColorNote, appConfig: " + this.this$0.mGameAppConfig);
      return null;
    }
    byte[] arrayOfByte = MiniAppUtils.packMiniAppInfo(this.this$0.mGameAppConfig.config);
    return new ColorNote.a().a(16842752).a(this.this$0.mGameAppConfig.config.appId).b(this.this$0.mGameAppConfig.config.name).c(this.this$0.mGameAppConfig.config.desc).d(this.this$0.mGameAppConfig.config.iconUrl).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.25
 * JD-Core Version:    0.7.0.1
 */