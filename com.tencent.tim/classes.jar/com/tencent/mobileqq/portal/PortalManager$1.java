package com.tencent.mobileqq.portal;

import com.tencent.qphone.base.util.QLog;

class PortalManager$1
  implements Runnable
{
  PortalManager$1(PortalManager paramPortalManager, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if ((this.afS <= 0L) || (this.afS > 60000L) || (PortalManager.afJ == this.afS)) {
        break label294;
      }
      PortalManager.afJ = this.afS;
      if (this.this$0.a.grebInterval == PortalManager.afJ) {
        break label294;
      }
      this.this$0.a.grebInterval = PortalManager.afJ;
    }
    label294:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.afT != -1L)
      {
        i = j;
        if (PortalManager.afK != this.afT)
        {
          PortalManager.afK = this.afT;
          i = j;
          if (this.this$0.a.reportActiveInterval != PortalManager.afK)
          {
            this.this$0.a.reportActiveInterval = PortalManager.afK;
            i = 1;
          }
        }
      }
      j = i;
      if (this.afU != -1L)
      {
        j = i;
        if (PortalManager.afL != this.afU)
        {
          PortalManager.afL = this.afU;
          j = i;
          if (this.this$0.a.reportNormalInterval != PortalManager.afL)
          {
            this.this$0.a.reportNormalInterval = PortalManager.afL;
            j = 1;
          }
        }
      }
      if (j != 0) {
        this.this$0.a(false, 6, 1000L, this.this$0.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "sGrabInterval = " + PortalManager.afJ + ",sReportActiveInterval = " + PortalManager.afK + ",sReportNormalInterval = " + PortalManager.afL);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.1
 * JD-Core Version:    0.7.0.1
 */