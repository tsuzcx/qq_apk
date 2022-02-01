package com.tencent.imcore.message;

import java.util.Map;
import tnu;
import top;

class BaseMessageManagerForTroopAndDisc$4$1
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$4$1(BaseMessageManagerForTroopAndDisc.4 param4) {}
  
  public void run()
  {
    if (this.a.this$0.b.gQ.containsKey(top.u(this.a.val$uin, this.a.val$type))) {
      this.a.this$0.b.gQ.remove(top.u(this.a.val$uin, this.a.val$type));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4.1
 * JD-Core Version:    0.7.0.1
 */