package com.tencent.qqmail.activity.setting.feedback;

import android.graphics.Bitmap;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;

class SettingFeedbackDetailActivity$6
  implements Runnable
{
  SettingFeedbackDetailActivity$6(SettingFeedbackDetailActivity paramSettingFeedbackDetailActivity, AttachInfo paramAttachInfo) {}
  
  private boolean hasAddedBefore()
  {
    return SettingFeedbackDetailActivity.access$000(this.this$0).getIndexOfInfo(this.val$info) >= 0;
  }
  
  public void run()
  {
    if ((!hasAddedBefore()) && (SettingFeedbackDetailActivity.access$000(this.this$0).canAddImage()) && (this.val$info.isImage()))
    {
      Bitmap localBitmap = QMAttachUtils.getThumbnail(this.val$info);
      if (localBitmap == null) {
        break label76;
      }
      SettingFeedbackDetailActivity.access$000(this.this$0).addImage(localBitmap, this.val$info);
      if (this.val$info.getThumbnailData() == null) {
        this.val$info.setThumbnailData(localBitmap);
      }
    }
    return;
    label76:
    int i = ImageResourceUtil.getImageResource(QMAttachUtils.attachFileType(this.val$info.getAttachName()), ImageResourceUtil.IMAGE_SIZE_76);
    SettingFeedbackDetailActivity.access$000(this.this$0).addImage(i, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */