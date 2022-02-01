package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

class ReadVirtualAdsMailFragment$5
  implements View.OnClickListener
{
  ReadVirtualAdsMailFragment$5(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onClick(View paramView)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
    localBottomListSheetBuilder.addItem(2130840827, this.this$0.getString(2131695199), this.this$0.getString(2131695199));
    localBottomListSheetBuilder.addItem(2130840843, this.this$0.getString(2131695618), this.this$0.getString(2131695618));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadVirtualAdsMailFragment.5.1(this));
    localBottomListSheetBuilder.build().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.5
 * JD-Core Version:    0.7.0.1
 */