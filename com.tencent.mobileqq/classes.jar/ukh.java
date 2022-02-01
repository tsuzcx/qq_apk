import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class ukh
  implements Handler.Callback
{
  private static final bnhx<ukh, Void> jdField_a_of_type_Bnhx = new uki();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static ukh a()
  {
    return (ukh)jdField_a_of_type_Bnhx.b(null);
  }
  
  private static void c(uko paramuko)
  {
    if ((paramuko == null) || (paramuko.jdField_a_of_type_Ukl == null) || (TextUtils.isEmpty(paramuko.jdField_a_of_type_Ukl.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramuko.jdField_a_of_type_Ukl.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramuko.b != 0))
        {
          uqf.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramuko.b + " msg=" + paramuko.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramuko.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramuko)
      {
        uqf.d("weishi-BusinessLooper", "reportRequest Exception:" + paramuko.getLocalizedMessage());
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
  
  public void a(uko paramuko)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramuko;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(uko paramuko)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramuko;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      uqf.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    uko localuko;
    do
    {
      do
      {
        return false;
        localuko = (uko)paramMessage.obj;
      } while (localuko == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localuko.jdField_a_of_type_Ukl != null) {}
      for (paramMessage = localuko.jdField_a_of_type_Ukl.getCmdString();; paramMessage = "mRequest is null")
      {
        uqf.a("weishi-BusinessLooper", paramMessage);
        localuko.a();
        break;
      }
      localuko = (uko)paramMessage.obj;
    } while (localuko == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localuko.b).append(", cmd=");
    if (localuko.jdField_a_of_type_Ukl != null) {}
    for (paramMessage = localuko.jdField_a_of_type_Ukl.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        uqf.c("weishi-BusinessLooper", paramMessage);
        if (localuko.jdField_a_of_type_Ukd == null) {
          break;
        }
        try
        {
          c(localuko);
          localuko.jdField_a_of_type_Ukd.a(localuko);
        }
        catch (Exception paramMessage)
        {
          uqf.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukh
 * JD-Core Version:    0.7.0.1
 */