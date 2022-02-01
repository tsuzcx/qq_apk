package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class EventListener$4
  implements Runnable
{
  EventListener$4(EventListener paramEventListener, IAppBrandPageContainer paramIAppBrandPageContainer, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.val$pageContainer.switchTab(this.val$url);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.4
 * JD-Core Version:    0.7.0.1
 */