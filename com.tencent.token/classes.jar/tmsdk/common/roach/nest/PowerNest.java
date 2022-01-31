package tmsdk.common.roach.nest;

import android.content.Context;
import btmsdkobf.bp;
import com.qq.taf.jce.JceStruct;

public class PowerNest
{
  public static final int CALLBACK_RUN_ON_THREAD = 0;
  public static final int CALLBACK_RUN_ON_UI = 8;
  public static final int S_ERR_NONE = 0;
  public static final int sNestVersion = 202;
  
  public static void actionDataReport() {}
  
  public static void addTask(Runnable paramRunnable, String paramString)
  {
    bp.addTask(paramRunnable, paramString);
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return bp.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return bp.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static Context getAppContext()
  {
    return bp.getAppContext();
  }
  
  public static String getGuid()
  {
    return bp.getGuid();
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    return bp.getInt(paramString, paramInt);
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    return bp.getLong(paramString, paramLong);
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    return bp.getString(paramString1, paramString2);
  }
  
  public static void putInt(String paramString, int paramInt)
  {
    bp.putInt(paramString, paramInt);
  }
  
  public static void putLong(String paramString, long paramLong)
  {
    bp.putLong(paramString, paramLong);
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    bp.putString(paramString1, paramString2);
  }
  
  public static void remove(String paramString)
  {
    bp.remove(paramString);
  }
  
  public static void saveActionData(int paramInt)
  {
    bp.saveActionData(paramInt);
  }
  
  public static void saveStringData(int paramInt, String paramString)
  {
    bp.saveStringData(paramInt, paramString);
  }
  
  public static boolean sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackNest paramISharkCallBackNest, long paramLong)
  {
    return bp.sendShark(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramISharkCallBackNest, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.roach.nest.PowerNest
 * JD-Core Version:    0.7.0.1
 */