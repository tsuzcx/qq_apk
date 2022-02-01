import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class alsb
  implements Manager
{
  private static int MAX_RETRY_COUNT = -1;
  private static int dwL = -1;
  private static int dwM = -1;
  private static int dwN = -1;
  private long ahF;
  private QQAppInterface app;
  private String attachInfo;
  private int currentStatus = 0;
  private int dwO;
  private int dwP;
  private ArrayList<Long> yP;
  
  public alsb(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void F(ArrayList<Long> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramInt >= paramArrayList.size()))
    {
      close();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAllInner(" + paramInt + ")...");
    }
    int j = HX() + paramInt;
    int i = j;
    if (j >= paramArrayList.size()) {
      i = paramArrayList.size();
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), alsd.class);
    paramArrayList = new ArrayList(paramArrayList.subList(paramInt, i));
    alse.a(localNewIntent, alse.a(1, Long.valueOf(this.app.getCurrentAccountUin()).longValue(), paramArrayList, 0L, null));
    this.app.startServlet(localNewIntent);
  }
  
  private static int HX()
  {
    if (dwL < 0) {
      dwL = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsUinNum", 100);
    }
    return dwL;
  }
  
  private static int HY()
  {
    if (MAX_RETRY_COUNT < 0) {
      MAX_RETRY_COUNT = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsRetryNum", 2);
    }
    return MAX_RETRY_COUNT;
  }
  
  private static int HZ()
  {
    if (dwM < 0)
    {
      dwM = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinTimeCell", 900);
      dwM *= 1000;
    }
    return dwM;
  }
  
  private static int Ia()
  {
    if (dwN < 0)
    {
      dwN = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinRefreshTimeCell", 604800);
      dwN *= 1000;
    }
    return dwN;
  }
  
  @TargetApi(9)
  private void aE(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    localEditor.putLong("last_request_time", paramLong);
    localEditor.putString("last_attach_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private SharedPreferences getSharedPreferences()
  {
    String str = SecurityUtil.encrypt(this.app.getCurrentAccountUin()) + "GetQZoneFeeds";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  public void a(newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (paramnewest_feeds_rsp == null) {}
    while ((this.currentStatus == 3) || (((this.currentStatus != 1) || (this.dwO != 0)) && (this.currentStatus != 2))) {
      return;
    }
    aE(paramnewest_feeds_rsp.last_feed_time, paramnewest_feeds_rsp.str_attach);
  }
  
  public void aD(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateAll(" + this.currentStatus + ")...");
    }
    if (this.currentStatus != 0) {
      return;
    }
    this.currentStatus = 2;
    this.ahF = paramLong;
    this.attachInfo = paramString;
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), alsd.class);
    alse.a(localNewIntent, alse.a(2, Long.valueOf(this.app.getCurrentAccountUin()).longValue(), null, paramLong, paramString));
    this.app.startServlet(localNewIntent);
  }
  
  public void acz()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAll(" + this.currentStatus + ")...");
    }
    if (this.currentStatus != 0) {
      return;
    }
    this.currentStatus = 1;
    this.dwO = 0;
    this.yP = alse.h(this.app);
    if (QLog.isColorLevel())
    {
      acff localacff = (acff)this.app.getManager(51);
      if (this.yP != null) {
        i = this.yP.size();
      }
      QLog.d("QzoneContactsFeedManager", 2, new Object[] { "allFriends.size:", Integer.valueOf(i), ",getAllFreindsCount:", Integer.valueOf(localacff.As()) });
    }
    F(this.yP, this.dwO);
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "close...");
    }
    this.currentStatus = 0;
    this.yP = null;
    this.dwO = 0;
    this.dwP = 0;
  }
  
  public void dIP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "retry(" + this.dwP + ")...");
    }
    this.dwP += 1;
    if (this.dwP >= HY())
    {
      this.dwP = 0;
      if (this.currentStatus == 1) {
        aE(0L, null);
      }
      dIQ();
      return;
    }
    if ((this.currentStatus == 1) || (this.currentStatus == 3))
    {
      F(this.yP, this.dwO);
      return;
    }
    if (this.currentStatus == 2)
    {
      this.currentStatus = 0;
      aD(this.ahF, this.attachInfo);
      return;
    }
    close();
  }
  
  public void dIQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "doNextRequest(" + this.dwO + ")...");
    }
    if ((this.currentStatus != 1) && (this.currentStatus != 3))
    {
      close();
      return;
    }
    this.dwO += HX();
    F(this.yP, this.dwO);
  }
  
  public long gF()
  {
    return getSharedPreferences().getLong("last_request_time", 0L);
  }
  
  public void kN(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateFriend(" + this.currentStatus + ")...");
    }
    if (this.currentStatus != 0) {
      return;
    }
    this.currentStatus = 3;
    this.dwO = 0;
    this.yP = new ArrayList(1);
    this.yP.add(Long.valueOf(paramLong));
    F(this.yP, this.dwO);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "onDestroy...");
    }
    close();
    GetQZoneFeeds.bJM = false;
  }
  
  @TargetApi(9)
  public void updateQzoneFeeds()
  {
    if (!GetQZoneFeeds.bJM) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedManager", 2, "GetQZoneFeeds 此step尚未执行，此次调用就此返回，等待自动机中GetQZoneFeeds执行此方法");
      }
    }
    while (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QzoneContactsFeedManager.1(this));
  }
  
  public String yv()
  {
    return getSharedPreferences().getString("last_attach_info", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsb
 * JD-Core Version:    0.7.0.1
 */