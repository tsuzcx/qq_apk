package com.tencent.mobileqq.search.fragment;

import acnk;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class HotWordsForSubBussFragment$2
  implements Runnable
{
  HotWordsForSubBussFragment$2(HotWordsForSubBussFragment paramHotWordsForSubBussFragment, boolean paramBoolean) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.this$0.a.s(acnk.bpQ);
    ThreadManager.getUIHandler().post(new HotWordsForSubBussFragment.2.1(this, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.2
 * JD-Core Version:    0.7.0.1
 */