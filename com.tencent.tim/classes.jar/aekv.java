import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class aekv
  extends aehv<aeku>
{
  public static volatile int maxTopNum = -1;
  public static volatile int showFullScreen = -1;
  
  /* Error */
  public static int W(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 28	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: astore_0
    //   7: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 38	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   13: invokevirtual 43	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   16: astore_3
    //   17: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   20: ldc 45
    //   22: iconst_4
    //   23: invokevirtual 49	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: new 51	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   33: aload_3
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 58
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: iload_1
    //   50: invokestatic 65	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokeinterface 71 3 0
    //   58: invokestatic 77	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: iload_2
    //   63: istore_1
    //   64: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +37 -> 104
    //   70: ldc 85
    //   72: iconst_1
    //   73: new 51	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   80: ldc 87
    //   82: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 89
    //   91: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_1
    //   95: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload_1
    //   105: ireturn
    //   106: astore_3
    //   107: ldc 85
    //   109: iconst_1
    //   110: ldc 98
    //   112: aload_3
    //   113: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: goto -52 -> 64
    //   119: astore_3
    //   120: goto -13 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   0	123	1	paramInt	int
    //   61	2	2	i	int
    //   4	30	3	str	String
    //   106	7	3	localException1	Exception
    //   119	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	106	java/lang/Exception
    //   7	62	119	java/lang/Exception
  }
  
  public static aeku a()
  {
    return (aeku)aeif.a().o(425);
  }
  
  /* Error */
  public static String aT(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 28	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: astore_0
    //   7: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 38	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   13: invokevirtual 43	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   16: astore_2
    //   17: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   20: ldc 45
    //   22: iconst_4
    //   23: invokevirtual 49	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: new 51	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   33: aload_2
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 58
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: aload_1
    //   50: invokeinterface 71 3 0
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +37 -> 98
    //   64: ldc 85
    //   66: iconst_1
    //   67: new 51	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   74: ldc 87
    //   76: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 89
    //   85: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: ldc 85
    //   103: iconst_1
    //   104: ldc 98
    //   106: aload_2
    //   107: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: goto -52 -> 58
    //   113: astore_2
    //   114: goto -13 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString1	String
    //   0	117	1	paramString2	String
    //   4	53	2	str	String
    //   100	7	2	localException1	Exception
    //   113	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	100	java/lang/Exception
    //   7	56	113	java/lang/Exception
  }
  
  public static boolean agU()
  {
    boolean bool = false;
    aeku localaeku = a();
    if (localaeku != null) {
      bool = localaeku.agU();
    }
    return bool;
  }
  
  public static boolean agV()
  {
    boolean bool = true;
    aeku localaeku = a();
    if (localaeku != null) {
      bool = localaeku.agN();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "needShowMiniAppEntry: " + bool);
    }
    return bool;
  }
  
  public static boolean agW()
  {
    return W("miniappshowreddot", 0) == 1;
  }
  
  public static boolean agX()
  {
    return W("miniappshowmessagereddot", 0) == 1;
  }
  
  public static boolean agY()
  {
    return W("miniappfullscreenshownotificationbtn", 1) == 1;
  }
  
  public static boolean agZ()
  {
    if (W("miniappfullscreenshownotificationreddot", 1) == 1) {}
    for (int i = 1; (agY()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean aha()
  {
    return !ahb();
  }
  
  public static boolean ahb()
  {
    for (;;)
    {
      try
      {
        String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt(str + "_" + "miniappfullscreenshowsetting", 0);
        j = i;
        QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowSettingButton Exception.");
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. needShowSettingButton settingValue: " + i + "，uin: " + str);
            j = i;
          }
          QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowSettingButton, settingValue = " + j);
          if (j != 1) {
            break;
          }
          return true;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          break label129;
        }
        localException1 = localException1;
        i = 0;
      }
      label129:
      j = i;
    }
    return false;
  }
  
  public static int getMaxTopNum()
  {
    if (maxTopNum == -1)
    {
      maxTopNum = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
      QLog.d("MiniAppConfProcessor", 1, "[MiniAppUserAppInfoListManager].maxtopnum = " + maxTopNum);
    }
    return maxTopNum;
  }
  
  public static int hd(int paramInt)
  {
    paramInt = W("miniapptriggerfullscreenheight", paramInt);
    QLog.d("MiniAppConfProcessor", 2, "getTriggerFullScreenHeight, height = " + paramInt);
    return paramInt;
  }
  
  public static boolean needShowMiniAppFullScreen()
  {
    if (showFullScreen == -1) {}
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      showFullScreen = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt(str + "_" + "miniappshowfullscreen", 1);
      QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = " + showFullScreen);
      if (showFullScreen == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        showFullScreen = 1;
        QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
      }
    }
    return false;
  }
  
  public static String tl()
  {
    String str = "";
    aeku localaeku = a();
    if (localaeku != null) {
      str = localaeku.tl();
    }
    return str;
  }
  
  public static String ts()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
  }
  
  public static String tt()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationNickName", "小程序通知");
  }
  
  public static String tu()
  {
    String str2 = "QQ小程序";
    String str1 = str2;
    try
    {
      String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      str1 = str2;
      str2 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(str3 + "_" + "miniappfullscreentitle", "QQ小程序");
      str1 = str2;
      if (QLog.isColorLevel())
      {
        str1 = str2;
        QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. desktopTitleConfig title: " + str2 + "，uin: " + str3);
      }
      return str2;
    }
    catch (Exception localException)
    {
      QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. desktopTitleConfig Exception");
    }
    return str1;
  }
  
  @NonNull
  public aeku a(int paramInt)
  {
    return new aeku();
  }
  
  public void a(aeku paramaeku)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "onUpdate " + paramaeku.toString());
    }
    paramaeku = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaeku instanceof QQAppInterface))
    {
      paramaeku = (MiniAppEntryHandler)((QQAppInterface)paramaeku).getBusinessHandler(149);
      if (paramaeku != null) {
        paramaeku.notifyUI(0, true, null);
      }
    }
  }
  
  @Nullable
  public aeku b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      new aeku();
      return aeku.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeku> clazz()
  {
    return aeku.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 425;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekv
 * JD-Core Version:    0.7.0.1
 */