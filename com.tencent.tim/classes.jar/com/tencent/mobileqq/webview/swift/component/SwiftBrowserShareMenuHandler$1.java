package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import arbt;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import rwt;

public class SwiftBrowserShareMenuHandler$1
  implements TeleScreenRunnable
{
  public SwiftBrowserShareMenuHandler$1(arbt paramarbt, WeakReference paramWeakReference, Intent paramIntent) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.iB.get();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "canceled");
      }
      return;
    }
    try
    {
      localActivity.startActivity(this.val$intent);
      return;
    }
    catch (Throwable localThrowable)
    {
      rwt.ez(1, 2131697436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1
 * JD-Core Version:    0.7.0.1
 */