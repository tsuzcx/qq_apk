package com.tencent.mobileqq.onlinestatus;

import akrq;
import aksl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class AccountOnlineStateActivity$4$1
  implements Runnable
{
  public AccountOnlineStateActivity$4$1(akrq paramakrq, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (this.val$isSuccess) {
      if (AccountOnlineStateActivity.a(this.a.this$0) != null) {
        AccountOnlineStateActivity.a(this.a.this$0).lK(this.Eo);
      }
    }
    while (AccountOnlineStateActivity.a(this.a.this$0) == null) {
      return;
    }
    QQToast.a(AccountOnlineStateActivity.a(this.a.this$0), 1, 2131690674, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1
 * JD-Core Version:    0.7.0.1
 */