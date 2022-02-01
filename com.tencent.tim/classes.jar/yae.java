import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class yae
  extends BroadcastReceiver
{
  yae(xzp paramxzp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.this$0.mGameRoomAVController.aqH();
    this.this$0.KF.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onBind enter room setSoundDisable");
    }
    this.this$0.mGameRoomAVController.setSoundEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yae
 * JD-Core Version:    0.7.0.1
 */