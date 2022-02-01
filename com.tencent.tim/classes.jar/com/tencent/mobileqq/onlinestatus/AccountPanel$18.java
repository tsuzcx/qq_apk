package com.tencent.mobileqq.onlinestatus;

import android.widget.TextView;
import aqqb;
import com.tencent.qphone.base.util.QLog;

public class AccountPanel$18
  implements Runnable
{
  public void run()
  {
    this.val$tv.setText(aqqb.a().Ct());
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "panel -> updateCustomOnlineStatus text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18
 * JD-Core Version:    0.7.0.1
 */