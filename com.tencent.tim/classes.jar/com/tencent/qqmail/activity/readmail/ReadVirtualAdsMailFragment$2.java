package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder;

class ReadVirtualAdsMailFragment$2
  implements View.OnClickListener
{
  ReadVirtualAdsMailFragment$2(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_AD_Mail_Share");
    QMBottomDialog.BottomGridSheetBuilder localBottomGridSheetBuilder = new QMBottomDialog.BottomGridSheetBuilder(this.this$0.getActivity());
    if (DeviceUtil.isWeChatInstalled())
    {
      localBottomGridSheetBuilder.addItem(2130840799, this.this$0.getString(2131719238), this.this$0.getString(2131719238), 0);
      localBottomGridSheetBuilder.addItem(2130840798, this.this$0.getString(2131719229), this.this$0.getString(2131719229), 0);
    }
    if (DeviceUtil.isQQInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840795, this.this$0.getString(2131719233), this.this$0.getString(2131719233), 0);
    }
    localBottomGridSheetBuilder.setOnSheetItemClickListener(new ReadVirtualAdsMailFragment.2.1(this));
    localBottomGridSheetBuilder.build().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.2
 * JD-Core Version:    0.7.0.1
 */