package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.token.core.bean.DeviceInfo;

final class ub
  extends Dialog
{
  private DeviceInfo b;
  
  public ub(PCMobileQQVerifyedDevicesActivity paramPCMobileQQVerifyedDevicesActivity, Context paramContext, DeviceInfo paramDeviceInfo)
  {
    super(paramContext, 2131427400);
    this.b = paramDeviceInfo;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903069);
    paramBundle = String.format(this.a.getResources().getString(2131362244), new Object[] { this.b.dname });
    ((TextView)findViewById(2131296492)).setText(paramBundle);
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
    findViewById(2131296493).setOnClickListener(new uc(this));
    findViewById(2131296494).setOnClickListener(new ud(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ub
 * JD-Core Version:    0.7.0.1
 */