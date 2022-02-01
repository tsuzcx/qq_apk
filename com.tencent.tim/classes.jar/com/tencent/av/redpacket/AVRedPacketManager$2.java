package com.tencent.av.redpacket;

import irs;
import irt;

public class AVRedPacketManager$2
  implements Runnable
{
  AVRedPacketManager$2(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    AVRedPacketManager.a(this.this$0, this.this$0.asN);
    long l = System.currentTimeMillis();
    this.this$0.a.a(new irs(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.2
 * JD-Core Version:    0.7.0.1
 */