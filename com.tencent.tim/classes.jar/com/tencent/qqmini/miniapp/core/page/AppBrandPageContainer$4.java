package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class AppBrandPageContainer$4
  implements Runnable
{
  AppBrandPageContainer$4(AppBrandPageContainer paramAppBrandPageContainer, boolean paramBoolean) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(AppBrandPageContainer.access$000(this.this$0).getAttachedActivity(), 230, "重启后生效", null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new AppBrandPageContainer.4.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.4
 * JD-Core Version:    0.7.0.1
 */