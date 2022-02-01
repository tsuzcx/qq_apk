package com.tencent.mobileqq.fragment;

import aqyg;
import com.tencent.biz.ui.TouchWebView;

class NearbyBaseFragment$1
  implements Runnable
{
  NearbyBaseFragment$1(NearbyBaseFragment paramNearbyBaseFragment, aqyg paramaqyg) {}
  
  public void run()
  {
    this.a.mWebview.flingScroll(0, -this.this$0.mVelocity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */