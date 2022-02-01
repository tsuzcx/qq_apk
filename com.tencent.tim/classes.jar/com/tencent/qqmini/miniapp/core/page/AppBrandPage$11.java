package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.widget.TabBar;

class AppBrandPage$11
  implements Runnable
{
  AppBrandPage$11(AppBrandPage paramAppBrandPage, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (AppBrandPage.access$300(this.this$0) != null)
    {
      if (!this.val$type.equals("text")) {
        break label41;
      }
      AppBrandPage.access$300(this.this$0).setTabBarBadge(this.val$index, this.val$text);
    }
    label41:
    do
    {
      return;
      if (this.val$type.equals("redDot"))
      {
        AppBrandPage.access$300(this.this$0).showTabBarRedDot(this.val$index);
        return;
      }
    } while (!this.val$type.equals("none"));
    AppBrandPage.access$300(this.this$0).hideBadge(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPage.11
 * JD-Core Version:    0.7.0.1
 */