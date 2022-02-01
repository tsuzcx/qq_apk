package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import klt;
import kns;
import mqq.os.MqqHandler;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(kns paramkns) {}
  
  public void run()
  {
    if ((kns.a(this.this$0) != null) && (kns.b(this.this$0) != null) && (kns.c(this.this$0) != null))
    {
      Pair localPair = klt.a(kns.a(this.this$0), kns.a(this.this$0).v, kns.b(this.this$0).v, kns.c(this.this$0).ck, kns.b(this.this$0), kns.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!kns.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    klt.a(10, kns.a(this.this$0), kns.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */