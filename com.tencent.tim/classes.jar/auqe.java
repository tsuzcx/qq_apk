import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.vendorpush.VendorPushHelper.1;
import java.util.HashMap;

public class auqe
{
  private static String cIM;
  private static String cIN;
  private static String cIO = "";
  public static int erT = 1;
  public static int erU = 2;
  private static int erV = -1;
  private static int erW;
  private static int erX = 1;
  private static int erY = 2;
  private static int erZ = 3;
  private static int esa = 4;
  private static int esb = 5;
  private static int esc;
  
  static
  {
    cIM = "vendorType";
    cIN = "otherPushType";
    esc = erV;
  }
  
  private static void VY(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(cIM, String.valueOf(esc));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "tpush_vendor_supported", paramBoolean, 0L, 0L, localHashMap, "", false);
  }
  
  public static boolean aJy()
  {
    if (esc == erV)
    {
      esc = erW;
      if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
        esc = erX;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TPush", 2, new Object[] { "isSupportVendorPush:", Integer.valueOf(esc) });
      }
    }
    return esc > erW;
  }
  
  private static void d(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(cIM, String.valueOf(esc));
    localHashMap.put("param_FailCode", paramString1);
    localHashMap.put(cIN, paramString2);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "tpush_init_result", paramBoolean, paramLong, 0L, localHashMap, "", false);
  }
  
  public static void ewf()
  {
    boolean bool = aJy();
    VY(bool);
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.d("TPush", 2, "Mobile Not Suppport!");
      }
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(cIO)) {
          break;
        }
        ewg();
      } while (!QLog.isColorLevel());
      QLog.d("TPush", 2, "already get PushToken");
      return;
    } while ("0".equals(aciu.rF()));
    ThreadManager.executeOnSubThread(new VendorPushHelper.1());
  }
  
  public static void ewg()
  {
    if (!TextUtils.isEmpty(cIO))
    {
      ((auqd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(184)).Zv(cIO);
      if (QLog.isColorLevel()) {
        QLog.d("TPush", 2, "TPush Token-By sendTokenToServer : ");
      }
    }
  }
  
  public static int getThirdPushType()
  {
    int i = erT;
    if (aJy()) {
      i = erU;
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "TPush pushType:" + i);
    }
    return i;
  }
  
  public static void gh(Context paramContext)
  {
    if (aJy()) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    }
  }
  
  public static void h(boolean paramBoolean, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(cIM, String.valueOf(esc));
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "tpush_settoken_result", paramBoolean, paramLong, 0L, localHashMap, "", false);
  }
  
  public static void i(boolean paramBoolean, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(cIM, String.valueOf(esc));
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "tpush_userswitch_result", paramBoolean, paramLong, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqe
 * JD-Core Version:    0.7.0.1
 */