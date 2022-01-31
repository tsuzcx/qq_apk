package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class n
  extends BroadcastReceiver
{
  n(AccountPageActivity paramAccountPageActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.token.account_opr_msg")) {
      AccountPageActivity.access$000(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.n
 * JD-Core Version:    0.7.0.1
 */