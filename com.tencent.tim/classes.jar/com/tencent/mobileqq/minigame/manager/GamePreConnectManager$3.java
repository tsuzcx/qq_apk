package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Set;

final class GamePreConnectManager$3
  implements Runnable
{
  GamePreConnectManager$3(String paramString) {}
  
  public void run()
  {
    if (GamePreConnectManager.access$000()) {
      GameLog.getInstance().e("GamePreConnectManager", "had saved, no saved needed");
    }
    while ((GamePreConnectManager.access$100().isEmpty()) || (TextUtils.isEmpty(this.val$appId))) {
      return;
    }
    String str = TextUtils.join(",", GamePreConnectManager.access$100());
    GamePreConnectManager.access$400("MiniGamePreConnect", this.val$appId, str);
    GameLog.getInstance().i("GamePreConnectManager", "save connect host " + GamePreConnectManager.access$100().size());
    GamePreConnectManager.access$100().clear();
    GamePreConnectManager.access$002(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.3
 * JD-Core Version:    0.7.0.1
 */