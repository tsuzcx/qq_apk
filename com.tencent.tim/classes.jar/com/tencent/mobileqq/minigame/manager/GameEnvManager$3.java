package com.tencent.mobileqq.minigame.manager;

import ahbj;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.Version;
import java.util.ArrayList;
import java.util.Iterator;

final class GameEnvManager$3
  implements Runnable
{
  public void run()
  {
    Object localObject = ahbj.getFiles(GameEnvManager.access$400(), false, 0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      Version localVersion1 = GameEnvManager.access$500();
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine local:" + localVersion1);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
        if (localFileInfo.isDirectory())
        {
          Version localVersion2 = GameEnvManager.access$600(localFileInfo);
          if (localVersion1.compareTo(localVersion2) >= 0)
          {
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine delete:" + localVersion2);
            ahbj.deleteFile(localFileInfo.getPath());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEnvManager.3
 * JD-Core Version:    0.7.0.1
 */