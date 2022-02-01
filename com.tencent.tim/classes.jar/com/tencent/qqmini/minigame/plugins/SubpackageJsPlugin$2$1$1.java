package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.io.File;

class SubpackageJsPlugin$2$1$1
  implements Runnable
{
  SubpackageJsPlugin$2$1$1(SubpackageJsPlugin.2.1 param1) {}
  
  public void run()
  {
    FileUtils.deleteFile(new File(ApkgManager.getApkgFolderPath(SubpackageJsPlugin.access$400(this.this$2.this$1.this$0)), this.this$2.val$dirPath));
    SubpackageJsPlugin.access$000(this.this$2.this$1.this$0, this.this$2.this$1.val$req, this.this$2.this$1.val$loadTaskId, this.this$2.this$1.val$subPackageName, this.this$2.this$1.val$miniGamePkg, this.this$2.this$1.val$tryCount + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.SubpackageJsPlugin.2.1.1
 * JD-Core Version:    0.7.0.1
 */