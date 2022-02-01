package com.tencent.biz.pubaccount.readinjoy.redpacket;

import java.util.List;

class RIJRedPacketManager$10$1
  implements Runnable
{
  RIJRedPacketManager$10$1(RIJRedPacketManager.10 param10, List paramList) {}
  
  public void run()
  {
    if ((this.val$list != null) && (!this.val$list.isEmpty()))
    {
      this.a.a.a((RedPacketTaskData)this.val$list.get(0));
      return;
    }
    this.a.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.10.1
 * JD-Core Version:    0.7.0.1
 */