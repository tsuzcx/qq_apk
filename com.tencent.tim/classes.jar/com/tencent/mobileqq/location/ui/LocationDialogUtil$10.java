package com.tencent.mobileqq.location.ui;

import airk;
import airm;
import android.app.Activity;
import android.content.res.Resources;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$10
  implements Runnable
{
  public LocationDialogUtil$10(Activity paramActivity) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.val$activity, 230, null, this.val$activity.getResources().getString(2131720292), 2131719963, 2131721058, null, new airm(this));
    localaqju.setCancelable(false);
    if (!String.valueOf(this.val$activity.hashCode()).equals(airk.access$200()))
    {
      airk.b(this.val$activity, localaqju);
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", airk.access$200() });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LocationDialogUtil", 2, new Object[] { "run: invoked. ", " same hash currentDialogActivityHash: ", airk.access$200(), " activity: ", Integer.valueOf(this.val$activity.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.10
 * JD-Core Version:    0.7.0.1
 */