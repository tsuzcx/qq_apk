import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.23.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class vke
  extends accn
{
  public vke(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  protected void onGetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onGetCareBarEnable(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "onGetCareBarEnable: invoked.  barEnable: " + paramBoolean2);
    }
    NotifyPushSettingActivity.j(this.this$0).setChecked(paramBoolean2);
  }
  
  protected void onGetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingActivity.a(this.this$0).obtainMessage();
      localMessage.what = 10003;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingActivity.a(this.this$0).sendMessage(localMessage);
      QLog.i("CardObserver_onGetHelloLiveMessageState", 1, "Succeeded to Get hello live message State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetHelloLiveMessageState", 1, "Failed to Get  hello live message State with Msg");
  }
  
  protected void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingActivity.a(this.this$0).obtainMessage();
      localMessage.what = 10000;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingActivity.a(this.this$0).sendMessage(localMessage);
      QLog.i("CardObserver_onGetPCActiveState", 1, "Succeeded to Get PC Active State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetPCActiveState", 1, "Failed to Get PC Active State with Msg");
  }
  
  protected void onSetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onSetCareBarEnable(paramBoolean1, paramBoolean2);
  }
  
  protected void onSetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, null, "qqsetting_hello_live_message", paramBoolean2);
      QLog.i("CardObserver_onSetHelloLiveMessage", 1, "Set the hell live mesaage result " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingActivity.a(this.this$0).obtainMessage();
    localMessage.what = 10002;
    localMessage.obj = paramString2;
    NotifyPushSettingActivity.a(this.this$0).sendMessage(localMessage);
    QQToast.a(this.this$0, paramString1, 0).show(5);
    QLog.i("SetHelloLiveMessage_Failure", 1, "Failed to HelloLiveMessage State " + paramString1);
  }
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_notify_push_setting_activity".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "onSetNotDisturb NOT FROM THIS" + paramString2);
      }
    }
    do
    {
      return;
      NotifyPushSettingActivity.a(this.this$0).set(false);
      if (!paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().post(new NotifyPushSettingActivity.23.1(this, paramString1));
        return;
      }
      paramString1 = this.this$0.app.getHandler(Conversation.class);
    } while (paramString1 == null);
    Conversation.a(paramString1, this.this$0);
  }
  
  protected void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, null, "qqsetting_pcactive_key", paramBoolean2);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingActivity.a(this.this$0).obtainMessage();
    localMessage.what = 10001;
    localMessage.obj = paramString2;
    NotifyPushSettingActivity.a(this.this$0).sendMessage(localMessage);
    QQToast.a(this.this$0, paramString1, 0).show(5);
    QLog.i("SetPCActiveState_Failure", 1, "Failed to set PC Active State " + paramString1);
  }
  
  protected void onSetShowPushNotice(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, null, "qqsetting_show_push_message", paramBoolean2);
      QLog.i("CardObserver_onSetShowPushNotice", 1, "Set show push notice");
      if (paramBoolean2) {}
      for (localObject = "0X8009520";; localObject = "0X800951F")
      {
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 1, "", "", "", "");
        return;
      }
    }
    Object localObject = NotifyPushSettingActivity.a(this.this$0).obtainMessage();
    ((Message)localObject).what = 10004;
    ((Message)localObject).obj = Boolean.valueOf(paramBoolean2);
    NotifyPushSettingActivity.a(this.this$0).sendMessage((Message)localObject);
    QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131719890), 0).show(5);
    QLog.i("onSetShowPushNotice_Failure", 1, "Failed to set push notice");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vke
 * JD-Core Version:    0.7.0.1
 */