package com.tencent.mobileqq.ar;

import adap;
import adfn;
import adfn.a;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class NeonControl$2
  implements Runnable
{
  public NeonControl$2(adfn paramadfn, adfn.a parama, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.b.cEi));
    localHashMap.put("selimg_frame_consume", String.valueOf(this.cEh));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_selimg_frame_consume", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", new Object[] { Integer.valueOf(this.b.count), Integer.valueOf(this.cEh), Integer.valueOf(this.b.cEi) }));
      adap.a().iu(this.cEh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.2
 * JD-Core Version:    0.7.0.1
 */