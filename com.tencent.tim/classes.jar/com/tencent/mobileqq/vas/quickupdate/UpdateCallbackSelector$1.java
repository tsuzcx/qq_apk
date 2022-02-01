package com.tencent.mobileqq.vas.quickupdate;

import aqsm;
import aqsp;
import aqsq;
import aqsr;
import aqss;
import aqst;
import aqsu;
import aqsx;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, aqsm>
{
  public UpdateCallbackSelector$1()
  {
    aqsm[] arrayOfaqsm = new aqsm[7];
    arrayOfaqsm[0] = aqsu.a;
    arrayOfaqsm[1] = aqst.a;
    arrayOfaqsm[2] = aqsr.a;
    arrayOfaqsm[3] = aqsp.a;
    arrayOfaqsm[4] = aqsq.a;
    arrayOfaqsm[5] = aqss.a;
    arrayOfaqsm[6] = aqsx.a;
    int j = arrayOfaqsm.length;
    while (i < j)
    {
      aqsm localaqsm = arrayOfaqsm[i];
      put(Long.valueOf(localaqsm.getBID()), localaqsm);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */