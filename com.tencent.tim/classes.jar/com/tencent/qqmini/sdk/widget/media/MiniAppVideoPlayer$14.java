package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$14
  implements Runnable
{
  MiniAppVideoPlayer$14(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    int m = 0;
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    this.this$0.isFullScreen = true;
    MiniAppVideoPlayer.access$4100(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$4200(this.this$0).setVisibility(0);
    Object localObject;
    int j;
    int k;
    int i;
    boolean bool;
    if (this.this$0.mMiniAppContext != null)
    {
      localObject = (IMiniAppContext)this.this$0.mMiniAppContext.get();
      if (localObject != null)
      {
        MiniAppVideoPlayer.access$4302(this.this$0, GetPageIntAction.obtain((IMiniAppContext)localObject).getNaviBarVisibility());
        MiniAppVideoPlayer.access$4402(this.this$0, GetPageIntAction.obtain((IMiniAppContext)localObject).getTabBarVisibility());
        SetViewVisibilityAction.obtain((IMiniAppContext)localObject).setNaviBarVisibility(8);
        SetViewVisibilityAction.obtain((IMiniAppContext)localObject).setTabBarVisibility(8);
      }
      MiniAppVideoPlayer.access$4502(this.this$0, ((CoverVideoView)this.this$0.getParent()).getLayoutParams());
      if (this.this$0.getParent().getParent() != null)
      {
        MiniAppVideoPlayer.access$4602(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
        ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
      }
      if (MiniAppVideoPlayer.access$800(this.this$0) == null) {
        break label638;
      }
      j = MiniAppVideoPlayer.access$800(this.this$0).getVideoWidth();
      k = MiniAppVideoPlayer.access$800(this.this$0).getVideoHeight();
      if (j != 0)
      {
        i = k;
        if (k != 0) {}
      }
      else
      {
        j = MiniAppVideoPlayer.access$4700(this.this$0);
        i = MiniAppVideoPlayer.access$4800(this.this$0);
      }
      if ((MiniAppVideoPlayer.access$4900(this.this$0) != 0) && (MiniAppVideoPlayer.access$4900(this.this$0) != 180)) {
        break label544;
      }
      if (j >= i) {
        break label638;
      }
      bool = false;
    }
    for (;;)
    {
      label340:
      j = DisplayUtil.getRealHeight(this.this$0.getContext());
      i = DisplayUtil.getScreenWidth(this.this$0.getContext());
      if (bool)
      {
        k = j;
        label369:
        if (bool) {
          j = i;
        }
        if ((this.this$0.mMiniAppContext == null) || (this.this$0.mMiniAppContext.get() == null) || (!((IMiniAppContext)this.this$0.mMiniAppContext.get()).isMiniGame())) {
          break label560;
        }
        localObject = new RelativeLayout.LayoutParams(k, j);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        label458:
        localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
        if (!bool) {
          break label601;
        }
        if (this.this$0.direction != -90)
        {
          i = m;
          if (this.this$0.direction != 270) {}
        }
        else
        {
          i = 8;
        }
      }
      for (;;)
      {
        localActivity.setRequestedOrientation(i);
        MiniAppVideoPlayer.access$5000(this.this$0, localActivity);
        MiniAppVideoPlayer.access$3500(this.this$0);
        MiniAppVideoPlayer.access$5100(this.this$0, bool);
        return;
        localObject = null;
        break;
        label544:
        if (j <= i) {
          break label638;
        }
        bool = false;
        break label340;
        k = i;
        break label369;
        label560:
        localObject = new FrameLayout.LayoutParams(k, j);
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label458;
        label601:
        if ((this.this$0.direction == 180) || (this.this$0.direction == -180)) {
          i = 9;
        } else {
          i = 1;
        }
      }
      label638:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.14
 * JD-Core Version:    0.7.0.1
 */