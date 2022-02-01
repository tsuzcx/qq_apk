package com.tencent.qqmini.sdk.cache;

class MiniCacheFreeManager$3
  implements Runnable
{
  MiniCacheFreeManager$3(MiniCacheFreeManager paramMiniCacheFreeManager, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    MiniCacheFreeManager.access$600(this.val$appId);
    MiniCacheFreeManager.access$700(this.val$appId);
    MiniCacheFreeManager.access$800(this.val$uin, this.val$appId);
    MiniCacheFreeManager.access$900(this.val$uin, this.val$appId);
    MiniCacheFreeManager.access$1000(this.val$appId);
    if (this.val$killSelf) {
      MiniCacheFreeManager.access$1100(this.val$appId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.3
 * JD-Core Version:    0.7.0.1
 */