package com.tencent.qqmail.ftn.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.concurrent.atomic.AtomicBoolean;

class FtnListActivity$30
  implements DialogInterface.OnDismissListener
{
  FtnListActivity$30(FtnListActivity paramFtnListActivity, AtomicBoolean paramAtomicBoolean) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FtnUploadInfo localFtnUploadInfo = FtnListActivity.access$900(this.this$0).getCurrentFtnUploadInfo();
    if (localFtnUploadInfo != null) {}
    for (paramDialogInterface = localFtnUploadInfo.getFid();; paramDialogInterface = null)
    {
      if ((!TextUtils.isEmpty(paramDialogInterface)) && (!FtnListActivity.access$5700(this.this$0, paramDialogInterface)) && (!this.val$isClickItem.get()))
      {
        FtnListActivity.access$500(this.this$0).goOnRequest(paramDialogInterface);
        this.this$0.updateRealPause(paramDialogInterface, false);
        if (!FtnListActivity.access$2800(this.this$0)) {
          break;
        }
        this.this$0.updateUploadItemState(localFtnUploadInfo, 2);
      }
      return;
    }
    this.this$0.updateUploadItemState(localFtnUploadInfo, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.30
 * JD-Core Version:    0.7.0.1
 */