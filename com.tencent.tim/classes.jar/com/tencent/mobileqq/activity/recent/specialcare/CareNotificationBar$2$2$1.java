package com.tencent.mobileqq.activity.recent.specialcare;

import aamo;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CareNotificationBar$2$2$1
  implements Runnable
{
  public CareNotificationBar$2$2$1(aamo paramaamo) {}
  
  public void run()
  {
    if (this.a.a.val$view.getParent() != null)
    {
      this.a.a.val$view.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("CareNotificationBar", 2, "onAnimationEnd-->clearAnimation");
      }
      Object localObject = this.a.a.val$view.getTag(2131375593);
      if ((localObject instanceof Drawable))
      {
        this.a.a.val$view.setBackgroundDrawable((Drawable)localObject);
        this.a.a.val$view.setTag(2131375593, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2.2.1
 * JD-Core Version:    0.7.0.1
 */