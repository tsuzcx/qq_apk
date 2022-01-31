package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public class PhoneStatusWatcher
{
  private static boolean aD;
  private TelephonyManager aE;
  private PhoneStateListener aF;
  private List aG = new LinkedList();
  
  public static boolean isCalling()
  {
    return aD;
  }
  
  public void addPhoneCallListener(PhoneStatusWatcher.PhoneCallListener paramPhoneCallListener)
  {
    this.aG.add(paramPhoneCallListener);
  }
  
  public void begin(Context paramContext)
  {
    if (this.aE == null) {
      this.aE = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.aF == null) {
      this.aF = new PhoneStatusWatcher.1(this);
    }
    this.aE.listen(this.aF, 32);
  }
  
  public void clearPhoneCallListener()
  {
    this.aG.clear();
  }
  
  public void end()
  {
    if (this.aE != null)
    {
      this.aE.listen(this.aF, 0);
      this.aF = null;
    }
  }
  
  public void removePhoneCallListener(PhoneStatusWatcher.PhoneCallListener paramPhoneCallListener)
  {
    this.aG.remove(paramPhoneCallListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneStatusWatcher
 * JD-Core Version:    0.7.0.1
 */