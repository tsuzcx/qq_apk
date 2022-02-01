package com.tencent.qqmini.minigame.plugins;

import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class SubpackageJsPlugin$2$1
  implements Runnable
{
  SubpackageJsPlugin$2$1(SubpackageJsPlugin.2 param2, IGameLauncher paramIGameLauncher, String paramString) {}
  
  public void run()
  {
    ScriptLoadResult localScriptLoadResult = this.val$gameLauncher.launchSubpackage(this.val$dirPath);
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubpackage " + this.this$1.val$subPackageName + " on JSThread, dirPath:" + this.val$dirPath + ", loadResult:" + localScriptLoadResult);
    if ((!localScriptLoadResult.isSuccess()) && (localScriptLoadResult == ScriptLoadResult.FAIL_COMPILE))
    {
      GameLog.getInstance().w("SubpackageJsPlugin", "retry loadSubpackage " + this.this$1.val$subPackageName + " for js compile fail");
      ThreadManager.executeOnNetworkIOThreadPool(new SubpackageJsPlugin.2.1.1(this));
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubpackage " + this.this$1.val$subPackageName + " loadFinish success? " + localScriptLoadResult);
    SubpackageJsPlugin.access$100(this.this$1.this$0, this.this$1.val$req, this.this$1.val$loadTaskId, localScriptLoadResult.isSuccess());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.SubpackageJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */