import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

class acbq
  extends BroadcastReceiver
{
  acbq(acbp paramacbp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(acbp.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (acbp.a(this.a) != null)
      {
        paramContext = new Intent(acbp.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", acbn.blz);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", acbp.a(this.a).getString(2131691039));
        acbp.a(this.a).startActivity(paramContext);
        acbp.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(acbp.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbq
 * JD-Core Version:    0.7.0.1
 */