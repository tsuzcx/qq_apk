package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class LoginInfoFragment$7
  implements UITableView.ClickListener
{
  LoginInfoFragment$7(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked())
    {
      LoginInfoFragment.access$902(this.this$0, true);
      LoginInfoFragment.access$500(this.this$0, true);
      paramUITableItemView.setChecked(true);
      LoginInfoFragment.access$1000(this.this$0);
      return;
    }
    LoginInfoFragment.access$902(this.this$0, false);
    LoginInfoFragment.access$500(this.this$0, false);
    paramUITableItemView.setChecked(false);
    LoginInfoFragment.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.7
 * JD-Core Version:    0.7.0.1
 */