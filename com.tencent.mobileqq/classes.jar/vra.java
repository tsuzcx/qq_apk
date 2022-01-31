import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class vra
{
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private vrd jdField_a_of_type_Vrd;
  private boolean jdField_a_of_type_Boolean;
  
  public vra(Context paramContext, vrd paramvrd, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vrb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Vrd = paramvrd;
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
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698318));
      return;
    }
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "Net not Support");
      }
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698323));
      return;
    }
    if (bbev.b(this.jdField_a_of_type_AndroidContentContext)) {
      a(7, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698322));
    }
    ((QIMMusicConfigManager)bjae.a(2)).a(paramString, this.jdField_a_of_type_Boolean, new vrc(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vra
 * JD-Core Version:    0.7.0.1
 */