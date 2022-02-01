package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.os.Bundle;
import aqjn;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$3
  implements Runnable
{
  public QQCustomArkDialog$3(aqjn paramaqjn, Bundle paramBundle) {}
  
  public void run()
  {
    if (aqjn.a(this.this$0) != null) {}
    for (Activity localActivity = (Activity)aqjn.a(this.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      aqjn.a(this.this$0, this.val$bundle);
      return;
    }
    QLog.e("QQCustomArkDialog", 1, "init bundle activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.3
 * JD-Core Version:    0.7.0.1
 */