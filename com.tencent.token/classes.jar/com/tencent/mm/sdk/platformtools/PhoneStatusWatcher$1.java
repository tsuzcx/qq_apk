package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import java.util.Iterator;
import java.util.List;

class PhoneStatusWatcher$1
  extends PhoneStateListener
{
  PhoneStatusWatcher$1(PhoneStatusWatcher paramPhoneStatusWatcher) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    Iterator localIterator = PhoneStatusWatcher.a(this.aH).iterator();
    while (localIterator.hasNext()) {
      ((PhoneStatusWatcher.PhoneCallListener)localIterator.next()).onPhoneCall(paramInt);
    }
    super.onCallStateChanged(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      PhoneStatusWatcher.a(false);
      return;
    }
    PhoneStatusWatcher.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.1
 * JD-Core Version:    0.7.0.1
 */