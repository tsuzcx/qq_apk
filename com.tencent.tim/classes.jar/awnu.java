import NS_MOBILE_COMM_CONF.MobileCommConf;
import NS_MOBILE_COMM_CONF.NewMobileGlobalConf;
import NS_MOBILE_COMM_CONF.NewMobileUserConf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class awnu
{
  private static awnu a;
  private long ib = -1L;
  
  public static awnu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awnu();
      }
      return a;
    }
    finally {}
  }
  
  public static void nT(long paramLong)
  {
    if (paramLong > 0L)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_report", 0).edit();
      localEditor.putLong("lastReportTime", paramLong);
      localEditor.apply();
    }
  }
  
  public void a(MobileCommConf paramMobileCommConf)
  {
    if ((paramMobileCommConf == null) || (paramMobileCommConf.new_mobile_global_conf == null) || (paramMobileCommConf.new_mobile_user_conf == null) || (paramMobileCommConf.vecAppList == null) || (paramMobileCommConf.maxScanNum <= 0)) {}
    long l;
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          return;
          l = paramMobileCommConf.new_mobile_global_conf.version;
        } while (paramMobileCommConf.new_mobile_user_conf.version < l);
        if (QLog.isColorLevel()) {
          QLog.d("YYBInstallPackageManager", 1, "invokeReport");
        }
        l = System.currentTimeMillis() / 1000L;
      } while (((this.ib >= paramMobileCommConf.new_mobile_user_conf.uBeginTime) && (this.ib <= paramMobileCommConf.new_mobile_user_conf.uEndTime)) || (l < paramMobileCommConf.new_mobile_user_conf.uBeginTime) || (l > paramMobileCommConf.new_mobile_user_conf.uEndTime));
      localArrayList = new ArrayList();
      Iterator localIterator = paramMobileCommConf.vecAppList.iterator();
      do
      {
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (ausc.bb(BaseApplicationImpl.getApplication(), str));
        localArrayList.add(str);
      } while (localArrayList.size() < paramMobileCommConf.maxScanNum);
    } while (localArrayList.size() <= 0);
    this.ib = l;
    nT(this.ib);
    paramMobileCommConf = new NewIntent(BaseApplicationImpl.getApplication(), awnw.class);
    try
    {
      l = Long.parseLong(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
      paramMobileCommConf.putExtra("selfuin", l);
      paramMobileCommConf.putStringArrayListExtra("uninstall_app_list", localArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMobileCommConf);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("YYBInstallPackageManager", 1, "get uin error " + localException);
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnu
 * JD-Core Version:    0.7.0.1
 */