package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Set;

final class GamePreConnectManager$2
  implements Runnable
{
  GamePreConnectManager$2(int paramInt, String paramString) {}
  
  public void run()
  {
    if (GamePreConnectManager.access$000()) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((GamePreConnectManager.access$100().size() >= GamePreConnectManager.access$200()) || (this.val$returnCode < 200) || (this.val$returnCode > 300));
      str = GamePreConnectManager.access$300(this.val$url);
    } while ((TextUtils.isEmpty(str)) || (!GamePreConnectManager.access$100().add(str)));
    GameLog.getInstance().i("GamePreConnectManager", "insert host: " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.2
 * JD-Core Version:    0.7.0.1
 */