package com.tencent.biz.pubaccount.readinjoy.viola.view;

import aqda;
import com.tencent.qphone.base.util.QLog;
import nxc;
import nxd;

public class ViolaBaseView$10$1
  implements Runnable
{
  public ViolaBaseView$10$1(nxc paramnxc) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.a.this$0, new nxd(this));
      aqda.a().a(ViolaBaseView.a(this.a.this$0));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.access$700(), 2, "pageOpenSuccess Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1
 * JD-Core Version:    0.7.0.1
 */