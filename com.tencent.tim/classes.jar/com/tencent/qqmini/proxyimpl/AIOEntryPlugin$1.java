package com.tencent.qqmini.proxyimpl;

import astj;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

public class AIOEntryPlugin$1
  implements Runnable
{
  public AIOEntryPlugin$1(astj paramastj, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((astj.a(this.this$0).getAttachedActivity() instanceof GameActivity1)) {}
    for (boolean bool = ((GameActivity1)astj.b(this.this$0).getAttachedActivity()).showMiniAIOEntrance(this.val$jsonObject); bool; bool = false)
    {
      this.val$req.ok();
      return;
      if ((astj.c(this.this$0) instanceof AppBrandRuntime))
      {
        IPage localIPage = ((AppBrandRuntime)astj.d(this.this$0)).getPage();
        if ((localIPage instanceof AppBrandPageContainer)) {
          ((AppBrandPageContainer)localIPage).getShowingPage().showMiniAIOEntrance(this.val$jsonObject);
        }
      }
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1
 * JD-Core Version:    0.7.0.1
 */