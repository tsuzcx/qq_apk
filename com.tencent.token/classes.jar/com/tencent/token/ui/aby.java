package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tmsdk.TMSDKContext;

class aby
  implements View.OnClickListener
{
  aby(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(View paramView)
  {
    TMSDKContext.saveActionData(1150069);
    paramView = new Intent(this.a, VerifyStartScanActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aby
 * JD-Core Version:    0.7.0.1
 */