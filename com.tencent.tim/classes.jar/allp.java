import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.1;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class allp
  implements Manager
{
  public QQAppInterface app;
  
  public allp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static boolean atN()
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    }
    if (awcr.a().aMk())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "checkNewImages cost:" + (System.currentTimeMillis() - l));
      }
      return true;
    }
    return false;
  }
  
  private SharedPreferences getSharedPreferences()
  {
    String str2 = "";
    String str1 = str2;
    if (this.app != null)
    {
      str1 = str2;
      if (this.app.getCurrentAccountUin() != null) {
        str1 = this.app.getCurrentAccountUin();
      }
    }
    str1 = str1 + "_QZoneAlbumRedTouch";
    return BaseApplication.getContext().getSharedPreferences(str1, 0);
  }
  
  public boolean atL()
  {
    long l2 = gz();
    if (l2 <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
      }
    }
    do
    {
      return false;
      long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadRedPointTimeInterval", 24) * 60 * 60 * 1000;
      l2 = System.currentTimeMillis() - l2;
      if ((l2 <= l1) && (l2 >= 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday true");
    }
    return true;
  }
  
  public boolean atM()
  {
    if (this.app == null) {
      return false;
    }
    Object localObject = (altq)this.app.getManager(36);
    if (localObject == null) {
      return false;
    }
    localObject = ((altq)localObject).getAppInfoByPath(String.valueOf(100180));
    return (localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1);
  }
  
  @TargetApi(9)
  public void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0) || (this.app == null)) {
      return;
    }
    QZoneClickReport.startReportImediately(this.app.getCurrentAccountUin(), "443", "1");
    ThreadManager.getSubThreadHandler().post(new QzoneAlbumRedTouchManager.2(this));
  }
  
  public void dGA()
  {
    if (this.app == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "setRedTouch");
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), allr.class);
    localNewIntent.putExtra("req", new operation_red_touch_req(1L));
    this.app.startServlet(localNewIntent);
  }
  
  public void dGB()
  {
    if (this.app == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "clearRedTouch");
    }
    ThreadManager.getSubThreadHandler().post(new QzoneAlbumRedTouchManager.1(this));
  }
  
  public void dGC()
  {
    if ((!awcr.aMm()) && (awcr.aMl()) && (awcr.aMn()))
    {
      LocalMultiProcConfig.putLong("key_photo_guide_last_check", System.currentTimeMillis());
      if (atM()) {
        break label65;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "not red");
      }
      if ((!atL()) && (atN())) {
        dGD();
      }
    }
    label65:
    while (atN()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "has Red but clear Red Touch");
    }
    dGB();
  }
  
  @TargetApi(9)
  public void dGD()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideSelectPhotoSendRedJumpToQzone", 0);
    SharedPreferences.Editor localEditor = getSharedPreferences().edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9) {
      localEditor.commit();
    }
    while ((i == 1) && (this.app != null) && (this.app.getApp() != null) && (alls.d(this.app.getApp(), 84)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "GetQZonePhotoGuideCheck supportJumpToQzone");
      }
      new alls(this.app, this).startService();
      return;
      localEditor.apply();
    }
    dGA();
  }
  
  public long gz()
  {
    return getSharedPreferences().getLong("key_photo_guide_has_red_date", 0L);
  }
  
  public void onDestroy()
  {
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allp
 * JD-Core Version:    0.7.0.1
 */