package wf7;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;

public class ea
{
  private static Looper lA = null;
  private static Looper lB = null;
  private static Context lC;
  private static dt lD = null;
  private static boolean lE = false;
  private static String lF = null;
  private static boolean lG = false;
  private static boolean lH = false;
  private static eb lI = null;
  private static dp lJ = null;
  private static ds lK = null;
  private static dw lL = null;
  public static boolean ly = false;
  public static boolean lz = false;
  
  public static void a(dp paramdp)
  {
    lJ = paramdp;
    lK = paramdp.bU();
  }
  
  public static void a(dt paramdt)
  {
    lD = paramdt;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    try
    {
      paramArrayOfByte1 = lK.a(paramArrayOfByte1, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1) {}
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    try
    {
      paramArrayOfByte1 = lK.b(paramArrayOfByte1, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1) {}
    return null;
  }
  
  public static dw bV()
  {
    if (lL == null) {
      lL = lJ.bV();
    }
    return lL;
  }
  
  public static boolean bX()
  {
    return lG;
  }
  
  public static Context cr()
  {
    return lC;
  }
  
  public static dt cs()
  {
    return lD;
  }
  
  public static boolean ct()
  {
    return lE;
  }
  
  public static String cu()
  {
    return lF;
  }
  
  public static boolean cv()
  {
    return lH;
  }
  
  public static eb cw()
  {
    if (lI == null) {}
    try
    {
      if (lI == null) {
        lI = new ec(et.b(3, 8589934592L));
      }
      return lI;
    }
    finally {}
  }
  
  public static boolean f(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length == 1);
  }
  
  public static Looper getLooper()
  {
    if (lA == null) {}
    try
    {
      if (lA == null)
      {
        HandlerThread localHandlerThread = bV().newFreeHandlerThread("Shark-Looper", 0);
        localHandlerThread.start();
        lA = localHandlerThread.getLooper();
      }
      return lA;
    }
    finally {}
  }
  
  public static void h(Context paramContext)
  {
    lC = paramContext.getApplicationContext();
  }
  
  public static void q(boolean paramBoolean)
  {
    lE = paramBoolean;
  }
  
  public static void r(boolean paramBoolean)
  {
    lG = paramBoolean;
  }
  
  public static void s(boolean paramBoolean)
  {
    lH = paramBoolean;
  }
  
  public static void y(String paramString)
  {
    lF = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ea
 * JD-Core Version:    0.7.0.1
 */