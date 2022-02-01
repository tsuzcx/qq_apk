package com.tencent.mobileqq.search.fragment;

import acnm;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$1$1
  implements Runnable
{
  HotWordsForSubBussFragment$1$1(HotWordsForSubBussFragment.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.val$data != null)
    {
      QLog.d(HotWordsForSubBussFragment.TAG, 1, "use cache!");
      this.a.this$0.b.a(null, 1000, this.val$data);
    }
    while (this.a.cDC) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsForSubBussFragment.TAG, 2, "hot word list cache is null！");
    }
    this.a.this$0.b.cNc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1.1
 * JD-Core Version:    0.7.0.1
 */