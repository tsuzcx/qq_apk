import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.util.LocationReportUtil.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;

public class aiur
{
  private static long abU;
  private static long abV;
  private static boolean clO = true;
  private static volatile boolean clP;
  private static boolean clQ;
  private static Handler db = new Handler(ThreadManager.getSubThreadLooper());
  private static int dfj = 0;
  private static Runnable gU;
  
  public static int a(QQAppInterface paramQQAppInterface, LocationRoom.b paramb)
  {
    if (paramb == null) {}
    do
    {
      do
      {
        return 0;
        paramQQAppInterface = aiqs.a(paramQQAppInterface).a(paramb);
      } while (paramQQAppInterface == null);
      if (paramQQAppInterface.a() == null) {
        return 1;
      }
      if (paramQQAppInterface.FT() == -1) {
        return 2;
      }
    } while (paramQQAppInterface.FT() == -1);
    return 3;
  }
  
  private static void arg()
  {
    db.removeCallbacks(gU);
    db.removeCallbacksAndMessages(null);
    gU = null;
    clP = true;
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "stopHandler: invoked. ", " updateLocationBgReportSpRunnable: ", gU });
    }
  }
  
  public static void duF()
  {
    if ((clO) && (dfj != 0))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localQQAppInterface = (QQAppInterface)localObject;
        localHashMap = new HashMap();
        if (!clQ) {
          break label131;
        }
        localObject = "1";
        localHashMap.put("sProcBgLocationIsReporting", localObject);
        if (!clQ) {
          break label137;
        }
        anpc.a(BaseApplication.getContext()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "actLocationBgReportSampling", true, dfj, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("LocationReportUtil", 2, new Object[] { "reportWhenFirstTimeOnAppForeground: invoked. ", " map: ", localHashMap, " sProcBgAliveTimeSecond: ", Integer.valueOf(dfj) });
        }
      }
    }
    label131:
    label137:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        HashMap localHashMap;
        return;
        Object localObject = "0";
        continue;
        if (kk(1000)) {
          anpc.a(BaseApplication.getContext()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "actLocationBgReportSampling", true, dfj, 0L, localHashMap, "");
        }
      }
    }
    QLog.d("LocationReportUtil", 2, new Object[] { "report: invoked. no need report", " isFirstTimeOnAppForeground: ", Boolean.valueOf(clO), " sProcBgAliveTimeSecond: ", Integer.valueOf(dfj) });
  }
  
  public static void duG()
  {
    abV = System.currentTimeMillis();
  }
  
  public static void duH()
  {
    long l = (System.currentTimeMillis() - abV) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "reportFloatWindowLastExposeDuration: invoked. ", " second: ", Long.valueOf(l) });
    }
    anot.a(null, "CliOper", "", "", "0X800A976", "0X800A976", 0, 0, String.valueOf(l), "0", "0", "");
  }
  
  public static boolean kk(int paramInt)
  {
    return new Random(System.currentTimeMillis()).nextInt(paramInt) == 0;
  }
  
  public static void onAppBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, "onAppBackground: invoked. ");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (TextUtils.isEmpty(localAppRuntime.getAccount()))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationReportUtil", 2, new Object[] { "onAppBackground: invoked. app account null", " rt: ", localAppRuntime });
      }
    }
    do
    {
      return;
      clO = false;
      abU = System.currentTimeMillis() / 1000L;
    } while (!(localAppRuntime instanceof QQAppInterface));
    boolean bool = aiqs.a((QQAppInterface)localAppRuntime).a.apC();
    if (gU == null) {
      gU = new LocationReportUtil.1(bool);
    }
    clP = false;
    db.post(gU);
  }
  
  public static void onAppForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, "onAppForeground: invoked. ");
    }
    arg();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (clO)
    {
      dfj = aqmj.br(localBaseApplicationImpl);
      clQ = aqmj.cc(localBaseApplicationImpl);
      if (QLog.isColorLevel()) {
        QLog.d("LocationReportUtil", 2, new Object[] { "onAppForeground: invoked. ", " sProcBgAliveTimeSecond: ", Integer.valueOf(dfj), " sProcBgLocationIsReporting: ", Boolean.valueOf(clQ) });
      }
    }
    aqmj.a(localBaseApplicationImpl, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiur
 * JD-Core Version:    0.7.0.1
 */