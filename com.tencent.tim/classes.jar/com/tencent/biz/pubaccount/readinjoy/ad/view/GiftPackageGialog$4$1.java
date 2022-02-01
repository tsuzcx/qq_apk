package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import kkn;
import klt;
import kns;
import kns.a;

class GiftPackageGialog$4$1
  implements Runnable
{
  GiftPackageGialog$4$1(GiftPackageGialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    int j = 2;
    Object localObject = "";
    if (!TextUtils.isEmpty((CharSequence)this.b.second)) {
      localObject = (String)this.b.second;
    }
    if ((((Boolean)this.b.first).booleanValue()) && (TextUtils.isEmpty((CharSequence)this.b.second))) {}
    for (int i = 0;; i = 2)
    {
      if (((Boolean)this.b.first).booleanValue()) {}
      for (;;)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), j, (CharSequence)localObject, 0).show();
        if (this.a.this$0.isShowing()) {
          this.a.this$0.dismiss();
        }
        if (((Boolean)this.b.first).booleanValue())
        {
          localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            klt.z(((QQAppInterface)localObject).getAccount(), kns.a(this.a.this$0));
            if (kns.a(this.a.this$0) != null) {
              kns.a(this.a.this$0).el(kns.a(this.a.this$0));
            }
          }
          if (!kns.b(this.a.this$0)) {
            klt.a(11, kns.a(this.a.this$0), kns.c(this.a.this$0), 30103, 3010305, 301);
          }
        }
        if ((kns.b(this.a.this$0)) && (kns.a(this.a.this$0) != null)) {
          kkn.b(kns.a(this.a.this$0), i, kns.d(this.a.this$0));
        }
        return;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4.1
 * JD-Core Version:    0.7.0.1
 */