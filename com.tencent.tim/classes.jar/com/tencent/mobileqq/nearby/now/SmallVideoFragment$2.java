package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;

class SmallVideoFragment$2
  implements Runnable
{
  SmallVideoFragment$2(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void run()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.this$0.a.getAdapter();
    if ((localVideoPlayerPagerAdapter.getView(this.this$0.a.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.getView(this.this$0.a.getCurrentItem())).aGy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */