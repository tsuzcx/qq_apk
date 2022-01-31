package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class VoipSSOObserver
  implements BusinessObserver
{
  private static final String a = "VoipSSOObserver";
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QLog.e("VoipSSOObserver", 2, "VoipSSOObserver param error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipSSOObserver
 * JD-Core Version:    0.7.0.1
 */