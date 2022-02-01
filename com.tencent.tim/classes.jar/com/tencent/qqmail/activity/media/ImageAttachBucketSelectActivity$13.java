package com.tencent.qqmail.activity.media;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.view.QMTopBar;
import java.util.List;
import moai.oss.OssHelper;

class ImageAttachBucketSelectActivity$13
  extends ViewPager.SimpleOnPageChangeListener
{
  ImageAttachBucketSelectActivity$13(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)ImageAttachBucketSelectActivity.access$100(this.this$0).get(paramInt);
    if ((localMediaItemInfo != null) && (localMediaItemInfo.getAttach() != null)) {
      QMAttachUtils.attachOpenOssLog(String.valueOf(localMediaItemInfo.getAttach().getHashId()), localMediaItemInfo.getSourcePath());
    }
    if (localMediaItemInfo.getImageType() == 3) {
      OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ImageAttachBucketSelectActivity", FileUtil.getFileNameSuffix(localMediaItemInfo.getAttach().getName()), "" });
    }
    for (;;)
    {
      ImageAttachBucketSelectActivity.access$000(this.this$0);
      if (ImageAttachBucketSelectActivity.access$1200(this.this$0).isVisible()) {
        ImageAttachBucketSelectActivity.access$2200(this.this$0);
      }
      ImageAttachBucketSelectActivity.access$300(this.this$0);
      ImageAttachBucketSelectActivity.access$2302(this.this$0, paramInt);
      return;
      OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ImageAttachBucketSelectActivity", FileUtil.getFileNameSuffix(localMediaItemInfo.getAttach().getName()), "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.13
 * JD-Core Version:    0.7.0.1
 */