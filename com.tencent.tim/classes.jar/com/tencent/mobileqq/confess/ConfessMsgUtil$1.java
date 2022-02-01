package com.tencent.mobileqq.confess;

import aegs;
import aegs.b;
import anaz;
import com.tencent.qphone.base.util.QLog;

public final class ConfessMsgUtil$1
  implements Runnable
{
  public ConfessMsgUtil$1(aegs paramaegs, String paramString, aegs.b paramb, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.b.a(this.bxg, this.c, this.Wc, this.Wc, this.Qo);
    if (QLog.isColorLevel())
    {
      long l = anaz.gQ();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.c.strConfessorDesc + " msgTime:" + this.Wc + " msgSeq:" + this.Qo + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */