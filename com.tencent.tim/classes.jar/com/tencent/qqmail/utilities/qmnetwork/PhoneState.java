package com.tencent.qqmail.utilities.qmnetwork;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;

public class PhoneState
{
  private static final boolean DBG = false;
  public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
  private static final int[] RSRP_THRESH_LENIENT = { -140, -128, -118, -108, -98, -44 };
  private static final int[] RSRP_THRESH_STRICT;
  public static final int SIGNAL_STRENGTH_GOOD = 3;
  public static final int SIGNAL_STRENGTH_GREAT = 4;
  public static final int SIGNAL_STRENGTH_MODERATE = 2;
  public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
  public static final int SIGNAL_STRENGTH_POOR = 1;
  private static String TAG = "PhoneState";
  private static HandlerThread phoneStateThread = new HandlerThread("PhoneStateThread");
  private static int sLevel = 0;
  private static PhoneStateListener sPhoneListener = null;
  
  static
  {
    RSRP_THRESH_STRICT = new int[] { -140, -115, -105, -95, -85, -44 };
  }
  
  private static int getCdmaLevel(int paramInt)
  {
    if (paramInt >= -75) {
      return 4;
    }
    if (paramInt >= -85) {
      return 3;
    }
    if (paramInt >= -95) {
      return 2;
    }
    if (paramInt >= -100) {
      return 1;
    }
    return 0;
  }
  
  public static int getCellNetworkLevel()
  {
    return sLevel;
  }
  
  public static int getGsmLevel(int paramInt)
  {
    int i = 2;
    if ((paramInt <= 2) || (paramInt == 99)) {
      i = 0;
    }
    do
    {
      return i;
      if (paramInt >= 12) {
        return 4;
      }
      if (paramInt >= 8) {
        return 3;
      }
    } while (paramInt >= 5);
    return 1;
  }
  
  private static int getLteLevel(int paramInt)
  {
    int i = 4;
    int[] arrayOfInt = RSRP_THRESH_LENIENT;
    if (paramInt > arrayOfInt[5]) {
      i = -1;
    }
    while (paramInt >= arrayOfInt[4]) {
      return i;
    }
    if (paramInt >= arrayOfInt[3]) {
      return 3;
    }
    if (paramInt >= arrayOfInt[2]) {
      return 2;
    }
    if (paramInt >= arrayOfInt[1]) {
      return 1;
    }
    if (paramInt >= arrayOfInt[0]) {
      return 0;
    }
    return 0;
  }
  
  public static void listenPhoneState()
  {
    try
    {
      if (sPhoneListener == null)
      {
        phoneStateThread.start();
        new PhoneState.1(phoneStateThread.getLooper()).sendEmptyMessage(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void log(String paramString)
  {
    Log.d(TAG, paramString);
  }
  
  static class QMPhoneStateListener
    extends PhoneStateListener
  {
    private int caculateLevel(TelephonyManager paramTelephonyManager, SignalStrength paramSignalStrength)
    {
      int i = paramSignalStrength.getGsmSignalStrength();
      if (isGsm(paramTelephonyManager))
      {
        if (paramTelephonyManager.getNetworkType() == 13) {
          return PhoneState.getLteLevel(getLteDbm(paramSignalStrength));
        }
        return PhoneState.getGsmLevel(i);
      }
      return PhoneState.getCdmaLevel(i * 2 - 113);
    }
    
    private void caculateLevel(SignalStrength paramSignalStrength)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)QMApplicationContext.sharedInstance().getSystemService("phone");
      int i = localTelephonyManager.getPhoneType();
      if ((QMNetworkUtils.getActiveNetworkType() == QMNetworkUtils.NetworkType.WIFI) || (i == 0)) {
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (PermissionUtils.hasReadPhoneStatePermission(QMApplicationContext.sharedInstance())))
      {
        PhoneState.access$102(paramSignalStrength.getLevel());
        return;
      }
      PhoneState.access$102(caculateLevel(localTelephonyManager, paramSignalStrength));
    }
    
    private int getLteDbm(SignalStrength paramSignalStrength)
    {
      if (paramSignalStrength != null) {
        try
        {
          Field localField = SignalStrength.class.getDeclaredField("mLteRsrp");
          localField.setAccessible(true);
          int i = ((Integer)localField.get(paramSignalStrength)).intValue();
          return i;
        }
        catch (Exception paramSignalStrength)
        {
          QMLog.log(5, PhoneState.TAG, "getLteDbm failed", paramSignalStrength);
        }
      }
      return -2147483648;
    }
    
    private boolean isGsm(TelephonyManager paramTelephonyManager)
    {
      int i = paramTelephonyManager.getPhoneType();
      return (i == 16) || (i == 1) || (i == 2);
    }
    
    public void onCellLocationChanged(CellLocation paramCellLocation) {}
    
    public void onServiceStateChanged(ServiceState paramServiceState)
    {
      super.onServiceStateChanged(paramServiceState);
    }
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      try
      {
        caculateLevel(paramSignalStrength);
        super.onSignalStrengthsChanged(paramSignalStrength);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.log(5, PhoneState.TAG, "onSignalStrengthsChanged", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.PhoneState
 * JD-Core Version:    0.7.0.1
 */