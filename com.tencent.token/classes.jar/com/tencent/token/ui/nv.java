package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tmsdk.TMSDKContext;

class nv
  implements View.OnClickListener
{
  nv(nu paramnu) {}
  
  public void onClick(View paramView)
  {
    TMSDKContext.saveActionData(1150079);
    paramView = new Intent(nu.a(this.a), PCMobileQQVerifyedDevicesActivity.class);
    nu.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nv
 * JD-Core Version:    0.7.0.1
 */