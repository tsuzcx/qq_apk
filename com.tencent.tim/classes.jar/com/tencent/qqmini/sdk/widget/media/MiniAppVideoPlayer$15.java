package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.GetPageStringAction;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$15
  implements Runnable
{
  MiniAppVideoPlayer$15(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
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
    } while ((localActivity == null) || (MiniAppVideoPlayer.access$800(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverVideoView)) || (!this.this$0.isFullScreen));
    MiniAppVideoPlayer.access$5202(this.this$0, MiniAppVideoPlayer.access$800(this.this$0).getCurrentPostion());
    QMLog.d("MiniAppVideoPlayer", "smallScreen current pos is: " + MiniAppVideoPlayer.access$5200(this.this$0));
    this.this$0.isFullScreen = false;
    MiniAppVideoPlayer.access$5300(this.this$0);
    MiniAppVideoPlayer.access$4100(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$4200(this.this$0).setVisibility(8);
    IMiniAppContext localIMiniAppContext;
    String str;
    int i;
    if (this.this$0.mMiniAppContext != null)
    {
      localIMiniAppContext = (IMiniAppContext)this.this$0.mMiniAppContext.get();
      if (localIMiniAppContext != null)
      {
        SetViewVisibilityAction.obtain(localIMiniAppContext).setNaviBarVisibility(MiniAppVideoPlayer.access$4300(this.this$0));
        SetViewVisibilityAction.obtain(localIMiniAppContext).setTabBarVisibility(MiniAppVideoPlayer.access$4400(this.this$0));
      }
      localActivity.getWindow().clearFlags(1024);
      if (localIMiniAppContext != null)
      {
        str = GetPageStringAction.obtain(localIMiniAppContext).getPageOrientation();
        if (!WindowInfo.ORIENTATION_AUTO.equals(str)) {
          break label361;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label251:
      localActivity.setRequestedOrientation(i);
      if (!localIMiniAppContext.isMiniGame()) {
        if (Build.VERSION.SDK_INT >= 16) {
          localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
      }
      for (;;)
      {
        try
        {
          i = GetPageIntAction.obtain(localIMiniAppContext).getNaviBarTextStyle();
          if (i != -1) {
            continue;
          }
          ImmersiveUtils.setStatusTextColor(false, localActivity.getWindow());
        }
        catch (Exception localException)
        {
          label361:
          QMLog.e("MiniAppVideoPlayer", "smallScreen: ", localException);
          continue;
          i = 1;
        }
        this.this$0.lastSmallScreenTime = System.currentTimeMillis();
        this.this$0.isBusyInChangeScreen = true;
        MiniAppVideoPlayer.access$3900(this.this$0).postDelayed(new MiniAppVideoPlayer.15.1(this), 200L);
        MiniAppVideoPlayer.access$3500(this.this$0);
        return;
        localIMiniAppContext = null;
        break;
        if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(str)) {
          continue;
        }
        i = 0;
        break label251;
        if (i == -16777216) {
          ImmersiveUtils.setStatusTextColor(true, localActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.15
 * JD-Core Version:    0.7.0.1
 */