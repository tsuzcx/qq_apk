package com.tencent.imcore.message;

import java.util.Map;
import toa;
import top;

class C2CMessageManager$2$2
  implements Runnable
{
  C2CMessageManager$2$2(C2CMessageManager.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.b.gQ.containsKey(top.u(this.a.val$uin, this.a.val$type))) {
      this.a.this$0.b.gQ.remove(top.u(this.a.val$uin, this.a.val$type));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2.2
 * JD-Core Version:    0.7.0.1
 */