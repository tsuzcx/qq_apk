package com.tencent.qqmail.inquirymail.fragment;

import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class InquiryMailAccountListFragment$1
  implements UITableView.ClickListener
{
  InquiryMailAccountListFragment$1(InquiryMailAccountListFragment paramInquiryMailAccountListFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    DataCollector.logEvent("Event_Received_Mail_Show_Account");
    paramUITableItemView = new InquiryMailListFragment(((QQMailAccount)InquiryMailAccountListFragment.access$000(this.this$0).get(paramInt)).getId());
    this.this$0.startFragment(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailAccountListFragment.1
 * JD-Core Version:    0.7.0.1
 */