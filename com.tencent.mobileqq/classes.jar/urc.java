import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;

public class urc
  implements Handler.Callback
{
  private static final Singleton<urc, Void> jdField_a_of_type_CooperationQzoneStatisticSingleton = new urd();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static urc a()
  {
    return (urc)jdField_a_of_type_CooperationQzoneStatisticSingleton.get(null);
  }
  
  private static void c(urj paramurj)
  {
    if ((paramurj == null) || (paramurj.jdField_a_of_type_Urg == null) || (TextUtils.isEmpty(paramurj.jdField_a_of_type_Urg.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramurj.jdField_a_of_type_Urg.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramurj.b != 0))
        {
          uya.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramurj.b + " msg=" + paramurj.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramurj.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramurj)
      {
        uya.d("weishi-BusinessLooper", "reportRequest Exception:" + paramurj.getLocalizedMessage());
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(urj paramurj)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramurj;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(urj paramurj)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramurj;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      uya.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    urj localurj;
    do
    {
      do
      {
        return false;
        localurj = (urj)paramMessage.obj;
      } while (localurj == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localurj.jdField_a_of_type_Urg != null) {}
      for (paramMessage = localurj.jdField_a_of_type_Urg.getCmdString();; paramMessage = "mRequest is null")
      {
        uya.a("weishi-BusinessLooper", paramMessage);
        localurj.a();
        break;
      }
      localurj = (urj)paramMessage.obj;
    } while (localurj == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localurj.b).append(", cmd=");
    if (localurj.jdField_a_of_type_Urg != null) {}
    for (paramMessage = localurj.jdField_a_of_type_Urg.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        uya.c("weishi-BusinessLooper", paramMessage);
        if (localurj.jdField_a_of_type_Uqy == null) {
          break;
        }
        try
        {
          c(localurj);
          localurj.jdField_a_of_type_Uqy.a(localurj);
        }
        catch (Exception paramMessage)
        {
          uya.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */