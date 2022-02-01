package com.tencent.tim.mvp.me;

import auje.b;
import aujf;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MePresenter$3$1
  implements Runnable
{
  MePresenter$3$1(MePresenter.3 param3, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MePresenter", 2, "refreshLebaConfig. tmpItems size=" + this.qQ.size());
    }
    if (this.a.this$0.isActive()) {
      aujf.a(this.a.this$0).hO(this.qQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.me.MePresenter.3.1
 * JD-Core Version:    0.7.0.1
 */