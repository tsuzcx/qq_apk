package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderActivity$3$1
  implements Runnable
{
  ServiceAccountFolderActivity$3$1(ServiceAccountFolderActivity.3 param3, int paramInt) {}
  
  public void run()
  {
    if (this.aIU <= 0) {
      this.a.tV.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "updateUnreadNumOnTitleBar->unread num:" + this.aIU);
      }
      return;
      if (this.aIU > 99)
      {
        this.a.tV.setText("99+");
        this.a.tV.setVisibility(0);
      }
      else
      {
        this.a.tV.setText(String.valueOf(this.aIU));
        this.a.tV.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.3.1
 * JD-Core Version:    0.7.0.1
 */