package com.etrump.mixlayout;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import lf;
import mqq.os.MqqHandler;

public final class VasShieldFont$1
  implements Runnable
{
  public VasShieldFont$1(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "loadDefaultFont: type=" + lf.iN);
    }
    if (!lf.access$000().get())
    {
      if (lf.b() == null)
      {
        if (!lf.access$200()) {
          break label135;
        }
        lf.access$300();
        lf.eW();
      }
      if (this.a != null)
      {
        this.a.removeMessages(87);
        this.a.sendEmptyMessage(87);
      }
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("loadDefaultFont: typeface=");
      if (lf.b() == null) {
        break label145;
      }
    }
    label135:
    label145:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VasShieldFont", 2, bool);
      lf.a().set(false);
      return;
      lf.u(this.val$app);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.1
 * JD-Core Version:    0.7.0.1
 */