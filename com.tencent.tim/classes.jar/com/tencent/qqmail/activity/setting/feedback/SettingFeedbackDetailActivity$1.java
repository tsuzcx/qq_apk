package com.tencent.qqmail.activity.setting.feedback;

import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMBaseView;

class SettingFeedbackDetailActivity$1
  implements FeedBackDetailInputLayout.FeedBackDetailInputListener
{
  SettingFeedbackDetailActivity$1(SettingFeedbackDetailActivity paramSettingFeedbackDetailActivity, QMBaseView paramQMBaseView) {}
  
  public void onClickAddImageBtn()
  {
    if (SettingFeedbackDetailActivity.access$300(this.this$0, this.this$0.getString(2131696384))) {
      QMAlbumManager.shareInstance().startAlbum(this.this$0, QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FEEDBACK, SettingFeedbackDetailActivity.access$400(this.this$0).getComposeCacheFilePath(), SettingFeedbackDetailActivity.access$000(this.this$0).getImagesCountCanAdd());
    }
  }
  
  public void onDelete(AttachInfo paramAttachInfo)
  {
    SettingFeedbackDetailActivity.access$100(this.this$0, paramAttachInfo);
  }
  
  public void onInputFoucChange(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.val$baseView.postDelayed(new SettingFeedbackDetailActivity.1.1(this), 300L);
    }
  }
  
  public void onPreviewImage(AttachInfo paramAttachInfo)
  {
    Threads.runOnMainThreadIfNotExist(new SettingFeedbackDetailActivity.1.2(this, paramAttachInfo), 180L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity.1
 * JD-Core Version:    0.7.0.1
 */