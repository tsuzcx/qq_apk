package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.TabBarView;
import java.lang.ref.WeakReference;

class TabBarJsPlugin$8
  implements Runnable
{
  TabBarJsPlugin$8(TabBarJsPlugin paramTabBarJsPlugin, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    TabBarView localTabBarView = (TabBarView)this.val$tabBarViewRef.get();
    if (localTabBarView != null) {
      localTabBarView.hideTabBarRedDot(this.val$index);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */