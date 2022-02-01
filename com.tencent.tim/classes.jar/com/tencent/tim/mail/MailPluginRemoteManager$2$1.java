package com.tencent.tim.mail;

import augt;
import augt.a;
import augu;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MailPluginRemoteManager$2$1
  implements Runnable
{
  public MailPluginRemoteManager$2$1(augu paramaugu) {}
  
  public void run()
  {
    while (!this.a.this$0.c.isEmpty())
    {
      augt.a locala = (augt.a)this.a.this$0.c.poll();
      if (locala != null) {
        augt.a(this.a.this$0, locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginRemoteManager.2.1
 * JD-Core Version:    0.7.0.1
 */