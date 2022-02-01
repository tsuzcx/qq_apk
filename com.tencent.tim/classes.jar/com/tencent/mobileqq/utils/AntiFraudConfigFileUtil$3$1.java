package com.tencent.mobileqq.utils;

import aqfz;
import aqga;

public class AntiFraudConfigFileUtil$3$1
  implements Runnable
{
  public AntiFraudConfigFileUtil$3$1(aqga paramaqga, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.a.this$0.bl(this.csN, this.dZb);
    String str = SecUtil.getFileMd5(this.a.this$0.pn(this.csN));
    if (!this.csO.equalsIgnoreCase(str))
    {
      this.a.this$0.bh(this.csN, this.csO, this.csP);
      return;
    }
    this.a.this$0.bk(this.csN, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1
 * JD-Core Version:    0.7.0.1
 */