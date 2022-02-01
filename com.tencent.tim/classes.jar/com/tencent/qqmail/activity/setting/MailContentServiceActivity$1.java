package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class MailContentServiceActivity$1
  implements UITableView.ClickListener
{
  MailContentServiceActivity$1(MailContentServiceActivity paramMailContentServiceActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == MailContentServiceActivity.access$000(this.this$0))
    {
      paramUITableItemView = MailContentCreditCardServiceActivity.createIntent(this.this$0);
      this.this$0.startActivity(paramUITableItemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.MailContentServiceActivity.1
 * JD-Core Version:    0.7.0.1
 */