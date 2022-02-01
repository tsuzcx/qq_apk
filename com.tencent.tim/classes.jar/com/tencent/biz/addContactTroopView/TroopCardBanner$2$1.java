package com.tencent.biz.addContactTroopView;

import android.support.v4.view.ViewPager;

class TroopCardBanner$2$1
  implements Runnable
{
  TroopCardBanner$2$1(TroopCardBanner.2 param2) {}
  
  public void run()
  {
    int i = this.a.this$0.mViewPager.getCurrentItem();
    this.a.this$0.mViewPager.setCurrentItem(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner.2.1
 * JD-Core Version:    0.7.0.1
 */