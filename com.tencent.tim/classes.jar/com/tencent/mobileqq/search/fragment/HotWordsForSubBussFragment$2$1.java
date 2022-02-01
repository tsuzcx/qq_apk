package com.tencent.mobileqq.search.fragment;

import acnk;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$2$1
  implements Runnable
{
  HotWordsForSubBussFragment$2$1(HotWordsForSubBussFragment.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.val$data != null)
    {
      QLog.d(HotWordsForSubBussFragment.TAG, 1, "UnifySearchHandler use cache!");
      this.a.this$0.a.a(null, 1000, this.val$data);
    }
    while (this.a.cDC) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsForSubBussFragment.TAG, 2, "UnifySearchHandler hot word list cache is null！");
    }
    this.a.this$0.a.cNc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.2.1
 * JD-Core Version:    0.7.0.1
 */