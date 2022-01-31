package com.tmsdk.base.oaid;

import android.text.TextUtils;
import btmsdkobf.m;
import btmsdkobf.m.a;
import java.util.ArrayList;

final class OaidProxy$2
  implements m.a
{
  OaidProxy$2(ArrayList paramArrayList, Object paramObject) {}
  
  public void a(String arg1, m paramm)
  {
    try
    {
      ??? = paramm.g();
      if (!TextUtils.isEmpty(???)) {
        this.y.add(???);
      }
      label21:
      synchronized (this.z)
      {
        this.y.set(0, "1");
        this.z.notify();
        return;
      }
    }
    catch (Throwable ???)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.oaid.OaidProxy.2
 * JD-Core Version:    0.7.0.1
 */