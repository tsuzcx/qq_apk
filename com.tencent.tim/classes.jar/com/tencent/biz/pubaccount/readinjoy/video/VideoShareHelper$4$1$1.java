package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import myq;
import myu;
import myv;
import ndi;

public class VideoShareHelper$4$1$1
  implements Runnable
{
  public VideoShareHelper$4$1$1(myv parammyv) {}
  
  public void run()
  {
    myq.a(this.a.a.a).j(this.a.a.m);
    if ((myq.a(this.a.a.a) instanceof BaseActivity)) {
      QQToast.a(myq.a(this.a.a.a), -1, myq.a(this.a.a.a).getString(2131701914), 0).show(((BaseActivity)myq.a(this.a.a.a)).getTitleBarHeight());
    }
    for (;;)
    {
      myq.a(this.a.a.a).a(myq.a(this.a.a.a), this.a.a.m, this.a.kM);
      return;
      if ((myq.a(this.a.a.a) instanceof PluginBaseActivity)) {
        QQToast.a(myq.a(this.a.a.a), -1, myq.a(this.a.a.a).getString(2131701914), 0).show(((PluginBaseActivity)myq.a(this.a.a.a)).getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper.4.1.1
 * JD-Core Version:    0.7.0.1
 */