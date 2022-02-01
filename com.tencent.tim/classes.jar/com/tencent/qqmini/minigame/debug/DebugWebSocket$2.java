package com.tencent.qqmini.minigame.debug;

import java.util.ArrayList;

class DebugWebSocket$2
  implements Runnable
{
  DebugWebSocket$2(DebugWebSocket paramDebugWebSocket, String paramString) {}
  
  public void run()
  {
    if (DebugWebSocket.access$000(this.this$0).size() < 64) {
      DebugWebSocket.access$000(this.this$0).add(this.val$message);
    }
    this.this$0.excuteSocketMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.DebugWebSocket.2
 * JD-Core Version:    0.7.0.1
 */