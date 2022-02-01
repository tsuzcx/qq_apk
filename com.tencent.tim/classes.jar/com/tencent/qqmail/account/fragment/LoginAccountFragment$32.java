package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.helper.HelperFocusChange;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.EmailEditText;

class LoginAccountFragment$32
  implements HelperFocusChange
{
  LoginAccountFragment$32(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onChange(boolean paramBoolean)
  {
    if ((!paramBoolean) && (LoginAccountFragment.access$1900(this.this$0) != null))
    {
      Object localObject2 = LoginAccountFragment.access$1900(this.this$0).getText().toString();
      Object localObject1 = localObject2;
      if (!((String)localObject2).equals("")) {
        if (((String)localObject2).contains("@"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).endsWith("@")) {}
        }
        else
        {
          localObject1 = AccountType.autoFillUserInput(this.this$0.mAccountType, (String)localObject2);
          LoginAccountFragment.access$1900(this.this$0).setText((CharSequence)localObject1);
        }
      }
      String str = LoginAccountFragment.access$2000(this.this$0, (String)localObject1);
      localObject2 = localObject1;
      if (!str.equals(localObject1))
      {
        QMLog.log(4, "LoginAccountFragment", "autoCorrectEmail " + (String)localObject1 + " to " + str);
        LoginAccountFragment.access$1900(this.this$0).setText(str);
        localObject2 = str;
      }
      if (!StringExtention.isEmailPattern((String)localObject2))
      {
        QMLog.log(6, "LoginAccountFragment", "error email:" + (String)localObject2);
        LoginAccountFragment.access$2100(this.this$0, new LoginAccountFragment.32.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.32
 * JD-Core Version:    0.7.0.1
 */