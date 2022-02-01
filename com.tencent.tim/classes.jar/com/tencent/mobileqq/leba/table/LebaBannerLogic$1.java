package com.tencent.mobileqq.leba.table;

import aimy;
import altq;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import wja;

public class LebaBannerLogic$1
  implements Runnable
{
  public LebaBannerLogic$1(aimy paramaimy) {}
  
  public void run()
  {
    if (this.this$0.mRootLayout == null)
    {
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "mRootLayout == null");
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {}
    Object localObject1;
    for (BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)localAppRuntime.getManager(36)).a(0, "100000");; localObject1 = null)
    {
      if (localAppInfo != null) {
        for (;;)
        {
          try
          {
            if (!RedTouch.c(localAppInfo)) {
              break;
            }
            if (this.this$0.mRootLayout.getChildCount() > 0)
            {
              QLog.i("Q.lebatab.LebaBannerLogic", 1, "showBannerView reused");
              localObject2 = this.this$0.mRootLayout.getChildAt(0);
              aimy.a(this.this$0, localAppRuntime, localAppInfo, (View)localObject2);
              return;
            }
          }
          catch (Exception localException)
          {
            QLog.i("Q.lebatab.LebaBannerLogic", 1, "showBannerView", localException);
            return;
          }
          QLog.i("Q.lebatab.LebaBannerLogic", 1, "showBannerView new");
          Object localObject2 = (LayoutInflater)aimy.a(this.this$0).getSystemService("layout_inflater");
          Resources localResources = aimy.a(this.this$0).getResources();
          localObject2 = ((LayoutInflater)localObject2).inflate(2131561395, null);
          this.this$0.mRootLayout.setOnClickListener(this.this$0);
          this.this$0.mRootLayout.setPadding(wja.dp2px(16.0F, localResources), wja.dp2px(12.0F, localResources), wja.dp2px(16.0F, localResources), 0);
          this.this$0.mRootLayout.addView((View)localObject2);
        }
      }
      if (this.this$0.mRootLayout.getChildCount() <= 0) {
        break;
      }
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "hideBannerView remove");
      this.this$0.mRootLayout.setPadding(0, 0, 0, 0);
      this.this$0.mRootLayout.removeAllViews();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.table.LebaBannerLogic.1
 * JD-Core Version:    0.7.0.1
 */