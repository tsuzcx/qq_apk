package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class AvatarSelector$2
  implements Action1<Boolean>
{
  AvatarSelector$2(AvatarSelector paramAvatarSelector) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptCamera(new double[0]);
      QMCameraManager.sharedInstance().startCamera(new AvatarSelector.2.1(this));
      this.this$0.baseActivityImpl.setFadeBackground();
      return;
    }
    KvHelper.eventPermissionDenyCamera(new double[0]);
    PermissionUtils.permissionWarn(this.this$0.baseActivityImpl.getActivity(), 2131718903, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.AvatarSelector.2
 * JD-Core Version:    0.7.0.1
 */