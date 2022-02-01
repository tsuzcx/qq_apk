package com.tencent.mobileqq.ark.API;

import adno;
import adno.a;
import adno.c;

public class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$6(adno.a parama) {}
  
  public void run()
  {
    if ((adno.a(this.b.this$0) != null) && (!"none".equals(adno.b(this.b.this$0))))
    {
      adno.a(this.b.this$0).az(true, "none");
      adno.a(this.b.this$0, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */