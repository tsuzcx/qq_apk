package com.tencent.qqmail.thirdpartycall;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ThirdPartyCallDialog$2
  implements AdapterView.OnItemClickListener
{
  ThirdPartyCallDialog$2(ThirdPartyCallDialog paramThirdPartyCallDialog, ThirdPartyCallDialog.TPCDialogParams paramTPCDialogParams) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.dismiss();
    if (this.val$params.mOnItemClickListener != null) {
      this.val$params.mOnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialog.2
 * JD-Core Version:    0.7.0.1
 */