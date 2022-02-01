package com.tencent.mobileqq.avatar.dynamicavatar;

import advv;
import android.view.WindowManager.BadTokenException;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;

public class DynamicAvatarRecordActivity$11
  implements Runnable
{
  DynamicAvatarRecordActivity$11(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = this.val$errMsg;
    if (this.val$errCode == 2002) {
      str = this.this$0.getString(2131701579);
    }
    this.this$0.ad = aqha.a(this.this$0, 230).setMessage(str).setPositiveButton(this.this$0.getString(2131695681), new advv(this));
    try
    {
      this.this$0.ad.setCancelable(false);
      this.this$0.ad.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.11
 * JD-Core Version:    0.7.0.1
 */