package com.tencent.mobileqq.activity.qwallet.utils;

import aadk;
import aadk.a;
import aagd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.lang.ref.WeakReference;

public final class QWalletTools$3
  implements Runnable
{
  public QWalletTools$3(WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.eJ.get();
    RedDotImageView localRedDotImageView = (RedDotImageView)this.W.get();
    if ((localObject != null) && (localRedDotImageView != null))
    {
      localObject = (aadk)((QQAppInterface)localObject).getManager(273);
      aadk.a locala = ((aadk)localObject).a("2001");
      if ((locala.bvg) && (aagd.J(locala.buffer, this.cgr)))
      {
        ((aadk)localObject).Ag("2001");
        localRedDotImageView.post(new QWalletTools.3.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.3
 * JD-Core Version:    0.7.0.1
 */