package tmsdk.common.nsd;

import android.net.nsd.NsdServiceInfo;

public abstract interface KingCardNsdServerCallback
{
  public abstract void registerFinished(NsdServiceInfo paramNsdServiceInfo, int paramInt);
  
  public abstract void unregisterFinished(NsdServiceInfo paramNsdServiceInfo, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmsdk.common.nsd.KingCardNsdServerCallback
 * JD-Core Version:    0.7.0.1
 */