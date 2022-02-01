package com.tencent.mobileqq.ark.API;

import adno;
import adno.a;
import adno.c;

public class ArkAppEventObserverManager$ArkConnectionHandler$4
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$4(adno.a parama) {}
  
  public void run()
  {
    if ((adno.a(this.b.this$0) != null) && (!"cellular".equals(adno.b(this.b.this$0))))
    {
      adno.a(this.b.this$0).az(true, "cellular");
      adno.a(this.b.this$0, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4
 * JD-Core Version:    0.7.0.1
 */