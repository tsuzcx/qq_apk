package cooperation.qzone;

import android.content.Context;
import awcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;

public class SharpPDec
{
  private static String LIB_NAME;
  private static long aAm;
  private static int eyk = -1;
  private static int eyl;
  
  static
  {
    LIB_NAME = "TcHevcDec";
    eyl = -1;
    try
    {
      SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication(), "c++_shared");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("SharpPDec", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable);
    }
  }
  
  private native int GetVersion();
  
  public static int bD(Context paramContext)
  {
    int j = 0;
    int i = 1;
    String str = "";
    do
    {
      try
      {
        paramContext = awcs.getCurProcessName(paramContext);
        if (awcs.tK(paramContext))
        {
          QLog.i("SharpPDec", 1, "cooperation.SharpPDec:QzoneLive process,return 0.");
          i = j;
          return i;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.w("SharpPDec", 1, "isSupportSharpP: getCurProcessName failed");
          paramContext = str;
        }
      }
      finally {}
      j = getVersion();
    } while (j >= 12);
    for (;;)
    {
      i = 0;
    }
  }
  
  /* Error */
  public static int getVersion()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   6: bipush 12
    //   8: if_icmpge +18 -> 26
    //   11: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   14: getstatic 92	cooperation/qzone/SharpPDec:aAm	J
    //   17: lsub
    //   18: getstatic 23	cooperation/qzone/SharpPDec:eyl	I
    //   21: i2l
    //   22: lcmp
    //   23: ifge +12 -> 35
    //   26: getstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   29: istore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_0
    //   34: ireturn
    //   35: iconst_0
    //   36: putstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   39: invokestatic 96	cooperation/qzone/SharpPDec:loadLibrary	()Z
    //   42: ifne +66 -> 108
    //   45: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   48: putstatic 92	cooperation/qzone/SharpPDec:aAm	J
    //   51: getstatic 23	cooperation/qzone/SharpPDec:eyl	I
    //   54: iconst_m1
    //   55: if_icmpne +46 -> 101
    //   58: invokestatic 102	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   61: ldc 104
    //   63: ldc 106
    //   65: sipush 3000
    //   68: invokevirtual 110	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   71: putstatic 23	cooperation/qzone/SharpPDec:eyl	I
    //   74: ldc 39
    //   76: iconst_1
    //   77: new 112	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   84: ldc 115
    //   86: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 23	cooperation/qzone/SharpPDec:eyl	I
    //   92: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: getstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   104: istore_0
    //   105: goto -75 -> 30
    //   108: new 2	cooperation/qzone/SharpPDec
    //   111: dup
    //   112: invokespecial 127	cooperation/qzone/SharpPDec:<init>	()V
    //   115: invokespecial 129	cooperation/qzone/SharpPDec:GetVersion	()I
    //   118: putstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   121: ldc 39
    //   123: iconst_1
    //   124: new 112	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   131: ldc 131
    //   133: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: getstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   139: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: getstatic 17	cooperation/qzone/SharpPDec:eyk	I
    //   151: istore_0
    //   152: goto -122 -> 30
    //   155: astore_1
    //   156: ldc 39
    //   158: iconst_1
    //   159: aload_1
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   167: goto -19 -> 148
    //   170: astore_1
    //   171: ldc 2
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	123	0	i	int
    //   155	5	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   170	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	101	155	java/lang/UnsatisfiedLinkError
    //   101	105	155	java/lang/UnsatisfiedLinkError
    //   108	148	155	java/lang/UnsatisfiedLinkError
    //   3	26	170	finally
    //   26	30	170	finally
    //   35	101	170	finally
    //   101	105	170	finally
    //   108	148	170	finally
    //   148	152	170	finally
    //   156	167	170	finally
  }
  
  public static boolean loadLibrary()
  {
    label38:
    for (;;)
    {
      try
      {
        boolean bool = AVSoUtils.ayu();
        QLog.e("SharpPDec", 2, "load library exception:", localUnsatisfiedLinkError1);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          QLog.i("SharpPDec", 4, "cooperation.SharpPDec--load from qq original: load success ? " + bool);
          if (!bool) {}
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          break label38;
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.SharpPDec
 * JD-Core Version:    0.7.0.1
 */