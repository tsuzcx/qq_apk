package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import iyv;

public class EffectSettingUi$2$2
  implements Runnable
{
  public EffectSettingUi$2$2(iyv paramiyv, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    if (this.a.a.mApp == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.a.a.cZ == null);
      this.a.a.F(this.kQ, false);
      bool = this.a.a.isShown();
      if ((this.Wq) && (bool)) {
        this.a.a.G(this.kQ, true);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("AVRedBag", 1, "onStatusChanged, remoteHasVideo[" + this.Wr + "], peerSupportRedBag[" + this.Ws + "], isInGameMode[" + this.Wq + "], isshow[" + bool + "], seq[" + this.kQ + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.2.2
 * JD-Core Version:    0.7.0.1
 */