import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class oks
  implements Handler.Callback
{
  private static String reportCmds;
  private static final awau<oks, Void> sSingleton = new okt();
  public Handler mHandler;
  
  public static oks a()
  {
    return (oks)sSingleton.get(null);
  }
  
  private static void d(okz paramokz)
  {
    if ((paramokz == null) || (paramokz.jdField_a_of_type_Okw == null) || (TextUtils.isEmpty(paramokz.jdField_a_of_type_Okw.getRequestCmd()))) {}
    for (;;)
    {
      return;
      try
      {
        if (reportCmds == null) {
          reportCmds = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramokz.jdField_a_of_type_Okw.getRequestCmd();
        if ((reportCmds.contains(str)) && (paramokz.mResultCode != 0))
        {
          ooz.e("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramokz.mResultCode + " msg=" + paramokz.msg + " duration=" + (System.currentTimeMillis() - paramokz.timestamp));
          return;
        }
      }
      catch (Exception paramokz)
      {
        ooz.e("weishi-BusinessLooper", "reportRequest Exception:" + paramokz.getLocalizedMessage());
      }
    }
  }
  
  public void I(Runnable paramRunnable)
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.mHandler.post(paramRunnable);
  }
  
  public void b(okz paramokz)
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramokz;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void c(okz paramokz)
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramokz;
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      ooz.e("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    okz localokz;
    do
    {
      do
      {
        return false;
        localokz = (okz)paramMessage.obj;
      } while (localokz == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localokz.jdField_a_of_type_Okw != null) {}
      for (paramMessage = localokz.jdField_a_of_type_Okw.getCmdString();; paramMessage = "mRequest is null")
      {
        ooz.i("weishi-BusinessLooper", paramMessage);
        localokz.run();
        break;
      }
      localokz = (okz)paramMessage.obj;
    } while (localokz == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localokz.mResultCode).append(", cmd=");
    if (localokz.jdField_a_of_type_Okw != null) {}
    for (paramMessage = localokz.jdField_a_of_type_Okw.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        ooz.w("weishi-BusinessLooper", paramMessage);
        if (localokz.jdField_a_of_type_Oko == null) {
          break;
        }
        try
        {
          d(localokz);
          localokz.jdField_a_of_type_Oko.a(localokz);
        }
        catch (Exception paramMessage)
        {
          ooz.e("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.mHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oks
 * JD-Core Version:    0.7.0.1
 */