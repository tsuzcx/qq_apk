package com.tencent.qqmail.thirdpartycall;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.fragment.base.QMBaseFragment;

final class ThirdPartyCallDialogHelpler$6
  implements View.OnClickListener
{
  ThirdPartyCallDialogHelpler$6(QMBaseFragment paramQMBaseFragment) {}
  
  public void onClick(View paramView)
  {
    ThirdPartyCallDialogHelpler.access$400(this.val$fragment, ThirdPartyCallDialogHelpler.access$000(), false, new ThirdPartyCallDialogHelpler.6.1(this), new ThirdPartyCallDialogHelpler.6.2(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.6
 * JD-Core Version:    0.7.0.1
 */