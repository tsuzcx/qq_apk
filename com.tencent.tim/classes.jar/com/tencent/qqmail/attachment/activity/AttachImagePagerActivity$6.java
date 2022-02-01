package com.tencent.qqmail.attachment.activity;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.activity.media.ImagePagerAdapter.OnItemLongClickListener;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.utilities.OneStepUtils;
import java.util.List;

class AttachImagePagerActivity$6
  implements ImagePagerAdapter.OnItemLongClickListener
{
  AttachImagePagerActivity$6(AttachImagePagerActivity paramAttachImagePagerActivity) {}
  
  public void onItemLongClick(int paramInt, View paramView)
  {
    paramInt = AttachImagePagerActivity.access$400(this.this$0).getCurrentItem();
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)AttachImagePagerActivity.access$500(this.this$0).get(paramInt);
    if (localMediaItemInfo != null) {
      OneStepUtils.dragImageByOneStep(paramView, localMediaItemInfo.getDataPath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.6
 * JD-Core Version:    0.7.0.1
 */