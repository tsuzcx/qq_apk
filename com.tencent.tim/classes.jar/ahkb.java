import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahkb
  extends BroadcastReceiver
{
  ahkb(ahjz paramahjz, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ahjz.a(this.this$0) == null) || (ahjz.a(this.this$0).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    ahjz.a(this.this$0);
    ahjz.a(this.this$0).removeMessages(93);
    ahjz.a(this.this$0).removeMessages(94);
    paramContext = ((ahlc)ahjz.a(this.this$0).app.getManager(350)).r(this.bKJ);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    ahjz.a(this.this$0, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */