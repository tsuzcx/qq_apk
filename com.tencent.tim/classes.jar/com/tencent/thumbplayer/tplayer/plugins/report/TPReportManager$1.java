package com.tencent.thumbplayer.tplayer.plugins.report;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class TPReportManager$1
  extends PhoneStateListener
{
  TPReportManager$1(TPReportManager paramTPReportManager) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    TPReportManager.access$3800(this.this$0, paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.1
 * JD-Core Version:    0.7.0.1
 */