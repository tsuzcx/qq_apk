package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.qqpim.QQPimNewActivity;
import com.tmsdk.TMSDKContext;

class ak
  implements View.OnClickListener
{
  ak(AccountPageActivity paramAccountPageActivity) {}
  
  public void onClick(View paramView)
  {
    TMSDKContext.saveActionData(170020);
    paramView = new Intent(this.a, QQPimNewActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ak
 * JD-Core Version:    0.7.0.1
 */