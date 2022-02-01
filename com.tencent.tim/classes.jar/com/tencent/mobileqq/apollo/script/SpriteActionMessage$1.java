package com.tencent.mobileqq.apollo.script;

import abhh;
import abhs;
import abqs;
import abrc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class SpriteActionMessage$1
  implements Runnable
{
  public SpriteActionMessage$1(abqs paramabqs, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((abqs.a(this.this$0) != null) && (abqs.a(this.this$0).getApp() != null))
    {
      abhs localabhs = ((abhh)abqs.a(this.this$0).getApp().getManager(153)).a();
      if (localabhs != null)
      {
        localabhs.aR.set(this.cqQ);
        localabhs.p(this.cqQ, true, this.bEN);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.1
 * JD-Core Version:    0.7.0.1
 */