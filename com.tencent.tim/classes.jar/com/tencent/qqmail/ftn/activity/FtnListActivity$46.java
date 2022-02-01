package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class FtnListActivity$46
  implements Action1<Boolean>
{
  FtnListActivity$46(FtnListActivity paramFtnListActivity) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptCamera(new double[0]);
      QMCameraManager.sharedInstance().startCamera(new FtnListActivity.46.1(this));
      this.this$0.setFadeBackground();
      return;
    }
    KvHelper.eventPermissionDenyCamera(new double[0]);
    PermissionUtils.permissionWarn(this.this$0.getActivity(), 2131718903, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.46
 * JD-Core Version:    0.7.0.1
 */