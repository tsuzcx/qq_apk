import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler.1;

public class awou
{
  private static awou.a a = new awou.a(Looper.getMainLooper());
  private static volatile String cRT;
  private static volatile int eCi;
  private static volatile int eCj;
  private static volatile int sErrorCode;
  private static volatile String sFriendUin;
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    String str2;
    String str1;
    if (!TextUtils.isEmpty(paramString3))
    {
      str2 = "";
      str1 = "";
      if (paramInt2 != 1127) {
        break label55;
      }
      str2 = paramQQAppInterface.getApp().getString(2131695174);
      str1 = awph.cz(paramQQAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
      if (!TextUtils.isEmpty(str2)) {
        break label181;
      }
    }
    label55:
    do
    {
      return;
      if (paramInt2 == 22000)
      {
        str2 = paramQQAppInterface.getApp().getString(2131695174);
        str1 = awph.cz(paramQQAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
        break;
      }
      if (paramInt2 == 1053)
      {
        str2 = paramQQAppInterface.getApp().getString(2131695177);
        str1 = awph.cy(paramQQAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        break;
      }
      if (paramInt2 == 22081)
      {
        str2 = paramQQAppInterface.getApp().getString(2131695176);
        str1 = awph.cy(paramQQAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        break;
      }
      if (paramInt2 != 22121) {
        break;
      }
      str2 = paramQQAppInterface.getApp().getString(2131695175);
      str1 = awph.Hl();
      break;
      paramInt2 = paramString3.indexOf(str2);
    } while (paramInt2 == -1);
    label181:
    new Thread(new ResponseHandler.1(paramString1, paramString2, paramString3, paramInt1, str1, paramInt2, str2, paramQQAppInterface)).start();
  }
  
  /* Error */
  public static boolean aNn()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	awou:eCi	I
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +10 -> 18
    //   11: iconst_1
    //   12: istore_1
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_1
    //   20: goto -7 -> 13
    //   23: astore_2
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	i	int
    //   12	8	1	bool	boolean
    //   23	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static boolean aNo()
  {
    return nS(sErrorCode);
  }
  
  public static void ah(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      sFriendUin = paramString1;
      cRT = paramString2;
      eCj = paramInt;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static String bR(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 101	awou:sErrorCode	I
    //   6: sipush 1127
    //   9: if_icmpne +15 -> 24
    //   12: aload_0
    //   13: ldc 123
    //   15: invokevirtual 126	android/content/Context:getString	(I)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 101	awou:sErrorCode	I
    //   27: sipush 22000
    //   30: if_icmpne +13 -> 43
    //   33: aload_0
    //   34: ldc 123
    //   36: invokevirtual 126	android/content/Context:getString	(I)Ljava/lang/String;
    //   39: astore_0
    //   40: goto -21 -> 19
    //   43: getstatic 101	awou:sErrorCode	I
    //   46: sipush 1053
    //   49: if_icmpeq +12 -> 61
    //   52: getstatic 101	awou:sErrorCode	I
    //   55: sipush -20001
    //   58: if_icmpne +13 -> 71
    //   61: aload_0
    //   62: ldc 127
    //   64: invokevirtual 126	android/content/Context:getString	(I)Ljava/lang/String;
    //   67: astore_0
    //   68: goto -49 -> 19
    //   71: getstatic 101	awou:sErrorCode	I
    //   74: sipush 22081
    //   77: if_icmpne +13 -> 90
    //   80: aload_0
    //   81: ldc 128
    //   83: invokevirtual 126	android/content/Context:getString	(I)Ljava/lang/String;
    //   86: astore_0
    //   87: goto -68 -> 19
    //   90: getstatic 101	awou:sErrorCode	I
    //   93: sipush 22121
    //   96: if_icmpne +13 -> 109
    //   99: aload_0
    //   100: ldc 129
    //   102: invokevirtual 126	android/content/Context:getString	(I)Ljava/lang/String;
    //   105: astore_0
    //   106: goto -87 -> 19
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -92 -> 19
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	19	114	finally
    //   24	40	114	finally
    //   43	61	114	finally
    //   61	68	114	finally
    //   71	87	114	finally
    //   90	106	114	finally
  }
  
  public static void eEJ()
  {
    try
    {
      eCi += 1;
      QLog.d("ResponseHandler", 2, "start count=" + eCi);
      a.removeMessages(0);
      a.sendEmptyMessageDelayed(0, 60000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void eZ(QQAppInterface paramQQAppInterface)
  {
    try
    {
      QLog.d("ResponseHandler", 2, "sFriendUin =" + sFriendUin + ";  sSenderUin=" + cRT);
      if ((!TextUtils.isEmpty(sFriendUin)) && (!TextUtils.isEmpty(cRT))) {
        fa(paramQQAppInterface);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private static void fa(QQAppInterface paramQQAppInterface)
  {
    Message localMessage = a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramQQAppInterface;
    a.sendMessageDelayed(localMessage, 1000L);
  }
  
  public static boolean nP(int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((nS(paramInt)) && (!nQ(sErrorCode))) {
          sErrorCode = paramInt;
        }
        if (eCi == 0)
        {
          a.removeMessages(0);
          return bool;
        }
        eCi -= 1;
        QLog.d("ResponseHandler", 2, "end count=" + eCi);
        if (eCi <= 0)
        {
          a.removeMessages(0);
          eCi = 0;
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public static boolean nQ(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081) || (paramInt == 22121) || (sErrorCode == -20001);
  }
  
  public static boolean nR(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  public static boolean nS(int paramInt)
  {
    return (!TextUtils.isEmpty(sFriendUin)) && (!TextUtils.isEmpty(cRT)) && ((nR(paramInt)) || (nQ(paramInt)));
  }
  
  static void reset()
  {
    sFriendUin = null;
    cRT = null;
    eCj = 0;
    sErrorCode = 0;
  }
  
  static class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 0) {
        awou.access$002(0);
      }
      while ((paramMessage.what != 1) || (!awou.aNn()) || (TextUtils.isEmpty(awou.sFriendUin)) || (TextUtils.isEmpty(awou.cRT))) {
        return;
      }
      String str1 = awou.sFriendUin;
      String str2 = awou.cRT;
      int i = awou.eCj;
      int j = awou.sErrorCode;
      String str3 = awou.bR(BaseApplicationImpl.getApplication());
      Process.setThreadPriority(10);
      awou.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
      awou.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awou
 * JD-Core Version:    0.7.0.1
 */