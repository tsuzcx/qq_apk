package com.tencent.qqmail.attachment.activity;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import java.util.ArrayList;
import moai.oss.OssHelper;

class ImagePagerActivity$15
  implements ViewPager.OnPageChangeListener
{
  ImagePagerActivity$15(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat > 0.98D) {
      this.this$0.resetLastImagePagerView();
    }
    if (paramInt2 <= 0) {
      this.this$0.resetLastImagePagerView();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ImageData localImageData = ImagePagerCache.getImageData(ImagePagerActivity.mUin, paramInt);
    ImagePagerActivity.access$3102(this.this$0, localImageData);
    if (localImageData != null)
    {
      ImagePagerActivity.access$302(this.this$0, localImageData);
      this.this$0.setPageSelected(localImageData.getItemPos());
      ImagePagerActivity.access$3200(this.this$0).clear();
      ImagePagerActivity.access$3200(this.this$0).add(localImageData.getFid());
      FtnDownloadInfo localFtnDownloadInfo = FtnManager.sharedInstance().getDownloadInfo(localImageData.getFid());
      if (localFtnDownloadInfo != null) {
        QMAttachUtils.attachOpenOssLog(localImageData.getFid(), localFtnDownloadInfo.getSavePath());
      }
      OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ImagePagerActivity", localImageData.getSuffix(), "" });
    }
    this.this$0.setFirstPage(false);
    if (paramInt != ImagePagerActivity.access$3300(this.this$0))
    {
      ImagePagerActivity.access$3402(this.this$0, ImagePagerActivity.access$3500(this.this$0));
      ImagePagerActivity.access$3302(this.this$0, paramInt);
      ImagePagerActivity.access$3502(this.this$0, ImagePagerActivity.access$3600(this.this$0).getFragment(paramInt));
    }
    this.this$0.updateAttachInfo(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.15
 * JD-Core Version:    0.7.0.1
 */