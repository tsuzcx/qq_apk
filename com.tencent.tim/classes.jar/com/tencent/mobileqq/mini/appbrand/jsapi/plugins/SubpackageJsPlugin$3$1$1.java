package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ahbj;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import java.io.File;

class SubpackageJsPlugin$3$1$1
  implements Runnable
{
  SubpackageJsPlugin$3$1$1(SubpackageJsPlugin.3.1 param1) {}
  
  public void run()
  {
    ahbj.deleteFile(new File(ApkgManager.getApkgFolderPath(this.this$2.this$1.val$miniGamePkg.appConfig.config), this.this$2.val$dirPath));
    SubpackageJsPlugin.access$100(this.this$2.this$1.this$0, this.this$2.this$1.val$webviewRef, this.this$2.this$1.val$taskId, this.this$2.this$1.val$subPackageName, this.this$2.this$1.val$currentLoader, this.this$2.this$1.val$miniGamePkg, this.this$2.this$1.val$tryCount + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.3.1.1
 * JD-Core Version:    0.7.0.1
 */