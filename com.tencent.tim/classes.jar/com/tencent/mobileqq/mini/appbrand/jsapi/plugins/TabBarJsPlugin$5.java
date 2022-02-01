package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.TabBarView;
import java.lang.ref.WeakReference;

class TabBarJsPlugin$5
  implements Runnable
{
  TabBarJsPlugin$5(TabBarJsPlugin paramTabBarJsPlugin, WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    TabBarView localTabBarView = (TabBarView)this.val$tabBarViewRef.get();
    if (localTabBarView != null)
    {
      if (!this.val$type.equals("text")) {
        break label40;
      }
      localTabBarView.setTabBarBadge(this.val$index, this.val$text);
    }
    label40:
    do
    {
      return;
      if (this.val$type.equals("redDot"))
      {
        localTabBarView.showTabBarRedDot(this.val$index);
        return;
      }
    } while (!this.val$type.equals("none"));
    localTabBarView.hideBadge(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */