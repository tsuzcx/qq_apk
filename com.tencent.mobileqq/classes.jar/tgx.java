import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class tgx
  implements Handler.Callback
{
  private static final bjsl<tgx, Void> jdField_a_of_type_Bjsl = new tgy();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static tgx a()
  {
    return (tgx)jdField_a_of_type_Bjsl.b(null);
  }
  
  private static void c(the paramthe)
  {
    if ((paramthe == null) || (paramthe.jdField_a_of_type_Thb == null) || (TextUtils.isEmpty(paramthe.jdField_a_of_type_Thb.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramthe.jdField_a_of_type_Thb.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramthe.b != 0))
        {
          tlo.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramthe.b + " msg=" + paramthe.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramthe.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramthe)
      {
        tlo.d("weishi-BusinessLooper", "reportRequest Exception:" + paramthe.getLocalizedMessage());
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
  
  public void a(the paramthe)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramthe;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(the paramthe)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramthe;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      tlo.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    the localthe;
    do
    {
      do
      {
        return false;
        localthe = (the)paramMessage.obj;
      } while (localthe == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localthe.jdField_a_of_type_Thb != null) {}
      for (paramMessage = localthe.jdField_a_of_type_Thb.getCmdString();; paramMessage = "mRequest is null")
      {
        tlo.a("weishi-BusinessLooper", paramMessage);
        localthe.a();
        break;
      }
      localthe = (the)paramMessage.obj;
    } while (localthe == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localthe.b).append(", cmd=");
    if (localthe.jdField_a_of_type_Thb != null) {}
    for (paramMessage = localthe.jdField_a_of_type_Thb.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        tlo.c("weishi-BusinessLooper", paramMessage);
        if (localthe.jdField_a_of_type_Tgt == null) {
          break;
        }
        try
        {
          c(localthe);
          localthe.jdField_a_of_type_Tgt.a(localthe);
        }
        catch (Exception paramMessage)
        {
          tlo.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgx
 * JD-Core Version:    0.7.0.1
 */