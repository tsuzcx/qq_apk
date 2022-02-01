package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class MediaBucketGridActivity$11
  implements Action1<Boolean>
{
  MediaBucketGridActivity$11(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptCamera(new double[0]);
      QMCameraManager.sharedInstance().startCamera(new MediaBucketGridActivity.11.1(this));
      this.this$0.setFadeBackground();
      return;
    }
    KvHelper.eventPermissionDenyCamera(new double[0]);
    PermissionUtils.permissionWarn(this.this$0.getActivity(), 2131718903, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.11
 * JD-Core Version:    0.7.0.1
 */