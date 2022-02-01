package com.tencent.mobileqq.troop.aioapp;

import aoxw;
import aoxx;
import aoxy;
import aoyc;
import com.tencent.qphone.base.util.QLog;

public class AioGroupAppsManager$1
  implements Runnable
{
  public AioGroupAppsManager$1(aoxw paramaoxw) {}
  
  public void run()
  {
    aoxw.a(this.this$0).dXP();
    aoxw.a(this.this$0).dXM();
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "login fullList from db " + aoyc.b(this.this$0.Hq));
    }
    this.this$0.dXL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1
 * JD-Core Version:    0.7.0.1
 */