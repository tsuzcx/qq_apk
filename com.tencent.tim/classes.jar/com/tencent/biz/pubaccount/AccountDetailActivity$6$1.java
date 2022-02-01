package com.tencent.biz.pubaccount;

import acbn;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.data.AccountDetail;

class AccountDetailActivity$6$1
  implements Runnable
{
  AccountDetailActivity$6$1(AccountDetailActivity.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.this$0.azx();
    if (TextUtils.equals(acbn.blN, this.a.this$0.uin)) {
      AccountDetailActivity.a(this.a.this$0);
    }
    while ((!this.acm) || (this.a.this$0.abG)) {
      return;
    }
    this.a.this$0.a(this.a.this$0.uin, 1008, this.a.this$0.a.name, ChatActivity.class, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.6.1
 * JD-Core Version:    0.7.0.1
 */