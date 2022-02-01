package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import jho;
import jhq;
import jht;

public class AVRedBag$3$1
  implements Runnable
{
  public AVRedBag$3$1(jhq paramjhq) {}
  
  public void run()
  {
    jht localjht = this.a.a.a();
    if (localjht == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.TAG, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localjht.wI()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localjht.kA("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3.1
 * JD-Core Version:    0.7.0.1
 */