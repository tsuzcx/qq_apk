package com.tencent.mobileqq.ark.API;

import adoj.f;
import adol;
import adom;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppSchemeCenter$TelSchemeHandler$1
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$1(adoj.f paramf, String paramString) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(BaseActivity.sTopActivity, this.val$phone);
    TextView localTextView = (TextView)localaqju.findViewById(2131365863);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localaqju.setPositiveButton(2131692643, new adol(this, localaqju));
    localaqju.setNegativeButton(2131721058, new adom(this, localaqju));
    try
    {
      localaqju.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1
 * JD-Core Version:    0.7.0.1
 */