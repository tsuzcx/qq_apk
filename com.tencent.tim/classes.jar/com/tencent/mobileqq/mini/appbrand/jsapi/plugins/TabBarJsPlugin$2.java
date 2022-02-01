package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.TabBarView;
import java.lang.ref.WeakReference;

class TabBarJsPlugin$2
  implements Runnable
{
  TabBarJsPlugin$2(TabBarJsPlugin paramTabBarJsPlugin, WeakReference paramWeakReference, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    TabBarView localTabBarView = (TabBarView)this.val$tabBarViewRef.get();
    if (localTabBarView != null)
    {
      if ("showTabBar".equals(this.val$event)) {
        localTabBarView.showTabBar(this.val$isAnim);
      }
    }
    else {
      return;
    }
    localTabBarView.hideTabBar(this.val$isAnim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */