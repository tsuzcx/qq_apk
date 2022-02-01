import UserGrowth.stLinkStragegyArgs;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.1;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.2;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class opa
{
  public static stLinkStragegyArgs a()
  {
    stLinkStragegyArgs localstLinkStragegyArgs = new stLinkStragegyArgs();
    localstLinkStragegyArgs.hasInstalledWeish = rpw.isWeishiInstalled(BaseApplicationImpl.getApplication().getApplicationContext());
    localstLinkStragegyArgs.todayClickCount = rG();
    localstLinkStragegyArgs.todayEnterCount = rF();
    localstLinkStragegyArgs.todayLastLinkId = rH();
    return localstLinkStragegyArgs;
  }
  
  public static void bfX()
  {
    cb(lE(), lF());
  }
  
  public static void bfY()
  {
    cb(lG(), lH());
  }
  
  private static void cb(String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.2(paramString1, paramString2));
  }
  
  private static boolean d(String paramString1, String paramString2, int paramInt)
  {
    long l = LocalMultiProcConfig.getLong("weishi_usergrowth", paramString2, 0L);
    boolean bool = awce.g(System.currentTimeMillis(), l);
    if (!bool) {
      ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.3(paramString1, paramInt, paramString2));
    }
    return bool;
  }
  
  private static String lE()
  {
    return "key_open_recommend_page_count_" + lK();
  }
  
  private static String lF()
  {
    return "key_open_recommend_page_time_" + lK();
  }
  
  private static String lG()
  {
    return "key_click_recommend_card_count_" + lK();
  }
  
  private static String lH()
  {
    return "key_click_recommend_card_time_" + lK();
  }
  
  private static String lI()
  {
    return "key_last_link_type_" + lK();
  }
  
  private static String lJ()
  {
    return "key_last_link_time_" + lK();
  }
  
  private static String lK()
  {
    String str2 = "";
    String str3 = DeviceUtils.getVersionName(BaseApplicationImpl.getContext());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str1 = str2;
    if (localAppRuntime != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(localAppRuntime.getAccount())) {
        str1 = arwu.toMD5(localAppRuntime.getAccount());
      }
    }
    return str1 + "_" + str3;
  }
  
  private static int rF()
  {
    if (!d(lE(), lF(), 0)) {
      return 0;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", lE(), 0);
  }
  
  private static int rG()
  {
    if (!d(lG(), lH(), 0)) {
      return 0;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", lG(), 0);
  }
  
  private static int rH()
  {
    if (!d(lI(), lJ(), -1)) {
      return -1;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", lI(), -1);
  }
  
  public static void uQ(int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.1(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opa
 * JD-Core Version:    0.7.0.1
 */