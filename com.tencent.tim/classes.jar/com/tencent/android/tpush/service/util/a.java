package com.tencent.android.tpush.service.util;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

public class a
{
  public static String a()
  {
    Object localObject1 = null;
    if (b.e() != null)
    {
      try
      {
        localObject2 = TpnsSecurity.getBusinessDeviceId(b.e());
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          TLogger.e("DeviceInfo", ">>getFacilityIdentity err", localThrowable);
        }
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.trim().length() != 0) {}
      }
      else
      {
        localObject2 = "";
      }
      return localObject2;
    }
    TLogger.e("DeviceInfo", ">>> getFacilityIdentity() > context == null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.a
 * JD-Core Version:    0.7.0.1
 */