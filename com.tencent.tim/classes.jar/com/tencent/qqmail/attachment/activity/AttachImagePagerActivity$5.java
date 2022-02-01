package com.tencent.qqmail.attachment.activity;

import android.content.res.Resources;
import android.view.View;
import com.tencent.qqmail.activity.media.ImagePagerAdapter.OnItemClickListener;
import com.tencent.qqmail.utilities.animation.AnimUtil;
import com.tencent.qqmail.view.QMTopBar;

class AttachImagePagerActivity$5
  implements ImagePagerAdapter.OnItemClickListener
{
  AttachImagePagerActivity$5(AttachImagePagerActivity paramAttachImagePagerActivity) {}
  
  public void onItemClick(int paramInt, boolean paramBoolean)
  {
    if (AttachImagePagerActivity.access$300(this.this$0).isVisible())
    {
      localView = AttachImagePagerActivity.access$300(this.this$0).getButtonRight();
      if (localView != null) {
        localView.setClickable(false);
      }
      AnimUtil.playAlphaBackgroundColor(this.this$0.findViewById(2131368921), this.this$0.getResources().getColor(2131167681), this.this$0.getResources().getColor(17170444), this.this$0.getResources().getInteger(17694722));
      AttachImagePagerActivity.access$300(this.this$0).animFadeOut();
      return;
    }
    View localView = AttachImagePagerActivity.access$300(this.this$0).getButtonRight();
    if (localView != null) {
      localView.setClickable(true);
    }
    AnimUtil.playAlphaBackgroundColor(this.this$0.findViewById(2131368921), this.this$0.getResources().getColor(17170444), this.this$0.getResources().getColor(2131167681), this.this$0.getResources().getInteger(17694722));
    AttachImagePagerActivity.access$300(this.this$0).animFadeIn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.5
 * JD-Core Version:    0.7.0.1
 */