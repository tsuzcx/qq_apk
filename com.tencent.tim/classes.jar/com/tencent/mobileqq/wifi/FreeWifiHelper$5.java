package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import aqha;
import aqju;
import armm;

public final class FreeWifiHelper$5
  implements Runnable
{
  public FreeWifiHelper$5(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, int paramInt) {}
  
  public void run()
  {
    String str = this.val$activity.getString(2131693875);
    aqha.a(this.val$activity, 0, this.val$title, this.val$content, this.cAJ, this.cAK, str, this.aa, this.ab, this.ac).show();
    if (this.val$scene == 1)
    {
      armm.aU(this.val$activity, 398667);
      armm.iF("0X80094F2");
    }
    do
    {
      return;
      if ((this.val$scene == 2) || (this.val$scene == 5))
      {
        armm.aU(this.val$activity, 398667);
        armm.iF("0X80094F1");
        return;
      }
      if (this.val$scene == 3)
      {
        armm.aU(this.val$activity, 398670);
        armm.iF("0X80094F3");
        return;
      }
    } while (this.val$scene != 4);
    armm.aU(this.val$activity, 398689);
    armm.iF("0X80094F1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.5
 * JD-Core Version:    0.7.0.1
 */