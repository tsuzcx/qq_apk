package com.tencent.qqmail.activity.media;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.utilities.OneStepUtils;
import java.util.List;

class MeidaBigBucketSelectActivity$3
  implements ImagePagerAdapter.OnItemLongClickListener
{
  MeidaBigBucketSelectActivity$3(MeidaBigBucketSelectActivity paramMeidaBigBucketSelectActivity) {}
  
  public void onItemLongClick(int paramInt, View paramView)
  {
    paramInt = MeidaBigBucketSelectActivity.access$200(this.this$0).getCurrentItem();
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)MeidaBigBucketSelectActivity.access$300(this.this$0).get(paramInt);
    if (localMediaItemInfo != null) {
      OneStepUtils.dragImageByOneStep(paramView, localMediaItemInfo.getDataPath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity.3
 * JD-Core Version:    0.7.0.1
 */