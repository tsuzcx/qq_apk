package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class AttachSaveToWeiYunActivity$2
  implements View.OnClickListener
{
  AttachSaveToWeiYunActivity$2(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getActivity() != null) && (QMNetworkUtils.isNetworkConnected(this.this$0.getActivity())))
    {
      AttachSaveToWeiYunActivity.access$100(this.this$0);
      if (!AttachSaveToWeiYunActivity.access$200(this.this$0).isBigAttach()) {
        break label65;
      }
      this.this$0.saveBigAttachToWeiYun(AttachSaveToWeiYunActivity.access$200(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label65:
      this.this$0.saveNormalAttachToWeiYunBuildTask(AttachSaveToWeiYunActivity.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.2
 * JD-Core Version:    0.7.0.1
 */