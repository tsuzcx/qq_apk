import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;

public class vfk
  implements Handler.Callback
{
  private static final Singleton<vfk, Void> jdField_a_of_type_CooperationQzoneStatisticSingleton = new vfl();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static vfk a()
  {
    return (vfk)jdField_a_of_type_CooperationQzoneStatisticSingleton.get(null);
  }
  
  private static void c(vfr paramvfr)
  {
    if ((paramvfr == null) || (paramvfr.jdField_a_of_type_Vfo == null) || (TextUtils.isEmpty(paramvfr.jdField_a_of_type_Vfo.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramvfr.jdField_a_of_type_Vfo.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramvfr.b != 0))
        {
          vmp.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramvfr.b + " msg=" + paramvfr.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramvfr.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramvfr)
      {
        vmp.d("weishi-BusinessLooper", "reportRequest Exception:" + paramvfr.getLocalizedMessage());
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
  
  public void a(vfr paramvfr)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramvfr;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(vfr paramvfr)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramvfr;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      vmp.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    vfr localvfr;
    do
    {
      do
      {
        return false;
        localvfr = (vfr)paramMessage.obj;
      } while (localvfr == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localvfr.jdField_a_of_type_Vfo != null) {}
      for (paramMessage = localvfr.jdField_a_of_type_Vfo.getCmdString();; paramMessage = "mRequest is null")
      {
        vmp.a("weishi-BusinessLooper", paramMessage);
        localvfr.a();
        break;
      }
      localvfr = (vfr)paramMessage.obj;
    } while (localvfr == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localvfr.b).append(", cmd=");
    if (localvfr.jdField_a_of_type_Vfo != null) {}
    for (paramMessage = localvfr.jdField_a_of_type_Vfo.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        vmp.c("weishi-BusinessLooper", paramMessage);
        if (localvfr.jdField_a_of_type_Vfg == null) {
          break;
        }
        try
        {
          c(localvfr);
          localvfr.jdField_a_of_type_Vfg.a(localvfr);
        }
        catch (Exception paramMessage)
        {
          vmp.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfk
 * JD-Core Version:    0.7.0.1
 */