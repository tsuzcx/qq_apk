package com.tencent.device.qfind;

class QFindBLEScanMgr$ScanReceiver$1
  implements Runnable
{
  QFindBLEScanMgr$ScanReceiver$1(QFindBLEScanMgr.a parama) {}
  
  public void run()
  {
    if (this.b.this$0.aOk)
    {
      QFindBLEScanMgr.a(this.b.this$0, System.currentTimeMillis());
      QFindBLEScanMgr.a(this.b.this$0, true);
      return;
    }
    QFindBLEScanMgr.a(this.b.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.ScanReceiver.1
 * JD-Core Version:    0.7.0.1
 */