package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import klt;
import kns;
import knu;
import mqq.os.MqqHandler;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(knu paramknu) {}
  
  public void run()
  {
    if ((kns.a(this.a.this$0) != null) && (kns.b(this.a.this$0) != null))
    {
      kns.b(this.a.this$0, klt.a(kns.a(this.a.this$0), kns.a(this.a.this$0).v, kns.b(this.a.this$0).v, kns.b(this.a.this$0).s));
      if ((kns.c(this.a.this$0) == null) || (kns.c(this.a.this$0).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */