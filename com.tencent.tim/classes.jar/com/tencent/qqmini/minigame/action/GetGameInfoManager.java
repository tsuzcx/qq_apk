package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class GetGameInfoManager
  implements Action<GameInfoManager>
{
  public static GameInfoManager obtain(IMiniAppContext paramIMiniAppContext)
  {
    return (GameInfoManager)paramIMiniAppContext.performAction(new GetGameInfoManager());
  }
  
  public GameInfoManager perform(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime instanceof GameRuntime)) {
      return ((GameRuntime)paramBaseRuntime).getGameInfoManager();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.GetGameInfoManager
 * JD-Core Version:    0.7.0.1
 */