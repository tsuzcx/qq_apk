package com.tencent.mobileqq.msf.core;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.qphone.base.util.QLog;

class al
  implements IAsyncQimeiListener
{
  al(ak paramak) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    ak.d(paramQimei.getQimeiNew());
    QLog.d("libboot_MSF.C.NetConnTag", 1, "onQimeiDispatch, sQimei = " + ak.q() + ", qimeiOld = " + paramQimei.getQimeiOld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.al
 * JD-Core Version:    0.7.0.1
 */