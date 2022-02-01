package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import java.util.Date;

class ImagePagerActivity$3$1
  implements Runnable
{
  ImagePagerActivity$3$1(ImagePagerActivity.3 param3) {}
  
  public void run()
  {
    ImagePagerActivity.access$400(this.this$1.this$0);
    ImagePagerActivity.access$500(this.this$1.this$0);
    int i = ImagePagerActivity.access$600(this.this$1.this$0).expiretime;
    int j = FtnCommonUtils.getExpireTimeFromNowSecond(FtnListActivity.mRenewDay);
    if (i <= j)
    {
      FtnManager.sharedInstance().updateFtn(ImagePagerActivity.access$700(this.this$1.this$0).getFid(), "expiretime", j + "");
      ImagePagerActivity.access$700(this.this$1.this$0).setExpire(FtnCommonUtils.getExpireTimeFromNowSecond(FtnListActivity.mRenewDay) * 1000L);
    }
    for (;;)
    {
      if (ImagePagerActivity.access$300(this.this$1.this$0) != null)
      {
        ImagePagerActivity.access$300(this.this$1.this$0).setExpireTime((int)(ImagePagerActivity.access$700(this.this$1.this$0).getExpire().getTime() / 1000L));
        ImagePagerActivity.access$800(this.this$1.this$0, ImagePagerActivity.access$300(this.this$1.this$0));
      }
      return;
      ImagePagerActivity.access$700(this.this$1.this$0).setExpire(i * 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.3.1
 * JD-Core Version:    0.7.0.1
 */