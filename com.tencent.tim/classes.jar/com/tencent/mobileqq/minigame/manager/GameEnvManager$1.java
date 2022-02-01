package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;

final class GameEnvManager$1
  implements Runnable
{
  public void run()
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 开始请求线上最新版本");
    MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new GameEnvManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEnvManager.1
 * JD-Core Version:    0.7.0.1
 */