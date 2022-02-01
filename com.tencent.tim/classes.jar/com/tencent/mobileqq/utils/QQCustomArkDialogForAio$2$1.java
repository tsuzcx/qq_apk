package com.tencent.mobileqq.utils;

import aqjq;
import aqjs;
import java.lang.ref.WeakReference;

public class QQCustomArkDialogForAio$2$1
  implements Runnable
{
  public QQCustomArkDialogForAio$2$1(aqjs paramaqjs, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    aqjq localaqjq = (aqjq)this.val$weakSelf.get();
    if (localaqjq != null) {
      aqjq.a(localaqjq, this.val$state);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2.1
 * JD-Core Version:    0.7.0.1
 */