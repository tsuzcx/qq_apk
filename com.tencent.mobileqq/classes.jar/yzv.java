import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class yzv
  extends BroadcastReceiver
{
  public yzv(BabyQFriendStatusWebViewPlugin paramBabyQFriendStatusWebViewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(BabyQFriendStatusWebViewPlugin.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (BabyQFriendStatusWebViewPlugin.a(this.a) != null)
      {
        paramContext = new Intent(BabyQFriendStatusWebViewPlugin.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", AppConstants.au);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", BabyQFriendStatusWebViewPlugin.a(this.a).getString(2131433698));
        BabyQFriendStatusWebViewPlugin.a(this.a).startActivity(paramContext);
        BabyQFriendStatusWebViewPlugin.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(BabyQFriendStatusWebViewPlugin.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yzv
 * JD-Core Version:    0.7.0.1
 */