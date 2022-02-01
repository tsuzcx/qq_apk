package com.tencent.mobileqq.utils;

import aqjn;
import aqjp;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$2$1
  implements Runnable
{
  public QQCustomArkDialog$2$1(aqjp paramaqjp, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    aqjn localaqjn = (aqjn)this.val$weakSelf.get();
    if (localaqjn == null) {
      return;
    }
    aqjn.a(localaqjn, this.val$state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.1
 * JD-Core Version:    0.7.0.1
 */