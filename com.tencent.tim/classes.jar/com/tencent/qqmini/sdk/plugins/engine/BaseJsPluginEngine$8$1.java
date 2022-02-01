package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog.AuthDialogResBuilder;

class BaseJsPluginEngine$8$1
  implements Runnable
{
  BaseJsPluginEngine$8$1(BaseJsPluginEngine.8 param8, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    if (this.this$1.this$0.authDialog == null) {
      return;
    }
    AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
    localAuthDialogResBuilder.setMiniAppIconUrl(this.this$1.val$miniAppProxy.getDrawable(this.this$1.val$context, this.this$1.val$miniIconUrl, this.val$miniAppIconSize, this.val$miniAppIconSize, null)).setMiniAppName(this.this$1.val$miniAppName).setAuthTitle(this.this$1.val$finalAuthTitle).setUserIconUrl(this.this$1.val$miniAppProxy.getDrawable(this.this$1.val$context, this.val$avatarUrl, this.val$userIconSize, this.val$userIconSize, null)).setUserName(this.val$nickName).setAuthDesc(this.this$1.val$finalAuthDesc).setLeftBtnText("取消").setLeftBtnClickListener(new BaseJsPluginEngine.8.1.2(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.8.1.1(this));
    this.this$1.this$0.authDialog.show(localAuthDialogResBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.8.1
 * JD-Core Version:    0.7.0.1
 */