package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BlockAdPlugin$3
  implements Runnable
{
  BlockAdPlugin$3(BlockAdPlugin paramBlockAdPlugin, int paramInt) {}
  
  public void run()
  {
    boolean bool = this.this$0.hideBlockAd(this.val$compId);
    if (QMLog.isColorLevel()) {
      QMLog.i("BlockAdPlugin", "hideBlockAd " + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */