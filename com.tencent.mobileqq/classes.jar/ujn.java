import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class ujn
  implements Handler.Callback
{
  private static final bmgv<ujn, Void> jdField_a_of_type_Bmgv = new ujo();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static ujn a()
  {
    return (ujn)jdField_a_of_type_Bmgv.b(null);
  }
  
  private static void c(uju paramuju)
  {
    if ((paramuju == null) || (paramuju.jdField_a_of_type_Ujr == null) || (TextUtils.isEmpty(paramuju.jdField_a_of_type_Ujr.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramuju.jdField_a_of_type_Ujr.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramuju.b != 0))
        {
          upe.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramuju.b + " msg=" + paramuju.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramuju.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramuju)
      {
        upe.d("weishi-BusinessLooper", "reportRequest Exception:" + paramuju.getLocalizedMessage());
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
  
  public void a(uju paramuju)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramuju;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(uju paramuju)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramuju;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      upe.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    uju localuju;
    do
    {
      do
      {
        return false;
        localuju = (uju)paramMessage.obj;
      } while (localuju == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localuju.jdField_a_of_type_Ujr != null) {}
      for (paramMessage = localuju.jdField_a_of_type_Ujr.getCmdString();; paramMessage = "mRequest is null")
      {
        upe.a("weishi-BusinessLooper", paramMessage);
        localuju.a();
        break;
      }
      localuju = (uju)paramMessage.obj;
    } while (localuju == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localuju.b).append(", cmd=");
    if (localuju.jdField_a_of_type_Ujr != null) {}
    for (paramMessage = localuju.jdField_a_of_type_Ujr.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        upe.c("weishi-BusinessLooper", paramMessage);
        if (localuju.jdField_a_of_type_Ujj == null) {
          break;
        }
        try
        {
          c(localuju);
          localuju.jdField_a_of_type_Ujj.a(localuju);
        }
        catch (Exception paramMessage)
        {
          upe.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */