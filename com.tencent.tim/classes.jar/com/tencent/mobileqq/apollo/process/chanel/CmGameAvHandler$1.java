package com.tencent.mobileqq.apollo.process.chanel;

import abnq;
import abvq;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(abnq paramabnq, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    abvq.a().hd(abnq.a(this.this$0));
    abvq.a().CU(this.bhd);
    abvq.a().hc(this.Of);
    abvq.a().Ij(0);
    abvq.a().f("" + this.cqj, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.cqj);
    }
    abnq.a(this.this$0, this.cqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */