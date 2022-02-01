package com.tencent.qqmail.inquirymail.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

class InquiryMailListFragment$8
  implements AdapterView.OnItemClickListener
{
  InquiryMailListFragment$8(InquiryMailListFragment paramInquiryMailListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DataCollector.logEvent("Event_Received_Mail_Click_Item");
    if (InquiryMailListFragment.access$1000(this.this$0) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = InquiryMailListFragment.access$1100(this.this$0).getHeaderViewsCount();
      paramInt -= i;
      if ((paramInt < 0) || ((InquiryMailListFragment.access$1000(this.this$0).canLoadMore()) || (paramInt < InquiryMailListFragment.access$1000(this.this$0).getCount()))) {
        if ((paramView instanceof MailListMoreItemView))
        {
          if ((InquiryMailListFragment.access$1000(this.this$0).canLoadMore()) && (paramInt == InquiryMailListFragment.access$1000(this.this$0).getCount()))
          {
            InquiryMailListFragment.access$800(this.this$0, true, false);
            InquiryMailListFragment.access$1200(this.this$0, new InquiryMailListFragment.8.1(this));
          }
          InquiryMailListFragment.access$1100(this.this$0).setItemChecked(i + paramInt, false);
        }
        else
        {
          InquiryMail localInquiryMail = InquiryMailListFragment.access$1000(this.this$0).getItem(paramInt);
          QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
          localBottomListSheetBuilder.addItem(0, localInquiryMail.getSenderAddress(), localInquiryMail.getSenderAddress(), false, true);
          if (localInquiryMail.canAddToWhiteList()) {
            localBottomListSheetBuilder.addItem(2130840812, this.this$0.getString(2131694978), this.this$0.getString(2131694978));
          }
          if (localInquiryMail.canRemoveBlackList()) {
            localBottomListSheetBuilder.addItem(2130840809, this.this$0.getString(2131695017), this.this$0.getString(2131695017));
          }
          if (localInquiryMail.canRetrieveMail()) {
            localBottomListSheetBuilder.addItem(2130840811, this.this$0.getString(2131695021), this.this$0.getString(2131695021));
          }
          if (localInquiryMail.canReadMail()) {
            localBottomListSheetBuilder.addItem(2130840810, this.this$0.getString(2131694996), this.this$0.getString(2131694996));
          }
          localBottomListSheetBuilder.setOnSheetItemClickListener(new InquiryMailListFragment.8.2(this, localInquiryMail));
          localBottomListSheetBuilder.build().show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.8
 * JD-Core Version:    0.7.0.1
 */