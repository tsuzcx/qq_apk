import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class zdj
{
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private zdm jdField_a_of_type_Zdm;
  private boolean jdField_a_of_type_Boolean;
  
  public zdj(Context paramContext, zdm paramzdm, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new zdk(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Zdm = paramzdm;
    paramContext = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    paramContext.addAction("action_music_start");
    paramContext.addAction("action_music_refresh_list");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "songMid not exist");
      }
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697517));
      return;
    }
    if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "Net not Support");
      }
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697522));
      return;
    }
    if (bgnt.b(this.jdField_a_of_type_AndroidContentContext)) {
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697521));
    }
    ((QIMMusicConfigManager)bojv.a(2)).a(paramString, this.jdField_a_of_type_Boolean, new zdl(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramObject);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdj
 * JD-Core Version:    0.7.0.1
 */