package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class EventListener$6
  implements Runnable
{
  EventListener$6(EventListener paramEventListener, IAppBrandPageContainer paramIAppBrandPageContainer, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$pageContainer.navigateTo(this.val$url, this.val$req.callbackId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.6
 * JD-Core Version:    0.7.0.1
 */