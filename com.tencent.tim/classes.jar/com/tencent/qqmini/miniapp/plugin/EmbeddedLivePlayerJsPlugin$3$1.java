package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;

class EmbeddedLivePlayerJsPlugin$3$1
  implements Runnable
{
  EmbeddedLivePlayerJsPlugin$3$1(EmbeddedLivePlayerJsPlugin.3 param3, AppBrandPage paramAppBrandPage) {}
  
  public void run()
  {
    this.val$showingPage.getNavBar().setVisibility(EmbeddedLivePlayerJsPlugin.access$000(this.this$1.this$0));
    this.val$showingPage.getTabBar().setVisibility(EmbeddedLivePlayerJsPlugin.access$100(this.this$1.this$0));
    EmbeddedLivePlayerJsPlugin.access$200(this.this$1.this$0);
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */