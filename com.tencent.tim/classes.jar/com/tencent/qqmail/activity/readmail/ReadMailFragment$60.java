package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.readmail.ReadMailHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$60
  implements View.OnClickListener
{
  ReadMailFragment$60(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadMailFragment.access$2400(this.this$0) != null)
    {
      localObject = ReadMailFragment.access$2400(this.this$0).getRedPoint();
      if ((localObject != null) && (((View)localObject).isShown()))
      {
        ((View)localObject).setVisibility(8);
        QMSettingManager.sharedInstance().setTelphonePromotionRedPoint(false);
      }
    }
    ReadMailFragment.access$12000(this.this$0, paramView);
    Object localObject = ReadMailFragment.access$12400(this.this$0);
    if ((localObject != null) && (((QMFolder)localObject).getType() == 4)) {
      ReadMailHelper.expireAttachDraftEditLocal(new ReadMailFragment.60.1(this), ReadMailFragment.access$000(this.this$0), this.this$0.getActivity());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.this$0.isAttachedToActivity()) {
        QMLog.log(5, "ReadMailFragment", "onSend onListItemClick fragment not attach.");
      } else {
        ReadMailFragment.access$12700(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.60
 * JD-Core Version:    0.7.0.1
 */