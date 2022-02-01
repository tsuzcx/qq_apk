package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;

class SubpackageJsPlugin$3$1
  implements Runnable
{
  SubpackageJsPlugin$3$1(SubpackageJsPlugin.3 param3, IGameLauncher paramIGameLauncher, String paramString) {}
  
  public void run()
  {
    ScriptLoadResult localScriptLoadResult = this.val$gameLauncher.launchSubpackage(this.val$dirPath);
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubpackage " + this.this$1.val$subPackageName + " on JSThread, dirPath:" + this.val$dirPath + ", loadResult:" + localScriptLoadResult);
    if ((!localScriptLoadResult.isSuccess()) && (localScriptLoadResult == ScriptLoadResult.FAIL_COMPILE))
    {
      GameLog.getInstance().w("SubpackageJsPlugin", "retry loadSubpackage " + this.this$1.val$subPackageName + " for js compile fail");
      ThreadManagerV2.excute(new SubpackageJsPlugin.3.1.1(this), 16, null, false);
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubpackage " + this.this$1.val$subPackageName + " loadFinish success? " + localScriptLoadResult);
    SubpackageJsPlugin.access$000(this.this$1.this$0, this.this$1.val$webviewRef, this.this$1.val$taskId, localScriptLoadResult.isSuccess());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */