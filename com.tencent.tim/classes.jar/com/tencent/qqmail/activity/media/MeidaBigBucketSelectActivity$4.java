package com.tencent.qqmail.activity.media;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import java.util.List;

class MeidaBigBucketSelectActivity$4
  extends ViewPager.SimpleOnPageChangeListener
{
  MeidaBigBucketSelectActivity$4(MeidaBigBucketSelectActivity paramMeidaBigBucketSelectActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    MeidaBigBucketSelectActivity.access$102(this.this$0, false);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    MeidaBigBucketSelectActivity.access$400(this.this$0, paramInt);
    MeidaBigBucketSelectActivity.access$502(this.this$0, paramInt);
    MeidaBigBucketSelectActivity.access$102(this.this$0, false);
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)MeidaBigBucketSelectActivity.access$300(this.this$0).get(paramInt);
    this.this$0.checkMediaType(localMediaItemInfo.getDataPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity.4
 * JD-Core Version:    0.7.0.1
 */