package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iiv;

class DoubleVideoCtrlUI$5$1
  implements Runnable
{
  DoubleVideoCtrlUI$5$1(DoubleVideoCtrlUI.5 param5, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (this.a.this$0.a.b() != null))
    {
      iiv localiiv = this.a.this$0.a.b();
      QLog.w(this.a.this$0.TAG, 1, "StartGlassCheck, lCurrent[" + this.on + "], lLastTickFinal[" + this.ov + "], VideoGlassWaitTime[" + localiiv.ann + "], DefaultTimeOutRule[" + localiiv.ano + "], GlassSwitch[" + localiiv.anm + "]");
      if ((this.a.this$0.ct(localiiv.ano)) && (this.a.this$0.a.b().anm != 0)) {
        DoubleVideoCtrlUI.a(this.a.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5.1
 * JD-Core Version:    0.7.0.1
 */