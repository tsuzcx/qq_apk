package cooperation.qzone.pfc.opencv;

import android.graphics.Bitmap;
import awby;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;

public class QzoneVision
{
  public static boolean Dd;
  
  static
  {
    qN();
  }
  
  public static native void getAntiShakeBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3);
  
  /* Error */
  public static boolean qN()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 23	cooperation/qzone/pfc/opencv/QzoneVision:qO	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +118 -> 126
    //   11: getstatic 29	awby:bg	Ljava/io/File;
    //   14: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: astore_1
    //   18: ldc 37
    //   20: iconst_1
    //   21: new 39	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   28: ldc 42
    //   30: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 48
    //   39: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 39	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 48
    //   61: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 63	java/lang/System:load	(Ljava/lang/String;)V
    //   70: ldc 37
    //   72: iconst_1
    //   73: new 39	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   80: ldc 65
    //   82: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 67
    //   91: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: new 39	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 67
    //   113: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 63	java/lang/System:load	(Ljava/lang/String;)V
    //   122: iconst_1
    //   123: putstatic 69	cooperation/qzone/pfc/opencv/QzoneVision:Dd	Z
    //   126: getstatic 69	cooperation/qzone/pfc/opencv/QzoneVision:Dd	Z
    //   129: istore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: iload_0
    //   134: ireturn
    //   135: astore_1
    //   136: ldc 37
    //   138: iconst_1
    //   139: ldc 71
    //   141: aload_1
    //   142: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_1
    //   146: invokevirtual 77	java/lang/Throwable:printStackTrace	()V
    //   149: iconst_0
    //   150: putstatic 69	cooperation/qzone/pfc/opencv/QzoneVision:Dd	Z
    //   153: goto -27 -> 126
    //   156: astore_1
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	128	0	bool	boolean
    //   17	91	1	str	String
    //   135	11	1	localThrowable	java.lang.Throwable
    //   156	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	126	135	java/lang/Throwable
    //   3	7	156	finally
    //   11	126	156	finally
    //   126	130	156	finally
    //   136	153	156	finally
  }
  
  public static boolean qO()
  {
    if (qP()) {
      return true;
    }
    awby.a().agA();
    return false;
  }
  
  public static boolean qP()
  {
    Object localObject = awby.bg.getAbsolutePath();
    localObject = new File((String)localObject + "/photoQulatitySo.zip");
    boolean bool = LocalMultiProcConfig.getBool(awby.cOK, true);
    if (!awby.a().T(awby.cOK, bool)) {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    do
    {
      return false;
      bool = LocalMultiProcConfig.getBool(awby.cOJ, true);
      if (awby.a().T(awby.cOJ, bool)) {
        break;
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.pfc.opencv.QzoneVision
 * JD-Core Version:    0.7.0.1
 */