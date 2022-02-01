package com.tencent.qqmini.sdk.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

final class BannerAdViolationManager$2
  implements View.OnClickListener
{
  BannerAdViolationManager$2(View.OnClickListener paramOnClickListener, long paramLong, View paramView, float[] paramArrayOfFloat, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.val$oldOnClickListener != null) {
      this.val$oldOnClickListener.onClick(paramView);
    }
    long l = 0L;
    Long localLong = (Long)BannerAdViolationManager.access$000().get(Long.valueOf(this.val$aid));
    if (localLong != null) {
      l = System.currentTimeMillis() - localLong.longValue();
    }
    int j = this.val$view.getWidth() / 5;
    int k = this.val$view.getHeight() / 2;
    if (this.val$lastTouchDownXY[1] > k) {}
    for (int i = (int)this.val$lastTouchDownXY[0] / j + 6;; i = (int)this.val$lastTouchDownXY[0] / j + 1)
    {
      QMLog.d("BannerAdViolationManage", "box = " + j + "," + k + " size = " + this.val$view.getWidth() + "," + this.val$view.getHeight() + " x,y = " + this.val$lastTouchDownXY[0] + "," + this.val$lastTouchDownXY[1] + " area = " + i);
      BannerAdViolationManager.access$100(this.val$miniAppId, this.val$aid, i, l);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BannerAdViolationManager.2
 * JD-Core Version:    0.7.0.1
 */