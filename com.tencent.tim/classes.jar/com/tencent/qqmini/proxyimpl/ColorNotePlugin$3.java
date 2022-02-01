package com.tencent.qqmini.proxyimpl;

import aeay;
import asuh;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class ColorNotePlugin$3
  implements Runnable
{
  public ColorNotePlugin$3(asuh paramasuh, aeay paramaeay, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$finalColorNoteController.onCannotAdd();
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.3
 * JD-Core Version:    0.7.0.1
 */