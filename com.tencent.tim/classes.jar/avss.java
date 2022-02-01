import GIFT_MALL_PROTOCOL.DouFuInfo;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.birthdaynotice.BirthDayNoticeManager.1;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class avss
{
  private static avss.a a = new avss.a();
  
  private static JSONObject a(DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("friendUin", paramDouFuInfo.uin);
      localJSONObject.put("background", paramDouFuInfo.background);
      localJSONObject.put("time", paramDouFuInfo.birthday);
      localJSONObject.put("blessing", paramDouFuInfo.blessing);
      localJSONObject.put("link", paramDouFuInfo.doufu_link);
      localJSONObject.put("icon", paramDouFuInfo.icon);
      return localJSONObject;
    }
    catch (Exception paramDouFuInfo)
    {
      QLog.e("BirthDayNoticeManager", 1, "error convert to json " + paramDouFuInfo);
      MonitorManager.a().d(19, 4, "convert to json error " + paramDouFuInfo, false);
    }
    return localJSONObject;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = a(paramDouFuInfo);
    long l = FeedsManager.getToken(String.valueOf(paramDouFuInfo.uin));
    ThreadManager.getSubThreadHandler().post(new BirthDayNoticeManager.1(paramDouFuInfo, paramQQAppInterface, localJSONObject, l));
  }
  
  public static boolean ai(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (ajnn.a(paramQQAppInterface, paramString, 5L, false) != null) {}
    while ((ajnn.a(paramQQAppInterface, paramString, 12L, false) != null) || (ajnn.a(paramQQAppInterface, paramString, false) != null)) {
      return true;
    }
    return false;
  }
  
  public static void q(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.aTl;
    Set localSet = paramQQAppInterface.a().F();
    long l1;
    long l3;
    if ((localSet != null) && (localSet.contains(str)) && (ai(paramQQAppInterface, paramSessionInfo.aTl)))
    {
      l1 = paramQQAppInterface.a().gR();
      l3 = System.currentTimeMillis() / 1000L;
      if (l3 - l1 >= 86400L)
      {
        QLog.i("BirthDayNoticeManager", 2, "requestBirthDayNotice ");
        paramSessionInfo = new NewIntent(BaseApplicationImpl.getApplication(), anea.class);
        l1 = 0L;
      }
    }
    try
    {
      long l2 = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeManager", 1, "get uin error " + localException);
      }
    }
    paramSessionInfo.putExtra("selfuin", l1);
    a.mAppRef = new WeakReference(paramQQAppInterface);
    paramQQAppInterface.registObserver(a);
    paramQQAppInterface.startServlet(paramSessionInfo);
    paramQQAppInterface.a().lk(l3);
  }
  
  static class a
    extends akln
  {
    public WeakReference<QQAppInterface> mAppRef;
    
    protected void R(boolean paramBoolean, Bundle paramBundle)
    {
      if (this.mAppRef == null) {
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData appRef==null");
        }
      }
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.mAppRef.get();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData app == null ");
      return;
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof doufu_piece_rsp)))
      {
        paramBundle = ((doufu_piece_rsp)paramBundle).doufu.iterator();
        while (paramBundle.hasNext()) {
          avss.b(localQQAppInterface, (DouFuInfo)paramBundle.next());
        }
      }
      localQQAppInterface.unRegistObserver(avss.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avss
 * JD-Core Version:    0.7.0.1
 */