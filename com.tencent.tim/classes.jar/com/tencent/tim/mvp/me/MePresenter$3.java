package com.tencent.tim.mvp.me;

import android.os.SystemClock;
import anot;
import anpc;
import aqlr;
import auje.b;
import aujf;
import aunq;
import aunr;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MePresenter$3
  implements Runnable
{
  public MePresenter$3(aujf paramaujf) {}
  
  public void run()
  {
    Object localObject = aunq.a().a(aujf.a(this.this$0).a(), aujf.d(this.this$0));
    this.this$0.g.post(new MePresenter.3.1(this, (List)localObject));
    if (aujf.a(this.this$0))
    {
      aujf.a(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = aujf.a(this.this$0);
      anpc.a(BaseApplication.getContext()).collectPerformance(aqlr.getUin(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
      localObject = aunq.a().dq();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aunr localaunr = (aunr)((Iterator)localObject).next();
          if (localaunr != null)
          {
            anot.a(aujf.e(this.this$0), "CliOper", "", "", "0X8005416", "0X8005416", 0, 0, localaunr.c.uiResId + "", "", "", "");
            if (!"PKG_SCHEDULE".equals(localaunr.c.strPkgName)) {}
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.me.MePresenter.3
 * JD-Core Version:    0.7.0.1
 */