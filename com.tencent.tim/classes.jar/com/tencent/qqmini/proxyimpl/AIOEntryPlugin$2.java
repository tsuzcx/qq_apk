package com.tencent.qqmini.proxyimpl;

import astj;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class AIOEntryPlugin$2
  implements Runnable
{
  public AIOEntryPlugin$2(astj paramastj, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((astj.e(this.this$0).getAttachedActivity() instanceof GameActivity1)) {
      ((GameActivity1)astj.f(this.this$0).getAttachedActivity()).hideMiniAIOEntrance();
    }
    for (;;)
    {
      this.val$req.ok();
      return;
      if ((astj.g(this.this$0) instanceof AppBrandRuntime))
      {
        IPage localIPage = ((AppBrandRuntime)astj.h(this.this$0)).getPage();
        if ((localIPage instanceof AppBrandPageContainer)) {
          ((AppBrandPageContainer)localIPage).getShowingPage().hideMiniAIOEntrance();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2
 * JD-Core Version:    0.7.0.1
 */