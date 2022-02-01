package com.tencent.mobileqq.ark.API;

import adno;
import adno.a;
import adno.c;

public class ArkAppEventObserverManager$ArkConnectionHandler$3
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$3(adno.a parama) {}
  
  public void run()
  {
    if ((adno.a(this.b.this$0) != null) && (!"wifi".equals(adno.b(this.b.this$0))))
    {
      adno.a(this.b.this$0).az(true, "wifi");
      adno.a(this.b.this$0, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3
 * JD-Core Version:    0.7.0.1
 */