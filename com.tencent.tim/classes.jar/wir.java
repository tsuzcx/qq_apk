import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wir
{
  public static boolean bcA;
  public static volatile boolean bcy;
  public static boolean bcz;
  private static boolean isInited;
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("sp_aio_input_helper_" + paramQQAppInterface.getAccount(), 0);
  }
  
  public static void bYo()
  {
    bcA = true;
    BaseApplication.getContext().getSharedPreferences("sp_upgrade", 0).edit().putBoolean("upgrade", true).commit();
  }
  
  @TargetApi(9)
  public static boolean w(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!isInited) {
      z(paramQQAppInterface);
    }
    if (bcy)
    {
      bcy = false;
      ThreadManager.getFileThreadHandler().post(new AIOInputTypeHelper.1(paramQQAppInterface));
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "inputhelper : need guide");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  /* Error */
  public static void z(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +11 -> 15
    //   7: getstatic 76	wir:isInited	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokestatic 114	wir:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Landroid/content/SharedPreferences;
    //   23: ldc 116
    //   25: iconst_1
    //   26: invokeinterface 120 3 0
    //   31: putstatic 82	wir:bcy	Z
    //   34: iconst_1
    //   35: putstatic 76	wir:isInited	Z
    //   38: goto -23 -> 15
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramQQAppInterface	QQAppInterface
    //   10	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	11	41	finally
    //   19	38	41	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wir
 * JD-Core Version:    0.7.0.1
 */