package com.tencent.mobileqq.apollo.process.chanel;

import abmt;
import abnq;
import abvq;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class CmGameAvHandler$10
  implements Runnable
{
  public CmGameAvHandler$10(abnq paramabnq, String paramString, long paramLong) {}
  
  public void run()
  {
    abvq.a().CU(this.bhe);
    abmt.a().callbackFromRequest(this.Od, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10
 * JD-Core Version:    0.7.0.1
 */