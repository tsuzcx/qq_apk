package btmsdkobf;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import tmsdk.common.roach.nest.ISharkCallBackNest;
import tmsdk.common.tcc.b;

public class bp
{
  public static final ec gn = new ec("r_entities_sp");
  
  public static void actionDataReport() {}
  
  public static void addTask(Runnable paramRunnable, String paramString)
  {
    ee.cT().addTask(paramRunnable, paramString);
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static Context getAppContext()
  {
    return bc.n();
  }
  
  public static String getGuid()
  {
    return bx.ar().getGuid();
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    return gn.getInt(paramString, paramInt);
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    return gn.getLong(paramString, paramLong);
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    return gn.getString(paramString1, paramString2);
  }
  
  public static void putInt(String paramString, int paramInt)
  {
    gn.putInt(paramString, paramInt);
  }
  
  public static void putLong(String paramString, long paramLong)
  {
    gn.putLong(paramString, paramLong);
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    gn.putString(paramString1, paramString2);
  }
  
  public static void remove(String paramString)
  {
    gn.remove(paramString);
  }
  
  public static void saveActionData(int paramInt)
  {
    try
    {
      be.saveActionData(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void saveStringData(int paramInt, String paramString)
  {
    try
    {
      be.SaveStringData(paramInt, paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static boolean sendShark(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ISharkCallBackNest paramISharkCallBackNest, long paramLong)
  {
    if ((paramJceStruct1 == null) || (paramISharkCallBackNest == null)) {
      return false;
    }
    try
    {
      bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new fg(paramISharkCallBackNest), paramLong);
      return true;
    }
    catch (Throwable paramJceStruct1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bp
 * JD-Core Version:    0.7.0.1
 */