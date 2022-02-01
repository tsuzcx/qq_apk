package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$4
  implements Runnable
{
  MiniAppLivePlayer$4(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverLiveView)));
    this.this$0.isFullScreen = true;
    if (this.this$0.webviewContainer != null)
    {
      MiniAppLivePlayer.access$002(this.this$0, this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().getVisibility());
      this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().setVisibility(8);
      MiniAppLivePlayer.access$102(this.this$0, this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().getVisibility());
      this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().setVisibility(8);
    }
    MiniAppLivePlayer.access$202(this.this$0, ((CoverLiveView)this.this$0.getParent()).getLayoutParams());
    if (this.this$0.getParent().getParent() != null)
    {
      MiniAppLivePlayer.access$302(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
    }
    Object localObject;
    if (this.this$0.webviewContainer == null)
    {
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.getRealHeight(this.this$0.getContext()), ImmersiveUtils.getScreenWidth());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      ((CoverLiveView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
      if ((this.this$0.direction != -90) && (this.this$0.direction != 270)) {
        break label409;
      }
      localActivity.setRequestedOrientation(8);
    }
    for (;;)
    {
      MiniAppLivePlayer.access$400(this.this$0, localActivity);
      MiniAppLivePlayer.access$500(this.this$0);
      return;
      localObject = new FrameLayout.LayoutParams(DisplayUtil.getRealHeight(this.this$0.getContext()), ImmersiveUtils.getScreenWidth());
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      ((CoverLiveView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label409:
      if (this.this$0.direction == 0) {
        localActivity.setRequestedOrientation(1);
      } else if ((this.this$0.direction == 180) || (this.this$0.direction == -180)) {
        localActivity.setRequestedOrientation(9);
      } else {
        localActivity.setRequestedOrientation(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer.4
 * JD-Core Version:    0.7.0.1
 */