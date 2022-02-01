import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BaseConstants.NetType;
import com.tencent.qphone.base.util.QLog;

public final class alil
  implements BaseConstants.NetType
{
  private static boolean cxj;
  private static boolean cxk = true;
  private static boolean cxl;
  private static int[] mF = new int[6];
  
  private static String A(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("StreamCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "getSavedStreamCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  private static String B(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("StreamSliceCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "getSavedStreamSliceCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void N(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((cxj) && (!paramBoolean)) {
      return;
    }
    cxj = true;
    for (;;)
    {
      try
      {
        paramQQAppInterface = A(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("StreamParams", 2, "initSupportCfg :" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          int i = paramQQAppInterface.length();
          if (i != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StreamParams", 2, "init params: " + cxk);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 1)) {
        cxk = "1".equals(paramQQAppInterface[0]);
      }
    }
  }
  
  public static void O(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((cxl) && (!paramBoolean)) {}
    for (;;)
    {
      return;
      cxl = true;
      try
      {
        paramQQAppInterface = B(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("StreamParams", 2, "initSliceCfg: " + paramQQAppInterface);
        }
        if (paramQQAppInterface == null) {
          continue;
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        int i = 0;
        while (i < paramQQAppInterface.length)
        {
          if (paramQQAppInterface[i].startsWith("1-"))
          {
            String[] arrayOfString = paramQQAppInterface[i].split("-");
            int j = Integer.parseInt(arrayOfString[1]);
            int k = Integer.parseInt(arrayOfString[2]);
            mF[j] = k;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (paramInt1 == 0)) {}
    do
    {
      return 800;
      O(paramQQAppInterface, false);
      paramQQAppInterface = mF;
      paramInt1 = i;
      if (paramInt2 >= 0)
      {
        paramInt1 = i;
        if (paramInt2 < paramQQAppInterface.length) {
          paramInt1 = paramQQAppInterface[paramInt2];
        }
      }
    } while (paramInt1 == 0);
    return paramInt1;
  }
  
  public static void ax(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putString("StreamCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "saveStreamCfg: " + paramString);
    }
  }
  
  public static void ay(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putString("StreamSliceCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("StreamParams", 2, "saveStreamSliceCfg: " + paramString);
    }
  }
  
  public static void release()
  {
    cxj = false;
    cxk = true;
    cxl = false;
    mF = new int[6];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */