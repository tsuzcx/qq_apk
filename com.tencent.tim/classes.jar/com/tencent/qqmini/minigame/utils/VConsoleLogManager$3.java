package com.tencent.qqmini.minigame.utils;

class VConsoleLogManager$3
  implements Runnable
{
  VConsoleLogManager$3(VConsoleLogManager paramVConsoleLogManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    VConsoleLogManager.access$200(this.this$0, "javascript:console." + this.val$logLevel + "(\"" + this.val$logContent + "\")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.VConsoleLogManager.3
 * JD-Core Version:    0.7.0.1
 */