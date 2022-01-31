package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.token.core.bean.DeviceInfo;

class tf
  extends Dialog
{
  private DeviceInfo b;
  
  public tf(PCMobileQQVerifyedDevicesActivity paramPCMobileQQVerifyedDevicesActivity, Context paramContext, int paramInt, DeviceInfo paramDeviceInfo)
  {
    super(paramContext, paramInt);
    this.b = paramDeviceInfo;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968634);
    paramBundle = String.format(this.a.getResources().getString(2131231539), new Object[] { this.b.dname });
    ((TextView)findViewById(2131558778)).setText(paramBundle);
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
    findViewById(2131558779).setOnClickListener(new tg(this));
    findViewById(2131558780).setOnClickListener(new th(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tf
 * JD-Core Version:    0.7.0.1
 */