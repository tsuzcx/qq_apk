package com.tencent.gdtad.aditem;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import tgh;
import tgi;
import tkw;

public class GdtPreLoader$1
  implements Runnable
{
  public GdtPreLoader$1(tgh paramtgh, GdtAd paramGdtAd) {}
  
  public void run()
  {
    if ((this.b == null) || (!this.b.isValid())) {
      tkw.e("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        tkw.i("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.b.isQQMINIProgram());
      tkw.i("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.b.canPreloadForQQMINIProgram()) }));
    } while ((!this.b.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.b.getUrlForLandingPage())));
    tkw.i("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(this.b.getUrlForLandingPage(), false, new tgi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */